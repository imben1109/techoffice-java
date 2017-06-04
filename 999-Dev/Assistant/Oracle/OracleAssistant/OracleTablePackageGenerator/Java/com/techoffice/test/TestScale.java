
package com.techoffice.test;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class TestScale {

    @Id
    @NotNull
    private double id;

    public double getId() {
        return id;
    }

    public double setId(double id) {
        this.id = id;
    }

}
