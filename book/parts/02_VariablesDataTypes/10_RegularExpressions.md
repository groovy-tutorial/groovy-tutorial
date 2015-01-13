---
title:	Regular Expressions
description:	
---

# Introduction


To define the pattern we use the `~/ /`

```groovy
def regex = ~/\n/
```

Underpinning Groovy's regular expression functionality is the Java class `java.util.regex.Pattern`. Groovy handles the compiling of the pattern and this helps you focus on the struggle of getting the regular expression correct :)

# Regular Expression Methods

`matcher`
:

`matches`
:

`split`
:	

A number of String methods can accept a regular expression

`findAll`
:

`matches`
:

`replaceAll`
:

`replaceFirst`
:

`splitEachLine`
:

# Characters

|Element | Matches|  
| :------:	| ------	|  
|`g`	| The character `g`	|  
|`\\`	| The backslash character	|  
|`\t`	| Tab character	|  
|`\n`	| Newline character	|  
|`\f`	| Formfeed character	|  
|`\r`	| Carriage-return character	|  

In the example below I take a section of a poem and use the `split` method to get a list whose elements contain a single line from the poem.

```groovy
// The Ballad of the Drover by Henry Lawson
def poem = '''\
 Across the stony ridges,
  Across the rolling plain,
 Young Harry Dale, the drover,
  Comes riding home again.
 And well his stock-horse bears him,
  And light of heart is he,
 And stoutly his old pack-horse
  Is trotting by his knee.'''

def regex = ~/\n/

def lines = regex.split(poem)

def i = 1
for (line in lines) {
    println "Line $i: $line"
    i++
}
```

# Character Classes

|Element | Matches|  
| :------:	| ------	|  
| `[xyz]`	| `x`, `y` or `z`	|  
| `[^xyz]`	| Not `x`, `y` or `z`	|  
| `[a-zA-Z]`	| Range of characters (all letters)	|  
| `[0-9]`	| Range of characters (all numbers)	|  
| `[a-zA-Z_0-9]`	| Range of characters	| 

# Predefined Character Classes

|Element | Matches|  
| :------:	| ------	|  
| `.`	| Any character	|  
| `\d`	| Digits `[0-9]`	|  
| `\D`	| Non-digits	|  
| `\s`	| Whitespace	|  
| `\S`	| Not whitespace	|  
| `\w`	| Word character `[a-zA-Z_0-9]`	|  
| `\W`	| Not a word character	| 

# Boundaries

|Element | Matches|  
| :------:	| ------	|  
| `^`	| Start of a line	|  
| `$`	| End of a line	|  
| `\b`	| Word boundary	|  
| `\B`	| Non-word boundary	|  

# Quantifiers

|Element | Matches|  
| :------:	| ------	|  
| `?`	| Single match	|  
| `*`	| Zero or more matches	|  
| `+`	| One or more matches	|  
| `{n}?`	| Exactly _n_ matches	|  
| `{n, }?`	| At least _n_ matches	|  
| `{n,m}?`	| At least _n_ but not more that _m_ matches	| 

# Further reading
The Java documentation for the `Pattern` class provides a full listing of [regular expression constructs](http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)