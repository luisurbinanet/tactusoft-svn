package co.com.tactusoft.medication.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.tactusoft.medication.dao.entities.Medication;

public class MedicationRowMapper implements RowMapper<Medication> {

	@Override
	public Medication mapRow(ResultSet rs, int line) throws SQLException {
		MedicationResultSetExtractor extractor = new MedicationResultSetExtractor();
		return extractor.extractData(rs);
	}

}
