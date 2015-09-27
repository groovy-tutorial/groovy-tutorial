# Grape
Whilst you can use Maven or (even better) [Gradle](http://gradle.org) to grab dependencies, Groovy includes a dependency manager called [Grape](http://groovy-lang.org/grape.html) that you can start using straight away.

Say I wanted to grab a copy of my favourite web page and had worked out that [Apache's HTTP Components](https://hc.apache.org/index.html) would really help me. I can search the Maven Central Repository and [find what I need](http://search.maven.org/#artifactdetails%7Corg.apache.httpcomponents%7Chttpclient%7C4.3.6%7Cjar). In fact, that web page even tells me how to use the library with Grape:

{title="Grape example",lang=Java}
	@Grapes(
	@Grab(group='org.apache.httpcomponents', module='httpcomponents-client', version='4.4')
	)

I> Searching the repository can be a little frustrating at first but you'll get the hang of it over time.

Grape uses annotations - essentially the "at" (`@`) sign followed by a name - to do its thing. In the example above:

- `@Grapes` starts of the grape listing
	- You need this if you're grabbing several libraries in the same segment (node) of your code - we can actually ignore this in smaller examples.
- Each grape is declared using `@Grab` and providing the following:
	- The `group` that holds the module
	- The name of the `module`
	- The required version of the `module`

In the code below I use the Apache HTTP Components library to report on the HTTP status line from my request to "http://www.example.org". I've trimmed off the `@Grapes` as I just need to `Grab` one module:

{title="Using Grape",lang=Java}
	@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.3.6')
	import org.apache.http.impl.client.HttpClients
	import org.apache.http.client.methods.HttpGet

	def httpclient = HttpClients.createDefault()
	def httpGet = new HttpGet('http://www.example.org')
	def response = httpclient.execute(httpGet)

	println response.getStatusLine()


T> ## Where to grab
T> I like to put my `@Grabs` on the line above the `import` that include the dependency - it helps other see where my libraries are coming from.

You can use a short-form version of `@Grab` using the format `<group>:<module>:<version>` - this would let us use the following:

{title="Short-form grape",lang=Java}
	@Grab('org.apache.httpcomponents:httpclient:4.3.6')

Once you start building more complex programs you will probably turn to Gradle but Grape works just fine for these tutorials.
