def grades = [ 45, 70, 95, 51 ].collect {
    switch (it) {
        case (90..100):
            'A'
            break
        case (70..89):
            'B'
            break
        case (50..69):
            'C'
            break
        default:
            'F'
    }
}

println grades
