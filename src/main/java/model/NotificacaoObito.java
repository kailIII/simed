/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.Temporal;
import javax.validation.constraints.Past;

/**
 *
 * @author NicolasMoura
 */
@Entity
@Views({
    @View(name = "NotificacaoObito", title = "Notificação de Óbito",
            filters = "Pesquisar Por:[nomeFalecido, Ctrl.DAO.filter()]",
            members = "Notificação Óbito["
            + "[tipoObito;dataObito;horaObito]:2;"
            + "Dados Pessoais[nomeFalecido;dataNascimento;idadeFalecido;racaFalecido;sexoFalecido;causaMortis];"
            + "Dados Familiares[nomeMaeFalecido;nomePaiFalecido;estadoCivil;ocupacao];"
            + "Endereço Familiar[enderecoResidencia;bairro;municipio];"
            + "Localização da Ocorrência[localObito;enderecoOcorrencia;bairroOcorrencia;municipioOcorrencia;declaracaoObito;ondeEnterrado;"
            + "Localização Geográfica[latitude;longitude]];"
            + "Agente de Saúde[nomeAgente];"
            + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador, Atendente, AgenteDeSaude")
})

public class NotificacaoObito implements Serializable {

    public enum Raca {

        Branca, Preta, Amarela, Parda,

    }

    public enum Civil {

        Solteiro, Casado, Viuvo, Separado, Junto, Ignorado
    }

    public enum Sexo {

        Masculino, Feminino, Ignorado
    }

    public enum LocalObito {

        Hospital, Domicilio, Via_Publica, Outros, Ignorado
    }

    public enum TipoObito {

        Fetal, Nao_Fetal
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(index = 1, hidden = true)
    private Long id;

    @Column(length = 60)
    @PropertyDescriptor(displayName = "Nome Falecido", autoFilter = true)
    private String nomeFalecido;

    @Column(length = 60)
    @PropertyDescriptor(displayName = "Nome da Mãe", autoFilter = true)
    private String nomeMaeFalecido;

    @Column(length = 60)
    @PropertyDescriptor(displayName = "Nome da Pai", autoFilter = true)
    private String nomePaiFalecido;

    @PropertyDescriptor(displayName = "Sexo")
    private Sexo sexoFalecido;

    @PropertyDescriptor(displayName = "Tipo de Óbito")
    private TipoObito tipoObito;

    @Past
    @PropertyDescriptor(displayName = "Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataObito;

    @Column(length = 5)
    @PropertyDescriptor(displayName = "Hora", mask = "99:99")
    private String horaObito;

    @Past
    @PropertyDescriptor(displayName = "Data Nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Column(length = 2)
    @PropertyDescriptor(displayName = "Idade")
    private Integer idadeFalecido;

    @PropertyDescriptor(displayName = "Raça")
    private Raca racaFalecido;

    private Civil estadoCivil;

    private String ocupacao;
    
    @Column(length = 30)
    @PropertyDescriptor(displayName = "Endereço da Residência")
    private String enderecoResidencia;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Bairro/Distrito")
    private String bairro;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Municipio")
    private String municipio;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Local de Ocorrência do Óbito")
    private LocalObito localObito;

    @Column(scale = 6 ,precision = 2)
    @PropertyDescriptor(displayName="Latitude da Ocorrência")
    private float latitude;
    
    @Column(scale = 6 ,precision = 2)
    @PropertyDescriptor(displayName="Longitude da Ocorrência")
    private float longitude;
    
    @Column(length = 30)
    @PropertyDescriptor(displayName = "Endereço da Ocorrência")
    private String enderecoOcorrencia;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Municipio")
    private String municipioOcorrencia;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Bairro/Distrito")
    private String bairroOcorrencia;

    @PropertyDescriptor(displayName = "Tem declaração de Óbito")
    private boolean declaracaoObito;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Onde Foi Enterrado")
    private String ondeEnterrado;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Causa da Morte")
    private String causaMortis;

    @Column(length = 60)
    @PropertyDescriptor(displayName = "Nome do Agente de Saúde", autoFilter = true)
    private String nomeAgente;

    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFalecido() {
        return nomeFalecido;
    }

    public void setNomeFalecido(String nomeFalecido) {
        this.nomeFalecido = nomeFalecido;
    }

    public String getNomeMaeFalecido() {
        return nomeMaeFalecido;
    }

    public void setNomeMaeFalecido(String nomeMaeFalecido) {
        this.nomeMaeFalecido = nomeMaeFalecido;
    }

    public String getNomePaiFalecido() {
        return nomePaiFalecido;
    }

    public void setNomePaiFalecido(String nomePaiFalecido) {
        this.nomePaiFalecido = nomePaiFalecido;
    }

    public Sexo getSexoFalecido() {
        return sexoFalecido;
    }

    public void setSexoFalecido(Sexo sexoFalecido) {
        this.sexoFalecido = sexoFalecido;
    }

    public TipoObito getTipoObito() {
        return tipoObito;
    }

    public void setTipoObito(TipoObito tipoObito) {
        this.tipoObito = tipoObito;
    }

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

    public String getHoraObito() {
        return horaObito;
    }

    public void setHoraObito(String horaObito) {
        this.horaObito = horaObito;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdadeFalecido() {
        return idadeFalecido;
    }

    public void setIdadeFalecido(Integer idadeFalecido) {
        this.idadeFalecido = idadeFalecido;
    }

    public Raca getRacaFalecido() {
        return racaFalecido;
    }

    public void setRacaFalecido(Raca racaFalecido) {
        this.racaFalecido = racaFalecido;
    }

    public Civil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Civil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getEnderecoResidencia() {
        return enderecoResidencia;
    }

    public void setEnderecoResidencia(String enderecoResidencia) {
        this.enderecoResidencia = enderecoResidencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public LocalObito getLocalObito() {
        return localObito;
    }

    public void setLocalObito(LocalObito localObito) {
        this.localObito = localObito;
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
    
    public String getEnderecoOcorrencia() {
        return enderecoOcorrencia;
    }

    public void setEnderecoOcorrencia(String enderecoOcorrencia) {
        this.enderecoOcorrencia = enderecoOcorrencia;
    }

    public String getMunicipioOcorrencia() {
        return municipioOcorrencia;
    }

    public void setMunicipioOcorrencia(String municipioOcorrencia) {
        this.municipioOcorrencia = municipioOcorrencia;
    }

    public String getBairroOcorrencia() {
        return bairroOcorrencia;
    }

    public void setBairroOcorrencia(String bairroOcorrencia) {
        this.bairroOcorrencia = bairroOcorrencia;
    }

    public boolean isDeclaracaoObito() {
        return declaracaoObito;
    }

    public void setDeclaracaoObito(boolean declaracaoObito) {
        this.declaracaoObito = declaracaoObito;
    }

    public String getOndeEnterrado() {
        return ondeEnterrado;
    }

    public void setOndeEnterrado(String ondeEnterrado) {
        this.ondeEnterrado = ondeEnterrado;
    }

    public String getCausaMortis() {
        return causaMortis;
    }

    public void setCausaMortis(String causaMortis) {
        this.causaMortis = causaMortis;
    }

    public String getNomeAgente() {
        return nomeAgente;
    }

    public void setNomeAgente(String nomeAgente) {
        this.nomeAgente = nomeAgente;
    }

    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final NotificacaoObito other = (NotificacaoObito) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
