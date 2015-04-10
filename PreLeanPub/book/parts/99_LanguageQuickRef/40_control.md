---
title:	Conditional (Branching) Statements
status:	draft
...

# if-else

## if

<pre><code class="groovy hljs xml">
if (<i>expression</i>) {
    <i>statement(s)</i>
}
</code></pre>

Single-line version:
<pre><code class="groovy hljs xml">
if (<i>expression</i>) <i>statement</i>
</code></pre>

## else

<pre><code class="groovy hljs xml">
if (<i>expression</i>) {
    <i>statement(s)</i>
} else {
    <i>statement(s)</i>
}
</code></pre>

Single-line version:
<pre><code class="groovy hljs xml">
if (<i>expression</i>) <i>statement</i> else <i>statement</i>
</code></pre>

## if-else-if

<pre><code class="groovy hljs xml">
if (<i>expression</i>) {
    <i>statement(s)</i>
} else if (<i>expression</i>) {
    <i>statement(s)</i>
} else {
    <i>statement(s)</i>
}
</code></pre>

# switch
<pre><code class="groovy hljs xml">
switch(<i>expression</i>) {
    case <i>expression</i>:
	<i>statement(s)</i>
        break
    //
    default:
        <i>statement(s)</i>
}
</code></pre>

-  0 to _n_ `case` blocks can be used
- `break` is optional - its absence will cause fall-through to next case
- `default:` section is optional

# try-catch-finally

## try-catch
To catch any exception raised in a `try` block:

<pre><code class="groovy hljs xml">
try {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
}
</code></pre>

To catch a specific exception use the specific exception type:

<pre><code class="groovy hljs xml">
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} 
</code></pre>

Provide multiple `catch` blocks to handle different exceptions:

<pre><code class="groovy hljs xml">
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
}
</code></pre>

Provide a "catch-all" for unexpected exceptions:

<pre><code class="groovy hljs xml">
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
}
</code></pre>

## finally
<pre><code class="groovy hljs xml">
try {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
} finally {
    <i>statement(s)</i>
}
</code></pre>
