# Statements  

I> A Groovy program is made up from lots of statements, each telling the computer to do something.

A Groovy statement is generally completed by an end-of-line (EOL) character such as a carriage return:

	def num = 21
	println num

A semicolon (`;`) can be used to explicitly mark the end of a statement however this is deemed to be redundant in most cases and spoils readability:

	def num = 21;
	println num;

The backslash (`\`) is used indicates that a statement continues on the next line. The example below uses continuation to break up a long statement:

	def solution =  1 * 2 * 3 \
                    * 4 * 5 * 6

Without the backslash the code above would cause an error but a minor rewrite will work:

	def solution =  1 * 2 * 3 *
                4 * 5 * 6

I would suggest the first version is easier to read and explicitly indicates that you intend to carry into the next line. However, statements can span multiple lines without a backslash provided Groovy can determine that the lines make up a single statement. This feature should be utilised if it aids in improved readability - this is often referred to as _line-wrapping_. For example, an array declaration that provides a number of entries may be written as:

{title="Okay formatting",lang=groovy}
	def myArray = ['Tasmania', 'Victoria', 'New South Wales', 'Queensland', 'Western Australia', 'South Australia']
    
The judicious use of line-wrapping may improve readability:  

{title="Better formatting",lang=groovy}
	def myArray = ['Tasmania', 
	               'Victoria',
	               'New South Wales',
	               'Queensland',
	               'Western Australia',
	               'South Australia']

It is difficult to provide specific metrics regarding readability in these cases and the programmer is left to determine the best use of white space and placement.

## Usage to avoid

A semicolon can be used to separate two statements appearing on the same line:

{title="One statement per line please",lang=groovy}
	def num = 1 + 1; println num

The presentation of multiple statements in a single line should be avoided - it's not easy to read and is likely to trip you up at some point.

Groovy is very forgiving of statements spread over more than one line but usage such as the one below should be avoided as it reduces readability. For example, the following code will actually work but it looks odd and isn't worth the hassle:

{title="Keep things together",lang=groovy}
	def num = 1 +
	1
	println num
