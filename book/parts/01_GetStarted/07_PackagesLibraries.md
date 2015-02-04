---
title:	Packages
status:	in-progress 
description:	Groovy lets you take advantage of the core Java packages (the JDK) so let's take a quick look at how this works.
...

# Built in Libraries

The following libraries are imported into Groovy by default:

- `java.io.*`
- `java.lang.*`
- `java.math.BigDecimal`
- `java.math.BigInteger`
- `java.net.*`
- `java.util.*`
- `groovy.lang.*`
- `groovy.util.*`

Groovy score is able to make use of classes within these packages without explicitly importing them.

# Useful third-party libraries
There is an extensive body of existing Java libraries available to the Groovy developer and it's best to do some investigating before you write your own code - re-using well-supported libraries is a real time saver.

1. [Apache Commons](http://commons.apache.org/)
1. [Google Guava](https://code.google.com/p/guava-libraries/)