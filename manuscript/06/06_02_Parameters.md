# Parameters

I> Parameters are method inputs that are used by the method to produce a result.

Let's look at the last example from the previous chapter:

{lang=Java}
<<[The determineAverage method](code/06/01/determineAverage.groovy)

You might be wondering what happened to the `scores` variable once it was passed to `determineAverage` as a parameter. Basically, Groovy gave it another name (`list`) for use within the method. Inside the method, `list` is just another variable. This means that if `determineAverage` changes `list` in some way, this is reflected in the `scores` variable used in the main script:

{title="A poor example",lang=Java}
	def scores = [2, 7, 4, 3]
	def result = determineAverage(scores)
	println result
	println scores

	def determineAverage(list) {
	    list << 9
	    return list.sum() / list.size()
	}


The code above is __very__ poorly behaved - it modifies `list` by adding a new item. Unless you provided documentation that explicitly states that you will change a parameter, most developers will assume that their parameters will be safely untouched by your method.

T> Deep down in the system, `scores` and `list` are names that point to the same piece of memory. Understanding how programming languages handle memory is an extremely important part of programming. I don't really cover it in this tutorial but start by looking up ["memory management" in Wikipedia](https://en.wikipedia.org/wiki/Memory_management).

## Declaring data types for parameters

Groovy lets you designate a data type for your parameters:

{title="Parameter with data type",lang=Java}
	def determineAverage(List list) {
	    return list.sum() / list.size()
	}


As you start to develop classes and larger programs, methods create your Application Programming Interface (API). Such methods can be called by other people's code and they could be using another JVM language (such as Java). It can make their life a little easier if you indicate the data types you're expecting for your parameters. Alternatively, you can stay true to dynamic typing and let people know through your documentation.

## Multiple parameters

Let's look at another method - one that needs several parameters:

{title="Multiple parameters",lang=Java}
	def callFriend(name, phone, message) {
	    println "Dialling $name on $phone"
	    println "Hi, $name - $message"
	}


Either of these calls would work - it just depends if you want to use the parentheses:

	callFriend('Barry', '0400 123 456', 'Did you see that local sporting team?')

	callFriend 'Alex', '07 3344 0000', 'Could you please check on my pets whilst I\'m away?'

Each parameter may be typed if needed:

	def callFriend(String name, String phone, String message) {..}


You can provide a mix of typed and untyped parameters but this is a little messy and I think it's bad form so I can't be bothered encouraging such an action by providing an example.
