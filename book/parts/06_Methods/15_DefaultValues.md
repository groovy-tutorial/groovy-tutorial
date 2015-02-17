---
title:	Default Values for Parameters
status:	in-progress
description:	
---


```groovy
def displayMessage (message, title = 'Important message:', border = true) {

    def borderText = ''
    
    if (border) {
         borderText = '-----------------------------------------------------------'
    }

    println """\
    $borderText
    $title
    \t $message
    $borderText
    """
}
```

The `displayMethod` can be called in a number of ways:

* `displayMessage 'Preparing to shut down. Please save your work'` - 
* `displayMessage 'The system appears to have crashed', 'Error!'`
* `displayMessage 'Be prepared for the happiness patrol', 'Public announcement:', false` 




