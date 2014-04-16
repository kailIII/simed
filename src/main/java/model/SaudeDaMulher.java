/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.ADDConsulta;
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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marsellus
 */
@Entity 
@NamedQueries({
@NamedQuery(name = "VerificacaoDaUsuaria",
            query = "Select p "
            + "From Paciente p "
            + "Where p.sexoPaciente = 1"
            + "Order By p.cns"),
@NamedQuery(name= "SaudeDaMulherNamedQuery",
            query = "Select u"
            + " From SaudeDaMulher u"
            + " Order By u.paciente" )
})
@Views({
            @View(name = "SaudeDaMulher", title = "Saúde Da Mulher",
            filters = "Pesquisar Por:[paciente, Ctrl.DAO.filter()]",
            members = "[Antecedentes[[paciente,ubs],"
            + "Familiares[afDiabetes;afHiperArter;afGemelares;afOutros],"
            + "Pessoais [peInfeccaoUrinar;peInfertilidade;peDiabetes;peHipertenCronica;peCirPelvicoUter;peOutros],"
            + "Obstétricos [gestas;abortos;partos;vaginais;cesarias;nascVivos;nascMortos;"
            + "mortePrimeiraSemana;morteDepoisPrimeiraSemana],"
            + "[pesouMenos;maiorPeso;dataTermino]];"
            + "Gravidez Atual [[pesoAnterior;estatura;dum;dpp;dataTransferencia;localTransferencia],[duvidas;"
            + "antitetanicaPrevia;antitetanicaAtualUmMes;antitetanicaAtualDoisMeses;"
            + "hospitalizacaoGravidez;diasHospitalizacao;grupo;rh;sensibilidade;transferida],"
            + "Exames [exameClinicoNormal;exameMamasNormal;exameOdontologicoNormal;"
            + "pelvisNormal;papanicolauNormal;colposcopiaNormal;exameClinicoCervix;"
            + "fuma;fumaQuantosDia]];"
                    
            + "Numero de Consultas["
            + "adicionarConsulta();"
            + "addConsulta<numeroConsulta;nomeDoMedico;dataConsulta;semanaAmenorreia;peso;"
            + "pressaoArterial;alteracaoUterina;bfc;movFetais,removerConsulta()>;];"
                    
//            + "];"
            + "[Exames Laboratoriais [gestacaoMultipla;hipertensaoPrevia;preEclampsia;eclampsia;cardiopatia;"
            + "diabetes;infeccaoUrinaria;outrasInfeccoes;parasitoses;ameacaDePartoPrematuro;desproporcaiCefPelv;"
            + "hemorragiaPrimeiroTrimestre;hemorragiaSegundoTrimestre;hemorragiaTerceiroTrimestre;"
            + "anemiaCronica;ruturaPrematuraMemb;infeccaoPuerperal;"
            + "hemorragiaPuerperal;outra;nenhuma],"
            + "Parto [Idade Gestaçao[semanas;menor37Semanas],"
            + "INICIO [inicioEspontaneo;induzido],"
            + "Terminação [terminoEspontaneo;forceps;cesaria;terminoOutra],"
            + "[nivelatencao;episiotomia;laceracao;dequitEspontaneo;placentaCompleta];"
            + "ATENDEU [atendeuParto;atendeuNeonato];"
            + "Morte Fetal [morteFetal;momentoMorteFetal];"
            + "Medicação no Parto [anestesiaLocal;anestesiaReg;anestesiaGeral;analgesico;"
            + "tranquilizante;ocitocina;antibiotico;medNoPartoOutro;medNoPartoNenhum];]];"
            + "[Recem - Nascido ["
            + "[sexo;"
            + "vdrl];"
            + "APGAR [apgarPrimeiro;apgarQuinto;seisOuMenor],"
            + "[reanimacao;pesoAoNascer],"
            + "Idade Por Ex.Fisico [sem;menorQue37],"
            + "[pesoIg;exameFisicoImediatoNormal;estaturRecemNascido;"
            + "perCefRecemNascido;exameFisicoPreAltaNormal;exameNeurologicoNormal];"
            + "Patologias do Recem - Nascido ["
            + "recemNascMHial;"
            + "recemNascSAsp;"
            + "recemNascOutrSdr;"
            + "recemNascApneias;"
            + "recemNascHemorragia;"
            + "recemNascHiperb;"
            + "recemNascInfeccao;"
            + "recemNascNeurologica;"
            + "recemNascACong;"
            + "recemNascPatosOutras;"
            + "recemNascPatosNenhuma],"
            + "[alojamentoConjunto;"
            + "altaDoRn;"
            + "idadeAltaOuTransferencia;"
            + "idadeAoFalecer;"
            + "alimentacao]];"
            + "[Puerpério ["
            + "horasOuDiasPosParto;"
            + "temperatura;"
            + "pressaoArterialMin;"
            + "pressaoArterialMax;"
            + "involUterina;"
            + "caracteristicasDosLoquios],"
            + "Orientação/Contracepção ["
            + "camisinha;"
            + "diu;"
            + "oral;"
            + "nenhum;"
            + "ligacaoDeTrompas;"
            + "ritmo;"
            + "outro];"
            + "[momentoDoObito;altaMaterna];"
            
            + "]];"
                    
            + "]",
            namedQuery = "SaudeDaMulherNamedQuery",
            template = "@CRUD+@PAGER",
            roles = "Administrador,SecretarioDeSaude,ChefeDaOdontologia")})

public class SaudeDaMulher implements Serializable {

    
    public enum Rh{Positivo, Negativo}
    
