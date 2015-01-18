---
title:	The `while` loop
description:	
---


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

# There is no `do...while` loop 

Unlike Java, Groovy does not have a `do...while` loop[^dowhile].

[^dowhile]: [A ticket](https://jira.codehaus.org/browse/GROOVY-5348) has been lodged to request one.