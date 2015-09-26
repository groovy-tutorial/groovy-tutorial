package org.groovy_tutorial.shapes

import spock.lang.Specification
import spock.lang.Unroll

/**
 * This is a very basic class providing an implementation harness
 * for the Sides trait
 */
class SidesTestImpl implements Sides {

}

@Unroll
class SidesTest extends Specification {
    def "test shape with sides (#sideMap) has perimeter of #perimeter"() {
        given: "A basic instance of SidesTestImpl"
        Sides s = new SidesTestImpl()

        when: "the sides are added as properties"
        for (side in sideMap) {
            s."$side.key" = side.value
        }

        then: "the perimeter is correct"
        perimeter == s.perimeter

        where:
        sideMap                 || perimeter
        [a: 3, b: 8, c: 10]     || 21
        [a: 3, b: 4, c: 3, d: 4] || 14
    }

    def "test getSideMap.getSideMap reflects the input sides"() {
        given: "A basic instance of SidesTestImpl"
        Sides s = new SidesTestImpl()

        when: "the sides are added as properties"
        for (side in sideMap) {
            s."$side.key" = side.value
        }

        then: "The getSideMap getter reflects the input sides"
        sideMap == s.sideMap

        where:
        sideMap                 || _
        [a: 3, b: 8, c: 10]     || _
        [a: 3, b: 4, c: 3, d: 4] || _
    }

    def "test getSideMap.getSideMap returns a copy of the sideMap and not a reference"() {
        given: "A basic instance of SidesTestImpl"
        Sides s = new SidesTestImpl()

        when: "the sides are added as properties"
        for (side in sideMap) {
            s."$side.key" = side.value
        }
        and: "the sideMap getter is called and allocated to myMap"
        def myMap = s.sideMap
        and: "I change myMap"
        myMap.x = 999

        then: "The getSideMap getter still reflects the input sides"
        sideMap == s.sideMap
        and: "myMap and s.sideMap are no longer equivalent"
        myMap != s.sideMap

        where:
        sideMap                 || _
        [a: 3, b: 8, c: 10]     || _
        [a: 3, b: 4, c: 3, d: 4] || _
    }

    def "When getSideMap.getPerimter is called the list of sides is 'locked' and cannot be added to"() {
        given: "A basic instance of SidesTestImpl"
        Sides s = new SidesTestImpl()

        when: "the sides are added as properties"
        for (side in sideMap) {
            s."$side.key" = side.value
        }
        and: "the perimeter is accessed"
        s.perimeter
        and: "an attempt is made to add to the list of sides"
        s.x = 999

        then: "the exception is thrown"
        thrown(ReadOnlyPropertyException)

        where:
        sideMap                 || _
        [a: 3, b: 8, c: 10]     || _
        [a: 3, b: 4, c: 3, d: 4] || _
    }

    def "When getSideMap.getPerimeter is called the list of sides is 'locked' and an existing side cannot be changed"() {
        given: "A basic instance of SidesTestImpl"
        Sides s = new SidesTestImpl()

        when: "the sides are added as properties"
        for (side in sideMap) {
            s."$side.key" = side.value
        }
        and: "the perimeter is accessed"
        s.perimeter
        and: "an attempt is made to modify an existing side"
        s.a = 999

        then: "the exception is thrown"
        thrown(ReadOnlyPropertyException)

        where:
        sideMap                 || _
        [a: 3, b: 8, c: 10]     || _
        [a: 3, b: 4, c: 3, d: 4] || _
    }

    def "The sides trait's map of sides can't be reassigned"() {
        given: "A new Sides-based shape"
        Sides s = new SidesTestImpl()

        when: "an attempt is made to assign the sideMap field to a new map"
        s.sideMap = [ : ]

        then: "the correct exception and s.sideMap hasn't changed"
        thrown(ReadOnlyPropertyException)
    }

    def "Adding a property (side) with a name (#sideName) that doesn't match SIDE_NAME_PATTERN causes a MissingPropertyException"() {
        given: "A basic instance of SidesTestImpl"
        Sides s = new SidesTestImpl()

        when: "the sides are added as properties"
        s."$sideName" = 1

        then: "the exception is thrown"
        MissingPropertyException e = thrown()
        "Property $sideName not found" == e.getMessage()

        where:
        sideName  || _
        'aa'     || _
        1    || _
    }

    def "Adding a side (#side) that is <= 0 or not a number causes an IllegalArgumentException and the correct exception message (#exceptionMsg)"() {
        given: "A basic instance of SidesTestImpl"
        Sides s = new SidesTestImpl()

        when: "the sides are added as properties"
        s.a = side

        then: "the exception is thrown"
        IllegalArgumentException e = thrown()
        e.getMessage() == exceptionMsg

        where:
        side  || exceptionMsg
        0     || 'The side must be a positive number.'
        -1    || 'The side must be a positive number.'
        'rabbit' || "The value [rabbit] is not a positive number."
    }

}
