package com.ittechoffice.example.exceptionexample;

public class RuntimeExceptionExample {
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
