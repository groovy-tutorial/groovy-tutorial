# Final Variables {#chfinal}

I> Don't go changing to try and please me (_Just the way you are, Billy Joel_)

The `final` modifier can be prefixed to a class- or instance-variable declaration so as to declare it to be immutable (something that doesn't change).
Once set, any attempt to change the value will result in `groovy.lang.ReadOnlyPropertyException` but you have to be
mindful of a few gotchas, especially with collections and objects - we'll cover these shortly.

First up, let's look at the `final` modifier in action:

{lang=Java}
<<[Class and instance usage](code/08/09/final.groovy)

In the code above I've declared one class variable (`owner`) and one instance variable (`creationDate`) as `final`.
You'll notice that I've not actually set the value for these so that's the next step. I have three options available to
me when setting the value for a `final` variable:

__Option 1: At the point of declaration (class and instance variables):__

{lang=Java}
<<(code/08/09/final_declaration.groovy)

__Option 2: In an initializer block (class and instance variables):__

{lang=Java}
<<(code/08/09/final_initializer.groovy)

__Option 3: In the constructor (instance variables only):__

{lang=Java}
<<(code/08/09/final_constructor.groovy)

Option 1 is usually best for simple assignments (such as a value or a minor expression) and Option 2 is handy if the
you need a more complicated expression or set of expressions. The third option is mainly used when the value is passed
by the client code into the constructor and then assigned to the instance variable either directly or following some evaluations.

T> ## `static final` variable names in uppercase
T> It is considered good form to use uppercase for final class variables - as seen with `static final String OWNER`.
T> For multi-word names, separate each word with an underscore, as per: `static final URL HOME_PAGE`.

## Final fields and the map-like constructor
Just remember that the map-like constructor that comes as a Groovy beans bonus won't help you with `final` variables.
The code below won't work as Groovy is not setting `creationDate` in the constructor but through the setter after
instantiating the instance:

{title="The attempt to use handy built-in approach will fail", lang=Java}
~~~~
class Record {
    final Date creationDate
}

Record myRecord = new Record(creationDate: new Date())
~~~~

## Final objects
When a variable is marked as `final` it is the value held by the variable that is immutable. This is fine for primitive values
(such as `int`) and some of the elementary classes (such as `Integer` and `String`) as their underlying value isn't changeable once
instantiated.
However, if that value points to an object that is _mutable_ (can be changed) then your class might find its variables
being changed by code outside the class. This isn't a good thing as the class should be managing its own state. Let's
take a look at how this can happen and how we can stop it.

First up, let's consider a class `FinalReport` that is meant to hold a set of `Record`s for archiving purposes. That means
 that once a `FinalReport` has been prepared, we don't want people tampering with it:

{lang=Java}
<<[First stab at a protected report](code/08/09/final_report.groovy)

First of all you'll notice the `@ToString(includeNames = true)` annotation. This is used to have a `toString()` method
generated for the class. This is really handy and I provide a description in the [Useful Annotations](#channotations) chapter.

When setting up the `FinalReport` class I dutifully set `final List records` so that the list of records is `final` but
two sections of code just blew a hole in my archive-ready report. The first one altered the text of a record in the report:

    report.records[1].text = 'REDACTED'
    println report.records[1]

The second section of code added a new record to the report:

    report.records << new Record('Record Z', 'You just go hacked')
    println report

My `FinalReport` isn't really very final and is quite open to tampering. This is one reason you write test suites for your code -
to make sure that you haven't made an incorrect assumption. Let's take a look at a more locked-down version of the previous
code:

{lang=Java}
<<[Make it all `final`](code/08/09/final_report_final.groovy)

You'll notice I've made a number of changes to really lock things down:

1. All of the properties in `Record` are now marked as `final`
    * This means that `Record` instances can't be tampered with post-creation
1. The `records` property in `FinalReport` is still marked as `final` (`final List records`)
    * This means that the `records` list can't just be swapped over for another
1. In the `FinalReport` constructor I call `asImmutable()` against the `records` parameter as this creates a copy of the list and marks it as immutable.
    * This means that the list can't have new items added or removed.

My first stab at the code assumed that `final List records` meant that the list of records couldn't be changed. This is
true to an extent - once `records` was assigned an instance of a list it couldn't be assigned another. However, it didn't mean
that the items in the list couldn't be changed or the list have items added/removed. I needed to make sure that each list item
(each being a `Record` instance) was itself locked down by making all of its properties `final`. I also needed to lock down
the list being passed to my constructor by using the `asImmutable()` method to copy the incoming list and stop it from being changed.

T> ## Defensive copies
T> Making a copy in order to protect your code is sometimes referred to as making a "defensive copy". This means that you
T> are copying an incoming parameter in case code outside your class modifies it elsewhere.

### The `@Immutable` annotation

As always, Groovy gives me a very handy approach to locking down my classes so that they're immutable. The `@Immutable`
annotation does quite a number of things for me, including:

* Makes properties `final`
* Sets up a map-based constructor and a tuple constructor (as per `@TupleConstructor`)
* Ensures that certain types of parameter (such as `Date` and collections) are defensively copied
* Prepares a `toString` method (as per `@ToString`)

So here's how our `FinalReport` code now looks with the help of `@Immutable`:

{lang=Java}
<<[Use the `@Immutable` annotation](code/08/09/final_report_immutable.groovy)

You can easily see that the code for my `FinalReport` and `Record` classes has been cut right back. This is really
helpful in many situations **but** `@Immutable` can't do everything so make sure you [read the documentation](http://docs.groovy-lang.org/latest/html/gapi/groovy/transform/Immutable.html).

### Copying and cloning {#secclone}

Just wandering a little off the `final` path, let's take a quick look at how we could defensively handle mutable objects.
Defensively copying basic objects such as `String` and `Integers` is easy as it happens at assignment time:

    Integer i = new Integer(10)
    Integer j = i
    i = 20
    assert !i.is(j)

This works because `i = 20` causes `i` to be assigned a new instance of `Integer`. Similarly, I can copy a list
of numbers quite easily:

    def yourList = [2, 4, 6]
    def myList = [*yourList]

    assert myList == yourList
    assert !myList.is(yourList)

This is all reasonably straight-forward as I'm only dealing with basic objects. However, how do I defensively copy
an object that consists of several properties/fields? Earlier, I re-programmed the `Record` class to make all of the
properties `final` and this meant that I didn't really need to defensively copy instances.
Sometimes I don't get that option, especially for existing or third-party developed classes. In such cases I have a few
options:

1. Don't copy the whole instance, just extract the fields I actually need and copy them
1. Create a new instance using the object's current state as input
1. Call the `clone()` method if one exists.

The second option is possible if I can use the object's properties to create another instance via the constructor and/or
setters:

{lang=Java}
<<[Use the object's state to instantiate a copy](code/08/09/final_clone_manual.groovy)

In the code above the `submitAssignment` method calls the `Assignment` constructor to create a new instance. This helps
make sure that the student can't mysteriously change their answers after submitting. You can see that it's a pretty simple
example and a more complex classes will make this very difficult, especially if they have internal state that is hard to
reach.

The third option is to have a class implement the `Cloneable` interface. If a third-party class provides this then you're
in luck and can make a copy (clone):

{lang=Java}
<<[Using `Cloneable`](code/08/09/final_clone.groovy)

As `Assignment` provides a `clone` method we just need to call it and we're returned a copy for our own use. Naturally,
this doesn't help us if the author of `Assignment` doesn't provide us with a `clone` method.
Check out the [Useful Annotations](#channotations) chapter for the `@Canonical` annotation.

T> ## Shallow copies vs Deep copies
T> Copying can become a very complicated procedure depending on how deeply nested classes are within classes.
T> It's worth having a quick read of Wikipedia's article on [object copying](https://en.wikipedia.org/wiki/Object_copying).

## Final classes and methods
The `final` modifier can also be used against `class` and method declarations. We'll look into this in the
[chapter on Final Classes](#chinheritancefinal)
