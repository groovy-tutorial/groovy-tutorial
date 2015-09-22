# Other OO Topics

This book can't cover everything but hopefully it's shown you a solid body of Groovy skills that will get you started.
In this chapter I'll very briefly touch on a few additional items that you may be interested in and give you some links
to help you research further.

## Type Checking

Groovy doesn't check data types at compile time. Thinking of Groovy as a dynamic language helps you see why this may be the case - variables could be changing types as they move through the system and my code can use approaches such as [duck typing](https://en.wikipedia.org/wiki/Duck_typing) to focus on behaviours rather than tasks. However, you may want to be specific about types and catch incorrect type allocations at compile time.

Consider the following code:

{lang=groovy}
	class Person {
	    String id
	    Integer getId() {id}
	}

	def pete = new Person(id: 12.3)
	println pete.id

Groovy will compile this code with `groovyc` but when you try to run the code you'll get a Groovy runtime exception (`org.codehaus.groovy.runtime.typehandling.GroovyCastException`) when we try to return `12.3` from `getId` - Groovy handles converting `12.3` to the `id` field as it's a `String` but fails when trying to convert that `String` into an `Integer`. Naturally I could have written the `Person` class to be a lot more dynamic but you can also see that I've mucked around my types by declaring `id` as a `String` but return an `Integer` from its getter.

The `@groovy.transform.TypeChecked` annotation can be applied to the class to make sure types are checked at compilation time:

{lang=groovy}
	@groovy.transform.TypeChecked
	class Person {
	    String id
	    Integer getId() {id}
	}

	def pete = new Person(id: 12.3)
	println pete.id

Instead of a runtime exception I now get a compile-time error for trying to return an `Integer` from `getId()`. If I only want to have
type checking performed on a specific method, I can just annotate that method:

{lang=groovy}
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

The `@groovy.transform.CompileStatic` annotation

{lang=groovy}
    @groovy.transform.CompileStatic
    class Person {
        Integer id

        Integer getId() {id}
    }

    def pete = new Person(id: 12)
    println pete.id

For more information please refer to the [Static compilation](http://docs.groovy-lang.org/latest/html/documentation/#_static_compilation)
section in the Groovy documentation. Cédric Champeau's [10 things your static language can’t do](http://melix.github.io/blog/2014/12/10-things-static-cant-do.html) and
Vinay Prajapati's [Compiling groovy code statically](www.tothenew.com/blog/compiling-groovy-code-statically) are also good reads.

## Metaprogramming

In the Shapes demo I touched very briefly on metaprogramming when I used the `propertyMissing` method to provide properties
at runtime. That only touched the surface of what's possible and, by digging deeper you'll discover how to:

* Use the `invokeMethod` and `methodMissing` methods of `groovy.lang.GroovyObject` to let you class provide methods on-the-fly
* Intercept method calls with `groovy.lang.GroovyInterceptable`
* Access another class's `MetaClass` to add methods

That last item lets you extend the functionality of existing classes - here's a silly example:

{lang=groovy}
    Number.metaClass.addSeven << {
        delegate + 7
    }

    Number n = 10
    println n.addSeven()

    println 20.addSeven()

For more information please refer to the [Metaprogramming](http://docs.groovy-lang.org/latest/html/documentation/#_metaprogramming) section in the Groovy documentation.

## Generics
Generics allow your class, interface or method to

You most often see generics used with collections such as Lists and Maps. The following uses the g

    List<Number> nums = [1, 2, 3, 4, 5]

... but this also works:

    List<Number> nums = [1, 2, 3, 4, 'rabbit']

... so we can turn on type checking to catch my mistake:

    @groovy.transform.TypeChecked
    class NumberLister {
        List<Number> nums = [1, 2, 3, 4, 'rabbit']
    }

The Java Tutorial features a [section on Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html) and
there's a [Generics in Java](https://en.wikipedia.org/wiki/Generics_in_Java) article in Wikipedia.

## Inner Classes
Inner classes are classes that are declared within another class. Often used to improve encapsulation, you can
sometimes cause healthy debate when you ask "should I use an inner classes or a closure?".

{title="Example inner class",lang=groovy}
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
