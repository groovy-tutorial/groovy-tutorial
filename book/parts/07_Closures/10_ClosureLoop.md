---
title:	Loops and closures
status:	in-progress
description:	
...
A number of Groovy classes (such as Lists and Maps) support methods like `each` which call a closure on each member of a collection. These are similar to loops (`for` and `while`) but each call to the closure is discreet and you can't use the `break` branching to exit the loop but you can use `return` as somewhat of a proxy for `continue`.


# each

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

# collect


# sort

Let's look at a sorting closure I used when discussing Relational Operators:

```groovy
def nums = [42, -99, 6.3, 1, 612, 1, -128, 28, 0]

//Descending
println nums.sort{n1, n2 -> n2<=>n1 }
```