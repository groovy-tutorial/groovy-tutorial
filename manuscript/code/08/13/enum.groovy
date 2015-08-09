enum Months {
    JAN,
    FEB,
    MAR,
    APR,
    MAY,
    JUN,
    JUL,
    AUG,
    SEP,
    OCT,
    NOV,
    DEC
}

// enums help comparisons
assert Months.JAN != Months.DEC
assert Months.APR == Months.APR

// enums aren't text strings
assert Months.OCT != 'Oct'

// Assign a variable to be the value of an enum constant
Months myMonth = Months.AUG

// Iterate through the months
for (month in Months) {
    println month
}

//The values method returns a list of the constants in the enum
println Months.values()
