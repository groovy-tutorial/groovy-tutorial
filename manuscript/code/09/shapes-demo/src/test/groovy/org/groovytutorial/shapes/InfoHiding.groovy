package org.groovytutorial.shapes

import spock.lang.Specification

/**
 *
 *
 * @author Duncan Dickinson
 */
class InfoHiding extends Specification {
    def "TEST"() {
        given:
        Square s = new Square(5)
        s.sides.hack = 999
        expect:
        !s.sides.containsKey('hack')
    }
}
