## Strings

There are a two main ways in which you can declare a string in Groovy: using single or double quotes

| Method | Usage
| ------ | ------	
|Single quotes (`'...'`)	| these are fixed strings and tell Groovy that the string is as we've written it (e.g. `def pet = 'dog'`). 
|Double quotes (`"..."`)	| these are called GStrings and let us interpolate (insert) variables into our string.  
|Three single quotes (`'''...'''`)	| a multi-line fixed string  
|Three double quotes (`"""..."""`)	| a multi-line GString  


### Escape sequences

Strings can contain escape sequences, allowing you to use non-printable characters in your text.

[Table: escape sequences]
|Sequence | Character  
| ------	| ------	|  
| \\n	| line feed  
| \\f	| form feed  
| \\r	| carriage return
| \\t	| horizontal tab  
| \\'	| single quote  
| \\"	| double quote  
| \\\\	| backslash  

The line feed (`\\n`) is often used to move to a new line:

```groovy
print 'Hi \n there\n'
``` 

You'll notice the use of `print` in the example above - the final `\\n` performs the same as `println` and moves to a new line.

The form feed (`\\f`) and carriage return (`\\r`) aren't often used. Form feed indicates a new page and carriage return goes back to the start of the line.

The horizontal tab (`\\t`) is essentially the same as the `tab` key on your keyboard. It's useful for formatting things like tables of information:

```groovy
println 'name\tage\tcolour'
println 'Sam\t12\tblue'
println 'Alice\t8\tgreen'
```

If you wish to use a quote within your string that matches the quote type you're using to surround your string then you need to escape the internal quote using the `\` character. In the code below you can see the quotes being escaped (`\'` and `\"`):

```groovy
println 'That\'s mine'
println "I said \"NO!\""
```

As the backslash (`\`) is used to escape characters, it needs an escape of its own. In order to use a backslash in a string you need to double it up (`\\`) as in the example below:

```groovy
println 'c:\\documents\\report.doc'
```

### GStrings
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

GStrings also let you interpolate more complicated expressions into a string by using `${...}`. In the following example we perform a calculation within the GString:

```groovy
println "10 to the power of 6 is ${10**6}"
```

We can also access information about a variable in the same manner:

```groovy
def word = 'Supercalifragilisticexpialidocious'
println "$word has ${word.length()} letters"
```

>The code `word.length()` calls the `length` method available on a string - we'll cover what this means shortly.

### Multiline Strings

The examples given so far use short strings but longer strings would be cumbersome to type using lots of new lines. Instead, Groovy provides multiline strings - the code below declares a multiline fixed string:

```groovy
def poem = '''But the man from Snowy River let the pony have his head,
And he swung his stockwhip round and gave a cheer,
And he raced him down the mountain like a torrent down its bed,
While the others stood and watched in very fear.'''

print poem
```

If you run the code above you'll see that new lines are used at the correct points in the display. You can modify this slightly and place a backslash (`\`) at the start of the string - using statement continuation for readability:

```groovy
def poem = '''\
But the man from Snowy River let the pony have his head,
And he swung his stockwhip round and gave a cheer,
And he raced him down the mountain like a torrent down its bed,
While the others stood and watched in very fear.'''

print poem
```

>Without the backslash the code above would cause a blank newline to be printed.

GStrings can also be defined using the multiline format:

```groovy
def animal = 'velociraptor'
println """But the man from Snowy River let the ${animal} have his head,
And he swung his stockwhip round and gave a cheer,
And he raced him down the mountain like a torrent down its bed,
While the others stood and watched in very fear."""
```

### Building Strings

Working with basic strings is fine but if you need to build up a large piece of text throughout a program they can become very inefficient. We'll look into this at a later point.
