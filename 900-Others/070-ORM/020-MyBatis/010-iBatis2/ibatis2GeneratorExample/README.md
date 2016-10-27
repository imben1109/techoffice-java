# iBatis Generator Example

## Maven Example

pom.xml
```
<build>
	<pluginManagement>
		<plugins>
			<plugin>
				<groupId>org.mybatis.generator</groupId>
				<artifactId>mybatis-generator-maven-plugin</artifactId>
				<version>1.3.5</version>
				<configuration>
					<verbose>true</verbose>
					<overwrite>true</overwrite>
				</configuration>
				<executions>
					<execution>
						<id>Generate MyBatis Artifacts</id>
						<goals>
							<goal>generate</goal>
						</goals>
					</execution>
				</executions>
				<dependencies>
					<!-- H2 Database -->
					<dependency>
						<groupId>com.h2database</groupId>
						<artifactId>h2</artifactId>
						<version>1.4.192</version>
					</dependency>
				</dependencies>
			</plugin>
		</plugins>
	</pluginManagement>
</build>
```

Generator Config, resource/generatorConfig.xml


Command Line to execute MyBatis Generate
```
mvn mybatis-generator:generate
```
