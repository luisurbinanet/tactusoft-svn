package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import co.com.tactusoft.dialer.dao.entities.AstTrunkDialpatterns;

public class AstTrunkDialpatternsResultSetExtractor implements
		ResultSetExtractor<AstTrunkDialpatterns> {

	@Override
	public AstTrunkDialpatterns extractData(ResultSet rs) throws SQLException {
		AstTrunkDialpatterns object = new AstTrunkDialpatterns();
		object.setTrunkid(rs.getInt("trunkid"));
		object.setExpressionRegular(rs.getString("expression_regular"));
		object.setCallNumber(rs.getString("call_number"));
		object.setPrefix(rs.getInt("prefix"));
		return object;
	}
}
