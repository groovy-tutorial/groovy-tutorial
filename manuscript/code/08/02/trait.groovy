class Project {
    def name
}

trait Agile {
    def iterationLength = 4
    def backlog = []
    def developmentTeam = []

    def startIteration() {
        println """\
	            We're staring our $iterationLength week iteration for $name
	            Team members: $developmentTeam
	            Backlog: $backlog
	            """
    }
}

class Scrum
        extends Project
        implements Agile {

    def productOwner
    def scrumMaster
}

def project = new Scrum().with {
    name = "Project X"
    iterationLength = 2
    productOwner = 'Charlie'
    scrumMaster = 'Bobby'
    developmentTeam = ['Dean', 'Sam']
    backlog << 'As a User I want to press buttons'
    backlog << 'As an Admin I want to lockout users'
    return it
}

project.startIteration()
