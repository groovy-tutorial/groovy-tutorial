import java.nio.file.*
import static java.nio.file.StandardWatchEventKinds.*
import groovy.io.FileType
import groovy.util.logging.*

//See: http://docs.oracle.com/javase/tutorial/essential/io/notification.html
//See: http://docs.oracle.com/javase/tutorial/essential/io/examples/WatchDir.java

def includes = [/^.*\.(mmd|md|markdown)$/]
def excludes = []
def events = [ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE]
//def events = [ENTRY_CREATE, ENTRY_MODIFY]

def handler = {Path path, WatchEvent<Path> event -> 
    if (event.kind in events) {
        def check = includes
        
        if (excludes)
            check = excludes
        
        if (check) {
            for (re in includes) {
                if ("${path}" ==~ re) {
                    println "I'll act on ${event.kind().name()} - ${path}"
                }
            }
        } else {
            println "nothing to do"
        }
    }
}

new WatchDir('/tmp/test').processEvents(handler)

@Log
class WatchDir {
    final def watcher
    final def keys = [:]
    final boolean recursive = false
    boolean trace = false
    
    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event
    }
    
    /**
     * Creates a WatchService and registers the given directory
     */
    WatchDir(String dir, boolean recursive = false) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService()
        
        this.recursive = recursive

        if (recursive) {
            log.info("Scanning ${dir}")
            registerAll(new File(dir))
            log.info("Complete scan of ${dir}")
        } else {
            register(new File(dir))
        }

        // enable trace after initial registration
        this.trace = true
    }
    
    private void registerAll(final File start) throws IOException {
        // register directory and sub-directories
        def f = new File(start)
        f.traverse(type: FileType.DIRECTORIES) {dir ->
            register(dir)
        }
    }
    
    private void register(File dir) throws IOException {
        log.info("Registering ${dir}")
        Path path = Paths.get(dir.getAbsolutePath())
        WatchKey key = path.register(this.watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY)
        if (this.trace) {
            Path prev = this.keys.get(key)
            if (prev == null) {
                log.info("Register: ${path}")
            } else {
                if (!dir.equals(prev)) {
                    log.info("Update: ${prev} -> ${path}")
                }
            }
        }
        keys.put(key, path)
    }
    
    void processEvents(Closure closure) {
        for (;;) {
            // wait for key to be signalled
            WatchKey key
            try {
                key = watcher.take()
            } catch (InterruptedException x) {
                return
            }

            Path dir = keys.get(key)
            if (dir == null) {
                log.info("WatchKey not recognized!!")
                continue
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind kind = event.kind()

                // TBD - provide example of how OVERFLOW event is handled
                if (kind == OVERFLOW) {
                    //A special event to indicate that events may have been lost or discarded. 
                    continue
                }

                // Context for directory entry event is the file name of entry
                WatchEvent<Path> ev = cast(event)
                Path name = ev.context()
                Path child = dir.resolve(name)

                // print out event
                log.info("${event.kind().name()}: ${child}\n")

                closure(child, event)

                // if directory is created, and watching recursively, then
                // register it and its sub-directories
                if (recursive && (kind == ENTRY_CREATE)) {
                    try {
                        if (Files.isDirectory(child, NOFOLLOW_LINKS)) {
                            registerAll(child)
                        }
                    } catch (IOException x) {
                        // ignore to keep sample readbale
                    }
                }
                
                //TODO: deal with a deleted directory
                
            }

            // reset key and remove from set if directory no longer accessible
            boolean valid = key.reset()
            if (!valid) {
                keys.remove(key)

                // all directories are inaccessible
                if (keys.isEmpty()) {
                    break
                }
            }
        }
    }
}