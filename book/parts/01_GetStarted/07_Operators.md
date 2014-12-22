---
title:	Operators  
description:	Groovy supports a range of operators - those you know from primary school (e.g. + and =), through to more specialised operators.  
...

# Groovy's operators
Operators are used with variables and the context in which they're used will vary the resulting output. This section provides an overview of all operators but will make more sense as you learn about variables and data types.


# Arithmetic and Conditional Operators


|Operator(s)         							  |Type
|:-------------------------------:|:------------------------------|
|`=`	| Simple Assignment Operator|
|`!`	| Logical Complement Operator|
|`==`   `!=`	| Equality Operators|   
|`+`   `-`   `*`   `/`  `%`, `**`	| Arithmetic Operators|
|`>`   `<`   `<=`  `>=`	| Relational Operators|
|`++`  `--`	| Increment and Decrement Operators|
|`&&`  `||`   `?:`	| Conditional Operators|
|`<<`   `>>`   `>>>`   `~`<br/>   `&` `|` `^`	| Bitwise Operators|
|`+=`  `-=`  `*=`  `/=`  `&=`  `|=`<br/> \
`^=`  `%=`  `<<=`  `>>=`  `>>>=`	| The Compound Assignment Operators|

## Operator Precedence
Operator precedence describes the order in which operators are evaluated. For example, most people know that the multiplication operator is evaluated before the addition, resulting in the following code displaying `20` (and not `60`):

```groovy
println 10 + 2 * 5
```

Parentheses can be used to denote the need for an operator to be evaluated first, allowing the following code to give us `60`: 

```groovy
def result = (10 + 2) * 5
println result
```

>Note that you can't write the code above as `println (10 + 2) * 5` - Groovy can't evaluate it correctly.

Operators with the same (equal) precedence (e.g. `+` and `-`) are evaluated depending on their _associativity_. There are three types of associativity:

* Left-associative: where the operators are grouped left to right
* Associative: where operators are grouped arbitrarily
	* Not seen in Groovy
* Right-associative: where the operators are grouped right to left

For example, the additive operators (`+` and `-`) are left associative, meaning that they are evaluated left to right. The expression `6 + 2 - 4` is evaluated as the result of `6 + 2` minus `4`. 

>In the `6 + 2 - 4` example the result would be the same regardless (`4`) but in other expressions the associativity does matter - consider`6 / 2 * 4`

The simple assignment operator (`=`) is right associative, resulting in the following code displaying a result of `2`:

```groovy
def a = 10
def b = 5
def c = 2

a = b = c

println a
```

>You don't tend to see code such as that given above out "in the wild"

### Order of Precedence

In Groovy the order of precedence (highest to lowest) is as follows:

|Operator||Example|  
| :------ | :-----	| :------:	|  
|Postfix increment and decrement	|| `n++`, `n--`	|  
|Unary operators	||	|  
||Positive and negative 	| `-10`	|  
||Prefix increment and decrement	| `++2`, `--1`	|  
||Logical complement	| `!true`	|  
||Bitwise complement	| `~0x64`	|  
|Power	|| `10**2`	|  
|Multiplicative	|| `10 * 2`, `6 / 3`	|  
|Additive	|| `5 + 5`, `10 - 2`	|  
|Shift	|| `>>`	| 
|Relational	|| `10 > 4`	|  
|Equality	|| `1 == 1`	|  
|Bitwise AND	|| `&`	|  
|Bitwise XOR	|| `^`	|  
|Bitwise OR	|| `|`	|  
|Logical AND	|| `true && false`	|  
|Logical OR	|| `true || false`	|  
|Ternary	|| `10 > 2? true: false`	|  
|Assignment (simple and compound)	|| `10 += 2`, `var = 9`	| 

{{Operators/AssignmentOperatorSimple.md}}  
{{Operators/ComplementOperator.md}}  
{{Operators/EqualityOperators.md}}  
{{Operators/ArithmeticOperators.md}}    
{{Operators/RelationalOperators.md}}  
{{Operators/IncrementDecrementOperators.md}}  
{{Operators/ConditionalOperators.md}}  
{{Operators/BitwiseOperators.md}}  
{{Operators/AssignmentOperatorsCompound.md}}  

# Regular Expression Operators

|Operator(s)     |Type
|:------------------:|:--------------------|  
| `=~`	| Find	|  
| `==~`	| Match	| 

The chapter on Regular Expressions will cover these more fully but here's a quick overview:

Find (`=~`)
:	Example: `assert 'http://www.example.com' =~ 'http://'`
:	Returns `true` if the string on the left-side contains the string on the right of the operator

