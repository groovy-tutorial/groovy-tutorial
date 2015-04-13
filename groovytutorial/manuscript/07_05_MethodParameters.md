# Closures as Method Parameters

I> Closures get really interesting when you start passing them around


We often say closures are first-class citizens in Groovy. This means that you can use them across the language in a similar manner to other first-class citizens, such as variables. 

The best example to start our exploration is the `each` method that's available to your collections (lists and maps). `each` can be called on a list or a map and is passed a closure as a parameter, allowing you to perform operations on each member of the collection. In the next example I call `each` on the `numList` variable and pass it a very basic closure as a parameter:


	def numList = [6, 9, 11, 4, 7]
	def myClosure = { println it }
	numList.each(myClosure)

However, we can avoid `myClosure` altogether as we don't really need to use it anywhere else in our code. So, we use an anonymous closure - one that doesn't get a name (i.e. assigned to a variable). This is really useful if we don't need to use the closure outside of the method being called:


	def numList = [6, 9, 11, 4, 7]
	numList.each({ println it })


Whilst the closure can be placed within the `(...)` parentheses, this becomes cumbersome for larger anonymous closures so Groovy lets us drop the parentheses:


	def numList = [6, 9, 11, 4, 7]
	numList.each { println it }


For a final example, we can call the `each` method directly against the literal array, just to prove that Groovy has a versatile and flexible syntax:


	[6, 9, 11, 4, 7].each { println it }


## Methods with Closure Parameters

Your own methods can accept one or more closures as a parameter. When doing this we usually follow a basic convention of:

* Use `closure` as the parameter name
* Put the `closure` parameter at the end of the parameter list

In the example below, the `mutator` method accepts a closure as the second parameter:


	def mutator(value, closure) {
	    closure(value)
	}

	mutator 10, {it**2}


We are able to call `mutator` in a number of ways:

* `mutator(10, {it**2})`
* `mutator 10, {it**2}`
* `mutator(10) {it**2}`

Those last two options are very useful if you're going to pass a non-trivial closure as it helps the reader see that the last parameter is a closure and not some random block.

Here's another example, a method `findPrimes` that accepts a list of numbers (such as a range) and a closure. The method loops through the list and, when it determines the item is a prime number it will call our closure:


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


If I wanted to be specific about my parameter data types, the correct data type for `closure` is `Closure`.  This lets me prepare a more static method signature of `def findPrimes(List list, Closure closure) `

One last round at this one - this time to set a return value from the `findPrimes` method. The code is not really different to the previous example but it throws a number of items together: a typed method signature, a closure parameter, and a return value for the method (the list of primes).


	List findPrimes(List list, Closure closure) {
	    def result = []
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
	            result << num
	            closure(num)
	        }
	    }
	    return result
	}
	
	def primes = findPrimes 0..100, { println "I found a prime: $it" }
