# Default Values for Parameters

I> Parameters can have a default value to indicate the most likely usage

One or more parameters can be defined with a default value. This can be really useful if most calls to the method will use the defaults:

	def displayMessage (message, 
			    title = 'Important message:', 
				border = true) {
	
	    def borderText = ''
	    
	    if (border) {
	         borderText = '--------------------------'
	    }
	
	    println """\
	    $borderText
	    $title
	    \t $message
	    $borderText
	    """
	}

The `displayMethod` can be called in a number of ways:

* `displayMessage 'Preparing to shut down. Please save your work'` - 
* `displayMessage 'The system appears to have crashed', 'Error!'`
* `displayMessage 'Be prepared for the happiness patrol', 'Public announcement:', false` 

When you get to method overloading and other object-oriented concepts you'll see that default parameter values can aid in reducing the variations of a method that you might need to provide.




