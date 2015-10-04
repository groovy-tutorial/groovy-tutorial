# Subclassing

As we saw in [the previous chapter](#chinheritance), the `extends` keyword announces that a class is a subtype of another:

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


* The `@Override` annotation signals that the `toString` method provided in `SuperHero` is overriding a method defined by the superclass.
    * This is a helpful annotation as Groovy will throw a compilation error if no pre-defined method signature exists - for example, if I mistyped the method as `tooString`.
    * In fact I could have used the `@Override` annotation in the `Person` class as well because `toString` is a method defined in `java.lang.Object`, the superclass for all Groovy classes.
* The `SuperHero` implementation of `toString` includes the call to `super.toString()`. The `super` keyword allows subclasses to access the superclass's methods and member variables (properties and fields) [^multitraits]

[^multitraits]: We also saw `super` in [the chapter on traits](#chtraitsmultiple) when considering a trait that implements other traits.

T> ## The importance of `java.lang.Object`
T> All classes extend from `java.lang.Object` - this is implied even when your class doesn't explicitly declare a superclass. Groovy objects also implement the `groovy.lang.GroovyObject` interface.
T>
T> You could check this by running the following code:
T> {lang="java"}
T> ~~~~~~~~~~~~~~~
T>    class TestClass {}
T>    println TestClass.interfaces
T>    println TestClass.superclass
T> ~~~~~~~~~~~~~~~

It is possible to access the superclass's constructors from within a subclass constructor:

{lang=Java}
<<[Calling `super` in a constructor](code/09/superhero_basic_constructor.groovy)

The call to `super(name)` invokes a call to the `Person(String name)` constructor and Groovy determines the matching constructor by the parameters being passed. Importantly, the call to the superclass constructor (`super()`) must occur first - before any other statements in the constructor.

## Type comparison

The `in` operator[^inopref] makes it possible to determine if class `extends` another class or `implements` an interface or a trait. The example below demonstrates a set of checks against the `SuperHero` class

{lang=Java}
    class Person {}

    interface SuperPower {}

    trait Flying implements SuperPower {}

    class SuperHero extends Person implements Flying {}

    assert SuperHero in Object
    assert SuperHero in Person
    assert SuperHero in Flying
    assert SuperHero in SuperPower

Where the example above investigates the `SuperHero` class, the example below is somewhat more useful as it checks to see what's available to a variable (`superGroovy`):

{lang=Java}
    class Person {}

    interface SuperPower {}

    trait Flying implements SuperPower {}

    class SuperHero extends Person implements Flying {}

    def superGroovy = new SuperHero()

    assert superGroovy in Person
    assert superGroovy in SuperHero
    assert superGroovy in SuperPower
    assert superGroovy in Flying

    assert superGroovy.class == SuperHero

The ability to check `superGroovy in Flying` is useful before we push `superGroovy` off a building and expect him not to hit the pavement!

[^inopref]: Refer back to the chapter on [Object Operators](#chobjectoperators)
