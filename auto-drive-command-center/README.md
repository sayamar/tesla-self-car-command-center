# Auto Driving Car Simulation


## Sequence Daigram

<img src="C:\Users\User\Softwares\micro-services\Tesla-Sun-self-drive\src\main\resources\AutoDriveSequence_Diagram.PNG"/>



## Technology/Tools/Approach:
- 
- [ ] Intellij IDEA
- [ ] Java 8
- [ ] Test Driven Development
- [ ] Maven 3.8.3


## Assumptions:
1. List of flights imported into In-Memory database during Startup
2. Flight Itinerary generated in PDF using following pattern **/SystemPath/<bookingConfirmNumber_lastname.pdf**

## Usage Guidance:
### Pre-requisites:
1. JDK 8
2. Maven 3.8.3

### Installation Steps:
1. Unzip the Tesla-Sun-self-drive.zip file

   2. ```cd``` into project location ```Tesla-Sun-self-drive```.
      ```bash
         cd self-drive-car/
      ```
      3. Execute ```maven``` install phase
         ```bash
            mvn clean install
         ```
         and you should be able to see that the application is built successfully.
         ```txt
		
          [INFO] Building Tesla-Sun-self-drive 1.0-SNAPSHOT
          [INFO] --------------------------------[ jar ]---------------------------------
          [INFO]
          [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Tesla-Sun-self-drive ---
          [INFO] Using 'UTF-8' encoding to copy filtered resources.
          [INFO] Copying 0 resource
          [INFO]
          [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Tesla-Sun-self-drive ---
          [INFO] Nothing to compile - all classes are up to date
          [INFO]
          [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ Tesla-Sun-self-drive ---
          [INFO] Using 'UTF-8' encoding to copy filtered resources.
          [INFO] skip non existing resourceDirectory C:\Users\User\Softwares\micro-services\Tesla-Sun-self-drive\src\test\resources
          [INFO]
          [INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ Tesla-Sun-self-drive ---
          [INFO] Nothing to compile - all classes are up to date
          [INFO]
          [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ Tesla-Sun-self-drive ---
          [INFO] No tests to run.
          [INFO]
          [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ Tesla-Sun-self-drive ---
          [INFO]
          [INFO] --- maven-install-plugin:2.4:install (default-install) @ Tesla-Sun-self-drive ---
          [INFO] Installing C:\Users\User\Softwares\micro-services\Tesla-Sun-self-drive\target\Tesla-Sun-self-drive-1.0-SNAPSHOT.jar to C:\Users\User\.m2\repository\org\example\Tesla-Sun-self-drive\1.0-SNAPSHOT\Tesla-Sun-self-drive-1.0-SNAPSHOT.jar
          [INFO] Installing C:\Users\User\Softwares\micro-services\Tesla-Sun-self-drive\pom.xml to C:\Users\User\.m2\repository\org\example\Tesla-Sun-self-drive\1.0-SNAPSHOT\Tesla-Sun-self-drive-1.0-SNAPSHOT.pom
          [INFO] ------------------------------------------------------------------------
          [INFO] BUILD SUCCESS
          [INFO] ------------------------------------------------------------------------
          [INFO] Total time:  2.309 s
          [INFO] Finished at: 2023-07-30T05:58:02-07:00
          [INFO] ------------------------------------------------------------------------

         ```
4. Now you are ready to start the ```Self Drive Simulator``` application in your local machine.
   
    1. Spring Boot Plugin: Execute below maven command:
       ```bash
          java -jar <recently-generated-jar-file-with-absolute-path>
          For example : java -jar Tesla-Sun-self-drive-1.0-SNAPSHOT.jar
       ```
       You should be able to see the command prompt to input values, If the application has started successfully.
       ```txt
       Test case 1
       ```
          ![](C:\Users\User\Softwares\micro-services\Tesla-Sun-self-drive\src\main\resources\Test1-Screenshot.PNG)

       ```txt
       Test case 2 Collision
       ```
       ![](C:\Users\User\Softwares\micro-services\Tesla-Sun-self-drive\src\main\resources\Test2-screenshot.PNG)

    

## Improvements:

	1. can write another test class to test Simulator by using Scanner  
	2. can seperate addCarToField and runSimulator methods to seperate class inline to Single responsibilty ( from SOLID principle )