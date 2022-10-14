package br.com.WorkOn.controller;

import java.net.URI;
import java.util.List;

import br.com.WorkOn.DAO.VagaDAO;
import br.com.WorkOn.model.Vaga;
import br.com.WorkOn.model.dto.VagaDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.UriBuilder;


@Path("/vaga")
public class VagaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<Vaga> retorno = VagaDAO.listarTodasVagas();
		ResponseBuilder response = Response.ok();
		response.entity(retorno);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarVaga(VagaDTO vaga) {
		System.out.println(vaga);
		// INSERIR NA BASE
		VagaDAO.InserirVaga(vaga.getCadastrador(), vaga.getVaga());
		
		final URI coffeeUri = UriBuilder.fromResource(VagaResource.class).path("/vaga/{id}").build(1);
	 	// @formatter:on
	 	ResponseBuilder response = Response.created(coffeeUri);
	 	response.entity(null);
	 	return response.build();
		
		
		//CONSTRUIR O PATH DE RETORNO
		
		
		//RETORNAR O PATH E O STATUS 201
//		return Response.created(builder.build()).build();
	}
}
