package com.monster.mgs.test.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO interface.
 */
public interface GenericDao<K extends Serializable, E> {

    /**
     * Saves given entity.
     *
     * @param entity
     *            given entity
     * @return Returns saved entity.
     * @throws GenericDaoException
     *             Indicates that entity cannot be stored.
     */
    K save(E entity) throws GenericDaoException;

    /**
     * Merges given entity.
     *
     * @param entity
     *            given entity
     * @return Returns merged entity.
     * @throws GenericDaoException
     *             Indicates that entity cannot be merged.
     */
    E merge(E entity) throws GenericDaoException;

    /**
     * Gets entity according to given key.
     *
     * @param key
     *            given entity key
     * @return Returns entity for given key.
     * @throws GenericDaoException
     *             Indicates that entity cannot be retrieved.
     */
    E get(K key) throws GenericDaoException;

    /**
     * Method returns all entities.
     *
     * @return Returns all entities sorted by name.
     * @throws GenericDaoException
     *             Indicates that entities be fetched due to a database related error.
     */
    List<E> findAll() throws GenericDaoException;

    /**
     * Method returns all entities ordered by name.
     *
     * @return Returns all entities sorted by name.
     * @throws GenericDaoException
     *             Indicates that entities be fetched due to a database related error.
     */
    List<E> findAllOrderByName() throws GenericDaoException;
}