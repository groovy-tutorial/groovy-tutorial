---
title:	Installing Groovy  
description:	Before we start anything let's get Groovy installed and running. 
...
There are a few methods for installing Groovy on your system and this section will describe the basics for getting started. Before you get started make sure that any installations are for the versions listed in the table below:

|System		|	Version
|-----------------|----------------
| Java JDK		|	7 (8 is fine too)
| Groovy		|	2.3.6 (or higher)

>Note: It is notoriously difficult to provide this type of information in a stable manner as versions are upgraded and URLs broken. The [Groovy Download]() page is the primary resource to return to if the links below appear to be broken.

# Install a Java Virtual Machine
All methods for installing Groovy require that you have a Java Virtual Machine (JVM) installed. For the purposes of this book we'll use the Java 7 SE JDK (Java 7 Standard Edition Development Kit)[^You'll notice that Java 7 may also be represented as Java 1.7 - the former is the Java Platform version number (7) and the latter is the version string (1.7)]. 

>Note: If you look around for Java downloads you'll likely come across Java Runtime Environment (JRE) downloads. The JRE provides enough functionality to run a compiled application but not to compile your Groovy code. You'll need the JDK to create Groovy programs.

To install the Java 7 JDK, head to the Oracle site and locate the download appropriate to your platform: [JDK][]. For the most part these installs are straight-forward and have enough associated documentation so we won't go through this step-by-step.

Before moving onto the Groovy installation I'd like to make you aware that the Oracle JDK is not the only version of the JDK available. As you become more comfortable with working in a Java-based environment you might like to take a look at the following alternatives:

  * [Open JDK](http://openjdk.java.net/)
  * [IcedTea](http://icedtea.classpath.org)

# Install Groovy
Once you have the JDK installed it's time to get Groovy. We'll be using Groovy 2.3 throughout this book. Other (newer) versions may work fine - it's just that the examples used throughout the book have been tested against Groovy 2.3.

The following subsections will guide you through an installation based on which platform you're using.

### Windows
The [Groovy Download][] page includes links to a Windows installer - download this and run the installer using the provided defaults (it's as easy as that). 

Just make sure you're downloading a 2.3.x version!

#### Checking for Groovy in the Start Menu
Once you have the JDK and Groovy installed you should see the GroovyConsole application in your Windows 7 Start menu. Start up the GroovyConsole application and you should be good to go.

### Mac OSX and Linux
The Groovy enVironment Manager (GVM) is the best tool for getting Groovy running on your system. The GVM homepage is <http://gvmtool.net/> but you don't need to visit it to run an installation. 

If you are comfortable with using the terminal then you just need to run the following command as a regular user[^curl]:

```bash
curl -s get.gvmtool.net | bash
```

Once the `gvm` has been installed, run the following command to determine which versions of Groovy are available:

```bash
gvm list groovy
```

You'll see a large table of version numbers but are most interested in those marked with 2.3.x - you'll want the version with the highest value of x (e.g. 2.3.6). To install Groovy you now just call `gvm` as below:

```bash
gvm install groovy 2.3.6
``` 
 
### Checking Groovy
Once you have the JDK and Groovy installed, run the following command to double-check your Groovy version:

````bash
groovy -v
````
You should see something like the following output:

````
Groovy Version: 2.3.6 JVM: 1.7.0_60 Vendor: Oracle Corporation OS: Mac OS X
````

This tells me that I am running:

 * Groovy 2.3.6
 * The Oracle Java 7 JVM
 * The Mac OS X operating system

### Alternatives
The [Groovy Download][] page provides binary and source releases for Groovy. These are perfectly fine to use but you'll need to setup your system path to get up and running.

For those on Mac OS X you can also explore one of the following package manager options:

 * [MacPorts](https://www.macports.org/)
 * [Homebrew](http://brew.sh/)

Linux users may find Groovy packages in their distribution's package repository but check the version being installed.

[JDK]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html "Oracle JDK Downloads"

[Groovy Download]:	http://groovy.codehaus.org/Download "Groovy Download"

[^curl]: The `curl` command line tool is used for transferring data. It's very likely that your Linux distribution's package manager (`yum`, `apt-get` etc) includes a copy of cURL but if it doesn't, visit <http://curl.haxx.se/> to download it.