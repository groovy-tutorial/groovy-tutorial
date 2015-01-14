---
title:	Quick reference guide  
description:	  
---

# Reserved Words

|---|---|---|---|---|
| abstract | as  | assert | boolean | break |
| byte \
| case \
| catch \
| char \
| class |
| const \
| continue \
| def \
| default \
| do |
| double \
| else \
| enum \
| extends \
| false |
| final \
| finally \
| float \
| for \
| goto
| if \
| implements \
| import \
| in \
| instanceof |
| int \
| interface \
| long \
| native \
| new
| null \
| package \
| private \
| protected \
| public |
| return \
| short \
| static \
| strictfp \
| super |
| switch \
| synchronized \
| this \
| threadsafe \
| throw |
| throws \
| transient \
| true \
| try \
| void
| volatile \
| while  
[Groovy's reserved words]

# Comments

| Type | Syntax |  
|  ------	| ------	|  
| Single-line	| `//comment`	|  
| Multi-line	| `/*...*/`	|  
| GroovyDoc	| `/**...*/`	| 

## GroovyDoc

|Tag	| Sample	|  Multiple| Scope	| 
| ------	| ------	|  ----------- |  -----------	| 
|@author	| `@author Fred Nurk`	| Y	| Overview, Class, Interface	| 
|@deprecated	| `@deprecated As of 1.3 - use altMeth()`	| N	| Class, Interface, Field, Constructor, Method	| 
|@throws	| `@throws java.io.FileNotFoundException`	| Y	| Constructor, Method	|  
|@param	| `@param name The name of the person`	|  Y	| Constructor, Method	| 
|@return	| `@return The sum of the squares`	| N	| Method	|  
|@see	| `@see Effective Java, 2nd edition`  \
`@see <a href="http://docs.oracle.com/javase/tutorial/">Java Tutorial</a>`  \
`@see java.lang.Object#wait`	| Y	| All

- Overview: Package-level documentation, usually stored in `overview.html`

See also: <http://docs.oracle.com/javase/1.5.0/docs/tooldocs/windows/javadoc.html>

# Variables

| Type | Examples |  
|  ------	| ------  	|  
| Boolean	| `true`, `false`	| 
| Number	| `1`, `3.14`, `1.67e-27`, `0xff` (hex), `071` (oct)	|  
| String	| `'Hello, world'`, `"Hello, world"`	|  
| List	| `[4, 'cat', myObject]`	|  
| Set	| `[4, 8, 2, 19] as Set`	|  
| Map	| `['h': 'hydrogen', 'he': 'helium']`  	|  
| Range	| `1..10`	|  
| Regular expression	| `~/<expression>/`


# Operators

## Arithmetic and Conditional Operators
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
[Table: Arithmetic and Conditional Operators]

## String Operators

|Operator(s)       |Type
|:-------------------:|:-----------| 
|`+`, `<<`	| Concatenate Operator	|   
|`<<=` `+=`	| Append Operator	|  
|`-`	| Remove Operator	| 
|`-=`	| Remove In-place Operator	|  
|`*`	| Repeat Operator	|  
|`*=`	| Repeat In-place Operator	|  
|`++` `--`	| Increment and Decrement Operators	| 
[Table: String Operators]

## Regular Expression Operators

|Operator(s)     |Type
|:------------------:|:--------------------|  
| `=~`	| Find	|  
| `==~`	| Match	|  
[Table: Regular Expression Operators]

## Collection Operators

|Operator(s)     |Type
|:------------------:|:--------------------|  
| `in`	| Membership Operator	|  
| `*`	| Spread Operator	|  
| `*.`	| Spread-Dot Operator	|  
| `..`	| Range Operator	|  
| `[]`	| Subscript Operator	|  
[Table: Collection Operators]

## Object Operators

|Operator(s)     |Type
|:------------------:|:--------------------|  
| `?.`	| Safe Navigation Operator|
| `.@`	| Field Operator	|   
| `.&`	| Method Reference	|  
| `as`	| Casting Operator	|  
| `is`	| Identity Operator	|  
| `instanceof`	| Type Comparison	|  
[Table: Object Operators]

# Loops

The following statements affect loops: 

- `break` causes the enclosing loop to complete
	- No further iterations are performed
- `continue` causes the current iteration to end and control is passed to the enclosing loop to evaluate the next iteration. 

## `for`
Groovy-style iteration:
<pre>
for (<i>[Type] parameter</i> in <i>expression</i>) {
    <i>statement(s)</i>
}
</pre>

- On the commencement of each iteration of the loop, `parameter` is assigned the next element from the iterator determined by `expression`
- A data type `[Type]` can be declared for the `parameter`

Java-style iteration:
<pre>
for (<i>Type parameter</i>: <i>expression</i>) {
    <i>statement(s)</i>
}
</pre>

- The data type for `parameter` must be declared
 
Traditional `for` loop:
<pre>
for (<i>[init_expression]</i>; <i>[expression]</i>; <i>[update_expression]</i>) {
    <i>statement(s)</i>
}
</pre>

- `init_expression` is performed before the loop starts
	- Optional
- `expression` is evaluated before each iteration. 
	- If _expression_ resolves to `false` the `for` statement is completed.
	- If _expression_ resolves to `true` the iteration commences.
	- Optional
- `update_expression` is evaluated at the completion of an iteration
	- This occurs prior to the next evaluation of `expression`
	- Optional

## `while`

<pre>
while (<i>expression</i>) {
    <i>statement(s)</i>
}
</pre>

## `do while`

This is not supported in Groovy.

# Conditional (Branching) Statements

## `if-else`

### `if`

<pre>
if (<i>expression</i>) {
    <i>statement(s)</i>
}
</pre>

Single-line version:
<pre>
if (<i>expression</i>) <i>statement</i>
</pre>

### `else`

<pre>
if (<i>expression</i>) {
    <i>statement(s)</i>
} else {
    <i>statement(s)</i>
}
</pre>

Single-line version:
<pre>
if (<i>expression</i>) <i>statement</i> else <i>statement</i>
</pre>

### `if-else-if`

<pre>
if (<i>expression</i>) {
    <i>statement(s)</i>
} else if (<i>expression</i>) {
    <i>statement(s)</i>
} else {
    <i>statement(s)</i>
}
</pre>

## `switch`
<pre>
switch(<i>expression</i>) {
    case <i>expression</i>:
	<i>statement(s)</i>
        break
    //
    default:
        <i>statement(s)</i>
}
</pre>

-  0 to _n_ `case` blocks can be used
- `break` is optional - its absence will cause fall-through to next case
- `default:` section is optional

## `try-catch-finally`

### `try-catch`
To catch any exception raised in a `try` block:
<pre>
try {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
}
</pre>

To catch a specific exception use the specific exception type:
<pre>
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} 
</pre>

