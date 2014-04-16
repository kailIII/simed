/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pedro
 */

@Entity
@NamedQueries(
        @NamedQuery(name = "procedimentosNamedQuery",
        query = ""
        + "Select u"
        + " From Procedimentos u"
        + " Order By u.nomeProcedimento"))
@Views({
    @View(name = "Procedimentos", title = "Procedimentos",
            members = "["
            + "codigoProcedimento;"
            + "nomeProcedimento"
            + "]",
            namedQuery = "procedimentosNamedQuery",
            template = "@CRUD+@PAGER",
            roles = "Administrador")}
        )



public class Procedimentos implements Serializable{
    
    @Id
    @Column(length = 25)
    @NotNull(message = "Informe o codigo do Procedimento")
    @PropertyDescriptor(displayName = "Código do Procedimento")
    private Long codigoProcedimento;
    
    @Column(length = 100)
    @PropertyDescriptor(displayName = "Nome do Procedimento")
    private String nomeProcedimento;

    public Long getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(Long codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    @Override
    public String toString() {
        return codigoProcedimento + " - " + nomeProcedimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.codigoProcedimento != null ? this.codigoProcedimento.hashCode() : 0);
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
        final Procedimentos other = (Procedimentos) obj;
        if (this.codigoProcedimento != other.codigoProcedimento && (this.codigoProcedimento == null || !this.codigoProcedimento.equals(other.codigoProcedimento))) {
            return false;
        }
        return true;
    }
    
    
}
