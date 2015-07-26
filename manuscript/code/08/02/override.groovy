class Person {
    def name

    def getName() {
        return this.name
    }
}

class StaffMember extends Person {
    def staffID

    @Override
    def getName() {
        "Team member ${super.name}"
    }

    def getIdentification() {
        println "${this.name} - ${this.staffID}"
    }
}

def sally = new StaffMember(name: 'Sally', staffID: 765)
println sally.name
