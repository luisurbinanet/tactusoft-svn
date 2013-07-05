package co.com.tactusoft.dialer.dao;

import java.util.List;

import javax.sql.DataSource;

import co.com.tactusoft.dialer.dao.entities.Agent;
import co.com.tactusoft.dialer.dao.entities.AstTrunkDialpatterns;
import co.com.tactusoft.dialer.dao.entities.CatTipoLlamada;

public interface IDao<T> {
	
	void setDataSource(DataSource dataSource);
	List<CatTipoLlamada> getListCatTipoLlamada();
	List<Agent> getListAgent();
	List<AstTrunkDialpatterns> getListRegularExpression();

}
