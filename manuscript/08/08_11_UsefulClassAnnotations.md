# Useful Annotations {#channotations}

I> Note to self: let annotations do my work for me

Groovy comes with a number of handy notations that let you easily customise a class without doing the hard work yourself.
This chapter will take a brief look at some of the handier annotations in the
[`groovy.tranform`](http://docs.groovy-lang.org/latest/html/gapi/groovy/transform/package-summary.html) package.

You can even write your own annotations but that's something for another book...

## ToString

The `toString()` method is used to provide a "human readable" representation of the object. It's available on all
objects and you can override it but you can also just use the `ToString` annotation to make this even easier:

{lang=Java}
<<[The ToString annotation](code/08/11/ToString.groovy)

T> Instead of using the full library path with `@groovy.transform.ToString` you can use the `import` keyword:
T>
T>  import groovy.transform.ToString
T>
T>  @ToString
T>  class Person {
T>  	//...
T>  }

`ToString` takes a few options:

* `@ToString(includeNames=true)`: will add in the property name, prefixing the property value
* `@ToString(includeFields=true)`: by default, properties are used but this adds in fields

You can use several options at once:

{lang=Java}
<<[The ToString annotation with options](code/08/11/ToString2.groovy)

## EqualsAndHashCode
Determining if two instances are equal is something you have to add in yourself. Groovy will agree that two
variables are the same if they point to the same instance of a class:

    def agentSmith1 = new Person(id: 411, name: 'Agent Smith')
    def agentSmith2 = agentSmith1
    assert agentSmith1 == agentSmith2

However, this isn't Groovy being clever, it's just seeing that `agentSmith1` and `agentSmith2` point to the same thing.
In the code below you'll see that a Person instance with the same `id` and `name` as another Person instance doesn't
automatically equate to them being equal:

{lang=Java}
<<[Same, same but not equal](code/08/11/equal.groovy)

By using the `EqualsAndHashCode` annotation I can tell Groovy that two instances of `Person` with the same `id` are actually
equal:

{lang=Java}
<<[The EqualsAndHashCode annotation](code/08/11/EqualsAndHashCode.groovy)

Equality is not always easy to determine and will depend on the context in which you're developing - my example above
is likely to cause some debate as to if matching only on `id` is enough. The `EqualsAndHashCode` annotation has a few options that are worth digging into.

T> ##HashCode?
T> A [hash code](https://en.wikipedia.org/wiki/Java_hashCode%28%29) is a number calculated from an object.
T> They're often used in [file verification](https://en.wikipedia.org/wiki/File_verification) and you may have seen
T> them when downloading files (often they're MD5 or SHA1). In Groovy/Java, an object instance can be hashed into an Integer and
T> this hash is used to help identify the instance against others.

## Canonical

The `Canonical` annotation brings together functionality from a suite of other annotations:

* `ToString`
* `EqualsAndHashCode`
* `TupleConstructor`

We've looked at these previously so let's jump to an example:

{lang=Java}
<<[The Canonical annotation](code/08/11/Canonical.groovy)

This saves you from needing to stack your annotations:

{lang=Java}
<<[Canonical combines three annotations](code/08/11/Canonical_equiv.groovy)

## Immutable

The `Immutable` annotation provides similar features as `Canonical` but locks down new instances so that they can't be changed after creation.
[Immutable objects](https://en.wikipedia.org/wiki/Immutable_object) can be very useful in systems using parallel processing or caching.

{lang=Java}
<<[You can't touch this - it will cause an exception](code/08/11/Immutable.groovy)

The code above will fail on `krusty.email = 'heyhey@example.com'` as the `Immutable` annotation marks the `email` field as `final`.
