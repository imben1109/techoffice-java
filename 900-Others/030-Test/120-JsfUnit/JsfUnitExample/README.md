# Aruqillian Example

## Dependencies
* junit 4.8.1
* Aruqillian 1.0.3
* Weld 1.0.0

## Arquillian
Aquillian is an Integration Test Framework for J2EE. 

## Weld
Weld is a J2EE Context and Dependency Injection (CDI) Container. Many popular J2EE Container integrate with Weld such as JBoss, GlassFlish, Weblogic and Websphere. It could be used in J2SE and Tomcat to provide the capacity of CDI. 

## Example
This Example test with J2EE Container Context Dependency Inject (CDI) capacity. The J2EE Container used for testing is Embedded Weld.

Sample Test Code
```
@RunWith(Arquillian.class)
public class SimpleTest {
	
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClasses(TestBean.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        // System.out.println(jar.toString(true));
        return jar;
    }
    
    @Inject
    TestBean testBean;
    
    @Test
    public void test(){
    	testBean.sayHi();
    }
}
```

Maven Dependencies
```
<!-- JUnit -->
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.8.1</version>
	<scope>test</scope>
</dependency>

<!-- Arquillian -->
<dependency>
	<groupId>org.jboss.arquillian</groupId>
	<artifactId>arquillian-bom</artifactId>
	<version>1.0.3.Final</version>
	<type>pom</type>
</dependency>
<dependency>
	<groupId>org.jboss.arquillian.junit</groupId>
	<artifactId>arquillian-junit-container</artifactId>
	<version>1.0.3.Final</version>
	<scope>test</scope>
</dependency>

<!-- J2EE Container: Embedded Weld -->
<dependency>
	<groupId>org.jboss.spec</groupId>
	<artifactId>jboss-javaee-6.0</artifactId>
	<version>1.0.0.Final</version>
	<type>pom</type>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>org.jboss.arquillian.container</groupId>
	<artifactId>arquillian-weld-ee-embedded-1.1</artifactId>
	<version>1.0.0.CR5</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.jboss.weld</groupId>
	<artifactId>weld-core</artifactId>
	<version>1.1.9.Final</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-simple</artifactId>
	<version>1.6.4</version>
	<scope>test</scope>
</dependency>
```