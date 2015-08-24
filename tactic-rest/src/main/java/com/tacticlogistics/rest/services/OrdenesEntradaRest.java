package com.tacticlogistics.rest.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tacticlogistics.model.bo.OrdenesEntradaBO;
import com.tacticlogistics.model.entities.Ciudad;
import com.tacticlogistics.model.entities.Pais;

/**
 *
 * @author csarmiento
 */
@Component
@Path("OrdenesEntrada")
public class OrdenesEntradaRest {

	@Autowired
	private OrdenesEntradaBO ordenesEntradaBO;

	@GET
	@Path("/listpaises")
	@Produces("application/json;charset=iso-8859-1")
	public List<Pais> getPaises() {
		List<Pais> list = ordenesEntradaBO.getListPaises();
		return list;
	}

	@GET
	@Path("/listciudades/{idPais}")
	@Produces("application/json;charset=iso-8859-1")
	public List<Ciudad> getCiudades(@PathParam("idPais") Integer idPais) {
		List<Ciudad> list = ordenesEntradaBO.getListCiudades(idPais);
		return list;
	}

}
