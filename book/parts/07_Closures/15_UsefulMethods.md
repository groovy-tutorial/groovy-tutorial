---
title:	Useful Methods That Use Closures
status:	in-progress
description:	
...

Groovy adds a number of methods to `java.lang.Object` that gives you the power of closures baked into many of the data types you'll use on a daily basis.

`any`
:	

`collect`
:	

`each`
:

`every`
:	

`find`
:	

`findAll`
:

`split`
:	

`with`
:

Let's look at a sorting closure I used when discussing Relational Operators:

```groovy
def nums = [42, -99, 6.3, 1, 612, 1, -128, 28, 0]

//Descending
println nums.sort{n1, n2 -> n2<=>n1 }
```