package org.groovytutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.groovytutorial.shapes.Triangle

@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class TriangleRightAngled extends Triangle {
    static final String TRIANGLE_TYPE = 'Right-angled'

    TriangleRightAngled(Number sideA, Number sideB,
                        Number sideC = calculateHypotenuse(sideA, sideB)) {
        super(sideA, sideB, sideC)
    }

    static Number calculateHypotenuse(Number sideA, Number sideB) {
        Math.sqrt(sideA**2 + sideB**2)
    }

    @Override
    Number getArea() {
        0.5 * sides.a * sides.b
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.getDisplayInfo()}"
    }
}
