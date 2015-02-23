---
title:	Parameters
status:	in-progress
description:	Closures can take parameters - just like methods.
...

We just saw that closures have an in-built `it` parameter but we can specify a parameter when we declare the closure:

```groovy
def cls = { name -> println "Hello, $name" }
cls('Jerry')
```

In the example above I declare the `name` parameter and this replaces `it` - in fact, if I called `it` within the closure I'd get an exception. 

The syntax of closures is starting to become evident:

1. Start the closure with `{`
2. List parameters, followed by `->` 
3. Write a set of statements for the closure body
4. End the closure with `}`

Each parameter is separated using a comma (`,`):

```groovy
def cls = { name, pet -> println "Hello, $name. How is your $pet?" }

cls('Jerry', 'cat')
```


As the closure gets more complicated I like to break it up over a number of lines. I start the closure and declare the parameters on the first line. The body of the closure then follows much the same as a method body and a final line closes off the closure:

```groovy
def cls = { name, pet -> 
    println "Hello, $name. How is your $pet?"
}
```


Closure parameters let me do the same things I can do with method parameters:

1. Use data types for parameters
2. Provide default values
3. Varargs
4. Named parameters

Parameter data types:

```groovy
def cls = { String name, String pet -> 
    println "Hello, $name. How is your $pet?"
}
```

Default values:

```groovy
def cls = { name, pet = 'dog' -> 
    println "Hello, $name. How is your $pet?"
}
```

Varargs:

```groovy
def cls = { name, ...pets -> 
    println "Hello, $name. How are your $pets?"
}

cls('Herman', 'cat', 'dog', 'spider')
```

Named parameters:

```groovy
def cls = { grades, name -> 
    println "This year $name received the following grades: $grades"
}

cls(maths: 'D', science: 'C', art: 'A', 'Albert')
```