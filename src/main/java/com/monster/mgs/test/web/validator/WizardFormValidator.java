package com.monster.mgs.test.web.validator;


import com.monster.mgs.test.web.WizardForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Custom validator for {@link WizardForm}.
 */
public class WizardFormValidator implements Validator {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class clazz) {
        //just validate the User instances
        return WizardForm.class.isAssignableFrom(clazz);
    }

    //validate page 1
    public void validatePage1Form(WizardForm wizardForm, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","required.firstName", "Field is required.");
        validateLength(wizardForm.getFirstName(), 30, "firstName", "maxLength", errors);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName","required.lastName", "Field is required.");
        validateLength(wizardForm.getLastName(), 30, "lastName", "maxLength", errors);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress","required.emailAddress", "Field is required.");
        validateEmail(wizardForm.getEmailAddress(), "emailAddress", "valid.emailAddress", errors);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingCourseDate","required.trainingCourseDate", "Field is required.");
        validateDate(wizardForm.getTrainingCourseDate(), "trainingCourseDate", "valid.trainingCourseDate", errors);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingCourseId","required.trainingCourseId", "Field is required.");
    }

    //validate page 2
    public void validatePage2Form(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rating","required.rating", "Field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingCourseId","required.trainingCourseId", "Field is required.");
    }

     @Override
    public void validate(Object target, Errors errors) {
        validatePage1Form((WizardForm) target, errors);
        validatePage2Form(target, errors);
    }


    private void validateLength(String value, int maxLength, String fieldName, String errorCode, Errors errors) {
        if (value != null  &&  value.length() > maxLength) {
            errors.rejectValue(fieldName, "errorCode", new Object[]{"'" + fieldName + "'"}, "Value exceeded " + maxLength +" characters.");
        }
    }

    private void validateEmail(String value, String fieldName, String errorCode, Errors errors) {
        if (value != null) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(value);

            if (!matcher.matches()) {
                errors.rejectValue(fieldName, "errorCode", new Object[]{"'id'"}, "Value should be valid email address.");
            }

        }
    }

    private void validateDate(String value, String fieldName, String errorCode, Errors errors) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (value != null) {
            try {
                format.parse(value);
            } catch (ParseException e) {
                errors.rejectValue(fieldName, "errorCode", new Object[]{"'id'"}, "Value should be date dd/MM/yyyy.");
            }

        }

    }
}