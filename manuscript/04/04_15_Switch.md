# The `switch` Statement {#chswitch}

I> When that if statement gets too big to handle, it's time to `switch`.

There are times when the number of possibilities are larger than a readable `if-else-if` statement can handle. There are also times where we want to execute a specific set of statements but then "fall through" to others. It's in these places that the `switch` statement comes in handy.

Let's take a look at an example:

{title="Switch",lang=groovy}
	switch (game) {
	    case 'chess':
	        println 'I like to play chess'
	        break
	    case 'go':
	        println 'I can play go if you want'
	        break
	    case 'ludo':
	        println 'I can play ludo if you want'
	        break
	    default:
	        println "Sorry, I don't know how to play $game"
	}


The `switch` statement evaluates an expression - in the example above it's the value of a variable (`game`) but it could be the result of an operation. This is called the switch value.

The rest of the `switch` block is broken up into `case`s and (optionally) a `default`. Each `case` is assessed against the switch value and the first match is selected. Each case is declared:

- prefixed by the keyword `case`, followed by
  - an expression, and lastly,
    - a colon `:`

The `case` expression can be a more complex expression but in our example above I've used a string value (e.g. `chess`). If the value of `game` was `'ludo'` then the statements under `case 'ludo':` are evaluated.

The `break` statement indicates the end of the set of statements for the `case` and signals that the `switch` statement has completed. In the example above I've used `break` for every case but this isn't required. If `break` isn't provided, execution of the `switch` is said to "fall through" to the next set of statements. Essentially, Groovy will keep evaluating expressions until either a `break` is provided or the end of the `switch` block is reached.

Falling through can be useful if you want to perform the same set of statements for more than one `case`. The example snippet below provides an example of such a case (pun intended):

    case 'snowboarding':
    case 'snowball fight':
        println 'But it\'s summer!'
        break

Here's another example of falling through:

{title="Falling through",lang=groovy}
	def score = 2

	println 'You win: '

	switch (score) {
	    case 3:
	        println '- gift voucher'
	     case 2:
	        println '- toy'
	    case 1:
	        println '- stamp'
	    default:
	        println '- certificate'
	}


In the code above the prizes are accumulated depending on your `score` and a score of 2 sees you win a toy, stamp and certificate - lucky you! Our default ensures that every child wins a prize, regardless of their score.

I> It can be useful to throw a comment in when you are "falling through" so as to help confirm that you didn't just forget to put in a `break`


## The Versatile Groovy `switch`

The Groovy  `switch` statement is much more powerful than Java's and can work across all data types.

>In Java `switch` is limited to the primitive types (and their object wrappers), Strings and Enums and the `case` expression is limited to a value (not an operation).

Groovy achieves through the use of the `isCase` method defined for the `Object` class and overloaded by subclasses such as `Pattern`. Essentially, the switch value is passed to the  `case` instance. In the example below, `10.isCase(score)` would be called:

	switch (score) {
		case 10:
			//etc
	}


If this all sounds a little foreign, don't worry, just check out the following sections to see how versatile the `switch` statement can be.

## Using Ranges

Ranges can be used in the `case` and is selected when the switch value is in the range.

Let's play some blackjack:

{title="Switch with ranges",lang=groovy}
	switch (hand) {
	    case 1..16:
	        println 'HIT'
	        break
	    case 17..21:
	        println 'STAND'
	        break
	    default:
	        println 'BUST'
	        break
	}


## Using Regular Expressions

Groovy extends the Java regular expression `Pattern` class to provide for their use in `switch` statements. This can be really handy if you want to test for a number of patterns.

In the example below I set up a list of URI's[^uri] and assess them against regular expressions based on various URI formats.

T>The `each` method calls the closure for each value in a list

{title="Switch with RegEx",lang=groovy}
	def location = ['urn:isbn:0451450523',
	                'http://en.wikipedia.org/wiki/Uniform_resource_locator',
	                'HTTPS://secure.example.com/',
	                'mailto:duncan@example.com',
	                'fax:53454567567']

	location.each {
	    switch( it.toLowerCase() ) {
	        case ~/^urn:.*/ :
	            print 'This looks like a URN'
	            break
	        case ~/^https?:.*/ :
	            print 'This looks like a HTTP(S) URL'
	            break
	        case ~/^mailto:.*/ :
	            print 'This looks like an email address'
	            break
	        default:
	            print 'Not sure what this is'
	    }
	    println " ($it)"
	}


[^uri]: See http://en.wikipedia.org/wiki/Uniform_resource_identifier

## Using Class Checks

Groovy's `switch` can use a data type (Class) for comparison. Essentially, the switch will use the `instanceof` operator to compare the switch value with a class name provided in the `case`. In the example below I iterate through a list containing elements of various types. I use the `switch` statement to then determine the type of each list item:

{title="Switch with class checks",lang=groovy}
	def objList = [ 10,
	                'hello',
	                [1, 5, 8],
	                [name: 'Dave'],
	                ~/\n/
	              ]

	for (item in objList) {
	    switch (item) {
	        case String:
	            println 'You gave me a string'
	            break
	        case Number:
	            println 'You gave me a number'
	            break
	        case List:
	            println 'You gave me a list'
	            break
	        case Map:
	            println 'You gave me a map'
	            break
	        default:
	            println "Sorry, I can't handle instances of ${item.class}"
	    }
	}
