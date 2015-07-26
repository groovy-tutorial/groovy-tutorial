# Throwing an exception

I> Your method can throw an exception.

A method is able to throw an exception just as we saw in the Exceptions tutorial. In the code below I throw an exception if the caller to `determineAverage()` tries to pass a String through as a parameter:

{lang=groovy}
<<[Throwing an exception from a method](code/06/07/throw.groovy)

None of that code is new to you except for the `throws IllegalArgumentException` that forms part of the method's signature[^sign]. The use of `throws` helps describe our method a little better by making callers aware of what to expect.

Multiple exceptions can be listed against `throws`, as seen in the example below:

{lang=groovy}
<<[Throwing exceptions from a method](code/06/07/throw_multiple.groovy)

Groovy doesn't require that you explicitly provide a `throws` listing if your method throws an exception or passes up an exception that it doesn't handle. However, if your method is to be used by others, I'd suggest that including `throws` is worth the effort.

You may note that, in that last example, I placed `throws` on a second line - this helps readability as it breaks up the display of the signature just slightly.

[^sign]: This is the section of the method definition contain the return type, method name, parameters and thrown exceptions. As always, [Wikipedia has some further information](https://en.wikipedia.org/wiki/Type_signature#Method_signature)
