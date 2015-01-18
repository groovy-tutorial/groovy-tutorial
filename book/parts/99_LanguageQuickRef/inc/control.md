# Conditional (Branching) Statements

## `if-else`

### `if`

<pre>
if (<i>expression</i>) {
    <i>statement(s)</i>
}
</pre>

Single-line version:
<pre>
if (<i>expression</i>) <i>statement</i>
</pre>

### `else`

<pre>
if (<i>expression</i>) {
    <i>statement(s)</i>
} else {
    <i>statement(s)</i>
}
</pre>

Single-line version:
<pre>
if (<i>expression</i>) <i>statement</i> else <i>statement</i>
</pre>

### `if-else-if`

<pre>
if (<i>expression</i>) {
    <i>statement(s)</i>
} else if (<i>expression</i>) {
    <i>statement(s)</i>
} else {
    <i>statement(s)</i>
}
</pre>

## `switch`
<pre>
switch(<i>expression</i>) {
    case <i>expression</i>:
	<i>statement(s)</i>
        break
    //
    default:
        <i>statement(s)</i>
}
</pre>

-  0 to _n_ `case` blocks can be used
- `break` is optional - its absence will cause fall-through to next case
- `default:` section is optional

## `try-catch-finally`

### `try-catch`
To catch any exception raised in a `try` block:
<pre>
try {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
}
</pre>

To catch a specific exception use the specific exception type:
<pre>
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} 
</pre>

Provide multiple `catch` blocks to handle different exceptions:
<pre>
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
}
</pre>

Provide a "catch-all" for unexpected exceptions:
<pre>
try {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(<i>Exception</i> e) {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
}
</pre>

### `finally`
<pre>
try {
    <i>statement(s)</i>
} catch(any) {
    <i>statement(s)</i>
} finally {
    <i>statement(s)</i>
}
</pre>
