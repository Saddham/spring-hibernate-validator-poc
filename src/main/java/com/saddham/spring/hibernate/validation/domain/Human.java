package com.saddham.spring.hibernate.validation.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by saddhamp on 4/4/16.
 */
public class Human {
    protected String fullName;

    @NotNull(
            groups = {InsertChecks.class}
    )
    @ValidFullName(
            groups = {InsertChecks.class}
    )
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
