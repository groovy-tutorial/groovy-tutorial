---
title:	Returning Values
status:	
description:	Closures can return values just like methods.
... 
 

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

However, unlike a method, closures can't explicitly define the data type of a return value

`Integer getMaxNumber(num1, num2) {...}`
:	This method signature is valid

`Integer maxNumber = {num1, num2 -> ...}`
:	This statement won't work 

`Closure myClosure = { num1, num2 -> ...}`
:	This will work as the `myClosure` variable is actually of the `Closure` data type
