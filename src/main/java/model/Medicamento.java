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
import javax.persistence.Lob;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author user
 */

@Entity
@Views({
            @View(name = "Medicamento", title = "Medicamento",
            filters = "Pesquisar Por:[nome, Ctrl.DAO.filter()]",
            members = "["
            + "nome;"
            + "descricao;"
            
            
            + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador")})


public class Medicamento implements Serializable {
    
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(index=1, hidden=true)
    private int id;
    
    @Column(length = 60)
    @PropertyDescriptor(index = 2, displayName="Nome", autoFilter = true)
    @NotEmpty(message = "Informe o nome do medicamento!")
    private String nome;
    
    @Lob
    @PropertyDescriptor(index = 3, displayName="Descrição")
    @NotEmpty(message = "Informe a descrição!")
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
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
        final Medicamento other = (Medicamento) obj;
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
