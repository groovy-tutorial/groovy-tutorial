---
title: 	Object Operators	
status:	in-progress
description:	
...


|Operator(s)     |Type
|:------------------:|:--------------------|  
| `?.`	| Safe Navigation Operator|
| `as`	| Casting Operator	|  
| `is`	| Identity Operator	|  
| `instanceof`	| Type Comparison	|  
| `.@`	| Field Operator	|   
| `.&`	| Method Reference	|  

The various operators available to objects are described more fully in the Objects section but here's a quick overview.

# Safe Navigation Operator

Checks to make sure that a variable isn't `null` before calling the method

Example: `myObj?.someMethod()`



# Casting Operator 

Casts a value or variable to the specified class.

Example: `num = 3.14 as Integer`

# Identity Operator

Determines if two variables are referencing the same object instance. 
:	Groovy overloads the equality operator (`==`) such that `obj1 == obj2` is equivalent to calling the `equals` method and checks if the two objects are the functionally the same. 
:	Example: `assert obj1.is(obj2)`

# Type Comparison

Used to determine if a variable is an instance of the specified class.
:	Example: `assert fred instanceof Person`

# Field Operator and Method Reference

>I won't discuss these two operators to any depth at this point. These will come up when you look at advanced object manipulation.

The Field operator (`.@`) provides direct access to an object's property (field) rather than using a getter/setter. _Use with a lot of caution or, even better, don't use it at all._

The Method Reference operator (`.&`) returns a reference to an object method. This can be handy when you'd like to use the method as a closure. This is a very useful feature so use it at will!

In the example below I describe the `Person` class. When I then create an instance called `example` you'll notice that:

- `example.name = 'Fred'` causes `setName()` to be called
- `println example.name` causes `getName()` to be called
- `example.@name = 'Jane'` and `println example.@name` both access the `name` property directly.
- `def intro = example.&introduceSelf` sets `intro` as a pointer (closure) to the `introduceSelf` method.
	- Which is then called using `intro()`

```groovy
class Person {
    def name
    
    def setName(name) {
        println 'You called setName()'
        this.name = name
    }
    
    def getName() {
        println 'You called getName()'
        return this.name
    }
    
    def introduceSelf() {
        println "Hi, my name is ${this.name}"
    }
}

def example = new Person()

//example.name actually calls the getter or setter
example.name = 'Fred'
println example.name

//example.@name directly access the field
example.@name = 'Jane'
println example.@name

//intro holds the reference to the introduceSelf method
def intro = example.&introduceSelf

//This next line calls introduceSelf()
intro()
```


