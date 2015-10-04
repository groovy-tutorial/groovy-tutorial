abstract class Thing {
    abstract String describe()

    @Override
    String toString() {
        'This is a thingy'
    }
}

class Blob extends Thing {
    String describe() {
        'I am an amorphous blob'
    }
}

def myObj = new Blob()
assert myObj.describe() == 'I am an amorphous blob'
