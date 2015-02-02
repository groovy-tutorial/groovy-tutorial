---
title:	Introduction
...
I like Groovy.

I like the way it lets me use the Java skills I've built up over the years but it makes it easier to code solutions to problems. I like the way it doesn't, well, get in the way. With Groovy I can:

- Easily code small scripts to perform command-line tasks
- Tie together existing systems and libraries - leveraging the breadth and depth of existing Java-based projects
- Write entire applications that can be deployed onto any system running the Java Virtual Machine (JVM) - without having to tell people the code isn't in Java.

Groovy programs run on the Java Virtual Machine (JVM) and the JVM is installed across a huge spectrum of systems: desktops, servers, mobiles and the Internet of Things. Importantly, the Java world has been going through a great renewal phase. Where once the JVM and the Java programming language were almost synonyms, a range of JVM-based languages have appeared: Groovy, [Scala](http://www.scala-lang.org/), [Clojure](http://clojure.org/), [Jython](http://www.jython.org/). These aren't languages that run within a Java program (though many can do just that), these are languages that compile down to JVM bytecode and run in a way that means you don't even need to tell your SysAdmin that you didn't write it in Java. What's more, we're not at the "cutting edge" of this approach - it's been going for long enough that you can expect a level of stability that supports the use of these languages in real application development.

In the following tutorials I aim to guide you through the basics of Groovy. I haven't really focussed on writing a "How to program" guide nor do I expend a lot of words comparing Groovy with Java. You may also notice that I haven't included the output of most of the code examples - this is to save some clutter in the text and encourage you pop open a groovyConsole and try the code for yourself. Go on, you know you'll love it.

I really hope that this tutorial gives you a basis in understanding the Groovy language and I hope that you start to see why I like Groovy so much.

## Something Wrong?

If you find something wrong I'd really appreciate you letting me know:

- Check out the [issue tracker](https://bitbucket.org/groovytutorial/groovy-tutorial/issues?status=new&status=open) and see if it's already been reported
	- If not then please create a new issue
- The [source text](https://bitbucket.org/groovytutorial/groovy-tutorial/) is written in [MultiMarkdown](http://fletcherpenney.net/multimarkdown/). If you feel confident in doing so, why not put together a correction and [create a pull request](https://confluence.atlassian.com/display/BITBUCKET/Fork+a+Repo,+Compare+Code,+and+Create+a+Pull+Request) 

Please remember that I'm not a big corporation or an automaton - I can't  respond immediately to queries and I am an assemblage of emotions that respond well to encouragement and positive encouragement a lot better than negativity.

## Bookmarks

Between Groovy and Java there's a lot of useful websites - this is a few key ones you'll want to have in your browser. 

Core resources to have at-hand:

- [The Groovy homepage](http://www.groovy-lang.org/) is a great starting point.
- The latest Groovy API documents are available at:
	- [The Groovy API](http://groovy-lang.org/api.html)
	- [The Groovy extensions to the JDK](http://groovy-lang.org/gdk.html)
		- aka the GDK
- The [Java API](http://docs.oracle.com/javase/7/docs/api/) always comes in handy
	- So do [The Java Tutorials](http://docs.oracle.com/javase/tutorial/)
- Whilst not a perfect fit for Groovy, I tend to use the [Google Java Style](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html) as my coding standard.

Great blogs and sites that provide Groovy coding examples:

- [Mr Haki](http://mrhaki.blogspot.com.au/search/label/Groovy) - A really useful site containing heaps of Groovy code examples.
- [DZone](http://www.dzone.com/links/tag/groovy.html) - Features a number of Groovy articles.
- [InfoQ](http://www.infoq.com/groovy) - Another useful site for Groovy articles.

If you find yourself stuck and needing some help, the following channels are worth tuning into:

- [StackOverflow's Groovy tag](http://stackoverflow.com/questions/tagged/groovy) is really useful 
	- search for an answer before posting a question
	- Check out their article "[How do I ask a good question?](http://stackoverflow.com/help/how-to-ask)" - it's an excellent outline for asking in a way people may answer
- The [Groovy Mailing lists](http://groovy-lang.org/mailing-lists.html) are also worth joining and searching

I suggest to anyone within the orbit of Java that "Effective Java (2nd edition)" by Joshua Bloch should not only be read (repeatedly) but always at-hand.

### Groovy Projects

There are several high-quality projects that use Groovy, it's worth checking them out:

- [Grails](https://grails.org/) - a full-stack web application framework for the Java Virtual Machine
	- That means it's a great tool-set for building web applications
- [Griffon](http://new.griffon-framework.org/) - a desktop application toolkit
- [Gradle](https://www.gradle.org/) - a build automation tool that should be your go-to when building non-trivial programs
- [Spock](https://code.google.com/p/spock/) - a testing framework
- [CodeNarc](http://codenarc.sourceforge.net/) - a code analysis tool for Groovy

Whilst it's not written in Groovy, the [Spring Boot](http://projects.spring.io/spring-boot/) project is worth a look as you can use Groovy to quickly write some nifty applications using the Spring framework.

