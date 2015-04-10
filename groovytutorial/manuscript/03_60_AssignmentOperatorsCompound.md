# Compound Assignment Operators

I> The compound assignment operators help make code that bit more compact by performing an operation in-place.

The compound assignment operators[^aug] really just conflate an operation that involves a variable which is, it turn, used to store the result. Let's look at an example to make this clearer. In the example below I really just want to add 10 to the `cost` variable:

	def cost = 20
	cost = cost + 10
	assert cost == 30

By using a compound assignment operator I can clean up the code (in a very minor way) by performing the operation 'in place':

	def cost = 20
	cost += 10
	assert cost == 30

{title="The compound assignment operators"}
|Operator |Name	| 
|:------:|:--------|  
| \*=      	| Multiply	| 
|/=   	| Divide	|  
|%=      	| Remainder	| 
|+=      	| Plus	| 
|-=      	| Minus	|  
|**=	| Power	| 
|<<=     	| Bitwise left-shift	| 
|\>>=    	| Bitwise right-shift	| 
|\>>>=  	| Bitwise unsigned right-shift	| 
|&=      	| Bitwise And	| 
|^=      	| Bitwise Xor	| 
|\|=     	| Bitwise Or	|  

[^aug]: Also known as augmented assignment operators. See <http://en.wikipedia.org/wiki/Augmented_assignment>