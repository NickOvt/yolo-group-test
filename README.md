# Yolo Group test for Backend Java Junior dev
> By Nick Ovt

### Stack
- Java 17
- Spring Boot 3.1.1
- Dependencies: Gradle: latest

#### Project (Spring Boot) dependencies
- implementation 'org.springframework.boot:spring-boot-starter-web'
- implementation 'org.springframework.boot:spring-boot-starter-websocket'
- compileOnly 'org.projectlombok:lombok'
- annotationProcessor 'org.projectlombok:lombok'
- testImplementation 'org.springframework.boot:spring-boot-starter-test'
- implementation 'org.springframework.boot:spring-boot-starter-validation'

## Running in IDE
Running the project in an IDE such an intellij IDEA should be relatively straightforward.
Just open the project in the IDE, wait for it to index the project, download all dependencies
from the build.gradle file, and you're good to go!
You can run the application, by running the `JavaTestYoloGroupApplication` class.
You can run the test, by right clicking on the `org.yolotest.test` and click on Run Tests in ...

## Running through console
Easiest way to run the application without building it is to just run: `./gradlew bootRun` (on Linux, might first make it an executable though by running `chmod +x ./gradlew`) or
`./gradlew.bat bootRun` (on Windows).
To run the tests just run `./gradlew clean test --info`.
To actually build the `jar` run `./gradlew build` then (to run the jar) execute in cmd `cd build` `cd libs` and `java -jar <file ending in .jar>`. That's it! 🎉😀