# Spring Test Mockito Example

## Prerequisite
* Maven 3
* Eclipse Mars 4.5.1

## Dependencies
* Spring 4.3
* JUnit 4.12
* Mockito 2.0.111-beta

## Example
This is a an example demonstrate that Spring Test integrate with Mockito to mock bean for testing. 


Declare bean using Mockito (e.g. beans.xml)
```
<bean id="simpleSpringService" class="org.mockito.Mockito" factory-method="mock">
	<constructor-arg value="com.ittechoffice.example.SimpleSpringService" />
</bean>
```

Then the bean can be modified in Test Case
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans.xml")
public class SimpleSpringServiceTest {
	
	@Autowired
	private SimpleSpringService simpleSpringService;
	
	@Test
	public void test(){
		Mockito.when(simpleSpringService.test()).thenReturn("From Mockito");
		
		String result = simpleSpringService.test();
		System.out.println(simpleSpringService.test());
		Assert.assertEquals(result, "From Mockito");
	}
}

```