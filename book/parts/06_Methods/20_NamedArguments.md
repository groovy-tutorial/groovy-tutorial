---
title:	Named Arguments
status:	in-progress
description:	
...

You can 

```groovy
def displayMessage (options, message) {

    def borderText = ''    
    if (options.border || ! options.containsKey(border)) {
         borderText = '-----------------------------------------------------------'
    }
    
    if (!options.title) {
         options.title = 'Important message:'
    }

    println """\
    $borderText
    $options.title
    \t $message
    $borderText
    """
}
```

* `displayMessage(title: 'Canberra', border: true, 'The capital of Australia')`
* `displayMessage title: 'Time', "It is now ${new Date()}"`
* `displayMessage border: false, 'Hang in there little buddy!'`