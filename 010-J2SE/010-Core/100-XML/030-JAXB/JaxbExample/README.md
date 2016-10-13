# Jaxb Java Architecture for XML Blinding (JAXB) Example

## Jaxb Java Architecture for XML Blinding (JAXB)

## Example List
* Appl
	* It show converting Java Bean to XML
* Xml2ModelExample  
	* It show converting XML to Java Bean
	
### Appl
```
User user = new User();
user.setName("Test User");
user.setAge(10);
JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
// output pretty printed
jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
jaxbMarshaller.marshal(user, System.out);
```

User.java
```
@XmlRootElement
public class User {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

```

### Xml2ModelExample  
```
String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><age>10</age><name>Test User</name></user>";
InputStream stream = new ByteArrayInputStream(xml.getBytes());

JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
User user = (User) jaxbUnmarshaller.unmarshal(stream);
System.out.println(user.getAge());
System.out.println(user.getName());
```