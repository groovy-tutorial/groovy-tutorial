# Let Go of That Instance!

Sometimes your variable (e.g. a class instance) can end up holding a large amount of data. For example, you might have placed the text of the complete works of Shakespeare into a property. The JVM performs a process called _Garbage Collection_ so as to clean up data that you are no longer using. By assigning a variable to `null` we flag that the data previously held by the variable is no longer needed:

	myInstance = null

For small Groovy scripts this may never be an issue but, for long running applications, data hanging around and not being used can start to soak up a serious amount of resources, especially memory. Once you've finished with a variable it's worth assigning its value to `null` to let the JVM know you don't need it anymore.

You don't always need to explicitly set variables to `null` - this would make your code far less readable. The JVM knows that once a variable is no longer in scope, it's no longer accessible and, thus, is no longer needed. This means that if you have a variable declared inside a method, that its value is no longer needed once the method has completed. The same goes for variables declared within scopes such as loops.

There is an important caveat however, if multiple variables refer to the same data then the JVM can only release resources once all references have "unlatched". Let's examine this in the code below:

{lang=groovy}
<<[Example of multiple references to the same data](code/08/12/let_go.groovy)

I've defined a variable (`shakespeare`) to hold a new instance of the `SampleText` class and then said that another variable (`marlow`) points to that instance of `SampleText`. My call to `marlow.text` will still work despite my setting `shakespeare` to `null`. In this case we say that "`marlow` still holds a reference to the `SampleText` instance". This means that the JVM can't release the resources held by the instance until all references are set to `null`. I need to set `marlow` to `null` to completely release the resources.

T> ## Keeping track of references
T> Building up unused references to data is how a program will use up all of your system's memory and slowing everything to a crawl over time. When you have variables or collections of variables (such as lists) that you keep and add to over a long period of time you need to make sure you clean up what you don't need.

There's a lot more to garbage collection than I want to cover here but if you spend a few moments searching "Java Garbage Collection" you'll be able to delve deep into the topic.
