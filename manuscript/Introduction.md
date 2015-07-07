# Introduction

I like Groovy.

I like the way it lets me use the Java skills I've built up over the years but it makes it easier to code solutions to problems. I like the way it doesn't, well, get in the way. With Groovy I can:

- Easily code small scripts to perform command-line tasks
- Tie together existing systems and libraries - leveraging the breadth and depth of existing Java-based projects
- Write entire applications that can be deployed onto any system running the Java Virtual Machine (JVM) - without having to tell people the code isn't in Java.

Groovy programs run on the Java Virtual Machine (JVM) and the JVM is installed across a huge spectrum of systems: desktops, servers, mobiles and the Internet of Things. Importantly, the Java world has been going through a great renewal phase. Where once the JVM and the Java programming language were almost synonyms, a range of JVM-based languages have appeared: Groovy, [Scala](http://www.scala-lang.org/), [Clojure](http://clojure.org/), [Jython](http://www.jython.org/). These aren't languages that run within a Java program (though many can do just that), these are languages that compile down to JVM bytecode and run in a way that means you don't even need to tell your SysAdmin that you didn't write it in Java. What's more, we're not at the "cutting edge" of this approach - it's been going for long enough that you can expect a level of stability that supports the use of these languages in real application development.

In the following tutorials I aim to guide you through the basics of Groovy. I haven't really focussed on writing a "How to program" guide nor do I expend a lot of words comparing Groovy with Java. You may also notice that I haven't included the output of most of the code examples - this is to save some clutter in the text and encourage you pop open a groovyConsole and try the code for yourself. Go on, you know you'll love it.

I really hope that this tutorial gives you a basis in understanding the Groovy language and I hope that you start to see why I like Groovy so much.

Q> ## Did you know?
Q> As of March 2015 Groovy entered the incubation phase at Apache?
Q> This is the first step towards having Groovy become a full-blown Apache project.

## Something Wrong?

If you find something wrong I'd really appreciate you letting me know via either:

- A [Leanpub email message](https://leanpub.com/groovytutorial/email_author/new); or
- Through the [Feedback tool](https://leanpub.com/groovytutorial/feedback)

Please remember that I'm not a big corporation or an automaton - I can't  respond immediately to queries and I am an assemblage of emotions that respond well to positive encouragement a lot better than negativity.

## Bookmarks

Between Groovy and Java there's a lot of useful websites - this is a few key ones you'll want to have in your browser. 

Core resources to have at-hand:

- [The Groovy homepage](http://www.groovy-lang.org/) is a great starting point.
- The latest Groovy API documents are available at:
	- [The Groovy API](http://groovy-lang.org/api.html)
		- aka the GAPI
	- [The Groovy extensions to the JDK](http://groovy-lang.org/gdk.html)
		- aka the GDK
- The [Java API](http://docs.oracle.com/javase/7/docs/api/) always comes in handy
	- So do [The Java Tutorials](http://docs.oracle.com/javase/tutorial/)
- Whilst not a perfect fit for Groovy, I tend to use the [Google Java Style](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html) as my stern mentor.

Great blogs and sites that provide Groovy coding examples:

- [Mr Haki](http://mrhaki.blogspot.com.au/search/label/Groovy) - A really useful site containing heaps of Groovy code examples.
- [InfoQ](http://www.infoq.com/groovy) - Another useful site for Groovy articles.
- My own [Workbench](http://workbench.duncan.dickinson.name) blog is very young but has a few Groovy samples.

The book [Groovy in Action (2nd Edition)](http://www.manning.com/koenig2/) will help you go further with your Groovy programming.

If you find yourself stuck and needing some help, the following channels are worth tuning into:

- [StackOverflow's Groovy tag](http://stackoverflow.com/questions/tagged/groovy) is really useful 
	- search for an answer before posting a question
	- Check out their article "[How do I ask a good question?](http://stackoverflow.com/help/how-to-ask)" - it's an excellent outline for asking in a way people may answer
- The [Groovy Mailing lists](http://groovy-lang.org/mailing-lists.html) are also worth joining and searching

I suggest to anyone within the orbit of Java that "Effective Java (2nd edition)" by Joshua Bloch should not only be read (repeatedly) but always at-hand.

## Conventions Used in This Book

I've tried to present this book in a manner that will suit both the reader that likes a linear path of front-to-back and those who like to dip in on specific items.  

### Code

Code is displayed using a `monospaced` font.

Code presented within regular language looks something like:

> Use of `println` as your primary testing framework is discouraged.

Blocks of code are presented as follows:

{title="A block of code",lang=groovy}
	def name = "Billy"
	println "Hi there $name"

Some code doesn't feature a title and is presented so as to be more aligned with the flow of the text:

	def name = "Billy"
	println "Hi there $name"

I've opted not to display line numbers with code as it makes copy and paste difficult.

### Asides

I use a variety of asides to note information. These appear with an icon and some text and, on most occasions, feature a title.

I> ## An informative message
I> These provide some extra context

T> ## A tip
T> These are handy tips

W> ## A warning message
W> These point out things to worry about

## Your Rights and This Book
I'm making the "Groovy Tutorial" freely available because I feel that open source projects such as Groovy deserve to have a variety of documentation that helps people use open source software. This body of work is one that took a significant amount of unpaid time but I have benefitted from many people's work in developing open source software and the associated, freely available text, that they make available. 

This work is licensed under a Creative Commons Attribution License - this means that you have the right to share and adapt the text as you see fit *but* you must give me _"appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use"_. If you decide to use the whole text or parts thereof in a manner that derives you an income I think it'd be civil of you to consider contributing to my retirement fund.

All code samples are licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0.html)

The "source code" for this book is written in Markdown, based on the [LeanPub Manual](https://leanpub.com/help/manual). You can access the source from my [Git repository](https://bitbucket.org/duncan_dickinson/groovy-tutorial).

I don't provide any warranties, guarantees or  certainties[^note]. You should use this text to help you in your Groovy coding but you are responsible for your journey :)

[^note]: ... or pekignese