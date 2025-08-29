# 🚀 Selenium Automation Framework

A robust automation framework built with **Selenium WebDriver**, **TestNG**, and **Maven**, designed for scalable test execution, reporting, and integration.

---

## 📌 Getting Started

### ✅ Prerequisites
Ensure the following Maven dependencies are added to your `pom.xml`:

- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) → Browser automation  
- [TestNG](https://mvnrepository.com/artifact/org.testng/testng) → Test framework (annotations, assertions, parallel execution)  
- [Extent Reports](https://mvnrepository.com/artifact/com.aventstack/extentreports) → Rich HTML reports  
- [zt-zip](https://mvnrepository.com/artifact/org.zeroturnaround/zt-zip) → Zip/unzip reports for sharing  
- [javax.mail](https://mvnrepository.com/artifact/com.sun.mail/javax.mail) → Email test reports  
- [ashot](https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot) → Full-page and element-level screenshots  
- [Jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind) → Serialization & deserialization of JSON test data  

---

## ▶️ Executing Tests

### Using Eclipse IDE
1. Navigate to `src/test/resources/testng_local.xml`  
2. Right-click → **Run As → TestNG Suite**  

**OR**

### Using Maven (Terminal / CMD)
```bash
cd <project-root>
mvn clean test -DsuiteXmlFile=testng_Local.xml
```

---

### 🔄 Execution Flow

 1. When we run ***mvn test*** Maven looks into your ***pom.xml***.
 2. In ***pom.xml***, under the ***maven-surefire-plugin***, TestNG is configured (directly or via testng.xml).
 3. So Maven doesn’t execute your tests directly. It delegates execution to the Surefire Plugin, which then invokes TestNG.

 ---

 ## Understanding POM.xml file in Detail : 
 ### 1. Project Metadata
 ```xml
<modelVersion>4.0.0</modelVersion>
<groupId>seleniumFramework</groupId>
<artifactId>seleniumFramework</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>seleniumFramework</name>
<url>http://www.example.com</url>
```
- **modelVersion** → Always 4.0.0 for Maven projects.
- **groupId** → Unique ID for your project’s group (like a company/domain).
- **artifactId** → Name of the project (this becomes the JAR name).
- **version** → Project version (SNAPSHOT = work in progress).
- **name/url** → Metadata (not mandatory, but useful for documentation).
- **Purpose**: Defines your project’s identity in Maven’s world.

### 2. Properties
```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.release>17</maven.compiler.release>
    <suiteFile>testng_Local</suiteFile>
    <aspectj.version>1.9.4</aspectj.version>
    <browserInstances>2</browserInstances>
</properties>
```
- **project.build.sourceEncoding** → Ensures all files use UTF-8 (avoids weird character issues).
- **maven.compiler.release** → Java version (17 here).
- **suiteFile** → TestNG XML file name (used in Surefire plugin).
- **aspectj.version** → Version of AspectJ (needed for weaving code at runtime, used with listeners).
- **browserInstances** → Custom property to control parallel browser count (read in Surefire plugin).
- **Purpose**: Central place to manage constants (easy to update later).

### 3. Dependencies
```xml
<dependencies>
    <dependency> Selenium </dependency>
    <dependency> TestNG </dependency>
    <dependency> ExtentReports </dependency>
    <dependency> zt-zip </dependency>
    <dependency> javax.mail </dependency>
    <dependency> commons-io </dependency>
    <dependency> ashot </dependency>
    <dependency> jackson-databind </dependency>
</dependencies>
```
- **selenium-java** → Core library to drive browsers.
- **testng** → Testing framework (annotations, assertions, parallel execution).
- **extentreports** → Beautiful HTML test reports.
- **zt-zip** → To zip/unzip test reports or screenshots (for sharing).
- **javax.mail** → Send reports via email.
- **commons-io** → File handling utilities (copy, delete, etc.).
- **ashot** → Take full-page or element screenshots.
- **jackson-databind** → Read/write JSON (useful for test data, API response validation).
- **Purpose**: These are your toolkit libraries for automation + reporting.

### 4. Build → Plugin Management
```xml
<build>
    <pluginManagement>
        <plugins>
```
- **This section defines all Maven plugins (tools that automate tasks).**

	a) Clean, Resources, Compiler
	```xml
		<plugin>
			<artifactId>maven-clean-plugin</artifactId>
			<version>3.4.0</version>
		</plugin>
		<plugin>
			<artifactId>maven-resources-plugin</artifactId>
			<version>3.3.1</version>
		</plugin>
		<plugin>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.13.0</version>
		</plugin>
	```
	- **clean-plugin** → Deletes old compiled files (target folder).
	- **resources-plugin** → Handles copying resources (.properties, .xml) to target.
	- **compiler-plugin** → Compiles Java code (here with Java 17).
	- **Purpose**: Standard build cycle tasks.

	b) Surefire Plugin (Most Important for You 🚀)
	```xml
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-surefire-plugin</artifactId>
			<version>3.0.0-M5</version>
			<configuration>
				<threadCount>${browserInstances}</threadCount>
				<suiteXmlFiles>
					<suiteXmlFile>src/test/resources/${suiteFile}.xml</suiteXmlFile>
				</suiteXmlFiles>
				<argLine>
					-javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
				</argLine>
			</configuration>
			<dependencies>
				<dependency>
					<groupId>org.aspectj</groupId>
					<artifactId>aspectjweaver</artifactId>
					<version>${aspectj.version}</version>
				</dependency>
			</dependencies>
		</plugin>
	```
	- **Surefire plugin** → Runs your TestNG tests when you do mvn test.
	- **threadCount** → Runs multiple browsers in parallel (based on your property).
	- **suiteXmlFiles** → Defines which TestNG XML to run (testng_Local.xml).
	- **argLine** → Loads AspectJ agent for weaving (used if you’re doing advanced stuff like listeners or retry analyzers).
	- **aspectjweaver dependency** → Required for AspectJ runtime.
	- **Purpose**: Controls how TestNG executes your tests.

	c) Jar, Install, Deploy
	```xml
		<plugin> maven-jar-plugin </plugin>
		<plugin> maven-install-plugin </plugin>
		<plugin> maven-deploy-plugin </plugin>
	```
	- **jar-plugin** → Packages your code as a .jar.
	- **install-plugin** → Installs JAR into your local Maven repo.
	- **deploy-plugin** → Deploys to remote repo (if needed).
	- **Purpose**: Packaging + distribution.

	d) Site and Reports
	```xml
		<plugin> maven-site-plugin </plugin>
		<plugin> maven-project-info-reports-plugin </plugin>
	```
	- **site-plugin** → Generates project documentation site.
	- **project-info-reports-plugin** → Generates reports (dependencies, plugin usage).
	- **Purpose**: Documentation and analysis.

<a href="#top">Back to top</a>
