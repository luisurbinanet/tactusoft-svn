package co.com.tactusoft.crm.model.dao.sap;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import co.com.tactusoft.crm.util.Parameter;

public interface SapCustomHibernateDao {

	public Integer persist(Object entity);
	
	public int delete(Object entity);

	public void persist(Object[] entities);
	
	public <T> T load(Class<T> entityClass, Serializable id);

	public <T> List<T> find(String hql);
	
	public <T> List<T> find(String hql, int maxResults);
	
	public <T> List<T> findNative(String sql, Class<T> clasz);
	
	public <T> List<T> findNamedQuery(String sql, List<Parameter> listParameter);
	
	public <T> BigDecimal getId(Class<T> clasz);
	
	public int executeHQL(final String hql);
	
	public <T> List<T> executeProcedure(String name, List<Parameter> parameters);

}