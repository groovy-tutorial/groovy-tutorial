docpadConfig = 
	watchOptions: 
		preferredMethods: ['watchFile','watch']
	
	templateData:
		site:
			styles: [
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"
				"//yandex.st/highlightjs/8.0/styles/default.min.css"
				"/styles/site.css"
			]

			scripts: [
				"//cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.min.js"
				"//cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js"
				"//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"
				"//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.0/highlight.min.js"
			]
			
		#book = new Book('book.cson')
			
		


# Export our DocPad Configuration
module.exports = docpadConfig
