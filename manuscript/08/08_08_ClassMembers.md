# Class Methods and Fields {#chclassmethods}

In the preceding chapters we looked at _instance_ properties/fields and _instance_ methods (including constructors) -
 the components of a class that pertain to individual instantiations of the class.

Declaring a field/property  or method as static is easy, you just prepend the `static` keyword.

A single property is best shared across all instances
: This is often the case with configuration properties

The method isn't really specific to an instance
: The method

The class is really just a library of methods
: Sometimes you just need a set of utility methods

The Java libraries feature a lot of static (final) fields, including:

* `java.lang.Math.PI` and `java.lang.Math.E`
* Most numeric types, such as `Integer` feature and `MIN_VALUE` and `MAX_VALUE` to indicate their range
* A number of calendar elements in `java.util.Calendar`

Many libraries also feature static methods:

* `java.lang.Math` has a stack of handy math-related methods
*
* `java.util.UUID.randomUUID()` is handy for creating identifiers


## Static initializer blocks

The static. However, just as we saw with instance intialising, static
