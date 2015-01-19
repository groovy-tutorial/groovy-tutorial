@Grab(group='org.apache.commons', module='commons-csv', version='1.0')

import static java.nio.charset.StandardCharsets.UTF_8
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser

//http://commons.apache.org/proper/commons-csv/apidocs/index.html
//Data: http://www.bom.gov.au/climate/data/?ref=ftr

def csvData = new File('sampledir/data/weather.csv')
def parser = CSVParser.parse(csvData, UTF_8, CSVFormat.RFC4180.withHeader())

def cities = [:]

for (record in parser) {
   if (cities[record.City] == null) {
       cities[record.City] = []
   }
   cities[record.City] << record.Maximum.toBigDecimal()
}

parser.close()

for (city in cities) {
    println "$city.key average was ${city.value.sum() / city.value.size()}"
}
