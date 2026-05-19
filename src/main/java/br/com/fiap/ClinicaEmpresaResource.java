package br.com.fiap;

import br.com.fiap.bo.ClinicaEmpresaBO;
import br.com.fiap.entities.ClinicaEmpresa;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("ClinicaEmpresa")
public class ClinicaEmpresaResource {

    private ClinicaEmpresaBO clinicaEmpresaBO = new ClinicaEmpresaBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(ClinicaEmpresa clinicaEmpresa, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        clinicaEmpresaBO.inserirBo(clinicaEmpresa);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(clinicaEmpresa.getIdEmpresa()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        clinicaEmpresaBO.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(ClinicaEmpresa clinicaEmpresa, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        clinicaEmpresaBO.atualizarBO(clinicaEmpresa);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ClinicaEmpresa> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<ClinicaEmpresa>) clinicaEmpresaBO.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClinicaEmpresa selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (ClinicaEmpresa) clinicaEmpresaBO.selecionarPorCodigoBo(codigo);
    }
}
