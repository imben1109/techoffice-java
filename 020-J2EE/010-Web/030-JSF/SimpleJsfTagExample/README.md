# Tomcat Jsf Tag Example

## Basic Tag


## Facelets
  
**faceletFragment1.xhtml**
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets">
	<body>
		<ui:composition>
			<h1>Facelets Fragment 1</h1>
		</ui:composition>
	</body>
</html>
```

```
<ui:insert name="faceletFragment1" >
	<ui:include src="faceletFragment1.xhtml" />
</ui:insert> 
```

## Convertor

## Validator



## DataTable
 
 ```
 <h:dataTable value="#{userController.userList}" var="user" border="1">
	<h:column>
	    <f:facet name="header">User Name</f:facet>    				
		#{user.userName}
	</h:column>
	<h:column>
		<f:facet name="header">First Name</f:facet>
		#{user.firstName}
	</h:column>
	<h:column>
		<f:facet name="header">Last Name</f:facet>
		#{user.lastName}
	</h:column>
	<h:column>
		<f:facet name="header">Age</f:facet>
		#{user.age}
	</h:column>
</h:dataTable>
 ```
 
## Ajax

  ```
<h:inputText id="inputValue" value="#{ajaxController.inputTextValue}"></h:inputText>
<h:commandButton value="Execute Ajax">
	<f:ajax execute="inputValue" render="outputValue" />
</h:commandButton>
<h:outputText id="outputValue" value="#{ajaxController.ajaxRetrunValue}"/>
  ```

