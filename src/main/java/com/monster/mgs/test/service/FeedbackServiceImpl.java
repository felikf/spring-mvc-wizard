package com.monster.mgs.test.service;

import com.monster.mgs.test.dao.TrainingCourseFeedbackDao;
import com.monster.mgs.test.dao.VisitorDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @see FeedbackService
 */
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private VisitorDao visitorDao;

    @Autowired
    private TrainingCourseFeedbackDao feedbackDao;

    @Override
    @Transactional
    public Long storeFeedback(Visitor visitor, TrainingCourseFeedback feedback) {
        Validate.notNull(visitor);
        Validate.notNull(feedback);
        Validate.notNull(feedback.getTrainingCourse());
        Validate.notNull(feedback.getFavoriteSection());

        Visitor found = visitorDao.findByEmailAddress(visitor.getEmailAddress());

        //if found then update
        if (found != null) {
            visitor.setId(found.getId());
            visitor = visitorDao.merge(visitor);
        } else { //else create a new visitor
            Long visitorId = visitorDao.save(visitor);
            visitor = visitorDao.get(visitorId);
        }

        feedback.setVisitor(visitor);

        feedback.setDate(new Date());

        return feedbackDao.save(feedback);
    }

}