---
title:	Closures as Method Parameters
status:	in-progress
description:	
...

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