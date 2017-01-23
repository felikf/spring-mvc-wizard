package com.monster.mgs.test.dao;

import org.springframework.transaction.annotation.Transactional;

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
     * Updates given entity.
     *
     * @param entity
     *            given entity
     * @throws GenericDaoException
     *             Indicates that entity cannot be updated.
     */
    void update(E entity) throws GenericDaoException;

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
     * Deletes given entity.
     *
     * @param entity
     *            given entity
     * @throws GenericDaoException
     *             Indicates that entity cannot be deleted.
     */
    void delete(E entity) throws GenericDaoException;

    /**
     * Deletes entity for given key.
     *
     * @param key
     *            given entity key
     * @throws GenericDaoException
     *             Indicates that entity cannot be deleted.
     */
    void delete(K key) throws GenericDaoException;

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
     * Gets entity of given class and for given key.
     *
     * @param clazz
     *            given class
     * @param key
     *            given key
     * @return Returns entity of given class and for given key.
     * @throws GenericDaoException
     *             Indicates that entity cannot be retrieved.
     */
    E get(Class<? extends E> clazz, K key) throws GenericDaoException;

    /**
     * Forces the session to flush.
     *
     * @throws GenericDaoException
     *             Indicates that entities cannot be flushed.
     */
    void flush() throws GenericDaoException;

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