---
title:	Return value
status:	draft
description:	Most methods are built to return an answer.
...

When we started this tutorial I provided a very basic method for calculating averages. I've rewritten it slightly to use varargs and this is a good starting point into using the `return` statement:

```groovy
println determineAverage(10, 20, 30, 40)

def determineAverage(... list) { 
    return list.sum() / list.size()
}
```

In the code above I `return` the average to the caller so, instead of printing out the result I could also assign it to a variable: `def avg = determineAverage(10, 20, 30, 40)`.

Using the `return` reserved word isn't required as Groovy will return the result of the last statement:

```groovy
println determineAverage(10, 20, 30, 40)

def determineAverage(... list) { 
    list.sum() / list.size()
}
```

You can use `return` to explicitly exit a method. By itself, `return` actually returns `null`. In the useless method I provide below, I explicitly provide `return`:

```groovy
def printer(message) {
    println message
    return
}

printer('hello, world')
```

That use of `return` in the last bit of code was redundant as the method would exit anyway (it had nothing left to do). However, this can be handy if the last expression to run in a method returns a value that _we don't want_ as the return value for our method.

Anything after a return is inaccessible, as illustrated by my even more useless method:

```groovy
def printer(message) {
    println message
    return
    println 'Help, I don\'t exist'
}
```

That last line in the method will never, ever, ever be called. __But__ if I really wanted it to be called I can use the `try-finally` approach:

```groovy
def printer(message) {
    try{
        println message
        return
    } finally {
        println 'Help, I don\'t exist'
    }
}
```

Now, that last bit of text will be displayed as it's in a `finally` block. This example is rather daft but it serves to illustrate how `finally` can be used to clean up something like an open file before the `return` is actioned.

# Multiple Returns

You can have more than one `return` expression in a method but only one will ever be evaluated. This is really handy as it localises the return and prevents the method from further evaluation. You can also place a `return` at the very end of the method block to ensure that the method always returns a value. In the code below I use two `return` statements in the `switch` but also have `return false` at the bottom of the method just in case something slips through (most likely when I add in code at a later date):

```groovy
def checkAnimalAsPet(animal) {
    switch(animal){
        case 'dog':
        case 'cat':
            return true
        default:
            return false   
    }
    return false
}

assert checkAnimalAsPet('cat') 
assert checkAnimalAsPet('dog')
assert checkAnimalAsPet('lion') == false
assert checkAnimalAsPet('pterodactyl') == false
```

You'll note that, in the `checkAnimalAsPet` method I have a `switch` with no breaks. Essentially, the `return` is breaking out of the switch and the method all at once.

# Declaring data types for return values

A data type can be declared for the return value by replacing `def` with the class name: `Number determineAverage(... list){..}`:

```groovy
println determineAverage(10, 20, 30, 40)

Number determineAverage(... list) { 
    return list.sum() / list.size()
}
```

This is very handy if your method is to be accessed as part of an API, especially by Java programs.