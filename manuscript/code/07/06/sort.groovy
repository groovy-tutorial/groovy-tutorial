def nums = [42, -99, 6.3, 1, 612, 1, -128, 28, 0]

//Ascending
nums.sort{n1, n2 -> n1<=>n2 }

assert nums == [-128, -99, 0, 1, 1, 6.3, 28, 42, 612]