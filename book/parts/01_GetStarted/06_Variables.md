---
Title:	Variables  
Abstract:	Variables are one of the most basic of programming constructs and help us to track values in our program.
...

# Variables
Variables are (perhaps unsurprisingly), items that can change. Essentially it is a "box" that can hold a value. Groovy provides a few ways to create a variable but the best one to start with is to use the `def` keyword. In the example below I define (`def`) a new variable named `score` that can be used to hold a value later in my program:

```groovy
def score
```

In the next example I assign `score` a value of 10 and ask Groovy to display the value of `score` using `println`:

```groovy
def score
score = 10
println score
```

Instead of declaring `score` and then assigning it the value `10` I can do this on a single line using `def score = 10`. I do just this in the example below and then change the value of `score` (it is a variable after all) - try this in your Groovy Console and the `println`s will show you the value of `score` after it's been set.

```groovy
def score = 10
println score
score = 11
println score
```

You'll note that the second time I use `score` I don't need the `def` prefix as I've already declared `score` and don't need to redeclare it.

If we're declaring a number of variables we could provide a `def` on each line:

```groovy
def myNumber
def myName
```

Alternatively, the previous example could be represented on a single line in which each variable is separated by a comma (`,`):

```groovy
def myNumber, myName
```

You can assign values to variables defined on a single line:

```groovy
def number1 = 10, number2 = 20
```

A set of variables can be assigned values from a list:

```groovy
def number1, number2
(number1, number2) = [10, 20]

assert number1 == 10
assert number2 == 20
```
    
In the next example a third variable is introduced but the assignment list only provides two elements. This will result in `number1` and `number2` being set but `number3` remaining without a value (`null`):

```groovy
def number1, number2, number3
(number1, number2, number3) = [10, 20]

assert number1 == 10
assert number2 == 20
assert number3 == null
```

## Variable names
Variable names must meet the following criteria:

 - Must start with a letter (upper-case [A-Z] or lower-case [a-z])
   - The underscore (`_`) is also allowed but very strongly discouraged 
 - Must only contain letters, digits (0-9) or an underscore (`_`)
   - The dollar-sign (`$`) is also allowed but very strongly discouraged 
 - Must not match a keyword (reserved word)
 
The use of literate variable names that comply to the criteria is encouraged. For example, a variable named `x` provides little information as to its role whereas `accountNumber` is likely to be clear within the context of a broader system.

# Data Types


## Objects


## Booleans

Va

## Numbers


{{Variables/Strings.md}}  
{{Variables/Lists.md}}  
{{Variables/Maps.md}}  