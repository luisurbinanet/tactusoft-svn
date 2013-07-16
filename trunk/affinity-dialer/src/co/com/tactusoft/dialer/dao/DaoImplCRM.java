package co.com.tactusoft.dialer.dao;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.tactusoft.dialer.dao.entities.TblCallOutBoundExt;
import co.com.tactusoft.dialer.mapper.CustomerRowMapper;

@Component("iDaoCRM")
public class DaoImplCRM<T extends Serializable> implements IDaoCRM<T> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(@Qualifier("dataSourceCRM") DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	@Transactional
	public List<TblCallOutBoundExt> getListCustomers(String id, String status) {
		return jdbcTemplate
				.query("SELECT id_CallOutBoundExt, id_UsuarioWeb, st_Nombre, st_Telefono, st_TelefonoMovil, id_Call, dt_Fecha "
						+ "FROM tbl_CallOutBoundExt WHERE id_Call IN ("
						+ status
						+ ") AND (DATEDIFF(dd, GETDATE(), dt_Fecha) = 0) AND id_CallOutBoundExt > ? ORDER BY id_CallOutBoundExt",
						new Object[] { id }, new CustomerRowMapper());
	}

	@Override
	public void updateCustomer(Long idCallOutBoundExt, Integer idCall) {
		jdbcTemplate
				.update("UPDATE tbl_CallOutBoundExt SET id_Call = ? WHERE id_CallOutBoundExt = ?",
						new Object[] { idCall, idCallOutBoundExt });

	}

}
