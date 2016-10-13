# Spring Test Example

## Prerequisite
* Maven 3
* Eclipse Mars 4.5.1

## Dependencies
* Spring 4.3
* JUnit 4.12

## Example
This is a an example demonstrating Unit Testing of Spring Application. The Unit test can be done in Spring Environment.

### SimpleSpringServiceTest.java
It is example of testing in Spring Test environment. It contain a separate configuration. Bean could automatically injected for testing.

## Spring Test

```
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>4.3.0.RELEASE</version>
</dependency>
```

Spring provide a SpringJUnit4ClassRunner so that the spring application can be tested in standalone environment.

```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans.xml")
public class SimpleSpringServiceTest {
	
	@Autowired
	private SimpleSpringService simpleSpringService;
	
	@Test
	public void test(){
		String result = simpleSpringService.test();
		Assert.assertEquals(result, "Test");
	}
}
```

The Spring can be configured separately in Spring Test Environment.
