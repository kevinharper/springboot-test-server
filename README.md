# Springboot Test Server with Sleuth

Demo to show a basic spring-boot server.  Includes spring cloud sleuth feature allowing multiple logging spans to be created within the same service, thereby isolating a portion of processing in the logs.

## Getting Started
These instructions will get you up and running

### Prerequisites
```
Java 1.8
Git
```
### Installing
```
git clone repo
```
## See it in action
```
http://localhost:8080/springboot-test-server/new-span-for-subtask-in-same-service
```

Check the logs in /opt/springboot-test-server/logs and examine the log messages from different spans