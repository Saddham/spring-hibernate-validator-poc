package com.saddham.spring.hibernate.validation.domain;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by saddhamp on 12/3/16.
 */
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateRangeValidator.class})
@Documented
public @interface ValidDateRage{
    String startDateAccessor();
    String endDateAccessor();
    String message() default "{com.wavemaker.invalid.date.range.message}";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
