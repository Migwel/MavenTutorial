This repository shows how life is without Maven.


# Download all libraries and add them to the lib folder

## Jackson
https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.12.2/jackson-annotations-2.12.2.jar
https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.12.2/jackson-core-2.12.2.jar
https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.12.2/jackson-databind-2.12.2.jar


## JUnit
https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.1/junit-platform-console-standalone-1.7.1.jar

## Mockito
https://repo1.maven.org/maven2/org/mockito/mockito-core/3.6.28/mockito-core-3.6.28.jar

## ByteBuddy
https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy/1.10.22/byte-buddy-1.10.22.jar
https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy-agent/1.10.22/byte-buddy-agent-1.10.22.jar

## Objenesis
https://repo1.maven.org/maven2/org/objenesis/objenesis/3.2/objenesis-3.2.jar

# Compile the normal sources and the tests

```bash
javac -cp lib/jackson-annotations-2.12.2.jar:lib/jackson-core-2.12.2.jar:lib/jackson-databind-2.12.2.jar --source 17 -d out src/main/java/dev/migwel/maventutorial/nomaven/QuoteFetcher.java src/main/java/dev/migwel/maventutorial/nomaven/Quote.java
```
```bash
javac -cp out:lib/junit-platform-console-standalone-1.7.1.jar:lib/mockito-core-3.6.28.jar:lib/jackson-databind-2.12.2.jar --source 17 -d out src/test/java/dev/migwel/maventutorial/nomaven/QuoteFetcherTests.java

```

# Run the test
```bash
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path out:lib/jackson-databind-2.12.2.jar:lib/jackson-core-2.12.2.jar:lib/jackson-annotations-2.12.2.jar:lib/mockito-core-3.6.28.jar:lib/byte-buddy-agent-1.10.22.jar:lib/byte-buddy-1.10.22.jar:lib/objenesis-3.2.jar -c dev.migwel.maventutorial.nomaven.QuoteFetcherTests
```

Great, everything works but how tedious was that?!