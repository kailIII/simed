/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.Param;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Marsellus
 */
@Entity
@Views({
            @View(name = "Notificacoes", title = "Notificacoes",
            //filters = "Pesquisar Por:[ Ctrl.DAO.filter()]",
            members = "["
            //+"unidadeDeSaudeAtendimento;"        
            //+ "horaAtendimento;"
            + "tipo;"
            + "nome;"
                   
            + "]",
            template = "@CRUD+@PAGER",
            params = {@Param(name = "odontologoAtendimento", value = "#{dataItem.odontologoAtendimento}")},
            roles = "Administrador")})


public class Notificacoes implements Serializable{
    
    public enum Funcao {

             ACS, MED, ENF
          }
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(index = 1, hidden = true)
    private Long id;
    
    @PropertyDescriptor(index = 2)
    private Funcao tipo;
    
    @PropertyDescriptor(index = 3)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcao getTipo() {
        return tipo;
    }

    public void setTipo(Funcao tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Notificacoes other = (Notificacoes) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}

