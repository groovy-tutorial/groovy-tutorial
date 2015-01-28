---
title:	Regular Expression Operators	
...
|Operator(s)     |Type
|:------------------:|:--------------------|  
| `=~`	| Find	|  
| `==~`	| Match	| 

The chapter on Regular Expressions will cover these more fully but here's a quick overview:

Find (`=~`)
:	Example: `assert 'http://www.example.com' =~ 'http://'`
:	Returns `true` if the string on the left-side contains the string on the right of the operator

Match (`==~`)
:	Example: `assert 'www.example.com' ==~ /www.\w*.com/`
:	Returns `true` if the string on the left-side matches the regular expression provided on the right of the operator