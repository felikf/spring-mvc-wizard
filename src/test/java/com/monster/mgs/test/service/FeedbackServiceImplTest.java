package com.monster.mgs.test.service;

import com.monster.mgs.test.dao.TrainingCourseDao;
import com.monster.mgs.test.dao.TrainingCourseFeedbackDao;
import com.monster.mgs.test.dao.TrainingCourseSectionDao;
import com.monster.mgs.test.dao.VisitorDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Integration test of {@link FeedbackService}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
@Transactional
public class FeedbackServiceImplTest {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private TrainingCourseFeedbackDao feedbackDao;

    @Autowired
    private VisitorDao visitorDao;

    @Autowired
    private TrainingCourseDao trainingCourseDao;

    @Autowired
    private TrainingCourseSectionDao trainingCourseSectionDao;

    @Test
    public void storeFeedbackTest() {
        List<TrainingCourseFeedback> feedbacks = feedbackDao.findAll();
        assertEquals(0, feedbacks.size());

        List<Visitor> visitors = visitorDao.findAll();
        assertEquals(0, visitors.size());

        //1. create first
        feedbackService.storeFeedback(createVisitor("barak@obama.com"), createFeedback());

        feedbacks = feedbackDao.findAll();
        assertEquals(1, feedbacks.size());

        visitors = visitorDao.findAll();
        assertEquals(1, visitors.size());

        //2. same email - update user; add feedback
        feedbackService.storeFeedback(createVisitor("barak@obama.com"), createFeedback());

        feedbacks = feedbackDao.findAll();
        assertEquals(2, feedbacks.size());

        visitors = visitorDao.findAll();
        assertEquals(1, visitors.size());

        //2. different email - add user; add feedback
        feedbackService.storeFeedback(createVisitor("milos@zeman.com"), createFeedback());

        feedbacks = feedbackDao.findAll();
        assertEquals(3, feedbacks.size());

        visitors = visitorDao.findAll();
        assertEquals(2, visitors.size());
    }

    private TrainingCourseFeedback createFeedback() {
        TrainingCourseFeedback feedback = new TrainingCourseFeedback();

        feedback.setDate(new Date());
        feedback.setRating(5);
        feedback.setComment("Quite good.");
        feedback.setTrainingCourse(trainingCourseDao.findAll().stream().findFirst().get());
        feedback.setFavoriteSection(trainingCourseSectionDao.findAll().stream().findFirst().get());

        return feedback;
    }

    private Visitor createVisitor(String email) {
        Visitor visitor = new Visitor();
        visitor.setFirstName("Barak");
        visitor.setLastName("Obama");
        visitor.setEmailAddress(email);
        return visitor;
    }

}