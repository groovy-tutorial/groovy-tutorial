import groovy.json.JsonSlurper

class Configuration {
    static String databaseName = ''
    static String databasePassword = ''
    static String logFile = ''

    static loadConfig() {
        //This is the config file:
        File file = new File('config.json')

        //We use JsonSlurper to read a JSON file:
        JsonSlurper slurper = new JsonSlurper()

        //Now parse the config file
        def config = slurper.parse(file)

        //We can access the config file elements using dot-point notation:
        databaseName = config.database
        databasePassword = config.password
        logFile = config.log

    }
}

Configuration.loadConfig()

println """\
    System database: ${Configuration.databaseName}
    System database password: ${Configuration.databasePassword}
    Log file: ${Configuration.logFile}
"""
