package br.com.fiap.resources;

import br.com.fiap.bo.DentistaBO;
import br.com.fiap.entities.Dentista;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/dentista")
public class DentistaResource {

    private DentistaBO dentistaBO = new DentistaBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Dentista dentista, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        dentistaBO.inserirBO(dentista);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(dentista.getIdDentista()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        DentistaBO.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Dentista dentista, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        DentistaBO.atualizarBO(dentista);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Dentista> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Dentista>) DentistaBO.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dentista selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (Dentista) DentistaBO.selecionarPorCodigoBo(codigo);
    }
}
