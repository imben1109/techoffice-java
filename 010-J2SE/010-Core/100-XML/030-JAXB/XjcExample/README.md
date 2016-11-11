# Java Architecture for XML Binding (Jaxb) Binding Compiler (xjc) Example
xjc can launched through xjc shell script in bin directory.

student.xsd
```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="student" type="student"/>
  <xs:complexType name="student">
	<xs:sequence>
		<xs:element name="name" type="xs:string" minOccurs="0"/>
	</xs:sequence>
  </xs:complexType>
</xs:schema>
```

Command to Generate Java Source Code
```
<JDK Home>\bin\xjc.exe student.xsd
```

It would generate two files 
* generated\ObjectFactory.java 
* generated\Student.java       

The generated Java Code could be used for Jaxb.

## Related Bugs
https://java.net/jira/browse/JAXB-1001
Currently, there is a bug found that the local would not be passed to xjc.exe. Then the language of javadoc would be according to machine. 
The workaround would be maven-xjc plugin. The locale configuration could be set in pom.xml.
