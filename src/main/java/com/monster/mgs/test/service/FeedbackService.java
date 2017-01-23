package com.monster.mgs.test.service;

import com.monster.mgs.test.dao.GenericDaoException;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;

/**
 * Feedback service - feedback related operations.
 */
public interface FeedbackService {

    /**
     * Methods stores feedback record. Creates a new visitor if not found by email otherwise the visitor is updated.
     * 
     * @param visitor visitor data
     * @param feedback feedback data
     * @return id of new feedback record
     * @throws GenericDaoException if feedback could not be stored
     */
    Long storeFeedback(Visitor visitor, TrainingCourseFeedback feedback);
}
