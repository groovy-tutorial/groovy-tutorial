# Interfaces

I> Interfaces are the best way to define your Application Programming Interface (API)

Interfaces provide a set of [method signatures](https://en.wikipedia.org/wiki/Type_signature) that are intended to be implemented
 by classes - they are an extremely useful construct that allows you to define a "contract" between your code and other
 developers.

Let's take a look at an example:

{title="An interface declaration",lang=groovy}
    interface SocialNetwork {
        Member friend(Member friend)
        Member unFriend(Member enemy)
    }

The syntax looks much like that of a `class` but you'll notice two key differences:

1. The keyword `interface` is used to declare an interface
1. There are two method signatures (`friend` and `unFriend`) but I haven't provided the code body for the method

That last point is an important one: interfaces don't define implementations, they are used to define an API that is implemented
 by one or more classes. Well thought out interfaces are integral to code that is easier to maintain . Some developers will start
 a new

T> Method signatures provided in an interface don't need an [access modifier](#chaccessmodifiers) - they're always
T> (and can only be) `public` - there's no use in an API that can't be implemented.

An interface can't be instantiated (e.g. `SocialNetwork network = new SocialNetwork()`) as it doesn't actually _do_ (implement) anything.
In order to implement an interface, the `implements` keyword, followed by the interface's name, is used in the `class` declaration:

{title="Implementing the interface",lang=groovy}
    class Member implements SocialNetwork {
        String name
        def friends = [] as Set

        @Override
        Member friend(Member friend) {
            friends << friend
            friend
        }

        @Override
        Member unFriend(Member enemy) {
            friends -= enemy
            enemy
        }
    }

In `class Member implements SocialNetwork` we bind the `Member` class to the `SocialNetwork` interface. This then means that
the class needs to provide implementations of the `friend` and `unFriend` methods. In the example above you'll note that I've
annotated each implemented method with `@Override`. This indicates to the Groovy compiler that those two methods are related to
method signatures from an interface that is being implemented[^class].

[^class]: It's also used for methods overriding those declared in a [superclass](#chinheritance).

Groovy (and Java) classes can implement more than one interface but listing them after the `implements` keyword - just
 use a comma (`,`) between each interface:

{title="Implementing more than one interface", lang=groovy}
    interface SocialNetwork {
        Member friend(Member friend)
        Member unFriend(Member enemy)
    }

    interface Posts {
        Map getPosts()
        void addPost(String title, String body)
    }

    class Member implements SocialNetwork, Posts {
        String name
        def friends = [] as Set
        Map posts = [:]

        @Override
        Member friend(Member friend) {
            friends << friend
            friend
        }

        @Override
        Member unFriend(Member enemy) {
            friends -= enemy
            enemy
        }

        @Override
        void addPost(String title, String body) {
            posts << [title: body]
        }
    }

Q> ##What happened to `Map getPosts()`?
Q> By declaring `Map posts = [:]` in the `Member` class, I know that Groovy will generate the associated getter for me.
Q> This will match the `Map getPosts()` signature. I could also do this explicitly and provide an `@Override` but I
Q> wanted to demonstrate the scenario.

I've provides a full code listing of the example below so that you can take this for a test spin in the groovyConsole:

{lang=groovy}
<<[Full code listing plus usage](code/09/social_network.groovy)

## Referring to objects by their interface
An interface defines _functionality_ rather than state.

In many cases you just want to interact with a specific set of an object's functionality a . Two interfaces,
`java.util.Map` and `java.util.List`, come to mind.

When declaring a variable I can provide an interface as the data type, e.g. `Map posts = [:]`. This means that I don't
really care which implementation of `Map` is assigned to `posts`, I'll only be accessing the methods declared by `Map`
(e.g. `keySet`). In a slightly more convoluted example, `Posts p = new Member()` indicates that the variable `p` is only
interested in the `Member` object's `Posts` functionality.

Whilst handy for variable declaration, referring to interfaces when defining method parameters is extremely useful as it
 makes the method more abstract.

Obviously, if you want to constrain usage to a specific implementation, you would declare that as the data type.
So if you really need the functionality of `java.util.Stack` then use that instead of `java.util.List` - just take a
moment to make sure it's really required.

## General advice
### Groovy interfaces don't allow default methods
Java interfaces allow you to provide implementation for a method. Such methods are referred to as "default methods"
as any implementing class doesn't have to provide their own implementation. This might be helpful when an interface
needs to be

Groovy's [traits]{#chtraits} gives you a neater approach to this.

### The constant interface antipattern

In my earlier examples I omitted the fact that you can declare constants in an interface. At first glance this might
sound like I've denied a useful piece of functionality but, in reality, the declaration of constants inside an interface
isn't a good idea. Consider the following example:

{title="Don't do this",lang=groovy}
    interface SocialNetwork {
        static final MAX_FRIENDS = 100

        Member friend(Member friend)
        Member unFriend(Member enemy)
    }

The example below provides a strong example as to how this is a bad idea as `MAX_FRIENDS` really is an implementation detail
and, furthermore, the `interface` construct doesn't let us actually enforce the logic. The `SocialNetwork` interface
relies on implementing classes to make the link.

If you focus your interfaces on providing method signatures, your code will be easier to maintain. When you need to define
constants, consider the following alternatives

* For enumerated constants, definitely use an [enum]{#chenums}
* If the constant is part of a class's logic, declare the constant with the class
* Consider creating a utility class that defines general constants of use in your program

## The shapes library

One interface is defined within the shapes library: `TwoDimensionalShape`. This interface provides the following method
signatures:

* `Number getPerimeter()`: will return the shape's perimeter
* `Number getArea()`: will return the shape's area
* `String getDisplayInfo()`: is used to prepare a handy description of the shape

{lang=groovy}
<<[The `TwoDimensionalShape` interface](code/09/shapes/src/main/groovy/org/groovytutorial/shapes/TwoDimensionalShape.groovy)