Match (`==~`)
:	Example: `assert 'www.example.com' ==~ /www.\w*.com/`
:	Returns `true` if the string on the left-side matches the regular expression provided on the right of the operator

# Collection operators
|Operator(s)     |Type
|:------------------:|:--------------------|  
| `in`	| Membership Operator	|  
| `*`	| Spread Operator	|  
| `*.`	| Spread-Dot Operator	|  
| `..`	| Range Operator	|  
| `[]`	| Subscript Operator	| 

A collections is a group of items held in a variable. In Groovy we primarily use lists and maps when managing collections.

The collection operators will be covered more completely when we look at lists and maps. However, here's a quick overview:

Membership Operator (`in`)
:	`in` is used to determine if an item is "in" a list or is a key in a map
:	Example: `assert 6 in [1, 2, 6, 9]`

Spread Operator (`*`)
: 	Extracts each item in the collection
:	Helpful when you need to include a collection's individual items in another collection or when your collection can be used as parameters in a method call.
: 	Example 1 - adding one collection's items to another collection

	```groovy
	def list = [1, 2, 6, 9]
	def list2 = [*list, 12, 34]
	//Result is list2 = [1, 2, 6, 9, 12, 34]
	```
:	Example 2 - using the collection items as a parameter list

	```groovy
	def mean(num1, num2, num3) {
      (num1 + num2 + num3) / 3
	}
	def scores = [4, 8, 1]
	mean(*scores)
	```

Spread-Dot Operator (`*.`)
:	The `*.` operator calls an action (method) on each item in the collection. 
:	The spread operator makes the call using the "Safe navigation Operator" to make sure that the item isn't null. 
	_Refer to the Object Operators section for more information._
:	Example: `['carrot', 'cabbage', 'cauliflower']*.reverse()`

Range Operator (`..`)
:	Creates a list of sequential values
:	Usually seen with numbers 
:	Can be used with classes implementing `java.lang.Comparable` and providing the `next()` and `previous()` methods
:	Example: `println 1..10` _(inclusive range)_
:	Example: `println 'a'..'k'` _(inclusive range)_
:	Example: `println 1..<99` _(half-open range)_
:	Example: Can be handy when dealing with `enums`:

	```groovy
	enum Priority {
	    LOW,MEDIUM,HIGH,URGENT
	}
	
	def focus = Priority.HIGH..Priority.URGENT
	```
	
Subscript Operator (`[]`)
:	Allows you to address a position (location) in a collection instead of using the `get`/`getAt` and `put`/`putAt` methods
:	Groovy collections are zero-based - the first item in a list is at position 0 (zero)
:	Example: working with a list

	```groovy
	def scores = [5, 8, 2, 11]
	assert scores[1] == 8
	scores[3] = 18
	assert scores[3] != 11
	```

:	Example: working with a map

	```groovy
	def team = [captain: 'Bill', goalie: 'Jane', sub: 'Jim']

	//The next two statements do the same thing
	println team['goalie']
	println team.goalie
	
	// Change the sub
	team['sub'] = 'Sally'
	println team['sub']
	```


# Object Operators


|Operator(s)     |Type
|:------------------:|:--------------------|  
| `?.`	| Safe Navigation Operator|
| `.@`	| Field Operator	|   
| `.&`	| Method Reference	|  
| `as`	| Casting Operator	|  
| `is`	| Identity Operator	|  
| `instanceof`	| Type Comparison	| 

The various operators available to objects are described more fully in the Objects section but here's a quick overview.

Safe Navigation Operator (`?.`)
: 	Checks to make sure that a variable isn't `null` before calling the method
:	Example: `myObj?.someMethod()`

Field Operator (`.@`)
:	Provides direct access to an object's property (field) rather than using a getter/setter. 
:	_Use with a lot of caution or, even better, don't use at all._
:	Example: `myObj.@someField`

Method Reference (`.&`)
:	Returns a reference to the object method - can be handy when you'd like to use the method as a closure.
:	Example: `myObj.&someMethod`

Casting Operator (`as`)
:	Casts a value or variable to the specified class.
:	Example: `num = 3.14 as Integer`

Identity Operator (`is`)
:	Determines if two variables are referencing the same object instance. 
:	Groovy overloads the equality operator (`==`) such that `obj1 == obj2` is equivalent to calling the `equals` method and checks if the two objects are the functionally the same. 
:	Example: `assert obj1.is(obj2)`

Type Comparison (`instanceof`)
:	Used to determine if a variable is an instance of the specified class.
:	Example: `assert fred instanceof Person`

