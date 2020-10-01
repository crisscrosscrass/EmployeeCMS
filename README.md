# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java 8+,

Maven (Maven is a Java tool, so you must have Java installed in order to proceed.)
First, [download Maven](https://maven.apache.org/download.cgi) and follow the [installation instructions](https://maven.apache.org/install.html). After that, type the following in a terminal or in a command prompt:
```
mvn --version
```

### Installing

Download the Repo

```
git clone url
```

change directory to the new downloaded Folder
```
cd EmployeeCMS
```

and Install the Whole Project by using 

```
mvn install
```

after that go to your target folder(the folder where the JAR File has been created) and run

```
java -jar Employee....jar
```

Once the JAR is running you can go to your localhost:8080 in the Browser and Test the Project.

#Closing
Once your done with testing, you can close the App by Strg+C
and after that go into the root directoy and clear the created files
```
cd ..
mvn clean
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)

