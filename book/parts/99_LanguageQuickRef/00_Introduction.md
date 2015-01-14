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

## `for`

## `while`

## `do while`

This is not supported in Groovy.

# Conditional (Branching) Statements

## `if-else`

## `switch`

## `try-catch-finally`


# Closures


# Classes

## Fields

## Methods

