---
title:	Techniques
status:	in-progress
description:	Various ideas to help your method writing but not your method acting.
...

I'd like to tell you that your programming career will be all about writing perfect code that never has problems but I'd just be lying. 

# Check that parameters are valid

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