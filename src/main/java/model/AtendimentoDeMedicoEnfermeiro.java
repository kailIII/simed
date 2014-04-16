/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author user
 */
@Entity
@Views({
            @View(name = "AtendimentoDeMedicoEnfermeiro", title = "Atendimento De Médico e Enfermeiro",
            members = "["
            + "nome"            
            
            + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador")})

public class AtendimentoDeMedicoEnfermeiro implements Serializable {
   
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(index=1, hidden=true)
    private int id;
    
    @PropertyDescriptor(index=2, displayName="Nome", autoFilter=true )
    @NotEmpty(message="Informe o nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final AtendimentoDeMedicoEnfermeiro other = (AtendimentoDeMedicoEnfermeiro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
