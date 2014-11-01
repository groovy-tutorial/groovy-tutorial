# Strings

There are a two main ways in which you can declare a string in Groovy: using single or double quotes

| Method | Usage
| ------ | ------	
|Using single quotes (`'...'`)	| these are fixed strings and tell Groovy that the string is as we've written it (e.g. `def pet = 'dog'`). 
|Using double quotes (`"..."`)	| these are called GStrings and let us interpolate (insert) variables into our string.  

If you wish to use a quote within your string that matches the quote type you're using to surround your string then you need to escape the internal quote using the `\` character. In the code below you can see the quotes being escaped (`\'` and `\"`):

```groovy
println 'That\'s mine'
println "I said \"NO!\""
```

## GStrings
In order to have Groovy interpolate the value of a variable we use the `$` symbol in front of the variable name - as you can see with `$pet` below:

```groovy
def pet = 'dog'  
println "I own a $pet"
```

This can be handy if you have a number of variables that you'd like to use in a string:

```groovy
def name = 'Sally'
def hobby = 'surfing'
println "Did you know that $name likes $hobby?"
```

>This helps escape the use of the addition operator (`+`) to concatenate (join) strings: \
>`println 'hello ' + 'world`  \
>You'll see this in a lot of Java code and I, for one, am pleased to see that Groovy lets us pretend this never happened.

## Building strings
Working with basic strings is fine but if you need to build up a large piece of text throughout a program they can become very inefficient. We'll look into this at a later point.
