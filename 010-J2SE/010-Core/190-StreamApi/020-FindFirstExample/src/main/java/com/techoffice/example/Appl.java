package com.techoffice.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Appl {

    public static void main(String[] args){
        List<TestModel1> testModel1List = new ArrayList<>();
        TestModel1 testModel11 = new TestModel1();
        TestModel1 testModel12 = new TestModel1();
        testModel12.setName("Testing");
        List<TestModel2> testModel2List = new ArrayList<>();
        TestModel2 testModel2 = new TestModel2();
        testModel2.setName("testing");
        testModel2List.add(testModel2);
        testModel12.setTestModel2List(testModel2List);
        testModel1List.add(testModel11);
        testModel1List.add(testModel12);

        long result = testModel1List.stream().filter(i -> "Testing".equals(i.getName())).count();
        System.out.println(result);
    }

}
