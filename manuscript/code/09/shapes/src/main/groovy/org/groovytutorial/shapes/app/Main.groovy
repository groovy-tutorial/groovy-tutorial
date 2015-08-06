package org.groovytutorial.shapes.app

import org.groovytutorial.shapes.Circle
import org.groovytutorial.shapes.Rectangle
import org.groovytutorial.shapes.Square
import org.groovytutorial.shapes.Triangle
import org.groovytutorial.shapes.triangle.TriangleEquilateral
import org.groovytutorial.shapes.triangle.TriangleIsosceles
import org.groovytutorial.shapes.triangle.TriangleRightAngled

def shapes = [
        Rectangle rectangle = new Rectangle(10, 2),
        Square square = new Square(4),
        Circle circle = new Circle(8),
        Triangle triangle = new Triangle(5, 8, 10),
        TriangleRightAngled triangleRightAngled = new TriangleRightAngled(3, 4),
        TriangleIsosceles triangleIsosceles = new TriangleIsosceles(2, 8),
        TriangleEquilateral triangleEquilateral = new TriangleEquilateral(6)
]

shapes*.getPerimeter()
shapes*.getArea()

shapes.each {
    println it
}
