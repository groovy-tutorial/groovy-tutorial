---
title:	The Basics  
status:	draft
description:	A basic overview of methods
...

Groovy, like Java, is object-oriented and works around classes. C and Pascal are procedural and work around functions. Whilst the methods described here may look a bit like C-style programming that lets you build libraries of functions, what is really happening is Groovy wraps your code in a `class` definition behind the scenes. You're only likely to create "raw" methods, like the ones below, as a means to break up your scripts. More usually you'll create methods within your classes.

Methods have a number of features:

1. Methods have names
	- this allows you to call your method in a meaningful way
2. Methods can accept parameters
	- these are inputs into your method that can affect how your method operates
3. Methods can return a result value 
	- this can be captured by a variable from the code calling the method
4. Methods have their own scope
	- they can have their own variables and not inadvertently affect the rest of your program

We've already looked at various methods for use with variables such as lists and maps so you've seen methods being called throughout the previous chapters.

Let's start by examining a new method we'll write to calculate the average of the numbers in a list:

```groovy
def determineAverage(list) {
    return list.sum() / list.size()
}
```

Breaking that code up we can see:

1. The `def` reserved word is used to commence the method declaration
	- Much like we use when defining a variable
1. `determineAverage` is the name of the method
1. The method accepts a single parameter, `list`
1. A single value is returned using the `return` reserved word
	- In this case it's the result of `list.sum() / list.size()`

The method name (`determineAverage`) may look a bit odd but it uses a naming strategy called ["lower Camel Case"](https://en.wikipedia.org/wiki/CamelCase). The camel aspect is the use of upper-case letters to indicate individual words in the name (hence `Average`). The first word in the method name is a verb (`determine`) to indicate that a method "does" something.

Let's return to that `determineAverage` method and get a complete script together - you can copy and paste this into `groovyConsole` and run it to experience the method first-hand:

```groovy
def scores = [2, 7, 4, 3]
def result = determineAverage(scores)
println result

def determineAverage(list) {
    return list.sum() / list.size()
}
```

Let's look at the main components of that script:

1. The `determineAverage` method is defined as before
    * This can appear above or below the other code - Groovy doesn't care but I like to put them at the bottom of scripts so the reader is presented with the main script first
1. A new list of numbers is created: `def scores = [2, 7, 4, 3]`
1. The method is called with the `scores` variable passed as a parameter
1. The return value (result) of `determineAverage` is stored in the `result` variable.





