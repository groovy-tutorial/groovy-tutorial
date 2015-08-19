#Parameters

I> Closures can take parameters - just like methods.

We just saw that closures have an in-built `it` parameter but we can specify a parameter when we declare the closure:

{lang=groovy}
<<[Specifying a parameter](code/07/02/closure_parameter.groovy)

In the example above I declare the `name` parameter and this replaces `it` - in fact, if I called `it` within the closure I'd get an exception.

The syntax of closures is starting to become evident:

1. Start the closure with `{`
2. List parameters, followed by `->`
3. Write a set of statements for the closure body
4. End the closure with `}`

Each parameter is separated using a comma (`,`):

{lang=groovy}
<<[Specifying two parameters](code/07/02/closure_parameters.groovy)

As the closure gets more complicated I like to break it up over a number of lines. I start the closure and declare the parameters on the first line. The body of the closure then follows much the same as a method body and a final line closes off the closure:

{lang=groovy}
<<[Formatting a closure](code/07/02/closure_parameters_format.groovy)

Closure parameters let me do the same things I can do with method parameters:

1. Use data types for parameters
2. Provide default values
3. Varargs
4. Named parameters

**Parameter data types:**

{lang=groovy}
<<[Specifying typed parameters](code/07/02/closure_parameters_typed.groovy)

**Default values:**

{lang=groovy}
<<[Specifying parameters with default types](code/07/02/closure_parameters_defaults.groovy)

**Varargs:**

{lang=groovy}
<<[Specifying varargs](code/07/02/closure_parameters_varargs.groovy)

**Named parameters:**

{lang=groovy}
<<[Specifying "named" parameters](code/07/02/closure_parameters_named.groovy)

So closures and methods are rather similar - there's no black magic going on.
