Setup Development Environment: Ensure that you have Java Development Kit (JDK) installed on your computer. You can download and install JDK from the official Oracle website or use OpenJDK, which is an open-source alternative.

Download Dependencies: If your Spring Boot project uses external dependencies, make sure they are downloaded and configured. You can use a build tool like Maven or Gradle to manage dependencies.

Build the Project: Navigate to the root directory of your Spring Boot project using the command line or terminal and build the project using the following command:

`mvn clean install`

This command will compile your code, run tests, and package the application into a JAR file.

Run the Application: After successfully building the project, you can run the Spring Boot application using the following command:

`java -jar target/<your-project-name>.jar`

So currently one is able to view the results of the comparison between the csv files 
in the logs after running the application especially the differences object in the service class
add the logger class in the switch case class to view the descrepancies 

`for (String column : columns)`
`{switch(column){`
                `case "ID":`
                    `// Skip comparison for ID, as it's already compared in compareRecords method.`
                    `break;`
               `case "Name":`
                    `if (!sourceRecord.getName().equals(targetRecord.getName())) {`
                        `difference.addDifference(column, sourceRecord.getName(), targetRecord.getName());`
                    `}`
                    `break;`
                `case "Date":`
                    `if (!sourceRecord.getDate().equals(targetRecord.getDate())) {`
                        `difference.addDifference(column, sourceRecord.getDate(), targetRecord.getDate());`
                    `}`
                    `break;`
                `case "AvailableBalance":`
                    `if (sourceRecord.getAvailableBalance() != targetRecord.getAvailableBalance()) {`
                        `difference.addDifference(column, Double.toString(sourceRecord.getAvailableBalance()),` `Double.toString(targetRecord.getAvailableBalance()));`
                    `}`
                    `break;`

 so i have implemented a table which i was trying to show the results which is in the other repository 
 for front end and it has js code to make ajax calls in javascript
  here is the sample response.

  `{`
    `"differences": [`
        `{`
            `"type": null,`
            `"recordIdentifier": null,`
            `"field": null,`
            `"sourceValue": null,`
            `"targetValue": null,`
            `"id": "001"`
        `},`
        `{`
            `"type": null,`
            `"recordIdentifier": null,`
            `"field": null,`
            `"sourceValue": null,`
            `"targetValue": null,`
            `"id": "002"`
        `},`
        `{`
            `"type": null,`
            `"recordIdentifier": null,`
            `"field": null,`
            `"sourceValue": null,`
            `"targetValue": null,`
            `"id": "003"`
        `}`
    `]`
`}`

make sure to put the path of the csv files for your system .
Ensure you have xampp installed that act as a hosting service.