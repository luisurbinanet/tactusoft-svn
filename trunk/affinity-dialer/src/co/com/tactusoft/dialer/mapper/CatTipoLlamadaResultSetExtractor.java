package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import co.com.tactusoft.dialer.dao.entities.CatTipoLlamada;

public class CatTipoLlamadaResultSetExtractor implements ResultSetExtractor<CatTipoLlamada> {

	  @Override
	  public CatTipoLlamada extractData(ResultSet rs) throws SQLException {
		  CatTipoLlamada object = new CatTipoLlamada();
	    object.setIdTipoLlamada(rs.getLong("id_TipoLlamada"));
	    object.setTipoLlamada(rs.getString("tipo_llamada"));
	    return object;
	  }
}
