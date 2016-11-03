# Exception Example

## Prerequisite
* Maven 3

## Exception
Exception is an event that interrupts the normal flow of a program. You can have your own Exception class in order to identify your exception in your application. 
It would be either checked or unchecked exception. Checked exception is required to declare in the method while unchecked exception does not. 

### Checked Exception
```
public class ExceptionExample{
    public void method1() throws Exception{
        throw new Exception("Method1");
    }
    
    public void method2(){
        try{
            method1();    
        }catch(Exception e){
            System.out.println("Exception Occurs");
        }
    }
    
    public static void main(String[] args){
        ExceptionExample example = new ExceptionExample();
        example.method2();
    }
    
}
```

### Unchecked Exception
RuntimeException is a kind of UncheckedExpceion.
```
public class RuntimeExceptionExample{

    public void method1(){
        throw new RuntimeException("test");
    }
    
    public void method2(){
        try{
            method1();
        }catch(Exception e){
            System.out.println("Exception Occurs");
        }
    }
    
    public static void main(String []args){
        System.out.println("Hello World");
        RuntimeExceptionExample example = new RuntimeExceptionExample();
        example.method2();
    }
}

```

## Example
In this example, there is a SimpleException which extends Exception in order to identify this exception is thrown from this Example.
Example program would do something and catch an exception in runtime and Actions after the point that throws exception would not be done.
Then the example program would do the task as specified in the exception block.

