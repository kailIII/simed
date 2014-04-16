/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author user
 */


@Entity
@Views({
            @View(
            name = "Hanseniase", title = "Notificação de Hanseniase",
            filters = "Pesquisar Por:[pacienteHanseniase, Ctrl.DAO.filter()]",
            members = "["
            + "Dados Gerais[tipoDeNotificacao:2;agravoDoenca;dataDaNotificacao,uf;municipio;unidadeDeSaude;dataDoDiagnostico];"
            + "Notificação Individual[pacienteHanseniase,gestante;cor;escolaridade;numeroCartaoSUS;nomeMae];"
            + "Dados de Residência[ufResidencia,municipioResidencia;distrito;bairro;logradouro;numero;complemento;pontoReferencia;cep;telefone;zona;pais;Localização Geográfica[latitude;longitude]];"
            + "Dados Complementares do Caso[ "  
            + "Ocupação[numeroProntuario,ocupacao]:2;"
            + "Dados Clínicos[numeroLesoes,formaClinica;classificacaoOperacional;numeroNervosAfetados]:2;"
            + "Atendimento[avaliacaoGrauIncapacidadeFisica;modoEntrada;modoDeteccaoCasoNovo];"
            + "Dados Laboratoriais[baciloscopia];"
            + "Tratamento[dataInicioTratamento;esquemaTerapeutico],"
            + "Med. Contr.[numeroContatos];"
            + "observacoesAdd;"       
            + "];" 
            
            + "]",
            
            template = "@CRUD+@PAGER",
            roles = "Administrador, Atendente, AgenteDeSaude")})

public class Hanseniase implements Serializable{
    
    public enum UF{ CE, AC, AL, AM, BA,  DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO}
    public enum Gestante {Não,PrimeiroTrimestre, SegundoTrimestre, TerceiroTrimestre, IdadeGestacionalIgnorada, NãoSeAplica, Ignorado}
    public enum Cor{Branca, Preta, Amarela, Parda, Indígena, Ignorado}
    public enum Escolaridade{Analfabeto, PrimeiraAQuartaSerieIncompletaEF, QuartaSerieCompletaEF, QuintaAOitavaSerieIncompleta, EnsinoFundamentalCompleto, EnsinoMedioIncompleto, EnsinoMedioCompleto, EducaçãoSuperiorIncompleta, EducaçãoSuperiorCompleta, Ignorado, NãoSeAplica}
    public enum Zona{Urbana, Rural, Periurbana, Ignorado}
    public enum FormaClinica{I, T, D, V, NãoClassificado}
    public enum ClassificacaoOperacional{PB,MB}
    public enum AvaliacaoGrauIncapacidadeFisica {GrauZero, GrauI, GrauII, NãoAvaliado}
    public enum ModoEntrada{CasoNovo, TransferênciaDoMesmoMunicípio, TransferênciaDeOutroMunicipio, TransferenciaDeOutroEstado, TransferenciaDeOutroPais, Recidiva, OutrosReingressos, Ignorado}
    public enum ModoDeteccaoCasoNovo{Encaminhamento, DemandaEspontânea, ExameDeColetividade, ExameDeContatos, OutrosModos, Ignorado}
    public enum Baciloscopia{Positiva, Negativa, NãoRealizada, Ignorado}
    public enum EsquemaTerapeutico{PQT_PB_6doses, PQT_MB_12doses, OutrosEsquemasSubstitutos}
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private int id;
    
    @PropertyDescriptor(index=1, displayName="Tipo de Notificação", autoFilter=true )
    private String tipoDeNotificacao;
    
    @PropertyDescriptor(index=2, displayName="Agravo/doença", autoFilter=true )
    private String agravoDoenca;
    
