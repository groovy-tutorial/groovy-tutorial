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

			# The website description (for SEO)
			description: """
			When your website appears in search results in say Google, the text here will be shown underneath your website's title.
			"""

			# The website keywords (for SEO) separated by commas
			keywords: """
			place, your, website, keywoards, here, keep, them, related, to, the, content, of, your, website
			"""

			# The website author's name
			author: "Duncan Dickinson"

			# The website author's email
			email: "labnotebook@duncan.dickinson.name"

			# Styles
			styles: [
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"
				"http://yandex.st/highlightjs/8.0/styles/default.min.css"
				"/styles/site.css"
			]

			# Scripts
			scripts: [
				"//cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.min.js"
				"//cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js"
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"
				"http://yandex.st/highlightjs/8.0/highlight.min.js"
				"/scripts/site.js"
			]
			
}

# Export the DocPad Configuration
module.exports = docpadConfig