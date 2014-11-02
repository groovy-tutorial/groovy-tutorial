---
Title:	Looping
Description:	Loops provide an easy way to repeat a set of statements.
...

# The `for` Loop
<!-- TODO: link back to Range data type -->

The `for` loop will  repeat a block of code whilst its condition is `true`

```groovy
for (<condition>) {
	//statements
}
```

## Using a range
Earlier we created a variable called `countdown` to hold a range:

```groovy
def countdown = (10..0)
```

At the time I gave this example it probably didn't seem too useful but let's look at a `for` loop:

```groovy
def countdown = (10..0)

for (i in countdown) {
    println "Launch in T-$i seconds"
}
```

So let's break down `for (i in countdown) {`:

* The `(..)` parentheses holds the condition
* The variable `i` will hold the next element in `countdown`
	* You can name this as you would any other variable
* The element to the right of the `in` reserved word is the variable being iterated (looped) over
* `{` starts the loop body 
	* and its matching `}` closes it

>`i` is commonly used to hold the value of each 

If you run this code in groovyConsole you'll see our launch sequence displayed. 

To make our code even more compact (yet readable), we can use the literal value for the range (`10..0`) in our `for` condition:

```groovy
for (i in (10..0)) {
    println "Launch in T-$i seconds"
}
```

## Using an Iterator
Many Groovy classes implement a feature called `Iterable`[^iterable] and these let you easily iterate over a collection of items. Lists and Maps are both iterable, making it very easy to loop through their contents.

<!-- TODO: Add link to the Iterable section in classes -->
[^iterable]: `Iterable` is actually an interface and these are discussed further in ...

### Lists

Looping through the items in a list is quite straight forward:

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

### Maps



## An C-style `for` Loop
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

The `<update expression>` can be a more complex expression.

```groovy
for (i = 0; i <= 20; i += 2) {
    println i
}
```

# The `while` Loop

```groovy
def flag = false
def num = 0

while (!flag) {
    num++
    if (num**2 == 64) {
        flag = true
    }
}

println "The square root of 64 is $num"
```

# There is no `do...while` loop 

Unlike Java, Groovy does not have a `do...while` loop[^dowhile].

[^dowhile]: [A ticket](https://jira.codehaus.org/browse/GROOVY-5348) has been lodged to request one.

# Disrupting a Loop

## `break`
The `break` reserved word is used to exit out of a loop  - even if there are more iterations possible.

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (planet in planets) {
    println planet
    if (planet == 'Earth') {
        break
    }
}
```

## `continue`
The `continue` reserved word will cause the next iteration of the loop - ignoring anything within the rest of the current iteration.

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (planet in planets) {
    if (planet == 'Earth') {
        continue
    }
    println planet
}
```

# Closures and Loops
<!-- TODO: link to closures section -->
