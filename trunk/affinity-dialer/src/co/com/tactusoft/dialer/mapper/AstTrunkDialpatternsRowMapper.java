package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.tactusoft.dialer.dao.entities.AstTrunkDialpatterns;

public class AstTrunkDialpatternsRowMapper implements
		RowMapper<AstTrunkDialpatterns> {

	@Override
	public AstTrunkDialpatterns mapRow(ResultSet rs, int line)
			throws SQLException {
		AstTrunkDialpatternsResultSetExtractor extractor = new AstTrunkDialpatternsResultSetExtractor();
		return extractor.extractData(rs);
	}

}
