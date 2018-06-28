
# Proxy Example

This Example introduce java.lang.reflect.Proxy.

```
TestService test = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(), new Class[]{TestService.class}, new ExampleInvcationHandler());
```

```
public class ExampleInvcationHandler implements InvocationHandler{

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoked " + proxy.getClass() + " "+ method.getName());
		return null;
	}

	
}
```

```
public interface TestService {
	
	public String getName() ;
	public void setName(String name);
	public Integer getAge() ;
	public void setAge(Integer age) ;
	
}
```