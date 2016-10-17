# ITTechoffice Example Assistant Project

## Functionality
* Maven Project Support
* Eclipse Project Support
* READNE Support
* NPM Project Support
* Bower Project Support

### Maven Project Support
* Git does commit empty folder while folder structure of maven project contain empty project. It make git support for maven project by add .gitkeey file to main/resources, test/java and test/resources folders.
* Files in targets are generated after maven build and it should ignore when git commit.  
* Maven Project contains pom.xml which has specifies the project name. Maven Project Name should be consistent with the project folder name.
	
### Eclipse Project Support
* Eclipse Project contains .project file storing meta data of the project. It would specifies the project name. Eclipse Project Name should be consistent with the project folder name.
	
### READNE Support
* For each Maven Project, it would contain its own README.md file. The file should follow specified format.

### NPM Project Support
* NPM is a package manager for NodeJs.
* NPM Project has a package.json file storing dependency of the project. 
* The dependency would be stored in node_modules folder which should be ignored.

### Bower Project Support
* Bower is a package manager for the web.
* The project has a bower.json storing dependency of the project.
* The dependency would be stored in bower_components folder which should be ignored.