This repository achieves the same as the NoMaven repository but this time, using Maven. The goal is to show how Maven makes our life much easier

Here, thanks to Maven, all we had to do is create a basic pom.xml and run the following command:
```bash
$ mvn verify
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------< dev.migwel.maventutorial:basicmaven >-----------------
[INFO] Building basicmaven 1
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running dev.migwel.maventutorial.nomaven.QuoteFetcherTests
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.199 s -- in dev.migwel.maventutorial.nomaven.QuoteFetcherTests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.284 s
[INFO] Finished at: 2023-10-23T21:04:14+02:00
[INFO] ------------------------------------------------------------------------
```

The tests were executed successfully and this time, we didn't need to run a crazy long java command to specify all our dependencies (and their own transitive dependencies!)