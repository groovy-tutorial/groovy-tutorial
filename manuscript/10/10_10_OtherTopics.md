# Other Topics

This book can't cover everything but hopefully it's shown you a solid body of Groovy skills that will get you started. In this chapter I'll very briefly touch on a few additional items that you may be interested in and give you some links to help you research further.

## Type Checking

Groovy doesn't check data types at compile time. Thinking of Groovy as a dynamic language helps you see why this may be the case - variables could be changing types as they move through the system and my code can use approaches such as [duck typing](https://en.wikipedia.org/wiki/Duck_typing) to focus on behaviours rather than types. However, you may want to be specific about types and catch incorrect type allocations at compile time.

Consider the following code:

{lang=Java}
	class Person {
	    String id
	    Integer getId() {id}
	}

	def pete = new Person(id: 12.3)
	println pete.id

Groovy will compile this code with `groovyc` but when you try to run the code you'll get a Groovy runtime exception (`org.codehaus.groovy.runtime.typehandling.GroovyCastException`) when we try to return `12.3` from `getId` - Groovy handles converting `12.3` to the `id` field as it's a `String` but fails when trying to convert that `String` into an `Integer`. Naturally I could have written the `Person` class to be a lot more dynamic but you can also see that I've mucked around my types by declaring `id` as a `String` but return an `Integer` from its getter.

The `@groovy.transform.TypeChecked` annotation can be applied to the class to make sure types are checked at compilation time:

{lang=Java}
	@groovy.transform.TypeChecked
	class Person {
	    String id
	    Integer getId() {id}
	}

	def pete = new Person(id: 12.3)
	println pete.id

Instead of a runtime exception I now get a compile-time error for trying to return an `Integer` from `getId()`. If I only want to have
type checking performed on a specific method, I can just annotate that method:

{lang=Java}
    class Person {
        String id

        @groovy.transform.TypeChecked
        Integer getId() {id}
    }

    def pete = new Person(id: 12.3)
    println pete.id

