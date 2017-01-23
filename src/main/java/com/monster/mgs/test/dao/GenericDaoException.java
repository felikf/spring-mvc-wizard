package com.monster.mgs.test.dao;

/**
 * Generic exception for {@link GenericDao} interface.
 */
public class GenericDaoException extends RuntimeException {

    private static final long serialVersionUID = -1836846304375266502L;

    public GenericDaoException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public GenericDaoException(String message) {
        super(message);
    }

    public GenericDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
