package org.groovy_tutorial.shapes.app

import org.groovy_tutorial.shapes.Circle
import org.groovy_tutorial.shapes.Rectangle
import org.groovy_tutorial.shapes.Square
import org.groovy_tutorial.shapes.Triangle
import org.groovy_tutorial.shapes.triangle.TriangleEquilateral
import org.groovy_tutorial.shapes.triangle.TriangleIsosceles
import org.groovy_tutorial.shapes.triangle.TriangleRightAngled

def shapes = [
        new Rectangle(10, 2),
        new Square(4),
        new Circle(8),
        new Triangle(5, 8, 10),
        new TriangleRightAngled(3, 4),
        new TriangleIsosceles(2, 8),
        new TriangleEquilateral(6) ]

println """
${'=' * 80}

Welcome to the Shapes demo

${'=' * 80}
"""

shapes.each {
    println "${it.displayInfo}\n"
    //println "  - toString(): ${it.toString()}"
}
