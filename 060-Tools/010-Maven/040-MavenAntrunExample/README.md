# Maven Ant Run Plugin Example
This example shows how to use AntRun Plugin to execute ant script

```
mvn:antrun@run
```

pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.techoffice.example</groupId>
  <artifactId>AntMavenExample</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <build>
	  <pluginManagement>
	  	<plugins>
	      <plugin>
	        <artifactId>maven-antrun-plugin</artifactId>
	        <version>1.8</version>
	        <executions>
	          <execution>
	            <phase> <!-- a lifecycle phase --> </phase>
	            <id>run</id>
	            <configuration>
					<target name="run">
						<java jar="lib/AntHelloWorldExample.jar" fork="true"/>
					</target>
	            </configuration>
	            <goals>
	              <goal>run</goal>
	            </goals>
	          </execution>
	        </executions>
	      </plugin>
	
	  	</plugins>
	  </pluginManagement>
  </build>
</project>
```

## Ant

**Ant Command**
```
ant build
```
```
ant run
```

**build.xml**
```
<project>
	<!-- Execute Java -jar AntHelloWorldExample.jar -->
	<target name="run">
		<java jar="lib/AntHelloWorldExample.jar" fork="true"/>
	</target>
	
	<target name="build">
		<jar destfile="lib/AntHelloWorldExample.jar" basedir="target/classes">
            <manifest>
                <attribute name="Main-Class" value="com.techoffice.example.HelloWorldExample"/>
            </manifest>
		</jar>
	</target>
</project>
```

## Reference

* https://maven.apache.org/plugins/maven-antrun-plugin/