```
mvn clean
mvn jaxb2:xjc
```
In order to make maven regenerate model class source code, maven should clean the cache first otherwise jaxb2:xjc command would not regenerate source codes.

By Default, xjc would generate source code with javadoc whose language is according to the locale. The Language of javadoc could be configurated in xjc maven plugin.
```
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>jaxb2-maven-plugin</artifactId>
	<version>2.3</version>
	<executions>
		<execution>
			<id>xjc</id>
			<goals>
				<goal>xjc</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<locale>fr</locale>
		<sources>
			<source>src/main/resources/student.xsd</source>
		</sources>
		<clearOutputDir>true</clearOutputDir>
		<outputDirectory>src/main/java</outputDirectory>
		<packageName>com.ittechoffice.example.student.model</packageName>
	</configuration>
</plugin>
```