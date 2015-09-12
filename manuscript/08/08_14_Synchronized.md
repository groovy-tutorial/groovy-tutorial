# The `synchronized` modifier

W> This topic is really beyond the scope of this book - I've written this brief chapter so that you are aware of the
W> `synchronized` modifier but I leave in-depth investigation to other resources.

The `synchronized` keyword is used in concurrent environments in which multiple [threads](https://en.wikipedia.org/wiki/Thread_%28computing%29) are operating and there's potential that code running on different threads are interacting on the same section of code. The `synchronized` modifier is used to indicate that the associated element can only be accessed by one caller at a time. In the code below you'll see the various applications of `synchronized` available:

{lang=groovy}
<<[Various usage of `synchronized`](code/08/14/pool.groovy)

* First of all, member and static variables can be marked as `synchronized` - only one thread can read/write the variable at a time.
* Instance and class methods can also be marked as `synchronized`. Once called by one thread, any other threads are prevented from accessing the method until the first thread's call has completed.
* One or more blocks within an instance or class method can be `synchronized`[^note]:
    * Within an instance method the block is prefixed with `synchronized (this)` - note the use of an object instance (`this`)
    * For a class method, the block is prefixed with `synchronized (PrizePool)` - note the use of a class name (`PrizePool`)

[^note]: Whilst the example blocks use `this` instance and the `PrizePool` class, you can use other instances and classes.

T> Constructors can't be `synchronized`.

A good starting place for understanding this topic is the [Concurrency](http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html) section of The Java Tutorials. Additionally, [the GPars Framework](http://www.gpars.org/guide/guide/introduction.html) provides a library to assist you in writing concurrent/parallel Groovy and Java code.

T> ##Groovy threading
T> Groovy enhances Java's `java.lang.Thread` object and lets you run a closure in a new thread.
