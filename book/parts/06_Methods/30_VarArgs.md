---
title:	Variable Arguments (Varargs)
status:	in-progress
description:	Some methods are happy to take as many parameters as you can muster.
...

There are times where we want to pass a variable number of parameters to the method but the parameter list for a method is fixed 

One approach is to use a list for a catch-all parameter, such as `items` does in the code below:

```groovy
buyGroceries 'The Corner Store', ['apples', 'cat food', 'cream']

def buyGroceries(store, items) {
    println "I'm off to $store to buy:"
    for (item in items) {
        println "  -$item"
    }
}
```

Whilst the list path is an option, Groovy supports the use of variable arguments (varargs) using the "three-dot" (`...`) notation for the last (and only the last) parameter:

```groovy
buyGroceries 'apples', 'cat food', 'cream'

def buyGroceries(... items) {
    for (item in items) {
        println item
    }
}
```

We can set a specific data type for the `items` parameter by placing the type before the `...`:

```groovy
def buyGroceries(String... items) {
    for (item in items) {
        println item
    }
}
```

Let's return to the first example in this chapter and rewrite it using varargs:

```groovy
buyGroceries 'The Corner Store', 'apples', 'cat food', 'cream'

def buyGroceries(store, ... items) {
    println "I'm off to $store to buy:"
    for (item in items) {
        println "  -$item"
    }
}
```

Putting a parameter after the variable arguments parameter doesn't make a great deal of sense as it'd be tricky to work out where `items` finished. So, even if `def buyGroceries(store, ...items, travelTime)` was legitimate (and it isn't) I'd suggest that readability is lost and `travelTime` should appear before `items`. Alternatively, going back to using an array for `items` would solve the problem.
