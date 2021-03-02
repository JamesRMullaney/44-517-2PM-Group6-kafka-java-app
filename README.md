# 44-517-2PM-Group6-kafka-java-app

## Team Lead: James Mullaney 

#### Team members: (team: add your name below when you get in)
<table>
  <tr>
  <td align="center"><a href="https://github.com/GuanMingChee"><img src="https://media-exp1.licdn.com/dms/image/C4E03AQFGCcqJt0vhMw/profile-displayphoto-shrink_800_800/0/1579219859147?e=1618444800&v=beta&t=7O8YlngIKOk8uvVM3E68Sv_VFgb7Da5xC9lz6PejEGQ" width="100px;" alt=""/><br /><sub><b>Guan Ming Chee</b></sub></a><br /><a href="https://github.com/GuanMingChee" title="Code">💻</a></td>
  <td align="center"><a href="https://github.com/ChaseStaples"><img src="https://avatars.githubusercontent.com/ChaseStaples" width="100px;" alt=""/><br /><sub><b>Chase Staples</b></sub></a><br /><a href="https://github.com/ChaseStaples" title="Code">💻</a></td>
   <td align="center"><a href="https://github.com/JamesRMullaney"><img src="https://avatars.githubusercontent.com/JamesRMullaney
" width="100px;" alt=""/><br /><sub><b>James Mullaney</b></sub></a><br /><a href="https://github.com/JamesRMullaney" title="Code">💻</a></td>
     <td align="center"><a href="https://github.com/Dixith1196"><img src="https://avatars.githubusercontent.com/u/60023341?s=460&u=fb45357be42f7f2b97401c4e7f6e607b781c8f8b&v=4" width="100px;" alt=""/><br /><sub><b>Deekshith Maram</b></sub></a><br /><a href="https://github.com/Dixith1196" title="Code">💻</a></td>
  </tr>
</table>

## Prerequisities

* OpenJDK or JDK (8 or up)
* Apache Zookeeper, installed and working
* Apache Kafka, installed and working

## Start Zookeeper Service

Start Zookeeper service. 

## Start Kafka Service

Start Kafka service. 

## Create the Topic

Create a Kafka topic. 


```PowerShell
mvn clean compile assembly:single
```

## Start Consumer

Open PowerShell as Administrator in the root project folder, start the original consumer app using your topic and group ID with:

```PowerShell
java -cp target/44-517-2PM-Group6-kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdatasec2group6.kafka.Consumer test group1
```

## Start Producer

Open a new PowerShell as Administrator in the root project folder, start the Producer app using topic test:

```PowerShell
java -cp target/44-517-2PM-Group6-kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdatasec2group6.kafka.ProducerByChase test
java -cp target/44-517-2PM-Group6-kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdatasec2group6.kafka.ProducerByChee test
```
