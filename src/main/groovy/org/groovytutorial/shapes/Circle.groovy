package org.groovytutorial.shapes

import static java.lang.Math.PI

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Describes a circle
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includes = 'radius')
@ToString(includeNames = true, includeFields = true, includePackage = true)
final class Circle implements TwoDimensionalShape {
    private     static final String SHAPE_NAME = 'Circle'

    /** The radius of the circle */
    final BigDecimal radius

    /** The circle's perimeter (circumference) */
    final BigDecimal perimeter

    /** The circle's area */
    final BigDecimal area

    /**
     *
     * @param radius the radius of the circle (must be a positive number)
     * @throws IllegalArgumentException if radius <= 0
     */
    Circle(BigDecimal radius) throws IllegalArgumentException {
        ShapeUtil.checkSidesException(radius)
        this.radius = radius
        this.perimeter = calculatePerimeter(radius)
        this.area = calculateArea(radius)
    }

    /**
     * Helper function - defers to calculatePerimeter
     * @see #calculatePerimeter(Number)
     * @param radius
     * @return the circumference (perimeter)
     * @throws IllegalArgumentException if radius <= 0
     */
    static BigDecimal calculateCircumference(Number radius) throws IllegalArgumentException {
        calculatePerimeter(radius)
    }

    /**
     * Calculates the perimeter of a circle using the formula: p = 2*Pi*r
     * @param radius
     * @return the perimeter
     * @throws IllegalArgumentException if radius <= 0
     */
    static BigDecimal calculatePerimeter(Number radius) throws IllegalArgumentException {
        ShapeUtil.checkSidesException(radius)
        (2 * PI * radius) as BigDecimal
    }

    /**
     * Calculates the area of a circle using the formula: a = Pi*r^2
     * @param radius
     * @return the area
     * @throws IllegalArgumentException if radius <= 0
     */
    static BigDecimal calculateArea(Number radius) throws IllegalArgumentException {
        ShapeUtil.checkSidesException(radius)
        (PI * radius**2) as BigDecimal
    }

    /**
     * Calculates the circle's diameter using the formula: d = 2r
     * @param radius
     * @return the diameter
     * @throws IllegalArgumentException if radius <= 0
     */
    static BigDecimal calculateDiameter(Number radius) throws IllegalArgumentException {
        ShapeUtil.checkSidesException(radius)
        (radius * 2) as BigDecimal
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: radius = $radius; diameter = $diameter; \
circumference = ${circumference}; area = ${area}"
    }

    /**
     * Just a convenience - equivalent to getPerimeter
     * @return the circumference
     */
    BigDecimal getCircumference() {
        perimeter
    }

    /**
     * A pseudo getter
     * @return the diameter
     */
    Number getDiameter() {
        calculateDiameter(this.radius)
    }

    @Override
    String getShapeName() {
        SHAPE_NAME
    }
}
