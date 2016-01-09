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

{lang=Java}
<<[Using `split`](code/07/07/split.groovy)


##`with`

The `with` method provides a handy approach to calling several methods and manipulating fields for an object.

In the example below I use `with` to perform a set of operations on an instance of the `Person` class:

{lang=Java}
<<[Using `with`](code/07/07/with.groovy)

This approach can be really useful when creating an object. In the snippet below I create a new `Person` and set up their details at the same time:

{lang=Java}
<<[Using `with` at instantiation time](code/07/07/with_constructor.groovy)
