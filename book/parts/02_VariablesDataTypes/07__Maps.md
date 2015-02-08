---
title:	Maps  
status:	in-progress
description:	Maps allow us to build up a type of look-up table using keys and values. 
...

Each key in a map is unique and points to a value in the map. In the example below we see the start of a basic periodic table:

```groovy
def periodic = ['h': 'hydrogen',
		'he': 'helium',
		'li': 'lithium']
                 
println periodic['li']
println periodic.li
```

You should also note that we can access map items using the key in square brackets (`[]`), much as we did with lists: `println periodic['li']`. We can also use the period (`.`) followed by the key: `println periodic.li`. I prefer the latter but sometimes you need to use square brackets if you're using a key that's a reserved word[^reswords].

[^reswords]: Reserved words have meaning to Groovy and can't be used in the wrong place (such as a variable name). For more information, see the [list of reserved words](../02/chapters/01/ReservedWords)