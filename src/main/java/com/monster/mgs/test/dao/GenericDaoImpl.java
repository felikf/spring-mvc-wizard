package com.monster.mgs.test.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Generic DAO implementation for interface {@link GenericDao}
 */

public abstract class GenericDaoImpl<K extends Serializable, E> implements GenericDao<K, E> {

    @Autowired
    SessionFactory sessionFactory;

    protected Class entityType;

    public GenericDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType genericSuperclass = (ParameterizedType) type;
        entityType = (Class) genericSuperclass.getActualTypeArguments()[1];
    }

    protected Session getSession() throws GenericDaoException {
        if (this.sessionFactory.getCurrentSession() == null)
            throw new GenericDaoException("Session has not been set on DAO before usage");
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public E get(K key) throws GenericDaoException {
        try {
            return (E) getSession().get(entityType, key);
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    public E get(Class<? extends E> clazz, K key) throws GenericDaoException {
        try {
            return (E) getSession().get(clazz, key);
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    public void delete(E entity) throws GenericDaoException {
        try {
            getSession().delete(entity);
            getSession().flush();
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    public K save(E entity) throws GenericDaoException {
        Session session = getSession();
        try {
            return (K) session.save(entity);
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    public void update(E entity) throws GenericDaoException {
        try {
            getSession().update(entity);
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    public E merge(E entity) throws GenericDaoException {
        try {
            return (E) getSession().merge(entity);
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    public void delete(K key) throws GenericDaoException {
        try {
            E entity = get(key);
            getSession().delete(entity);
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    public void flush() throws GenericDaoException {
        try {
            getSession().flush();
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    @Transactional
    public List<E> findAll() throws GenericDaoException {
        try {
            String hqlQuery = "SELECT e FROM " + entityType.getName() + " e";
            Query query = getSession().createQuery(hqlQuery);
            return query.list();
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

    @Override
    @Transactional
    public List<E> findAllOrderByName() throws GenericDaoException {
        try {
            String hqlQuery = "SELECT e FROM " + entityType.getName() + " e ORDER BY name";
            Query query = getSession().createQuery(hqlQuery);
            return query.list();
        } catch (HibernateException he) {
            throw new GenericDaoException(he);
        }
    }

}