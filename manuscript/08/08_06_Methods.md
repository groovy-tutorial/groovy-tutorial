# Methods

Methods were covered in [their own section](#chmethods) and we just looked at getters/setters so you'd think that
we've covered it all. Well, there's a bit more to say about methods in Groovy.

In [The basics of OO](#chbasicoo) I touched on instance and class elements:

* Instance elements are properties/fields and methods that relate to a specific instance of a class
  * These are also referred to as member variables and member methods/functions
* Class elements are properties/fields and methods that relate to the class itself - not a specific instance
  * These are covered in the chapter on [Class Methods](#chclassmethods)

In the code below I have two instance properties (`name` and `email`) and an instance method (`getContact()`)

{lang=groovy}
<<[`getContact` is an instance method](code/08/06/instance.groovy)

When we look at the two instances of `People` (`jenny` and `dave`) we can see that the call to `getContact()` is specific to each
instance of the class. This means that our request for jenny's contact information doesn't return us dave's details.

T> The previous chapter on getters and setter was focused entirely on instance methods and you'll likely see that `getContact()`
T> is what I referred to as a _pseudo property_ but it's important to remember that I am actually defining a method. In the example
T> above I would normally have used `dave.contact`

There are times when we need to make sure we're specific when referring to instance elements within a class. In order to do this, we use the `this` keyword:

{lang=groovy}
<<[Using `this`](code/08/06/instance2.groovy)

In the example above I have provided a `setName(name)` method and set the instance's `name` property using `this.name = name`. This example
is demonstrating a primary use of `this`: to delineate between the method parameter and the instance property. `this` can be used for both
member variables (e.g. `this.email`) and when calling member methods (`this.setEmail()`) but is limited to elements within the class - it can't
be called from outside the class (e.g. jenny.this.setName('Jenny')).

T> If I had declared `setName(n)` I wouldn't have needed to use `this.name = n` as `name = n` would suffice.
T> However, using `name` makes for a more readable method signature so that would be my preference.

## Overloading
I've deferred a really useful method feature for this section: [method overloading](https://en.wikipedia.org/wiki/Function_overloading).
Overloading allows a class to declare a method with the same name more than once, provided each version of the method has different parameters.

I> I've deferred another method feature - overriding - to the chapter on [Inheritance](#chinheritance)

In the example below I provide two implementations of the `exercise` method: one that takes no parameters and another
that takes one parameter (`duration`).

{lang=groovy}
<<[A basic example of overloading](code/08/06/overload.groovy)

Whilst my example has just two versions of the `exercise` method, I could keep adding more
(`def exercise(duration, location)`, `def exercise(duration, location, activity)`) to cover all of the cases I need. In many cases
I'll need a baseline of functionality and, in order to save me writing this functionality into each version of `exercise`, I can
call from one method to another:

{lang=groovy}
<<[One method calling its cousin](code/08/06/overload2.groovy)

In the previous versions of `exercise` I haven't used parameter types so my overloads must be differentiated by the number of parameters
for each version of the method. However, if I provide specific parameter types I can have several variations of a method,
differentiated by the parameter types:

{lang=groovy}
<<[One method calling its cousin](code/08/06/overload3.groovy)

Whilst I could have written another `exercise` method with `exercise(Integer duration, String activity)` I have already provided
`exercise(String activity, Integer duration)` so such an addition would, at best, be redundant but could also be confusing if
each variation did something functionally different. For example, say `exercise(Integer duration, String activity)` were to be written as:

    def exercise(Integer duration, String activity) {
        println "I'll go for a $activity in $duration minutes"
    }

I can technically do this as the parameters are different to `exercise(String activity, Integer duration)` but you can see
that my intent is different to the intent seen in the other `exercise` methods. Avoid this type of coding - it really is a trap. Overloading
best works when you have the same functionality that can work with different parameters. Using overloading to provide different functionality, depending on parameters,
is likely to trip you up. Instead of overloading with that last example, I would have given the method a different signature that
better reflects what the method is doing: `delayExercise(Integer duration, String activity)`.

## Default parameter values can make this confusing

Try the code below in a groovyConsole:

{lang=groovy}
<<[A basic example of overloading](code/08/06/overload_fail.groovy)

Unfortunately that example won't even run - Groovy reports that `method "java.lang.Object exercise()" that is already defined`.
It's not always clear where this clash lays - after all, I have explicitly written two versions of `exercise`, each with a different parameter list.
However, my use of a default value for a parameter (`exercise(duration = 10)`) is implicitly defining two versions of the `exercise` method:

1. `exercise()` - this is what clashes with the explicitly declared `exercise()`
1. `exercise(duration)`

In larger classes this can get a little confusing so, when it happens to you, start looking at the overloaded methods with
 default parameter values.

## Overloading != Overriding
Before we move on, it's worth highlighting two pieces of terminology:

* **Overloading** is when a class is defined with methods with the same name but different parameters to others within the class or its superclass(es).
* **Overriding** is when a subclass redefines a method from its superclass. We'll see this in the chapter on [Inheritance](#chinheritance)

When we looked at [Operator Overloading](#choperatoroverloading) we saw that we could write a `plus` method that aligns with the
`+` operator. The _overloading_ aspect indicates that the functionality for the operator (`+`) is being defined for certain operands
 and this is using different parameter types in overloading.
