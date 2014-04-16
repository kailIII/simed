/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Marsellus
 */
@Entity
@Views({
    @View(name = "Enfermeiro", title = "Enfermeiro",
    filters = "Pesquisar Por:[coren, nome, Ctrl.DAO.filter()]",
    members = "["
    + "coren;"
    + "nome;"
    + "telefone;"
    + "]",
    template = "@CRUD+@PAGER",            
    roles = "Administrador, Atendente")
})
public class Enfermeiro implements Serializable {
    @Column(length=10)
    @NotEmpty(message = "informe o COREN do Enfermeiro")
    @PropertyDescriptor(index = 1, displayName = "COREN", autoFilter = true)
    private String coren;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;

    
    @NotEmpty(message = "Informe o nome do Enfermeiro")
    @Column(length = 60)
    @PropertyDescriptor(index = 2, autoFilter = true)
    private String nome;
    //private Especialidade especialidade; //*: Representa a especialidade do OdontÃ³logo; 
    @NotEmpty(message = "Informe o telefone do Enfermeiro")
    @PropertyDescriptor(index = 3, mask = "(99)9999-9999")
    private String telefone;

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
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
        final Enfermeiro other = (Enfermeiro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
