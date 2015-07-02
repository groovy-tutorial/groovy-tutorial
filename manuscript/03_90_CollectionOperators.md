# Collection operators

I> Working with Lists and Maps is made easier with these handy operators.

A number of operators are provided for working with Lists and Maps. Some overload operators such as `+` and `<<` whilst others (such as `in`) are more collection-oriented. Certain operators work with both Lists and Maps whilst others apply to only one.

|Operator(s)     |Type
|:------------------:|:--------------------|  
| `in`	| Membership Operator	|
| `<<`	| Append operator	|  
| `+`	| Addition operator	|  
| `-`	| Subtraction operator	|  
| `+=` `-=`	| Compound assignment operators	|   
| `*`	| Spread Operator	|  
| `*.`	| Spread-Dot Operator	|  
| `..`	| Range Operator	|  
| `[]`	| Subscript Operator	| 

This chapter won't discuss the following operators as they've been described earlier:

- The Range operator creates a list of sequential values and is usually seen with numbers. This is how we created Ranges in the tutorial on Variables.
- The Subscript operator is used to access items in a List or a Map and this was also discussed in the tutorial on Variables.

To finish this chapter off I'll do a little bit of mucking around with set theory.

## Membership Operator (Lists and Maps)

The `in` operator is used to determine if an item is "in" a list or is a key in a map.

{title="Using the `in` operator",lang=groovy}
	assert 6 in [1, 2, 6, 9]
	assert !(3 in [1, 2, 6, 9])



	def grades = ['Maths': 'A',
	    'English': 'C',
	    'Science': 'B'].asImmutable()
	
	assert 'Science' in grades
	assert !('French' in grades)


## Append (Lists and Maps)

The `<<` operator adds a new element to an existing list:


	def friends = ['Frank', 'Larry']
	friends << 'Jane'
	println friends


It's important to note that appending a list to a list will add a new element that contains the list in the right-hand operand:


	def friends = ['Frank', 'Larry']
	friends << ['Jane', 'Greg']
	assert friends == ['Frank', 'Larry', ['Jane', 'Greg']]


In order to add the individual items of one list to another I need to use the `addAll()` method:


	def friends = ['Frank', 'Larry']
	friends.addAll(['Jane', 'Greg'])
	assert friends == ['Frank', 'Larry', 'Jane', 'Greg']


T>Also check out the Spread operator

I can also use `<<` to append a new key:value pair to a map:


	def grades = [:]
	grades << ['Maths': 'A']
	grades << ['English': 'C']
	grades << ['Science': 'B']
	println grades


If I was to add another line `grades << ['Science': 'F']` to the code above, the value for `Science` would be changed to `F` as the map's keys are unique.

## Addition (Lists and Maps)

The addition operator (`+`) returns a __*new*__ list with the right-hand operand added:


	def friends = ['Frank', 'Larry']
	assert friends + 'Jane' == ['Frank', 'Larry', 'Jane']


T>This is different to the append operation as the addition results in a new list whereas append adds to the existing list - we'll look into this when we get to compound assignment operators

When we add two lists together we get a union of the two lists returned:


	def friends = ['Frank', 'Larry']
	assert friends + ['Jane', 'Greg'] == ['Frank', 'Larry', 'Jane', 'Greg']


T> This is different to the `addAll()` method as a new list is returned rather than the items being added to the existing list.

Adding to a Set returns a set with the union sans any duplicates:


	def set = [2, 4, 6, 8] as Set
	assert union + [8, 10] == [2, 4, 6, 8, 10] as Set


The addition operator will either add a key:value pair to a map or alter the value held against an existing key. In the example below I create a new map item with a result for my French class and then change an existing map item with a reduced English score:


	def grades = ['Maths': 'A',
	    'English': 'C',
	    'Science': 'B']
	
	assert grades + ['French': 'F'] == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']
	assert grades + ['English': 'D'] == ['Maths': 'A', 'English': 'D', 'Science': 'B']


## Subtraction (Lists and Maps)

