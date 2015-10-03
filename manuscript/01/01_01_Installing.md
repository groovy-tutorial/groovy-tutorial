# Installing Groovy

I> Before we start anything let's get Groovy installed and running.

There are a few methods for installing Groovy on your system and this section will describe the basics for getting started. Before you get started make sure that any installations are for the versions listed in the table below:

|System		|	Version
|-----------------|----------------
| Java JDK		|	8 (7 is fine too)
| Groovy		|	2.4.0 (or higher)

W> ## The vagaries of installations
W> It is notoriously difficult to provide this type of information in a stable manner as versions are upgraded and URLs broken. The [Groovy Download](http://groovy-lang.org/download.html) page is the primary resource to return to if the links below appear to be broken.

## Don't Install Groovy

I know this chapter is about installing Groovy but perhaps it's worth leaving this until later. The [Groovy web console](http://groovyconsole.appspot.com) is an online Groovy console that should let you run most of the sample code provided in this book. Provided you have web access you can skip through to the next chapter and get straight into writing some code!

## Install a Java Virtual Machine
All methods for installing Groovy require that you have a Java Virtual Machine (JVM) installed. For the purposes of this book we'll use the Java 8 SE JDK (Java 8 Standard Edition Development Kit). You'll notice that Java 8 may also be represented as Java 1.8 - the former is the Java Platform version number (8) and the latter is the version string (1.8).

W> ## JDK not JRE
W> If you look around for Java downloads you'll likely come across Java Runtime Environment (JRE) downloads. The JRE provides enough functionality to run a compiled application but not to compile your Groovy code. You'll need the JDK to create Groovy programs.

To install the Java JDK, head to the Oracle site and locate the download appropriate to your platform: [Oracle JDK Downloads](http://www.oracle.com/technetwork/java/javase/downloads/index.html). For the most part these installs are straight-forward and have enough associated documentation so we won't go through this step-by-step.

Before moving onto the Groovy installation I'd like to make you aware that the Oracle JDK is not the only version of the JDK available. As you become more comfortable with working in a Java-based environment you might like to take a look at the [Open JDK](http://openjdk.java.net/).

## Install Groovy
Once you have the JDK installed it's time to get Groovy. We'll be using Groovy 2.4 throughout this book. Other (newer) versions may work fine - it's just that the examples used throughout the book have been tested against Groovy 2.4.

The following subsections will guide you through an installation based on which platform you're using.

### Windows
The [Groovy Download](http://groovy-lang.org/download.html) page includes links to a Windows installer - download this and run the installer using the provided defaults (it's as easy as that).

Just make sure you're downloading a 2.4.x version!

#### Checking for Groovy in the Start Menu
Once you have the JDK and Groovy installed you should see the GroovyConsole application in your Windows 7 Start menu. Start up the GroovyConsole application and you should be good to go.

### Mac OSX and Linux
SDKMAN! is the best tool for getting Groovy running on your system. The homepage is <http://sdkman.io/> but you don't need to visit it to run an installation.

If you are comfortable with using the terminal then you just need to run the following command as a regular user[^curl]:

	curl -s get.sdkman.io | bash

Once SDKMAN! has been installed, run the following command to determine which versions of Groovy are available:

	sdk list groovy

You'll see a large table of version numbers but are most interested in those marked with 2.4.x - you'll want the version with the highest value of x (e.g. 2.4.4). To install Groovy you now just call `sdk` as below:

	sdk install groovy 2.4.4

### Checking Groovy (all platforms)
Once you have the JDK and Groovy installed, run the following command to double-check your Groovy version:

	groovy -v

You should see something like the following output:

	Groovy Version: 2.4.0 JVM: 1.8.0_31 Vendor: Oracle Corporation OS: Mac OS X

This tells me that I am running:

 * Groovy 2.4.0
 * The Oracle Java 8 JVM
 * The Apple Mac OS X operating system

### Alternatives
The [Groovy Download](http://groovy-lang.org/download.html) page provides binary and source releases for Groovy. These are perfectly fine to use but you'll need to setup your system path to get up and running.

For those on Mac OS X you can also explore one of the following package manager options:

 * [MacPorts](https://www.macports.org/)
 * [Homebrew](http://brew.sh/)

Linux users may find Groovy packages in their distribution's package repository but check the version being installed.

[^curl]: The `curl` command line tool is used for transferring data. It's very likely that your Linux distribution's package manager (`yum`, `apt-get` etc) includes a copy of cURL but if it doesn't, visit <http://curl.haxx.se/> to download it.
