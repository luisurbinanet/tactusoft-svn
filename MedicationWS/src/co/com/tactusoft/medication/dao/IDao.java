package co.com.tactusoft.medication.dao;

import java.util.List;

import javax.sql.DataSource;

import co.com.tactusoft.medication.dao.entities.Medication;

public interface IDao {
	
	void setDataSource(DataSource dataSource);
	List<Medication> getListMedication(String doc);

}
