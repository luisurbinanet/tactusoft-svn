package com.vaadin.demo.dashboard.view.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.vaadin.demo.dashboard.data.bo.OrdenesEntradaBO;
import com.vaadin.demo.dashboard.domain.Movie;

/**
 *
 * @author casarmiento
 */
@Component
@Path("indicadorservice")
public class OrdenesEntradaRest {
	
	@Autowired
	private OrdenesEntradaBO ordenesEntradaBO;

	@GET
	@Path("/listentidades/{tipoEntidad}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String getEntidades(@PathParam("tipoEntidad") String tipoEntidad) {
		Movie movie = new Movie();
		movie.setId(1);
		movie.setPosterUrl("Prueba");
		//List<Entidad> list;
		//list = processBO.getListEntidades(tipoEntidad);
		return new Gson().toJson(movie);
	}

}
