/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.ADDAcompanhamentoMulher;
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
 * @author diogenes
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "SelecionarPacienteMulher",
            query = "Select p From Paciente p Where p.sexoPaciente = 1 Order By p.cns"), //    /*@NamedQuery(name = "NomeMulher",
//            query = "Select p.nomeCompletoPaciente From Paciente p Where p.sexoPaciente = 1 Order By p.idPaciente"),
//    @NamedQuery(name = "EnderecoMulher",
//            query = "Select p.enderecoPaciente From Paciente p Where p.sexoPaciente = 1 Order By p.idPaciente"),
//    @NamedQuery(name = "NumeroProntuarioMulher",
//            query = "Select p.idPaciente From Paciente p Where p.sexoPaciente = 1 Order By p.idPaciente")*/
})
@Views({
    @View(name = "AtendimentoMulher",
            title = "Ficha de Atendimento à Mulher",
            filters = "[paciente,Ctrl.DAO.filter()]",
            members = "[Ficha de Atendimento à Mulher["
            + "Dados Pessoais['Nome:':paciente,'Nº do Prontuário:':numero_prontuario;'Endereço:':endereco,'Data de Nascimento:':dn];"
            + "[Tipo de Cliente['NOVA - Que nunca se submeteu ao exame citológico':nova;"
            + "'CONTROLE - Com exame anterior negativo/inflamatório':controle;"
            + "'SEGUIMENTO - Acompanhamento após Diagnóstico/Tratamento de Displasias ou Carcinomas':seguimento],"
            + "Último Exame['1 a 3 anos':umATres;'Mais de 3 anos':maisDeTres;'Mais de 5 anos':maisDeCinco;'Ignorado':ignorado],"
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
            + "addAcompanhamentoMulher<mamasNormais,seios, quadrantes, sintomas, removerSintoma()>],"
            + "Exame da Vulva['Vulva Normal:':vulva_normal,'Condiloma:':condiloma,'Outros Sintomas:':outros_sintomas;"
            + "'Cont. Vaginal Normal:':cont_vaginal_normal,'Sangramento:':sangramento_facil,'Ulceração:':ulceracao;"
            + "'Amarelo:':amarelo,'Grumoso:':grumoso,'Bolhoso:':bolhoso;"
            + "'Sanguinolento:':sanguinolento,'Colo Normal:':colo_normal,'M.V.P.O:':mvpo;"
            + "Shiler['1 +':shiler_umMais,'1 CL':shiler_umCL;'1 -':shiler_umMenos],Exame de Toque['Descrição:':exame_toque]]]];"
            + "Atendente['ENFERMEIRO:':enfermeiro,'COREN Nº:':coren_enfermeiro;'MÉDICO:':medico,'CRM Nº:':crm_medico]]]",
            template = "@CRUD+@PAGER",
            rows = 1,
            roles = "Administrador, Medico, Enfermeiro, TecnicoDeEnfermagem")
})
public class AtendimentoAMulher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    @ManyToOne()
    @PropertyDescriptor(autoFilter = true)
    @Editor(namedQuery = "SelecionarPacienteMulher")
    private Paciente paciente;
    @Column(length = 50)
    //@Editor(namedQuery = "NomeMulher")
    private String nome;
    //@Editor(namedQuery = "EnderecoMulher")
    @Column(length = 50)
    private String endereco;
    //@Editor(namedQuery = "NumeroProntuarioMulher")
    private Integer numero_prontuario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dn;
    @PropertyDescriptor(displayName = "Adicionar Sintoma")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mulherAddAcompanhamento")
    private List<ADDAcompanhamentoMulher> addAcompanhamentoMulher = new ArrayList<ADDAcompanhamentoMulher>();

    public enum Resposta {

        Sim, Não
    }
    private Boolean nova;
    private Boolean controle;
    private Boolean seguimento;
    private Boolean umATres;
    private Boolean maisDeTres;
    private Boolean maisDeCinco;
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
    @Column(length = 50)
    private String inicioVidaSexual;
    @Column(length = 50)
    private String gesta;
    @Column(length = 50)
    private String para;
    @Column(length = 50)
    private String aborto;
    @Column(length = 50)
    private String ultimaGravidez;
    @Column(length = 50)
    private String ciclos;
    @Column(length = 50)
    private String ur;
    private Resposta sinusiorragia;
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
    private String pa;
    @Column(length = 50)
    private String peso;
    private Resposta mamasNormais;
    private Resposta vulva_normal;
    @Column(length = 50)
    private String condiloma;
    private Boolean cont_vaginal_normal;
    private Boolean amarelo;
    private Boolean grumoso;
    private Boolean bolhoso;
    private Boolean sanguinolento;
    private Boolean colo_normal;
    private Boolean mvpo;
    private Boolean sangramento_facil;
    private Boolean ulceracao;
    @Column(length = 50)
    private String outros_sintomas;
    private Boolean shiler_umMais;
    private Boolean shiler_umCL;
    private Boolean shiler_umMenos;
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

    public Boolean getNova() {
        return nova;
    }

    public void setNova(Boolean nova) {
        this.nova = nova;
    }

    public Boolean getControle() {
        return controle;
    }

    public void setControle(Boolean controle) {
        this.controle = controle;
    }

    public Boolean getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(Boolean seguimento) {
        this.seguimento = seguimento;
    }

    public Boolean getUmATres() {
        return umATres;
    }

    public void setUmATres(Boolean umATres) {
        this.umATres = umATres;
    }

    public Boolean getMaisDeTres() {
        return maisDeTres;
    }

    public void setMaisDeTres(Boolean maisDeTres) {
        this.maisDeTres = maisDeTres;
    }

    public Boolean getMaisDeCinco() {
        return maisDeCinco;
    }

    public void setMaisDeCinco(Boolean maisDeCinco) {
        this.maisDeCinco = maisDeCinco;
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

    public String getInicioVidaSexual() {
        return inicioVidaSexual;
    }

    public void setInicioVidaSexual(String inicioVidaSexual) {
        this.inicioVidaSexual = inicioVidaSexual;
    }

    public String getGesta() {
        return gesta;
    }

    public void setGesta(String gesta) {
        this.gesta = gesta;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getAborto() {
        return aborto;
    }

    public void setAborto(String aborto) {
        this.aborto = aborto;
    }

    public String getUltimaGravidez() {
        return ultimaGravidez;
    }

    public void setUltimaGravidez(String ultimaGravidez) {
        this.ultimaGravidez = ultimaGravidez;
    }

    public String getCiclos() {
        return ciclos;
    }

    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

    public Resposta getSinusiorragia() {
        return sinusiorragia;
    }

    public void setSinusiorragia(Resposta sinusiorragia) {
        this.sinusiorragia = sinusiorragia;
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

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Resposta getMamasNormais() {
        return mamasNormais;
    }

    public void setMamasNormais(Resposta mamasNormais) {
        this.mamasNormais = mamasNormais;
    }

    public Resposta getVulva_normal() {
        return vulva_normal;
    }

    public void setVulva_normal(Resposta vulva_normal) {
        this.vulva_normal = vulva_normal;
    }

    public String getCondiloma() {
        return condiloma;
    }

    public void setCondiloma(String condiloma) {
        this.condiloma = condiloma;
    }

    public Boolean getCont_vaginal_normal() {
        return cont_vaginal_normal;
    }

    public void setCont_vaginal_normal(Boolean cont_vaginal_normal) {
        this.cont_vaginal_normal = cont_vaginal_normal;
    }

    public Boolean getAmarelo() {
        return amarelo;
    }

    public void setAmarelo(Boolean amarelo) {
        this.amarelo = amarelo;
    }

    public Boolean getGrumoso() {
        return grumoso;
    }

    public void setGrumoso(Boolean grumoso) {
        this.grumoso = grumoso;
    }

    public Boolean getBolhoso() {
        return bolhoso;
    }

    public void setBolhoso(Boolean bolhoso) {
        this.bolhoso = bolhoso;
    }

    public Boolean getSanguinolento() {
        return sanguinolento;
    }

    public void setSanguinolento(Boolean sanguinolento) {
        this.sanguinolento = sanguinolento;
    }

    public Boolean getColo_normal() {
        return colo_normal;
    }

    public void setColo_normal(Boolean colo_normal) {
        this.colo_normal = colo_normal;
    }

    public Boolean getMvpo() {
        return mvpo;
    }

    public void setMvpo(Boolean mvpo) {
        this.mvpo = mvpo;
    }

    public Boolean getSangramento_facil() {
        return sangramento_facil;
    }

    public void setSangramento_facil(Boolean sangramento_facil) {
        this.sangramento_facil = sangramento_facil;
    }

    public Boolean getUlceracao() {
        return ulceracao;
    }

    public void setUlceracao(Boolean ulceracao) {
        this.ulceracao = ulceracao;
    }

    public String getOutros_sintomas() {
        return outros_sintomas;
    }

    public void setOutros_sintomas(String outros_sintomas) {
        this.outros_sintomas = outros_sintomas;
    }

    public Boolean getShiler_umMais() {
        return shiler_umMais;
    }

    public void setShiler_umMais(Boolean shiler_umMais) {
        this.shiler_umMais = shiler_umMais;
    }

    public Boolean getShiler_umCL() {
        return shiler_umCL;
    }

    public void setShiler_umCL(Boolean shiler_umCL) {
        this.shiler_umCL = shiler_umCL;
    }

    public Boolean getShiler_umMenos() {
        return shiler_umMenos;
    }

    public void setShiler_umMenos(Boolean shiler_umMenos) {
        this.shiler_umMenos = shiler_umMenos;
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

    public List<ADDAcompanhamentoMulher> getAddAcompanhamentoMulher() {
        return addAcompanhamentoMulher;
    }

    public void setAddAcompanhamentoMulher(List<ADDAcompanhamentoMulher> addAcompanhamentoMulher) {
        this.addAcompanhamentoMulher = addAcompanhamentoMulher;
    }

    @ActionDescriptor(methodDisabled = "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarSintoma() {
        ADDAcompanhamentoMulher addM = new ADDAcompanhamentoMulher();
        addM.setMulherAddAcompanhamento(this);
        addAcompanhamentoMulher.add(addM);
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
        final AtendimentoAMulher other = (AtendimentoAMulher) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
