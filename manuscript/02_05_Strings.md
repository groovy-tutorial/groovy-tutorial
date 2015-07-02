# Strings  

I> Strings are pieces of text.

There are a two main ways in which you can declare a string in Groovy: single or double quotes

{title="The String section",width="wide"}
| Method | Usage |
| ------ | ------ |	
|Single quotes (`'...'`)	| These are fixed strings and tell Groovy that the string is as we've written it (e.g. `def pet = 'dog'`). |
|Double quotes (`"..."`)	| These are called GStrings and let us interpolate (insert) variables into our string.  (e.g. `def petDescription = "My pet is a $pet"`) |
|Three single quotes (`'''...'''`)	| A multi-line fixed string  |
|Three double quotes (`"""..."""`)	| A multi-line GString  |

Here's a quick example of a fixed string and a GString in action:

{title="Fixed strings and GStrings",lang=groovy}
	def pet = 'dog'
	def petDescription = "My pet is a $pet"
	println petDescription


## Escape sequences

Strings can contain escape sequences, allowing you to use non-printable characters in your text.

{title="Escape sequences"}
|Sequence | Character  	| 
|---------|------|  
| \\n	| line feed  	| 
| \\f	| form feed  	| 
| \\r	| carriage return	| 
| \\t	| horizontal tab  	| 
| \\'	| single quote  	| 
| \\"	| double quote  	| 
| \\\\	| backslash  	| 

The line feed (`\\n`) is often used to move to a new line:

{title="The line feed",lang=groovy}
	print 'Hi \n there\n'
 

You'll notice the use of `print` in the example above - the final `\\n` performs the same as `println` and moves to a new line.

The form feed (`\\f`) and carriage return (`\\r`) aren't often used. Form feed indicates a new page and carriage return goes back to the start of the line.

The horizontal tab (`\\t`) is essentially the same as the `tab` key on your keyboard. It's useful for formatting things like tables of information:

{title="Sequences",lang=groovy}
	println 'name\tage\tcolour'
	println 'Sam\t12\tblue'
	println 'Alice\t8\tgreen'


If you wish to use a quote within your string that matches the quote type you're using to surround your string then you need to escape the internal quote using the `\` character. In the code below you can see the quotes being escaped (`\'` and `\"`):

{title="Escape, escape!",lang=groovy}
	println 'That\'s mine'
	println "I said \"NO!\""


As the backslash (`\`) is used to escape characters, it needs an escape of its own. In order to use a backslash in a string you need to double it up (`\\`) as in the example below:

{title="Backslashing",lang=groovy}
	println 'c:\\documents\\report.doc'


## GStrings
In order to have Groovy interpolate the value of a variable we use the `$` symbol in front of the variable name - as you can see with `$pet` below:

{title="GStrings",lang=groovy}
	def pet = 'dog'  
	println "I own a $pet"


This can be handy if you have a number of variables that you'd like to use in a string:

{title="Interpolating strings",lang=groovy}
	def name = 'Sally'
	def hobby = 'surfing'
	println "Did you know that $name likes $hobby?"

T> ## Avoid `+` for String concatenation
T> This helps escape the use of the addition operator (`+`) to concatenate (join) strings: 
T>	`println 'hello ' + 'world` 
T> You'll see this in a lot of Java code and I, for one, am pleased to see that Groovy lets us pretend this never happened.

GStrings also let you interpolate more complicated expressions into a string by using `${...}`. In the following example we perform a calculation within the GString:

{title="Operation in a GString",lang=groovy}
	println "10 to the power of 6 is ${10**6}"


We can also access information about a variable in the same manner:

{title="Operation in a GString",lang=groovy}
	def word = 'Supercalifragilisticexpialidocious'
	println "$word has ${word.length()} letters"


I> The code `word.length()` calls the `length` method available on a string - we'll cover what this means shortly.

## Multiline Strings

The examples given so far use short strings but longer strings would be cumbersome to type using lots of new lines. Instead, Groovy provides multiline strings - the code below declares a multiline fixed string:

{title="A Multiline string",lang=groovy}
	def poem = '''But the man from Snowy River let the pony have his head,
	And he swung his stockwhip round and gave a cheer,
	And he raced him down the mountain like a torrent down its bed,
	While the others stood and watched in very fear.'''
	
	print poem


If you run the code above you'll see that new lines are used at the correct points in the display but the first line is not quite right. You can modify this slightly and place a backslash (`\`) at the start of the string - using statement continuation for readability:

{title="Fixing the first line",lang=groovy}
	def poem = '''\
	But the man from Snowy River let the pony have his head,
	And he swung his stockwhip round and gave a cheer,
	And he raced him down the mountain like a torrent down its bed,
	While the others stood and watched in very fear.'''
	
	print poem

T> ## Use the backslash
T> Without the backslash the code above would cause a blank newline to be printed.

GStrings can also be defined using the multiline format:

{title="A multiline GString",lang=groovy}
	def animal = 'velociraptor'
	
	println """But the man from Snowy River let the ${animal} have his head,
	And he swung his stockwhip round and gave a cheer,
	And he raced him down the mountain like a torrent down its bed,
	While the others stood and watched in very fear."""


## Building Strings

Working with basic strings is fine but if you need to build up a large piece of text throughout a program they can become very inefficient. We'll look into this in the tutorial on Operators.

## Useful Methods

Strings (text) are important aspects to human-based systems so most programming languages provide a number of methods for modifying, search, slicing and dicing strings. Groovy provides a number of helpful methods you can use with strings and we'll look at just a few of them here:

* `length()` : returns the number of characters in a string
* `reverse()`: returns the mirrored version of the string
* `toUpperCase()` and `toLowerCase()`: returns the string with all of the characters converted to upper or lower case.

{title="Some String methods",lang=groovy}
	def str = 'Hello, World'
	println str.length()
	println str.reverse()
	println str.toUpperCase()
	println str.toLowerCase()


The `trim()` method returns the string with any leading and trailing whitespace removed:

{title="Trimming a String",lang=groovy}
	def str = '  Hello, World  '
	println str.trim()


The `substring` method returns a subsection of a string and can be used in two possible ways:

* Provide a start index (e.g. `substring(7)`) to get the subsection that includes that index (i.e. the 7th character in the string) through to the end of the string
* Provide a start and an end index (e.g. `substring(7, 9)`) to get the subsection that includes that start index through to the end index of the string

{title="Substrings",lang=groovy}
	def str = 'Hello, World'
	println str.substring(7)
	println str.substring(7,9)


A number of methods are provided to help you with basic searching:

* The `indexOf` and `lastIndexOf` methods return the index (location) of the specified character in the string
* `contains`, `startsWith`, and `endsWith` return `true` or `false` if the supplied parameter is located within the string

{title="Basic searching",lang=groovy}
	def str = 'Hello, World'
	
	//These methods return the index of the requested character
	println str.indexOf(',')
	println str.lastIndexOf('o')
	
	//These methods check if the string contains another string
	println str.contains('World')
	println str.startsWith('He')
	println str.endsWith('rld')


Lastly, `replace` lets us provide a string that we want to change to a new value:

{title="Replacing text",lang=groovy}
	def str = 'Hello, World'
	
	println str.replace('World', 'Fred')


Regular expressions provide a comprehensive approach to searching and manipulating strings and are covered in a an up-coming chapter. Additionally, the tutorial on Operators will look into this in more depth.
