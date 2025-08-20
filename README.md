# SpiceJet UI Automation (Selenium + Cucumber + TestNG)

A ready-to-run UI automation starter for the SpiceJet login scenario.

## Stack
- Java 11, Maven
- Selenium 4, WebDriverManager
- Cucumber BDD + TestNG runner
- Page Object Model (POM)
- GitHub Actions CI (headless Chrome)

## Run locally
```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

> By default tests run **headless** in CI. Locally you can see the browser by unsetting `HEADLESS`:
- On mac/linux:
```bash
HEADLESS=false mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```
- On Windows (PowerShell):
```powershell
$env:HEADLESS="false"; mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

## Reports
- HTML: `target/cucumber-report.html`
- JSON: `target/cucumber.json`

## Notes
- SpiceJet DOM changes often; tweak locators in `LoginPage.java` if needed.
- Credentials in the sample feature are placeholders.
