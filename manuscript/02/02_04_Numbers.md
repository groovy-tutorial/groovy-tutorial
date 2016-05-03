# Numbers

I> Groovy supports the various types of numbers that you'd expect - and makes it easy to use them. We'll take a quick look at those now but the [chapter on data types](#chdatatypes) will really get into the depths of messing around with numbers.

There are two main types of numbers you're likely to need:

* Integers (whole numbers)
* Decimals

Groovy also gives us scientific notation and other number systems and we'll take a look at how you use them.

## Integers
Integers are whole numbers and can be negative or positive:

{title="Using Integers",lang=Java}
	def age = 27
	def coldDay = -8


Groovy will also handle very large numbers:

{title="Large numbers",lang=Java}
	// 1 astronomical unit (au)
	def distanceEarthToSun = 149597870700
	def distanceNeptuneToSun = distanceEarthToSun * 30


## Decimals
Decimal numbers provide a fraction and can be negative or positive:

{title="Using decimals",lang=Java}
	def pi = 3.14159

	// Measured in celsius
	def absoluteZero = -273.15


## Scientific notation
Base-10 (decimal) scientific notation ({$$}a * 10^b{/$$}) can also be used by placing an `e` or `E` before the exponent:

{title="Using SN",lang=Java}
	def atomicMass = 1.67e-27


The next example sets the `au` variable to {$$}1.49597870700 * 10^{11}{/$$} and then checks to make sure I haven't messed up the exponent:

{title="Just a check",lang=Java}
	def au = 1.49597870700e11
	assert au == 149597870700


In the previous two examples you can see a signed (positive or negative) integer as the exponent:

* `e-27` is negatively signed
* `e11` can also be written as `e+11` and is positively signed

W> This tutorial will give you an overview that will cover most types of numbers. If you expect to be handling very large or very small numbers, and calculations with such numbers, then you really need to do some research to make sure that you don't become a victim of truncation (where parts of the number are chopped off) and other issues with precision.


## Number Systems

Most of the time we deal with decimal (base-10) numbers but there are other number systems out there. If we want to use the number 15 in base-10 we just type `15` but we can also use:

- Binary (base-2) by prefixing `0b`
	- That's a zero followed by lower-case "b"
- Octal (base-8) by prefixing `0`
	- That's just zero
- Hexadecimal (base-16) by prefixing `0x`
	- That's a zero followed by lower-case "x"

The code below illustrates the many faces of the number 15 (base-10):

{title="Different number systems",lang=Java}
	println 0b1111    //Binary
	println 15         //Decimal
	println 017       //Octal
	println 0xf       //Hexadecimal


To help you deal with long numbers Groovy lets you use underscores (`_`) to visually break up the number without changing its value:

{title="Formatting large numbers",lang=Java}
	assert 1_000_000 == 1000000
	assert 0b0001_0110_1101 == 365


Let's close with a joke:

{title="Lolz",lang=Java}
	def value = 0b10

	println "There are only $value types of people in the world - those who know binary and those who don't"


## Useful Methods and Properties

Groovy (Java) numbers trace their lineage (inherit) back to `java.lang.Number`. The `Number` class provides methods to covert between different types of numbers (integer, decimal etc) - we'll cover this in the chapter on Data Types.

Most numerical classes (e.g. `Integer`) provide the handy `max` and `min` methods that let you compare two numbers of the same numerical type:

{title="max and min",lang=Java}
	assert Integer.max(10, 2) == 10
	assert Integer.min(10, 2) == 2

