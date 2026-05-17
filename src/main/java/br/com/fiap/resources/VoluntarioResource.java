package br.com.fiap.resources;

import br.com.fiap.bo.VoluntarioBO;
import br.com.fiap.entities.ClinicaEmpresa;
import br.com.fiap.entities.Voluntario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/voluntario")
public class VoluntarioResource {

    private VoluntarioBO voluntarioBO = new VoluntarioBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Voluntario voluntario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        voluntarioBO.inserirBO(voluntario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(voluntario.getIdVoluntario()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        voluntarioBO.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Voluntario voluntario, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        voluntarioBO.atualizarBO(voluntario);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Voluntario> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Voluntario>) voluntarioBO.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Voluntario selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (Voluntario) voluntarioBO.selecionarPorCodigoBo(codigo);
    }
}
