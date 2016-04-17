package com.saddham.spring.hibernate.validation.service;

import com.saddham.spring.hibernate.validation.domain.Employee;
import com.saddham.spring.hibernate.validation.domain.InsertChecks;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by saddhamp on 4/4/16.
 */
public interface ServiceBase {

    public void insert(@NotNull(groups = {InsertChecks.class}) @Valid Employee employee);
}
