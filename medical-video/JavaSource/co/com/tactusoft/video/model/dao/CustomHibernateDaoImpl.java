package co.com.tactusoft.video.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomHibernateDaoImpl extends HibernateDaoSupport implements
		CustomHibernateDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public CustomHibernateDaoImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Transactional
	public void persist(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	public void persist(Object[] entities) {
		for (int i = 0; i < entities.length; i++) {
			persist(entities[i]);
		}
	}

	@Transactional(readOnly = true)
	public <T> List<T> find(Class<T> entityClass) {
		final List<T> entities = getHibernateTemplate().loadAll(entityClass);
		return entities;
	}

	@Transactional(readOnly = true)
	public <T> T load(Class<T> entityClass, Serializable id) {
		final T entity = (T) getHibernateTemplate().load(entityClass, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> find(String hql) {
		final List<T> entities = getHibernateTemplate().find(hql);
		return entities;
	}

	@Override
	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	@Transactional(readOnly = false)
	public int executeHQL(final String hql) {
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}

	public BigDecimal getId(String clasz) {
		BigDecimal id = null;
		try {
			Session session = getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			id = (BigDecimal) session.createQuery(
					"select MAX(o.id) from " + clasz + " o").uniqueResult();
			if (id != null) {
				id = new BigDecimal(id.intValue() + 1);
			} else {
				id = new BigDecimal(1);
			}
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return id;

	}

}