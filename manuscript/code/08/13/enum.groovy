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

// Iterate through the months
for (month in Months) {
    println month
}

// enums help comparisons
assert Months.JAN != Months.DEC
assert Months.APR == Months.APR

// enums aren't text strings
assert Months.OCT != 'Oct'

// Assign a variable to be the value of an enum constant
Months myMonth = Months.AUG