    @Past
    @PropertyDescriptor(index=3,displayName="Data da Notificação")
    @NotNull(message = "Informe a data da notificação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDaNotificacao;
    
    @PropertyDescriptor(index=4, displayName="UF")
    @NotNull(message="Informe a Unidade Federativa do Estado")
    private UF uf;
    
    @PropertyDescriptor(index=5, displayName="Município de Notificação")
    @NotEmpty(message="Informe o Município de Notificação!")
    private String municipio;
        
    @NotNull
    @ManyToOne
    @PropertyDescriptor(displayName="Unidade de Saúde (ou outra fonte notificadora)")
    private UnidadeBasicaDeSaude unidadeDeSaude;
            
    @Past
    @PropertyDescriptor(index=9,displayName="Data do Diagnóstico")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDoDiagnostico;
    
    @NotNull
    @ManyToOne
    @PropertyDescriptor(displayName="Nome do Paciente")
    private Paciente pacienteHanseniase;
             
    @PropertyDescriptor(index=10, displayName="Gestante")
    private Gestante gestante;
    
    @PropertyDescriptor(index=11, displayName="Raça/Cor")
    private Cor cor;
    
    @PropertyDescriptor(index=12, displayName="Escolaridade")
    private Escolaridade escolaridade;
    
    @Column(length=15)
    @PropertyDescriptor(index=13,displayName="Número do Cartão SUS", mask="999999999999999")
    private String numeroCartaoSUS;
    
    @PropertyDescriptor(index=14, displayName="Nome da mãe")
    private String nomeMae;
    
    @PropertyDescriptor(index=15, displayName="UF")
    private UF ufResidencia;
    
    @PropertyDescriptor(index=16, displayName="Município de Residência")
    private String municipioResidencia;
    
    @PropertyDescriptor(index=17, displayName="Distrito")
    private String distrito;
    
    @PropertyDescriptor(index=18, displayName="Bairro")
    private String bairro;
    
    @PropertyDescriptor(index=19, displayName="Logradouro (rua,avenida,...)")
    private String logradouro;
    
    @PropertyDescriptor(index=20, displayName="Numero")  
    private Integer numero;
    
    @PropertyDescriptor(index=21, displayName="Complemento (apto, casa,...)")
    private String complemento;
    
    @Column(scale = 6 ,precision = 2)
    @PropertyDescriptor(displayName="Latitude da Ocorrência")
    private float latitude;
    
    @Column(scale = 6 ,precision = 2)
    @PropertyDescriptor(displayName="Longitude da Ocorrência")
    private float longitude;
    
    @PropertyDescriptor(index=24, displayName="Ponto de Referência")
    private String pontoReferencia;
    
    @Column(length=8)
    @PropertyDescriptor(index=25,displayName="CEP", mask="99999-999")
    private String cep;
    
    @Column(length=13)
    @PropertyDescriptor(index=26, displayName="(DDD) Telefone", mask="(99)9999-9999")
    private String telefone;
    
    @PropertyDescriptor(index=27, displayName="Zona")
    private Zona zona;
    
    @PropertyDescriptor(index=28, displayName="País (se residente fora do Brasil)")
    private String pais;
    
    @PropertyDescriptor(index=29, displayName="Nº do Prontuário")  
    private Integer numeroProntuario;
    
    @PropertyDescriptor(index=30, displayName="Ocupação")
    private String ocupacao;
    
    @PropertyDescriptor(index=31, displayName="Nº de Lesões Cutâneas")  
    private Integer numeroLesoes;
    
    @PropertyDescriptor(index=32, displayName="Forma Clínica")
    private FormaClinica formaClinica;
    
    @PropertyDescriptor(index=33, displayName="Classificação Operacional")
    private ClassificacaoOperacional classificacaoOperacional;
    
    @PropertyDescriptor(index=34, displayName="Nº de Nervos afetados")  
    private Integer numeroNervosAfetados;
    
    @PropertyDescriptor(index=35, displayName="Avaliação do Grau de Incapacidade Física no Diagnóstico")
    private AvaliacaoGrauIncapacidadeFisica avaliacaoGrauIncapacidadeFisica;
    
    @PropertyDescriptor(index=36, displayName="Modo de Entrada")
    private ModoEntrada modoEntrada;
    
    @PropertyDescriptor(index=37, displayName="Modo de Detecção do Caso Novo")
    private ModoDeteccaoCasoNovo modoDeteccaoCasoNovo;
    
    @PropertyDescriptor(index=38, displayName="Baciloscopia")
    private Baciloscopia baciloscopia;
    
    @Past
    @PropertyDescriptor(index=39,displayName="Data do Início do Tratamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicioTratamento;
    
    @PropertyDescriptor(index=40, displayName="Esquema Terapêutico Inicial")
    private EsquemaTerapeutico esquemaTerapeutico;
            
    @PropertyDescriptor(index=41, displayName="Nº de Contatos Registrados")  
    private Integer numeroContatos;
    
    @Lob
    @PropertyDescriptor(index = 42, displayName="Observações adicionais")
    private String observacoesAdd;

    
    public UnidadeBasicaDeSaude getUnidadeDeSaude() {
        return unidadeDeSaude;
    }

    public void setUnidadeDeSaude(UnidadeBasicaDeSaude unidadeDeSaude) {
        this.unidadeDeSaude = unidadeDeSaude;
    }
      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPacienteHanseniase() {
        return pacienteHanseniase;
    }

    public void setPacienteHanseniase(Paciente pacienteHanseniase) {
        this.pacienteHanseniase = pacienteHanseniase;
    }

    public Gestante getGestante() {
        return gestante;
    }

    public void setGestante(Gestante gestante) {
        this.gestante = gestante;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getNumeroCartaoSUS() {
        return numeroCartaoSUS;
    }

    public void setNumeroCartaoSUS(String numeroCartaoSUS) {
        this.numeroCartaoSUS = numeroCartaoSUS;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public UF getUfResidencia() {
        return ufResidencia;
    }

    public void setUfResidencia(UF ufResidencia) {
        this.ufResidencia = ufResidencia;
    }

    public String getMunicipioResidencia() {
        return municipioResidencia;
    }

    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getNumeroProntuario() {
        return numeroProntuario;
    }

    public void setNumeroProntuario(Integer numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Integer getNumeroLesoes() {
        return numeroLesoes;
    }

    public void setNumeroLesoes(Integer numeroLesoes) {
        this.numeroLesoes = numeroLesoes;
    }

    public FormaClinica getFormaClinica() {
        return formaClinica;
    }

    public void setFormaClinica(FormaClinica formaClinica) {
        this.formaClinica = formaClinica;
    }

    public ClassificacaoOperacional getClassificacaoOperacional() {
        return classificacaoOperacional;
    }

    public void setClassificacaoOperacional(ClassificacaoOperacional classificacaoOperacional) {
        this.classificacaoOperacional = classificacaoOperacional;
    }

    public Integer getNumeroNervosAfetados() {
        return numeroNervosAfetados;
    }

    public void setNumeroNervosAfetados(Integer numeroNervosAfetados) {
        this.numeroNervosAfetados = numeroNervosAfetados;
    }

    public AvaliacaoGrauIncapacidadeFisica getAvaliacaoGrauIncapacidadeFisica() {
        return avaliacaoGrauIncapacidadeFisica;
    }

    public void setAvaliacaoGrauIncapacidadeFisica(AvaliacaoGrauIncapacidadeFisica avaliacaoGrauIncapacidadeFisica) {
        this.avaliacaoGrauIncapacidadeFisica = avaliacaoGrauIncapacidadeFisica;
    }

    public ModoEntrada getModoEntrada() {
        return modoEntrada;
    }

    public void setModoEntrada(ModoEntrada modoEntrada) {
        this.modoEntrada = modoEntrada;
    }

    public ModoDeteccaoCasoNovo getModoDeteccaoCasoNovo() {
        return modoDeteccaoCasoNovo;
    }

    public void setModoDeteccaoCasoNovo(ModoDeteccaoCasoNovo modoDeteccaoCasoNovo) {
        this.modoDeteccaoCasoNovo = modoDeteccaoCasoNovo;
    }

    public Baciloscopia getBaciloscopia() {
        return baciloscopia;
    }

    public void setBaciloscopia(Baciloscopia baciloscopia) {
        this.baciloscopia = baciloscopia;
    }

    public Date getDataInicioTratamento() {
        return dataInicioTratamento;
    }

    public void setDataInicioTratamento(Date dataInicioTratamento) {
        this.dataInicioTratamento = dataInicioTratamento;
    }

    public EsquemaTerapeutico getEsquemaTerapeutico() {
        return esquemaTerapeutico;
    }

    public void setEsquemaTerapeutico(EsquemaTerapeutico esquemaTerapeutico) {
        this.esquemaTerapeutico = esquemaTerapeutico;
    }

    public Integer getNumeroContatos() {
        return numeroContatos;
    }

    public void setNumeroContatos(Integer numeroContatos) {
        this.numeroContatos = numeroContatos;
    }

    public String getObservacoesAdd() {
        return observacoesAdd;
    }

    public void setObservacoesAdd(String observacoesAdd) {
        this.observacoesAdd = observacoesAdd;
    }
    
    

    public String getTipoDeNotificacao() {
        return tipoDeNotificacao;
    }

    public void setTipoDeNotificacao(String tipoDeNotificacao) {
        this.tipoDeNotificacao = tipoDeNotificacao;
    }

    public String getAgravoDoenca() {
        return agravoDoenca;
    }

    public void setAgravoDoenca(String agravoDoenca) {
        this.agravoDoenca = agravoDoenca;
    }

    public Date getDataDaNotificacao() {
        return dataDaNotificacao;
    }

    public void setDataDaNotificacao(Date dataDaNotificacao) {
        this.dataDaNotificacao = dataDaNotificacao;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Date getDataDoDiagnostico() {
        return dataDoDiagnostico;
    }

    public void setDataDoDiagnostico(Date dataDoDiagnostico) {
        this.dataDoDiagnostico = dataDoDiagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
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
        final Hanseniase other = (Hanseniase) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    

    @Override
    public String toString() {
        return pacienteHanseniase.getNomePaciente();
    }
    
    
    
}
