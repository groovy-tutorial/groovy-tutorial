---
title:	Branching statements
status:	draft
description:	These statements may let you improve the efficiency of  switches, loops and methods.
...

Groovy has three branching statements:

- `break`
- `continue`
- `return`

# break

We first came across the use of `break` in the `switch` statement - it's used to indicate the end of the set of statements for the `case` and signals that the `switch` statement has completed.

The `break` reserved word is also used to exit out of a loop  - even if there are more iterations possible. In the code below I iterate through the list until I reach the value `'Earth'` and then `break` out of the loop:

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (planet in planets) {
    println planet
    if (planet == 'Earth') {
        break
    }
}
```

When we looked at the `while` loop I gave an example of setting a `flag` variable and checking that as the loop's condition. This could have been refined using `break` and not using `flag` at all:

```groovy
def num = 0

while (true) {
    num++
    if (num**2 == 64) {
        break
    }
}

println "The square root of 64 is $num"
```

>Be cautious with this sort of code - it doesn't take much to create an infinite loop.

I'll refine that `while` loop just a little further:

```groovy
def num = 0

while (++num) {
    if (num**2 == 64) {
        break
    }
}

println "The square root of 64 is $num"
```

As Groovy resolves a number other than `0` to be `true`, `++num` will allow the loop to commence and we still rely on `break` to get us out of the loop.


# continue
The `continue` reserved word will cause the next iteration of the loop - ignoring anything within the rest of the current iteration. In the loop below I use `continue` to ignore `'Earth'`.

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (planet in planets) {
    if (planet == 'Earth') {
        continue
    }
    println planet
}
```

# Labelled branching

If you have a secret desire to create spaghetti code that quickly becomes unreadable then labels are for you! 

Labels are used when you have nested loops - a loop within a loop. Both `break` and `continue` can be given a label that directs the program to another nesting level. In the example below I label the first loop `flowerlist` and, when I get to the colour `'Green'` in the inner loop, my `continue` is directed not at the inner loop but at the outer one labelled `flowerlist` - this is called a "labelled continue":

```groovy
def colours = ['Red', 'Orange', 'Yellow', 'Green', 'Blue', 'Indigo', 'Violet']

def flowers = ['daisy', 'rose', 'tulip']

flowerlist:
    for (flower in flowers) {
        for (colour in colours) {
            if (colour == 'Green') {
                continue flowerlist
            }
            println "$colour $flower"
        }
    }
```

As you can see, the label consists of a name, followed by a colon (`:`) that appears above the loop being labelled. The code above will display the following: 

```groovy
Red daisy
Orange daisy
Yellow daisy
Red rose
Orange rose
Yellow rose
Red tulip
Orange tulip
Yellow tulip
```

>Perhaps our business logic dictated that no rainbow colour below 'Yellow' was to be associated with a flower - it's a silly example.

A labelled `break` works much the same way and defers control back to the loop designated by the label.

There are times when labels are useful but really think about what you need to do before resorting to them. For example, using a `break` in the code above would have done the job:

```groovy
def colours = ['Red', 'Orange', 'Yellow', 'Green', 'Blue', 'Indigo', 'Violet']

def flowers = ['daisy', 'rose', 'tulip']

for (flower in flowers) {
    for (colour in colours) {
        if (colour == 'Green') {
            break
        }
        println "$colour $flower"
    }
}
```

# return

The `return` statement is used to hand control back to the caller[^call]. In most cases, `return` is used in a method or closure to return a value. In the most basic usage, the keyword `return` just appears on a line by itself:

```groovy
//some code
return
```

Any code that appears below the `return` is unreachable and is never evaluated:

```groovy
//some code... 
return
//unreachable code...
```

Return can be provided a value and this is returned to the caller:

```groovy 
//some code
return 3.14
```

You can use an expression in the `return` statement and the result is returned:

```groovy
//some code
return circumference / diameter
```

Using `return` within the body of a script[^body] will cause it to exit as the command-line/terminal is the caller. When exiting you can choose to return a value - usually `0` if the script succeeds, or an error number if it fails.

[^body]: By body I mean the `main` part of the script.
[^call]: The caller is the section of code that called the method/closure.