# Organising your code {#chorganising}

When you start getting into writing larger code bases you'll need to think about how to organise your code. You don't have to do this
if you're using Groovy to write scripts that can fit into a reasonable file size (say, 400 lines) but really large files
can become difficult to scroll through and debug. There are two complementary tactics you can use when working with larger
bodies of code:

* Break the code into packages
* Put the code files into a directory structure that reflects your package structure

We'll start by looking at packages and then move onto directory structures.

## Packages
Code that doesn't specify a package is said to be in the _default_ package. Most of the code we've looked at so far
has been lacking a specific package and is automatically put into the default package - this is perfectly fine for small applications and scripts.
However, once you start to build larger codebase you'll want to start breaking you classes, enums, interfaces etc into
separate files and collect them into packages.

The generally agreed approach to structuring larger codebases is to:

1. Declare one structure (e.g. class, interface, enum) per file
2. Name the file after the structure declared in the file. For example, if you declare `class Person{...}` then name the file `Person.groovy`
3. Place these files into one or more packages

Following this approach will help you avoid a mess of files that makes it hard to debug problems later.

Let's take a look at a basic example in which I have a script that declares a `Person` class and then tries to do something
with it:

{title="First attempt at Person.groovy - will fail", lang=groovy}
    package mypackage

    class Person {
        def name = ''
    }

    def jim = new Person()
    println jim.name

If I put the above script into a file named `Person.groovy` and try to run it with `groovy Person.groovy`
it will give me the following error:

    org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
    Person.groovy: 3: Invalid duplicate class definition of class mypackage.Person : The source Person.groovy contains at least two definitions of the class mypackage.Person.
    One of the classes is an explicit generated class using the class statement, the other is a class generated from the script body based on the file name. Solutions are to change the file name or to change the class name.
     @ line 3, column 1.
       class Person {
       ^

    1 error

Essentially, this is caused by Groovy trying to create a `Person` class around the `def jim = new Person()` - Groovy
assumes that you want to create a class with the same name as the file *but* you have already declared a `Person` class in the file.

If we're following the rule of "One structure per file", we should only declare the `Person` class in `Person.groovy`:

    {title="Second attempt at Person.groovy - will work", lang=groovy}
    package mypackage

    class Person {
        def name = ''
    }

In the same directory we'll then create `Main.groovy`  and put it into the `mypackage.app` package as follows:

    {title="Main.groovy", lang=groovy}
    package mypackage.app

    import mypackage.Person

    def jim = new Person(name: 'Jim')
    println jim.name

Note that I'm actually creating two packages:

* `mypackage` will contain the `Person` class
* `mypackage.app` will contain the `Main` class

As `Person` isn't in the same package as `Main`, we need to import it using the fully qualified name for the `Person`
class: `mypackage.Person`.

### Compiling and running
Now that you have a `Person.groovy` file and a `Main.groovy` file you can run `groovyc Main.groovy Person.groovy`[^short] to
compile the two files. Once `groovyc` has completed you'll notice the following:

1. A `mypackage` subdirectory has been created and contains `Person.class`
1. A `mypackage/app` subdirectory has been created and contains `Main.class`

If I now run `groovy Main` I'll get Jim's name displayed as I expect but __be warned__ that, whilst this call to `groovy` is
using the compiled `Person` class, it is actually using the `Main.groovy` file and not the compiled version. In most cases
you would keep `Main.groovy` as a script and not worry about putting it into a package - this is just for demonstration
purposes.

You can run your compiled Groovy classes using Java by doing the following:

1. Download the [groovy-all jar](https://bintray.com/artifact/download/groovy/maven/org/codehaus/groovy/groovy-all/2.4.4/groovy-all-2.4.4.jar) into the directory containing the `mypackage` subdirectory.
2. Now run `java -cp groovy-all-2.4.4.jar:. mypackage.app.Main`

[^short]: Short form: `groovyc *.groovy`

## Directory structure
Groovy is very forgiving and I can put all of my code files in a single directory, regardless of which package I say they're
in. This, however, is poor practice and I should create a directory structure that mirrors my package structure. In the last
example I had two packages, `mypackage` and the sub-package `mypackage/app` and, when compiled, the following directory structure
appeared:

    mypackage/
        Person.class
        app/
            Main.class

This structure reflects the one I should be using in my source:

    mypackage/
        Person.groovy
        app/
            Main.groovy

Here's the logic:

1. `Person.groovy` is in the `mypackage` package so I create a `mypackage` directory and put `Person.groovy` in there
1. `Main.groovy` is in the `mypackage.app` package:
    1. As `app` is a subpackage of `mypackage` so I should create an `app` subdirectory under `mypackage` and place `Main.groovy` there.

T> The logic is easily mapped by remembering that the period (`.`) in the package name equates to a
directory separator (`/` in Unix, `\` in Windows).

Once I've shuffled the files into the new structure I can compile them with:

    groovyc -d classes mypackage/Person.groovy mypackage/app/Main.groovy

You'll find the compiled class files in the `classes` directory (as set by the `-d` switch).

At this point you're probably thinking that having to individually name all of the directories in a large codebase
is going to be unwieldy and you're absolutely correct. Once you get beyond a few files you'll turn to a build system
such as [Gradle](http://gradle.org).

## Naming your packages

If all Groovy and Java programmers just relied on the default package or `mypackage` it'd be almost impossible to
share code as it's extremely likely more that one `Person` class would be created. The [package naming convention](http://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html) helps to avoid this and there are two key elements to remember:

1. Package names are written in lower-case to avoid clashing with elements such as class names.
1. It is recommended that a reversed domain name is used as the base package name

The first point is straight-forward so let's explore the second. If you or the company you work for own a domain name,
you basically just reverse it and then prefix specific package names. For example, as I own the `groovy-tutorial.org`
domain I should use:[^uscore]

    `org.groovy_tutorial.mypackage`

I would use `org.groovy_tutorial` as the basis and then start with a prefix that reflects a project or library name for
 which I'm developing (e.g. `org.groovy_tutorial.shapes`). If I didn't own a domain I could have used the name
 of the site on which my code is hosted:

    com.github.groovy_tutorial.shapes_demo

I'm not pretending to own `github.com` but I've also included the organisation name and project name to ensure uniqueness.

One final point to remember is that your chosen package name needs to be based on something that's not likely to change
and isn't pinned to a single person. I've seen email addresses used (e.g. `com.gmail.example`) but this isn't the best idea.
Just take a moment before committing to a package name - you'll thank yourself if the code is still going in five years.

[^uscore]: I've converted the hyphen (`-`) to an underscore (`_`) as package names can't contain a hyphen
(and domain names can't contain an underscore).

## The shapes demo

You'll find the following packages in the shapes demo source code:

* `org.groovy_tutorial.shapes`
* `org.groovy_tutorial.shapes.triangle`
* `org.groovy_tutorial.shapes.app`

Within each package's folder you'll notice a `package-info.groovy` file. This isn't a script but the documentation for the
package. The `groovydoc` system will use this file when preparing the application's documentation.
For further information, please check out the [JavaDoc documentation section on "Package Comment Files"](http://docs.oracle.com/javase/1.5.0/docs/tooldocs/windows/javadoc.html#packagecomment).
