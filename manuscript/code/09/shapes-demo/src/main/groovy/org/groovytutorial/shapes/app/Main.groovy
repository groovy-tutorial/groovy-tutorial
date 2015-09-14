package org.groovytutorial.shapes.app

import org.groovytutorial.shapes.Circle
import org.groovytutorial.shapes.Rectangle
import org.groovytutorial.shapes.Square
import org.groovytutorial.shapes.Triangle
import org.groovytutorial.shapes.triangle.TriangleEquilateral
import org.groovytutorial.shapes.triangle.TriangleIsosceles
import org.groovytutorial.shapes.triangle.TriangleRightAngled

def shapes = [
        new Rectangle(10, 2),
        new Square(4),
        new Circle(8),
        new Triangle(5, 8, 10),
        new TriangleRightAngled(3, 4),
        new TriangleIsosceles(2, 8),
        new TriangleEquilateral(6) ]

shapes.each {
    println it.displayInfo
    println "  - toString(): ${it.toString()}"
    println()
}

