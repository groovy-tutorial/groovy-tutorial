---
title:	Returning Values
status:	in-progress
description:	Closures can return values just like methods.
... 

 
```groovy
def max = { num1, num2 ->
    if (num1 >= num2) {
        num1
    } else if (num2 > num1) {
        num2
    } 
}

println max(14, 6)
```


```groovy
def myClosure = { num1, num2 ->
    if (num1 > num2) {
        return num1
    } else if (num2 > num1) {
        return num2
    } 
    
    //The numbers are equivalent so return either
    return num1
}

println myClosure(14, 6)
```

Unlike a method, closures can't explicitly define the data type of a return value. You might take a crack at `Integer maxNumber = {num1, num2 -> ...}` to set the return type but this statement won't work as `maxNumber` doesn't hold the result of the closure - it holds a reference to the closure.

>`Closure myClosure = { num1, num2 -> ...}` will work as the `myClosure` variable is actually of the `Closure` data type.



