class Person {
    def name
}

class StaffMember extends Person {
    def staffID

    def getIdentification() {
        println "${this.name} - ${this.staffID}"
    }
}

def sally = new StaffMember(name: 'Sally', staffID: 765)
sally.getIdentification()