---
Title:	Conditionals
Description:	Conditional statements let you determine when to run sections of code.
...

# The `if` statement


As an example, let's say we have some code that displays the result of a division. It's very important that we don't try to divide a number by 0 as this causes an error. In the code below we use the `if` statement to check if the denominator is `0` before we perform the division:

```groovy
def numerator = 0
def denominator = 0

// ... various statements

if (denominator != 0) {
    println numerator / denominator
}
```

`if` evaluates the conditional expression between the parentheses - `(..)` - and will only process the statement block if the conditional result is `true`.

## `if` - `else`

An `else` section can be provided where you want to process statements when the conditional result is `false`.

```groovy
def numerator = 0
def denominator = 0

// ... various statements

if (denominator != 0) {
    println numerator / denominator
} else {
    println 'I refuse to divide by zero'
}
```

## `if` - `else if` - `else`

`if` and `else` let you deal with situations where you have two possible outcomes but sometimes you might have a few conditions that you want to check for: 

```groovy
def game = 'twister'

if (game == 'chess') {
    println 'I like to play chess'
} else if (game == 'twister') {
    println 'I can play twister if you want'
} else {
    println "Sorry, I don't know how to play $game"
}
```

The code above 

It's important to note that once a conditional evaluates to `true`, no other conditionals in the `if` statement are evaluated. It's a case of the first positive match wins. In the code below, the conditional `(game=='chess' || game == 'twister')` is redundant because an earlier condition would have returned `true` (`(game == 'chess')`)

```groovy
if (game == 'chess') {
    println 'I like to play chess'
} else if (game == 'twister') {
    println 'I can play twister if you want'
} else if (game=='chess' || game == 'twister') {
    println 'Can you really play both of these at once?'
} else {
    println "Sorry, I don't know how to play $game"
}
```

# The `switch` statement