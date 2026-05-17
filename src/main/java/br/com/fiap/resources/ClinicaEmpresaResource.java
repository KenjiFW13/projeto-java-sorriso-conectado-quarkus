package br.com.fiap.resources;

import br.com.fiap.bo.ClinicaEmpresaBO;
import br.com.fiap.entities.ClinicaEmpresa;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;

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
}
