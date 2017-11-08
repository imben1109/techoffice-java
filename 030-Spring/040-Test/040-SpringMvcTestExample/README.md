# Spring MVC Test Example

## Spring MVC Test
```
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.0.1</version>
</dependency>
```
The servlet-api library is required to add to dependency because there is no container in Spring test environment.

@WebAppConfiguration is required to add to Test class. It could automatically read the src/main/webapp for mocking servlet environment¡C

Spring Test also provide MockMvc for mocking request to the servlet. You can test your controller by getting the response.

```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans.xml")
@WebAppConfiguration
public class HomeControllerTest {
	
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void homeTest() throws Exception {
    	String reponse = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn().getResponse().getContentAsString();
    	System.out.println(reponse);
    	Assert.assertEquals(reponse, "Welcome to Spring MVC Test Example");
    }


}
```
