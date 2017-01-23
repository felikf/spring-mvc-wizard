package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseSection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO interface for {@link TrainingCourseSection}.
 */
public interface TrainingCourseSectionDao extends GenericDao<Long, TrainingCourseSection> {

    /**
     * Returns all {@link TrainingCourseSection} for given course.
     *
     * @param trainingCourseId id of course
     * @return Entities for given course.
     * @throws GenericDaoException Indicates that entities be fetched due to a database related error.
     */
    List<TrainingCourseSection> findAllForCourse(Long trainingCourseId) throws GenericDaoException;
}