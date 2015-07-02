# Declaring Variables  

I> Let's look at how you declare a variable and what it is you're actually declaring.

Variables are (perhaps unsurprisingly), items that can change. Essentially a variable is a "box" that can hold a value. Groovy is a "dynamic language" in that it allows you to easily store and manipulate variables regardless of their value. This places it in similar company to Python and Ruby but, as a child of Java, Groovy can also operate as a "typed language". In typed languages we can specify the data type (e.g. a number or piece of text) of the variable.

Groovy lets us work in both language modes - dynamic and typed - and this flexibility makes it that much easier to use.

Groovy provides a few ways to create a variable but the best one to start with is to use the `def` keyword. In the example below I define (`def`) a new variable named `score` that can be used to hold a value later in my program:

{title="Defining a variable",lang=groovy}
	def score


In the next example I assign `score` a value of 10 and ask Groovy to display the value of `score` using `println`:

{title="Using a variable",lang=groovy}
	def score
	score = 10
	println score


Instead of declaring `score` and then assigning it the value `10` I can do this on a single line using `def score = 10`. I do just this in the example below and then change the value of `score` (it is a variable after all) - try this in your Groovy Console and the `println`s will show you the value of `score` after it's been set.

{title="Changing the value",lang=groovy}
	def score = 10
	println score
	score = 11
	println score


You'll note that the second time I use `score` I don't need the `def` prefix as I've already declared `score` and don't need to redeclare it.

If we're declaring a number of variables we could provide a `def` on each line:

{title="",lang=groovy}
	def myNumber
	def myName


Alternatively, the previous example could be represented on a single line in which each variable is separated by a comma (`,`):

{title="",lang=groovy}
	def myNumber, myName


You can assign values to variables defined on a single line:

{title="",lang=groovy}
	def number1 = 10, number2 = 20


A set of variables can be assigned values from a list (multiple assignment):

{title="Multiple assignment",lang=groovy}
	def number1, number2
	(number1, number2) = [10, 20]
	
	assert number1 == 10
	assert number2 == 20

    
In the next example a third variable is introduced but the assignment list only provides two elements. This will result in `number1` and `number2` being set but `number3` remaining without a value (`null`):

{title="Multiple assignment",lang=groovy}
	def number1, number2, number3
	(number1, number2, number3) = [10, 20]
	
	assert number1 == 10
	assert number2 == 20
	assert number3 == null


Finally, we can perform multiple assignment at the point of declaring the variables:

{title="Multiple assignment",lang=groovy}
	def (number1, number2, number3) = [10, 20, 30]
	
	assert number1 == 10
	assert number2 == 20
	assert number3 == 30


## Variable names
Variable names must meet the following criteria:

- Must start with a letter (upper-case [A-Z] or lower-case [a-z])
	   - The underscore (`_`) is also allowed but this is very strongly discouraged 
- Must only contain letters, digits (0-9) or an underscore (`_`)
	- The dollar-sign (`$`) is also allowed but very strongly discouraged 
 - Must not match a keyword (reserved word)
 
The use of literate variable names that comply to the criteria is encouraged. For example, a variable named `x` provides little information as to its role whereas `accountNumber` is likely to be clear within the context of a broader system.


# Data Types
Data types define the sort of data a variable can hold. Most programming language feature the following data types:

* Booleans
	* A logical value of `true` or `false`
* Characters and strings
	* A character is a single letter, number or symbol (e.g. `#`)
	* A piece of text is referred to as a "string"
* Numbers
	* Integers (whole numbers) both positive and negative
	* Decimals (fractional numbers) both positive and negative
* Dates and times
	* You know, like dates and times
* Lists and sets
	* A variable that holds a number of values (list)
	* A variable that holds unique values (set)
* Maps
	* A variable that holds a number of values, each referred to by a key
* Ranges
	* A numeric sequence between a start and an end value - e.g. 1 to 10

Being an object-oriented programming language, Groovy lets you also define your own  types of objects (called classes).

Groovy allows you to create and use variables without declaring a data type - often called _dynamic typing_. Java, on the other hand, uses _static typing_ and you need to tell Java the data type you want to use when declaring a variable. Once again, Groovy is flexible and lets you use dynamic or static typing (or both) in your programs.
