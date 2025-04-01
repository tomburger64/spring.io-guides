# https://spring.io/guides/gs/scheduling-tasks
- through a terminal, cd into scheduling-tasks folder and run mvnw.cmd spring-boot:run to start (windows)
- control+c to stop

This project has an app .jar file made at scheduling-tasks\target\scheduling-tasks-0.0.1-SNAPSHOT.jar
To run it trough terminal, cd into scheduling-tasks and run:
- java -jar target/scheduling-tasks-0.0.1-SNAPSHOT.jar

Sum up of learned stuff (still need practice but I get it):
- @EnableScheduling enables scheduled stuff, needs to be above main class
- @Scheduled() tells when the following method should run, takes in fixedRate = 123 / cron = 123 / fixedDelay = 123 / initialDelay = 123 to mention the interval
- how to make an app off of a project using maven:
- - through terminal, cd into project folder
- - run `mvnw.cmd clean package`, which will make a .jar into the target folder
