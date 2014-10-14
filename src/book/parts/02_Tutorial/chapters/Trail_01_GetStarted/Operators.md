---
Title:		Expressions and Operators  
Abstract:	Let's get started with some Groovy essentials. In this section we'll look at language elements that 
...
# [%Title]

[%Abstract] 

## Operators
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
Using Groovy as a calculator is perhaps a little underwhelming. If we can capture the results of an expression then we can use it in further processing. In the example below I add up four numbers and store the result in the `total` variable. I then divide `total` by 4 to determine the `average`. Lastly, I print the value of `average`:

````groovy
def total = 2 + 7 + 4 + 3
def average = total / 4
println average
````

The code above works just fine but what if `total` was the sum of more (or less) that four numbers? This would result in the `average` being wrong. Instead of writing such a fixed program I could put my list of numbers into a list called `scores` by using `def scores = [2, 7, 4, 3]`. 

At first glance this might sound useful as I could add more numbers to the `scores` list but I'd need a way to determine how many items are stored in my `scores` list. Luckily, the list has a method called `size` that will tell me how many items are in the `scores` list. Furthermore, lists also have a handy `sum` method that will return to us the sum of all of the list items. 

Let's take a look at how I've changed my previous code to work a little smarter:

````groovy
def scores = [2, 7, 4, 3]
def total = scores.sum()
def average = total / scores.size()
println average
````

Whilst the code above is reasonably simple, it shows us that we can use variables and methods to make our code more versatile. The numbers in the `scores` variable can change and we can add or remove list items but the calculation will handle this. Let's look at methods a bit more to find out what they are and how they help.