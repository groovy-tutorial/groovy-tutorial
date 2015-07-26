enum Grades {
    FAIL,
    PASS,
    CREDIT

    def next() {
        switch (this) {
            case FAIL:
                return PASS
            case PASS:
                return CREDIT
            case CREDIT:
                return CREDIT
        }
    }

    def previous() {
        switch (this) {
            case FAIL:
                return FAIL
            case PASS:
                return FAIL
            case CREDIT:
                return PASS
        }
    }
}

println Grades.FAIL.next()
println Grades.PASS.next()
println Grades.CREDIT.next()

println Grades.FAIL.previous()
println Grades.PASS.previous()
println Grades.CREDIT.previous()
