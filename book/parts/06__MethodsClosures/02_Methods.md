---
title:		Methods and Closures  
description:	Methods help us break code into logical and reusable segments. Closures let us store these methods as variables so that we can pass them around to be used by other methods.  
...
Methods (sometimes also called functions) are blocks of code that can be run more than once and encapsulate a segment of logic. We define a method by writing the code that will be run when the method is called. Calling a method is the process of your code asking the method to start.

Groovy, like Java, is object-oriented and works around classes. C is procedural and works around functions. Whilst the methods described here may look a bit like C-style programming that lets you build libraries of functions, what is really happening is Groovy is wrapping your code in a `class` definition behind the scenes. Your only likely to create "raw" methods, like the ones below, as a means to break up your scripts. More usually you'll create methods within your classes.

<!-- TODO: Link to the methods section in Objects tutorial -->

Methods have a number of features:

1. Methods have names - this allows you to call your method in a meaningful way
2. Methods can accept parameters - these are inputs into your method that can affect how your method 
3. Methods can return a result value - this can be captured by a parameter from the code calling the method
4. Methods have their own scope - they can have their own variables and not inadvertently affect the rest of your program

We've already looked at various methods...

Let's start by examining a new method we'll write to calculate the average of the numbers in a list:

```groovy
def determineAverage(list) {
    return list.sum() / list.size()
}
```

Breaking that code up we can see:

1. The `def` reserved word
1. `determineAverage` is the name of the method
1. The method accepts a single parameter, `list`
1. A single value is returned using the `return` reserved word - in this case it's the result of `list.sum() / list.size()`

The method name (`determineAverage`) may look a bit odd but it uses a naming strategy called "lower Camel Case". The camel aspect is the use of upper-case letters to indicate individual words in the name (hence `Average`). The first word in the method name is a verb (`determine`) to indicate that a method "does" something.

<!-- TODO: Link to naming strategies -->

Let's return to that `determineAverage` method and get a complete script together - you can copy and paste this into `groovyConsole`:

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
    * This can appear above or below the other code - Groovy doesn't care but I like to put them at the bottom of scripts so the reader is presented with the main 
1. A new list of numbers is created: `def scores = [2, 7, 4, 3]`
1. The method is called with the `scores` variable passed as a parameter
1. The return value (result) of `determineAverage` is stored in the `result` variable.

# Parameters
You might be wondering what happened to the `scores` variable once it was passed to `determineAverage` as a parameter. Basically, Groovy gave it another name (`list`) for use within the method. Inside the method, `list` is just another variable. This means that if `determineAverage` changes `list` in some way, this is reflected in the `scores` variable used in the main script:

```groovy
def scores = [2, 7, 4, 3]
def result = determineAverage(scores)
println result
println scores

def determineAverage(list) {
    list << 9
    return list.sum() / list.size()
}
```

The code above is very poorly behaved - it modifies `list` by adding a new item. Unless you provided documentation that explicitly states that you will change a parameter, most developers will assume that their parameters will be safely untouched by your method.

>Deep down in the computer, `scores` and `list` are names that point to the same piece of memory. Understanding how programming languages handle memory is an extremely important part of programming. I don't really cover it in this tutorial but start by looking up "memory management" in wikipedia.

## Declaring data types for parameters

> As methods create your Application Programming Interface (API), it can be called by other people's code and they could be using another JVM language (such as Java). It can make their life a little easier if you indicate the data types your expecting for your parameters. Alternatively, you can stay true to dynamic typing and let people know through your documentation.

## Multiple parameters

```groovy
def callFriend(name, phone, message) {
    println "Dialling $name on $phone"
    println "Hi, $name - $message"
}
```

Either of these calls would work:

```groovy
callFriend('Barry', '0400 123 456', 'Did you see that local sporting team?')

callFriend 'Alex', '07 3344 0000', 'Could you please check on my pets whilst I\'m away?'
```

## Default Values for Parameters


```groovy
def displayMessage (message, title = 'Important message:', border = true) {

    def borderText = ''
    
    if (border) {
         borderText = '-----------------------------------------------------------'
    }

    println """\
    $borderText
    $title
    \t $message
    $borderText
    """
}
```

The `displayMethod` can be called in a number of ways:

* `displayMessage 'Preparing to shut down. Please save your work'` - 
* `displayMessage 'The system appears to have crashed', 'Error!'`
* `displayMessage 'Be prepared for the happiness patrol', 'Public announcement:', false` 

## Named Arguments

You can 

```groovy
def displayMessage (options, message) {

    def borderText = ''    
    if (options.border || ! options.containsKey(border)) {
         borderText = '-----------------------------------------------------------'
    }
    
    if (!options.title) {
         options.title = 'Important message:'
    }

    println """\
    $borderText
    $options.title
    \t $message
    $borderText
    """
}
```

