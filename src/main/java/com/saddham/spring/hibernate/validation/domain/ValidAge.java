package com.saddham.spring.hibernate.validation.domain;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

/**
 * Created by saddhamp on 9/3/16.
 */

@Digits(
        integer = 3,
        fraction = 0,
        groups = {InsertChecks.class}
)
@Min(
        value = 18L,
        groups = {InsertChecks.class}
)
@Max(
        value = 60L,
        groups = {InsertChecks.class}
)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
@ReportAsSingleViolation
public @interface ValidAge {
    String message() default "{com.wavemaker.invalid.age.message}";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
