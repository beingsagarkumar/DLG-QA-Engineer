Steps to setup project:
1. Clone the project from the git repo.

Steps to execute suite:
1. Either open the directory in cmd and run "mvn clean install". It will build all dependencies and execute the TestRunner class.
2. If step1 doesn't work, Please open the project in IDE (Eclipse/ IntelliJ), build the dependencies and run "src/test/java/runners/TestRunner.java" file
by right click and run as "JUnit Test".
3. It will execute the suite and html report will be generated in "target/cucumber-reports.html".

Points for improvement:
1. Adding extent report. Supporting code is written but not integrated to deliver report fast and avoiding respecive libraries in pom.xml. Same are commented out in pom.xml.
2. Capturing screenshots for failed test cases and integrate them with extent report.
3. Adding logs using logger and steps for logs.
4. Making project more dynamic for future requirements.
5. Project can be integrated on CI pipeline (Jenkins/GitLab) using yml file.
6. For Reporting, logs and screenshots files, an additional directory is to be created in src.

Note:
1. Test cases are written in LogInTest.Feature file with various scenarios for valid and invalid credentials validating data type and length of the fields.
2. User can run suite on any environment supporting java and maven.
3. Test scripts response is available in JUnit console/console of IDE. 
