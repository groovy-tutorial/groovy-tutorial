# Shapes example
An introductory project that demonstrates aspects of OO-programming in Groovy. The code here is described in
[The Groovy 2 Tutorial](https://leanpub.com/groovytutorial).

This codebase contains:

* Various [Gradle-related](http://gradle.org/) files (e.g. `build.gradle`)
* Groovy source code in `src/main/groovy`
* [Spock tests](http://spockframework.github.io/spock/docs/1.0/index.html) in `src/test/groovy`

You don't need Groovy or Gradle to run this codebase - you just need to have a Java JDK installed (at least v1.7).

## Running the code

### Using Gradle

The easiest way to run the code is to use the Gradle build, as defined in `build.gradle`.

For OS X, Linux and other *nix systems:

    ./gradlew run

For Windows:

    gradlew.bat run

You don't need to download anything for this to work
- the [Gradle wrapper](https://docs.gradle.org/current/userguide/wrapper_plugin.html) will download everything you need.

The Gradle build also provides a number of interesting options. In Gradle these are called _tasks_ and you can
see all of the available tasks by running `./gradlew tasks`. Here are a few tasks worth trying out:

* `./gradlew clean`: removes all of the generated files (it doesn't delete the source code)
* `./gradlew check`: runs a [CodeNarc](http://codenarc.sourceforge.net/) check and the [Spock tests](http://spockframework.github.io/spock/docs/1.0/index.html)
    * You can find the output of these checks/tests in the `build/reports/` directory - check them out in your browser.
* `./gradlew groovydoc`: will generate the GroovyDoc for the project
    * The documentation is put into `build/docs/` and is best read in your browser
* `./gradlew assemble`: creates a number of outputs that make distributing your code possible:
    * `build/distributions`: contains `tar` and `zip` archives that can be distributed to others, including handy scripts to start your application

#### The Über jar
I've also added in the [Gradle Shadow](https://github.com/johnrengelman/shadow/) plugin as it will create an über jar - one that hold the compiled codebase and all required libraries.
To create this file, run `./gradlew shadowJar` and `build/libs/shapes-demo-1.0-SNAPSHOT-all.jar` will be created.
Take the über jar out for a spin by running: `java -jar build/libs/shapes-demo-1.0-SNAPSHOT-all.jar`.

#### The Gradle files
There are a number of files relating to the Gradle build:

* `build.gradle` is the primary file and describes what's needed to build the application
* `gradle.properties` provides information to `build.gradle` such as library versions
    * I've also enabled the [Gradle Daemon](https://docs.gradle.org/current/userguide/gradle_daemon.html) - this creates a background process that makes it quicker to run builds.
* `settings.gradle` is used, amongst other things, to give the project a name ("shapes-demo")
* The Gradle wrapper plugin produces the following files:
    * `gradlew` and `gradlew.bat` are used to run the Gradle build and will download a copy of Gradle if needed
    * The `gradle/wrapper` directory houses the files needed by Gradle wrapper

You'll also notice a `.gradle/` directory is created. This is used by Gradle to cache information and libraries etc.

### Using the command line

You don't have to use the Gradle build to build and run the code and it might be a useful learning experience to try out
compiling and running the code from the command line. The information provided here has been prepared on an OS X system
so should also work in Linux systems. Windows users will most likely need to change the file paths.

__Note:__ All commands provided in this section are run from the base of the project distribution - that's where this
README file resides.

To run the code using `groovy`:

    groovy -classpath src/main/groovy/ src/main/groovy/org/groovytutorial/shapes/app/Main.groovy

To build the code using `groovyc`:

    groovyc -d classes src/main/groovy/org/groovytutorial/shapes/*.groovy src/main/groovy/org/groovytutorial/shapes/app/*.groovy src/main/groovy/org/groovytutorial/shapes/triangle/*.groovy

To create a Jar:

    groovyc -d classes src/main/groovy/org/groovytutorial/shapes/*.groovy src/main/groovy/org/groovytutorial/shapes/app/*.groovy src/main/groovy/org/groovytutorial/shapes/triangle/*.groovy
    jar -cvfe shapes-demo.jar org.groovytutorial.shapes.app.Main -C output .

<
