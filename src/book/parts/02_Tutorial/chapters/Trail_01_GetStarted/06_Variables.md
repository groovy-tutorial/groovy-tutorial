---
Title:		Variables  
Abstract:	 
...
# [%Title]

[%Abstract] 


## Variables
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

````groovy
def score = 10
println score.class
score = 'win!'
println score.class
````

For most of this book I'll actively avoid using explicit data types as I'd like you to get used to dynamic typing. However, it's useful to know what's happening "under the hood", especially when you start working with existing Java libraries.



### Lists and sets
List variables contain several items and are declared using square brackets (`[...]`). 

````groovy
def temperatures = [10, 5, 8, 3, 6]
````

In the temperatures example the list contains just numbers but Groovy lists can contain a mix of data types:

````groovy
def mixed = [1, true, 'rabbit', 3.14]
println mixed[2]
````

In the example above you'll notice I've printed out `mixed[2]` - the list item with index 2. Somewhat confusingly this causes `rabbit` to be displayed. This is because lists are zero-based and the first item is at index 0, not index 1. Where we use `mixed[2]` we're asking for the third item in the list.

Sets are much like arrays but each element in a set is unique:

````
def names = ['sally', 'bob', 'sally', 'jane'] as Set
println names
````

If you try the code above you'll get `[sally, bob, jane]` - the set just ignores the repeated element.

### Maps
Maps allow us to build up a type of look-up table using keys and values. Each key is unique and points to a value in the map. In the example below we see the start of a basic periodic table:

````
def periodic = ['h': 'hydrogen',
                 'he': 'helium', 
                 'li': 'lithium']
                 
println periodic['li']
println periodic.li
````

You should also note that we can access map items using the key in square brackets (`[]`), much as we did with lists: `println periodic['li']`. We can also use the period (`.`) followed by the key: `println periodic.li`. I prefer the latter but sometimes you need to use square brackets if you're using a key that's a reserved word[^reswords].

[^reswords]: Reserved words have meaning to Groovy and can't be used in the wrong place (such as a variable name). For more information, see the [list of reserved words](../02/chapters/01/ReservedWords)

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

