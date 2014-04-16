
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
    @View(name = "NascidosVivos", title = "NascidosVivos",
            filters = "Pesquisar Por:[paciente, Ctrl.DAO.filter()]",
            members = "["
            + "[Paciente[paciente,numeroConsultasPreNatal]];"
            + "[Dados da Criança[dataDeNascimento,sexo,peso]],"
            + "[Local da Ocorrência[localNascido;nomeLocal]];" 
            + "[Agente[nomeAgente,dataAtual]]"
            + "]",
            template = "@CRUD+@PAGER",            
    roles = "Administrador, Atendente, AgenteDeSaude")
})


public class NascidosVivos implements Serializable {

    public enum Sexo {
             MASCULINO, FEMININO
    }
    
    public enum LocalNascido {
             HOSPITAL, OUTRO_ESTABELECIMENTO_DE_SAUDE,DOMICILIO,OUTROS
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Long id;

    
    @ManyToOne
    @NotNull(message="Escolher o Paciente")
    private Paciente paciente;
    
    
    @Column(length = 2)
    @PropertyDescriptor(displayName = "Idade")
    private Integer idadeMae;
    
    
    @Column(length = 2)
    @PropertyDescriptor(displayName = "Nº Consultas Pré-Natal")
    private Integer numeroConsultasPreNatal;

    
    @PropertyDescriptor(displayName="Sexo")
    @NotNull(message = "Informe o sexo do nascido")
    private Sexo sexo;
    
    @PropertyDescriptor(displayName="Local da Ocorrência")
    @NotNull(message = "Informe o lacal do nascimento")
    private LocalNascido localNascido;
    
    @Column(length = 45)
    private String nomeLocal;
   
    @Column(length = 5)
    private Integer peso;
    
    @Past
    @PropertyDescriptor(displayName="Data de Nascimento")
    @NotNull(message = "Informe a data de nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    
    @Past
    @PropertyDescriptor(displayName="Data")
    @NotNull(message = "Informe a data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtual;

    @Column(length = 40)
    @PropertyDescriptor(displayName = "Nome do Agente")
    private String nomeAgente;
    
    @Column(length = 40)
    @PropertyDescriptor(displayName = "Endereço",autoFilter = true)
    @NotEmpty(message = "Informe o endereço")
    private String endereco;

    @Column(length = 10)
    @PropertyDescriptor(displayName = "Número")
    private Integer numero;

    @Column(length = 40)
    @PropertyDescriptor(displayName="Bairro/Distrito")
    private String bairro;

    @Column(length = 15)
    @PropertyDescriptor(mask="(99)9999-9999", displayName="Telefone")
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
    public Integer getIdadeMae() {
        return idadeMae;
    }

    public void setIdadeMae(Integer idade) {
        this.idadeMae = idade;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }
    
    public Integer getNumeroConsultasPreNatal() {
        return numeroConsultasPreNatal;
    }

    public void setNumeroConsultasPreNatal(Integer numeroConsultasPreNatal) {
        this.numeroConsultasPreNatal = numeroConsultasPreNatal;
    }

   
    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getNomeAgente() {
        return nomeAgente;
    }

    public void setNomeAgente(String nomeAgente) {
        this.nomeAgente = nomeAgente;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalNascido getLocalNascido() {
        return localNascido;
    }

    public void setLocalNascido(LocalNascido localNascido) {
        this.localNascido = localNascido;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

   
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final NascidosVivos other = (NascidosVivos) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NascidosVivos{" + "paciente=" + paciente + '}';
    }
    
    
}