Provide multiple `catch` blocks to handle different exceptions:
<pre>
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
}
</pre>

Provide a "catch-all" for unexpected exceptions:
<pre>
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
}
</pre>

### `finally`
<pre>
try {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
} finally {
    <i>statement(s)</i>
}
</pre>

# Closures

Basic form:
<pre>
<i>[assignment]</i> {
    <i>statement(s)</i>
    [return <i>statement</i>]
}
</pre>

- _[assignment]_ of the closure is to a variable, including a method parameter
	- e.g. `def myClosure = {...}`
	- e.g. `methodCall(param1){...}` 
		- ... or less often `methodCall(param1, {...})`
- The `it` parameter is implicitly provided but is not available when explicit parameters are declared
- The closure will return a result, being determined as either:
	- Explicitly declared using the `return` keyword
	- The result of the last statement evaluated in the closure 

To preclude any parameters (including `it`):
<pre>
<i>[assignment]</i> { ->
    <i>statement(s)</i>
    [return <i>statement</i>]
}
</pre>

Explicit parameter declaration:
<pre>
<i>[assignment]</i> { [Type] <i>parameter_name</i> <i>[= default_value]</i> <i>[, params</i>] ->
    <i>statement(s)</i>
}
</pre>

- The parameter's data type may be explicitly declared (`[Type]`)
	- ... but this isn't common
- 0.._n_ parameters can be declared, separated by a comma (`,`)
- A default value can be provided for the parameter (`[= default_value]`)

Variable arguments (var-arg):
<pre>
<i>[assignment]</i> { <i>[params,]</i> [Type]... <i>parameter_name</i> ->
    <i>statement(s)</i>
}
</pre>

- The var-arg parameter must be the last parameter declared

# Classes

## Fields

## Methods