The subtraction (`-`) operator will return a __*new*__ list with an element removed _if_ the list contains the element:


	assert [2, 4, 6, 8] - 6 == [2, 4, 8]


A list can also be subtracted from a list, returning a new list containing items in the left-hand operand (`[2, 4, 6, 8]`) that are not in the right-hand operand (`[2, 6, 12]`):


	assert [2, 4, 6, 8] - [2, 6, 12] == [4, 8]


In the example below my attempt to remove `Gary` doesn't do anything as he's not in the list (this doesn't cause an exception) but I do succeed in un-friending `Frank`:


	def friends = ['Frank', 'Larry', 'Jane']
	assert friends - 'Gary' == ['Frank', 'Larry', 'Jane']
	assert friends - 'Frank' == ['Larry', 'Jane']


When subtraction is applied to a Map the right-hand operand needs to be a key:value pair. In the example below I attempt 3 things:

1. I attempt to remove `['English': 'D']` but it's not in `grades` so nothing happens
2. I attempt to remove `['French': 'F']` but it's not in `grades` so nothing happens
3. I attempt to remove `['English': 'C']` and __it is__ in `grades` so the removal occurs.


{title="Subtracting from a map",lang=groovy}
	def grades = ['Maths': 'A',
	    'English': 'C',
	    'Science': 'B']
	
	assert grades - ['English': 'D'] == ['Maths': 'A', 'English': 'C', 'Science': 'B']
	assert grades - ['French': 'F'] == ['Maths': 'A', 'English': 'C', 'Science': 'B']
	assert grades - ['English': 'C'] == ['Maths': 'A', 'Science': 'B']


## Compound Assignment Operators (Lists and Maps)

Just as we saw with numbers, the addition and subtraction operators returns a value but don't actually change the variable involved in the operation. To change the value of `grades` I would have needed to assign the resultant back into the variable as follows:


	grades = grades + ['French': 'F'] 
	assert grades  == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']


If we want to use the `grades` variable as the left-hand operand and change its value we can use the compound assignment operators. This means I could also have written the previous example using the `+=` compound assignment:


	grades += ['French': 'F'] 
	assert grades  == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']


Using the append operator in its compound form (`<<=`) is redundant.

### Immutability and Assignment

Consider the following code and see if you're surprised:


	def grades = ['Maths': 'A',
	    'English': 'C',
	    'Science': 'B'].asImmutable()
	
	grades += ['French': 'F'] 
	assert grades  == ['Maths': 'A', 'English': 'C', 'Science': 'B', 'French': 'F']


Groovy let me change something that's immutable! I should go to the mailing list and report this! The outrage!

Hang on! What `asImmutable()` does is set the elements of the list to be unchangeable but it doesn't make the `grades` variable immutable. As the `+` operator actually returns a new list value, Groovy is correct in assigning that new value to `grades`. 

If I'd used `grades << ['French': 'F']` instead of grades += ['French': 'F'] I would get a `java.lang.UnsupportedOperationException` as I'm actually trying to add a new element to `grades`.

If I really want to make `grades` completely immutable (constant) then I'd need to use the `final` modifier and declare `grades` within a class. The code below demonstrates how I'd set up the class and ensure that attempts to change `grades` cause an exception:


	class Report {
	    final grades = ['Maths': 'A',
	        'English': 'C',
	        'Science': 'B'].asImmutable()
	}
	
	def myReport = new Report()
	myReport.grades += ['French': 'F'] 


Running the code above will earn you a `groovy.lang.ReadOnlyPropertyException`.

## Spread Operator (Lists)

The Spread operator extracts each element in the List into another list or a method's parameters. This is helpful when you need to include a list's individual items in another list or when your list can be used as parameters in a method call.

### Extracting Into Lists

In the first example, one lists's items are extracted into another list:


	def list = [1, 2, 6, 9]
	def list2 = [*list, 12, 34]
	assert list2 == [1, 2, 6, 9, 12, 34]


This usage looks rather like the `addAll()` method but you may need to be mindful as to the position in which the list is extracted. The example below uses `addAll()` but results in `list2` being ordered differently than in the previous example:


	def list = [1, 2, 6, 9]
	def list2 = [12, 34]
	list2.addAll(list)
	assert list2 == [12, 34, 1, 2, 6, 9]


In this last example I demonstrate an easy approach to creating a union of the two lists:


	def list = [1, 2, 6, 9]
	def list2 = [12, 34]
	assert [*list, *list2] == [1, 2, 6, 9, 12, 34]


### Extracting as Parameters

In the next example I extract the items in the `score` list out, each aligning with the parameters in the 


	def mean(num1, num2, num3) {
	  (num1 + num2 + num3) / 3
	}
	def scores = [4, 8, 3]
	assert mean(*scores) == 5


That last example is a little bit of a goldilocks moment - I have exactly the same number of items in the list as the method has parameters. I also have a pretty limited version of the `mean` method - it only works on 3 numbers. However, a method with a varargs parameter is a little less fairy tale:


	def mean(...nums) {
	  def total = 0
	  for (item in nums) {
	    total += item
	  }
	  return total / nums.size()
	}
	
	def scores = [4, 8, 3]
	assert mean(*scores) == 5


One last example of using the spread operator:


	def buyGroceries(...items) {
	    for (item in items) {
	        println item
	    }
	}
	
	def shoppingList = ['apples', 'cat food', 'cream']
	buyGroceries(*shoppingList)


>Realistically, the `items` parameter is a list but it proves the point. We'll look into this type of method parameter in the tutorial on methods.

### Multiply Operator

Note that you can use `*` as a form of multiplication involving lists but this doesn't return a list containing each element multiplied by the right-hand operand. Rather, the returned list just contains the original list elements repeated by the number of times set by the right-hand operand. In the example below I get `2, 4, 6` repeated 4 times:


	def list = [2, 4, 6]
	println list * 4


## Spread-Dot Operator (Lists)
The `*.` operator calls an action (method) on each item in the list and returns a new list containing the results. In the example below I call the `reverse()` method on each list element:


	println(['carrot', 'cabbage', 'cauliflower']*.reverse())


The spread operator mimics the `collect()` method - with the previous example being equivalent to the following:


	['carrot', 'cabbage', 'cauliflower'].collect{it?.reverse()}


The spread operator makes the method call using the "Safe navigation Operator" (`?.`) to make sure that the list element isn't null - refer to the Object Operators section for more information. In the next example I include a `null` in the list and the returned list features the `null`:


	println(['carrot', 'cabbage', null, 'cauliflower']*.reverse())


For maps I can't use `*.` so need to use the `collect()` method.

## A Little Set Theory

Writing this chapter got me thinking about [set theory](https://en.wikipedia.org/wiki/Set_theory) and how various aspects can be achieved in Groovy lists.

### Membership

The `in` method gives us a membership check:


	assert 4 in [2, 4, 6, 8]


### Union

The addition operator provides us with the ability to performs unions:


	assert [2, 4, 6, 8] + [1, 3, 5, 7] == [2, 4, 6, 8, 1, 3, 5, 7]


### Complements

The subtraction operator (`-`) gives us set complement (difference):


	assert [2, 4, 6, 8] - [6, 8, 10] == [2, 4]


### Intersection

The `disjoint()` method will return `true` if two lists don't contain any intersecting elements:


	assert [2, 4, 6, 8].disjoint([1, 3, 5, 7]) == true


If `disjoint()` returns `false` then some elements intersect.


	def list1 = [2, 4, 6, 8]
	def list2 = [6, 8, 10]
	
	assert ([*list1, *list2] as Set) - (list1 - list2) - (list2 - list1) == [6, 8] as Set


### Guava Sets Library

All this got me thinking further and looking into Google's Guava libraries - here's some code that uses Guava to scratch my set itch:

{title="Sip some guava",lang=groovy}
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
