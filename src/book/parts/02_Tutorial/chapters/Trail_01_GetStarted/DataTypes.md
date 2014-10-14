---
Title:		Data Types  
Abstract:	 
...
# [%Title]

[%Abstract] 

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




