package com.saddham.spring.hibernate.validation.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Calendar;

/**
 * Created by saddhamp on 8/3/16.
 */
@ValidDateRage(
        startDateAccessor = "getStartDate",
        endDateAccessor = "getEndDate",
        message = "{com.wavemaker.invalid.date.range.message}",
        groups = {InsertChecks.class}
)
public class Employee extends Human {
    private Integer id;

    private Integer age;

    private String emailID;

    private Calendar startDate;

    private Calendar  endDate;

    private Double experience;

    public Employee() {
    }

    @NotNull(
            groups = {InsertChecks.class}
    )
    @Email(
            message = "{com.wavemaker.invalid.emailid.message}",
            groups = {InsertChecks.class}
    )
    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    @NotNull(
            groups = {InsertChecks.class}
    )
    @ValidAge(
            message = "{com.wavemaker.invalid.age.message}",
            groups = {InsertChecks.class}
    )
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull(
            message = "Employee id cannot be empty",
            groups = UpdateChecks.class
    )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull(
            groups = {InsertChecks.class}
    )
    @FutureDate(
            groups = {InsertChecks.class}
    )
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    @NotNull(
            groups = {InsertChecks.class}
    )
    @FutureDate(
            groups = {InsertChecks.class}
    )
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    @NotNull(
            groups = {InsertChecks.class}
    )
    @Digits(
            integer = 3,
            fraction = 2,
            message = "{com.wavemaker.invalid.number.message}",
            groups = {InsertChecks.class}
    )
    @Min(
            value = 10,
            message = "{com.wavemaker.invalid.manager.message}",
            groups = {InsertChecks.class}
    )
    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

/*    @AssertTrue(
            message = "{com.wavemaker.invalid.date.range.message}",
            groups = {InsertChecks.class, UpdateChecks.class}
    )
    public boolean isValidRange() {
        if (startDate == null && endDate == null){
            return true;
        } else if (startDate == null || endDate == null){
            return false;
        }

        return (endDate.compareTo(startDate) >= 0);
    }*/
}
