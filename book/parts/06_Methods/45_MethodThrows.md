---
title:	Throwing an exception
status:	in-progress
description:	You method can throw an exception.
...

A method is able to throw an exception just as we saw in the Exceptions tutorial. In the code below I throw an exception if the caller to `determineAverage()` tries to pass a String through as a parameter:

```groovy
def determineAverage(...values) throws IllegalArgumentException {
    for (item in values) {
        if (item instanceof String) {
            throw new IllegalArgumentException()
        }
    }
    return values.sum() / values.size()
}

//This works:
assert determineAverage(12, 18) == 15

//This does not work - we get an exception
determineAverage(5, 5, 8, 'kitten')
```

None of that code is new to you except for the `throws IllegalArgumentException` that forms part of the method's signature[^sign]. The use of `throws` helps describe our method a little better by making callers aware of what to expect.

Multiple exceptions can be listed against `throws`, as seen in the example below:

```groovy
def determineAverage(...values) 
  throws IllegalArgumentException, NullPointerException {
    for (item in values) {
        if (item instanceof String) {
            throw new IllegalArgumentException()
        }
    }
    return values.sum() / values.size()
}
```

Groovy doesn't require that you explicitly provide a `throws` listing if your method throws an exception or passes up an exception that it doesn't handle. However, if your method is to be used by others, I'd suggest that including `throws` is worth the effort. You may note that I placed `throws` on a second line - this helps readability as it breaks up the display of the signature just slightly.

[^sign]: This is the section of the method definition contain the return type, method name, parameters and thrown exceptions. As always, [Wikipedia has some further information](https://en.wikipedia.org/wiki/Type_signature#Method_signature) 