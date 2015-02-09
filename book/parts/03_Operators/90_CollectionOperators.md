---
title: Collection operators		
...
|Operator(s)     |Type
|:------------------:|:--------------------|  
| `in`	| Membership Operator	|  
| `*`	| Spread Operator	|  
| `*.`	| Spread-Dot Operator	|  
| `..`	| Range Operator	|  
| `[]`	| Subscript Operator	| 

A collections is a group of items held in a variable. In Groovy we primarily use lists and maps when managing collections.

The collection operators will be covered more completely when we look at lists and maps. However, here's a quick overview:

Membership Operator (`in`)
:	`in` is used to determine if an item is "in" a list or is a key in a map
:	Example: `assert 6 in [1, 2, 6, 9]`

Spread Operator (`*`)
: 	Extracts each item in the collection
:	Helpful when you need to include a collection's individual items in another collection or when your collection can be used as parameters in a method call.
: 	Example 1 - adding one collection's items to another collection

	```groovy
	def list = [1, 2, 6, 9]
	def list2 = [*list, 12, 34]
	//Result is list2 = [1, 2, 6, 9, 12, 34]
	```
:	Example 2 - using the collection items as a parameter list

	```groovy
	def mean(num1, num2, num3) {
      (num1 + num2 + num3) / 3
	}
	def scores = [4, 8, 1]
	mean(*scores)
	```

Spread-Dot Operator (`*.`)
:	The `*.` operator calls an action (method) on each item in the collection. 
:	The spread operator makes the call using the "Safe navigation Operator" to make sure that the item isn't null. 
	_Refer to the Object Operators section for more information._
:	Example: `['carrot', 'cabbage', 'cauliflower']*.reverse()`

Range Operator (`..`)
:	Creates a list of sequential values
:	Usually seen with numbers 
:	Can be used with classes implementing `java.lang.Comparable` and providing the `next()` and `previous()` methods
:	Example: `println 1..10` _(inclusive range)_
:	Example: `println 'a'..'k'` _(inclusive range)_
:	Example: `println 1..<99` _(half-open range)_
:	Example: Can be handy when dealing with `enums`:

	```groovy
	enum Priority {
	    LOW,MEDIUM,HIGH,URGENT
	}
	
	def focus = Priority.HIGH..Priority.URGENT
	```
	
Subscript Operator (`[]`)
:	Allows you to address a position (location) in a collection instead of using the `get`/`getAt` and `put`/`putAt` methods
:	Groovy collections are zero-based - the first item in a list is at position 0 (zero)
:	Example: working with a list

	```groovy
	def scores = [5, 8, 2, 11]
	assert scores[1] == 8
	scores[3] = 18
	assert scores[3] != 11
	```

:	Example: working with a map

	```groovy
	def team = [captain: 'Bill', goalie: 'Jane', sub: 'Jim']

	//The next two statements do the same thing
	println team['goalie']
	println team.goalie
	
	// Change the sub
	team['sub'] = 'Sally'
	println team['sub']
	```

