---
title:	Blocks
status:	in-progress
description:	
...

>This chapter is really just a note about syntax - feel free to move to the next chapter after a quick glance here.

Groovy uses curly brackets `{..}` to enclose blocks of code. These are primarily used to group a set of statements within an elements such as control flow, class, method and closure declarations. Blocks also let you "partition off" parts of code so that items such as variables aren't visible to other parts of your code - referred to as "scope".

Groovy doesn't allow the use of anonymous code block such as the one below:

```groovy
{
    def count = 0
    assert count == 0
}
```

You need to label the block provided above if you want to use it in Groovy code:

```groovy
Block1:{
    def count = 0
    assert count == 0
}
```

This limitation is primarily due to the closure syntax - labelling the block ensures it isn't confused with a closure.

Blocks appearing within blocks are called "nested blocks":

```groovy
Block1:{
    def count = 0
    assert count == 0
    NestedBlock: {
        assert count == 0
    }
}
```

## Usage
You're not likely to see usage such as `Block1:{..}` very often. You're more likely to see blocks used with control flow statements (such as `if`):

```groovy
if (true) {
    //some code
}
```

... in class declarations:

```groovy
class Person {

}
```

... in method declarations:

```groovy
def doStuff() {

}
```

... in closure declarations

```groovy
{name -> 
    println "Hello, $name"
}
```

# Scope 

In the 

```groovy
def count = 0

Block1: {
    assert count == 0
}

assert count == 0
```

The second `assert` will fail as `count` is not in scope in the main body of the script:

```groovy
Block1: {
    def count = 0
    assert count == 0
}

assert count == 0
```

```groovy
Block1:{
    def count = 0
    
    Block2:{
        assert count == 0
    }
}
```

What all of this means is that you need to keep an eye on where the variable can be "seen". I have a repeated (broken) approach in which I declare a variable within a `try` block that I need to use later on. The code below is an example of my mistake - `println myObj` will never work as `myObj` is not visible at that level.

```groovy
try {
    def myObj = new Object()
} catch (any) {
    //Do something to handle the exception
}

println myObj
```
