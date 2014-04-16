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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author NicolasMoura
 */

@Entity
@Views({
    @View(
        name = "Tuberculose", title = "Notificação de Tuberculose",
        filters = "Pesquisar Por:[pacienteTuberculose, Ctrl.DAO.filter()]",
            members = "["
              + "Dados Gerais[Notificação Individual[dataDaNotificacao;municipioNotificacao;unidadeDeSaude;Localização Geográfica[latitude;longitude]]];"
              + "Dados do Caso[Tuberculose[pacienteTuberculose;dataDoDiagnostico;idade;cor;escolaridade;numeroCartaoSUS;]];"
              + "Antecedentes Epidemiologicos[numeroProntuario;ocupacao;tipoEntrada;];"
              + "Dados Clinicos[raioXTorax,forma;testeTuberculinico,seExtrapulmonar;agravosAssociados;];"
              + "Dados Do Laboratorio[baciloscopiaEscarro,baciloscopiaDeOutroMaterial;culturaEscarro,culturaOutroMaterial;"
              + "hiv,histopatologia;];"
              + "Tratamento[dataInicioTratamento;tratamentoSupervisionado;doencaTrabalho;"
              + "Drogas[rifampicina;isoniazida;pirazinamida;etambutol;estreptomicina;etionamida;outrasDrogas]];"
              + "Investigador[nomeInvestigador,municipoInvestigador;funcaoInvestigador];"
              + "]",
            
            template = "@CRUD+@PAGER",
            roles = "Administrador, Atendente, AgenteDeSaude")
})

public class Tuberculose implements Serializable{
    
    public enum TipoEntrada{Caso_Novo,Recidiva,Reingresso_Apos_Abandono,Nao_Sabe,Transferencia}
    public enum RaioX{Suspeito,Normal,Outra_Patologia,Nao_Realizado}
    public enum TesteTuberculinico{Nao_Reator,Reator_Fraco,Reator_Forte,Nao_Realizado}
    public enum Forma{Pulmonar,Extrapulmonar,Pulmonar_e_Extrapulmonar}
    public enum SeExtraPulmonar {Pleural,Gang_Perif,Genituriario,Ossea,Ocular,Miliar,Menigite,Outras,Nao_Se_Aplica}
    public enum AgravosAssociados {AIDS,Alcoolismo,Diabetes,Doenca_Mental,Outros,Ignorado}
    public enum BaciloscopiaEscarro {Positiva,Negativa,Nao_Realizada}
    public enum CulturaEscarro {Positiva,Negativa,Em_Andamento,Nao_Realizada}
    public enum CulturaOutroMaterial {Positiva,Negativa,Em_Andamento,Nao_Realizada}
    public enum BaciloscopiaDeOutroMaterial {Positiva,Negativa,Nao_Realizada}
    public enum HIV {Positiva,Negativa,Em_Andamento,Nao_Realizada}
    public enum Histopatologia {Baar_Positiva,Sugestivo_TB,Nao_Sugestivo_TB,Em_Andamento,Nao_Realizada}
    public enum Zona{Urbana, Rural, Periurbana, Ignorado}
    public enum DoencaTrabalho {Sim,Nao,Ignorado}
    public enum TratamentoSupervisionado {Sim,Nao,Ignorado}
    public enum Cor {Branca,Preta,Amarela,Parda,Indigena,Ignorado}
    public enum Escolaridade {Nenhuma,De_1_a_3,De_4_a_7,De_4_8_11,De_12_e_mais,Nao_se_Aplica,Ignorado}
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private int id;
    
    
    @PropertyDescriptor(index=11, displayName="Tipo de Entrada")
    private TipoEntrada tipoEntrada;
    
    @PropertyDescriptor(index=5, displayName="Ocupação/Ramo de Atividade Econômica")
    private String ocupacao;
    
    @PropertyDescriptor(displayName = "Nº do Prontuário ")
    private int numeroProntuario;
    
    private TesteTuberculinico testeTuberculinico;
    
    @PropertyDescriptor(index=11, displayName="Raio X do Tórax")
    private RaioX raioXTorax;
    
    private Forma forma;
    
    private SeExtraPulmonar seExtrapulmonar;
    
    private AgravosAssociados agravosAssociados;
    
    private BaciloscopiaEscarro baciloscopiaEscarro;
    
    private BaciloscopiaDeOutroMaterial baciloscopiaDeOutroMaterial;
    
    private CulturaEscarro culturaEscarro;
    
    private CulturaOutroMaterial culturaOutroMaterial;
    
    private HIV hiv;
    
    private Histopatologia histopatologia;
    
