---
title:	Looping
description:	Loops provide an easy way to repeat a set of statements.
---
The `for` loop will  repeat a block of code whilst its condition is `true`:

```groovy
for (<condition>) {
	//statements
}
```

# The `for`-each Loop

The for-each loop basically says "for each element is this collection, perform the following":

```groovy
for (<var> in <iterator>) {
	//statements
}
```

>That wasn't a formatting error (`for`-each) - as, unlike `if-else` -  the for-each loop doesn't actually have a keyword `each`. 

In the Groovy for-each loop we have a variable (`var`) provided as the next item in the `iterator`[^iterator]. In most cases this is a collection of objects such as a list or map.

You can't change the iterator within a loop - it'd just be too confusing! That means code such as the following causes an exception and won't run:

```groovy
def scores = [4, 8, 2]

for (i in scores) {
    scores << i**2
}
```

[^iterator]: Many Groovy classes implement a feature (interface) named `Iterable` and these let you easily iterate over a collection of items. Lists and Maps are both iterable, making it very easy to loop through their contents.

## Using a range
Consider a variable called `countdown` to hold a range:

```groovy
def countdown = (10..0)
```

By itself, `countdown` probably doesn't seem too useful but let's look at a `for` loop:

```groovy
def countdown = (10..0)

for (i in countdown) {
    println "Launch in T-$i seconds"
}

println 'Blast off!'
```

So let's break down `for (i in countdown) {`:

* The `(...)` parentheses holds the condition
* The variable `i` will hold the next element in `countdown`
	* You can name this as you would any other variable
* The element to the right of the `in` reserved word is the variable being iterated (looped) over
* `{` starts the loop body 
	* and its matching `}` closes it

>`i` is commonly used to hold the value of each _**i**_teration

If you run this code in groovyConsole you'll see our launch sequence displayed. 

To make our code even more compact (yet readable), we can use the literal value for the range (`10..0`) in our `for` condition:

```groovy
for (i in 10..0) {
    println "Launch in T-$i seconds"
}
println 'Blast off!'
```

## Lists

Looping through the items in a list is quite straight forward now you've seen the range example:

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (planet in planets) {
    println planet
}
```

>Ranges work like Lists because, under the hood, ranges _are_ Lists! Consider `1..3` - it's actually a list of `[1, 2, 3]`

## Maps

Iterating through maps is much the same as we did for lists but the iteration variable consists of the key and the value for that map item. The next code segment will just display the value of each map item:

```groovy
def domains = [
    'com': 'Corporate sites',
    'org': 'Non-commercial sites',
    'mil': 'Military sites'    
]

for (site in domains) {
    println site
}
```

The code above will display a set of lines such as `com=Corporate sites` - illustrating that `site` contains a key/value pair.

Instead of printing out the iteration variable (`site`) we can be a little smarter and access the key (`site.key`) and value (`site.value`) individually:

```groovy
def domains = [
    'com': 'Corporate sites',
    'org': 'Non-commercial sites',
    'mil': 'Military sites'    
]

for (site in domains) {
    println site.key << ': ' << site.value
}
```

# The Java for-each

Groovy supports Java's version of a for-each loop:

```groovy
for (<Type> <var>: <iterator>) {
	//statements
}
```

Unlike Groovy's for-each loop, the Java version:

- uses `:` instead if `in`
- Requires you to declare a data type for the iteration variable
	- Which makes lists consisting of elements with different data types a little more tricky.

Re-writing the previous planets example in the Java for-each style we'd see the following:

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (String planet: planets) {
    println planet
}
```

The Java version has no real benefit over the Groovy approach so I'd stick with the Groovy `for (<var> in <iterator>)`. The Groovy approach also make for easier iteration of maps.

If you really want to set a data type for your iteration variable you can still be Groovy about it:

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars',
]

for (String planet in planets) {
    println planet
}
```

# A C-style `for` Loop
Java (and Groovy) both offer the `for` loop syntax found in the C programming language:

```groovy
for (<init variable>; <condition>; <update expression>) {
	//statements
}
```
 

* `<init variable>` initialises the loop variable before the first iteration
* `<condition>` sets the condition to be met for the iteration to commence
* `<update expression>` is evaluated after each iteration

This next example does the same as `for (i in (10..1))` but is more verbose:
 
```groovy
for (i = 10; i >= 0; i--) {
    println i
}
```

So what's happening in `(i = 10; i >= 0; i--)`?

* `i = 10` initialises the loop variable `i` to `10`
* `i >= 0` is the conditional that says "keep looping until `i` is no longer greater than or equal to 10"
* `i--` is evaluated after each iteration - `i` is decremented by 1.

The `<update expression>` can be a more complex expression:

```groovy
for (i = 0; i <= 20; i += 2) {
    println i
}
```


## Infinite loops
The C-style `for` loop can let you set up infinite loops:

```groovy
for (;;) {

}
```

These are often used in event-based systems. Essentially, the program will enter a loop and await incoming events such as a mouse-click. It's a very interesting aspect to coding but outside the scope of these tutorials.

>The term 'infinite' should set off an alarm in your head - be careful as this type of coding can cause your system to stop responding!

The C-style loop doesn't protect you from altering the thing you're working on and, perhaps inadvertently, creating an infinite loop. That means that the code below needs the safety break provided by (`&& i < 20`) as the loop keeps altering the size of `scores`. If you take out `&& i < 20` and run the code below it won't stop unless you interrupt it or you run out of system resources:

```groovy
def scores = [4, 8, 2]

for (i = 0; i < scores.size && i < 20; i++) {
    println scores[i]
    scores << scores[i]**2   
}
```

