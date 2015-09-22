-# Operators

# Introduction {#chops}

Groovy supports a range of operators - those you know from primary school (e.g. + and =), through to more specialised operators.

Operators are used with values and variables and the context in which they're used will vary the resulting output. This introduction lists the range of operators available to you and the following chapters describe each in more detail.

## Arithmetic and Conditional Operators

{title="Arithmetic and Conditional Operators",width="wide"}
|Operator(s)         							  |Type|
|:-------------------------------:|:------------------------------|
|`=`	| Simple Assignment Operator|
|`!`	| Logical Complement Operator|
|`==`   `!=`	| Equality Operators|
|`+`   `-`   `*`   `/`  `%`  `**`	| Arithmetic Operators|
|`>`   `<`   `<=`  `>=`	| Relational Operators|
|`++`  `--`	| Increment and Decrement Operators|
|`&&`  `||`   `?:`	| Conditional Operators|
|`<<`   `>>`   `>>>`   `~`   `&` `|` `^`	| Bitwise Operators|
|`+=`  `-=`  `*=`  `/=`  `&=`  `|=`  `^=`  `%=`  `<<=`  `>>=`  `>>>=`	| The Compound Assignment Operators|


## String Operators

{title="String Operators",width="default"}
|Operator(s)       |Type
|:-------------------:|:-----------|
|`+`, `<<`	| Concatenate Operator	|
|`<<=` `+=`	| Append Operator	|
|`-`	| Remove Operator	|
|`-=`	| Remove In-place Operator	|
|`*`	| Repeat Operator	|
|`*=`	| Repeat In-place Operator	|
|`++` `--`	| Increment and Decrement Operators	|

## Regular Expression Operators

{title="Regular Expression Operators"}
|Operator(s)     |Type
|:------------------:|:--------------------|
| `=~`	| Find	|
| `==~`	| Match	|


## Collection Operators

{title="Collection Operators"}
|Operator(s)     |Type
|:------------------:|:--------------------|
| `in`	| Membership Operator	|
| `*`	| Spread Operator	|
| `*.`	| Spread-Dot Operator	|
| `..`	| Range Operator	|
| `[]`	| Subscript Operator	|


## Object Operators

{title="Object Operators"}
|Operator(s)     |Type
|:------------------:|:--------------------|
| `?.`	| Safe Navigation Operator|
| `.@`	| Field Operator	|
| `.&`	| Method Reference	|
| `as`	| Casting Operator	|
| `is`	| Identity Operator	|
| `instanceof`, `in`	| Type Comparison	|


