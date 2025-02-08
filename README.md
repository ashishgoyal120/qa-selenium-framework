## Selenium Automation Framework

## Getting Started

### Prerequisites

- Requires [Selenium-Java Maven Dependency](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- Requires [TestNg Maven Dependency](https://mvnrepository.com/artifact/org.testng/testng)
- Requires [Extent Report Maven Dependency](https://mvnrepository.com/artifact/com.aventstack/extentreports)
- Requires [zt-zip Maven depenedency](https://mvnrepository.com/artifact/org.zeroturnaround/zt-zip) for Zipping the report.
- Requires [javax.mail maven dependency](https://mvnrepository.com/artifact/com.sun.mail/javax.mail)for mailing the report.
- Requires [ashot maven dependency](https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot) for taking screenshot.
- Requires [Jackson-databind Maven dependency](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)for serialization and deserialization Java object.
 
 
 ### Overview of the Folder Structure
 
<details>
<summary>[src/main/java](./src/main/java)</summary>

* org.selenium.annotations
	- `FrameworkAnnotations.java :`
	```bash
	In this Java Interface, this is a custom annotation that allows you to tag test methods with metadata such as the author and category.
    It contains two elements:
    - `AuthorType[] author();` → Specifies the author(s) of the test case.
    - `CategoryType[] category();` → Specifies the category of the test case (e.g., Smoke, Regression).
    
    We have Used 2 Annotations : 
    - `@Retention(RetentionPolicy.RUNTIME)` :This specifies that the annotation should be retained at runtime and be available for reflection.In your case, this means that the FrameworkAnnotation can be accessed at runtime using Java Reflection API, which is useful for dynamically handling test cases.
    - `@Target(ElementType.METHOD)` : This means that the annotation can only be applied to methods. In a Selenium project, this typically means test methods in a test class.
	```

</details>
