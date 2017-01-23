package com.monster.mgs.test.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
public class DateValidator implements ConstraintValidator<DateCheck, String> {

    @Override
    public void initialize(DateCheck paramA) {
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext ctx) {
        if(date == null){
            return false;
        }
        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(date);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}