    private TratamentoSupervisionado tratamentoSupervisionado;
    
    private DoencaTrabalho doencaTrabalho;
    
    private Boolean rifampicina;
    private Boolean etambutol;
    private Boolean isoniazida;
    private Boolean estreptomicina;
    private Boolean pirazinamida;
    private Boolean etionamida;
    
    @PropertyDescriptor(index=5, displayName="Outras")
    private String outrasDrogas;
    
    @Past
    @PropertyDescriptor(index=3,displayName="Data de Início do Tratamento Atual")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicioTratamento;
    
    @Past
    @PropertyDescriptor(index=3,displayName="Data da Notificação")
    @NotNull(message = "Informe a data da notificação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDaNotificacao;
    
    @Column(scale = 6 ,precision = 2)
    @PropertyDescriptor(displayName="Latitude da Ocorrência")
    private float latitude;
    
    @Column(scale = 6 ,precision = 2)
    @PropertyDescriptor(displayName="Longitude da Ocorrência")
    private float longitude;
    
    @PropertyDescriptor(index=5, displayName="Município de Notificação")
    @NotEmpty(message="Informe o Município de Notificação!")
    private String municipioNotificacao;
        
    @PropertyDescriptor(index=7, displayName="Unidade de Saúde (ou outra fonte notificadora)")
    @NotEmpty(message="Informe a Unidade de Saúde!")
    private String unidadeDeSaude;
        
    @Past
    @PropertyDescriptor(index=9,displayName="Data do Diagnóstico")
    @NotNull(message = "Informe a data do diagnóstico!")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDoDiagnostico;
   
    @ManyToOne
    @NotNull(message="Escolher o Paciente")
    private Paciente pacienteTuberculose;
             
    @PropertyDescriptor(index=11, displayName="Raça/Cor")
    @NotNull(message="Informe a raça/cor")
    private Cor cor;
    
    @PropertyDescriptor(index=12, displayName="Escolaridade (em anos de estudos concluídos)")
    @NotNull(message="Informe a escolaridade ")
    private Escolaridade escolaridade;
    
    @Column(length=15)
    @PropertyDescriptor(index=13,displayName="Número do Cartão SUS", mask="999999999999999")
    private String numeroCartaoSUS;
    
    @PropertyDescriptor(index=28, displayName="País (se residente fora do Brasil)")
    private String pais;
    
    @Column(length = 4)
    private Integer idade;
    
    @PropertyDescriptor(index=28, displayName="Municipio/Unidade de Saúde")
    private String municipoInvestigador;
    
    @PropertyDescriptor(index=28, displayName="Nome")
    private String nomeInvestigador;

    @PropertyDescriptor(index=28, displayName="Função")
    private String funcaoInvestigador;
    
   
    //Getters and Setters
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public int getNumeroProntuario() {
        return numeroProntuario;
    }

    public void setNumeroProntuario(int numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    public TesteTuberculinico getTesteTuberculinico() {
        return testeTuberculinico;
    }

    public void setTesteTuberculinico(TesteTuberculinico testeTuberculinico) {
        this.testeTuberculinico = testeTuberculinico;
    }

    public RaioX getRaioXTorax() {
        return raioXTorax;
    }

    public void setRaioXTorax(RaioX raioXTorax) {
        this.raioXTorax = raioXTorax;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public SeExtraPulmonar getSeExtrapulmonar() {
        return seExtrapulmonar;
    }

    public void setSeExtrapulmonar(SeExtraPulmonar seExtrapulmonar) {
        this.seExtrapulmonar = seExtrapulmonar;
    }

    public AgravosAssociados getAgravosAssociados() {
        return agravosAssociados;
    }

    public void setAgravosAssociados(AgravosAssociados agravosAssociados) {
        this.agravosAssociados = agravosAssociados;
    }

    public BaciloscopiaEscarro getBaciloscopiaEscarro() {
        return baciloscopiaEscarro;
    }

    public void setBaciloscopiaEscarro(BaciloscopiaEscarro baciloscopiaEscarro) {
        this.baciloscopiaEscarro = baciloscopiaEscarro;
    }

    public BaciloscopiaDeOutroMaterial getBaciloscopiaDeOutroMaterial() {
        return baciloscopiaDeOutroMaterial;
    }

    public void setBaciloscopiaDeOutroMaterial(BaciloscopiaDeOutroMaterial baciloscopiaDeOutroMaterial) {
        this.baciloscopiaDeOutroMaterial = baciloscopiaDeOutroMaterial;
    }

    public CulturaEscarro getCulturaEscarro() {
        return culturaEscarro;
    }

    public void setCulturaEscarro(CulturaEscarro culturaEscarro) {
        this.culturaEscarro = culturaEscarro;
    }

    public CulturaOutroMaterial getCulturaOutroMaterial() {
        return culturaOutroMaterial;
    }

    public void setCulturaOutroMaterial(CulturaOutroMaterial culturaOutroMaterial) {
        this.culturaOutroMaterial = culturaOutroMaterial;
    }

    public HIV getHiv() {
        return hiv;
    }

    public void setHiv(HIV hiv) {
        this.hiv = hiv;
    }

    public Histopatologia getHistopatologia() {
        return histopatologia;
    }

    public void setHistopatologia(Histopatologia histopatologia) {
        this.histopatologia = histopatologia;
    }

    public TratamentoSupervisionado getTratamentoSupervisionado() {
        return tratamentoSupervisionado;
    }

    public void setTratamentoSupervisionado(TratamentoSupervisionado tratamentoSupervisionado) {
        this.tratamentoSupervisionado = tratamentoSupervisionado;
    }

    public DoencaTrabalho getDoencaTrabalho() {
        return doencaTrabalho;
    }

    public void setDoencaTrabalho(DoencaTrabalho doencaTrabalho) {
        this.doencaTrabalho = doencaTrabalho;
    }

    public Boolean getRifampicina() {
        return rifampicina;
    }

    public void setRifampicina(Boolean rifampicina) {
        this.rifampicina = rifampicina;
    }

    public Boolean getEtambutol() {
        return etambutol;
    }

    public void setEtambutol(Boolean etambutol) {
        this.etambutol = etambutol;
    }

    public Boolean getIsoniazida() {
        return isoniazida;
    }

    public void setIsoniazida(Boolean isoniazida) {
        this.isoniazida = isoniazida;
    }

    public Boolean getEstreptomicina() {
        return estreptomicina;
    }

    public void setEstreptomicina(Boolean estreptomicina) {
        this.estreptomicina = estreptomicina;
    }

    public Boolean getPirazinamida() {
        return pirazinamida;
    }

    public void setPirazinamida(Boolean pirazinamida) {
        this.pirazinamida = pirazinamida;
    }

    public Boolean getEtionamida() {
        return etionamida;
    }

    public void setEtionamida(Boolean etionamida) {
        this.etionamida = etionamida;
    }

    public String getOutrasDrogas() {
        return outrasDrogas;
    }

    public void setOutrasDrogas(String outrasDrogas) {
        this.outrasDrogas = outrasDrogas;
    }

    public Date getDataInicioTratamento() {
        return dataInicioTratamento;
    }

    public void setDataInicioTratamento(Date dataInicioTratamento) {
        this.dataInicioTratamento = dataInicioTratamento;
    }

    public Date getDataDaNotificacao() {
        return dataDaNotificacao;
    }

    public void setDataDaNotificacao(Date dataDaNotificacao) {
        this.dataDaNotificacao = dataDaNotificacao;
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
    
    public String getMunicipioNotificacao() {
        return municipioNotificacao;
    }

    public void setMunicipioNotificacao(String municipioNotificacao) {
        this.municipioNotificacao = municipioNotificacao;
    }

    public String getUnidadeDeSaude() {
        return unidadeDeSaude;
    }

    public void setUnidadeDeSaude(String unidadeDeSaude) {
        this.unidadeDeSaude = unidadeDeSaude;
    }

    public Date getDataDoDiagnostico() {
        return dataDoDiagnostico;
    }

    public void setDataDoDiagnostico(Date dataDoDiagnostico) {
        this.dataDoDiagnostico = dataDoDiagnostico;
    }

    public Paciente getPacienteTuberculose() {
        return pacienteTuberculose;
    }

    public void setPacienteTuberculose(Paciente pacienteTuberculose) {
        this.pacienteTuberculose = pacienteTuberculose;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getMunicipoInvestigador() {
        return municipoInvestigador;
    }

    public void setMunicipoInvestigador(String municipoInvestigador) {
        this.municipoInvestigador = municipoInvestigador;
    }

    public String getNomeInvestigador() {
        return nomeInvestigador;
    }

    public void setNomeInvestigador(String nomeInvestigador) {
        this.nomeInvestigador = nomeInvestigador;
    }

    public String getFuncaoInvestigador() {
        return funcaoInvestigador;
    }

    public void setFuncaoInvestigador(String funcaoInvestigador) {
        this.funcaoInvestigador = funcaoInvestigador;
    }
    
    //
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Tuberculose other = (Tuberculose) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pacienteTuberculose.getNomePaciente();
    }
    
    
    
}