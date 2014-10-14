---
Title:		Strings  
Abstract:	 
...
# [%Title]

[%Abstract] 

It's useful to understand how Groovy treats strings as this can affect the efficiency of your program. There are a two main ways in which you can declare a string: using single or double quotes

Using single quotes (`'...'`): these are fixed strings and tell Groovy that the string is as we've written it (e.g. `def pet = 'dog'`)

Using double quotes (`"..."`): these are called GStrings and let us interpolate (insert) variables into our string. In order to have Groovy insert the value of a variable we use the `$` symbol in front of the variable name - as you can see with `$pet` below:

````groovy
def pet = 'dog'  
println "I own a $pet"
````

Working with basic strings is fine but if you need to build up a large piece of text throughout a program they can become very inefficient. We'll look into this at a later point.