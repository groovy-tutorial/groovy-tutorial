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

