---
title:	Catching Errors
status:	in-progress
description:	You can catch an error but you probably shouldn't.
...
Before we go too far on this one please note that **errors indicate serious/abnormal problems and shouldn't be caught**. Errors are different to exceptions as they indicate a fundamental issue rather than a recoverable problem. It's highly unlikely you'll ever need to handle an error so treat it like a cold and don't try to catch one. They may "crash" your program but it's likely any treatment that you try to apply will make things worse.

>I was unsure if I should even include this section but feel it more useful to flag that, whilst you can handle errors, you probably shouldn't.

One more time: **don't catch errors**.

Errors are objects and can be caught much like exceptions but the following won't work:

```groovy
try {
    assert true == false
} catch (err) {
    println 'I caught the error!'
    println err.message
}
```

The code above doesn't do what we hoped as, by default, the `catch` is looking for `Exception` or one of its subclasses[^sub] - probably because we **shouldn't catch errors**.

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

