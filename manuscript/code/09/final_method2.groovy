class Person {
    String name
}

class SuperHero extends Person {

    final String discoverName() {
        'Unknown'
    }

    String discoverName(Boolean mindRead) {
        'Unknown'
    }

    final setName(name) {}
}

class BizarroSuperHero extends SuperHero {

    //This WILL be allowed:
    @Override
    String discoverName(Boolean mindRead) {
        name
    }
}

def batBoy = new BizarroSuperHero(name: 'Bryce Rain')

assert batBoy.discoverName() == 'Unknown'
assert batBoy.discoverName(true) == 'Bryce Rain'
