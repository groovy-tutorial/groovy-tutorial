---
title:	Parameters
status:	in-progress
description:	
...

```groovy
def myClosure = { name, age ->
    println "$name is $age years old"
}

myClosure('Jeff', 26)
```

```groovy
def myClosure = { String name, Integer age ->
    println "$name is $age years old"
}

myClosure('Jeff', 26)
```


