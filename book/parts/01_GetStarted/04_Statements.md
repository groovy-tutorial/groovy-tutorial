---
Title:	Statements  
Abstract: 	A Groovy program is made up from lots of statements, each telling the computer to do something.
...
# Statement structure
A Groovy statement is generally completed by an end-of-line (EOL) character such as a carriage return:

```groovy
def num = 21
println num
```

A semicolon (`;`) can be used to explicitly mark the end of a statement however this is deemed to be redundant in most cases and spoils readability

```groovy
def num = 21;
println num;
```

Statements can span multiple lines. This feature should be utilised if it aids in improved readability - this is often referred to as _line-wrapping_. For example, an array declaration that provides a number of entries may be written as:

```groovy
def myArray = ['Tasmania', 'Victoria', 'New South Wales', 'Queensland', 'Western Australia', 'South Australia']
```
    
The judicious use of line-wrapping may improve readability:  

```groovy
def myArray = ['Tasmania', 
               'Victoria',
               'New South Wales',
               'Queensland',
               'Western Australia',
               'South Australia']
```

It is difficult to provide specific metrics regarding readability in these cases and the programmer is left to determine the best use of white space and placement.

# Usage to avoid

A semicolon can be used to separate two statements appearing on the same line:

```groovy
def num = 1 + 1; println num
```

The presentation of multiple statements in a single line should be avoided.

Groovy is very forgiving of statements spread over more than one line but usage such as the one below should be avoided as it reduces readability. For example, the following code will actually work but it looks odd and isn't worth the hassle:

```groovy
def num = 1 +
1
println num
```
