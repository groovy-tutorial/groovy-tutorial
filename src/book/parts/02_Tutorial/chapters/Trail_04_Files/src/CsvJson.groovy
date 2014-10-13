@Grab(group='org.apache.commons', module='commons-csv', version='1.0')

import static java.nio.charset.StandardCharsets.UTF_8
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser

//http://commons.apache.org/proper/commons-csv/apidocs/index.html
//Data: http://www.bom.gov.au/climate/data/?ref=ftr

def csvData = new File('sampledir/data/weather.csv')
def parser = CSVParser.parse(csvData, UTF_8, CSVFormat.RFC4180.withHeader())
header_map = parser.getHeaderMap()

def json = new groovy.json.JsonBuilder(parser)

struct = [monthly_averages:[]]

parser.each { record -> 
    def row = [:]
    header_map.each { h ->
        row[h.key] = record[h.value]
    }
    struct.monthly_averages << row
}


json struct
println json.toPrettyString()

parser.close()
