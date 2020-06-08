# Applitools Cross Browser Testing Hackathon

## OS

This solution was worked on Mac OSX Catalina 10.15.4

## Pre-requisites

- [Java 8 JDK](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
- Maven 3.6.3_1: `brew install maven`
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=mac)

## Libraries used

- Selenium WebDriver: - 3.141.59
- Applitools Eyes: - 3.164.0
- WebDriverManager: - 4.0.0
- TestNG: - 7.1.0
- Truth: - 1.0.1

## Plugins used

- Maven compiler: - 3.8.1
- Maven resource: - 3.1.0
- Maven surefire: - 3.0.0-M4

## Target Browsers

- [Chrome](https://www.google.com/chrome) (83.0.4103.61)
- [Firefox](https://www.mozilla.org/en-GB/firefox) (77.0 (64-bit))
- [Edge](https://www.microsoft.com/en-us/edge) (83.0.478.44)

## How to run?

### Modern approach

#### Terminal

```shell script
> mvn clean install -DEYE_API=<your_api_key>
```

### Traditional approach

#### Terminal

```shell script
> mvn clean install -DEYE_API=<your_api_key> -Dapproach=traditional
```
## Author

Wasiq Bhamla
