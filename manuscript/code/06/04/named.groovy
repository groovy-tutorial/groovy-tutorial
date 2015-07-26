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

displayMessage(title: 'Canberra', border: true, 'The capital of Australia')
