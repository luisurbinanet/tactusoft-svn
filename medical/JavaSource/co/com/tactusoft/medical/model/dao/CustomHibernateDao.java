package co.com.tactusoft.medical.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface CustomHibernateDao {

	public void persist(Object entity);
	
	public void delete(Object entity);

	public void persist(Object[] entities);

	public <T> List<T> find(Class<T> entityClass);

	public <T> T load(Class<T> entityClass, Serializable id);

	public <T> List<T> find(String hql);
	
	public BigDecimal getId(String clasz);

}