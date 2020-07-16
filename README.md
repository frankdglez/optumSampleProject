# Optum Pathway CCM Developer Case Study


The only thing better than a Maven archetype is a repo you can fork with everything already setup. Skip the documentation and just fork-and-code.

Delete the sample code, replace with your own and you’re good to go.

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[H2](https://www.h2database.com) - Open-Source Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[OpenAPI](https://swagger.io/specification/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.
* 	[JUnit](https://junit.org/) - Testing framework for Java
* 	[mockito](https://swagger.io/specification/) - Mocking framework for unit tests in Java.


## External Tools Used

* 	[Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## To-Do

* 	[x] Create spring boot project
* 	[x] Save one user on H2 data base
* 	[x] Retrive one user
* 	[x] Retrieve all users

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.optum.optumsample.OptumSampleApplication` class from your IDE.

* [Clone](https://github.com/frankdglez/optumSampleProject) - Clone the Git repository.
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
##When the service is running

openAPI definition
* Please go to http://localhost:8080/developers - to view the CRUD operations implemented, you will find the following methods.
```
POST /save to save one user
```
```
GET /all to retrieve all users
```
```
GET /user/{userId} to retrieve one user based on the ID
```

### H2 database console
* To access the H2 console please go to http://localhost:8080/h2-console/ once there please replace the JDBC URL: with `jdbc:h2:file:./data/demo`

to view the CRUD operations implemented

|  Username     |  Password |
|---------------|-----------|
|`sa`   | password  |

Note.- All the information is on the 'application.yml'


### Testing on postman



### Web Page URLs

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080/save`       | POST |
|`http://localhost:8080/user/1`         | GET |
|`http://localhost:8080/all` | GET |

to save one user with the 'POST' operation please use the following on the body, select `raw` radio button and `JSON` from the dropdown menu at the left

```
{
    "firstName" : "John",
    "middleInitial": "D",
    "lastName": "Doe",
    "city":"Minneapolis",
    "state" : "MN",
    "zipCode": "55444",
    "phoneNumber" : "999-999-999"
}

IMPORTANT.- The fields `firstName, lastName` CAN'T be nulls
```

I have added 10 dummy users to the DB on the `data.sql` file under `resources` directory, and is recreated every time you restart the service, so if you add a user with the `POST` operation it will get the id 11.

###Package structure

## Files and Directories

```text
.
├── Sample_Optum
├── src
│   └── main
│       └── java
│           ├── com.optum.optumsample.controller
│           ├── com.optum.optumsample.exception
│           ├── com.optum.optumsample.model
│           ├── com.optum.optumsample.controller
│           ├── com.optum.optumsample.persistence
│           └── com.optum.optumsample.service
│           
├── src
│   └── main
│       └── resources
│           ├── static
│           ├── templates
│           │   └── view.html
│           └── application.yml
│           
├── src
│   └── test
│       └── java
│           └── com.optum.optumsample
│               ├── com.optum.optumsample.controller
│               └── com.optum.optumsample.service
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## packages

* 	`controllers` — to listen to the client;
* 	`exception` — to handle the exceptions;
* 	`models` — to hold our entities;
* 	`persistence` — to communicate with the database;
* 	`services` — to hold our business logic;
* 	`resources/` - Contains all the static resources, templates and property files.
* 	`resources/application.yml` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.
* 	`test/` - contains unit and integration tests
* 	`pom.xml` - contains all the project dependencies
