package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseSection;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 */
@Transactional
public class TrainingCourseSectionDaoImpl extends GenericDaoImpl<Long, TrainingCourseSection> implements TrainingCourseSectionDao {

    @Override
    @Transactional
    public List<TrainingCourseSection> findAllForCourse(Long trainingCourseId) throws GenericDaoException {
        try {
            String hqlQuery = "SELECT e FROM " + entityType.getName() + " e WHERE e.trainingCourseId = :trainingCourseId ORDER BY name";
            Query query = getSession()
                    .createQuery(hqlQuery)
                    .setParameter("trainingCourseId", trainingCourseId);
            return query.list();
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

}
