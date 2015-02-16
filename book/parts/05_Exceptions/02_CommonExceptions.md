---
title:	Common Exceptions
status:	in-progress
description:	
...

Whilst you can write your own Exceptions (they're just objects after all), you should look to the pre-packaged ones and see if they meet your needs. Alternatively, consider if you can write a subclass that provides refinement to an existing exception rather than just extending `Exception`.

In the following sections we'll thrown some errors and exceptions (on purpose) so that we can check out some of the most common 

# NullPointerException

The good old `java.lang.NullPointerException` will haunt your debugging sessions for years to come.

```groovy
def tmp = null
tmp.class
```

# PowerAssertionError

When your assertions fail you'll receive a `org.codehaus.groovy.runtime.powerassert.PowerAssertionError`. This is an `Error` not an `Exception`.

```groovy
assert true == false
```

# NumberFormatException

`NumberFormatException`

```groovy
'Kitten' as Integer
```

# groovy.lang.MissingPropertyException

```groovy
class Person {}
def jim = new Person()
jim.name
```

# groovy.lang.MissingMethodException

```groovy
class Person {}
def jim = new Person()
jim.getName()
```

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

## ArrayIndexOutOfBoundsException



```groovy
Integer[] nums = [0, 1, 2]
nums[5]
```