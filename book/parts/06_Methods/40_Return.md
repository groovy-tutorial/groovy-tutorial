---
title:	Return value
status:	in-progress
description:	
...

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
