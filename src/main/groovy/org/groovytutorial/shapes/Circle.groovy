package org.groovytutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import static java.lang.Math.PI

/**
 * Describes a circle
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includes = 'radius')
@ToString(includeNames = true, includeFields = true, includePackage = true)
final class Circle implements TwoDimensionalShape {
    static final String SHAPE_NAME = 'Circle'

    final Number radius
    final Number perimeter
    final Number area

    /**
     *
     * @param radius the radius of the circle
     */
    Circle(Number radius) {
        this.radius = radius
        this.perimeter = calculatePerimeter(radius)
        this.area = calculateArea(radius)
    }

    static Number calculateCircumference(Number radius) {
        calculatePerimeter(radius)
    }

    static Number calculatePerimeter(Number radius) {
        2 * PI * radius
    }

    static Number calculateArea(Number radius) {
        PI * radius**2
    }

    static Number calculateDiameter(Number radius) {
        radius * 2
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: radius = $radius; diameter = $diameter; circumference = ${circumference.trunc(4)}; area = ${area.trunc(4)}"
    }

    /**
     * Just a convenience - equivalent to getPerimeter
     * @return the circumference
     */
    Number getCircumference() {
        perimeter
    }

    /**
     * A pseudo getter
     * @return the diameter
     */
    Number getDiameter() {
        calculateDiameter(this.radius)
    }

    /**
     *
     * @param obj
     * @return true if obj is a Circle and has the same radius as this instance, false otherwise
     */
    @Override
    boolean equals(Object obj) {
        if (obj instanceof Circle) {
            return this.radius == obj.radius
        }
        false
    }
}
