# Booleans

I> Booleans help you get to the truth of the matter.

Boolean variables are perhaps the simplest and can hold a value of either `true` or `false`.

{title="Booleans",lang=groovy}
	def truth = true
	def lies = false


## Useful Methods

Booleans have a small number of methods that you generally won't find yourself using as they (mostly) have equivalent operators that are more "natural" to read and write.

The `and(right)` method performs a logical 'and'

{title="The and method",lang=groovy}
	def truth = true
	def lies = false
	assert truth.and(lies) == false 


The conditional And operator (`&&`) is equivalent to the `and` method and the assertion above could also be written as `assert truth && lies == false`

The `or(right)` method performs a logical 'or'

{title="The or method",lang=groovy} 
	def truth = true
	def lies = false
	assert truth.or(lies) == true 


The conditional Or operator (`||`) is equivalent to the `or` method and the assertion above could also be written as `assert truth || lies == true`
