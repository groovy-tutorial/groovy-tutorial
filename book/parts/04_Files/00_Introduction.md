---
Title:	Introduction
Description:	Handling file I/O (Input/Output) is a "bread and butter" task for programmers. Groovy builds on Java's strong file handling libraries by adding a number of handy extras.
...

Java originally shipped a library (`java.io`) for handling input and output from elements such as files, network resources and devices. A new library, called NIO (`java.nio`), was released in Java 1.4 and extended in Java 7. This later extension is usually referred to as NIO.2 but you'll find these classes in the `java.nio` packages.

As you'd expect, Groovy lets you use `java.io` and `java.nio` packages. Groovy has a number of enhancements to the `java.io` package and, as of Groovy 2.3, there has been extended (i.e. Groovy-friendly) support for `java.nio.file.Path`. I'll focus on using the NIO packages in the tutorials on file I/O. 

## Key concepts

There are a few key concepts that you should get your head around if you're going to be handling file I/O. First of all, let's picture a filesystem's hierarchical layout:

<pre>
C:\ or /
    users/
        bill/
            documents/
        	    letter.txt
        jane/
            music/
        	    song.mp3
</pre>

Whilst this won't necessarily match the way your files are laid out in directories you can see the following in the filesystem:

* The filesystem has a "root" node. 
	* In Windows this is based on the disk (e.g. `C:\` or `D:\`)
	* In Linux and OS X there is only one root node: `/`
* There's a `users` directory.
  * Directory is analogous to "folder"
* Each user (`bill` and `jane`) has their own directory
* Bill has one file (`letter.txt`) stored in his `documents` directory
* Jane has one file (`song.mp3`) stored in her `music` directory
* Files usually (though not always) have an extension (e.g. `mp3` or `txt`). This gives us a clue to what type of content to expect in the file
	* But don't trust this as the user can change the extension to anything



### Paths
A "path" defines the location of a resource (such as a file or directory) within a filesystem. 

Different operating systems use different notations to define a path. For example, in Linux-based and Apple's OS X operating systems you would refer to Jane's song file using `/users/jane/music/song.mp3`. In Microsoft Windows you would use `C:\users\music\song.mp3`.

To separate each segment of the hierarchy (i.e. each folder and file) a separator is used:

 - Linux and OS X use the forward slash character (`/`) 
 - Windows uses backslashes ('\\')

The use of backslashes in Windows' paths can make strings annoying. Looking at `println 'C:\users\jane\music\song.mp3'` you'll see the problem pretty quickly - the backslash is an escape character in Groovy strings so that `println` won't work. You can escape the backslash using `\\` but that starts to look very messy: `println 'C:\\users\\jane\\music\\song.mp3'`. Luckily, we can use the forward slash instead and Groovy will `println 'C:/users/jane/music/song.mp3'`

> If you'd like to check which separator is used by the operating system you're using, try `println File.separator` in the Groovy Console

Paths in some operating systems, such as Linux and OS X, are case-sensitive. This means that you must refer to a path using the correct upper-case and lower-case characters. This means that `/users/Jane/music/song.MP3` doesn't refer to the same path as `/users/jane/music/song.mp3`. However, Windows' paths are case-insensitive so the two versions of the path for Jane's song file both point to the same file.

As a programmer this can be rather frustrating as you can write Groovy code that works across a number of operating systems but you need to make sure you're correctly handling paths.

#### Absolute Paths


#### Relative paths


### URIs and URLs
Universal Resource Identifiers[^uri] provide a string format for referring to resources. The most common form of URI is the URL[^url] (Uniform Resource Locator) and we'll focus mostly on these. URNs[^urn] (Uniform Resource Names) aren't as common - examples include ISBNs[^isbn] and UUIDs[^uuid].

[^uri]: <http://en.wikipedia.org/wiki/Uniform_resource_identifier>
[^url]: <http://en.wikipedia.org/wiki/Uniform_resource_locator>
[^urn]: <http://en.wikipedia.org/wiki/Uniform_resource_name>
[^isbn]: <http://en.wikipedia.org/wiki/International_Standard_Book_Number>
[^uuid]: <http://en.wikipedia.org/wiki/Universally_unique_identifier>

A URL also defines a path to a resource. If you've used a web browser then you've definitely seen a URL. 

`<scheme name>://<host>[:<port>]/<path>[?<query_string>][#<fragment_id>]`

* `<scheme name>`: 
	* You'll have used the `http` and `https` schemes when browsing the Web
	* The `ftp` scheme is used for the File Transfer Protocol
* `<host>`: 
	* This could be a domain name such as `groovy.codehaus.org`
	* ... or the IP address `199.193.192.103`
* `[<port>]`: 
* `<path>`: The path points to the resource being requested 
	* For example: `/home/index.html`
* `[?<query_string>]`: One or more key/value pairs
	* The `&` character is used as the delimeter to separate each key/value pair
	* For example: name=fred&answer=yes
* `[#<fragment_id>]`: Points to a place (anchor) within the requested resource
	* This is often used to point to a place within a web page such as a heading.
	* For example: `#chapter01`

Here are a few examples:

<http://www.wikipedia.org/wiki/Uniform_resource_locator>
:	This is 

<file://>




