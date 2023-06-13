
<h3>Testing the Oscar Sandbox web store for the sale of books and clothes

[Oscar Sandbox](https://latest.oscarcommerce.com/en-gb/catalogue/)

###
Oscar Sandbox is intended as a playground for experimenting with Oscar's features. Manual and automatic testing of the Oscar Sandbox website is my graduation project. As part of this project, I was able to use the acquired skills and some of the technologies studied during the education. During the work on the project, Smoky and regression testing were carried out, e2e tests were implemented.
###
### As an independent work for automated testing of the site were used:
- IntelliJ IDEA
- Java version 11
- Maven
- Selenium version 3.141.59
- TestNG 7.1.0
- DataProvider
- Page Object Model Pattern
- Logback-classic version 1.2.11
- Ashot version 1.5.4
- Jenkins

<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://www.jenkins.io" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/jenkins/jenkins-icon.svg" alt="jenkins" width="40" height="40"/> </a> <a href="https://www.selenium.dev" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/detain/svg-logos/780f25886640cef088af994181646db2f6b1a3f8/svg/selenium-logo.svg" alt="selenium" width="40" height="40"/> </a> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/linux/linux-original.svg" alt="linux" width="40" height="40"/> </a> <a href="https://www.selenium.dev" target="_blank" rel="noreferrer"> </p>

To launch a project via IntelliJ IDEA, as well as via the command line and Jenkins, you will find all the necessary dependencies and builds in
[pom.xml](https://github.com/Olchik5/OscarSandbox/blob/main/pom.xml)

##### Run tests via the command line use the command:
```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testngSmokyTestOscar.xml
```
##### Run tests via Jenkins use:
```bash
java -jar jenkins.war
localhost:8080
```

### In teamwork during manual testing and preparation of test documentation were used, such tools as:
- TestLink
- MindMap
- Jira

#### You can read the test documentation in detail  [here](https://docs.google.com/spreadsheets/d/1FTwBr2ZMarSJlSf8UhqJepka_jUeK-pQryNizCQlGHg/edit?usp=sharing)
###
I checked the first version of the [Oscar](http://selenium1ру.pythonanywhere.com/en-gb/) website and found 12 bugs, then checked the second version of the site [Oscar](https://latest.oscarcommerce.com/en-gb/catalogue/), where 9 bugs were fixed, but found 5 more bugs.
#### You can view my bug reports in Jira  [here](https://drive.google.com/drive/folders/1CIv4b7FW-4b0UjX_JjKgssr_S5CpCyMc?usp=share_link)
####
For screenshots and making video bug reports, I used:
- PicPick
- BandiCam
