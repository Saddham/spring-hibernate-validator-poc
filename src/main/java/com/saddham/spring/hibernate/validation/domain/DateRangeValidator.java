package com.saddham.spring.hibernate.validation.domain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * Created by saddhamp on 12/3/16.
 */
public class DateRangeValidator implements ConstraintValidator<ValidDateRage, Object> {
    private String startDateAccessor;
    private String endDateAccessor;
    //private static final String accessorPrefix = "get";

    @Override
    public void initialize(ValidDateRage validDateRage) {
        startDateAccessor = validDateRage.startDateAccessor();
        endDateAccessor = validDateRage.endDateAccessor();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if(object == null)
            return true;

        Method accessorMethod;
        Calendar startDate = null;
        Calendar endDate = null;
        try {
            accessorMethod = object.getClass().getMethod(startDateAccessor);
            startDate = (Calendar) accessorMethod.invoke(object);
            accessorMethod = object.getClass().getMethod(endDateAccessor);
            endDate = (Calendar) accessorMethod.invoke(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if (startDate == null || endDate == null){
            return true;
        }

        return (endDate.compareTo(startDate) >= 0);
    }


/*    private String getAccessor(String fieldName){
        StringBuilder sb = new StringBuilder(accessorPrefix);
        sb.append(capitalizeFirstLetter(fieldName));

        return sb.toString();
    }

    private String capitalizeFirstLetter(String word){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(word.charAt(0)));
        sb.append(word.substring(1));

        return sb.toString();
    }*/

}
