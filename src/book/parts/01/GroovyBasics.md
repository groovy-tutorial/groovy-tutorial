---
Title:		Groovy Basics  
Abstract:	Let's get started with some Groovy essentials. In this section we'll look at language elements that 
...
# [%Title]

[%Abstract] 

## Comments
Comments don't actually perform any action - they're used to help you describe what's going on to other programmers reading your code. In the code example below we add a small comment to describe what's going on:

````
//This displays a well-known bit of text
println "hello, world"
````

The `//` indicates to Groovy that everything after is a comment and not code. For longer comments that span several lines the comment will start with `/*` and finish with `*/`. In the example below you can this being used but note that the `*` at the start of each line is customary and used to make the comment more readable.

````
/*
 * The history of the 'hello, world' example is a long and interesting one.
 * blah blah blah
 * blah blah blah
 */
println "hello, world"
````

You'll see various comments used in the coming examples.

## Variables and data types
Variables are (perhaps unsurprisingly), items that can change. Essentially it is a "slot" that can hold a value. Groovy provides a few ways to create a variable but the best one to start with is to use the `def` keyword. In the example below I define (`def`) a new variable named `score` that can be used to hold a value later in my program:

````
def score
````

In the next example I assign `score` a value of 10 and ask Groovy to display `score`'s value using `println`:

````
def score
score = 10
println score
````

Instead of declaring `score` and then assigning it the value `10` I can do this on a single line using `def score = 10`. I do just this in the example below and then change the value of `score` (it is a variable after all) - try this in your Groovy Console and the `println`s will show you the value of `score` after it's been set.

````
def score = 10
println score
score = 11
println score
````

Groovy allows you to create and use variables without declaring a data type - often called _dynamic typing_. Java, on the other hand uses _static typing_ and you need to tell Java the data type you want to use when declaring a variable. 

### So, what is a data type?

A data type is essentially a definition of the possible values that can be held by elements such as variables. 

In the previous examples we set `score` to equal numbers but Groovy can access a range of types that are available from Java. Some of the key types are:

 - `Boolean`: to store a logical value of `true` or `false`
 - `Integer`: a whole number such as `10` or `1001`
 - `Float`: a floating point (decimal) number such as `3.14159`
 - `String`: a piece of text such as `'My name is mud'`

You don't have to explicitly tell Groovy which data type you want to use - Groovy will work this out based on the value of the variable. 

Try out the following code in Groovy Console and see what gets printed out:

````
def score = 10
println score.class
````

You should see `class java.lang.Integer` displayed - basically it's telling you that `score` is an Integer (its full name is `java.lang.Integer`). If you change the variable to a value of a different data type you'll see the variable's data type also changes:

````
def score = 10
println score.class
score = "win!"
println score.class
````

For most of this book I'll actively avoid using explicit data types as I'd like you to get used to dynamic typing. However, it's useful to know what's happening "under the hood", especially when you start working with existing Java libraries.

### Arrays and sets
Arrays contain . 

````
def temperatures = [10, 5, 8, 3, 6]
````

Sets are much like arrays but each element in a set is unique

````
def names = ['sally', 'bob', 'sally', 'jane'] as Set
println names
````

If you try the code above you'll get `[sally, bob, jane]` - the set just ignores the repeated element.

### Maps

````
def chemicals = ['h': 'hydrogen',
                 'he': 'helium', 
                 'li': 'lithium']
                 
println chemicals['li']
println chemicals.li
````

## Expressions and operators
### Arithmetic operators
Groovy can evaluate the arithmetic operators (`+`, `-`, `*`, `/`, `%`) that are familiar to most people:

|Operator|Name   |
|:------:|:------|
|+       |Plus   |
|-       |Minus  |
|*       |Multiply |
|/       |Divide   |
|%       |Remainder|

These operators can be used to perform calculations like those below:

````
println 1 + 1   // = 2
println 10 - 6  // = 4
println 50 * 3  // = 150
println 12 / 4  // = 3
println 19 % 2  // = 1
````

The standard order of precedence is observed when performing the calculations:

 * The expression is evaluated from left to right
 * The multiplicative operators (`*`, `/`, `%`) are evaluated first, followed by the additive operators (`+`, `-`). 

So we can put in a longer equation and feel confident that Groovy will follow the rules our maths teacher taught us:

````
println 10 + 2 * 3  // = 16
````

### Assignment and comparison
Using Groovy as a calculator is perhaps a little underwhelming. If we can capture the results of an expression then we can use it in further processing.