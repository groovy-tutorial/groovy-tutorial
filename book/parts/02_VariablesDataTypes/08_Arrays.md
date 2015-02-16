---
title:	Arrays
status:	in-progress
description:	You should use collections rather than arrays but you should probably know about arrays. 
...

For my money, the collections we've just looked at (lists, sets maps) are more versatile than arrays and collections are my preferred approach. However, there's a lot of code out there using arrays so let's take a quick look.

Arrays contain a fixed number of elements of a specified data type.  Let's look at an example of array declaration and usage:

```groovy
Number[] point = new Number[2]

point[0] = 27
point[1] = -153

assert point.size() == 2
```

So let's dissect that last bit of code:

- The `point` variable is declared using `Number[] point = new Number[2]`
	- `Number[]` indicates that we want an array of Numbers
		- `[]` indicates that the variable is an array, not just a single Number value
		- We don't use `def` as we're specifying the data type
	- `new Number[2]` sets `point` to be an empty array that can contain two (2) elements
- Arrays are zero-based, meaning that the first element is at index 0
	- `point[0]` is the first element
	- `point[1]` is the second
- `point.size()` returns the number of elements in the array
	- Note that the range of indexes for an array is `0..(point.size() - 1)`

>`point.length` would also work and provides the same result as `point.size()` 

It's important to note that the `size` of an array is fixed at declaration. If you decide that you need to expand the array then you'll slap your forehead and ask "Why didn't I use collections?". If you dig your heels in and stay with arrays you might check out the `java.lang.System.arraycopy` method and learn the gentle art of copying and resizing arrays. Then, you'll start using collections.	
If I'd tried something like `point[2] = 99` I would get a `java.lang.ArrayIndexOutOfBoundsException` as the array can only hold 2 elements.

We can be more direct in creating the array and provide the values up-front. In the example below I create an array that can hold two elements and I load the values into the array:

```groovy
Number[] point = [27, -153]
```

So, why did I pick `Number`? Well, I want an array of numerical values but perhaps wasn't sure which _type_ of numbers. Provided the values I put into the array are subtypes of `Number`, all will be well. That means the following will work fine and nothing will be truncated:

```groovy
Number[] point = [27.9, -153]
```

If I really wanted to be specific I could have declare `point` as an array of `Integer` values:

```groovy
Integer[] point = [27, -153]
```

Arrays can also be declared to be of a primitive type such as `int`:

```groovy
int[] point = [27, -153]
```

Going further with subtypes etc, arrays can be of any type and the `Object` class provides a flexible type when your array needs to hold a mixture of values (e.g. numbers, strings, various types):

```groovy
Object[] bag = new Object[4]
bag[0] = true
bag[1] = 'Rabbit'
bag[2] = 3.14
bag[3] = null
```

Without wanting to be repetitive, the example above would probably be easier to work with if we used a collection such as a list.

# Manipulating arrays

We've seen the `sort()` method and `length` property - both indicating how many elements the array can hold.

Sorting an array is easy with the `sort()` method:

```groovy
Number[] nums = [99, 10.2, -7, 99.1]
nums.sort()
println nums
```

> Note that the `sort()` modifies the `nums` array. 

Of course `sort()` works well if the element types have a meaningful sorting order but try out the following code and you'll see that the `sort()` perhaps isn't overly useful on mixed values:

```groovy
Object[] bag = new Object[4]

bag[0] = true
bag[1] = 'Rabbit'
bag[2] = 3.14
bag[3] = null

println bag.sort()
```

Use the `Arrays.asList()` static method to get a copy of an array into a list (collection):

```groovy
Number[] nums = [99, 10.2, -7, 99.1]
def list = Arrays.asList(nums)
```

Alternatively, you can use the `as` operator to cast the array to a List.

```groovy
Number[] nums = [99, 10.2, -7, 99.1]
def list = nums as List
```

Check out the `java.util.Arrays` class for more array methods.