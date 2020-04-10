# OpenMediation Dashboard Server

OpenMediation Dashboard Server provides API services for [OM-Dashboard-UI](https://github.com/AdTiming/OM-Dashboard-UI).  

## Usage

### Packaging

You can package using [mvn](https://maven.apache.org/).

```
mvn clean package -Dmaven.test.skip=true
```

After packaging is complete, you can find "om-ds-server.jar" in the directory "target".  
"om-ds-server.jar" is a executable jar, see [springboot](https://spring.io/projects/spring-boot/)


### Configuration

"om-ds-server.conf"

```shell script
## springboot cfg ###
MODE=service
APP_NAME=om-ds-server
#JAVA_HOME=/usr/local/java/jdk
JAVA_OPTS="-Dapp=$APP_NAME\
 -Duser.timezone=GMT+08\
 -Xmx3g\
 -Xms1g\
 -server"

RUN_ARGS="--spring.profiles.active=prod"
PID_FOLDER=log
LOG_FOLDER=log
LOG_FILENAME=stdout.log
```

### Run

put "om-ds-server.conf" and "om-ds-server.jar" in the same directory.

```
├── om-ds-server.conf
├── om-ds-server.jar
└── log
```

```shell script
mkdir -p log
./om-ds-server.jar start
```

### Logs

```shell script
tail -f log/stdout.log
```

### Stop

```shell script
./om-ds-server.jar stop
```

### Restart

```shell script
./om-ds-server.jar restart
```


