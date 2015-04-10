# Named Arguments

I> Groovy uses a sneaky Map to provide named argument functionality

You can use named arguments by having the first parameter be a Map. Consider the method below:

	def displayMessage (options, message) {
	
	    def borderText = ''    
	    if (! options.containsKey('border') || options.border) {
	         borderText = '--------------------------'
	    }
	        
	    def title = 'Important message:'
	    if (options.title) {
	         title = options.title
	    }
	
	    println """\
	    $borderText
	    $title
	    \t $message
	    $borderText
	    """
	}

The `options` parameter is actually a Map and this lets the caller use an interesting Groovy syntax when calling the method. Instead of passing a Map (`[:]`) to the `options` parameter, the caller can use the `key: value` format in their method call. This lets us call `displayMessage` in many ways, including:

* `displayMessage(title: 'Canberra', border: true, 'The capital of Australia')`
* `displayMessage title: 'Time', "It is now ${new Date()}"`
* `displayMessage border: false, 'Hang in there little buddy!'`

My recommendation is to use named parameters for non-essential parameters and to make sure that your method can operate correctly if a named parameter is not provided.

If others are to be using your method or __you__ need to remember which named parameters are available, then you'll make sure that you add some useful documentation to the method.