---
title:	Loops and closures
description:	
---
# Closures and Loops
A number of Groovy classes (such as Lists and Maps) support methods like `each` which call a closure on each member of a collection. These are similar to loops (`for` and `while`) but each call to the closure is discreet and you can't use the `break` branching to exit the loop but you can use `return` as somewhat of a proxy for `continue`.

```groovy
def scores = [2, 4, 6, 8, 10]
def total = 0
def average = 0

for (i in scores) {
    total += i
}

average = total / scores.size

println "The average of the scores ($scores) is $average"

scores.each {
    print "The value $it is "

    if (it > average) {
       println 'above average'
    } else if (it < average) {
        println 'below average'
    } else {
        println 'average'
    }
}
```