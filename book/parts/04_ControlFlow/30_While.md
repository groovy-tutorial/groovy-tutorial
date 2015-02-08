---
title:	The `while` loop
description:	
...
The `while` loop will  repeat a block of code whilst its condition is `true`:

```groovy
while (<condition>) {
	//statements
}
```

>Unlike the `for` loop, there is only the one syntax for `while` loops. 

`while` loops feature the following:

* `<condition>` can be a value or expression - the loop will only iterate if `<condition>` is `true`.
* The `while` loop syntax does not manage an iterator variable - you must do this yourself
	* It's very easy to create an infinite `while` loop if you're not paying attention

The example below uses a common approach for `while` loops and sets a flag to indicate when the desired state has been reached and the loop can stop:

```groovy
def flag = false
def num = 0

while (!flag) {
    num++
    if (num**2 == 64) {
        flag = true
    }
}

println "The square root of 64 is $num"
```

The code above will increment `num` by 1 each iteration and test to see if num^2 is equal to 64. Once the correct `num` is reached, `flag` is change to `true` and the `while` condition now resolves to `false` - indicating that the `while` loop should run the next iteration.


# There is no `do...while` loop 

Unlike Java, Groovy does not have a `do...while` loop[^dowhile].

[^dowhile]: [A ticket](https://jira.codehaus.org/browse/GROOVY-5348) has been lodged to request one.