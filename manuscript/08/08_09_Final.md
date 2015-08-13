# Final Variables {#chfinal}

I> Don't go changing to try and please me (_Just the way you are, Billy Joel_)

The `final` modifier can be prefixed to a class or instance variable declaration so as to declare it to be a constant.
Once set, any attempt to change the value will result in `groovy.lang.ReadOnlyPropertyException` but you have to be
mindful of a few gotchas, especially with collections and objects.

First up, let's look at the `final` modifier in action:

{lang=groovy}
<<[Class and instance usage](code/08/09/final.groovy)

In the code above I've declared one class variable (`owner`) and one instance variable (`creationDate`) as `final`.
You'll notice that I've not actually set the value for these so that's the next step. I have three options available to
me when setting the value for a `final` property

At the point of declaration (class and instance variables):
:
{lang=groovy}
<<(code/08/09/final_declaration.groovy)

In an initializer block (class and instance variables):
:
{lang=groovy}
<<(code/08/09/final_initializer.groovy)

In the constructor (instance variables only):
:
{lang=groovy}
<<(code/08/09/final_constructor.groovy)

## Final fields and the map-like constructor
Just remember that the map-like constructor that comes as a Groovy beans bonus won't help you with `final` variables.
The code below won't work as Groovy is not setting `creationDate` in the constructor but through the setter after
instantiating the instance:

{title="The attempt to use handy built-in approach will fail", lang=groovy}
~~~~
class Record {
    final Date creationDate
}

Record myRecord = new Record(creationDate: new Date())
~~~~

Be warned with the map-based approach to creating new instances as they don't really call a special constructor and
won't work against `final` properties.

## Final collections
But for collections....

{lang=groovy}
<<[This may surprise you](code/08/09/collection.groovy)

This will stop Duncan:

{lang=groovy}
<<[Really make that collection final](code/08/09/collection_immutable.groovy)

## Final objects

{lang=groovy}
<<[First stab at a protected report](code/08/09/final_report.groovy)

{lang=groovy}
<<[Make it all `final`](code/08/09/final_report_final.groovy)

{lang=groovy}
<<[Use the `@Immutable` annotation](code/08/09/final_report_immutable.groovy)

### Cloning

{lang=groovy}
<<[TODO](code/08/09/final_clone_manual.groovy)

{lang=groovy}
<<[TODO](code/08/09/final_clone.groovy)

## Final parameters



## Final classes and methods
The `final` modifier can also be used against `class` and method declarations. We'll look into this in the
[chapter on inheritance](#chinheritance)
