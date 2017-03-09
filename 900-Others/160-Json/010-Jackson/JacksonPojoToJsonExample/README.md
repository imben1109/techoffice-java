
```
public class User {
	private String userid;
	private String name;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
```

```
ObjectMapper mapper = new ObjectMapper();
User user = new User();
user.setUserid("001");
user.setName("Test Name");
String userJsonStr = mapper.writeValueAsString(user);
System.out.println(userJsonStr);
```