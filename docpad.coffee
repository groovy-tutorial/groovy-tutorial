# DocPad Configuration File
# http://docpad.org/docs/config

# Define the DocPad Configuration
docpadConfig = {
	watchOptions: preferredMethods: ['watchFile','watch']
	# =================================
	# Template Data
	# These are variables that will be accessible via our templates
	# To access one of these within our templates, refer to the FAQ: https://github.com/bevry/docpad/wiki/FAQ

	templateData:

		# Specify some site properties
		site:
			# The production url of our website
			url: "http://website.com"

			# Here are some old site urls that you would like to redirect from
			oldUrls: [
			]

			# The default title of our website
			title: "Groovy 2 Handbook"

			version: "0.0.1"

			# The website description (for SEO)
			description: """

			"""

			# The website keywords (for SEO) separated by commas
			keywords: """
			groovy, java
			"""

			# The website author's name
			author: "Duncan Dickinson"

			# The website author's email
			email: "labnotebook@duncan.dickinson.name"

			# Styles
			styles: [
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"
				"//yandex.st/highlightjs/8.0/styles/default.min.css"
				"/styles/site.css"
			]

			# Scripts
			scripts: [
				"//cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.min.js"
				"//cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js"
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"
				"//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.0/highlight.min.js"
			]

		book:
			title: "Groovy 2 Handbook"
			authors: [
				{name: "Duncan Dickinson", email: "", url: ""}
			]
			rights:
				holder: "Duncan Dickinson"
				year: "2014"

			license:
				text: "This work is licensed under a Creative Commons Attribution 4.0 International License"
				name: "cc-by"
				url: "http://creativecommons.org/licenses/by/4.0/"
				icon: "http://i.creativecommons.org/l/by/4.0/88x31.png"
				icon_small: "http://i.creativecommons.org/l/by/4.0/80x15.png"

			source: "https://github.com/labnotebook/groovy-language"

			issues: "https://github.com/labnotebook/groovy-language/issues"

			index:
				title_page: "Title"
				front_matter:
					"Preface": "Preface"
					"Introduction": "Introduction"
					"Useful references": "References"
					"Colophon": "Colophon"
				chapters:
					"A Tutorial Introduction":
						"Introduction": "Introduction"
					"Basics":
						"Introduction": "Introduction"
						"Statement Termination": "StatementTermination"
						"Reserved Words": "ReservedWords"
						"Comments": "Comments"
					"Types, operators and expressions":
						"Introduction": "Introduction"
						"Data Types": "DataTypes"
						"Variables": "Variables"
						"Strings and GStrings": "Strings"
						"Constants": "Constants"
						"The assert statement": "Assert"
						"Operators":
							"Introduction": "Introduction"
							"Simple Assignment Operator": "AssignmentOperatorSimple"
							"Logical Complement Operator": "ComplementOperators"
							"Equality Operators": "EqualityOperators"
							"Arithmetic Operators": "ArithmeticOperators"
							"Relational Operators": "RelationalOperators"
							"Type Comparison Operator": "TypeComparionOperator"
							"Increment and Decrement Operators": "IncrementDecrementOperators"
							"Conditional Operators": "ConditionalOperators"
							"Bitwise Operators": "BitwiseOperators"
							"The Compound Assignment Operators": "AssignmentOperatorsCompound"
						"Type Conversions": "TypeConversions"
						"Ranges": "Ranges"
						"Arrays": "Arrays"
						"Lists": "Lists"
						"Collections": "Collections"
						"Conditional Expressions": "ConditionalExpressions"
						"Precedence and Order of Evaluation": ""
						"Errors and Exceptions": "ErrorsExceptions"
						"Regular Expressions": "RegularExpressions"
						"Summary": "Summary"
					"Control Flow":
						"Statements and Blocks": "StatementsBlocks"
						"If-Else": "IfElse"
						"Switch": "Switch"
						"Loops - While": "LoopsWhile"
						"Loops - For": "LoopsFor"
						"Break and Continue": "BreakContinue"
						"Try, Catch and Finally": "TryCatchFinally"
						"Summary": "Summary"
					"Closures":
						"Introduction": "Introduction"
					"Classes":
						"Introduction": "Introduction"
						"Classes": "Classes"
						"Methods": "Methods"
						"Inheritance": "Inheritance"
						"Interfaces": "Interfaces"
						"The with method": "with"
						"The ?. dereference operator": "Dereference"
						"enum": "enum"
					"Input and Output":
						"Introduction": "Introduction"
						"The Command Line": "CommandLine"
						"Files": "Files"
						"Databases": "Databases"
				
			getTitle: -> 
				this.title
				
			getSource: ->
				this.source
				
			getIssues: ->
				this.issues
				
			getChapterList: -> 
				toc = []
				for title, value of this.index.chapters
					toc.push title
				return toc
				
			getChapterToc: (chapter) -> 
				toc = []
				for title, value of this.index.chapters[chapter]
					//Check to make sure value isn't an object!
					toc.push "<a href='/chapters//#{value}'>#{title}</a>"
				return toc
			
			getFrontMatterToc: -> 
				toc = []
				for title, url of this.index.front_matter
					toc.push "<a href='/front_matter/#{url}'>#{title}</a>"
				return toc
}

# Export the DocPad Configuration
module.exports = docpadConfig
