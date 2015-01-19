---
title:	Inheritance
description:	
...


## The Object superclass

A Groovy `class` that does not explicitly `extend` another class actually subclasses the `java.lang.Object` class. This reflects Groovy's Java heritage and all objects are directly or indirectly subclasses of `Object`.

It is possible The `Person` c

```
class Person {}
println Person.superclass
```

Running the code above will cause `java.lang.Object` to be displayed. 

Just to provide a final piece of evidence, instances of `Person` can also be tested to see if they have the `Object` heritage by using the `instanceof` operator:

```
Person sam =  new Person()
assert sam instanceof Object
```

Being a subclass of `Object` means that all Groovy objects come pre-packaged with a range of handy methods. Groovy provides extra methods over Java's `Object`.

The following list provides some of these methods.

`each (closure)`
:    

`boolean equals(Object obj)`
:

`toString()`
:    

`with(closure)`
:

For a complete listing please refer to the [Object](/groovy-jdk/java/lang/Object) page in the Groovy JDK.


### Polymorphism

```
def people = [john, sally, robert]
people.each {println it.getName()}
```