    public enum NivelDeAtencao{Primeiro, Segundo, Terceiro, Domiciliar, Outro}
    
    public enum Cargos{Medico, Enfermeiro, Auxiliar, Empir, Outro}
    
    public enum Momento{Gravidez, Parto, Ignorado}
    
    public enum PesoRecemNascido{Adequado, Pequeno, Grande}
    
    public enum AltaDoRn{Sadio, Transferido, ComPatologia, Obito}
    
    public enum Alimentacao{Materna, Mixta, Artificial}
    
    public enum MomentoObito{Gravidez, Parto, Puerperio}
    
    public enum AltaMaterna{Sadia, Tranferencia, ComPatologia}
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    
    @NotNull
    @ManyToOne
    private UnidadeBasicaDeSaude ubs;
    
    @NotNull
    @ManyToOne()
    @Editor(namedQuery = "VerificacaoDaUsuaria")
    private Paciente paciente;
    
    @PropertyDescriptor(displayName="Diabetes")
    private boolean afDiabetes;
    
    @PropertyDescriptor(displayName="Hipertensão Arterial")
    private boolean afHiperArter;
    
    @PropertyDescriptor(displayName="Gemelares")
    private boolean afGemelares;
    
    @PropertyDescriptor(displayName="Outros")
    private boolean afOutros;
    
    @PropertyDescriptor(displayName="Infecção Urinar")
    private boolean peInfeccaoUrinar;
    
    @PropertyDescriptor(displayName="Infertilidade")
    private boolean peInfertilidade;
    
    @PropertyDescriptor(displayName="Diabetes")
    private boolean peDiabetes;
    
    @PropertyDescriptor(displayName="Hipertensão Crônica")
    private boolean peHipertenCronica;
    
    @PropertyDescriptor(displayName="Circunferência Pélvico-Uterina")
    private boolean peCirPelvicoUter;
    
    @PropertyDescriptor(displayName="Outros")
    private boolean peOutros;
    
    private int gestas;
    
    private int abortos;
    
    private int partos;
    
    private int vaginais;
    
    @PropertyDescriptor(displayName="Cesárias")
    private int cesarias;
    
    @PropertyDescriptor(displayName="Nascidos Vivos")
    private int nascVivos;
    
    @PropertyDescriptor(displayName="Nascidos Mortos")
    private int nascMortos;

    @PropertyDescriptor(displayName="Morreram na primeira semana")
    private int mortePrimeiraSemana;
    
    
    @PropertyDescriptor(displayName="Morreram depos da primeira semana")
    private int morteDepoisPrimeiraSemana;

    @PropertyDescriptor(displayName="Algum recem nascido pesou menos de 2.5 kg")
    private boolean pesouMenos;
    
    @PropertyDescriptor(displayName="Nascido com maior peso")
    private double maiorPeso;
    
    @PropertyDescriptor(displayName="Data do término da última gravidez")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataTermino;

    //GRAVIDEZ ATUAL
    
    private double pesoAnterior;
    
    private int estatura;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dum;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dpp;
    
    private boolean duvidas;
    
    @PropertyDescriptor(displayName="Prévia:")
    private boolean antitetanicaPrevia;
    
    @PropertyDescriptor(displayName="Atual 1º mês de gestação:")
    private boolean antitetanicaAtualUmMes;
    
    @PropertyDescriptor(displayName="Atual 2º/R mês de gestação:")
    private boolean antitetanicaAtualDoisMeses;
    
    
    @PropertyDescriptor(displayName="Hospitalização na gravidez:")
    private boolean hospitalizacaoGravidez;
    
    @PropertyDescriptor(displayName="Dias de hospitalização na gravidez:")
    private int diasHospitalizacao;
    
    private int grupo;
    
    @PropertyDescriptor(displayName="RH")
    private Rh rh; 
    
    private boolean sensibilidade;
    
    private boolean transferida;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataTransferencia;
    
    private String localTransferencia;
    
    //EXAMES
    
    private boolean exameClinicoNormal;
    
    private boolean exameMamasNormal;
    
    private boolean exameOdontologicoNormal;
    
    private boolean pelvisNormal;
            
    private boolean papanicolauNormal;
            
    private boolean colposcopiaNormal;
            
    private boolean exameClinicoCervix;
            
    private boolean fuma;
            
    private int fumaQuantosDia;

    //CONSULTAS
    
    
    //APAGADO PQ DEU ERRO;

    
    
    //EXAMES LABORATORIAIS
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataTipoSanguineo;
    
    private String resultadoTipoSanguineo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHemoglobina;
    
    private String resultadoHemoglobina;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVdrl;
    
    private String resultadoVdrl;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataUrina1;
    
    private String resultadoUrina1;
    
    @PropertyDescriptor(displayName="Data da Citologia Oncótica")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCitologiaOncotica;
    
    @PropertyDescriptor(displayName="Resultado da Citologia Oncótica")
    private String resultadoCitologiaOncotica;
    
    @PropertyDescriptor(displayName="Intercorrências e Orientações:")
    private String intercorrenciasEOrientacoes;
    
    //PATOLOGIA NA GRAVIDEZ/PARTO/PUERPÉRIO
    
    private boolean gestacaoMultipla;
            
    private boolean hipertensaoPrevia;       
    
    private boolean preEclampsia;
    
    private boolean eclampsia;
      
    
    private boolean cardiopatia;       
            
    private boolean diabetes;
            
    private boolean infeccaoUrinaria;       
    
    private boolean outrasInfeccoes;
        
    
    private boolean parasitoses;
      
