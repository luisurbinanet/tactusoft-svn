package co.com.tactusoft.dialer.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tactusoft.dialer.dao.IDao;
import co.com.tactusoft.dialer.dao.entities.Agent;
import co.com.tactusoft.dialer.dao.entities.AstTrunkDialpatterns;
import co.com.tactusoft.dialer.dao.entities.CatTipoLlamada;

@Service
public class ServicesBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IDao<?> dao;

	public List<CatTipoLlamada> getListCatTipoLlamada() {
		return dao.getListCatTipoLlamada();
	}

	public List<Agent> getListAgent() {
		return dao.getListAgent();
	}

	public List<AstTrunkDialpatterns> getListRegularExpression() {
		return dao.getListRegularExpression();
	}

}
