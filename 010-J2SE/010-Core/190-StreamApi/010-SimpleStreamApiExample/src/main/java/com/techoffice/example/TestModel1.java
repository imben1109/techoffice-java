package com.techoffice.example;

import lombok.Data;

import java.util.List;

@Data
public class TestModel1 {

    private String name;

    private List<TestModel2> testModel2List;

}
