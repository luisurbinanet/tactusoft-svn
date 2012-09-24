package co.com.tactusoft.crm.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomHibernateDaoImpl implements CustomHibernateDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Resource
	private SessionFactory sessionFactory;

	public CustomHibernateDaoImpl() {

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Integer persist(Object entity) {
		int result = 0;
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(entity);
			getSessionFactory().getCurrentSession().flush();
		} catch (ConstraintViolationException ex) {
			result = -1;
		} catch (DataIntegrityViolationException ex) {
			result = -2;
		}
		return result;
	}

	@Transactional
	public void persist(Object[] entities) {
		for (int i = 0; i < entities.length; i++) {
			persist(entities[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> T load(Class<T> entityClass, Serializable id) {
		final T entity = (T) getSessionFactory().getCurrentSession().load(
				entityClass, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> find(String hql) {
		final List<T> entities = getSessionFactory().getCurrentSession()
				.createQuery(hql).list();
		return entities;
	}

	@Override
	public int delete(Object entity) {
		int result = 0;
		try {
			getSessionFactory().getCurrentSession().delete(entity);
		} catch (Exception ex) {
			result = -1;
		}
		return result;
	}

	@Transactional(readOnly = false)
	public int executeHQL(final String hql) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}

	@Transactional(readOnly = true)
	public <T> BigDecimal getId(Class<T> clasz) {
		BigDecimal id = null;
		try {
			id = (BigDecimal) this.find(
					"select MAX(o.id) from " + clasz.getName() + " o").get(0);
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

}