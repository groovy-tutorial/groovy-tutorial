class Test {
    static printer(){
        println 'Hello, world'
    }

    static printer(name) {
        println "Hello, $name"
    }
}

def cls = Test.&printer
cls()
cls('Newman')