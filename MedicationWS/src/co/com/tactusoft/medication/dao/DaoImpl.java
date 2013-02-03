package co.com.tactusoft.medication.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.tactusoft.medication.dao.entities.Medication;
import co.com.tactusoft.medication.mapper.MedicationRowMapper;

@Repository
public class DaoImpl implements IDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public List<Medication> getListMedication(String doc) {
		return jdbcTemplate
				.query("SELECT A.id_UsuarioWeb as Id_cliente_crm "
						+ ",A.id_Receta "
						+ ",A.id_Medico "
						+ ",A.id_TipoProducto as id_producto_crm "
						+ ",C.st_SAP as id_material_SAP "
						+ ",a.i_Cantidad "
						+ "FROM erpafinity.fernandoruiz.tbl_RecetaProductosUsuarioWeb A "
						+ ", [erpafinity].[fernandoruiz].[tbl_UsuariosWebCac] B "
						+ ", [erpafinity].[dbo].[cat_TipoProducto] C "
						+ "where B.id_UsuarioWeb = A.id_UsuarioWeb "
						+ "and A.id_TipoProducto = C.id_TipoProducto "
						+ "and B.st_Documento = ? "
						+ "and A.dt_FechaRegistro between GETDATE() - 1 and GETDATE() + 1",
						new Object[] { doc }, new MedicationRowMapper());
	}

}