For more information please refer to the [Static type checking](http://docs.groovy-lang.org/latest/html/documentation/#static-type-checking)
and [Type checking extensions](http://docs.groovy-lang.org/latest/html/documentation/#_type_checking_extensions) sections in the Groovy documentation.

## Static Compilation

The `@groovy.transform.CompileStatic` annotation combines the functionality of `@groovy.`\-`transform.`\-`TypeChecked` with direct method invocation. Essentially, this removes the need for the Groovy runtime to be involved when using statically compiled classes and methods.

For more information please refer to the [Static compilation](http://docs.groovy-lang.org/latest/html/documentation/#_static_compilation)
section in the Groovy documentation. [10 things your static language can't do](http://melix.github.io/blog/2014/12/10-things-static-cant-do.html), [Compiling groovy code statically](http://www.tothenew.com/blog/compiling-groovy-code-statically), and the [Java Performance Tuning Guide](http://java-performance.info/static-code-compilation-groovy-2-0/) are also good reads.

## Metaprogramming

In the Shapes demo I touched very briefly on metaprogramming when I used the `propertyMissing` method to provide properties at runtime. That only glanced the surface of what's possible and, by digging deeper you'll discover how to:

* Use the `invokeMethod` and `methodMissing` methods of `groovy.lang.GroovyObject` to let your class handle and provide methods on-the-fly
* Intercept method calls with `groovy.lang.GroovyInterceptable`
* Access another class's `MetaClass` to add methods

That last item lets you extend the functionality of existing classes - here's a silly example:

{lang=Java}
    Number.metaClass.addSeven << {
        delegate + 7
    }

    Number n = 10
    assert 27 == 20.addSeven()

For more information please refer to the [Metaprogramming](http://docs.groovy-lang.org/latest/html/documentation/#_metaprogramming) section in the Groovy documentation.

## Generics
Generics allow classes, interfaces or methods to adapt to an instance-specified data type. You most often see generics used with collections such as Lists and Maps. The following snippet uses the diamond notation (`<>`) to indicate that the `nums` list should contain subtypes of `Number`:

    List<Number> nums = [1, 2, 3, 4, 5]

However, Groovy isn't overly respectful of generics and the following also works:

    List<Number> nums = [1, 2, 3, 4, 'rabbit']

... so we can turn on type checking to catch my mistake:

    @groovy.transform.TypeChecked
    class NumberLister {
        List<Number> nums = [1, 2, 3, 4, 'rabbit']
    }

The Java Tutorial features a [section on Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html) and there's a [Generics in Java](https://en.wikipedia.org/wiki/Generics_in_Java) article in Wikipedia.

## Inner Classes
Inner classes are classes that are declared within another class. Often used to improve encapsulation, you can
sometimes cause healthy debate when you ask "should I use an inner classes or a closure?". In the example below I've decided that the `Address` inner class would be a useful way to handle the `address` field:

{title="Example inner class",lang=Java}
    import groovy.transform.ToString

    @ToString
    class Person {
        String name
        Address address

        @ToString
        class Address {
            String street
            String suburb
            String country

            String prepareMailingSticker() {
                "$name\n$street\n$suburb\n$country\n"
            }
        }

        Person(name, street, suburb, country) {
            this.name = name
            this.address = new Address(street: street, suburb: suburb, country: country)

        }

        String getMailingSticker() {address.prepareMailingSticker()}
    }

    Person phil = new Person('Phil', '12 Smith St', 'Kimba', 'Australia')
    println phil

    print phil.mailingSticker

The Groovy documentation covers [inner classes](http://docs.groovy-lang.org/latest/html/documentation/#_inner_class).

## Single abstract methods

A number of classes related to responding to events implement an interface with a Single Abstract Method (SAM). Such interfaces have one method signature defined and this is usually focused on handling an event raised by an invoking class. A common example is a class such as a `Button` that handles user events such as a mouse click - the `Button` doesn't necessarily know what you need it to do and it concerns itself more with presentation in the user interface.

Traditionally, Java developers would use what's called an [anonymous class](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html). These are just written to handle the event but, as a class, aren't useful as a more generic member of the codebase. This book hasn't delved into them but Groovy supports anonymous classes and the example below will give you an indication of what one looks like:

{lang=Java}
<<[An anonymous class as a SAM](code/10/sam_obj.groovy)

In the example above you'll see that the `window.addReceiver` method is passed an interesting piece of syntax in `new Command() {...}`. An anonymous class is declared with the `new` keyword being invoked on an existing interface or class that the anonymous class will extend and then the body of the class is provided. For SAM interfaces this is usually what you can see in the example - a single-method anonymous class. As soon as you get an even moderately functional user interface you'll start to see anonymous classes everywhere.

Luckily, Groovy allows you to use a closure _instead_ of an anonymous class for SAM interfaces and this helps unclutter the code:

{lang=Java}
<<[A closure as a SAM](code/10/sam_basic.groovy)

In the code above, Groovy transparently coerces the closure to the correct interface type. Prior to [Groovy 2.2](http://www.groovy-lang.org/releasenotes/groovy-2.2.html) you needed to _cast_ the closure to the interface through use of the `as` keyword.

    window.addReceiver { println "I just received a '$it' event" } as Command

The Groovy documentation has [a section on SAMs](http://docs.groovy-lang.org/latest/html/documentation/#closure-coercion) and Wikipedia describes the [Command Pattern](https://en.wikipedia.org/wiki/Command_pattern#Terminology) on which this model of interaction is based.

### Observable Maps

The `ObservableMap`, `ObservableList` and `ObservableSet` classes, located in the `groovy.util` package, can alert implementations of the `java.beans.PropertyChangeListener` interface when a member of the collection has changed. As `PropertyChangeListener` is a SAM interface, we can use closures:

{lang=Java}
<<[ObservableMaps - closure as a `PropertyChangeListener`](code/10/sam_map.groovy)

This models the [Observer pattern](https://en.wikipedia.org/wiki/Observer_pattern).

### Threads

The `Thread` class is used to create new execution threads in an application, allowing program tasks to work concurrently. Starting a thread requires passing the `start` method an implementation of `java.lang.Runnable` which, you guessed it, is a SAM interface:

{title="Threads - closure as a `Runnable`",lang=Java}
    println 'Start'
    new Thread().start {
        println 'This is a new thread'
    }
    println 'End'

The example above is somewhat Java-centric and Groovy's addition of a `static start(Closure closure)` method to the `Thread` class avoids the need to call `new Thread()`:

{title="Starting threads the Groovy way",lang=Java}
    Thread.start {
        println 'This is a new thread'
    }


