package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.Visitor;
import org.apache.commons.lang.Validate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see VisitorDao
 */
public class VisitorDaoImpl extends GenericDaoImpl<Long, Visitor> implements VisitorDao {

    @Override
    @Transactional
    public Visitor findByEmailAddress(String emailAddress) throws GenericDaoException {
        Validate.notNull(emailAddress);

        try {
            String hqlQuery = "SELECT e FROM " + entityType.getName() + " e WHERE e.emailAddress = :emailAddress";
            Query query = getSession()
                    .createQuery(hqlQuery)
                    .setParameter("emailAddress", emailAddress);
            return (Visitor) query.uniqueResult();
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

}
