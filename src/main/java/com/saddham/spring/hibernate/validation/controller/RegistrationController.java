package com.saddham.spring.hibernate.validation.controller;

import com.saddham.spring.hibernate.validation.domain.Employee;
import com.saddham.spring.hibernate.validation.service.RegistrationService;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.Set;

@Controller
@RequestMapping(value="/")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(method=RequestMethod.GET)
    public String showForm(ModelMap model){
        Employee userRegis = new Employee();
        model.addAttribute("Employee", userRegis);
        return "registration";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="Employee") Employee userRegis, BindingResult result){
        try{
            registrationService.insert(userRegis);
        } catch (MethodConstraintViolationException mCVException){
            Set<MethodConstraintViolation<?>> constraintViolations = mCVException.getConstraintViolations();
            Iterator<MethodConstraintViolation<?>> itr = constraintViolations.iterator();
            MethodConstraintViolation<?> violation;
            while (itr.hasNext()){
                violation = itr.next();
                result.reject(violation.getMessage(), violation.getMessage());
            }

        }

        if(result.hasErrors()){
            return "registration";
        }else{
            userRegis.setId(10);
            return "update";
        }
    }
}