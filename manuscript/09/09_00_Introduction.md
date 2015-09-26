-# More object-oriented programming

# Introduction

Now that you have a handle on constructing classes we'll explore the various Groovy constructs for creating a more
extensible codebase:

* Interfaces: define a set of method signatures that are then implemented by a class (or classes).
* Traits: add abilities to a class
* Inheritance: Allows a class to inherit the functionality of another class and extend it.
    * When ClassA inherits from ClassB, we say that ClassA is a _subclass_ of ClassB and that ClassB is a _superclass_ of ClassA[^wp].

First up, we'll look at how to organise your code before those classes get out of hand.

[^wp]: See: [Wikipedia: Inheritance (object-oriented programming)](https://en.wikipedia.org/wiki/Inheritance_%28object-oriented_programming%29#Subclasses_and_superclasses)

## The Shapes demo
Throughout this section I'll build up an example library for working with two-dimensional shapes. You'll see these
in each of the following chapters under the __The shapes demo__ sub-heading.

As the Shapes demo source code is laid out as a larger project and divided into packages, you won't be able to run it
via `groovyConsole`.
To support you in trying out the demo I've setup the [http://www.groovy-tutorial.org/shapes-demo/](shapes demo)
mini site. This provides a number of handy resources:

* A guide to building (compiling) the code both directly using `groovyc` and with the [http://gradle.org/](Gradle build tool).
* Links to download the code
* Various reports on the code

Once you've read through the chapters in this section, head to the [http://www.groovy-tutorial.org/shapes-demo/](shapes demo)
 mini site and give it a try.
