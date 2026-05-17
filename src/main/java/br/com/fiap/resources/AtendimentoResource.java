package br.com.fiap.resources;

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
    // Aqui eu precisava passar como parâmetro os ids a serem relacionados na hora de realizar um atendimento
    // (O sistema pede o id do dentista, da clinica e do beneficiario para conseguir criar um atendimento)
    // E o metodo não aceita tantos parâmetros, por isso o @QueryParam
    public Response inserirRs(Atendimento atendimento,
                              @QueryParam("idClinica") int idClinica,
                              @QueryParam("idDentista") int idDentista,
                              @QueryParam("idBeneficiario") int idBeneficiario,
                              @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        ClinicaEmpresa clinicaEmpresa = new ClinicaEmpresa();
        clinicaEmpresa.setIdEmpresa(idClinica);

        Dentista dentista = new Dentista();
        dentista.setIdDentista(idDentista);

        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setIdBeneficiario(idBeneficiario);

        atendimentoBO.inserirBo(atendimento, clinicaEmpresa, dentista, beneficiario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(atendimento.getIdAtendimento()));
        return Response.created(builder.build()).build();
    }

    // DefinirPrioridade
    @PUT
    @Path("/{codigo}/prioridade")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response definirPrioridadeRs(Atendimento atendimento, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        atendimentoBO.DefinirPrioridadeBo(atendimento);
        return Response.ok().build();
    }

    @PUT
    @Path("/{codigo}/observacoes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarObservacoesRs(Atendimento atendimento, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        atendimentoBO.AtualizarObservacoesBo(atendimento);
        return Response.ok().build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Atendimento selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (Atendimento) atendimentoBO.selecionarPorCodigo(codigo);
    }
}
