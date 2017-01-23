package com.monster.mgs.test.web;

import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.TrainingCourseSection;
import com.monster.mgs.test.model.Visitor;

import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Wizard form - contains user input and available database categories.
 */
public class WizardForm {
    public static final String WIZARD_FORM_NAME = "wizardForm";

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String trainingCourseDate;
    private Long trainingCourseId;
    private Long trainingCourseSectionId;
    private Integer rating;
    private String comments;
    private String stepTypeBack;
    private String stepTypeForward;

    List<TrainingCourse> availableTrainingCourses;
    List<TrainingCourseSection> availableTrainingCourseSections;

    public TrainingCourse getTrainingCourse() {
        if (trainingCourseId == null  ||  availableTrainingCourses == null) {
            return null;
        }

        return availableTrainingCourses.stream()
                .filter(c -> c.getId().equals(trainingCourseId))
                .findFirst()
                .get();
    }

    public TrainingCourseSection getTrainingCourseSection() {
        if (trainingCourseSectionId == null  ||  availableTrainingCourseSections == null) {
            return null;
        }

        return availableTrainingCourseSections.stream()
                .filter(c -> c.getId().equals(trainingCourseSectionId))
                .findFirst()
                .get();
    }

    public Map<String, String> getAvailableTrainingCoursesMap() {
        return this.availableTrainingCourses
                .stream()
                .collect(Collectors.toMap(i -> i.getId().toString(), TrainingCourse::getName));
    }

    public void setAvailableTrainingCourses(List<TrainingCourse> availableTrainingCourses) {
        this.availableTrainingCourses = availableTrainingCourses;
    }

    public Map<String, String> getAvailableTrainingCourseSectionsMap() {
        return this.availableTrainingCourseSections
                .stream()
                .collect(Collectors.toMap(i -> i.getId().toString(), TrainingCourseSection::getName));
    }

    public void setAvailableTrainingCourseSections(List<TrainingCourseSection> availableTrainingCourseSections) {
        this.availableTrainingCourseSections = availableTrainingCourseSections;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getTrainingCourseId() {
        return trainingCourseId;
    }

    public void setTrainingCourseId(Long trainingCourseId) {
        this.trainingCourseId = trainingCourseId;
    }

    public String getTrainingCourseDate() {
        return trainingCourseDate;
    }

    public void setTrainingCourseDate(String trainingCourseDate) {
        this.trainingCourseDate = trainingCourseDate;
    }

    public Long getTrainingCourseSectionId() {
        return trainingCourseSectionId;
    }

    public void setTrainingCourseSectionId(Long trainingCourseSectionId) {
        this.trainingCourseSectionId = trainingCourseSectionId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Visitor createVisitor() {
        Visitor visitor = new Visitor();

        visitor.setFirstName(getFirstName());
        visitor.setLastName(getLastName());
        visitor.setEmailAddress(getEmailAddress());

        return visitor;
    }

    public TrainingCourseFeedback createFeedback() {
        TrainingCourseFeedback feedback = new TrainingCourseFeedback();
        feedback.setComment(getComments());
        feedback.setRating(getRating());
//        feedback.setDate(getTrainingCourseDate());  //TODO
        feedback.setTrainingCourse(getTrainingCourse());
        feedback.setFavoriteSection(getTrainingCourseSection());

        return feedback;
    }

    public String getStepTypeBack() {
        return stepTypeBack;
    }

    public void setStepTypeBack(String stepTypeBack) {
        this.stepTypeBack = stepTypeBack;
    }

    public String getStepTypeForward() {
        return stepTypeForward;
    }

    public void setStepTypeForward(String stepTypeForward) {
        this.stepTypeForward = stepTypeForward;
    }
}