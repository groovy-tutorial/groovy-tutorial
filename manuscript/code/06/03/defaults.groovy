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

displayMessage 'Preparing to shut down. Please save your work'