    private boolean ameacaDePartoPrematuro;
            
    private boolean desproporcaiCefPelv;       
    
    private boolean hemorragiaPrimeiroTrimestre;
     
    
    private boolean hemorragiaSegundoTrimestre;
   
    private boolean hemorragiaTerceiroTrimestre;
            
    private boolean anemiaCronica;       
    
    private boolean ruturaPrematuraMemb;
    
    
    private boolean infeccaoPuerperal;
    
    private boolean hemorragiaPuerperal;
            
    private boolean outra;       
    
    private boolean nenhuma;

    //PARTO
    
        //IDADE GESTA
    private int semanas;
    
    private boolean menor37Semanas;
    
        //INICIO
    private boolean inicioEspontaneo;
    
    private boolean induzido;
    
    //TERMINAÇAO
    
    private boolean terminoEspontaneo;
    
    private boolean forceps;
    
    private boolean cesaria;
    
    private boolean terminoOutra;
    
    //NIVEL DE ATENÇAO
    
    private NivelDeAtencao nivelatencao;
    
    //
    private boolean episiotomia;
    
    private boolean laceracao;
    
    private boolean dequitEspontaneo;
    
    private boolean placentaCompleta;
    
    //ATENDEU
    
    private Cargos atendeuParto;
    
    private Cargos atendeuNeonato;
    
    //MORTE FETAL
    
    private boolean morteFetal;
    
    private Momento momentoMorteFetal;
    
    //MEDICAÇÃO NO PARTO
    
            
    private boolean anestesiaLocal;
            
    private boolean anestesiaReg;
            
    private boolean anestesiaGeral;
            
    private boolean analgesico;
            
    private boolean tranquilizante;
            
    private boolean ocitocina;
    
    private boolean antibiotico;
            
    private boolean medNoPartoOutro;
            
    private boolean medNoPartoNenhum;
    
    //RECEM NASCIDO
    
    private boolean sexo;
    
    private Rh vdrl;
            
            //APGAR
    private int apgarPrimeiro;
    
    private int apgarQuinto;
    
    private boolean seisOuMenor;
            //
    
    private boolean reanimacao;
    
    private int pesoAoNascer;
    
            //RECEM-NASCIDO>> IDADE POR EX.FISICO
    private int sem;
    
    private int menorQue37;
            //
    
    private PesoRecemNascido pesoIg;
    
    private boolean exameFisicoImediatoNormal;
    
    private int estaturRecemNascido;
    
    private int perCefRecemNascido;
    
    private boolean exameFisicoPreAltaNormal;
    
    private boolean exameNeurologicoNormal;
    
    //Patologias Recém-Nascido
    
    private boolean recemNascMHial;
            
    private boolean recemNascSAsp;
            
    private boolean recemNascOutrSdr;
            
    private boolean recemNascApneias;
            
    private boolean recemNascHemorragia;
            
    private boolean recemNascHiperb;
            
    private boolean recemNascInfeccao;
            
    private boolean recemNascNeurologica;
            
    private boolean recemNascACong;
            
    private boolean recemNascPatosOutras;
            
    private boolean recemNascPatosNenhuma;
    
    private boolean alojamentoConjunto;
            
    private AltaDoRn altaDoRn; 
            
    private int idadeAltaOuTransferencia;
    
    private int idadeAoFalecer;
    
    private Alimentacao alimentacao;
    
            //PUERPERIO
    
    private String horasOuDiasPosParto;
    
    private int temperatura;
    
    private int pressaoArterialMin;
    
    private int pressaoArterialMax;
    
    private int involUterina;
    
    private String caracteristicasDosLoquios;
    
            //
    
    private MomentoObito momentoDoObito;
    
    private AltaMaterna altaMaterna;
    
            //ORIENTACAO/CONTRACEPCAO
    private boolean camisinha;
    
    private boolean diu;
            
    private boolean oral;
            
    private boolean nenhum;
            
    private boolean ligacaoDeTrompas;
            
    private boolean ritmo;
            
    private boolean outro;

