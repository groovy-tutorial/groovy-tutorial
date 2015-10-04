# Abstract classes

When a class is marked with the `abstract` modifier it cannot be instantiated. The code below will cause a compilation error:

{lang=Java}
    abstract class Thing {}

    def myObj = new Thing()

The main reason you would create an `abstract` class is to establish a base class for a number of subclasses. This is somewhat similar to an interface as abstract classes usually also define one or more method signatures that need to be implemented. Unlike interfaces, abstract classes can provide a mix of method signatures and method implementations.

T> ## Concrete classes
T> Classes providing the implementation of an abstract class or an interface are often referred to as "concrete" classes. These implementation classes often bear the same name as the abstract class/interface but add the suffix `Impl` or just `I`. For example, my concrete implementation of `Thing` could be called `ThingImpl` - it's purely a naming strategy and up for debate.

The `abstract` modifier can be attached to a method signature to indicate that a subclass will need to provide an implementation for the method. A class containing an abstract method must also be marked as `abstract`. In the code below, the abstract `Thing` class provides an abstract `describe()` method signature which is then implemented in the `Blob` subclass:

{lang=Java}
<<[Abstract class/method example](code/09/abstract_blob.groovy)

Some things to keep in mind:

* Abstract classes can implement interfaces and traits
    * The abstract class may choose not to provide an implementation of some or all of the interface methods - any missing implementations must be provided by the class extending the abstract class.
* You can provide class (static) methods in an abstract class - however, `static` methods can't be abstract.
* An abstract class can extend (subclass) another abstract class
    * The subclass doesn't need to implement any/all of the abstract methods of the superclass - the responsibility is passed down to a non-abstract subclass
     * This option is rarely useful and interfaces are likely to be a better approach

Before committing to an abstract class it'd be well worth your time determining if a combination of an interface and a "base" concrete class; or an interface and a trait; or just an interface; wouldn't be more flexible. If you're wanting to create a _subtype_ then it'd be worth using an interface for this purpose and then implementing a concrete base class. In some cases an abstract class is just used to provide class methods but it is likely that a utility class containing these methods is a better idea.
