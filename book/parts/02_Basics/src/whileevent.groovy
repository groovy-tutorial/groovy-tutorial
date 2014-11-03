def flag = false
Scanner input = new Scanner(System.in)

while (!flag) {
    print 'Enter a number and press <return>: '
    num = input.nextInt()
    if (num == 3) {
        flag = true
    } else {
        print "You picked $num but I want you to pick 3"
        println ''
    }
}
println 'You picked the number 3 and that makes me happy'
input.close()