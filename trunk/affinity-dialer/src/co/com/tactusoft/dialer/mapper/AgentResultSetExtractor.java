package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import co.com.tactusoft.dialer.dao.entities.Agent;

public class AgentResultSetExtractor implements ResultSetExtractor<Agent> {

	@Override
	public Agent extractData(ResultSet rs) throws SQLException {
		Agent object = new Agent();
		object.setAgent(rs.getInt("agent"));
		object.setReadyForCall(rs.getInt("ready_for_call"));
		return object;
	}
}
