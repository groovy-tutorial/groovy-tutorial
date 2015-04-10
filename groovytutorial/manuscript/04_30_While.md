# The `while` loop

I> The while loop comes in one model which will do just fine

The `while` loop will  repeat a block of code whilst its condition is `true`:

{title="While",lang=groovy}
	while (<condition>) {
		//statements
	}

I>Unlike the `for` loop, there is only the one syntax for `while` loops. 

`while` loops feature the following:

* `<condition>` can be a value or expression - the loop will only iterate if `<condition>` is `true`.
* The `while` loop syntax does not manage an iterator variable - you must do this yourself
	* It's very easy to create an infinite `while` loop if you're not paying attention

The example below uses a common approach for `while` loops and sets a flag to indicate when the desired state has been reached and the loop can stop:

	def flag = false
	def num = 0
	
	while (!flag) {
	    num++
	    if (num**2 == 64) {
	        flag = true
	    }
	}
	
	println "The square root of 64 is $num"

The code above will increment `num` by 1 each iteration and test to see if num^2 is equal to 64. Once the correct `num` is reached, `flag` is change to `true` and the `while` condition now resolves to `false` - indicating that the `while` loop should run the next iteration.

The `while` loop can also be used to create an infinite loop: `while(true) {}`

## There is no `do...while` loop 

Unlike Java, Groovy does not have a `do...while` loop[^dowhile]. Don't be sad.

[^dowhile]: [A ticket](https://jira.codehaus.org/browse/GROOVY-5348) has been lodged to request one.