# Spring JavaFx Example
**Custom FXMLLoader**
```
public class SpringFxmlLoader extends FXMLLoader{
	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	
	public SpringFxmlLoader(){
		this.setControllerFactory(new Callback<Class<?>, Object>() {
			public Object call(Class<?> clazz) {
				// TODO Auto-generated method stub
				return applicationContext.getBean(clazz);
			}
		});
	}
	
	
	public Object load(String fxml) throws IOException {
		InputStream applFxml = this.getClass().getClassLoader().getResourceAsStream(fxml);
		return load(applFxml);
	}
}

```

Then, the Controller could use the Spring Bean for further operation.
```
@Component
public class ApplController {
	
	@Autowired
	private ApplService applService;
	
	@FXML
    private TextField inputText1;

	@FXML
	public void doSomething(){
		applService.doSomething();
	}
	
}
```