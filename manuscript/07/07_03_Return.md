# Returning Values

I> Closures can return values just like methods.

Just like methods, closures can return a value. In this next example, the result of the last expression is returned (the value of `num1` or `num2`):

{lang=Java}
<<[Returning a value](code/07/03/return.groovy)

Alternatively, we can use the `return` statement to explicitly exit the closure and return a value:

{lang=Java}
<<[Explicitly returning a value](code/07/03/return_explicit.groovy)

Unlike a method, closures can't explicitly define the data type of a return value. You might take a crack at `Integer maxNumber = {num1, num2 -> ...}` to set the return type but this statement won't work as `maxNumber` doesn't hold the result of the closure - it holds a reference to the closure.

`Closure myClosure = { num1, num2 -> ...}` will work as the `myClosure` variable is actually of the `Closure` data type.



