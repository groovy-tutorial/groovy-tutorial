---
title:	Variable Arguments (Varargs)
status:	in-progress
description:
...

There are times where we want to . One such method is to use an array for a catch-all parameter 

```groovy
buyGroceries 'The Corner Store', ['apples', 'cat food', 'cream']

def buyGroceries(store, items) {
    println "I'm off to $store to buy:"
    for (item in items) {
        println "  -$item"
    }
}
```



Groovy supports the use of variable arguments using the "three-dot" (`...`) notation for the last (and only the last) parameter:

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



```groovy
buyGroceries 'The Corner Store', 'apples', 'cat food', 'cream'

def buyGroceries(store, ... items) {
    println "I'm off to $store to buy:"
    for (item in items) {
        println "  -$item"
    }
}
```

Putting a parameter after the variable arguments parameter doesn't make a great deal of sense as it'd be tricky to work out where `items` finished. So, even if `def buyGroceries(store, ...items, travelTime)` was legitimate (and it isn't) I'd suggest that readability is lost and `travelTime` should appear before `items`. Alternatively, using an array for `items` would solve the problem.