    //
     @PropertyDescriptor(displayName="Adicionar Procedimentos")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="mulherAddConsulta")
    private List<ADDConsulta> addConsulta = new ArrayList<ADDConsulta>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarConsulta() {
        ADDConsulta addCM = new ADDConsulta();
        addCM.setMulherAddConsulta(this);
        addConsulta.add(addCM);
    }

    // GETS E SETS
    public List<ADDConsulta> getAddConsulta() {
        return addConsulta;
    }

    public void setAddConsulta(List<ADDConsulta> addConsulta) {
        this.addConsulta = addConsulta;
    }
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UnidadeBasicaDeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeBasicaDeSaude ubs) {
        this.ubs = ubs;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isAfDiabetes() {
        return afDiabetes;
    }

    public void setAfDiabetes(boolean afDiabetes) {
        this.afDiabetes = afDiabetes;
    }

    public boolean isAfHiperArter() {
        return afHiperArter;
    }

    public void setAfHiperArter(boolean afHiperArter) {
        this.afHiperArter = afHiperArter;
    }

    public boolean isAfGemelares() {
        return afGemelares;
    }

    public void setAfGemelares(boolean afGemelares) {
        this.afGemelares = afGemelares;
    }

    public boolean isAfOutros() {
        return afOutros;
    }

    public void setAfOutros(boolean afOutros) {
        this.afOutros = afOutros;
    }

    public boolean isPeInfeccaoUrinar() {
        return peInfeccaoUrinar;
    }

    public void setPeInfeccaoUrinar(boolean peInfeccaoUrinar) {
        this.peInfeccaoUrinar = peInfeccaoUrinar;
    }

    public boolean isPeInfertilidade() {
        return peInfertilidade;
    }

    public void setPeInfertilidade(boolean peInfertilidade) {
        this.peInfertilidade = peInfertilidade;
    }

    public boolean isPeDiabetes() {
        return peDiabetes;
    }

    public void setPeDiabetes(boolean peDiabetes) {
        this.peDiabetes = peDiabetes;
    }

    public boolean isPeHipertenCronica() {
        return peHipertenCronica;
    }

    public void setPeHipertenCronica(boolean peHipertenCronica) {
        this.peHipertenCronica = peHipertenCronica;
    }

    public boolean isPeCirPelvicoUter() {
        return peCirPelvicoUter;
    }

    public void setPeCirPelvicoUter(boolean peCirPelvicoUter) {
        this.peCirPelvicoUter = peCirPelvicoUter;
    }

    public boolean isPeOutros() {
        return peOutros;
    }

    public void setPeOutros(boolean peOutros) {
        this.peOutros = peOutros;
    }

    public int getGestas() {
        return gestas;
    }

    public void setGestas(int gestas) {
        this.gestas = gestas;
    }

    public int getAbortos() {
        return abortos;
    }

    public void setAbortos(int abortos) {
        this.abortos = abortos;
    }

    public int getPartos() {
        return partos;
    }

    public void setPartos(int partos) {
        this.partos = partos;
    }

    public int getVaginais() {
        return vaginais;
    }

    public void setVaginais(int vaginais) {
        this.vaginais = vaginais;
    }

    public int getCesarias() {
        return cesarias;
    }

    public void setCesarias(int cesarias) {
        this.cesarias = cesarias;
    }

    public int getNascVivos() {
        return nascVivos;
    }

    public void setNascVivos(int nascVivos) {
        this.nascVivos = nascVivos;
    }

    public int getNascMortos() {
        return nascMortos;
    }

    public void setNascMortos(int nascMortos) {
        this.nascMortos = nascMortos;
    }

    public int getMortePrimeiraSemana() {
        return mortePrimeiraSemana;
    }

    public void setMortePrimeiraSemana(int mortePrimeiraSemana) {
        this.mortePrimeiraSemana = mortePrimeiraSemana;
    }

    public int getMorteDepoisPrimeiraSemana() {
        return morteDepoisPrimeiraSemana;
    }

    public void setMorteDepoisPrimeiraSemana(int morteDepoisPrimeiraSemana) {
        this.morteDepoisPrimeiraSemana = morteDepoisPrimeiraSemana;
    }

    public boolean isPesouMenos() {
        return pesouMenos;
    }

    public void setPesouMenos(boolean pesouMenos) {
        this.pesouMenos = pesouMenos;
    }

    public double getMaiorPeso() {
        return maiorPeso;
    }

    public void setMaiorPeso(double maiorPeso) {
        this.maiorPeso = maiorPeso;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getPesoAnterior() {
        return pesoAnterior;
    }

    public void setPesoAnterior(double pesoAnterior) {
        this.pesoAnterior = pesoAnterior;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public Date getDum() {
        return dum;
    }

    public void setDum(Date dum) {
        this.dum = dum;
    }

    public Date getDpp() {
        return dpp;
    }

    public void setDpp(Date dpp) {
        this.dpp = dpp;
    }

    public boolean isDuvidas() {
        return duvidas;
    }

    public void setDuvidas(boolean duvidas) {
        this.duvidas = duvidas;
    }

    public boolean isAntitetanicaPrevia() {
        return antitetanicaPrevia;
    }

    public void setAntitetanicaPrevia(boolean antitetanicaPrevia) {
        this.antitetanicaPrevia = antitetanicaPrevia;
    }

    public boolean isAntitetanicaAtualUmMes() {
        return antitetanicaAtualUmMes;
    }

    public void setAntitetanicaAtualUmMes(boolean antitetanicaAtualUmMes) {
        this.antitetanicaAtualUmMes = antitetanicaAtualUmMes;
    }

    public boolean isAntitetanicaAtualDoisMeses() {
        return antitetanicaAtualDoisMeses;
    }

    public void setAntitetanicaAtualDoisMeses(boolean antitetanicaAtualDoisMeses) {
        this.antitetanicaAtualDoisMeses = antitetanicaAtualDoisMeses;
    }

    public boolean isHospitalizacaoGravidez() {
        return hospitalizacaoGravidez;
    }

    public void setHospitalizacaoGravidez(boolean hospitalizacaoGravidez) {
        this.hospitalizacaoGravidez = hospitalizacaoGravidez;
    }

    public int getDiasHospitalizacao() {
        return diasHospitalizacao;
    }

    public void setDiasHospitalizacao(int diasHospitalizacao) {
        this.diasHospitalizacao = diasHospitalizacao;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Rh getRh() {
        return rh;
    }

    public void setRh(Rh rh) {
        this.rh = rh;
    }

    public boolean isSensibilidade() {
        return sensibilidade;
    }

    public void setSensibilidade(boolean sensibilidade) {
        this.sensibilidade = sensibilidade;
    }

    public boolean isTransferida() {
        return transferida;
    }

    public void setTransferida(boolean transferida) {
        this.transferida = transferida;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public String getLocalTransferencia() {
        return localTransferencia;
    }

    public void setLocalTransferencia(String localTransferencia) {
        this.localTransferencia = localTransferencia;
    }

    public boolean isExameClinicoNormal() {
        return exameClinicoNormal;
    }

    public void setExameClinicoNormal(boolean exameClinicoNormal) {
        this.exameClinicoNormal = exameClinicoNormal;
    }

    public boolean isExameMamasNormal() {
        return exameMamasNormal;
    }

    public void setExameMamasNormal(boolean exameMamasNormal) {
        this.exameMamasNormal = exameMamasNormal;
    }

    public boolean isExameOdontologicoNormal() {
        return exameOdontologicoNormal;
    }

    public void setExameOdontologicoNormal(boolean exameOdontologicoNormal) {
        this.exameOdontologicoNormal = exameOdontologicoNormal;
    }

    public boolean isPelvisNormal() {
        return pelvisNormal;
    }

    public void setPelvisNormal(boolean pelvisNormal) {
        this.pelvisNormal = pelvisNormal;
    }

    public boolean isPapanicolauNormal() {
        return papanicolauNormal;
    }

    public void setPapanicolauNormal(boolean papanicolauNormal) {
        this.papanicolauNormal = papanicolauNormal;
    }

    public boolean isColposcopiaNormal() {
        return colposcopiaNormal;
    }

    public void setColposcopiaNormal(boolean colposcopiaNormal) {
        this.colposcopiaNormal = colposcopiaNormal;
    }

    public boolean isExameClinicoCervix() {
        return exameClinicoCervix;
    }

    public void setExameClinicoCervix(boolean exameClinicoCervix) {
        this.exameClinicoCervix = exameClinicoCervix;
    }

    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public int getFumaQuantosDia() {
        return fumaQuantosDia;
    }

    public void setFumaQuantosDia(int fumaQuantosDia) {
        this.fumaQuantosDia = fumaQuantosDia;
    }

    public Date getDataTipoSanguineo() {
        return dataTipoSanguineo;
    }

    public void setDataTipoSanguineo(Date dataTipoSanguineo) {
        this.dataTipoSanguineo = dataTipoSanguineo;
    }

    public String getResultadoTipoSanguineo() {
        return resultadoTipoSanguineo;
    }

    public void setResultadoTipoSanguineo(String resultadoTipoSanguineo) {
        this.resultadoTipoSanguineo = resultadoTipoSanguineo;
    }

    public Date getDataHemoglobina() {
        return dataHemoglobina;
    }

    public void setDataHemoglobina(Date dataHemoglobina) {
        this.dataHemoglobina = dataHemoglobina;
    }

    public String getResultadoHemoglobina() {
        return resultadoHemoglobina;
    }

    public void setResultadoHemoglobina(String resultadoHemoglobina) {
        this.resultadoHemoglobina = resultadoHemoglobina;
    }

    public Date getDataVdrl() {
        return dataVdrl;
    }

    public void setDataVdrl(Date dataVdrl) {
        this.dataVdrl = dataVdrl;
    }

    public String getResultadoVdrl() {
        return resultadoVdrl;
    }

    public void setResultadoVdrl(String resultadoVdrl) {
        this.resultadoVdrl = resultadoVdrl;
    }

    public Date getDataUrina1() {
        return dataUrina1;
    }

    public void setDataUrina1(Date dataUrina1) {
        this.dataUrina1 = dataUrina1;
    }

    public String getResultadoUrina1() {
        return resultadoUrina1;
    }

    public void setResultadoUrina1(String resultadoUrina1) {
        this.resultadoUrina1 = resultadoUrina1;
    }

    public Date getDataCitologiaOncotica() {
        return dataCitologiaOncotica;
    }

    public void setDataCitologiaOncotica(Date dataCitologiaOncotica) {
        this.dataCitologiaOncotica = dataCitologiaOncotica;
    }

    public String getResultadoCitologiaOncotica() {
        return resultadoCitologiaOncotica;
    }

    public void setResultadoCitologiaOncotica(String resultadoCitologiaOncotica) {
        this.resultadoCitologiaOncotica = resultadoCitologiaOncotica;
    }

    public String getIntercorrenciasEOrientacoes() {
        return intercorrenciasEOrientacoes;
    }

    public void setIntercorrenciasEOrientacoes(String intercorrenciasEOrientacoes) {
        this.intercorrenciasEOrientacoes = intercorrenciasEOrientacoes;
    }

    public boolean isGestacaoMultipla() {
        return gestacaoMultipla;
    }

    public void setGestacaoMultipla(boolean gestacaoMultipla) {
        this.gestacaoMultipla = gestacaoMultipla;
    }

    public boolean isHipertensaoPrevia() {
        return hipertensaoPrevia;
    }

    public void setHipertensaoPrevia(boolean hipertensaoPrevia) {
        this.hipertensaoPrevia = hipertensaoPrevia;
    }

    public boolean isPreEclampsia() {
        return preEclampsia;
    }

    public void setPreEclampsia(boolean preEclampsia) {
        this.preEclampsia = preEclampsia;
    }

    public boolean isEclampsia() {
        return eclampsia;
    }

    public void setEclampsia(boolean eclampsia) {
        this.eclampsia = eclampsia;
    }

    public boolean isCardiopatia() {
        return cardiopatia;
    }

    public void setCardiopatia(boolean cardiopatia) {
        this.cardiopatia = cardiopatia;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isInfeccaoUrinaria() {
        return infeccaoUrinaria;
    }

    public void setInfeccaoUrinaria(boolean infeccaoUrinaria) {
        this.infeccaoUrinaria = infeccaoUrinaria;
    }

    public boolean isOutrasInfeccoes() {
        return outrasInfeccoes;
    }

    public void setOutrasInfeccoes(boolean outrasInfeccoes) {
        this.outrasInfeccoes = outrasInfeccoes;
    }

    public boolean isParasitoses() {
        return parasitoses;
    }

    public void setParasitoses(boolean parasitoses) {
        this.parasitoses = parasitoses;
    }

    public boolean isAmeacaDePartoPrematuro() {
        return ameacaDePartoPrematuro;
    }

    public void setAmeacaDePartoPrematuro(boolean ameacaDePartoPrematuro) {
        this.ameacaDePartoPrematuro = ameacaDePartoPrematuro;
    }

    public boolean isDesproporcaiCefPelv() {
        return desproporcaiCefPelv;
    }

    public void setDesproporcaiCefPelv(boolean desproporcaiCefPelv) {
        this.desproporcaiCefPelv = desproporcaiCefPelv;
    }

    public boolean isHemorragiaPrimeiroTrimestre() {
        return hemorragiaPrimeiroTrimestre;
    }

    public void setHemorragiaPrimeiroTrimestre(boolean hemorragiaPrimeiroTrimestre) {
        this.hemorragiaPrimeiroTrimestre = hemorragiaPrimeiroTrimestre;
    }

    public boolean isHemorragiaSegundoTrimestre() {
        return hemorragiaSegundoTrimestre;
    }

    public void setHemorragiaSegundoTrimestre(boolean hemorragiaSegundoTrimestre) {
        this.hemorragiaSegundoTrimestre = hemorragiaSegundoTrimestre;
    }

    public boolean isHemorragiaTerceiroTrimestre() {
        return hemorragiaTerceiroTrimestre;
    }

    public void setHemorragiaTerceiroTrimestre(boolean hemorragiaTerceiroTrimestre) {
        this.hemorragiaTerceiroTrimestre = hemorragiaTerceiroTrimestre;
    }

    public boolean isAnemiaCronica() {
        return anemiaCronica;
    }

    public void setAnemiaCronica(boolean anemiaCronica) {
        this.anemiaCronica = anemiaCronica;
    }

    public boolean isRuturaPrematuraMemb() {
        return ruturaPrematuraMemb;
    }

    public void setRuturaPrematuraMemb(boolean ruturaPrematuraMemb) {
        this.ruturaPrematuraMemb = ruturaPrematuraMemb;
    }

    public boolean isInfeccaoPuerperal() {
        return infeccaoPuerperal;
    }

    public void setInfeccaoPuerperal(boolean infeccaoPuerperal) {
        this.infeccaoPuerperal = infeccaoPuerperal;
    }

    public boolean isHemorragiaPuerperal() {
        return hemorragiaPuerperal;
    }

    public void setHemorragiaPuerperal(boolean hemorragiaPuerperal) {
        this.hemorragiaPuerperal = hemorragiaPuerperal;
    }

    public boolean isOutra() {
        return outra;
    }

    public void setOutra(boolean outra) {
        this.outra = outra;
    }

    public boolean isNenhuma() {
        return nenhuma;
    }

    public void setNenhuma(boolean nenhuma) {
        this.nenhuma = nenhuma;
    }

    public int getSemanas() {
        return semanas;
    }

    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }

    public boolean isMenor37Semanas() {
        return menor37Semanas;
    }

    public void setMenor37Semanas(boolean menor37Semanas) {
        this.menor37Semanas = menor37Semanas;
    }

    public boolean isInicioEspontaneo() {
        return inicioEspontaneo;
    }

    public void setInicioEspontaneo(boolean inicioEspontaneo) {
        this.inicioEspontaneo = inicioEspontaneo;
    }

    public boolean isInduzido() {
        return induzido;
    }

    public void setInduzido(boolean induzido) {
        this.induzido = induzido;
    }

    public boolean isTerminoEspontaneo() {
        return terminoEspontaneo;
    }

    public void setTerminoEspontaneo(boolean terminoEspontaneo) {
        this.terminoEspontaneo = terminoEspontaneo;
    }

    public boolean isForceps() {
        return forceps;
    }

    public void setForceps(boolean forceps) {
        this.forceps = forceps;
    }

    public boolean isCesaria() {
        return cesaria;
    }

    public void setCesaria(boolean cesaria) {
        this.cesaria = cesaria;
    }

    public boolean isTerminoOutra() {
        return terminoOutra;
    }

    public void setTerminoOutra(boolean terminoOutra) {
        this.terminoOutra = terminoOutra;
    }

    public NivelDeAtencao getNivelatencao() {
        return nivelatencao;
    }

    public void setNivelatencao(NivelDeAtencao nivelatencao) {
        this.nivelatencao = nivelatencao;
    }

    public boolean isEpisiotomia() {
        return episiotomia;
    }

    public void setEpisiotomia(boolean episiotomia) {
        this.episiotomia = episiotomia;
    }

    public boolean isLaceracao() {
        return laceracao;
    }

    public void setLaceracao(boolean laceracao) {
        this.laceracao = laceracao;
    }

    public boolean isDequitEspontaneo() {
        return dequitEspontaneo;
    }

    public void setDequitEspontaneo(boolean dequitEspontaneo) {
        this.dequitEspontaneo = dequitEspontaneo;
    }

    public boolean isPlacentaCompleta() {
        return placentaCompleta;
    }

    public void setPlacentaCompleta(boolean placentaCompleta) {
        this.placentaCompleta = placentaCompleta;
    }

    public Cargos getAtendeuParto() {
        return atendeuParto;
    }

    public void setAtendeuParto(Cargos atendeuParto) {
        this.atendeuParto = atendeuParto;
    }

    public Cargos getAtendeuNeonato() {
        return atendeuNeonato;
    }

    public void setAtendeuNeonato(Cargos atendeuNeonato) {
        this.atendeuNeonato = atendeuNeonato;
    }

    public boolean isMorteFetal() {
        return morteFetal;
    }

    public void setMorteFetal(boolean morteFetal) {
        this.morteFetal = morteFetal;
    }

    public Momento getMomentoMorteFetal() {
        return momentoMorteFetal;
    }

    public void setMomentoMorteFetal(Momento momentoMorteFetal) {
        this.momentoMorteFetal = momentoMorteFetal;
    }

    public boolean isAnestesiaLocal() {
        return anestesiaLocal;
    }

    public void setAnestesiaLocal(boolean anestesiaLocal) {
        this.anestesiaLocal = anestesiaLocal;
    }

    public boolean isAnestesiaReg() {
        return anestesiaReg;
    }

    public void setAnestesiaReg(boolean anestesiaReg) {
        this.anestesiaReg = anestesiaReg;
    }

    public boolean isAnestesiaGeral() {
        return anestesiaGeral;
    }

    public void setAnestesiaGeral(boolean anestesiaGeral) {
        this.anestesiaGeral = anestesiaGeral;
    }

    public boolean isAnalgesico() {
        return analgesico;
    }

    public void setAnalgesico(boolean analgesico) {
        this.analgesico = analgesico;
    }

    public boolean isTranquilizante() {
        return tranquilizante;
    }

    public void setTranquilizante(boolean tranquilizante) {
        this.tranquilizante = tranquilizante;
    }

    public boolean isOcitocina() {
        return ocitocina;
    }

    public void setOcitocina(boolean ocitocina) {
        this.ocitocina = ocitocina;
    }

    public boolean isAntibiotico() {
        return antibiotico;
    }

    public void setAntibiotico(boolean antibiotico) {
        this.antibiotico = antibiotico;
    }

    public boolean isMedNoPartoOutro() {
        return medNoPartoOutro;
    }

    public void setMedNoPartoOutro(boolean medNoPartoOutro) {
        this.medNoPartoOutro = medNoPartoOutro;
    }

    public boolean isMedNoPartoNenhum() {
        return medNoPartoNenhum;
    }

    public void setMedNoPartoNenhum(boolean medNoPartoNenhum) {
        this.medNoPartoNenhum = medNoPartoNenhum;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Rh getVdrl() {
        return vdrl;
    }

    public void setVdrl(Rh vdrl) {
        this.vdrl = vdrl;
    }

    public int getApgarPrimeiro() {
        return apgarPrimeiro;
    }

    public void setApgarPrimeiro(int apgarPrimeiro) {
        this.apgarPrimeiro = apgarPrimeiro;
    }

    public int getApgarQuinto() {
        return apgarQuinto;
    }

    public void setApgarQuinto(int apgarQuinto) {
        this.apgarQuinto = apgarQuinto;
    }

    public boolean isSeisOuMenor() {
        return seisOuMenor;
    }

    public void setSeisOuMenor(boolean seisOuMenor) {
        this.seisOuMenor = seisOuMenor;
    }

    public boolean isReanimacao() {
        return reanimacao;
    }

    public void setReanimacao(boolean reanimacao) {
        this.reanimacao = reanimacao;
    }

    public int getPesoAoNascer() {
        return pesoAoNascer;
    }

    public void setPesoAoNascer(int pesoAoNascer) {
        this.pesoAoNascer = pesoAoNascer;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public int getMenorQue37() {
        return menorQue37;
    }

    public void setMenorQue37(int menorQue37) {
        this.menorQue37 = menorQue37;
    }

    public PesoRecemNascido getPesoIg() {
        return pesoIg;
    }

    public void setPesoIg(PesoRecemNascido pesoIg) {
        this.pesoIg = pesoIg;
    }

    public boolean isExameFisicoImediatoNormal() {
        return exameFisicoImediatoNormal;
    }

    public void setExameFisicoImediatoNormal(boolean exameFisicoImediatoNormal) {
        this.exameFisicoImediatoNormal = exameFisicoImediatoNormal;
    }

    public int getEstaturRecemNascido() {
        return estaturRecemNascido;
    }

    public void setEstaturRecemNascido(int estaturRecemNascido) {
        this.estaturRecemNascido = estaturRecemNascido;
    }

    public int getPerCefRecemNascido() {
        return perCefRecemNascido;
    }

    public void setPerCefRecemNascido(int perCefRecemNascido) {
        this.perCefRecemNascido = perCefRecemNascido;
    }

    public boolean isExameFisicoPreAltaNormal() {
        return exameFisicoPreAltaNormal;
    }

    public void setExameFisicoPreAltaNormal(boolean exameFisicoPreAltaNormal) {
        this.exameFisicoPreAltaNormal = exameFisicoPreAltaNormal;
    }

    public boolean isExameNeurologicoNormal() {
        return exameNeurologicoNormal;
    }

    public void setExameNeurologicoNormal(boolean exameNeurologicoNormal) {
        this.exameNeurologicoNormal = exameNeurologicoNormal;
    }

    public boolean isRecemNascMHial() {
        return recemNascMHial;
    }

    public void setRecemNascMHial(boolean recemNascMHial) {
        this.recemNascMHial = recemNascMHial;
    }

    public boolean isRecemNascSAsp() {
        return recemNascSAsp;
    }

    public void setRecemNascSAsp(boolean recemNascSAsp) {
        this.recemNascSAsp = recemNascSAsp;
    }

    public boolean isRecemNascOutrSdr() {
        return recemNascOutrSdr;
    }

    public void setRecemNascOutrSdr(boolean recemNascOutrSdr) {
        this.recemNascOutrSdr = recemNascOutrSdr;
    }

    public boolean isRecemNascApneias() {
        return recemNascApneias;
    }

    public void setRecemNascApneias(boolean recemNascApneias) {
        this.recemNascApneias = recemNascApneias;
    }

    public boolean isRecemNascHemorragia() {
        return recemNascHemorragia;
    }

    public void setRecemNascHemorragia(boolean recemNascHemorragia) {
        this.recemNascHemorragia = recemNascHemorragia;
    }

    public boolean isRecemNascHiperb() {
        return recemNascHiperb;
    }

    public void setRecemNascHiperb(boolean recemNascHiperb) {
        this.recemNascHiperb = recemNascHiperb;
    }

    public boolean isRecemNascInfeccao() {
        return recemNascInfeccao;
    }

    public void setRecemNascInfeccao(boolean recemNascInfeccao) {
        this.recemNascInfeccao = recemNascInfeccao;
    }

    public boolean isRecemNascNeurologica() {
        return recemNascNeurologica;
    }

    public void setRecemNascNeurologica(boolean recemNascNeurologica) {
        this.recemNascNeurologica = recemNascNeurologica;
    }

    public boolean isRecemNascACong() {
        return recemNascACong;
    }

    public void setRecemNascACong(boolean recemNascACong) {
        this.recemNascACong = recemNascACong;
    }

    public boolean isRecemNascPatosOutras() {
        return recemNascPatosOutras;
    }

    public void setRecemNascPatosOutras(boolean recemNascPatosOutras) {
        this.recemNascPatosOutras = recemNascPatosOutras;
    }

    public boolean isRecemNascPatosNenhuma() {
        return recemNascPatosNenhuma;
    }

    public void setRecemNascPatosNenhuma(boolean recemNascPatosNenhuma) {
        this.recemNascPatosNenhuma = recemNascPatosNenhuma;
    }

    public boolean isAlojamentoConjunto() {
        return alojamentoConjunto;
    }

    public void setAlojamentoConjunto(boolean alojamentoConjunto) {
        this.alojamentoConjunto = alojamentoConjunto;
    }

    public AltaDoRn getAltaDoRn() {
        return altaDoRn;
    }

    public void setAltaDoRn(AltaDoRn altaDoRn) {
        this.altaDoRn = altaDoRn;
    }

    public int getIdadeAltaOuTransferencia() {
        return idadeAltaOuTransferencia;
    }

    public void setIdadeAltaOuTransferencia(int idadeAltaOuTransferencia) {
        this.idadeAltaOuTransferencia = idadeAltaOuTransferencia;
    }

    public int getIdadeAoFalecer() {
        return idadeAoFalecer;
    }

    public void setIdadeAoFalecer(int idadeAoFalecer) {
        this.idadeAoFalecer = idadeAoFalecer;
    }

    public Alimentacao getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(Alimentacao alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getHorasOuDiasPosParto() {
        return horasOuDiasPosParto;
    }

    public void setHorasOuDiasPosParto(String horasOuDiasPosParto) {
        this.horasOuDiasPosParto = horasOuDiasPosParto;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getPressaoArterialMin() {
        return pressaoArterialMin;
    }

    public void setPressaoArterialMin(int pressaoArterialMin) {
        this.pressaoArterialMin = pressaoArterialMin;
    }

    public int getPressaoArterialMax() {
        return pressaoArterialMax;
    }

    public void setPressaoArterialMax(int pressaoArterialMax) {
        this.pressaoArterialMax = pressaoArterialMax;
    }

    public int getInvolUterina() {
        return involUterina;
    }

    public void setInvolUterina(int involUterina) {
        this.involUterina = involUterina;
    }

    public String getCaracteristicasDosLoquios() {
        return caracteristicasDosLoquios;
    }

    public void setCaracteristicasDosLoquios(String caracteristicasDosLoquios) {
        this.caracteristicasDosLoquios = caracteristicasDosLoquios;
    }

    public MomentoObito getMomentoDoObito() {
        return momentoDoObito;
    }

    public void setMomentoDoObito(MomentoObito momentoDoObito) {
        this.momentoDoObito = momentoDoObito;
    }

    public AltaMaterna getAltaMaterna() {
        return altaMaterna;
    }

    public void setAltaMaterna(AltaMaterna altaMaterna) {
        this.altaMaterna = altaMaterna;
    }

    public boolean isCamisinha() {
        return camisinha;
    }

    public void setCamisinha(boolean camisinha) {
        this.camisinha = camisinha;
    }

    public boolean isDiu() {
        return diu;
    }

    public void setDiu(boolean diu) {
        this.diu = diu;
    }

    public boolean isOral() {
        return oral;
    }

    public void setOral(boolean oral) {
        this.oral = oral;
    }

    public boolean isNenhum() {
        return nenhum;
    }

    public void setNenhum(boolean nenhum) {
        this.nenhum = nenhum;
    }

    public boolean isLigacaoDeTrompas() {
        return ligacaoDeTrompas;
    }

    public void setLigacaoDeTrompas(boolean ligacaoDeTrompas) {
        this.ligacaoDeTrompas = ligacaoDeTrompas;
    }

    public boolean isRitmo() {
        return ritmo;
    }

    public void setRitmo(boolean ritmo) {
        this.ritmo = ritmo;
    }

    public boolean isOutro() {
        return outro;
    }

    public void setOutro(boolean outro) {
        this.outro = outro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final SaudeDaMulher other = (SaudeDaMulher) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
