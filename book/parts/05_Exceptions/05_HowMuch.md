---
title:	How Much Should We try?
status:	draft
description:	Just a small chapter on technique
...

Whilst you could wrap an entire script/method/closure in a huge `try` statement this will quickly get confusing - imagine how many `catch` blocks you'll need at the end of a 150-line script! Yes, you can `catch (any)` but you'd really have no clue what caused the exception.

Take the following example:

```groovy
try {
    methodOne()
    methodTwo()
    //148 more lines of code :)
} catch (MethodOneException e) {

} catch (MethodTwoException e) {

}
```

I tend to "localise" my `try` blocks so that they deal more specifically with the exception arising from a specific method call:

```groovy
try {
    methodOne()
} catch (MethodOneException e) {

}

try {
    methodTwo()
} catch (MethodTwoException e) {

}
```

Although that last example results in more code I suggest it's more useful as it helps localise the exception. In the first example I could end up catching a `MethodTwoException` from my call to `methodOne` - probably not what I really intended. If both methods throw the same exception type then localising really helps as I'll know which method threw the exception.

Additionally, if you go with the rule that you're only catching exceptions you're prepared to actually do something with, a lot of your code may not be wrapped with a `try` statement at all!