package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.Visitor;

/**
 * DAO interface for {@link Visitor}.
 */
public interface VisitorDao extends GenericDao<Long, Visitor> {

    /**
     * Finds {@link Visitor} by email address.
     * @param emailAddress String email address
     *
     * @return {@link Visitor} in case visitor with given email is found
     * @throws GenericDaoException
     *             Indicates that entity cannot be fetched.
     */
    Visitor findByEmailAddress(String emailAddress) throws GenericDaoException;

}