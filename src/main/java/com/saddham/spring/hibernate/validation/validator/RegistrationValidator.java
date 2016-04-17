package com.saddham.spring.hibernate.validation.validator;

import com.saddham.spring.hibernate.validation.domain.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {
    @Override
    public boolean supports(Class<?> c) {
        return Employee.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object command, Errors errors) {
        /*Employee regBean = (Employee) command;
        if(regBean.getStartDate().compareTo(regBean.getEndDate())>0)
            errors.rejectValue("rePassword", "End date less than start date");*/
    }

}

