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
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author NicolasMoura
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "PacientePorPrioridade",
            query = ""
            + "Select p"
            + " From Paciente p"
            + " Order By p.prioridade "),
    @NamedQuery(name = "pacienteNamedQuery",
            query = ""
            + "Select u"
            + " From Paciente u"
            + " Order By u.nomePaciente")
})
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nomePaciente"},
            name = "Paciente")
})
@Views({
    @View(name = "Pacientes", title = "Pacientes",
            filters = "Pesquisar Por:[nomePaciente, Ctrl.DAO.filter()]",
            members = "[Dados Pessoais[cns,nomePaciente,sexoPaciente;"
            + "civil,dataDeNascimentoPaciente,profissao;"
            + "naturalidade,nomeDaMae,procedencia;"
            + "categoria];"
            + "Endereço[logradouro,"
            + "numeroCasa,complemento;"
            + "municipio,bairro,uf;"
            + "cep,zona,numeroTelefone]]",
            template = "@CRUD+@PAGER",
            roles = "Administrador, Atendente, AgenteDeSaude"),
    @View(name = "DefinirPrioridade",
            title = "Cadastrar Prioridades",
            rows = 10,
            members = "nomePaciente,sexoPaciente,prioridade",
            namedQuery = "PacientePorPrioridade",
            roles = "Administrador, Atendente",
            template = "@CRUD+@PAGER"),})
public class Paciente implements Serializable {

    public enum UF {

        CE, AC, AL, AM, BA, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO
    }

    public enum Civil {

        Solteiro, Casado, Viuvo, Separado, Outro
    }

    public enum Prioridade {

        Muito_Alta, Alta, Media, Normal, Baixa, Muito_Baixa
    }

    public enum Sexo {

        Masculino, Feminino
    }

    public enum Zona {

        Urbana, Rural, Periurbana, Ignorado
    }
    
    @Id
    @NotNull
    @PropertyDescriptor(displayName = "CNS - Cartão Nacional de Saúde", hidden = true)
    private Long cns;
    
    @Column(length = 60)
    @PropertyDescriptor(displayName = "Nome Completo")
    @NotEmpty(message = "Informe o nome completo do paciente")
    private String nomePaciente;
    
    @PropertyDescriptor(displayName = "Estado Civil")
    private Civil civil;
    
    @PropertyDescriptor(displayName = "UF")
    private UF uf;
    
    @Column(length = 60)
    @PropertyDescriptor(displayName = "Nome da Mãe")
    private String nomeDaMae;
    
    @Column(length = 60)
    @PropertyDescriptor(displayName = "Logradouro(rua,avenida)")
    private String logradouro;
    
    @Column(length = 10)
    @PropertyDescriptor(displayName = "Complemento")
    private String complemento;
    @PropertyDescriptor(displayName = "Número")
    private int numeroCasa;
    @PropertyDescriptor(index = 27, displayName = "Zona")
    @NotNull(message = "Informe a Zona")
    private Zona zona;
    @Column(length = 40)
    private String procedencia;
    @Column(length = 40)
    private String categoria;
    @Column(length = 40)
    private String profissao;
    @PropertyDescriptor(autoSort = true)
    private Prioridade prioridade;
    @Column(length = 40)
    private String naturalidade;
    @Column(length = 40)
    private String bairro;
    @Column(length = 40)
    private String municipio;
    @PropertyDescriptor(displayName = "Sexo")
    @NotNull(message = "Informe o sexo do paciente")
    private Sexo sexoPaciente;
    @Past
    @PropertyDescriptor(displayName = "Data de Nascimento")
    @NotNull(message = "Informe a data de nascimento do paciente")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimentoPaciente;
    @Column(length = 15)
    @PropertyDescriptor(mask = "(99)9999-9999", displayWidth = 15)
    private String numeroTelefone;
    @Column(length = 10)
    @PropertyDescriptor(index = 15, displayName = "CEP", mask = "99.999-999")
    private String cep;

    public Civil getCivil() {
        return civil;
    }

    public void setCivil(Civil civil) {
        this.civil = civil;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public Long getCns() {
        return cns;
    }

    public void setCns(Long cns) {
        this.cns = cns;
    }

    
    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomeCompletoPaciente) {
        this.nomePaciente = nomeCompletoPaciente;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
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

    public Sexo getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(Sexo sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public Date getDataDeNascimentoPaciente() {
        return dataDeNascimentoPaciente;
    }

    public void setDataDeNascimentoPaciente(Date dataDeNascimentoPaciente) {
        this.dataDeNascimentoPaciente = dataDeNascimentoPaciente;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if ((this.nomePaciente == null) ? (other.nomePaciente != null) : !this.nomePaciente.equals(other.nomePaciente)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.nomePaciente != null ? this.nomePaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nomePaciente;
    }
}
