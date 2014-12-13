---
title:	Closures
description:	A closure is a method function that is either named (stored in a variable) or anonymous (passed directly to a method).
...

Intro stuff [^terms]


[^terms]: Whilst I tend to use the terms "function" and "method" somewhat interchangeably when discussing Groovy, people discussing closures more generally use the term "function". Some languages have very specific meanings for terms such as "function", "procedure", "method" but I'd suggest that if you use the term "method" or "function" that most Java and Groovy developers will get your meaning. Alternatively, you could try to be more universal and call them all "subroutines"

```groovy
def myClosure = { println 'Hello, world' }
myClosure()
```

Closures get a single parameter named `it` by default: 

```groovy
def myClosure = { println "Hello, $it" }
myClosure('Jerry')
```

# Useful Methods That Use Closures
Groovy adds a number of methods to `java.lang.Object` that gives you the power of closures baked into many of the data types you'll use on a daily basis.

`any`
:	

`collect`
:	

`each`
:

`every`
:	

`find`
:	

`findAll`
:

`split`
:	

`with`
:

# Parameters

```groovy
def myClosure = { name, age ->
    println "$name is $age years old"
}

myClosure('Jeff', 26)
```

```groovy
def myClosure = { String name, Integer age ->
    println "$name is $age years old"
}

myClosure('Jeff', 26)
```

# Returning Values

Closures can return values just like methods. 

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

# Closures as Method Parameters


```groovy
def numList = [6, 9, 11, 4, 7]
def myClosure = { println it }
numList.each(myClosure)
```

However, we can use what's called an anonymous closure - one that doesn't get a name (i.e. assigned to a variable). This is really useful if we don't need to use the closure outside of the method being called:

```groovy
def numList = [6, 9, 11, 4, 7]
numList.each({ println it })
```

Whilst the closure can be placed within the `(...)` brackets, this becomes cumbersome for larger anonymous closures so Groovy lets us 

```groovy
def numList = [6, 9, 11, 4, 7]
numList.each { println it }
```

For a final example, we can call the `each` method directly against the literal array:

```groovy
[6, 9, 11, 4, 7].each { println it }
```

## Method Signatures With Closure Parameters

* Use `closure` as the parameter name
* Put the `closure` parameter at the end of the parameter list

```groovy
def findPrimes(list, closure) {
    for (num in list) {
        def isPrime = true
        if (num != 2) {
            for (divisor in (2..num/2)) {
                if (num % divisor == 0) {
                    isPrime = false
                    break
                }
            }
        }
        if (isPrime) {
            closure(num)
        }
    }
}

def numList = (1..100)
findPrimes numList, { println "I found a prime: $it" }

findPrimes (numList) { println it }
```

If I wanted to be specific about my parameter data types, the correct type for `closure` is `Closure`: `def findPrimes(List list, Closure closure) `

One last round at this one - this time to set a return value from the `findPrimes` method:

```groovy
Boolean findPrimes(List list, Closure closure) {
    def result = false
    for (num in list) {
        def isPrime = true
        if (num != 2) {
            for (divisor in (2..num/2)) {
                if (num % divisor == 0) {
                    isPrime = false
                    break
                }
            }
        }
        if (isPrime) {
            result = true
            closure(num)
        }
    }
    return result
}
```