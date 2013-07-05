package co.com.tactusoft.dialer.dao;

import java.util.List;

import javax.sql.DataSource;

import co.com.tactusoft.dialer.dao.entities.TblCallOutBoundExt;

public interface IDaoCRM<T> {
	
	void setDataSource(DataSource dataSource);
	List<TblCallOutBoundExt> getListCustomers();
	void updateCustomer(Long idCallOutBoundExt, Integer idCall);

}
