---
title:	Comments
status:	draft
...

| Type | Syntax |  
|  ------	| ------	|  
| Single-line	| `//comment`	|  
| Multi-line	| `/*...*/`	|  
| GroovyDoc	| `/**...*/`	| 

# GroovyDoc

|Tag	| Sample	|  Multiple| Scope	| 
| ------	| ------	|  ----------- |  -----------	| 
|@author	| `@author Fred Nurk`	| Y	| Overview, Class, Interface	| 
|@deprecated	| `@deprecated As of 1.3 - use altMeth()`	| N	| Class, Interface, Field, Constructor, Method	| 
|@throws	| `@throws java.io.FileNotFoundException`	| Y	| Constructor, Method	|  
|@param	| `@param name The name of the person`	|  Y	| Constructor, Method	| 
|@return	| `@return The sum of the squares`	| N	| Method	|  
|@see	| `@see Effective Java, 2nd edition`  \
`@see <a href="http://docs.oracle.com/javase/tutorial/">Java Tutorial</a>`  \
`@see java.lang.Object#wait`	| Y	| All

- Overview: Package-level documentation, usually stored in `overview.html`

See also: <http://docs.oracle.com/javase/1.5.0/docs/tooldocs/windows/javadoc.html>