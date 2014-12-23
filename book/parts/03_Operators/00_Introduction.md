---
title:	Operators
description:	Groovy supports a range of operators - those you know from primary school (e.g. + and =), through to more specialised operators.  
---

# Introduction
Operators are used with variables and the context in which they're used will vary the resulting output. This chapter purely lists the range of operators available to you and the following chapters describe each in more detail.

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