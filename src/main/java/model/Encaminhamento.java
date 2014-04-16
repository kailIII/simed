/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.ADDAgendamento;
import entities.annotations.ActionDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pedro
 */
@Entity
@Views({
    @View(name = "Encaminhamentos", title = "Encaminhamento de Paciente",
            members = "["
            + "unidadeSaudeOrigem;"
            + "unidadeSaudeEncaminhamento;"
            + "dataEncaminhamento;"
            + "pacienteEncaminhamento;"
            + "motivoDoEncaminhamento;"
            + "resultadoDeExames;"
            + "condutaRealizada;"
            + "impressaoDiagnostica;"
            + "adicionarAgendamento();"
            + "'Adicionar Agendamento':pacienteAddAgendamentos<paciente,tipo,procedimento,profissional,ubs,dataAgendamento,removerAgendamento()>;"
            + "Ficha de contra-referência[municipio;numeroProntuario;dataDaAlta;"
            + "resumoClinico;resultadoDeExames2;diagnosticoPrincipal;"
            + "cidDiagnosticoPrincipal;secundario1;cidSecundario1;secundario2;"
            + "cidSecundario2;propostaDeCondutaParaSegmento;oProblemaJustificouAReferencia;oMotivoDaReferenciaCoincideComODiagnostico];]",
            template = "@CRUD+@PAGER",
            roles = "Administrador, Atendente")
})
public class Encaminhamento implements Serializable {

    public enum Resposta {

        Sim, Não
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Integer idEncaminhamento;
    @ManyToOne
    private UnidadeBasicaDeSaude unidadeSaudeOrigem;
    @ManyToOne
    private UnidadeBasicaDeSaude unidadeSaudeEncaminhamento;
    @NotNull
    @ManyToOne
    private Paciente pacienteEncaminhamento;
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "Informe a Data do Encaminhamento")
    private Date dataEncaminhamento;
    @Lob
    private String motivoDoEncaminhamento;
    @Lob
    private String resultadoDeExames;
    @Lob
    private String condutaRealizada;
    @Lob
    private String impressaoDiagnostica;
    private String municipio;
    private int numeroProntuario;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @PropertyDescriptor(displayName = "Data da Alta")
    private Date dataDaAlta;
    @Lob
    private String resumoClinico;
    @Lob
    private String resultadoDeExames2;
    private String diagnosticoPrincipal;
    private String cidDiagnosticoPrincipal;
    private String secundario1;
    private String cidSecundario1;
    private String secundario2;
    private String cidSecundario2;
    private String propostaDeCondutaParaSegmento;
    private Resposta oProblemaJustificouAReferencia;
    private Resposta oMotivoDaReferenciaCoincideComODiagnostico;

    public Resposta getoProblemaJustificouAReferencia() {
        return oProblemaJustificouAReferencia;
    }

    public void setoProblemaJustificouAReferencia(Resposta oProblemaJustificouAReferencia) {
        this.oProblemaJustificouAReferencia = oProblemaJustificouAReferencia;
    }

    public Resposta getoMotivoDaReferenciaCoincideComODiagnostico() {
        return oMotivoDaReferenciaCoincideComODiagnostico;
    }

    public void setoMotivoDaReferenciaCoincideComODiagnostico(Resposta oMotivoDaReferenciaCoincideComODiagnostico) {
        this.oMotivoDaReferenciaCoincideComODiagnostico = oMotivoDaReferenciaCoincideComODiagnostico;
    }

    public String getResumoClinico() {
        return resumoClinico;
    }

    public void setResumoClinico(String resumoClinico) {
        this.resumoClinico = resumoClinico;
    }

    public String getResultadoDeExames2() {
        return resultadoDeExames2;
    }

    public void setResultadoDeExames2(String resultadoDeExames2) {
        this.resultadoDeExames2 = resultadoDeExames2;
    }

    public String getDiagnosticoPrincipal() {
        return diagnosticoPrincipal;
    }

