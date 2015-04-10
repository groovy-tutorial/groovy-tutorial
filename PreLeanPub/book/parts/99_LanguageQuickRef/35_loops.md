---
title:	Loops
status:	draft
...

The following statements affect loops: 

- `break` causes the enclosing loop to complete
	- No further iterations are performed
- `continue` causes the current iteration to end and control is passed to the enclosing loop to evaluate the next iteration. 

# for
Groovy-style iteration:

<pre><code class="groovy hljs xml">
for (<i>[Type] parameter</i> in <i>expression</i>) {
    <i>statement(s)</i>
}
</code></pre>

- On the commencement of each iteration of the loop, `parameter` is assigned the next element from the iterator determined by `expression`
- A data type `[Type]` can be declared for the `parameter`

Java-style iteration:

<pre><code class="groovy hljs xml">
for (<i>Type parameter</i>: <i>expression</i>) {
    <i>statement(s)</i>
}
</code></pre>

- The data type for `parameter` must be declared
 
Traditional `for` loop:

<pre><code class="groovy hljs xml">
for (<i>[init_expression]</i>; <i>[expression]</i>; <i>[update_expression]</i>) {
    <i>statement(s)</i>
}
</code></pre>

- `init_expression` is performed before the loop starts
	- Optional
- `expression` is evaluated before each iteration. 
	- If _expression_ resolves to `false` the `for` statement is completed.
	- If _expression_ resolves to `true` the iteration commences.
	- Optional
- `update_expression` is evaluated at the completion of an iteration
	- This occurs prior to the next evaluation of `expression`
	- Optional

# while

<pre><code class="groovy hljs xml">
while (<i>expression</i>) {
    <i>statement(s)</i>
}
</code></pre>

# do while

This is not supported in Groovy. Don't be sad.
