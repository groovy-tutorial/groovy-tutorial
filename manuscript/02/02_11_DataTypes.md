# Data types {#chdatatypes}

I> Groovy does a good job of working out what sort of variable you're using (numbers, strings, booleans etc) but let's look at what's going on under the hood.

Groovy does not preclude the programmer from explicitly declaring a data type, particularly when it would be pertinent to constrain the values being managed. Furthermore, knowledge of data types is very useful for a number of reasons:

 1. Use of JVM-compatible libraries may require knowledge of the data types required by method calls.
	 - Important if you want to mine the rich collection of existing Java libraries
 2. Conversion between different data types (such as decimal numbers to whole numbers) can cause truncation and other (perhaps unexpected) results.
	 - Essential knowledge if your program relies on calculations

Most of Java's "core" classes (types) are defined in the `java.lang` package. Groovy enhances some of these in the GDK to give you extra flexibility.

## Groovy's use of types
The table below illustrates Groovy's selection of a data type based on a literal value:

{title="Groovy's use of types"}
|Value  |Assigned Type|
|:------|:------------|
|`true`|java.lang.Boolean|
|`'a'`|java.lang.String|
|`"This is a String"`|java.lang.String|
|`"Hello ${Larry}"`|org.codehaus.groovy.runtime.GStringImpl|
|`127`|java.lang.Integer|
|`32767`|java.lang.Integer|
|`2147483647`|java.lang.Integer|
|`9223372036854775807`|java.lang.Long|
|`92233720368547758070`|java.math.BigInteger|
|`3.14`|java.math.BigDecimal|
|`3.4028235E+38`|java.math.BigDecimal|
|`1.7976931348623157E+308`|java.math.BigDecimal|

It is important to note that the type is selected at each assignment - a variable that is assigned a string such as `"Hello"` is typed as `java.lang.String` but changes to `java.lang.Integer` when later assigned the value `101`.

## Using a specific type
A variable can be declared as being of a specific data type. When using a type, drop the `def` keyword:

{title="Declaring a variable using a specific type",lang=Java}
	Integer myNum = 1
	String myName = "Fred nurk"


Suffixes can also be used if you want to be really specific about the data type Groovy is to use for a number. When using suffixes you use the def keyword to define the variable: `def dozen = 12i`

{title="Type suffixes supported by Groovy"}
|Suffix|Type|Example|
|:------:|:------|:------:|
| `I` or `i`| Integer	| `12i`	|
| `L` or `l`| Long	| `23423l`	|
|`F` or `f`	| Float	| `3.1415f`	|
|`D` or `d`	| Double	| `3.1415d`	|
|`G` or `g`	| BigInteger	| `1_000_000g`	|
|`G` or `g`	| BigDecimal	| `3.1415g`	|

You may have noticed that BigInteger and BigDecimal have the same suffix - this isn't a typo - Groovy works out which one you need simply by determining if the number is a whole number (BigInteger) or a decimal (BigDecimal).

If you're going to use explicit types then you need to know limitations of that type. For example, the following code will fail:

    assert 3.1415926535f == 3.1415926535d

This failure occurs because Float will shorten (narrow) the value to `3.1415927` - not a mistake you'd want to make when measuring optics for your space telescope! You can see which type Groovy will use automatically by running this snippet of code:


	println 3.1415926535.class.name



## The `null` Value
Variables that are not assigned a value at declaration are provided a `null` value by default. This is a special reference that indicates the variable is devoid of a value.

Variables can be explicitly assigned `null`:

    def id = null

## Available data types
As Groovy imports the `java.lang` package as well as the `java.math.BigDecimal` and `java.math.BigInteger` classes by default, a range of data types are available for immediate use:

 - `Boolean`: to store a logical value of `true` or `false`
 - Numbers (based on `java.lang.Number`):
	- `Byte`
	- `Short`
	- `Integer`
	- `Long`
	- `Float`
	- `Double`
	- `BigDecimal`
	- `BigInteger`
 - `Character`: A single character such as a letter or non-printing character
 - `String`: A regular Java-esque piece of text
 - `GString`: A Groovy string that allows for interpolation
 - `Object`: This is the base class for all other classes
 - `Closure`: The class that holds closure values

The types listed above are often referred to as _reference types_, indicating that they relate to a class definition. Groovy also provides a set of _primitive types_ that are more closely aligned to the C programming language than an object-oriented language such as Java and Groovy.

### Primitive types
The table below maps the types defined in `java.lang` against their equivalent primitive types:

{title="The primitive types"}
|Type     |Primitive type| Value range                                             |Size (bits) |
|:--------|:-------------|:--------------------------------------------------------|:----------:|
|Boolean  |`boolean`     |`true` or `false`                                        |-           |
|Byte     |`byte`        |-128 to 127, inclusive                                   |8           |
|Short    |`short`       |-32768 to 32767, inclusive                               |16          |
|Character|`char`        |'\u0000' to '\uffff' inclusive                           |16          |
|Integer  |`int`         |-2147483648 to 2147483647, inclusive                     |32          |
|Long     |`long`        |-9223372036854775808 to 9223372036854775807, inclusive   |64          |
|Float    |`float`       |32-bit IEEE 754 floating-point numbers                   |32          |
|Double   |`double`      |64-bit IEEE 754 floating-point numbers                   |64          |

You can check those value ranges by using the `MIN_VALUE` and `MAX_VALUE` constants available on the various classes representing numbers:

{title="Determining value range",lang=Java}
	println Integer.MIN_VALUE
	println Integer.MAX_VALUE
	println Float.MIN_VALUE
	println Float.MAX_VALUE


As an object-oriented language Groovy also provides a mechanism for declaring new data types (objects) that extend and encapsulate information to meet a range of requirements. These implicitly extend the `java.lag.Object` class.

I> ## Autoboxing
I> _Autoboxing_ refers to the automatic conversion of a primitive type to a reference type. _Unboxing_ is the reverse of _Autoboxing_.

## Type Conversions

Groovy will convert values assigned to variables into the variable's declared data type. For example, the code below declares a variable of type "String" and then assigns it 3.14 (a number). The assertion that the variable remains of type "String" will succeed, indicating that `3.14` was converted to a String value by Groovy before being assigned to the `myName` variable.

{title="Checking the type",lang=Java}
	String myName = "Fred nurk"
	myName = 3.14
	assert myName.class == java.lang.String


Care must be taken to not rely totally on this automatic conversion. In the example below the assertion will fail as the `myPi` variable is declared as an `Integer` and the assignment drops the fractional component of `3.14`:


	def pi = 3.14
	Integer myPi = pi
	assert myPi == pi


### Casting

The `as` operator can be used to cast (change) a value to another class.

{title="Casting",lang=Java}
	def pi = 3.1415926535 as Integer
	assert 3 == pi

T> You've seen this before... `def myGroceries = ['milk', 'honey'] as Set` - this is actually just casting the list to the `Set` data type.

This will be discussed further in the [Object Operators tutorial](#chobjectoperators).

### Converting Numbers

`java.lang.Number` provides a number of methods for converting numbers between the various numerical data types:

* `byteValue()`
* `doubleValue()`
	* also `toDouble()`
* `floatValue()`
	* also `toFloat()`
* `intValue()`
	* also `toInteger()`
* `longValue()`
	* also `toLong()`
* `shortValue()`
* `toBigInteger()`
* `toBigDecimal()`

Here's a small example of grabbing the whole (integer) component from a number:

{title="Getting the integer",lang=Java}
	def pi = 3.1415926535
	assert 3 == pi.intValue()
	assert 3 == pi.toInteger()
