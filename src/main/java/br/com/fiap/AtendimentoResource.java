package br.com.fiap;

import br.com.fiap.bo.AtendimentoBO;
import br.com.fiap.entities.Atendimento;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.entities.ClinicaEmpresa;
import br.com.fiap.entities.Dentista;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;

@Provider

@Path("/atendimento")
public class AtendimentoResource {

    private AtendimentoBO atendimentoBO = new AtendimentoBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Atendimento atendimento, ClinicaEmpresa clinicaEmpresa, Dentista dentista, Beneficiario beneficiario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        atendimentoBO.inserirBo(atendimento, clinicaEmpresa, dentista, beneficiario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(atendimento.getIdAtendimento()));
        return Response.created(builder.build()).build();
    }

    // DefinirPrioridade
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response definirPrioridadeRs(Atendimento atendimento, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        atendimentoBO.DefinirPrioridadeBo(atendimento);
        return Response.ok().build();
    }
}
