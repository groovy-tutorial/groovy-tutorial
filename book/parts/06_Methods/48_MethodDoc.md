---
title:	Documenting a method
status:	in-progress
description:	GroovDoc helps us document our methods
...

The `groovydoc` command that comes with the Groovy installation can be used to generate HTML documentation from comments within your code. GroovyDoc is based on [JavaDoc](http://docs.oracle.com/javase/1.5.0/docs/tooldocs/windows/javadoc.html#documentationcomments) and uses much the same syntax.

Let's look at a Groovy method that features GroovyDoc comments:

```groovy
/**
 * Returns the average of the parameters
 *
 * @param values  a series of numerical values
 * @throws IllegalArgumentException if a parameter is a String
 * @returns The average of the values
 */
def determineAverage(...values) 
  throws IllegalArgumentException {
    for (item in values) {
        if (item instanceof String) {
            throw new IllegalArgumentException()
        }
    }
    return values.sum() / values.size()
}
```

Taking a look at the commenting:

- The multi-line comment block starts with `/**` to indicate that this is a GroovyDoc
- The first piece of text provides the summary of the method. It's one line and meant to be terse. 
- A set of `@param` tags can be provided to describe each parameter. 
	- The format is `@param <parameter name> <summary>`
	- You don't provide the parameter type even if you declare one
- Each exception that can be thrown by the method is listed against a `@throws` tag and provides a summary as to when the exception may be thrown.
	- The format is `@throws <exception class> <summary>`
- The `@returns` tag describes what the method will `return`
	- The format is `@returns <summary>`

If you copy the sample code into a file named `Average.groovy` you can then run the following command in your command line/terminal:

```bash
groovydoc -d doc Average.groovy
```

This will produce a directory named `doc` that contains a set of documentation files. Inside the `doc` directory you'll see `index.html` - open this in a browser to view your documentation.

As you click through the various links you'll find the documentation for the `determineAverage()` method. It'll contain the following information (but look a lot prettier):

---
<ul>
                            <li>
                                <h4>java.lang.Object <strong>determineAverage</strong>(java.lang.Object... values)</h4>
                                <p> Returns the average of the parameters</p><dl><dt><b>throws:</b></dt><dd>IllegalArgumentException if a parameter is a String</dd></dl><dl><dt><b>returns:</b></dt><dd>The average of the values</dd></dl>
 <dl><dt><b>Parameters:</b></dt><dd><code>values</code> -   a series of numerical values</dd></dl><p></p>
                            </li>
                        </ul>
---

If you keep clicking links in the html files but can't find it, look in the `DefaultPackage` directory for a file name `Average.html` - that'll be what you're after.