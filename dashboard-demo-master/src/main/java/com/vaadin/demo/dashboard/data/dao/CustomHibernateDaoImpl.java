package com.vaadin.demo.dashboard.data.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomHibernateDaoImpl implements CustomHibernateDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Resource
	private SessionFactory sessionFactory;

	public CustomHibernateDaoImpl() {

	}

	@Qualifier(value = "sessionFactory")
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	@Transactional("transactionManager")
	public void persist(Object entity) {
		getCurrentSession().saveOrUpdate(entity);
		getCurrentSession().flush();
	}

	@Transactional("transactionManager")
	public void save(Object entity) throws RuntimeException {
		getCurrentSession().saveOrUpdate(entity);
		getCurrentSession().flush();
	}

	@Transactional("transactionManager")
	public void persist(Object[] entities) {
		for (int i = 0; i < entities.length; i++) {
			persist(entities[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "transactionManager", readOnly = true)
	public <T> T load(Class<T> entityClass, Serializable id) {
		final T entity = (T) getCurrentSession().load(entityClass, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "transactionManager", readOnly = true)
	public <T> List<T> find(String hql) {
		final List<T> entities = getCurrentSession().createQuery(hql).list();
		return entities;
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "transactionManager", readOnly = true)
	public <T> List<T> find(String hql, int maxResults) {
		Query query = getCurrentSession().createQuery(hql);
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		final List<T> entities = query.list();
		return entities;
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "transactionManager", readOnly = true)
	public <T> List<T> findNative(String sql, Class<T> clasz) {
		final List<T> entities = getCurrentSession().createSQLQuery(sql).addEntity(clasz).list();
		return entities;
	}

	@Override
	@Transactional("transactionManager")
	public int delete(Object entity) {
		int result = 0;
		try {
			getCurrentSession().delete(entity);
		} catch (Exception ex) {
			result = -1;
		}
		return result;
	}

	@Transactional(value = "transactionManager", readOnly = false)
	public int executeHQL(final String hql) {
		Query query = getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}

	@Transactional(value = "transactionManager", readOnly = true)
	public <T> BigDecimal getId(Class<T> clasz) {
		BigDecimal id = null;
		try {
			id = (BigDecimal) this.find("select MAX(o.id) from " + clasz.getName() + " o").get(0);
			if (id != null) {
				id = new BigDecimal(id.intValue() + 1);
			} else {
				id = new BigDecimal(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "transactionManager", readOnly = false)
	public <T> List<T> executeProcedure(String name, List<Parameter> parameters) {
		Query query = getCurrentSession().getNamedQuery(name);
		for (Parameter row : parameters) {
			query.setParameter(row.getName(), row.getValue());
		}
		return query.list();
	}

}