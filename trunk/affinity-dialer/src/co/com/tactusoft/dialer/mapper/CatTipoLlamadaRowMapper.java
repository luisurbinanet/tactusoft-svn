package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.tactusoft.dialer.dao.entities.CatTipoLlamada;

public class CatTipoLlamadaRowMapper implements RowMapper<CatTipoLlamada> {

	@Override
	public CatTipoLlamada mapRow(ResultSet rs, int line) throws SQLException {
		CatTipoLlamadaResultSetExtractor extractor = new CatTipoLlamadaResultSetExtractor();
		return extractor.extractData(rs);
	}

}
