package com.monster.mgs.test.service;

import com.monster.mgs.test.dao.GenericDaoException;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Feedback service - feedback related operations.
 */
public interface FeedbackService {

    /**
     * Methods stores feedback according. Creates a new visitor if not found by email.
     * 
     * @param visitor visitor data
     * @param feedback feedback data
     * @return id of new feedback record
     * @throws GenericDaoException if feedback could not be stored
     */
    @Transactional
    Long storeFeedback(Visitor visitor, TrainingCourseFeedback feedback);
}
