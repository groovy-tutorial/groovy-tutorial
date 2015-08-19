#Regular Expression Operators

I> These are useful for comparing strings to regular expressions. They still don't help you work out the regular expression.

The [earlier tutorial on Regular Expressions](#chregex) covered regular expression (pattern) variables and described the `find` and `match` methods. These operators are similar to these methods but return `true` or `false` if the pattern is found in (`find`) or matches (`match`) the first operand (a string).

{title="RegEx operators"}
|Operator(s)     |Type
|:------------------:|:--------------------|
| `=~`	| Find	|
| `==~`	| Match	|

For these operations, the left-hand operand must be a string and the right-hand operand a regular expression pattern.

## Find (`=~`)
Returns `true` if the string on the left-side contains the pattern on the right of the operator.

	def regex = ~/:[0-9]+/
	def httpUrl1 = 'http://www.example.com:8080/'
	def httpUrl2 = 'http://www.example.com/'

	assert httpUrl1 =~ regex
	assert ! (httpUrl2 =~ regex)


## Match (`==~`)
Returns `true` if the string on the left-side matches (completely) the pattern provided on the right of the operator

	def regex = ~/https?:\/\/.*/

	def httpUrl = 'http://www.example.com/'
	def ftpUrl = 'ftp://ftp.example.com/'

	assert httpUrl ==~ regex
	assert ! (ftpUrl ==~ regex)
