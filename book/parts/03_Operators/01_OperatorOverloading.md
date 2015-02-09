---
title:	Operator Overloading
status:	in-progress
description:	Groovy provides a mechanism for classes to define how they respond to the various operators.
...

Groovy supports something called "operator overloading" and it's possible for classes to determine how they want operators to behave. Throughout this section I'll provide some examples of overloading but before we go too far, let's take a look at what "Operator Overloading" actually means.

The C++ language provides a mechanism for programmers to customise how operators such as `+` (plus) and `-` (minus) work. This functionality isn't provided in Java but is available to Groovy programmers. Essentially, a class can include certain methods that replace (overload) the default implementation - as such methods are tied to specific operators  

You might note that you can use the methods instead of the operators - e.g. `10.plus(2)` - but your code will be far less readable.

Whilst all of this this means that you can use operator overload for evil - say, by creating a numerical class that ignores all mathematical sense - you'll only use operator overloading sparingly. Where it does become extremely useful is in the core Groovy classes and the Groovy extensions to the JDK. 

Operator overloading can be used in classes via the following methods:

|Method|Operator|  
| :------	| :------:	|  
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

>This list doesn't include all possible operators, just the main ones

Throughout this tutorial on operators I'll provide information as to how certain functionality is obtained through operator overloading. Feel free to glaze past these sections - they're mainly there to explain why/how stuff is happening.