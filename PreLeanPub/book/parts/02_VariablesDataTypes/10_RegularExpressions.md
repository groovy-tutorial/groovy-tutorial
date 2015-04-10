---
title:	Regular Expressions
status:	draft
description:	Regular expressions give us a powerful (and confusing) way of sifting through text.
...

Regular expressions (RegEx's) get entire books devoted to them and you'll find some developers are RegEx ninjas and others (like myself) are RegEx numpties. This chapter will introduce the basics but the [Java Tutorial's Regular Expression trail](http://docs.oracle.com/javase/tutorial/essential/regex/) is a useful reference as is [Wikipedia](https://en.wikipedia.org/wiki/Regular_expression) for those seeking RegEx glory. There are also a number of online tools such as [RegExr](http://www.regexr.com) that come in very handy when trying to debug that elusive RegEx pattern.

To define the regular expression pattern we use the `~/ /` syntax:

```groovy
def regex = ~/\n/
```

Once stored as a variable, this regular expression can be used in a variety of ways. The example below sets up three string variables and tests them against the `regex` pattern by using the `matches` method - which returns `true` if the string matches the pattern: 

```groovy
def regex = ~/https?:\/\/.*/

def httpUrl = 'http://www.example.com/'
def httpsUrl = 'https://secure.example.com/'
def ftpUrl = 'ftp://ftp.example.com/'

assert httpUrl.matches(regex)
assert httpsUrl.matches(regex)
assert ! ftpUrl.matches(regex)
```

In the code above, `~/https?:\/\/.*/` is the regular expression pattern that's essentially looking for any string starting with `http` or `https`. The `s?` will match 0 or 1 occurrence of `s` in the pattern. You'll notice the odd-looking `\/\/` - I need to escape the forward slashes in `http://` so that Groovy doesn't confuse them with the slashes used to define the regular expression pattern (`~/../`).

We'll also look at the special operators for regular expressions in the next tutorial: Operators.

Underpinning Groovy's regular expression functionality is the Java class [`java.util.regex.Pattern`](http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html). Groovy handles the compiling of the pattern and this helps you focus on the struggle of getting the regular expression correct :)


# Regular Expression Syntax

Regular expressions use a number of syntactic elements to define a pattern of text. We'll take a brief look at them here.

## Characters

These elements are used to match specific literal characters.

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

## Character Classes

Character classes are used to define character sets and sequences.

|Element | Matches|  
| :------:	| ------	|  
| `[xyz]`	| `x`, `y` or `z`	|  
| `[^xyz]`	| Not `x`, `y` or `z`	|  
| `[a-zA-Z]`	| Range of characters (all letters)	|  
| `[0-9]`	| Range of characters (all numbers)	|  
| `[a-zA-Z_0-9]`	| Range of characters	| 

### Predefined Character Classes

The predefined character classes save you from having to define the class specifically and are handy for seeking out words and whitespace.

|Element | Matches|  
| :------:	| ------	|  
| `.`	| Any character	|  
| `\d`	| Digits `[0-9]`	|  
| `\D`	| Non-digits	|  
| `\s`	| Whitespace	|  
| `\S`	| Not whitespace	|  
| `\w`	| Word character `[a-zA-Z_0-9]`	|  
| `\W`	| Not a word character	| 

## Boundaries

Boundaries, to state the obvious, mark the edge of something - specifically a line or a word.

|Element | Matches|  
| :------:	| ------	|  
| `^`	| Start of a line	|  
| `$`	| End of a line	|  
| `\b`	| Word boundary	|  
| `\B`	| Non-word boundary	|  

## Quantifiers

These determine how many matches are acceptable. For example `s?` matches the character `s` zero or one time - meaning that I expect that character to be an `s` or, if it's not, move to the next part of the pattern. `s+` means  that I really want at least one `s` at that point.

|Element | Matches|  
| :------:	| ------	|  
| `?`	| Single match	|  
| `*`	| Zero or more matches	|  
| `+`	| One or more matches	|  
| `{n}?`	| Exactly _n_ matches	|  
| `{n, }?`	| At least _n_ matches	|  
| `{n,m}?`	| At least _n_ but not more that _m_ matches	| 

# Useful Methods

A number of String methods can accept a regular expression and these are my preferred approach to checking text against regular expressions. Most of them take the pattern as the first parameter.

We saw the `matches()` method at the beginning of the chapter:

```groovy
def regex = ~/https?:\/\/.*/
def httpUrl = 'http://www.example.com/'

assert httpUrl.matches(regex)
```

The `find()` method returns the first match against the pattern within the string. In the example below the `find()` will return the match against the port number in the URL:

```groovy
def regex = ~/:[0-9]+/
def httpUrl = 'http://www.example.com:8080/'

println httpUrl.find(regex)
```

The `findAll()` method returns a list of matches for the pattern. In the example below I am returned all words in `speech` that start with `like`:

```groovy
def speech = '''This like guy like I know but like don\'t really like 
 was like so mean but likely to be nice when you know him better.'''

println speech.findAll(~/\blike\w*\b/)
```

>Like, wow!

The example below provides a very basic word counter by seeking out the `\b\w+\b` pattern and displaying the size of the list returned by `findAll`:

```groovy
def poem = '''\
 Across the stony ridges,
  Across the rolling plain,
 Young Harry Dale, the drover,
  Comes riding home again.'''
  
def regex = ~/\b\w+\b/

println poem.findAll(regex).size()
```

The `replaceFirst()` and `replaceAll()` methods seek out matches and replace them in a manner that their names implies:

```groovy
def speech = '''This like guy like I know but like don\'t really like 
 was like so mean but likely to be a nice guy when you know him better.'''

println speech.replaceAll(~/\blike\b/, 'um')
println speech.replaceFirst(~/\bguy\b/, 'marmoset')
```

The `splitEachLine()` method is very handy when handling structured files such as comma-separated files. You can see in the example below that the first parameter is the pattern that will match commas (`~/,/`) and the second parameter is a closure that will do something for each line. Within the closure,  the `it` variable is a list with each element being the delimited segment of the text with the line:

```groovy
def csv = '''\
Bill,555-1234,cats
Jane,555-7485,dogs
Indira,555-0021,birds'''

csv.splitEachLine(~/,/) {
    println "Name: ${it[0]}"
}
```

## Pattern Methods

The `java.util.regex.Pattern` class provides a number of useful methods. I prefer to use the String methods but maybe I'm just lazy.

The static `matches` method is called against `Pattern` to evaluate a pattern against a piece of text. You'll note that the first parameter is the pattern but represented as a string so you drop the `~/../` notation:

```groovy
//Note the import
import java.util.regex.Pattern
assert Pattern.matches('https?://.*/', 'http://www.example.com/') == true
```

The `matcher()` method is called against a regular expression pattern and is passed the text that is to be checked. A [`Matcher`](http://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html) variable is returned and these give you a whole heap of regular expression functionality. In my example I just check for the match by calling `matches()`:

```groovy
def regex = ~/https?:\/\/.*/
def httpUrl = 'http://www.example.com/'
def matcher = regex.matcher(httpUrl)
assert matcher.matches() == true
```

The `split()` method uses a pattern as a delimiter and returns the elements of the parameter broken up by the delimiter. In my example below I split the domain up based on the period (`.`) delimiter:

```groovy
def regex = ~/\./
def domain = 'www.example.com'

println regex.split(domain)
```	

> That last example is simple but you can use some pretty funky patterns to split up a string. 