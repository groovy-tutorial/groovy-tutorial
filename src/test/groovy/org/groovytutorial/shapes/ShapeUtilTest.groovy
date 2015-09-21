package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ShapeUtilTest extends Specification {
    def "test checkSides"() {
        expect:
        result == ShapeUtil.checkSides(*sides)

        where:
        sides || result
        [1]   || true
        [7, 3, 101] || true
        [0, 9, 2]   || false
        [8, -1, 9]  || false
    }

    def "test checkSideException - exception not thrown"() {
        when:
        result == ShapeUtil.checkSidesException(*sides)

        then:
        notThrown(IllegalArgumentException)

        where:
        sides || result
        [1]   || true
        [7, 3, 101] || true
    }

    def "test checkSideException - exception thrown"() {
        when:
        result == ShapeUtil.checkSidesException(*sides)

        then:
        thrown(IllegalArgumentException)

        where:
        sides || result
        [0, 9, 2]   || false
        [8, -1, 9]  || false
    }
}
