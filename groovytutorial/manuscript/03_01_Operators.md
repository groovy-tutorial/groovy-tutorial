# Operators

Groovy supports a range of operators - those you know from primary school (e.g. + and =), through to more specialised operators.  

Operators are used with values and variables and the context in which they're used will vary the resulting output. This introduction lists the range of operators available to you and the following chapters describe each in more detail.

## Arithmetic and Conditional Operators

{title="Arithmetic and Conditional Operators",width="wide"}
|Operator(s)         							  |Type|
|:-------------------------------:|:------------------------------|
|`=`	| Simple Assignment Operator|
|`!`	| Logical Complement Operator|
|`==`   `!=`	| Equality Operators|   
|`+`   `-`   `*`   `/`  `%`, `**`	| Arithmetic Operators|
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
| `instanceof`	| Type Comparison	|  


## Operator Overloading

Groovy supports something called "operator overloading" and it's possible for classes to determine how they want operators to behave. Throughout this tutorial I'll provide some examples of overloading but before we go too far, let's take a look at what "operator overloading" actually means.

The C++ language provides a mechanism for programmers to customise how operators such as `+` (plus) and `-` (minus) work. This functionality isn't provided in Java but is available to Groovy programmers. Essentially, a class can include certain methods that replace (overload) the default implementation - as such methods are tied to specific operators.

Consider the `+` operator, as seen in many great additions. You can use the operator in a statement such as `10 + 2` but you can also use the `plus` method instead: `10.plus(2)`. I'd argue (strongly) that using the `plus` method in your code will be far less readable. However, you should be able to see that using the `+` operator actually results in the `plus` method being called.

This this means that you can use operator overloading for evil - say, by creating a numerical class that ignores all mathematical sense. Aside from developer practical jokes you'll probably only use operator overloading every now and then. Where it does become extremely useful is in the core Groovy classes and the Groovy extensions to the JDK. 

In the coming chapters you'll see a range of operator usage that isn't available to the Java developer but made available through Groovy's extensions to the JDK and through the GAPI.

To highlight all of this, operator overloading can be used in classes via the methods associated in the following table:

{title="Methods for overloading operators"}
|Method|Operator|  
|:------	|:------:	|  
| plus	| `+`	|  
| minus	| `-`	|  
| div	| `/`	|  
| mod	| `%`	|  
| multiply	| `*`	|  
| power	| `**`	|  
| equals	| `==`	| 
| compareTo	| `<=>`, `>`, `<`	| 
| rightShift	| `>>`	|  
| leftShift	| `<<`	|  
| next	| `++`	|  
| previous	| `--`	|  

I>This list doesn't include all possible operators, just the main ones

Throughout this tutorial on operators I'll provide information as to how certain functionality is obtained through operator overloading. Feel free to glaze past these sections - they're mainly there to explain why/how stuff is happening.