---
title:	Object-related Operators
description:	
...
# Field override


```groovy
class Person {
    def name
    
    def getName() {
        return 'Broken'
    }
    
    def setName(name) {
        this.name = name
    }
}

def me = new Person(name: 'Fred Smith')

println me.name
println me.@name
```

## Cast with `as`
```groovy
10.3 as int
```

## Check Identity With `is`

```groovy
@groovy.transform.EqualsAndHashCode
class Person {
    def name
}

def fred = new Person(name: 'Fred')
def doppleganger = new Person(name: 'Fred')

assert fred == doppleganger 
assert fred.is(doppleganger)
```

## Method Reference

```groovy
class Person {
    def name
    def debt
    
    def String promissory() {
        return "$name will pay you $debt"
    }
}

// Jane takes out a loan
def jane = new Person(name: 'Jane', debt: 100)

// We give the loan to someone else to manage
def iou = jane.&promissory

// Jane disappears
jane = null

// The loan is still there - you just need to find Jane
iou.call()
```