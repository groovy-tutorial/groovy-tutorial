# Loops and closures

I> Some collection methods that accept a closure look like a loop but you do need to take a little care.

A number of Groovy types (such as lists and maps) support methods like `each` which call a closure on each member of a collection. These are similar to loops (`for` and `while`) but each call to the closure is discreet and you can't use the `break` branching statement to exit as you would with a loop. However, you can use `return` as somewhat of a proxy for `continue`.

In this chapter we'll take a look at a number of these methods.

## `each`

We looked at `each` in the previous chapter but let's do one more. In the example below I determine the average of a list of numbers and then use the `each` method to tell us something about each number's relationship to the average:


	def scores = [2, 4, 6, 8, 10]
	def total = 0
	def average = 0
	
	for (i in scores) {
	    total += i
	}
	
	average = total / scores.size
	
	println "The average of the scores ($scores) is $average"
	
	scores.each {
	    print "The value $it is "
	
	    if (it > average) {
	       println 'above average'
	    } else if (it < average) {
	        println 'below average'
	    } else {
	        println 'average'
	    }
	}


## `collect`

The collect method calls a closure for each item in a list and returns a list of the results from each closure call. This next example takes a list of test scores and uses the closure's algorithm for returning a list of grades:


	def grades = [45, 70, 95, 51].collect {
	    switch(it) {
	        case (90..100):
	            'A'
	            break
	        case (70..89):
	            'B'
	            break
	        case (50..69):
	            'C'
	            break
	        default:
	            'F'
	    }
	}
	
	println grades


## `sort`

The `sort` method, when called on a list, will use the closure to evaluate a sorting algorithm and alter the list to reflect its sorted form.

In the next example I provide a very basic sorting closure - one that just returns the length of the string it's passed. This means that the `sort` method will return a list with the shortest string first:


	assert ['cat', 'rabbit', 'ox'].sort{it.length()} == ['ox', 'cat', 'rabbit']


In this use of `sort` the closure accepts a single parameter and returns a numerical value. `sort` uses this result to determine the list item's new place in the sorted list. A string of length `2` will be placed at an earlier index to a string with a length of `6`.

It's important to remember that the list is changed by the `sort` method - the next example highlights this as the `animals` variable is different after `sort` is called.


	def animals = ['cat', 'rabbit', 'ox']
	animals.sort{it.length()} 
	assert animals == ['ox', 'cat', 'rabbit']


When  the `sort` method is passed a closure that accepts two parameters then it works through the list by comparing neighbours. As sort changes the list, these neighbours change, resulting in the closure undertaking a number of comparisons, at least equal to the number of list items. This is powerful stuff so let's look at a sorting closure I used when discussing Relational Operators:

	
	def nums = [42, -99, 6.3, 1, 612, 1, -128, 28, 0]
	
	//Ascending
	nums.sort{n1, n2 -> n1<=>n2 }
	
	assert nums == [-128, -99, 0, 1, 1, 6.3, 28, 42, 612]




