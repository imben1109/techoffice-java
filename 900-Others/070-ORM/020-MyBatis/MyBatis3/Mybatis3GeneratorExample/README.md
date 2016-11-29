# MyBatis Generator Example

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
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>

	<context id="context1">
		<!-- JDBC Connection -->
		<jdbcConnection connectionURL="jdbc:h2:./test"
			driverClass="org.h2.Driver" password="" userId="sa" />

		<!-- Model -->
		<javaModelGenerator targetPackage="com.ittechoffice.example.model"
			targetProject="src/main/java">

			<property name="enableSubPackages" value="true" />
			<property name="trimStrings" value="true" />

		</javaModelGenerator>

		<!-- SQL Map -->
		<sqlMapGenerator targetPackage="com.ittechoffice.example.xml"
			targetProject="src/main/java">
			
			<property name="enableSubPackages" value="true" />
			
		</sqlMapGenerator>

		<!-- DAO -->
		<javaClientGenerator type="XMLMAPPER" targetPackage="com.ittechoffice.example.dao" 
			targetProject="src/main/java">
			
			<property name="enableSubPackages" value="true" />
			
		</javaClientGenerator>

		<!-- Database Table Mapping -->
		<table tableName="TABLE1">
		</table>

	</context>
</generatorConfiguration>
```

Command Line to execute MyBatis Generate
```
mvn mybatis-generator:generate
```
