# Variable Arguments (Varargs) {#chvarargs}

I> Some methods are happy to take as many parameters as you can muster.

There are times where we want to pass a variable number of parameters to the method. However, the parameter list for a method is fixed.

One approach is to use a list for a catch-all parameter, such as `items` does in the code below:

{lang=Java}
<<[Using a list parameter](code/06/05/list.groovy)

Whilst the list path is an option, Groovy supports the use of variable arguments (varargs) using the "three-dot" (`...`) notation for the last (and only the last) parameter:

{lang=Java}
<<[Using a varargs parameter](code/06/05/varargs.groovy)

We can set a specific data type for the `items` parameter by placing the type before the `...`:

{lang=Java}
<<[Using a typed varargs parameter](code/06/05/varargs_typed.groovy)

Let's return to the first example in this chapter and rewrite it using varargs:

{lang=Java}
<<[Varargs instead of a list](code/06/05/list_rewrite.groovy)

So the `items` parameter is actually a list inside `buyGroceries` but the caller just passes a series of values to the method.

T> ## Varargs last
T> Putting a parameter after the variable arguments parameter doesn't make a great deal of sense as it'd be tricky to work out where `items` finished.
T>So, even if `def buyGroceries(store, ...items, travelTime)` was legitimate (and it isn't) I'd suggest that readability is lost and `travelTime` should appear before `items`. Alternatively, going back to using an array/list for `items` would solve the problem.
