# Maven Jar Plugin Example

## Command 

```
mvn jar:jar
```

The jar would be built in the folder target as MavenJarExample-0.0.1-SNAPSHOT.jar

```
java -cp target\MavenJarExample-0.0.1-SNAPSHOT.jar com.techoffice.example.Appl
```

## Reminder
Normally, Maven Jar Plugin 3.0.2 is not compatiable with Eclipse Mars.
In this example, Maven Jar Plugin 2.6 is used instead.

