# Increment and Decrement Operators

I> Number goes up. Number goes down.

The increment operator increments a value to its next value. When you increment or decrement a variable using `++` or `--` the variable is modified to the new value.

{title="Inc and dec"}
|Operator|Name	| 
|:------:|:--------| 
|++      |Increment	| 
|--      |Decrement	| 


The increment and decrement operators come in two flavours, prefix and postfix:

* Prefixes are assessed _before_ the statement is evaluated
	* `assert ++5 == 6`
* Postfixes are assessed _after_ the statement is evaluated
	* `assert 5++ == 5`

{title="Using inc and dec",lang=groovy}
	assert 10++ == 10
	assert ++10 == 11
	assert --10 == 9
	assert 10-- == 10


The increment and decrement behaves differently depending on the type of value being used:

Booleans
:	These don't increment/decrement

Numbers
:	 Numbers increment/decrement by 1:

	def num = 10
	num++
	assert num == 11

Characters
:	Characters move to the previous (`--`) or next (`++`) character:

	def ch = 'c'
	ch--
	assert ch == 'b'

Strings
:	Strings are a little odd and it is the last character in the string that is affected:
	
	def str = 'hello'
	str++
	assert str == 'hellp'

Enums
:	Enums will cycle through the enum values:

	enum Priority {
	    LOW, MEDIUM, HIGH
	}
	def task = Priority.LOW
	task++ 
	assert task == Priority.MEDIUM
	
:	**BUT** be aware that you'll cycle back to the beginning of the value list. The following example is a good example of where you can easily get caught out:

	def task = Priority.LOW
	task-- 
	assert task == Priority.HIGH

:	We'll get to Enums much later. 

## Overloading the Increment and Decrement Operators

By overloading `next` and `previous` methods, a custom class can support the increment and decrement operators.

The example below demonstrates a class that only allows numbers to increment/decrement to even numbers:

{title="Overloading increment and decrement",lang=groovy}
	class Evens extends Object {
	    def value
	    
	    Evens(val) {
	        this.value = val
	    }
	    
	    public setValue(val) {
	        if (val % 2 == 0) {
	            this.value=val
	        }
	    }
	    
	    def next() {
	        value += 2
	        return this
	    }
	    
	    def previous() {
	        value -= 2
	        return this
	    }
	    
	    String toString(){
	        return "I have a value of ${this.value}"
	    }
	}
	
	def two = new Evens(2)
	println two
	two++
	println two
	two--
	println two