* `displayMessage(title: 'Canberra', border: true, 'The capital of Australia')`
* `displayMessage title: 'Time', "It is now ${new Date()}"`
* `displayMessage border: false, 'Hang in there little buddy!'`

## Variable Arguments (Varargs)

There are times where we want to . One such method is to use an array for a catch-all parameter 

```groovy
buyGroceries 'The Corner Store', ['apples', 'cat food', 'cream']

def buyGroceries(store, items) {
    println "I'm off to $store to buy:"
    for (item in items) {
        println "  -$item"
    }
}
```



Groovy supports the use of variable arguments using the "three-dot" (`...`) notation for the last (and only the last) parameter:

```groovy
buyGroceries 'apples', 'cat food', 'cream'

def buyGroceries(... items) {
    for (item in items) {
        println item
    }
}
```

We can set a specific data type for the `items` parameter by placing the type before the `...`:

```groovy
def buyGroceries(String... items) {
    for (item in items) {
        println item
    }
}
```



```groovy
buyGroceries 'The Corner Store', 'apples', 'cat food', 'cream'

def buyGroceries(store, ... items) {
    println "I'm off to $store to buy:"
    for (item in items) {
        println "  -$item"
    }
}
```

Putting a parameter after the variable arguments parameter doesn't make a great deal of sense as it'd be tricky to work out where `items` finished. So, even if `def buyGroceries(store, ...items, travelTime)` was legitimate (and it isn't) I'd suggest that readability is lost and `travelTime` should appear before `items`. Alternatively, using an array for `items` would solve the problem.

# Return value

```groovy
println determineAverage(10, 20, 30, 40)

def determineAverage(... list) { 
    return list.sum() / list.size()
}
```

Using the `return` reserved word isn't required as Groovy will return the result of the last statement:

```groovy
println determineAverage(10, 20, 30, 40)

def determineAverage(... list) { 
    list.sum() / list.size()
}
```

A method can use `return` at different points of a method. This allows you to exit a method at an arbitrary point 

<!-- example of return to just exit -->

You can also return a value:

```groovy
def isEven(num) {
    if (num % 2 == 0) {
        return true
    }
    return false
}
```

## Declaring data types for return values

```groovy
println determineAverage(10, 20, 30, 40)

Number determineAverage(... list) { 
    return list.sum() / list.size()
}
```

# Variable scope



# Testing and defensive coding
I'd like to tell you that your programming career will be all about writing perfect code that never has problems but I'd just be lying. 

## Check that parameters are valid

````
assert determineAverage([5, 5, 8]) == 6
assert determineAverage([-10, 5, 2, 7]) == 1
````

We understand that `determineAverage(list)` is expecting a list of numbers and have used a reasonably clear naming strategy (`determineAverage`) to display that the method is number-oriented *but* what happens when our colleague gives us something like:

````
def data = [5, 5, 8, 'kitten']
determineAverage(data)
````

Clearly, _kittens_ aren't something that the _average_ calculation can understand. If you try to run that code you'll get a nasty error that basically says your code has failed. Don't be too hard on your colleague though - perhaps they've loaded data from a file that's become corrupted by felines.

What you can do though is to code defensively and make sure that `determineAverage` has some useful documentation such as: 

````groovy
/**
 * Determines the average for a list of numbers
 * @param   list  a list of numbers
 * @return the average of the numbers in the list
 */
def determineAverage(list) {
    return list.sum() / list.size()
}
````

In the example above I've just added a comment block that describes what the method does, its parameter and what it will return.

Next, I can make sure that the method has a prerequisite that needs to be met before it attempts to run.

SEE METHODS.GROOVY

```
/**
 * Determines the average for a list of numbers
 * @param   list  a list of numbers
 * @return        the average of the numbers in the list
 */
def determineAverage(list) {
    for (item in list) {
        if (! item instanceof Number) {
            throw new IllegalArgumentException()
        }
        if (item instanceof String) {
            throw new IllegalArgumentException()
        }
    }
    return list.sum() / list.size()
}

//assert determineAverage([5, 5, 8]) == 6
//assert determineAverage([-10, 5, 2, 7]) == 1

assert determineAverage([12, '18']) == 15

//def data = [5, 5, 8, 'kitten']
//determineAverage(data)
```
import groovy.transform.TypeChecked

def scores = [2, 7, 4, 4]
println determineAverage(scores)

@TypeChecked
Number determineAverage(List<Number> list) {
    Number sum = (Number)list.sum()
    Number size = list.size()
    return  sum / size
}

Let's go all out on the type checking:

```groovy
import groovy.transform.TypeChecked

def scores = [2, 7, 4, 4]
println determineAverage(scores)

@TypeChecked
Number determineAverage(List<Number> list) {
    Number sum = (Number)list.sum()
    Number size = list.size()
    return  sum / size
}
```
