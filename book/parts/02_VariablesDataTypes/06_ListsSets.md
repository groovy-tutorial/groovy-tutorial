---
Title:		Lists and sets  
Abstract:	 
...
## Lists

List variables contain several items and are declared using square brackets (`[...]`). 

```groovy
def temperatures = [10, 5, 8, 3, 6]
```

In the temperatures example the list contains just numbers but Groovy lists can contain a mix of data types:

```groovy
def mixed = [1, true, 'rabbit', 3.14]
println mixed[2]
```

In the example above you'll notice I've printed out `mixed[2]` - the list item with index 2. Somewhat confusingly this causes `rabbit` to be displayed. This is because lists are zero-based and the first item is at index 0, not index 1. Where we use `mixed[2]` we're asking for the third item in the list.

## Sets
Sets are much like arrays but each element in a set is unique:

````
def names = ['sally', 'bob', 'sally', 'jane'] as Set
println names
````

If you try the code above you'll get `[sally, bob, jane]` - the set just ignores the repeated element.

## Multidimensional lists