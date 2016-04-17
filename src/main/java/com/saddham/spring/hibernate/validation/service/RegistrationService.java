package com.saddham.spring.hibernate.validation.service;

import com.saddham.spring.hibernate.validation.domain.Employee;
import com.saddham.spring.hibernate.validation.domain.InsertChecks;
import com.saddham.spring.hibernate.validation.domain.UpdateChecks;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by saddhamp on 14/3/16.
 */
@Service
@Validated
public class RegistrationService extends RegistractionServiceBase{

    @Validated(value = {UpdateChecks.class})
    public void update(@NotNull(groups = {UpdateChecks.class}) @Valid Employee employee){
    }
}
