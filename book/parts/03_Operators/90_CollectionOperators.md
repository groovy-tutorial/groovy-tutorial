---
title:	Collection operators
status:	in-progress
description:	
...

|Operator(s)     |Type
|:------------------:|:--------------------|  
| `<<`	| Append operator	|  
| `+`	| Addition operator	|  
| `-`	| Subtraction operator	|  
| `+=` `-=`	| Compound assignment operators	| 
| `in`	| Membership Operator	|  
| `*`	| Spread Operator	|  
| `*.`	| Spread-Dot Operator	|  
| `..`	| Range Operator	|  
| `[]`	| Subscript Operator	| 

I finish this chapter off with a little bit of mucking around with set theory.

# Membership Operator 

The `in` operator is used to determine if an item is "in" a list or is a key in a map.

```groovy
assert 6 in [1, 2, 6, 9]
assert !(3 in [1, 2, 6, 9])
```

```groovy
def grades = ['Maths': 'A',
    'English': 'C',
    'Science': 'B'].asImmutable()

assert 'Science' in grades
assert !('French' in grades)
```

# Append

The `<<` operator adds a new element to a list:

```groovy
def friends = ['Frank', 'Larry']
friends << 'Jane'
println friends
```

It's important to note that appending a list to a list will see the new element contain a list:

```groovy
def friends = ['Frank', 'Larry']
friends << ['Jane', 'Greg']
assert friends == ['Frank', 'Larry', ['Jane', 'Greg']]
```

In order to add the individual items of one list to another I need to use the `addAll()` method:

```groovy
def friends = ['Frank', 'Larry']
friends.addAll(['Jane', 'Greg'])
assert friends == ['Frank', 'Larry', 'Jane', 'Greg']
```

>Also check out the Spread operator

I can also use `<<` to append a new key:value pair to a list:

```groovy
def grades = [:]
grades << ['Maths': 'A']
grades << ['English': 'C']
grades << ['Science': 'B']
println grades
```

If I was to add `grades << ['Science': 'F']` to the code above, the value for `Science` would be changed to `F` as the map's keys are unique.

# Addition

The addition operator (`+`) returns a __*new*__ list with the right-hand operand added:

```groovy
def friends = ['Frank', 'Larry']
assert friends + 'Jane' == ['Frank', 'Larry', 'Jane']
```

>This is different to the append operation as the addition results in a new list whereas append adds to the existing list - we'll look into this when we get to compound assignment operators

When we add two lists together we get a union of the two lists returned:

```groovy
def friends = ['Frank', 'Larry']
assert friends + ['Jane', 'Greg'] == ['Frank', 'Larry', 'Jane', 'Greg']
```

>This is different to the `addAll()` method as a new list is returned rather than the items being added to the existing list.

Adding to a Set returns a set with the union sans any duplicates:

```groovy
def set = [2, 4, 6, 8] as Set
assert union + [8, 10] == [2, 4, 6, 8, 10] as Set
```

The addition operator will either add a key:value pair to a map of alter the value held against an existing key. In the example below I create a new map with a result for my French class and then create another map with a reduced English score:

```groovy
def grades = ['Maths': 'A',
    'English': 'C',
    'Science': 'B']

assert grades + ['French': 'F'] == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']
assert grades + ['English': 'D'] == ['Maths': 'A', 'English': 'D', 'Science': 'B']
```

# Subtraction

The subtraction (`-`) operator will return a __*new*__ list with an element removed _if_ the list contains the element:

```groovy
assert [2, 4, 6, 8] - 6 == [2, 4, 8]
```

A list can also be subtracted from a list, returning a new list containing items in the left-hand operand (`[2, 4, 6, 8]`) that are not in the right-hand operand (`[2, 6, 12]`):

```groovy
assert [2, 4, 6, 8] - [2, 6, 12] == [4, 8]
```

