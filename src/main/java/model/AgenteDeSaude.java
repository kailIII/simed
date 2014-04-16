/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author francieudo
 */
@Entity
@NamedQueries(
        @NamedQuery(name= "nomeAgenteSaudeQuery",
        query = ""
        + "Select u"
        + " From AgenteDeSaude u"
        +" Order By u.nomeAgenteSaude" ))
@EntityDescriptor(displayName = "Agente De Saúde", pluralDisplayName = "Agentes de Saúde",
template = "@FORM_CRUD",
roles = "Administrador")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nomeAgenteSaude"},
    name = "AgenteDeSaude")
})
@Views({
    @View(name = "AgentesdeSaude", title = "Agentes de Saúde",
    filters = "Pesquisar Por:[nomeAgenteSaude,Ctrl.DAO.filter()]",
    members = "["
    + "nomeAgenteSaude;"
    + "areaDeAtuacaoAgenteSaude;"
    + "]",
    namedQuery = "nomeAgenteSaudeQuery",
    template = "@CRUD+@PAGER",            
    roles = "Administrador")
})
public class AgenteDeSaude implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer idAgenteSaude;
    
    @NotEmpty(message = "Informe o nome do Agente de Saude")
    @Column(length = 60)
    private String nomeAgenteSaude;
    
    @NotEmpty(message = "Informe a area de Atuação")
    @Column(length = 30)
    private String areaDeAtuacaoAgenteSaude;

    public Integer getIdAgenteSaude() {
        return idAgenteSaude;
    }

    public void setIdAgenteSaude(Integer idAgenteSaude) {
        this.idAgenteSaude = idAgenteSaude;
    }

    public String getNomeAgenteSaude() {
        return nomeAgenteSaude;
    }

    public void setNomeAgenteSaude(String nomeAgenteSaude) {
        this.nomeAgenteSaude = nomeAgenteSaude;
    }

    public String getAreaDeAtuacaoAgenteSaude() {
        return areaDeAtuacaoAgenteSaude;
    }

    public void setAreaDeAtuacaoAgenteSaude(String areaDeAtuacaoAgenteSaude) {
        this.areaDeAtuacaoAgenteSaude = areaDeAtuacaoAgenteSaude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.idAgenteSaude != null ? this.idAgenteSaude.hashCode() : 0);
        hash = 67 * hash + (this.nomeAgenteSaude != null ? this.nomeAgenteSaude.hashCode() : 0);
        hash = 67 * hash + (this.areaDeAtuacaoAgenteSaude != null ? this.areaDeAtuacaoAgenteSaude.hashCode() : 0);
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
        final AgenteDeSaude other = (AgenteDeSaude) obj;
        if (this.idAgenteSaude != other.idAgenteSaude && (this.idAgenteSaude == null || !this.idAgenteSaude.equals(other.idAgenteSaude))) {
            return false;
        }
        if ((this.nomeAgenteSaude == null) ? (other.nomeAgenteSaude != null) : !this.nomeAgenteSaude.equals(other.nomeAgenteSaude)) {
            return false;
        }
        if ((this.areaDeAtuacaoAgenteSaude == null) ? (other.areaDeAtuacaoAgenteSaude != null) : !this.areaDeAtuacaoAgenteSaude.equals(other.areaDeAtuacaoAgenteSaude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeAgenteSaude;
    }
        
}
