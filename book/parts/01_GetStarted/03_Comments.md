---
title:	Comments  
description:	Comments are used to clarify sections of Groovy code.
	Groovy supports two types of comments - single line and multi-line.  
...

# Single-line comments
A single-line comment is introduced with two forward slash characters `//`:

```groovy
//This is a single-line comment
println "hello, world"
```
    
Single-line comments can be appended to a Groovy statement:

    def radius = 10
    def pi = 3.14 //This is not very precise
    def area = pi * (radius * radius)

# Multi-line comments
    
A multi-line comment is introduced by the characters `/*` and terminated with the characters `*/`. Generally, the `/*` and `*/` appear on their own line:

```groovy
/*
This is a multiline comment
and here is the second line
*/
```

Multi-line comments are most commonly formatted with an asterisk (`*`) on each line, aligned with the introductory asterisk as follows:

```groovy
/*
 * This is a multiline comment
 * and here is the second line
 */
```

Multi-line comments can be introduced and terminated on a single line:

```groovy
/* This is a multiline comment on a single line */
```

Nesting within a multi-line comment is not possible, rendering the following code invalid:

```groovy
/*
 * Multi-line comments cannot 
 * /* be nested */
 */
```
    
# Usage to avoid    
In a similar vein to single-line comments, multi-line comments can be appended to a statement. However, the single-line comment is generally more readable than the following example:

```groovy
def radius = 10
def pi = 3.14 /* This is not very precise */
def area = pi * (radius * radius)
```

Even less expected is a multi-line comment appended to a statement in the following manner:

```groovy
def radius = 10
def pi = 3.14 /* This is not very precise
                and should really use java.lang.Math.PI */
def area = pi * (radius * radius)
```
    
In such a case the multi-line comment should appear above the statement being discussed:

```groovy
def radius = 10
/*
 * This is not very precise
 * and should really use java.lang.Math.PI
*/
def pi = 3.14 
def area = pi * (radius * radius)    
```
    
Use of a comment within a statement should never be contemplated as it results in code that is hard to read:

```groovy
    def radius = 10
    def pi = 3.14
    def area = pi * /* I should find out how to square */ (radius * radius)
```