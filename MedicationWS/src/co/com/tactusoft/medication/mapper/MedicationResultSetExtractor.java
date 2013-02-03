package co.com.tactusoft.medication.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import co.com.tactusoft.medication.dao.entities.Medication;

public class MedicationResultSetExtractor implements ResultSetExtractor<Medication> {

	  @Override
	  public Medication extractData(ResultSet rs) throws SQLException {
	    Medication object = new Medication();
	    object.setIdClienteCrm(rs.getString(1));
	    object.setIdReceta(rs.getString(2));
	    object.setIdMedico(rs.getString(3));
	    object.setIdProductoCrm(rs.getString(4));
	    object.setIdMaterialSAP(rs.getString(5));
	    object.setCantidad(rs.getString(6));
	    return object;
	  }
}
