# Ranges {#chranges}

I> Ranges describe a range of numbers.

Ranges define a starting point and an end point. Let's look at a well-known type of range:

{title="Declaring a range",lang=groovy}
	def countdown = 10..0

	println countdown.getFrom()
	println countdown.getTo()


The `countdown` range starts at 10 and goes down to 0. The notation should be easy to decipher: `<start>..<end>`.

Printing out a range variable will display that a range is rather like a list of values - in the case of `countdown` they're numbers:

{title="Ready for launch",lang=groovy}
	def countdown = 10..0
	println countdown


Whilst my examples so far all go down, you can just as easily have a range that goes up:

{title="Going up",lang=groovy}
	def floors = 1..10
	println floors


You can also use decimals but note that it is only the integer (whole-number) component that is stepped through:

{title="Decimals in ranges",lang=groovy}
	def countdown = 10.1..1.1
	println countdown


## Half-Open Ranges

Ranges aren't just limited to inclusive ranges such as `1..10`. You can also declare a _half-open range_ using `..<` - that's two periods and a less-than. This denotes that the range ends prior to the number to the right. In the example below I setup a grading criteria that avoids an overlap between the grades:

{title="Half-open range declarations",lang=groovy}
	def gradeA = 90..100
	def gradeB = 80..<90
	def gradeC = 65..<80
	def gradeD = 50..<65
	def gradeF = 0..<50


I could tweak the above code if I want to get fancy:

{title="A fancier approach",lang=groovy}
	def gradeA = 90..100
	def gradeB = 80..<gradeA.getFrom()
	def gradeC = 65..<gradeB.getFrom()
	def gradeD = 50..<gradeC.getFrom()
	def gradeF = 0..<gradeD.getFrom()


## Ranges of Objects

Ranges are primarily used with numbers but they can be of any object type that can be iterated through. This basically means that Groovy needs to know what object comes next in the range - these objects provide a `next` and `previous` method to determine this sequence. Over time you'll discover various options for use in ranges but numbers really are the main type.

Apart from numbers, individual characters (letters) can be used in ranges. In the example below I create a range of lower-case letters:

{title="A range of characters",lang=groovy}
	def alphabet = 'a'..'z'
	println alphabet


### Ranges and Enums

I> We'll look into Enums when we start looking at creating objects in [a later tutorial](#chenums)

Ranges can be handy when dealing with `enums` as they give us the ability to set a subset of enum values. In the example below I create a handy helpdesk tool:

1. Setup an `enum` listing the possible ticket priorities
2. Create a new `class` to describe helpdesk tickets
3. Setup a `helpdeskQueue` containing a list of tickets
4. Set the `focus` variable as a range of `Priority` values
5. Go through the list of tickets and pick up any that are set to the `priority` I care about.

{title="Using a helpdesk ticket `enum`",lang=groovy}
	enum Priority {
	    LOW,MEDIUM,HIGH,URGENT
	}

	class Ticket {
	    def priority
	    def title
	}

	def helpdeskQueue = [
	    new Ticket(priority: Priority.HIGH, title: 'My laptop is on fire'),
	    new Ticket(priority: Priority.LOW, title: 'Where is the any key'),
	    new Ticket(priority: Priority.URGENT, title: 'I am the CEO and I need a coffee'),
	    new Ticket(priority: Priority.MEDIUM, title: 'I forgot my password')
	]

	def focus = Priority.HIGH..Priority.URGENT

	for (ticket in helpdeskQueue) {
	    if (ticket.priority in focus) {
	        println "You need to see to: ${ticket.title}"
	    }
	}


Try the example above out with various settings for the `focus` variable:

- `def focus = Priority.MEDIUM..Priority.URGENT`
	- Gives us more tickets to see to :(
- `def focus = Priority.HIGH..Priority.LOW`
	- Is actually similar to `4..1` and leaves out the tickets marked `URGENT`

## Ranges and List Indexes

You can access a subset of a list using a range subscript. In the example below I use the subscript `[1..3]` to grab a new list containing elements 1 through 3 of the `temperatures` list.

T> ## Zero-based lists
T> Remember that lists are zero-based so `5` is element number 1

{title="Accessing range elements",lang=groovy}
	def temperatures = [10, 5, 8, 3, 6]
	def subTemp = temperatures[1..3]
	assert subTemp == [5, 8, 3]


## Ranges and Loops

Ranges are most often see when we're using loops - we'll get to them in a later tutorial but here's an example of a launch sequence:

{title="Looping with ranges",lang=groovy}
	def countdown = 10..0

	for (i in countdown) {
	    println "T minus $i and counting"
	}


In the above example I store the range in the `countdown` variable in case I need it again later. If I don't really need to re-use the range I can put the range's literal value directly into the loop:

{title="Looping with ranges refined",lang=groovy}
	for (i in 10..1) {
	    println "T minus $i and counting"
	}


## Useful Methods

We can use the `size()` method to find out how many elements are in the range:

{title="The size method",lang=groovy}
	def dalmations = 1..101
	println dalmations.size()


As seen earlier, the `getFrom()` and `getTo()` methods return the start and final values respectively:

{title="The range's start and end values",lang=groovy}
	def intRange = 1..10
	println intRange.getFrom()
	println intRange.getTo()


The `isReverse()` method returns `true` if a range iterates downwards (backwards):

{title="Checking for reverse",lang=groovy}
	def countdown = 10..0
	assert countdown.isReverse() == true


You can can use the `reverse()` method to flip the range:

{title="Reversing the range",lang=groovy}
	def floors = 1..10
	println floors.reverse()


In order to check if a value is contained within a range we use the `containsWithinBounds` method and pass it the value we're checking on:

{title="Checking bounds",lang=groovy}
	def countdown = 10..0
	assert countdown.containsWithinBounds(5) == true


The `step` method returns a list based on going through the range via the specified increment (step). In the example below I step through the range one at a time (`step(1)`) and then two at a time (`step(2)`):

{title="Stepping",lang=groovy}
	def countdown = 5..1
	assert countdown.step(1) == [5, 4, 3, 2, 1]
	assert countdown.step(2) == [5, 3, 1]


As `step` returns a list I can use it to populate a list variable that has too many numbers for me to be bothered typing out:


	def dalmations = (1..101).step(1)
	println dalmations


As we're about to see the `step` method is very effective when used with closures.

### Ranges and Closures

Closures are a method (function) that can be handled in a manner similar to variables. A closure is described within curly brackets `{..}` and can be passed as method parameters.  Closure have a default variable named `it` and this holds a value passed to the closure by its caller.

We'll look into closures much more thoroughly in a [later tutorial](#chclosures) but, for now, take in the following examples and refer back to them when you get to know closures a little better.

The `step` method will call a closure for each item in a range. In the example below I step through `countdown` one number at a time and, for each number, I display a message:

{title="Stepping through a range with closures",lang=groovy}
	def countdown = 10..1
	countdown.step(1) {
	    println "T minus $it and counting"
	}

I> ## Closure syntax
I>The syntax `countdown.step(1) {..}` probably looks a bit odd at this point - essentially, the closure is being passed as a parameter to `step`. There's a [tutorial covering closures coming up](#chclosures) so don't feel too annoyed if these examples don't look right to you.

I can use the range literal but need to place it within `(..)`:

{title="Using the range literal",lang=groovy}
	(10..1).step(1) {
	    println "T minus $it and counting"
	}


You can change the size of each step - in the case below I step down by 2 each time. Run the code and notice that launch never happens!

{title="Changing the step",lang=groovy}
	(10..1).step(2) {
	    println "T minus $it and counting"
	}

