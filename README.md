## espressGO_API

This is a maven build, which is a dependency management system. If external libraries are needed, add them in the pom.xml file. 
Currently, the API rests on port 8080, so all API calls will essentially be "http:///localhost:8080/*"

When running the android app, the API must be running concurrently on the system so that the app can utilize the database since we don't want the database on the user end.

### RUN INSTRUCTION

Run EspressGoApiApplication.groovy
