package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.tactusoft.dialer.dao.entities.Agent;

public class AgentRowMapper implements RowMapper<Agent> {

	@Override
	public Agent mapRow(ResultSet rs, int line) throws SQLException {
		AgentResultSetExtractor extractor = new AgentResultSetExtractor();
		return extractor.extractData(rs);
	}

}
