# Relational Operators {#chrelops}

I> Less than, greater than and so on - it's all about how the operands relate.

Similar to the Equality Operators, the expressions involving Relational Operators return a boolean result (`true` or `false`). 

{title="The relational operators"}
|Operator|Name|     
|:------:|:--------|
|\>      |Greater than|
|\>=     |Greater than or equal to|
|<       |Less than|
|<=      |Less than or equal to|
|`<=> `    |Spaceship|

All of the following operations resolve to `true`:

{title="It's all `true`",lang=groovy}
	assert 5 > 2
	assert 4 >= 3
	assert 4 >= 4
	assert 8 < 9
	assert 6 <= 7
	assert 7 <= 7

Ordinarily, the operands used in a relational comparison can be compared in a meaningful manner. If they are different data types then the operands need to be able to find a common type for comparison (such as both being numbers) - the following code will cause and exception because Groovy can't be expected compare a string with a number in this way:

	if ('easy' < 123) println "It's easier than 123"

## Spaceship
The spaceship operator comes from the Perl programming language. The Spaceship operator is most often seen where sorting is done. 

{title="The spaceship operator"}
|Operator|  
|:------:|
|`<=>`      |  

In the example below the `sort` function uses the closure to define the sort algorithm and this is where the spaceship lands:

{title="UFO sighting",lang=groovy}
	def nums = [42, -99, 6.3, 1, 612, 1, -128, 28, 0]
	
	//Descending
	println nums.sort{n1, n2 -> n2<=>n1 }
	
	//Ascending
	println nums.sort{n1, n2 -> n1<=>n2 }

The following table indicates the result for spaceship expressions (LHS = left-hand side, RHS = right-hand side):

|Expression|Result
|:--|:--:
|LHS less than RHS|-1
|LHS equals RHS|0
|LHS greater than RHS|1

The following assertions all resolve as true:

	assert 2 <=> 2 == 0
	assert 1 <=> 2 == -1
	assert 2 <=> 1 == 1

## Overloading the relational operators
The `compareTo` method is used by Groovy to assess the result of relational operations:

		assert 1.compareTo(2) == -1
	
I> There is a reasonable assumption that the two operands can be coerced (cast) into a similar type. This is why `1.compareTo('cat')` just won't work.

Java's [`Comparable`](http://docs.oracle.com/javase/8/docs/api/index.html) interface is implemented by classes that allow instances to be compared. Custom classes can determine their own appropriate algorithm for the `Comparable`'s `compareTo` method and this will be available when you use the relational operators.

{title="Overloading relational operators",lang=groovy}
	class Num implements Comparable {
	    def val
	    
	    @Override
	    int compareTo(obj) {
	         if (val < obj.val) {
	             return -1
	         } else if (val > obj.val) {
	             return 1
	         } else {
	             return 0
	         } 
	    }
	}
	
	def a = new Num(val: 2)
	def b = new Num(val: 5)
	def c = new Num(val: 2)
	
	assert a < b
	assert b > a
	assert a != b
	assert a == c

You'll notice that I've tested `a != b` and `a == c` - these equality operators actually calls the `compareTo` method. There's been a bit of discussion about how Groovy handles `==` and the underlying `equals` and `compareTo` methods so if you're looking to overload these operators it'd be worth your time checking up on [what the Groovy developers are planning](http://blackdragsview.blogspot.fr/2015/02/getting-rid-of-compareto-for.html).