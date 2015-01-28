---
title: Variables
...
| Type | Examples |  
|  ------	| ------  	|  
| Boolean	| `true`, `false`	| 
| Number	| `1`, `3.14`, `1.67e-27`, `0xff` (hex), `071` (oct)	|  
| String	| `'Hello, world'`, `"Hello, world"`	|  
| List	| `[]`, `[4, 'cat', myObject]`	|  
| Set	| `[4, 8, 2, 19] as Set`	|  
| Map	| `[:]`, `['h': 'hydrogen', 'he': 'helium']`  	|  
| Range	| `1..10`	|  
| Regular expression	| `~/<expression>/`	|  

- Collection types (List, Set, Map) can use the `asImmutable()` method to make the collection immutable (_i.e. you can't change its contents_)
	- e.g. `def myList = [1, 2, 3].asImmutable()`