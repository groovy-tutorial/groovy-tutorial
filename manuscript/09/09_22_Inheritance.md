# Inheritance {#chinheritance}

Inheritance provides a strategy for building up new types by drawing upon existing implementations. In Groovy this focuses on the `class` structure and we can use inheritance to create a class that builds on and refines the concepts defined in another class. This is supported by the `interface` structure for defining programming interfaces and the `traits` structure for encapsulating abilities or features that could be applicable to one or more classes.

The options available in Groovy for combining these three structures are as follows:

* Interfaces can:
    * Implement zero or more interfaces
* Traits can:
    * Implement zero or more interfaces
    * Implement zero or more traits
* Classes can:
    * Implement zero or more interfaces
    * Implement zero or more traits
    * Extend zero or one class

The last two chapters have demonstrated use of the `implements` keyword for utilising a `trait` or an `interface`. The `extends` keyword is the gateway to inheritance in Groovy and the spartan example below demonstrates a how a we declare that a class (`SuperHero`) will inherit from another class (`Person`):

{lang=Java}
    class Person {}

    class SuperHero extends Person {}



# Some inheritance theory

Before we go much further into how inheritance is undertaken I'd like to explore some background aspects that are worth your consideration.

When ClassA inherits from ClassB, we say that ClassA is a _subclass_ of ClassB and that ClassB is a _superclass_ of ClassA. Groovy supports _single inheritance_ which means that a class can only be a subclass of a single superclass. Other languages, such as C++, allow for _multiple inheritance_ and this allows a class to have more than one superclass. Multiple inheritance can suffer from the [diamond problem](https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem) in which the multiple paths through which subtyping occurs can make it difficult to determine the . Groovy's class subtyping, being based in single inheritance, doesn't suffer from this problem as the . However, Groovy classes can implement multiple traits and this can lead to the same problems encountered in multiple inheritance. The two approaches to resolving this - manual- or automatic-resolution were discussed in [the chapter on Traits](#chtraitsmultiple).

Inheritance helps in terms of code-reuse but it's important to make sure that a class correctly encapsulates the desire concepts and doesn't suffer from implementation

Inheritance is often viewed through two facets: implementation inheritance or interface inheritance.

# Subclassing

As we saw in the introduction to this chapter, the `extends` keyword announces that a class is a subtype of another:

{lang=Java}
    class Person {}

    class SuperHero extends Person {}

Let's put something a little more useful together:

{lang=Java}
<<[Name that super hero](code/09/superhero_basic.groovy)

In the expanded example you can see the following:

* The `Person` class is much like we've seen previously - it provides a `name` property and a `toString()` method
* `SuperHero` extends `Person`:
    * By extending `Person`, the SuperHero class has (inherits) the `name` property
    * `SuperHero` also has a `superHeroName` property
    * An implementation of `toString()` is provided to give more details about the hero

In order to create a new instance of `SuperHero`, the Groovy-supplied constructor is called and the `name` and `superHeroName` properties set:

    new SuperHero(name: 'Gary Grails', superHeroName: 'Groovy Man!')

The script will output:

    Name: Groovy Man! (alias: Gary Grails)

At this point the `SuperHero` class demonstrates two aspects of inheritance:

* Subclasses inherit the superclass's properties and these are accessible to the subclass's instances
* By providing a `toString` method that has the same signature as the superclass, `SuperHero` is said to `override` the supertype's declaration of the method.

The next example builds just slightly on the previous:

{lang=Java}
<<[Calling `super` on a SuperHero](code/09/superhero_basic_super.groovy)

The script will output:

    Name: Groovy Man!
    Alias:
      Name: Gary Grails



* The `@Override` annotation signals that the `toString` method provided in `SuperHero` is overriding a method defined by the supertype.
    * This is a helpful annotation as Groovy will throw a compilation error if no pre-defined method signature exists - for example, if I mistyped the method as `tooString`.
    * In fact I could have used the `@Override` annotation in the `Person` class as well because `toString` is a method defined in `java.lang.Object`, the superclass for all Groovy classes.
* The `SuperHero` implementation of `toString` includes the call to `super.toString()`. The `super` keyword allows subclasses to access the superclass's methods and member variables (properties and fields) [^multitraits]

[^multitraits]: We also saw `super` in [the chapter on traits](#chtraitsmultiple) when considering a trait that implements other traits.

## The importance of `java.lang.Object`

All classes inherit from `java.lang.Object` but they also implement the `groovy.lang.GroovyObject` interface.

# Final Classes and Methods

{lang=Java}
<<[Classes marked `final` cannot be extended](code/09/final_class.groovy)

{lang=Java}
<<[Methods marked `final` cannot be overridden](code/09/final_method.groovy)


{lang=Java}
<<[Methods marked `final` cannot be overridden](code/09/final_method2.groovy)


# Abstract classes


Before committing to an abstract class it'd be well worth your time determining if a combination of an interface and a "base" class or an interface and a trait wouldn't be more flexible.

## Type Comparison

{lang=Java}
    class Person {}

    class SuperHero extends Person {}

    assert SuperHero in Person

    def superGroovy = new SuperHero()

    assert superGroovy in SuperHero
    assert superGroovy in Person

    assert superGroovy instanceof SuperHero
    assert superGroovy instanceof Person

Whilst XXX, it's almost always a better idea to use interfaces as your type definitions

# Inheritance and access modifiers


# Composition



This can start to get even more abstract if we consider that a superhero has their hero identity (_Groovy Man!_) and their secret identity (_Gary Grails_). The approach to modelling this could be pondered in a number of ways:

* A super hero is just an advanced person so they inherit the person's properties and methods and extend them with additional abilities. This would mean that we use subclassing.
* The super hero abilities are just that - encapsulated abilities - and we could enhance a class with one or more traits.
* At their core, _Gary Grails_ and _Groovy Man!_ are two different people within a single physical body and should be described as an entity composed of two people.

This is all very deep and meaningful stuff and, whilst my example isn't overly serious, is what makes the design of software both extremely interesting and somewhat frustrating. My approach would normally be to write some prototype classes and traits and see how well they hold together as you delve into the concepts. Many times you'll find there's no perfect answer, just a less fragile one.

# The Shapes demo - Inheritance

The class hierachy for the Shapes demo is provided below:

![The Shapes Demo class diagram](images/ClassDiagram.png)

Inheritance is used in a number of places:

* The `Square` class is a subtype of `Rectangle` as squares are a special type of rectangle in which all four sides have the same length.
    * `Square` doesn't need to do much over the already provided `Rectangle` class
* The `Triangle` class is extended by two subtypes: `TriangleRightAngled` and `TriangleIsosceles`
    * `TriangleEquilateral` is a subtype of `TriangleIsosceles`

The three `Triangle` subtypes encapsulate specific refinements such as the definition of the sides and refinement of the `calculateArea` calculation. By making `calculateArea` a `static` method, each subtype makes the calculation easily available to other code as well as tying the `calculateArea` instance method to the static method.

The `Square`, `TriangleRightAngled` and `TriangleEquilateral` classes are both declared as `final` because I decided they couldn't be refined any further. This is an important aspect to designing/developing classes: only allow for inheritance if you will support it. By marking these classes as `final` I've indicated that the implementations can't/shouldn't be further enhanced. Naturally, another developer could `extend Triangle` with their own implementation as it isn't marked as `final` because I believe `Triangle` to be a sound generic basis for describing triangles.

Q> ## Was `TriangleSubtype` a good name/approach for a `trait`?
Q> I wanted subclasses of `Triangle` to provide a specific `getTriangleType()` implementation and considered two other options:
Q>
Q> * I could have created a `TriangleSubclass` that extended `Triangle` and was, in turn, extended by specific subclasses. However, this just felt like an odd "shim" in the class hierarchy so I decided against it.
Q> * A `TriangleSubtype` `interface` might have been a better idea but I felt that the actual implementation of the `getTriangleType` wouldn't need to be adapted by a subclass.
Q>
Q> I'm not really happy with `TriangleSubtype` but it helped me demonstrate `@SelfType` and the use of a `trait` to provide a default implementation similar to the functionality available in Java interfaces.

The Shapes demo doesn't declare any abstract classes.