    public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
        this.diagnosticoPrincipal = diagnosticoPrincipal;
    }

    public String getCidDiagnosticoPrincipal() {
        return cidDiagnosticoPrincipal;
    }

    public void setCidDiagnosticoPrincipal(String cidDiagnosticoPrincipal) {
        this.cidDiagnosticoPrincipal = cidDiagnosticoPrincipal;
    }

    public String getSecundario1() {
        return secundario1;
    }

    public void setSecundario1(String secundario1) {
        this.secundario1 = secundario1;
    }

    public String getCidSecundario1() {
        return cidSecundario1;
    }

    public void setCidSecundario1(String cidSecundario1) {
        this.cidSecundario1 = cidSecundario1;
    }

    public String getSecundario2() {
        return secundario2;
    }

    public void setSecundario2(String secundario2) {
        this.secundario2 = secundario2;
    }

    public String getCidSecundario2() {
        return cidSecundario2;
    }

    public void setCidSecundario2(String cidSecundario2) {
        this.cidSecundario2 = cidSecundario2;
    }

    public String getPropostaDeCondutaParaSegmento() {
        return propostaDeCondutaParaSegmento;
    }

    public void setPropostaDeCondutaParaSegmento(String propostaDeCondutaParaSegmento) {
        this.propostaDeCondutaParaSegmento = propostaDeCondutaParaSegmento;
    }
    @PropertyDescriptor(displayName = "Agendamento")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteAddAgendamento")
    private List<ADDAgendamento> pacienteAddAgendamentos = new ArrayList<ADDAgendamento>();

    @ActionDescriptor(methodDisabled = "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarAgendamento() {
        ADDAgendamento addAgendamento = new ADDAgendamento();
        addAgendamento.setPaciente(pacienteEncaminhamento);
        addAgendamento.setPacienteAddAgendamento(this);
        pacienteAddAgendamentos.add(addAgendamento);
        //pacienteEncaminhamento.getNomeCompletoPaciente()
    }

    public Integer getIdEncaminhamento() {
        return idEncaminhamento;
    }

    public void setIdEncaminhamento(Integer idEncaminhamento) {
        this.idEncaminhamento = idEncaminhamento;
    }

    public UnidadeBasicaDeSaude getUnidadeSaudeOrigem() {
        return unidadeSaudeOrigem;
    }

    public void setUnidadeSaudeOrigem(UnidadeBasicaDeSaude unidadeSaudeOrigem) {
        this.unidadeSaudeOrigem = unidadeSaudeOrigem;
    }

    public UnidadeBasicaDeSaude getUnidadeSaudeEncaminhamento() {
        return unidadeSaudeEncaminhamento;
    }

    public void setUnidadeSaudeEncaminhamento(UnidadeBasicaDeSaude unidadeSaudeEncaminhamento) {
        this.unidadeSaudeEncaminhamento = unidadeSaudeEncaminhamento;
    }

    public Paciente getPacienteEncaminhamento() {
        return pacienteEncaminhamento;
    }

    public void setPacienteEncaminhamento(Paciente pacienteEncaminhamento) {
        this.pacienteEncaminhamento = pacienteEncaminhamento;
    }

    public Date getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    public void setDataEncaminhamento(Date dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    public String getMotivoDoEncaminhamento() {
        return motivoDoEncaminhamento;
    }

    public void setMotivoDoEncaminhamento(String motivoDoEncaminhamento) {
        this.motivoDoEncaminhamento = motivoDoEncaminhamento;
    }

    public String getResultadoDeExames() {
        return resultadoDeExames;
    }

    public void setResultadoDeExames(String resultadoDeExames) {
        this.resultadoDeExames = resultadoDeExames;
    }

    public String getCondutaRealizada() {
        return condutaRealizada;
    }

    public void setCondutaRealizada(String condutaRealizada) {
        this.condutaRealizada = condutaRealizada;
    }

    public String getImpressaoDiagnostica() {
        return impressaoDiagnostica;
    }

    public void setImpressaoDiagnostica(String impressaoDiagnostica) {
        this.impressaoDiagnostica = impressaoDiagnostica;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getNumeroProntuario() {
        return numeroProntuario;
    }

    public void setNumeroProntuario(int numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    public Date getDataDaAlta() {
        return dataDaAlta;
    }

    public void setDataDaAlta(Date dataDaAlta) {
        this.dataDaAlta = dataDaAlta;
    }

    public List<ADDAgendamento> getPacienteAddAgendamentos() {
        return pacienteAddAgendamentos;
    }

    public void setPacienteAddAgendamentos(List<ADDAgendamento> pacienteAddAgendamentos) {
        this.pacienteAddAgendamentos = pacienteAddAgendamentos;
    }

    
}
