package com.monster.mgs.test.web;

import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseSection;
import com.monster.mgs.test.model.Visitor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests for {@link WizardForm}.
 */
public class WizardFormTest {

    @Test
    public void getTrainingCourse() throws Exception {
        WizardForm wizardForm = createWizardForm();

        wizardForm.setTrainingCourseId(1L);
        TrainingCourse trainingCourse = wizardForm.getTrainingCourse();

        Assert.assertNotNull(trainingCourse);
        Assert.assertEquals(1L, trainingCourse.getId().longValue());
        Assert.assertEquals("Java", trainingCourse.getName());
    }

    @Test
    public void getTrainingCourseSection() throws Exception {
        WizardForm wizardForm = createWizardForm();

        wizardForm.setTrainingCourseId(1L);
        wizardForm.setTrainingCourseSectionId(1L);
        TrainingCourseSection trainingCourseSection = wizardForm.getTrainingCourseSection();

        Assert.assertNotNull(trainingCourseSection);
        Assert.assertEquals(1L, trainingCourseSection.getId().longValue());
        Assert.assertEquals("Swing", trainingCourseSection.getName());

    }

    @Test
    public void getAvailableTrainingCoursesMap() throws Exception {
        WizardForm wizardForm = createWizardForm();

        Map<String, String> map = wizardForm.getAvailableTrainingCoursesMap();
        Assert.assertNotNull(map);
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void getAvailableTrainingCourseSectionsMap() throws Exception {
        WizardForm wizardForm = createWizardForm();

        Map<String, String> map = wizardForm.getAvailableTrainingCourseSectionsMap();
        Assert.assertNotNull(map);
        Assert.assertEquals(4, map.size());
    }

    @Test
    public void createFeedback() throws Exception {

    }

    private WizardForm createWizardForm() {
        WizardForm wizardForm = new WizardForm();

        wizardForm.setAvailableTrainingCourses(createAvailableTrainingCourses());
        wizardForm.setAvailableTrainingCourseSections(createAvailableTrainingCourseSections());

        return wizardForm;
    }

    private List<TrainingCourseSection> createAvailableTrainingCourseSections() {
        List<TrainingCourseSection> result = new ArrayList<>();

        result.add(new TrainingCourseSection(1L, "Swing", 1L));
        result.add(new TrainingCourseSection(2L, "Collections", 1L));

        result.add(new TrainingCourseSection(3L, "Angular", 2L));
        result.add(new TrainingCourseSection(4L, "React", 2L));

        return result;
    }

    private List<TrainingCourse> createAvailableTrainingCourses() {
        List<TrainingCourse> result = new ArrayList<>();

        result.add(new TrainingCourse(1L, "Java"));
        result.add(new TrainingCourse(2L, "JavaScript"));

        return result;
    }
}