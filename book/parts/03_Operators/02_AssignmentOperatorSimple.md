---
title: The Simple Assignment Operator
...
[Table: Simple assignment operator]
|Operator|
|:------:|  
|`=`|

The equals (`=`) sign is used to assign a value to a variable:

```groovy
def age = 101
def name = "Fred"
```

>Be aware that the `=` and `==` operators perform different roles. In Groovy the equality operator (`==`) is used to determine if two things are the same.

In the following code the variable `count` is assigned the numeric value `10`:

```groovy
def count = 10
```

If we then wanted compare `count` with another value (`11`) we need to use the `==` operator:   

```groovy
if (count == 11) println "Count is 11"
```

Use of `=` in the comparison will cause a compilation error:

```groovy
if (count = 11) println "Count is 11"
```

>Rest assured that if you accidently use the simple assignment operator (`=`) instead of the equality operator (`==`) you'll not be the first in making that mistake.