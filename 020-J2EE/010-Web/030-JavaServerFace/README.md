# JavaServcer Face Example

## JavaServer Face (JSF)
JavaServer Face (JSF) is a Java Specification for building component-based user interface for web application. The architecture of JSF is MVC which separates the concern of logic from presentation. In JSF, the logic would be managed in Managed Bean while the presentation would be managed by JSF Page.

### JSF Page
It is a HTML page which could use HTTP Tag Libraray provided by JSF. It is responsible for managed the Presentation in JSF and interact with Managed Bean.

### Managed Beans
Managed Bean is regular Java Bean registered in JSF. It handle business logic and interact with JSF Page and different component such as database. There are different scope for managed bean in JSF Context. The default scope is **request**.

* Request
* None
* View
* Session
* Application
* Custom

## Implementations of JSF
JavaServer Face (JSF) is specification. It requires different vendors to do implementation. The below is the examples of JSF Implementation.
* Mojarra
* Apache MyFaces

### JSF Ajax Framework
* ICEfaces
* JBoss RickFaces
* PrimeFaces

# Reference
* https://techofficejava.wordpress.com/j2ee-java-server-face-jsf/

