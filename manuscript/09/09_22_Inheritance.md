# Inheritance {#chinheritance}

Inheritance provides a strategy for building up new types by drawing upon existing implementations. In Groovy this focuses on the `class` structure and we can use inheritance to create a class that builds on and refines the concepts defined in another class. This approach is supported by the `interface` structure for defining programming interfaces and the `traits` structure for encapsulating abilities or features that could be applicable to one or more classes.

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

The `extends` keyword is the gateway to inheritance in Groovy and the spartan example below demonstrates a how a we declare that a class (`SuperHero`) will inherit from another class (`Person`):

{lang=Java}
    class Person {}

    class SuperHero extends Person {}

## Some inheritance theory

Before we go much further into how inheritance is undertaken I'd like to explore some background aspects that are worth your consideration.

Subclass and superclass

: When `ChildClass` inherits from `ParentClass`, we say that `ChildClass` is a _subclass_ of `ParentClass` and that `ParentClass` is a _superclass_ of `ChildClass`

Overriding

: When `ChildClass` subtypes `ParentClass` and `ChildClass` provides a method with the same signature as a method declared in `ParentClass` (or a supertype thereof and so on) then that method is said to be `overridden`.

: Overriding provides a mechanism for the subtype to provide a more specific implementation than the supertype's.

Single and multiple inheritance

: Groovy supports _single inheritance_ which means that a class can only be a subclass of a single superclass.

: Other languages, such as C++, allow for _multiple inheritance_ and this allows a class to have more than one superclass.

: Multiple inheritance can suffer from the [diamond problem](https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem) in which the multiple paths through which subtyping occurs can make it difficult to determine the origin of an overridden method.

: Groovy's class subtyping, being based in single inheritance, doesn't suffer from this problem as there is only one path back through the hierarchy.

: However, Groovy classes can implement multiple traits and this can lead to the same problems encountered in multiple inheritance. The two approaches to resolving this (manual- or automatic-resolution) were discussed in [the chapter on Traits](#chtraitsmultiple).

Implementation inheritance or interface inheritance

: Inheritance is often viewed through two facets: implementation inheritance or interface inheritance.

: __Interface inheritance__ occurs when the _implements_ keyword is used by a class to inherit an `interface`.

: __Implementation inheritance__ occurs when the _extends_ keyword is used by a class to inherit from another class.

: As an interface contains no implementation the implementing class can't be "injured" through its association with the interface unless the author of the interface changes the method signatures. This shouldn't happen if the interface is well designed. The class implementing the interface is wholly responsible for the implementation details for the interface's methods.

: A subclass can be significantly injured by changes in the superclass as implementation inheritance reuses the parent class's implementation and this is a form of [coupling](https://en.wikipedia.org/wiki/Coupling_%28computer_programming%29) that can silently introduce bugs into your program.

: The lure of reuse through implementation inheritance is often in its perceived time-saving value. However, as requirements change and the classes are [refactored](https://en.wikipedia.org/wiki/Code_refactoring) and other changes made, the use of implementation inheritance can create a house of cards. Interface inheritance, by not passing through implementation, avoids this.

: Composition can combine the benefit of reuse seen in implementation inheritance with the flexibility and independence of interface inheritance.

: Aim to use interface inheritance heavily and implementation inheritance sparingly.

Leaky abstraction

: Inheritance may help in terms of code-reuse but it's important to make sure that a class correctly encapsulates the desired concepts and doesn't suffer from implementation leakage. As a superclass gets more complex or the subtype hierarchy gets deeper, implementations from higher-level supertypes start to build up and the lower-level subclasses end up with a large number of methods that may have no utility to that class. This will also blow out the number of tests you'll need.

Composition

: The super-/sub-class association in implementation inheritance works well when the subclass truly is a refined definition (subtype) of the superclass. I find that the relationship usually breaks down once the superclass becomes quite complex and the leaks start to pour out. If you find that you're constantly changing a superclass in order to resolve issues in a subclass it's probably time to rethink the design and consider composition.

: In composition the candidate _superclass_ is used as a member variable of the candidate _subclass_. Instead of using `extends`, the subclass just declares a member variable (a property or field) that holds an instance of the candidate _superclass_. At that point the candidate _superclass_ isn't actually a superclass, it's just a member variable.

: Sometimes human language leads us astray and the notion of a `StudentClassList` makes us think that such a class could `extend` an existing `List` implementation. However, it's likely that `StudentClassList` really just needs a `List` as a member variable and will provide a set of methods to manage the business logic around the list.

: It is often safer to use composition instead of inheritance if you're considering creating a subtype for a class in a package that you don't have control over. Whilst parts of your class might just be brokering the interaction between its interface and the member variable, this is very useful if the other class changes.

: It can be tempting to use implementation inheritance to "pass down" useful instance methods. Where this occurs it's likely to be more useful take the composition approach or consider providing such methods as `static`, especially if the method logic is broadly useful.

A quick web search on these topics will yield a wealth of articles that will help you refine your practice. I'd also recommend "Effective Java (2nd edition)" by Joshua Bloch as a great starting place.
