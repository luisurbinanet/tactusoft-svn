package co.com.tactusoft.dialer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import co.com.tactusoft.dialer.dao.entities.TblCallOutBoundExt;

public class CustomerResultSetExtractor implements
		ResultSetExtractor<TblCallOutBoundExt> {

	@Override
	public TblCallOutBoundExt extractData(ResultSet rs) throws SQLException {
		TblCallOutBoundExt object = new TblCallOutBoundExt();
		object.setIdCallOutBoundExt(rs.getLong("id_CallOutBoundExt"));
		object.setIdUsuarioWeb(rs.getLong("id_UsuarioWeb"));
		object.setStNombre(rs.getString("st_Nombre"));
		object.setStTelefono(rs.getString("st_Telefono"));
		object.setStTelefonoMovil(rs.getString("st_TelefonoMovil"));
		object.setIdCall(rs.getInt("id_Call"));
		object.setDtFecha(rs.getDate("dt_Fecha"));
		return object;
	}
}
