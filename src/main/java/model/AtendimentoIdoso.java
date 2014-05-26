/*
/ * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.ADDAcompanhamentoIdoso;
import entities.annotations.ActionDescriptor;
import entities.annotations.Editor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author marsellus
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "SelecionarPacienteIdoso",
            query = "Select p From Paciente p Where p.sexoPaciente = 1 OR p.sexoPaciente = 0 Order By p.cns")
})
@Views({
    @View(name = "AtendimentoIdoso",
            title = "Ficha de Atendimento à Idoso",
            filters = "[paciente,Ctrl.DAO.filter()]",
            members = "[Ficha de Atendimento à Idoso["
            + "Dados Pessoais['Nome:':paciente,'Nº do Prontuário:':numero_prontuario;'Endereço:':endereco,'Data de Nascimento:':dn];"
            + "Exames['Radioterapia:':paciente_radio;'Gestante:':paciente_gestante;'TRH:':paciente_trh],"
            + "Métodos Anticoncepcionais['Nome do Remédio:':nome_remedio;'Tempo de Uso:':tempoUso;'Causa de Interrupção:':causaInterrupcao]];"
            + "Enfermeiros e Médicos["
            + "[['Início da Vida Sexual:':inicioVidaSexual,'GESTA:':gesta,'PARA:':para,'ABORTO:':aborto];"
            + "['Última Gravidez:':ultimaGravidez,'Peso:':peso,'Ciclos:':ciclos,'UR:':ur];"
            + "['Sinusiorragia:':sinusiorragia,'Eletro:':eletro,'Fumante:':fumante,'Hipertensão:':hipertensao,'Diabetes:':diabetes,"
            + "'Câncer Familiar:':cancerFamiliar,'Quem?':cancer_descricao,'Tipo de Câncer:':tipo_cancer];"
            + "['PA:':pa,'Outras Doenças:':outras_doencas,'Antecedentes Cirúrgicos:':antecedentesCirurgicos];"
            + "['DST:':dst, 'Descrição:':dst_descricao]];"
            + "[Exame das Mamas[adicionarSintoma();"
            + "addAcompanhamentoIdoso<glicose ,pressao , sintomas, removerSintoma()>],"
            + "Shiler['1 +':shiler_umMais,'1 CL':shiler_umCL;'1 -':shiler_umMenos],Exame de Toque['Descrição:':exame_toque]]]];"
            + "Atendente['ENFERMEIRO:':enfermeiro,'COREN Nº:':coren_enfermeiro;'MÉDICO:':medico,'CRM Nº:':crm_medico]]]",
            template = "@CRUD+@PAGER",
            rows = 1,
            roles = "Administrador, Medico, Enfermeiro, TecnicoDeEnfermagem")
})
public class AtendimentoIdoso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    @ManyToOne()
    @PropertyDescriptor(autoFilter = true)
    @Editor(namedQuery = "SelecionarPacienteIdoso")
    private Paciente paciente;
    @Column(length = 50)
    //@Editor(namedQuery = "NomeIdoso")
    private String nome;
    //@Editor(namedQuery = "EnderecoIdoso")
    @Column(length = 50)
    private String endereco;
    //@Editor(namedQuery = "NumeroProntuarioIdoso")
    private Integer numero_prontuario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dn;
    @PropertyDescriptor(displayName = "Adicionar Sintoma")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IdosoAddAcompanhamento")
    private List<ADDAcompanhamentoIdoso> addAcompanhamentoIdoso = new ArrayList<ADDAcompanhamentoIdoso>();

    public enum Resposta {

        Sim, Não
    }
    

    private Integer glicose; 
    private Integer pressao; 
    private Boolean ignorado;
    private Resposta paciente_radio;
    private Resposta paciente_gestante;
    private Resposta paciente_trh;
    @Column(length = 50)
    private String nome_remedio;
    @Column(length = 50)
    private String tempoUso;
    @Column(length = 50)
    private String causaInterrupcao;
 

    private Resposta eletro;
    @Column(length = 50)
    private String dst;
    @Editor(inputComponentName = "javax.faces.component.html.HtmlInputTextarea")
    @Column(length = 100)
    private String dst_descricao;
    private Resposta fumante;
    private Resposta cancerFamiliar;
    @Editor(inputComponentName = "javax.faces.component.html.HtmlInputTextarea")
    @Column(length = 100)
    private String cancer_descricao;
    @Column(length = 50)
    private String tipo_cancer;
    private Resposta diabetes;
    private Resposta hipertensao;
    @Column(length = 50)
    private String outras_doencas;
    @Column(length = 50)
    private String antecedentesCirurgicos;
    @Column(length = 50)
    private String outros_antecedentes;
   
    @Column(length = 50)
    private String peso;

    @Editor(inputComponentName = "javax.faces.component.html.HtmlInputTextarea")
    @Column(length = 100)
    private String exame_toque;
    private Boolean enfermeiro;
    private int coren_enfermeiro;
    private Boolean medico;
    private int crm_medico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero_prontuario() {
        return numero_prontuario;
    }

    public void setNumero_prontuario(Integer numero_prontuario) {
        this.numero_prontuario = numero_prontuario;
    }

    public Date getDn() {
        return dn;
    }

    public void setDn(Date dn) {
        this.dn = dn;
    }

    public Boolean getIgnorado() {
        return ignorado;
    }

    public void setIgnorado(Boolean ignorado) {
        this.ignorado = ignorado;
    }

    public Resposta getPaciente_radio() {
        return paciente_radio;
    }

    public void setPaciente_radio(Resposta paciente_radio) {
        this.paciente_radio = paciente_radio;
    }

    public Resposta getPaciente_gestante() {
        return paciente_gestante;
    }

    public void setPaciente_gestante(Resposta paciente_gestante) {
        this.paciente_gestante = paciente_gestante;
    }

    public Resposta getPaciente_trh() {
        return paciente_trh;
    }

    public void setPaciente_trh(Resposta paciente_trh) {
        this.paciente_trh = paciente_trh;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public String getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(String tempoUso) {
        this.tempoUso = tempoUso;
    }

    public String getCausaInterrupcao() {
        return causaInterrupcao;
    }

    public void setCausaInterrupcao(String causaInterrupcao) {
        this.causaInterrupcao = causaInterrupcao;
    }
  
    public Resposta getEletro() {
        return eletro;
    }

    public void setEletro(Resposta eletro) {
        this.eletro = eletro;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getDst_descricao() {
        return dst_descricao;
    }

    public void setDst_descricao(String dst_descricao) {
        this.dst_descricao = dst_descricao;
    }

    public Resposta getFumante() {
        return fumante;
    }

    public void setFumante(Resposta fumante) {
        this.fumante = fumante;
    }

    public Resposta getCancerFamiliar() {
        return cancerFamiliar;
    }

    public void setCancerFamiliar(Resposta cancerFamiliar) {
        this.cancerFamiliar = cancerFamiliar;
    }

    public String getCancer_descricao() {
        return cancer_descricao;
    }

    public void setCancer_descricao(String cancer_descricao) {
        this.cancer_descricao = cancer_descricao;
    }

    public String getTipo_cancer() {
        return tipo_cancer;
    }

    public void setTipo_cancer(String tipo_cancer) {
        this.tipo_cancer = tipo_cancer;
    }

    public Resposta getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Resposta diabetes) {
        this.diabetes = diabetes;
    }

    public Resposta getHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(Resposta hipertensao) {
        this.hipertensao = hipertensao;
    }

    public String getOutras_doencas() {
        return outras_doencas;
    }

    public void setOutras_doencas(String outras_doencas) {
        this.outras_doencas = outras_doencas;
    }

    public String getAntecedentesCirurgicos() {
        return antecedentesCirurgicos;
    }

    public void setAntecedentesCirurgicos(String antecedentesCirurgicos) {
        this.antecedentesCirurgicos = antecedentesCirurgicos;
    }

    public String getOutros_antecedentes() {
        return outros_antecedentes;
    }

    public void setOutros_antecedentes(String outros_antecedentes) {
        this.outros_antecedentes = outros_antecedentes;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }


    public String getExame_toque() {
        return exame_toque;
    }

    public void setExame_toque(String exame_toque) {
        this.exame_toque = exame_toque;
    }

    public Boolean getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Boolean enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public int getCoren_enfermeiro() {
        return coren_enfermeiro;
    }

    public void setCoren_enfermeiro(int coren_enfermeiro) {
        this.coren_enfermeiro = coren_enfermeiro;
    }

    public Boolean getMedico() {
        return medico;
    }

    public void setMedico(Boolean medico) {
        this.medico = medico;
    }

    public int getCrm_medico() {
        return crm_medico;
    }

    public void setCrm_medico(int crm_medico) {
        this.crm_medico = crm_medico;
    }

    public List<ADDAcompanhamentoIdoso> getAddAcompanhamentoIdoso() {
        return addAcompanhamentoIdoso;
    }

    public void setAddAcompanhamentoIdoso(List<ADDAcompanhamentoIdoso> addAcompanhamentoIdoso) {
        this.addAcompanhamentoIdoso = addAcompanhamentoIdoso;
    }

    @ActionDescriptor(methodDisabled = "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarSintoma() {
        ADDAcompanhamentoIdoso addM = new ADDAcompanhamentoIdoso();
        addM.setIdosoAddAcompanhamento(this);
        addAcompanhamentoIdoso.add(addM);
    }

    @Override
    public String toString() {
        return paciente.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtendimentoIdoso other = (AtendimentoIdoso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
