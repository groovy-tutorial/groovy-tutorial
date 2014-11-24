---
Title:	Reading files
Description:	
...




## 


<code-file url="src/BasicRead.groovy"><figcaption>
Reading a file
</figcaption></code-file>


### Determining the file type
```groovy
import java.nio.file.Paths
import java.nio.file.Files

def path = Paths.get('C:/Users/s2183294/Documents/test.txt')
println Files.probeContentType(path)
```

### Working With URIs

To view the URI representation of a file path:

```groovy
import java.nio.file.Paths

def path = Paths.get("sampledir/poem/snowyriver.txt")
println path.toUri().toString()
```

To open a file using a URI

```groovy
import java.nio.file.Paths

def path = Paths.get('sampledir/poem/snowyriver.txt').toAbsolutePath()
def uri = new URI("file:///$path")
def file = Paths.get(uri)
println file.getText()
```

You'll see that I grabbed the absolute path for the file for use in the URI. This is because using a relative path (`file://sampledir/poem/snowyriver.txt`) won't work - the URI needs the root node (`/`) after the `://` to indicate 