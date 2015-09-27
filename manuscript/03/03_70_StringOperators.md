# String Operators

I> Groovy provides a very handy set of operators for working with Strings.

You'll spend a lot of your career manipulating strings so anything that makes them less of a hassle is nice. Groovy helps you with the following operators overloaded for your string work.

{title="String operators"}
|Operator(s)       |Type
|:-------------------:|:-----------|
|`+`, `<<`	| Concatenate Operator	|
|`<<=` `+=`	| Append Operator	|
|`-`	| Remove Operator	|
|`-=`	| Remove In-place Operator	|
|`*`	| Repeat Operator	|
|`*=`	| Repeat In-place Operator	|
|`++` `--`	| Increment and Decrement Operators	|

## Concatenate Operator

The concatenate operator joins two strings together:


	println  'It was the best of times.' << 'It was the worst of times.'


The above example is rather daft as we could have just put both strings together in the same set of quotes. You're more likely to see strings added to over the course of a program:


	def quote = 'It was the best of times.'
	quote = quote << 'It was the worst of times.'
	println quote


Instead of using the concatenate you could have just used string interpolation:


	def quote = 'It was the best of times.'
	quote = "$quote It was the worst of times."
	println quote


The `+` operator is used in the same manner as `<<`:


	def quote = 'It was the best of times.'
	quote = quote + 'It was the worst of times.'
	println quote


As you'll see in later in this chapter it's best to use `<<` over `+`

### Concatenation and Types

When you concatenate a string with a number Groovy will cast the number into a string. That means you can end up with 1 + 1 = 11 as the code below demonstrates:


	assert '1' + 1 == '11'
	assert 1 + '1' == '11'


If you're really wanting to add a string to a number you need to make sure you explicitly turn the string into a number:


	assert '1'.toInteger() + 1 == 2


This may all sound a bit odd now but if you're trying to work out why your program's maths seems all wrong it's worth looking into where strings and numbers are being mashed together.

## Append Operator

The append operator (`<<=`) conflates the assignment (`=`) and concatenate operators:


	def quote = 'It was the best of times.'
	quote <<= 'It was the worst of times.'
	println quote


This saves you from having to use `quote = quote << 'It was the worst of times.'`

W> `+=` also appends but don't use it - you'll see why in a moment.

## Remove Operator

The remove operator (`-`) removes the first instance of a string or regular expression from another string. The easiest form just removes the first instance of a specific string - in the case of the example below, 'of ' is removed:


	quote = 'It was the worst of times.' - 'of '
	println quote


The example above will display `It was the worst times.`

A regular expression pattern can also be used if you want to use a pattern. In the example below, the first occurrence of "bat" or "rat" is removed, resulting in `cat  rat monkey` (_note the double space_)


	println 'cat bat rat monkey' - ~/[br]at/


## Remove In-Place Operator

Works just like the remove operator (`-`) but does the match to the variable as well as modifying it. As for the first remove example, a string can be provided for removal:


	quote = 'It was the worst of times.'
	quote -= 'of '
	println quote


...and it can also use patterns:


	def str = 'cat bat rat monkey'
	str -= ~/[br]at/
	println str


## Repeat Operator

This is a great operator for those that love repetition! Let's print out `hello` ten-times, each time one a new line:


	print 'hello\n' * 10


## Repeat In-PlaceOperator

This one applies the multiplier against the variable and stores the result back in the variable:


	def complaint = 'ow'
	complaint *= 10
	println complaint


I'll leave it to you to see what happens :)

## Increment and Decrement Operators

The increment operator will move the last character of the string to its next value:


	def str = 'hello'
	str++
	assert str == 'hellp'


The increment/decrement actually works across the Unicode character codes[^unicode] so don't expect code to just use 'a' to 'z':


	def str = 'fo%'
	str--
	assert str == 'fo$'


For a small experiment, try the following code - it will display a subset of the Unicode characters:


	//\u00A1 is the Unicode character for an inverted exclamation mark
	def chr = '\u00A1'
	for (i in 161..191) {
	    println chr
	    chr++
	}


I'm sure that this is useful somewhere.....

[^unicode]: See the [Unicode Character Code Charts](http://www.unicode.org/charts/)

## Warning: Strings Are Expensive!

Many programs build strings up over the course of their operation. This can start becoming very expensive in terms of program resources such as memory because, without the correct approach, the JVM has to copy strings to new memory locations each time you use concatenation.

Java developers turn to the `StringBuilder` and `StringBuffer` classes to make their string building more efficient. Groovy developers using dynamic types can use a few tricks to stay dynamic and ensure efficiency.

Let's take a look at two approaches to building a string. In the first example I'll use the `+=` operator and perform 1000 concatenations:

{title="Timing the `+=` concatenation",lang=Java}
	import java.text.DecimalFormat

	def quote = 'It was the best of times. It was the worst of times.\n'

	def str = ""

	def startTime = System.nanoTime()
	1000.times {
	    str += quote
	}
	def endTime = System.nanoTime()

	DecimalFormat formatter = new DecimalFormat("#,###")
	def duration = formatter.format(endTime - startTime)

	println "That took $duration nano seconds"

W> ## Timing issues
W>Timing in this manner isn't perfect as you won't get the same answer each time you run the script. However, you should notice a significant different between the two examples - enough to indicate that the second version is much more efficient.

In the next example I'll change just 1 thing: I'll use the `<<=` operator rather than `+=`:

{title="Timing the `<<=` concatenation",lang=Java}
	import java.text.DecimalFormat

	def quote = 'It was the best of times. It was the worst of times.\n'

	def str = ""

	def startTime = System.nanoTime()
	1000.times {
	    str <<= quote
	}
	def endTime = System.nanoTime()

	DecimalFormat formatter = new DecimalFormat("#,###")
	def duration = formatter.format(endTime - startTime)

	println "That took $duration nano seconds"


When I run these scripts in groovyConsole I can see that the results are very different. When I ran each test 100 times and averaged the result I got:

* Example 1 (using `+=`): 24,215,520 ns
* Example 2 (using `<<=`): 191,490 ns

To me this is evidence enough for me to use '<<=' over `+=`!

## Templates

If you find yourself building strings around boilerplate text - such as a form letter - consider using [Groovy's templating system](http://www.groovy-lang.org/templating.html).
