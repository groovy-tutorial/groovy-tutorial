# The basics of OO {#chbasicoo}

This chapter will provide a whirlwind tour of the various object oriented programming concepts supported by Groovy.

## Classes
Object-oriented programmers use *classes* to classify objects. As such, a class defines the fields (properties) and methods of an object.

In Groovy the `class` keyword if used when declaring a new class:

	class Person {}

T> ## Classes are types
T> The definition of the `Person` class now provides the programmer with an new reference type.

Objects consist of fields (data) and methods for interacting with that data. For example, the code below describes a `Person` class with a `name` field and a `getName` method:

{title="A basic class with a field and a method",lang=groovy}
	class Person {
	    def name

	    def getName() {
	        return this.name
	    }
	}


In order to create an instance of the `Person` class we use the `new` keyword and assign the result to a variable

	def john = new Person(name: 'John')
	println john.getName()

The call to `new Person(…)` is actually using a special method called a "constructor". Classes can define a variety of constructors to help with creating an instance and Groovy has some handy tricks we'll explore later.

Instead of using the `def` keyword the variable could be declared as being of the `Person` type:

	Person john = new Person(name: 'John')

I> ## Information hiding
I> Groovy lets you hide fields and methods from other classes through the use of the `private` and `public` keywords. This helps us improve the level of [encapsulation](https://en.wikipedia.org/wiki/Encapsulation_(object-oriented_programming)) in our implementation.
I> We'll get into this a lot more in subsequent chapters.

### Instance and Class Elements

In the `getName` method you'll notice the keyword `this` is used. You can translate `this` to mean "this instance". Groovy supports instance fields and methods - those operating on a specific instance of the class. This means that your code isolates one instance from another and prevents you from inadvertently altering instances.

Static fields and methods are also supported - these apply at a class level. By preceding a field or a method with the keyword `static` we indicate that it is relevant to all instances of the class. In the example below I set the `specie` field to be static and this means I access it at the class level by referring to `Person.specie`.

{title="Class fields use the `static` keyword",lang=groovy}
	class Person {
	    static specie = 'homo sapien'
	    def name
	}

	println Person.specie

### Constants

An (English) language lawyer might think that the keyword `static` indicates that the value of `specie` can't be changed. However, if you try `Person.specie = 'tubulidentata'` you'll see that we can turn Person into a different specie! This is definitely not what we want so we need to declare `specie` as a constant.

The `final` keyword precedes static/instance fields and methods to make them constant:

{title="Make it constant with `final`",lang=groovy}
	class Person {
	    static final specie = 'homo sapien'
	    def name
	}

### Constructors

Constructors are a special type of method that is called when a new instance is created. We saw that Groovy provides a built-in constructor when we called `new Person(name: 'John')`. This takes a map in which the keys match the fields in the `Person` object.

To define a custom constructor we define a method with the same name as the class but without the `def` preceding it. The example below declares a constructor this way (`Person(name)`):

{lang=groovy}
<<[Constructing a person](code/08/02/constructor.groovy)

T> ## The default is now lost
T> By providing our own constructor, `new Person(name: 'John')` no longer works as it did before. In fact it will now do something rather odd - it will store a Map in John's name field!

### Overloading

The overloading feature of Groovy classes allows us to create multiple versions of the same method. The parameter list for each version of the method varies to allow callers to provide either a different number of parameters (as in the example below) or with the same number of parameters but with different types. Overloading is useful but also consider using default values for parameters as this can help reduce the number of methods you need to write and maintain.

{lang=groovy}
<<[Overloading the `mean` method](code/08/02/overload.groovy)

T> ## Overloading constructors
T> Constructors are just methods so they can also be overloaded.

## Interfaces
*Interfaces* provide a method for defining programming interfaces. Interfaces, for the most part, just define method signatures and not their implementation. Classes implement these interfaces in a manner that reflect the class's role/model/context.

The example below defines an interface named `Exercise` with a single method `run`. The `Athlete` class then implements the interface:

{lang=groovy}
<<[Implementing an interface](code/08/02/interface.groovy)

## Inheritance
A *superclass* is one from which other classes inherit functionality. The "child" classes are referred to as being *subclasses*. A subclass inherits from a superclass through the use of the `extends` keyword.

In the code below, `StaffMember` is a subclass of `Person`. This allows `StaffMember` to access the `name` field defined in `Person`:

{lang=groovy}
<<[Inheritance in action](code/08/02/inheritance.groovy)

Unlike interfaces, superclasses can provide implemented methods and fields that subclasses can utilise. However, Superclasses can work somewhat like interfaces and their methods can be declared as `abstract` to force subclasses to provide their own implementation.

T> ## Multiple inheritance is not supported
T> Unlike some other OO languages (e.g. C++), Groovy does not support multiple inheritance. This means that a class cannot extend more than one superclass. However, Groovy classes can implement more than one interface.
T> Groovy does support classes implementing multiple interfaces and traits.

### Overriding methods
Subclasses can also override methods and fields implemented by superclasses. This lets subclasses provide more contextual implementations if needed. A subclass can refer directly to superclass fields and methods by using the `super` keyword.

In the example below, `StaffMember` is a subclass of `Person`. The `StaffMember` class overrides the `getName` method and prefixes a string to the `name` returned by the superclass.

{lang=groovy}
<<[Overriding methods](code/08/02/trait.groovy)

T> ## Stop the override
T> Superclass methods declared with the `final` keyword can't be overridden.

T> ## Mark the override
T> You'll notice that I put `@Override` before the `getName` method in `StaffMember`. This is a really handy annotation as it tells Groovy that the method is overriding one declared by the superclass. If I mis-spell the method name then Groovy will give me an error.

## Traits

At first glance, traits can be considered as interfaces with an implementation but they offer a really useful approach to adding features or abilities to a class. A common example may be to add the flying trait to animals or vehicles. The trait may have its own fields and/or methods.

In the example below:

1. A very basic `Project` class is defined. It just stores the project name
2. An `Agile` trait provides some basic fields used to describe an agile aspect to projects. A very basic method (`startIteration`) gives us an example method to call.
3. A `Scrum` class is defined:
	1. It extends the `Project` class
	2. It implements the `Agile` trait
	3. Two Scrum-specific fields are added (`productOwner` & `scrumMaster`)
4. I can then create an instance of `Scrum` and provide it information for both the `Project`/`Scrum` hierarchy as well as the `Agile` trait.
	1. I then call the `Agile` trait's `startIteration` method and our project is away!

{lang=groovy}
<<[Applying a trait](code/08/02/trait.groovy)


## Packages
As discussed earlier, Groovy allows programmers to group objects into `packages`. In the following snippet the `Person` class is allocated to the `myobjects` package:

{title="Put classes into packages",lang=groovy}
	package myobjects

	class Person {}

Packages are central to using others' code in your programs and allowing your code to be used elsewhere.

## Summary
This chapter has provided an extremely brief overview of object-oriented programming supported by small Groovy examples.
The following chapters in this section will explore fundamental aspects of fields and methods and the subsequent section
will dive far deeper into how to really get OO with Groovy.
