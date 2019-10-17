package com.test.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class TestModel {
    private String name;
    private String address;
    private List<TestNestedModel> dataList;
}
