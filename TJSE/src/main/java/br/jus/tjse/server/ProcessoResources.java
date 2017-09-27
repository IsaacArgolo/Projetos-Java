package br.jus.tjse.server;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import io.swagger.annotations.Api;

import br.jus.tjse.model.Classe;
import br.jus.tjse.model.Parte;
import br.jus.tjse.model.Processo;
import br.jus.tjse.service.ClasseService;
import br.jus.tjse.service.PartesService;
import br.jus.tjse.service.ProcessoService;
import br.jus.tjse.util.log.Log;


/**
 * @author isaac
 *
 */

@Api
@Path("ProcessoResource")
public class ProcessoResources {
	@Context
    private ResourceContext resourceContext;
	
	private ProcessoService processoService;

	private static Logger log = Log.createLog();
	
	public ProcessoResources() {
		System.out.println("****** Inicializou o serviço Processo Rest *****");
		processoService = new ProcessoService();
		//PropertyConfigurator.configure("log4j.properties");
//		System.out.print());
	}

	@GET
	@Path("/partesPorProcesso/{numero}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Parte> partesPorProcesso(@Size(min=10,message="no mínimo 10 dígitos") @PathParam(value = "numero") String numero) throws javax.validation.ValidationException{
		System.out.println("Server - method:partesPorProcesso \n numProcesso: "+numero);

		return processoService.listarPartes(numero);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Processo> todosProcessos() {
		return processoService.todos();
	}

	@GET
	@Path("/classes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Classe> todasClasses() {
		return new ClasseService().getClasses();
	}

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces((MediaType.APPLICATION_JSON))
	
	public Response salvar(@Valid Processo processo) throws javax.validation.ValidationException {

		String numero = Calendar.getInstance().get(Calendar.YEAR) + "" + ((long)(Math.random() * new Long("99999999")));

		System.out.println("numero do processo: " + numero);
		processo.setNumero(numero);
		processo.setSituacao("Andamento");
		Boolean b = processoService.gravar(processo);
		
		try {
			
		} catch (javax.validation.ValidationException e) {
			// TODO: handle exception
			System.out.println("teste "+e.getMessage());
		}
		
		if (b)
			System.out.println("******Processo salvo com sucesso!******");
		else
			System.out.println("******Erro ao salvar o processo******");
		
		log.info(processo);
		
		return Response.status(Response.Status.OK).entity(processo).build();
	}

	@DELETE
	@Path("/deletar/{numero}")
	public Processo deletar(@NotNull @PathParam(value = "numero") String numero) throws Exception {

		Processo p = processoService.remover(numero);
		System.out.println("******Processo deletado com sucesso!******");
		return p;
	}

	@GET
	@Path("/partes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Parte> todasPartes() {
		return new PartesService().todas();
	}
}
