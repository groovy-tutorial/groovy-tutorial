---
title:	Variables
status:	draft
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

# Type Suffixes


[Table: Type suffixes supported by Groovy]
|Suffix |Type |  Example |  
| ------	| ------	| ------	|  
| `I` or `i`	| Integer	| `12i`	|  
| `L` or `l`	| Long	| `23423l`	|  
|`G` or `g`	| BigInteger	| `1_000_000g`	|  
|`F` or `f`	| Float	| `3.1415f`	| 
|`D` or `d`	| Double	| `3.1415d`	|  
|`G` or `g`	| BigDecimal	| `3.1415g`	|  

# Number Systems

- Binary (base-2): prefix `0b`
- Octal (base-8) prefix `0`
- Hexadecimal (base-16) prefix `0x`