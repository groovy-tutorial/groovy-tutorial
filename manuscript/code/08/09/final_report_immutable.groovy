import groovy.transform.Immutable

@Immutable
class FinalReport {
    final List records
}

@Immutable
class Record {
    Date creationDate = new Date()
    String title
    String text
}

def recordSet = [
        new Record(title: 'Record A', text: 'This is a record'),
        new Record(title: 'Record B', text: 'This is another record'),
        new Record(title: 'Record C', text: 'This is yet another record')
]

FinalReport report = new FinalReport(recordSet)

//This will fail with groovy.lang.ReadOnlyPropertyException
try {
    report.records[1].text = 'REDACTED'
} catch (ReadOnlyPropertyException e) {
    println 'Sorry, you can\'t change a record in a final report'
}

//This will fail with java.lang.UnsupportedOperationException
try {
    report.records << new Record(title: 'Record Z', text: 'You just go hacked')
} catch (UnsupportedOperationException e) {
    println 'Sorry, you can\'t add a record to a final report'
}

println report
