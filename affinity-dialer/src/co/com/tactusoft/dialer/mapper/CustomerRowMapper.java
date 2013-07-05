package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.tactusoft.dialer.dao.entities.TblCallOutBoundExt;

public class CustomerRowMapper implements RowMapper<TblCallOutBoundExt> {

	@Override
	public TblCallOutBoundExt mapRow(ResultSet rs, int line) throws SQLException {
		CustomerResultSetExtractor extractor = new CustomerResultSetExtractor();
		return extractor.extractData(rs);
	}

}
