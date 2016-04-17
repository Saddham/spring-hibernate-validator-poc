package com.saddham.spring.hibernate.validation.controller;

import com.saddham.spring.hibernate.validation.service.RegistrationService;
import com.saddham.spring.hibernate.validation.domain.Employee;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by saddhamp on 11/3/16.
 */

@Controller
@RequestMapping(value = "/updateEmployee")
public class UpdationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(method= RequestMethod.POST)
    public String updateEmployee(@ModelAttribute(value="Employee") Employee userRegis, BindingResult result){
        try{
            registrationService.update(userRegis);
        } catch (MethodConstraintViolationException mCVException){
            Set<MethodConstraintViolation<?>> constraintViolations = mCVException.getConstraintViolations();
            Iterator<MethodConstraintViolation<?>> itr = constraintViolations.iterator();
            MethodConstraintViolation<?> violation;
            while (itr.hasNext()){
                violation = itr.next();
                System.out.println(violation.getPropertyPath());
                System.out.println(violation.getMessage());
            }

        }
        if(result.hasErrors()){
            return "update";
        }else{
            return "success";
        }
    }
}
