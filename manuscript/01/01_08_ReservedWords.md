# Reserved Words  

I> Groovy reserves a set of keywords that cannot be used as identifiers.  

{title="Groovy's reserved words"}
| abstract | as  | assert | boolean | break | 
| byte | case | catch | char | class |
| const | continue | def | default | do |
| double | else | enum | extends | false |
| final | finally | float | for | goto |  
| if | implements | import | in | instanceof |
| int | interface | long | native | new |
| null | package | private | protected | public |
| return | short | static | strictfp | super |
| switch | synchronized | this | threadsafe | throw |
| throws | trait | transient | true | try | 
| void | volatile | while 	| 	|	| 

Groovy relies of a number of key words that it reserves for its own use. This means that you shouldn't use these words for the names of variables and other items you declare. For example, the code below won't run as `package` is a reserved word:

	def package = 'my package'
