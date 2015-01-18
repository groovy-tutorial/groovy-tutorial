---
title:	Try-Catch-Finally
description:	This is a placeholder
...


```groovy
try {
    10 / 0
} catch (any) {
    println any.message
    any.printStackTrace()
}
```

```groovy
try {
    10 / 0
} catch (any) {
    println any.message
} finally {
    println 'I think we survived'
}
```

>The exceptions I've used in this chapter are all declared in the `java.lang` package.

Exceptions are used in a large number of places, including:

- Failure to read/write a file
- Failure to access a database
- Trying to access `null`

# Causing an Exception

```groovy
def numerator = 10
def denominator = -1

try {
    if (denominator < 0) {
        throw new IllegalStateException('I haven\'t learnt how to divide negative numbers')
    } else {
        return numerator / denominator
    }
} catch (any) {
    println "${any.message} (${any.class})"
}
```

In the code above I `throw` an exception (`IllegalStateException`) to indicate a limitation in my program. As before, the `catch` will receive the thrown exception but this time it could be either the `IllegalStateException` or the `ArithmeticException`

>Naturally, I've correctly documented the limitation so that people using my code will know but I perform the check just to be sure.

```groovy
def numerator = 10
def denominator = -1

try {
    if (denominator < 0) {
        throw new IllegalStateException('I haven\'t learnt how to divide negative numbers')
    } else {
        return numerator / denominator
    }
} catch (IllegalStateException e) {
    println 'I just caught an IllegalStateException'
} catch (ArithmeticException e) {
    println 'I just caught an ArithmeticException'
} catch (any) {
    println 'What just happened?'
}
```


```groovy
def numerator = 10
def denominator = -1

try {
    if (denominator < 0) {
        throw new IllegalStateException('I haven\'t learnt how to divide negative numbers')
    } else {
        return numerator / denominator
    }
} catch (IllegalStateException | ArithmeticException e) {
    println 'Stand back, I know how to handle this'
} catch (any) {
    println 'What just happened?'
}
```

## Anatomy of an Exception

Exceptions aren't magical - they're just objects, defined the same as any other object. Importantly, exceptions implement the `java.lang.Throwable` interface. In nearly all cases, exceptions that you write or form part of the Java libraries will extend the `java.lang.Exception` class.

# Errors
Errors are objects and can be caught much like exceptions but the following won't work:

```groovy
try {
    assert true == false
} catch (err) {
    println 'I caught the error!'
    println err.message
}
```

The code above doesn't do what we hoped as, by default, the `catch` is looking for `Exception` or one of its subclasses[^sub].

[^sub]: This is why, when we write our own exception we extend `Exception` rather than implement `Throwable`.

In order to catch an error we must provide `Error` (or a subclass of `Error`) as the data type in the `catch`:

```groovy
try {
    assert true == false
} catch (Error err) {
    println 'I caught the error!'
    println err.message
}
```

## Anatomy of an Error

Much like Exceptions, Errors implement the `java.lang.Throwable` interface but are sub-classes of `java.lang.Error`.

# Methods and Exceptions

The code in this chapter is rather skewed as we'd rarely throw an exception and catch it within the same `try-catch` block. Rather, we're most likely to throw an exception from a method back to the caller. Throwing an exception from a method results in no `return` value being returned to the caller - they need to 

This will be covered in the tutorial on Methods.