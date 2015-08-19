# Collections {#chcollections}

I> Having a single number or string is useful but collections help you keep them together.

Collections group a number of values in a single container. The Java [Collections Framework](http://docs.oracle.com/javase/tutorial/collections/intro/index.html) provides a really extensible and unified approach to handling collections. Groovy makes these even easier to use and focusses on two key collection types:

* Lists: provide a container for several values
* Maps: use keys as a method for indexing a set of values

## Lists

List variables contain several items and are declared using square brackets (`[...]`).

The example below declares a variable (`temperatures`) as an empty list:

{title="Declaring an empty list",lang=groovy}
	def temperatures = []


The next examples declares the `temperatures` list with some initial values:

{title="Declaring a list with values",lang=groovy}
	def temperatures = [10, 5, 8, 3, 6]


In the temperatures example the list contains just numbers but Groovy lists can contain a mix of data types:

{title="Lists can contain mixed types",lang=groovy}
	def mixed = [1, true, 'rabbit', 3.14]
	println mixed[2]
	println mixed[-3]
	println mixed.get(3)


The square brackets `[]` are used to create a list but are also used to refer to indexes in the list (e.g. `mixed[2]`) - this is often referred to as _subscript notation_. In the example above you'll notice I've printed out `mixed[2]` - the list item with index (subscript) 2. Somewhat confusingly this causes `rabbit` to be displayed. This is because lists are zero-based and the first item is at index 0, not index 1. Where we use `mixed[2]` we're asking for the third item in the list.

It may surprise some programmers that `println mixed[-3]` is valid - it's a very handy approach to accessing list items from the end of the list. Item `-1` is the last in the list so `mixed[-3]` will be the value `true`.

The `get()` method can also be used to access a list element by its index - e.g. `mixed.get(3)` gives us `3.14`.

I can provide multiple indexes in the subscript notation and grab the specified elements from the list. In the example below I grab elements 0 and 2 (`temperatures[0, 2]`) and then elements 1, 3 and 4 (`temperatures[1, 3, 4]`):

{title="Using indexes with lists",lang=groovy}
	def temperatures = [10, 5, 8, 3, 6]
	assert temperatures[0, 2] == [10, 8]
	assert temperatures[1, 3, 4] == [5, 3, 6]


Ranges can also be used in the subscript notation and, as demonstrated in the example below, return a list containing the items whose indexes are included in the range:

{title="Using ranges with lists",lang=groovy}
	def temperatures = [10, 5, 8, 3, 6]
	assert temperatures[1..3] == [5, 8, 3]


We can also use a mix of individual indexes and ranges as we see fit:

{title="Indexes and ranges with lists",lang=groovy}
	def temperatures = [10, 5, 8, 3, 6]
	assert temperatures[0..1, 3] == [10, 5, 3]
	assert temperatures[0..1, 1..3] == [10, 5, 5, 8, 3]
	assert temperatures[0..1, 1..3, 4] == [10, 5, 5, 8, 3, 6]


What? Let's take a look:

- `temperatures[0..1, 3]` returns a list containing the elements of `temperatures` with the indexes 0, 1 and 3
- `temperatures[0..1, 1..3]` returns a list using two ranges to select the indexes. As index item `1` is requested twice, the returned list features the item (`5`) twice.
- `temperatures[0..1, 1..3, 4]` does the same as the previous statement but adds in the item at index `4`

### Adding elements

To add an element to a list we use the `add()` method or the `<<` operator:

{title="Adding elements",lang=groovy}
	def mixed = [1, true, 'rabbit', 3.14]
	mixed << 'biscuit'
	mixed.add(101)
	println mixed


### Sets
Sets are much like lists but each element in a set is unique:

{title="Declaring a Set",lang=groovy}
	def names = ['sally', 'bob', 'sally', 'jane'] as Set
	println names


If you try the code above you'll get `[sally, bob, jane]` - the set just ignores the repeated element.

T> ## The `as` keyword
T> The `as` keyword is an operator used to cast a variable to another type. In the example above we're casting to the `Set` class but you can also cast to other collection types - something to look forward to when you get into more advanced coding.

### Useful List Methods

The `size()` method returns the number of elements in the list:

{title="List size",lang=groovy}
	def periodic = ['hydrogen', 'helium', 'lithium']
	println periodic.size()


The `first()` and `last()` methods return the first and last elements in a list. The `head()` method is synonymous with `first()`.

{title="First and last methods",lang=groovy}
	def periodic = ['hydrogen', 'helium', 'lithium']
	println periodic.first()
	println periodic.head()
	println periodic.last()


The `tail()` method returns the list minus the first (head) element and the `init()` method returns the list minus the last element:

{title="Tail method",lang=groovy}
	def periodic = ['hydrogen', 'helium', 'lithium']
	assert periodic.tail() == ['helium', 'lithium']
	assert periodic.init() == ['hydrogen', 'helium']


The `contains()` method returns `true` if the requested element is contained in the list:

{title="Contains method",lang=groovy}
	def periodic = ['hydrogen', 'helium', 'lithium']
	assert periodic.contains('helium') == true


The `reverse()` method returns the mirror of the list:

{title="Reverse method",lang=groovy}
	def periodic = ['hydrogen', 'helium', 'lithium']
	println periodic.reverse()


The `sort()` will sort the elements in a "natural" order. Basically, this relies on the list elements being comparable in some manner. The `sort` method is best used when the list contents are all of the same type (e.g. strings or numbers):

{title="Sort method",lang=groovy}
	def periodic = ['hydrogen', 'helium', 'lithium']
	periodic.sort()


The `asImmutable()` method is a handy way to set the list contents in stone -  "Immutable" essentially means "unchanging".

{title="Don't go changing",lang=groovy}
	def friends = ['fred', 'sally', 'akbar'].asImmutable()

	//This next line will cause an exception:
	friends << 'jake'


## Maps

Maps allow us to build up a type of look-up table using keys and values. Other languages call these dictionaries or associated arrays.

An empty map is declared using `[:]` and the example below shows this in use when declaring the `periodic` variable.

{title="Declaring an empty map",lang=groovy}
	def periodic = [:]


Each key in a map is unique and points to a value in the map. In the example below we see the start of a basic periodic table by declaring a variable (`periodic`) with a set of key-value pairs (`key: value`) each separated by a comma (`,`) and held within square brackets (`[...]`):

{title="Declaring a map with elements",lang=groovy}
	def periodic = ['h': 'hydrogen',
			'he': 'helium',
			'li': 'lithium']

	println periodic['li']
	println periodic.li
	println periodic.get('li')


You should also note that we can access map items using:

1. The key in square brackets (`[]`)
	1. Much as we did with lists: `println periodic['li']`.
	2. This is often referred to as _subscript notation_.
2. We can also use the period (`.`) followed by the key:
	3. As in `println periodic.li`.
	1. This is often referred to as _dot-point notation_
3. Lastly, the `get()` method is passed a key and returns the associated value

T> ## Dot point or key access?
T> I prefer the dot-point notation but sometimes you need to use square brackets if you're using a key that's a reserved word or not a valid name. The `get()` method is OK but is a little less clean in terms of aesthetics.

The keys in a map can be names provided they adhere to the same rules we follow for variable names. That means that the keys in `periodic` don't have to be written as strings:

{title="Keys as names",lang=groovy}
	def periodic = [h: 'hydrogen',
	        he: 'helium',
	        li: 'lithium']


### Adding elements
To add an element to a map we can use the square bracket, dot-point notation, `<<` operator, or `put()` method to add on a new key/value pair:

{title="Adding elements",lang=groovy}
	def periodic = ['h': 'hydrogen',
	        'he': 'helium',
	        'li': 'lithium']

	periodic['be'] = 'Beryllium'
	periodic.b = 'Boron'
	periodic << ['c': 'Carbon']
	periodic.put('n', 'Nitrogen')

	println periodic


### Keys
Map keys don't have to be strings - they can be a mix of strings, numbers or other objects. Let's look at an example then go through the various bits of code:

{lang=groovy}
<<[Different types of keys](code/02/06/keys.groovy)


In the example above:

1. I create a new class (`Chicken`)
	1. ... and store a new instance of `Chicken` in the variable `cluckers`
2. I then create a map variable called `mixedMap` with different types of keys:
	1. `12` is a number
	2. `'chicken'` is a string
	3. `(cluckers)` indicates that the key is a variable value
3. I use the square-bracket notation and `get` method to access the value aligned to the key `12`
	1. `mixedMap.12` won't work
4. I use the square-bracket, dot-point and `get` method to access the value aligned to the key `'chicken'`
5. I use the square-bracket notation and `get` method to access the value aligned to the key `(cluckers)`
	1. `mixedMap.cluckers`
6. `println mixedMap` is called to display the map contents

T> I'd suggest you stick with strings as keys for now. I'd also suggest that using one type for your keys will usually make life a lot easier.

For those interested in such things, the `(cluckers)` key isn't affected if I change the value of `cluckers` later on. If you append the code below to the chicken example you'll see that `mixedMap.get(cluckers)` will now return `null` as the match fails. You'll also notice that `println mixedMap` is the same output you get before changing `cluckers`:

{title="Changing objects used as keys",lang=groovy}
	cluckers = new Chicken(name: 'Bill')
	println mixedMap.get(cluckers)
	println mixedMap


### Useful Map Methods

As with lists, the `size()` methods returns the number of elements in a map.

The `get` method can be used to get the value for the requested key. A second optional parameter can be provided and is returned if the map does not contain the requested key:

{title="Get method",lang=groovy}
	def periodic = ['h': 'hydrogen',
	        'he': 'helium',
	        'li': 'lithium']

	println periodic.get('he')
	println periodic.get('he', 'Unknown element')
	println periodic.get('x', 'Unknown element')


The `keySet()` method returns a list containing all of the keys in a map and `values()` returns a list of the values in a map:

{title="keySet method",lang=groovy}
	def periodic = ['h': 'hydrogen',
	        'he': 'helium',
	        'li': 'lithium']

	println periodic.keySet()
	println periodic.values()


The `containsKey()` and `containsValue()` methods are useful for checking on map contents:

{title="Checking for keys and values",lang=groovy}
	def periodic = ['h': 'hydrogen',
	        'he': 'helium',
	        'li': 'lithium']

	println periodic.containsKey('li')
	println periodic.containsValue('carbon')


The `asImmutable()` method works for maps in the same manner as it does for lists:

{title="Don't go changing",lang=groovy}
	def periodic = ['h': 'hydrogen',
	        'he': 'helium',
	        'li': 'lithium'].asImmutable()

	//This will cause an exception:
	periodic.x = 'new element'
