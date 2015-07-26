import spock.lang.Specification

class MathDemo {
    /**
     * Returns the average of the parameters
     *
     * @param values a series of numerical values
     * @throws IllegalArgumentException if a parameter is a String
     * @returns The average of the values
     */
    static determineAverage(... values)
            throws IllegalArgumentException {
        for (item in values) {
            if (!(item instanceof Number)) {
                throw new IllegalArgumentException()
            }
        }

        if (!values) {
            return 0
        }

        return values.sum() / values.size()
    }
}

class AvgSpec extends Specification {

    @Unroll
    def "average of #values gives #result"(values, result) {
        expect:
        MathDemo.determineAverage(*values) == result

        where:
        values         || result
        [ 1, 2, 3 ]    || 2
        [ 2, 7, 4, 4 ] || 4.25
        [ ]            || 0
    }

    @Unroll
    def "determineAverage called with #values throws #exception"(values, exception) {
        setup:
        def e = getException(MathDemo.&determineAverage, *values)

        expect:
        exception == e?.class

        where:
        values          || exception
        [ 'kitten', 1 ] || java.lang.IllegalArgumentException
        [ 99, true ]    || java.lang.IllegalArgumentException
        [ 1, 2, 3 ]     || null
    }

    Exception getException(closure, ... args) {
        try {
            closure.call(args)
            return null
        } catch (any) {
            return any
        }
    }
}
