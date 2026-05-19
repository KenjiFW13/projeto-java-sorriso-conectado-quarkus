package br.com.fiap.resources;

import br.com.fiap.bo.FuncionarioTdbBO;
import br.com.fiap.entities.FuncionarioTdb;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/funcionariotdb")
public class FuncionarioTdbResource {

    private FuncionarioTdbBO funcionarioTdbBO = new FuncionarioTdbBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(FuncionarioTdb funcionarioTdb, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        funcionarioTdbBO.inserirBO(funcionarioTdb);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(funcionarioTdb.getIdFuncionarioTdb()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        funcionarioTdbBO.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(FuncionarioTdb funcionarioTdb, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        funcionarioTdbBO.atualizarBO(funcionarioTdb);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<FuncionarioTdb> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<FuncionarioTdb>) funcionarioTdbBO.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public FuncionarioTdb selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (FuncionarioTdb) funcionarioTdbBO.selecionarPorCodigoBo(codigo);
    }
}
