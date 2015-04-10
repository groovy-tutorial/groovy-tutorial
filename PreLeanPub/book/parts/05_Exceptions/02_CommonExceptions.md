---
title:	Common Exceptions
status:	draft
description:	Take a look at some exceptions you're likely to see through the day.
...

In the following sections we'll thrown some errors and exceptions (on purpose) so that we can check out some of the most common children of `java.lang.Throwable` you're likely to see. As a bonus we'll also discover a few approaches to avoiding them.

# java.lang.NullPointerException

The good old `NullPointerException` (NPE) will haunt your debugging sessions for years to come. Basically it means that you've tried to call a method or access a property on an object that isn't there (i.e. the variable is `null`). Let's cause an NPE - it's easy:

```groovy
def tmp = null
tmp.class
```

To avoid these, check for `null` by:

- Using the Safe Navigation operator (`tmp?.class`)
- Checking the variable with an `if` statement before trying to access it

# java.lang.AssertionError

This is an `Error`, not an `Exception` and occurs when your `assert` expression evaluates to `false`:

```groovy
assert true == false : 'This cannot be'
```

>`: 'This cannot be'` sets the error message for a failed assertion

When your Groovy assertions fail you actually seem to receive a `org.codehaus.groovy.runtime.powerassert.PowerAssertionError` - a subclass of `java.lang.AssertionError`.

The `assert` statement is usually seen in tests and small scripts. It's usually better to signal an incorrect state/situation using `throws` - more about them in a later chapter.

# java.lang.NumberFormatException

Groovy can be used as a dynamic language so there are times where you may try to do something to a value that just can't be done. Trying to convince something that it can be a number when it really can't be will give you a `NumberFormatException`:

```groovy
'Kitten' as Integer
```

If you really need a variable to be a specific type you could use the class check feature of the `switch` statement. In the code below I check if `value` is of a type within the `Number` family tree before I try to convert it to an `Integer`. If it isn't, I could `throw` and exception or handle it in some other way:

```groovy
def value = 'kitten'

switch (value) {
    case Number:
        value = value as Integer
        break;
    default:
        println 'I should throw an exception'
}
```

# groovy.lang.MissingPropertyException

This exception happens when you try to access an object's property but it doesn't have that property. In the example below, my `Person` class doesn't have a `name` property:

```groovy
class Person {}
def jim = new Person()
jim.name
```

Using `try-catch` around this sort of exception can let you [duck type](https://en.wikipedia.org/wiki/Duck_typing) - an approach that uses an object's properties and methods to determine if something is possible. 

I reckon that the `hasProperty()` method available on all Groovy objects is a cleaner approach than the `try-catch` option. We can check the object has the property before trying to use it and without causing an exception:

```groovy
class Person {}
def jim = new Person()

if (jim.hasProperty('name')) {
    jim.name
}
```

# groovy.lang.MissingMethodException

This exception appears when you call a method on an object that doesn't support the method. The lack of a `getName()` method on the `Person` class will cause an exception for poor old `jim`:

```groovy
class Person {}
def jim = new Person()
jim.getName()
```

There's no `hasMethod()` method - it's called `respondsTo()`:

```
class Person {}
def jim = new Person()

if (jim.respondsTo('getName')) {
    jim.getName()
}
```

The `respondsTo()` method just checks if the method exists but we may want to be certain that the methods exists _and_ has the parameter list we're after. To achieve this we need to call `respondsTo()` with a second parameter, a list of the method argument types we expect - `respondsTo(String name, Object[] argTypes)`.

# java.lang.IndexOutOfBoundsException

These appear when you attempt to `get()` an index from a list that isn't there. The code below attempts to get the 5th element from a 3-element list:

```groovy
def list = [0, 1, 2]
println list.get(5)
```

Note that if we'd written that code in a slightly different way, we'd get `null` returned rather than an exception raised:

```groovy
def list = [0, 1, 2]
println list[5]
```

Checking `list.size()` (or the `length` property) before trying to access is another option:

```groovy
def list = [0, 1, 2]

if (list.size() >= 5) {
    println list.get(5)
}
```

Of course the `for-in` loop will iterate through the list and not try to give you an element that isn't there. 

>The same can't be said for the C-style `for` loop or `while`

```groovy
def list = [0, 1, 2]

for (item in list) {
    println item
}
```

## java.lang.ArrayIndexOutOfBoundsException

If you just had to use an array (instead of a list) then you'll get an `ArrayIndexOutOfBoundsException` if you attempt to use an array index that isn't there:

```groovy
Integer[] nums = [0, 1, 2]
nums[5]
```

We can use the `length` property to make sure we don't try to access an element that isn't there:

```groovy
Integer[] nums = [0, 1, 2]

if (nums.length >= 5) {
    nums[5]
}
```

The `for-in` loop is also handy for staying within the bounds:

```groovy
Integer[] nums = [0, 1, 2]

for (item in nums) {
    println item
}
```