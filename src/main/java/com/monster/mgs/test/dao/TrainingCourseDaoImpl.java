package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.Visitor;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Transactional
public class TrainingCourseDaoImpl extends GenericDaoImpl<Long, TrainingCourse> implements TrainingCourseDao {

}
