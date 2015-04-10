---
title:	Useful Methods That Use Closures
status:	in-progress
description:	
...

Groovy adds a number of methods to `java.lang.Object` that gives you the power of closures baked into many of the data types you'll use on a daily basis.

#any

```groovy
def scores = [10, 8, 11, 6]
assert scores.any {it > 10} == true
```

#find and findAll

```groovy
def animals = ['dog', 'rat', 'cat', 'mouse']

assert animals.find {it in ['rat', 'mouse', 'wild pig'] } == 'rat'

assert animals.findAll {it in ['rat', 'mouse', 'wild pig'] } == ['rat', 'mouse']
```

#split

```groovy
def players = [
    [name: 'Fred', topScore: 120],
    [name: 'Sally', topScore: 200],
    [name: 'Felix', topScore: 101],
    [name: 'Albert', topScore: 12],
    [name: 'Jane', topScore: 20]
]

def result = players.split {it.topScore > 100}

result[0].each {println "$it.name is in the hall of fame"}

result[1].each {println "$it.name missed out"}
```

#with

```groovy
class Person {
    def name
    def email
    def mobile
    
    def printBusinessCard(){
        println "$name"
        println "e: $email"
        println "m: $mobile"
    }
}

def john = new Person()

john.with {
    name = 'John Smith'
    email = 'john@example.com'
    mobile = '0401 999 888'
    printBusinessCard()
}
```

