# Enums {#chenums}

Enums are a special type of class that represent an [_enumerated type_](https://en.wikipedia.org/wiki/Enumerated_type)
- they're used to define one or more constants. Sometimes people use strings for this but they aren't always the best
option for checking identifiers and enums are a nicer approach to declaring a set of constants than having lots of
`static final` variables in a class.

Booleans represent an enumerated type[^bool] that can be `true` or `false` but,
whilst these are English-language keywords, the boolean value `true` isn't a string representing the text "true":

    String t = 'true'
    Boolean b = true

    assert t == b

[^bool]: However, Boolean is a class and extends `java.lang.Object`. Enums implcitly extend `java.lang.Enum`.

So let's take a look at a very simple enum:

{lang=groovy}
<<[A basic enum](code/08/13/enum.groovy)

First up you'll see that the `enum` keyword replaces `class`. Next, I've named the enum `Months` and provided a set
of three-letter constants for each of the months in a year - these are the enum's constants. The enum's constants are
accessed using the same approach we use for static variables: `Months.JAN`. Essentially, the enum's constant is much the
same as a class's `static final` variables *but* the ability to loop through the enum with `for (month in Months) {}`
marks enums as managing a set of constants rather than individual variables/constants.

In the line `Months myMonth = Months.AUG` you'll see that enums define types but in a manner different to that we saw in classes.
The `myMonth` variable is of the enum type `Months` but we don't create the instance by calling `Months myMonth = new Months()`.
Instead, we assign `myMonth` to the value of one of the constants as `AUG` is a constant of type `Months`.

T> Check out `java.time.Month` if you need an enum for the months.

One more point before moving on, the enum constants don't have to be declared in upper-case, that's just the usual approach
and mirrors how we declared constants using the `final` modifier. It's a just a standard approach to style rather than
required by the language.

Let's take a look at another example - this time I'll create a `Gender` enum and use it in my `Person` class:

{lang=groovy}
<<[Another basic enum](code/08/13/gender.groovy)

There's probably nothing too new in that example but it helps us take a next step - to give the `Gender` enum constants a value:

{lang=groovy}
<<[Adding to the enum](code/08/13/gender2.groovy)

Describing that last example can get a litle tricky so I'm going to step through it.
First of all, I start the enum declaration as you'd expect:

    enum Gender {

Then I list the enum's constants but they look a little odd. In fact they look like constructor calls:

    MALE('male'),
    FEMALE('female')

Remember how we don't call `new Gender()`? That's because `MALE` is a analagous to single static instance of the `Gender` enum and the
call `MALE('male')` is instantiating `MALE` via the constructor. Importantly, enum constructors are called internally
by the enum and not from any external source - they're `private` to the enum. The constructor is called once for each constant.

The next part of the `Gender` enum, as listed below, declares a member variable (`value`) and the constructor sets the
variable based on the incoming parameter:

    final String value

    Gender(value) {
        this.value = value
    }

I have declared `value` to be `final` as I don't want others to change it. Whilst I could drop the `final` modifier
it's not a great idea as enums are generally seen as a constant construct.

Lastly, I provide a `toString` method that helps us when displaying an enum constant:

    @Override
    String toString() {
        value
    }

The order within an enum is important and you must put the list of constants before any other items. I generally prefer
to lay them out as follows:

1. Constants
2. Member variables
3. Constructors
4. Methods

Some enums can describe not just a set of constants but also a series of constants that are declared in order. Groovy
provides the built-in `next` and `previous` methods that help step through the constants in an enum. Let's look at a
school grades enum and the result of calling `next` on each constant:

{lang=groovy}
<<[Iterate through an enum](code/08/13/grades.groovy)

Running this script will yield:

    PASS
    CREDIT
    FAIL

Unfortunately, according to Groovy, the next highest grade after `CREDIT` is `FAIL` - the `next` function .
This next version will fix that by overriding the default behaviours for `next` and `previous`:

{lang=groovy}
<<[Enhancing the enum](code/08/13/grades2.groovy)

This approach can be really useful when dealing with constants that can be escalated. Think about examples such as
a Priority enum with constants such as `LOW`, `MEDIUM` and `HIGH` or a DeliveryTime enum with `NORMAL`, `PRIORITY` and
`EXPRESS`.

T> ## Planet enum
T> Check out the [Java Tutorial page on enums](http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
T> as it provides a very nifty use of enums to work out your weight on various planets.
