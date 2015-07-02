# Numeric Operators  

I> There are many numeric operators available in Groovy - you're likely to know many of them from your school days. 

The following chapters will describe each of the numerical operators in further detail.  In this tutorial I just lay the list of operators out for you to quickly see and then describe operator precedence - the order in which the operators are evaluated.

{title="Groovy's numerical operators",width="wide"}
|Operator(s)	| Type |
|:-------------------------------:|:------------------------------|
|`=`	| Simple Assignment Operator|
|`!`	| Logical Complement Operator|
|`==`   `!=`	| Equality Operators|   
|`+`   `-`   `*`   `/`  `%`, `**`	| Arithmetic Operators|
|`>`   `<`   `<=`  `>=`	| Relational Operators|
|`++`  `--`	| Increment and Decrement Operators|
|`&&`  `||`   `?:`	| Conditional Operators|
|`<<`   `>>`   `>>>`   `~`   `&` `|` `^`	| Bitwise Operators|
|`+=`  `-=`  `*=`  `/=`  `&=`  `|=` `^=`  `%=`  `<<=`  `>>=`  `>>>=`	| The Compound Assignment Operators|

## Operator Precedence
Operator precedence describes the order in which operators are evaluated. For example, most people know that the multiplication operator is evaluated before the addition, resulting in the following code displaying `20` (and not `60`):


	println 10 + 2 * 5


Parentheses can be used to denote the need for an operator to be evaluated first, allowing the following code to give us `60`: 

	def result = (10 + 2) * 5
	println result

I> Note that you can't write the code above as `println (10 + 2) * 5` - Groovy can't evaluate it correctly. You'd need to write it as `println ((10 + 2) * 5)`

Operators with the same (equal) precedence (e.g. `+` and `-`) are evaluated depending on their _associativity_. There are three types of associativity:

* Left-associative: where the operators are grouped left to right
* Associative: where operators are grouped arbitrarily
	* Not seen in Groovy
* Right-associative: where the operators are grouped right to left

For example, the additive operators (`+` and `-`) are left associative, meaning that they are evaluated left to right. The expression `6 + 2 - 4` is evaluated as the result of `6 + 2` minus `4`. 

I> In the `6 + 2 - 4` example the result would be the same regardless (`4`) but in other expressions the associativity does matter - consider`6 / 2 * 4`

The simple assignment operator (`=`) is right associative, resulting in the following code displaying a result of `2`:

{title="Right associativity in assignments",lang="groovy"}
	def a = 10
	def b = 5
	def c = 2
	
	a = b = c
	
	println a

T> ## This isn't typical
T> You don't tend to see code such as that given above out "in the wild"

## Order of Precedence

The order of precedence (highest to lowest) for the arithmetic operators is as follows:

{title="Numeric operator precedence",width="wide"}
|Operator| |Example|  
|:------ |:-----|:------:|  
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





