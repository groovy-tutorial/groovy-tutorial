import groovy.util.logging.*

@Log
class AssertionTest {
    static void runTest() {
        try {
            assert true == false : 'true cannot be false'
        } catch(AssertionError err) {
            log.severe "An assertion failed ${err}"
        }
    }
}

AssertionTest.runTest()
