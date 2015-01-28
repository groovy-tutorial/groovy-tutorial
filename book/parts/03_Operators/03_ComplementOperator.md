---
title: The Complement Operator
...
[Table: Complement operator]
|Operator|
|:------:|  
|`!`|

The exclamation (`!`) sign is used switch a value to its opposite boolean value. In boolean algebra[^bool] this is referred to as a Not (or negation) operator.

The following example makes sure that "not true" is the same as "false":

```groovy
assert !true == false
```

The complement operator results in the following:

[Table: The complement truth table]
|Value|Complement|  
| ------	| ------	|  
|`true`	| `false`	|  
|`false`	| `true`	|  

[^bool]: see <http://en.wikipedia.org/wiki/Boolean_algebra>