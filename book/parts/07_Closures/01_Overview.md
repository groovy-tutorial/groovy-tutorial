---
title:	Closures
status:	in-progress
description:	A closure is a method/function that is either named (stored in a variable) or anonymous (passed directly to a method).
...
Intro stuff 




```groovy
def myClosure = { println 'Hello, world' }
myClosure()
```

Closures get a single parameter named `it` by default: 

```groovy
def myClosure = { println "Hello, $it" }
myClosure('Jerry')
```

