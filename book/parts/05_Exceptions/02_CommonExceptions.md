---
title:	Common Exceptions
status:	in-progress
description:	Take a look at some exceptions you're likely to see through the day.
...

In the following sections we'll thrown some errors and exceptions (on purpose) so that we can check out some of the most common 

# java.lang.NullPointerException

The good old `NullPointerException` will haunt your debugging sessions for years to come. Basically it means that you've tried to call a method or access a property on an object that isn't there (i.e. the variable is `null`).

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

The `assert` statement is usually seen in tests and small scripts. It's usually better to signal an incorrect state/situation using `throws`. 

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

The `respondsTo()` method just checks if the method exists but we may want to be certain that the methods exists _and_ has the parameter list we're after. To achieve this we need to call `respondsTo()` with a second parameter, a list of the method argument types we expect - `respondsTo(String name, Object[] argTypes)`

# java.lang.IndexOutOfBoundsException

 

```groovy
def list = [0, 1, 2]
println list.get(5)
```

Note that if we'd written that code in a slightly different way, we'd get `null` returned rather than an exception raised:

```groovy
def list = [0, 1, 2]
println list[5]
```

Checking `list.size()` before trying to access 

```groovy
def list = [0, 1, 2]

if (list.size() >= 5) {
    println list.get(5)
}
```

## ArrayIndexOutOfBoundsException



```groovy
Integer[] nums = [0, 1, 2]
nums[5]
```

```groovy
Integer[] nums = [0, 1, 2]

if (nums.length >= 5) {
    nums[5]
}
```