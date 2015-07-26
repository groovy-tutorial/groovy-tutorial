# Simple Assignment Operator

I> Assigns a value to a variable

{title="Simple assignment operator"}
|Operator|
|:------:|  
|`=`|

The equals (`=`) sign is used to assign a value to a variable:

	def age = 101
	def name = "Fred"

W> Assignment and equality
W> Be aware that the `=` and `==` operators perform different roles. In Groovy the equality operator (`==`) is used to determine if two things are the same.

In the following code the variable `count` is assigned the numeric value `10`:

	def count = 10

If we then wanted compare `count` with another value (`11`) we need to use the `==` operator:   

	if (count == 11) println "Count is 11"

Use of `=` in the comparison will cause a compilation error:

	if (count = 11) println "Count is 11"

Rest assured that if you accidentally use the simple assignment operator (`=`) instead of the equality operator (`==`) you'll not be the first in making that mistake.