In the example below my attempt to remove `Gary` doesn't do anything as he's not in the list (this doesn't cause an exception) but I do succeed in un-friending `Frank`:

```groovy
def friends = ['Frank', 'Larry', 'Jane']
assert friends - 'Gary' == ['Frank', 'Larry', 'Jane']
assert friends - 'Frank' == ['Larry', 'Jane']
```

When subtraction is applied to a Map the right-hand operand needs to be a key:value pair. In the example below I attempt 3 things:

1. I attempt to remove `['English': 'D']` but it's not in `grades` so nothing happens
2. I attempt to remove `['French': 'F']` but it's not in `grades` so nothing happens
3. I attempt to remove `['English': 'C']` and __it is__ in `grades` so nothing happens

```groovy
def grades = ['Maths': 'A',
    'English': 'C',
    'Science': 'B']

assert grades - ['English': 'D'] == ['Maths': 'A', 'English': 'C', 'Science': 'B']
assert grades - ['French': 'F'] == ['Maths': 'A', 'English': 'C', 'Science': 'B']
assert grades - ['English': 'C'] == ['Maths': 'A', 'Science': 'B']
```

# Compound Assignment Operators

Just as we saw with numbers, the addition and subtraction operators returns a value but don't actually change the variable involved in the operation

```groovy
def grades = ['Maths': 'A',
    'English': 'C',
    'Science': 'B']

assert grades + ['French': 'F'] == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']
assert grades + ['English': 'D'] == ['Maths': 'A', 'English': 'D', 'Science': 'B']
assert grades == ['Maths': 'A', 'English': 'C', 'Science': 'B']
```

If I actually wanted to change the value of `grades` I would have needed to assign the resultant back into the variable as follows:

```groovy
grades = grades + ['French': 'F'] 
assert grades  == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']
```

This means I could also have written the previous example using the `+=` compound assignment:

```groovy
grades += ['French': 'F'] 
assert grades  == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']
```

Using the append operator in its compound form (`<<=`) is redundant.

## Immutability and Assignment

Consider the following code and see if you're surprised:

```groovy
def grades = ['Maths': 'A',
    'English': 'C',
    'Science': 'B'].asImmutable()

grades += ['French': 'F'] 
assert grades  == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']
```

Groovy let me change something that's immutable! I should go to the mailing list and report this! The outrage!

Hang on! What `asImmutable()` does is set the elements of the list to be unchangeable but it doesn't make the `grades` variable immutable. As the `+` operator actually returns a new list value, Groovy is correct in assigning that new value to `grades`. 

If I'd used `grades << ['French': 'F']` instead of grades += ['French': 'F'] I would get an `java.lang.UnsupportedOperationException` as I'm actually trying to add a new element to `grades`.

If I really want to make `grades` completely immutable (constant) then I'd need to use the `final` modifier and declare `grades` within a class. The code below demonstrates how I'd set up the class and then attempts to change `grades` and causes an exception.

```groovy
class Report {
    final grades = ['Maths': 'A',
        'English': 'C',
        'Science': 'B'].asImmutable()
}

def myReport = new Report()
myReport.grades += ['French': 'F'] 
```


# Spread Operator
Extracts each item in the collection

Helpful when you need to include a collection's individual items in another collection or when your collection can be used as parameters in a method call.

Example 1 - adding one collection's items to another collection

```groovy
def list = [1, 2, 6, 9]
def list2 = [*list, 12, 34]
//Result is list2 = [1, 2, 6, 9, 12, 34]
```

Example 2 - using the collection items as a parameter list

```groovy
def mean(num1, num2, num3) {
  (num1 + num2 + num3) / 3
}
def scores = [4, 8, 1]
mean(*scores)
```

## Multiply Operator

Note that you can use `*` as a form of multiplication involving lists but this doesn't return a list containing each element multiplied by the right-hand operand. Rather, the returned list just contains the original list elements repeated by the number of times set by the right-hand operand. In the example below I get `2, 4, 6` repeated 4 times:

```groovy
def list = [2, 4, 6]
println list * 4
```

# Spread-Dot Operator
The `*.` operator calls an action (method) on each item in the list and returns a new list containing the results. In the example below I call the `reverse()` method on each list element:

```groovy
println(['carrot', 'cabbage', 'cauliflower']*.reverse())
```

The spread operator mimics the `collect()` method - with the previous example being equivalent to the following:

```groovy
['carrot', 'cabbage', 'cauliflower'].collect{it?.reverse()}
```

The spread operator makes the call using the "Safe navigation Operator" (`?.`) to make sure that the list elements isn't null - refer to the Object Operators section for more information. In the next example I include a `null` in the list and the returned list features the `null`:

```groovy
println(['carrot', 'cabbage', null, 'cauliflower']*.reverse())
```

For maps I can't use `*.` so need to use the `collect()` method:

```groovy
grades = ['Maths': 'A',
        'English': 'C',
        'Science': 'B']

grades.collect{
    println it
    return it
}
```

# Range Operator

Creates a list of sequential values

Usually seen with numbers 

Can be used with classes implementing `java.lang.Comparable` and providing the `next()` and `previous()` methods

Example: `println 1..10` _(inclusive range)_
Example: `println 'a'..'k'` _(inclusive range)_
Example: `println 1..<99` _(half-open range)_
Example: Can be handy when dealing with `enums`:

```groovy
enum Priority {
    LOW,MEDIUM,HIGH,URGENT
}

def focus = Priority.HIGH..Priority.URGENT
```
	
# Subscript Operator

Allows you to address a position (location) in a collection instead of using the `get`/`getAt` and `put`/`putAt` methods

Groovy collections are zero-based - the first item in a list is at position 0 (zero)

Example: working with a list

```groovy
def scores = [5, 8, 2, 11]
assert scores[1] == 8
scores[3] = 18
assert scores[3] != 11
```

Example: working with a map

```groovy
def team = [captain: 'Bill', goalie: 'Jane', sub: 'Jim']

//The next two statements do the same thing
println team['goalie']
println team.goalie

// Change the sub
team['sub'] = 'Sally'
println team['sub']
```

# A Little Set Theory

Writing this chapter got me thinking about [set theory](https://en.wikipedia.org/wiki/Set_theory) and how various aspects can be achieved in Groovy lists.

## Membership

The `in` method gives us a membership check:

```groovy
assert 4 in [2, 4, 6, 8]
```

## Union

The addition operator provides us with the ability to performs unions:

```groovy
assert [2, 4, 6, 8] + [1, 3, 5, 7] == [2, 4, 6, 8, 1, 3, 5, 7]
```

## Complements

The subtraction operator (`-`) gives us set complement (difference):

```groovy
assert [2, 4, 6, 8] - [6, 8, 10] == [2, 4]
```

## Intersection

The `disjoint()` method will return `true` if two lists don't contain any intersecting elements:

```groovy
assert [2, 4, 6, 8].disjoint([1, 3, 5, 7]) == true
```

If `disjoint()` returns `false` then some elements intersect.

```groovy
def list1 = [2, 4, 6, 8]
def list2 = [6, 8, 10]

assert ([*list1, *list2] as Set) - (list1 - list2) - (list2 - list1) == [6, 8] as Set
```

## Guava Sets Library

All this got me thinking further and looking into Google's Guava libraries - here's some code that uses Guava to scratch my set itch:

```groovy
@Grab(group='com.google.guava', module='guava', version='18.0')
import static com.google.common.collect.Sets.*

def list1 = [2, 4, 6, 8] as Set
def list2 = [6, 8, 10] as Set

println "Intersection: " << intersection(list1, list2)
println "Union: " << union(list1, list2)
println "Difference (list1 - list2): " << difference(list1, list2)
println "Difference (list2 - list1): " << difference(list2, list1)

println "Cartesian product of list1 and list2"
for (set in cartesianProduct(list1, list2)) {
    println " - $set"
}

println "Powersets of list1: " 
for (set in powerSet(list1)) {
    println " - $set"
}
```