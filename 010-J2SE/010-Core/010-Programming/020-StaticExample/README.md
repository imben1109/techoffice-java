# Static Example
## Static
Static mean it belong to Class rather than an instance. 
It can be
* static block 
* static method
* static field
* static nested class
## Static Block
It is the statement which would be executed when Java Virtual Machine load the classes.
By default, Java would not load a class which it do not call. It just load the class definition by class loader.
Therefore, the static block is required to force to trigger by some tricks.
For example, using Class.forName("") force VM to load the specified class.  
