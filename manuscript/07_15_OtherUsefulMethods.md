#Useful Methods That Use Closures

I> Groovy has a number of ready to go uses for closures

Groovy adds a number of methods to `java.lang.Object` that gives you the power of closures baked into many of the data types you'll use on a daily basis.

##`any`

The `any` method is passed a closure that evaluates a criteria (condition). If any element in the collection meets that criteria, `true` is returned. Importantly, `any` will only iterate through the list until it the criteria is met.

	def scores = [10, 8, 11, 6]
	assert scores.any {it > 10} == true


##`find` and `findAll`

The `find` method locates the first item in a collection that meets the criteria set in the closure:

	def animals = ['dog', 'rat', 'cat', 'mouse']
	assert animals.find {it in ['rat', 'mouse', 'wild pig'] } == 'rat'

The `findAll` method is similar to `find` but returns all collection items that meet the criteria set by the closure:

	def animals = ['dog', 'rat', 'cat', 'mouse']
	assert animals.findAll {it in ['rat', 'mouse', 'wild pig'] } == ['rat', 'mouse']


##`split`

The `split` method splits a collection into two lists: the first list contains all items that meet the criteria set by the closure parameter and the second list contains all remaining items.

In the example below I use the `split` method to get a list of those who got a score over 100 and those that didn't.

	def players = [
	    [name: 'Fred', topScore: 120],
	    [name: 'Sally', topScore: 200],
	    [name: 'Felix', topScore: 101],
	    [name: 'Albert', topScore: 12],
	    [name: 'Jane', topScore: 20]
	]
	
	def result = players.split {it.topScore > 100}
	
	result[0].each {println "$it.name is in the hall of fame"}
	
	result[1].each {println "$it.name missed out"}


##`with`

The `with` method provides a handy approach to calling several methods and manipulating fields for an object. 

In the example below I use `with` to perform a set of operations on an instance of the `Person` class:

	class Person {
	    def name
	    def email
	    def mobile
	    
	    def printBusinessCard(){
	        println "$name"
	        println "e: $email"
	        println "m: $mobile"
	    }
	}
	
	def john = new Person()
	
	john.with {
	    name = 'John Smith'
	    email = 'john@example.com'
	    mobile = '0401 999 888'
	    printBusinessCard()
	}


This approach can be really useful when creating an object. In the snippet below I create a new `Person` and set up their details at the same time:
	
	def stacey = new Person().with {
        name = 'Stacey Jane'
        email = 'stacy@example.com'
        mobile = '0401 333 666'
        return it
    }
    stacey.printBusinessCard()

