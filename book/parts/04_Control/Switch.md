---
title:	
description:	
---

# Introduction

```groovy
switch (game) {
    case 'chess':
        println 'I like to play chess'
        break;
    case 'twister': 
        println 'I can play twister if you want'
        break;
    default:
        println "Sorry, I don't know how to play $game"
}
```

## Comparison with Java
The Groovy  `switch` statement is much more powerful than Java's and can work across all data types.

>In Java `switch` is limited to the primitive types (and their object wrappers), Strings, Enums and the 

This is achieved through the use of the `isCase` method defined for the `Object` class and overloaded by subclasses such as `Pattern`. Essentially, the switch expression is passed to the 

# Falling Through

```groovy
def score = 2

println 'You win: '

switch (score) {
    case 3: 
        println '- gift voucher'
     case 2:
        println '- toy'
    case 1:
        println '- stamp'
    default:
        println '- certificate'
}
```

# Using Ranges

```groovy
switch (hand) {
    case 1..16:
        println 'HIT'
        break
    case 17..21:
        println 'STAND'
        break
    default:
        println 'BUST'
        break
}
```

# Using Regular Expressions

Groovy extends the Java regular expression `Pattern` class to provide for their use in `switch` statements. This can be really handy if you want to test for a number of patterns.

```groovy
def location = ['urn:isbn:0451450523', 
                'http://en.wikipedia.org/wiki/Uniform_resource_locator',
                'HTTPS://secure.example.com/',
                'mailto:duncan@example.com',
                'fax:53454567567']

location.each {
    switch( it.toLowerCase() ) {
        case ~/^urn:.*/ :
            print 'This looks like a URN'
            break
        case ~/^https?:.*/ :
            print 'This looks like a HTTP(S) URL'
            break
        case ~/^mailto:.*/ :
            print 'This looks like an email address'
            break
        default:
            print 'Not sure what this is'
    }
    println " ($it)"
}
```

# Using Class Checks


Groovy's `case` can use a data type (Class) for comparison. Essentially, the switch will use the `instanceof` operator to compare the expression with a class name provided in the case. In the example below I iterate through a list containing elements of various types. I use the `switch` statement to then determine the type of each list item:

```groovy
def objList = [ 10, 
                'hello', 
                [1, 5, 8], 
                [name: 'Dave'],
                ~/\n/
              ]

for (item in objList) {
    switch (item) {
        case String:
            println 'You gave me a string'
            break
        case Number: 
            println 'You gave me a number'
            break
        case List:
            println 'You gave me a list'
            break
        case Map:
            println 'You gave me a map'
            break
        default:
            println "Sorry, I can't handle instances of ${item.class}"
    }
}
```
