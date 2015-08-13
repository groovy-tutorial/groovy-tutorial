import groovy.transform.Canonical
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@Canonical
class Assignment implements Cloneable {
    final String studentName
    String answers

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Assignment(studentName, answers)
    }
}

@Canonical
class SubmissionSystem {
    Map submissions = [:]

    def submitAssignment(Assignment sub) {
        if (!submissions.get(sub.studentName)) {
            submissions.put sub.studentName, sub.clone()
        }
    }
}

Assignment myAssignment = new Assignment('Fred Nurk', 'I have no idea')

SubmissionSystem system = new SubmissionSystem()

system.submitAssignment(myAssignment)
println system

myAssignment.answers = 'A really good set of answers'
println system
