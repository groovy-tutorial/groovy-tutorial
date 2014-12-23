---
title:	
description:	
---

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

