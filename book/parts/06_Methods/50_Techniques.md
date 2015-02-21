---
title:	Techniques
status:	in-progress
description:	Various ideas to help your method writing but not your method acting.
...

I'd like to tell you that your programming career will be all about writing perfect code that never has problems but I'd just be lying. Here are some techniques to help make sure your methods are more robust and helpful to other programmers.

# Valid parameters

We understand that the method `determineAverage(...values)` is expecting a list of numbers and have used a reasonably clear naming strategy (`determineAverage`) to display that the method is number-oriented *but* what happens when our colleague gives us something like:

````
determineAverage(5, 5, 8, 'kitten')
````

Clearly, _kittens_ aren't something that the _average_ calculation can understand[^pun]. If you try to run that code you'll get a nasty error that basically says your code has failed. Don't be too hard on your colleague though - perhaps they've loaded data from a file that's become corrupted by felines.

[^pun]: Pun intended

## Comment your method 
Firstly, make sure that `determineAverage` has some useful documentation such as: 

```groovy
/**
 * Returns the average of the parameters
 *
 * @param values  a series of numerical values
 * @throws IllegalArgumentException if a parameter is a String
 * @returns The average of the values
 */
def determineAverage(...values) 
    return values.sum() / values.size()
}
```

In the example above I've just added a GroovyDoc comment block that describes what the method does, its parameter and what it will return. At the very least, other developers will see how they _should_ be using my method.

## Check the parameters
Next, I can be more defensive in my coding and make sure that the method has a prerequisite that needs to be met before it attempts to run.

```
/**
 * Returns the average of the parameters
 *
 * @param values  a series of numerical values
 * @throws IllegalArgumentException if a parameter is a String
 * @returns The average of the values
 */
def determineAverage(...values) 
  throws IllegalArgumentException {
    for (item in values) {
        if (item instanceof String) {
            throw new IllegalArgumentException()
        }
    }
    return values.sum() / values.size()
}

//This works:
assert determineAverage(12, 18) == 15

//This does not work - we get an exception
determineAverage(5, 5, 8, 'kitten')
```

The approach above checks to make sure that no parameter is a `String` - if you pass one to the method you'll get an exception thrown back at you. In reality I should make sure that only numbers can be passed in and my check won't pick up a `Boolean` value - more on this in a moment.

What do you think would happen if I called the method with no parameters - `determineAverage()`? 

(pause)

Well, the division would attempt to divide by zero and that's a fail so I need to also check that `values` isn't empty (I'll leave out the comments for brevity):

```groovy
def determineAverage(...values) 
  throws IllegalArgumentException {
    for (item in values) {
        if (item instanceof String) {
            throw new IllegalArgumentException()
        }
    }
    
    if (!values) {
        return 0
    }
    
    return values.sum() / values.size()
}
```

Note that if no parameters are passed, I return `0`. I really don't like returning `null` from methods as it makes other developers then have to check for `null`. I also don't want to raise an exception - I'm happy enough to say that the average of no values is `0`.

## Get really typed

If I really want to get specific with the data types I'll take as parameters and return from the method then I can switch to static typing. I can make sure that all my parameters are of type `Number` (or one of its subtypes) and that I will return a value of type `Number`. The code below really gets specific about data types:

```groovy
/**
 * Returns the average of the parameters
 *
 * @param values  a series of numerical values
 * @throws IllegalArgumentException if a parameter is a String
 * @returns The average of the values
 */
Number determineAverage(Number...values) {
    
    if (!values) {
        return 0 as Number
    }
    
    Integer sum = values.sum() as Integer
    Integer n = values.length
    Number average = (sum / n) as Number
    return  average 
}
```

The following two calls to the method would work:

```groovy
assert determineAverage(2, 7, 4, 4) == 4.25
assert determineAverage() == 0
```

...but the following two calls won't work:

```groovy
determineAverage(2, 7, 4, 4, 'kitten')
determineAverage(2, 7, 4, 4, true)
```

If you are writing a method that needs to be very specific about data types for parameters and/or return values then this is the way to go.

# Testing

I'd get into a lot of trouble from experienced developers if I just left this chapter without mentioning testing. I'm hoping that one day there'll be a Testing tutorial added to this book but, until then, check out [Unit Tests section](http://groovy-lang.org/testing.html) on the Groovy website.

Oh ok, here's a little example using [Spock](http://docs.spockframework.org/en/latest/)! 

Firstly, this won't run in your groovyConsole. You need to copy the code into the online [Spock web console](http://meetspock.appspot.com)[^sample] and then click on "Run Script":

```groovy
import spock.lang.Specification

class MathDemo {
    /**
     * Returns the average of the parameters
     *
     * @param values  a series of numerical values
     * @throws IllegalArgumentException if a parameter is a String
     * @returns The average of the values
     */
    static determineAverage(...values) 
      throws IllegalArgumentException {
        for (item in values) {
            if (! (item instanceof Number)) {
                throw new IllegalArgumentException()
            }
        }
        
        if (!values) {
            return 0
        }
        
        return values.sum() / values.size()
    }
}

class AvgSpec extends Specification {

    @Unroll
    def "average of #values gives #result"(values, result){
        expect:
            MathDemo.determineAverage(*values) == result
        
        where:
            values       || result
            [1,2,3]      || 2
            [2, 7, 4, 4] || 4.25
            []           || 0
    }
    
    @Unroll
    def "determineAverage called with #values throws #exception"(values, exception){
        setup:
           def e = getException(MathDemo.&determineAverage, *values)

        expect:
            exception == e?.class
        
        where:
            values       || exception
            ['kitten', 1]|| java.lang.IllegalArgumentException
            [99, true]   || java.lang.IllegalArgumentException
            [1,2,3]      || null
    }
    
    Exception getException(closure, ...args){
        try{
            closure.call(args)
            return null
        } catch(any) {
            return any
        }
    }
}
```

When you run this in the Spock web console you should get:

```
AvgSpec
 - average of [1, 2, 3] gives 2
 - average of [2, 7, 4, 4] gives 4.25
 - average of [] gives 0
 - determineAverage called with [kitten, 1] throws class java.lang.IllegalArgumentException
 - determineAverage called with [99, true] throws class java.lang.IllegalArgumentException
 - determineAverage called with [1, 2, 3] throws null
```

So there's a lot going on here that we haven't covered in the tutorials so far but let's try to break it down:

1. I wrapped the `determineAverage()` method in a class named `MathDemo` and made it a `static` method
	- I won't explain this here - just trust me that you can call `MathDemo.determineAverage()`
	- But do note that I've changed `determineAverage()` to better check that the parameters are numbers.
1. I then created a spock test `Specification` subclass called `AvgSpec`
	2. The first test is `def "average of #values gives #result"(values, result)`
		3. This runs a series of tests using the data table in the `where:` block
		4. Yes, that's right, Groovy will let you use a GString as the name of the method - that's v.cool
	4. The second test is `def "determineAverage called with #values throws #exception"(values, exception)`
		5. This checks to make sure that the `IllegalArgumentException` is thrown for incorrect parameters

As I say, there are a number of topics such as classes and closures that I haven't covered - this example was just a quick one and should make sense as you learn about those additional concepts.

[^sample]: I've [published the code](http://meetspock.appspot.com/script/5713144022302720) to make it easy for you but can't promise that this link will always work.