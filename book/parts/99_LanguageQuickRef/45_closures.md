---
title: Closures
...
Basic form:
<pre>
<i>[assignment]</i> {
    <i>statement(s)</i>
    [return <i>statement</i>]
}
</pre>

- _[assignment]_ of the closure is to a variable, including a method parameter
	- e.g. `def myClosure = {...}`
	- e.g. `methodCall(param1){...}` 
		- ... or less often `methodCall(param1, {...})`
- The `it` parameter is implicitly provided but is not available when explicit parameters are declared
- The closure will return a result, being determined as either:
	- Explicitly declared using the `return` keyword
	- The result of the last statement evaluated in the closure 

To preclude any parameters (including `it`):
<pre>
<i>[assignment]</i> { ->
    <i>statement(s)</i>
    [return <i>statement</i>]
}
</pre>

Explicit parameter declaration:
<pre>
<i>[assignment]</i> { [Type] <i>parameter_name</i> <i>[= default_value]</i> <i>[, params</i>] ->
    <i>statement(s)</i>
}
</pre>

- The parameter's data type may be explicitly declared (`[Type]`)
	- ... but this isn't common
- 0.._n_ parameters can be declared, separated by a comma (`,`)
- A default value can be provided for the parameter (`[= default_value]`)

Variable arguments (var-arg):
<pre>
<i>[assignment]</i> { <i>[params,]</i> [Type]... <i>parameter_name</i> ->
    <i>statement(s)</i>
}
</pre>

- The var-arg parameter must be the last parameter declared
