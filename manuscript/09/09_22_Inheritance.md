# Inheritance {#chinheritance}

Stay tuned!

All classes inherit from `java.lang.Object` but they also implement the `groovy.lang.GroovyObject` interface.

## Type Comparison

{lang=groovy}
    class Person {}

    class SuperHero extends Person {}

    assert SuperHero in Person

    def superGroovy = new SuperHero()

    assert superGroovy in SuperHero
    assert superGroovy in Person

    assert superGroovy instanceof SuperHero
    assert superGroovy instanceof Person

## Abstract classes

## Utility classes
Bloch - ch 4

## Final Classes and Methods

{lang=groovy}
<<[Classes marked `final` cannot be extended](code/09/final_class.groovy)

{lang=groovy}
<<[Methods marked `final` cannot be overridden](code/09/final_method.groovy)


{lang=groovy}
<<[Methods marked `final` cannot be overridden](code/09/final_method2.groovy)

## Composition


## Probing an object

There's a lot of information you can extract from a class and this can come in handy when something isn't working quite
right. Throughout writing this book I have used `groovyConsole` to probe classes in ways such as the following example:

{lang=groovy}

    package demo

    interface MyApi {}

    class Test implements MyApi {}

    class ExtraTest extends Test {}

    assert Test in MyApi
    assert ExtraTest in MyApi
    assert ExtraTest in Test

    println "Test.superclass: ${Test.superclass}"
    println "Test.interfaces: ${Test.interfaces}"
    println "Test.package: ${Test.package}"

    println "ExtraTest.superclass: ${ExtraTest.superclass}"
    println "ExtraTest.interfaces: ${ExtraTest.interfaces}"
    println "ExtraTest.properties: ${ExtraTest.properties}"
    println "ExtraTest.fields: ${ExtraTest.fields}"
    println "ExtraTest.methods: ${ExtraTest.methods}"

Much of this is working against `java.lang.Class` and its Groovy extensions. I just mention them here in case they could
help any diagnostic work you need to do.

## The Shapes demo
