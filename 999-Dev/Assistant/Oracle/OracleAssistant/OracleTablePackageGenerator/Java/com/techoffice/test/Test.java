
package com.techoffice.test;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Test {

    @Id
    @NotNull
    private int id;
    @NotNull
    private int age;
    private String address;
    private String phone;

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public int setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String setPhone(String phone) {
        this.phone = phone;
    }

}
