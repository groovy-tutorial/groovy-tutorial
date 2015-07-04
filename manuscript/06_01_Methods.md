# The Basics  

Let's start by examining a new method we'll write to calculate the average of the numbers in a list:

```groovy
	def determineAverage(list) {
	    return list.sum() / list.size()
	}
```

Breaking that code up we can see:

1. The `def` reserved word is used to commence the method declaration
	- Much like we use when defining a variable
1. `determineAverage` is the name of the method
1. The method accepts a single parameter, `list`
1. A single value is returned using the `return` reserved word
	- In this case it's the result of `list.sum() / list.size()`

The method name (`determineAverage`) may look a bit odd but it uses a naming strategy called ["lower Camel Case"](https://en.wikipedia.org/wiki/CamelCase). The camel aspect is the use of upper-case letters to indicate individual words in the name (hence `Average`). The first word in the method name is a verb (`determine`) to indicate that a method "does" something.

Let's return to that `determineAverage` method and get a complete script together - you can copy and paste this into `groovyConsole` and run it to experience the method first-hand:

	def scores = [2, 7, 4, 3]
	def result = determineAverage(scores)
	println result
	
	def determineAverage(list) {
	    return list.sum() / list.size()
	}

Let's look at the main components of that script:

1. The `determineAverage` method is defined as before
    * This can appear above or below the other code - Groovy doesn't care but I like to put them at the bottom of scripts so the reader is presented with the main script first
1. A new list of numbers is created: `def scores = [2, 7, 4, 3]`
1. The method is called with the `scores` variable passed as a parameter
1. The return value (result) of `determineAverage` is stored in the `result` variable.

In the example I called the method using `determineAverage(scores)` but, in many cases, I don't need to use the parentheses and `determineAverage scores` would have also worked. That's why `println 'hello, world'` works just fine. This works really well when you start to use Groovy to construct [domain-specific languages](http://groovy-lang.org/dsls.html).



