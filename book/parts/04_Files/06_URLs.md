---
Title:	Reading URLs
Description:	
...

```groovy
def url = new URL('https://raw.githubusercontent.com/groovy/groovy-core/master/NOTICE.txt')
def download = url.getText()
println download
```