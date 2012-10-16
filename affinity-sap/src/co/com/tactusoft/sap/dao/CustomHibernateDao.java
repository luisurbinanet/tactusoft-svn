package co.com.tactusoft.sap.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface CustomHibernateDao {

	public Integer persist(Object entity);
	
	public int delete(Object entity);

	public void persist(Object[] entities);
	
	public <T> T load(Class<T> entityClass, Serializable id);

	public <T> List<T> find(String hql);
	
	public <T> List<T> findNative(String sql, Class<T> clasz);
	
	public <T> BigDecimal getId(Class<T> clasz);
	
	public int executeHQL(final String hql);

}