package br.com.fiap;

import br.com.fiap.bo.BeneficiarioBO;

import br.com.fiap.entities.Beneficiario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/beneficiario")
public class BeneficiarioResource {

    private BeneficiarioBO beneficiarioBO = new BeneficiarioBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Beneficiario beneficiario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        beneficiarioBO.inserirBO(beneficiario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(beneficiario.getIdBeneficiario()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        beneficiarioBO.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Beneficiario beneficiario, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        beneficiarioBO.atualizarBO(beneficiario);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Beneficiario> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Beneficiario>) beneficiarioBO.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Beneficiario selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (Beneficiario) beneficiarioBO.selecionarPorCodigoBo(codigo);
    }
}
