package com.ittechoffice.example.exceptionexample;

public class ExceptionExample {
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
