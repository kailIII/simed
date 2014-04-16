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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ufc
 */
@Entity
@NamedQueries(
        @NamedQuery(name= "especialidadeMedicaNameQuery",
        query = ""
        + "Select u"
        + " From EspecialidadeMedica u"
        +" Order By u.nomeEspecialidade" ))
@Views({
            @View(name = "EspecialidadesMedicas", title = "Especialidades",
            filters = "Pesquisar Por:[nomeEspecialidade, Ctrl.DAO.filter()]",
            members = "["
            + "nomeEspecialidade"
                     
            + "]",
            namedQuery = "especialidadeMedicaNameQuery",
            template = "@CRUD+@PAGER",
            roles = "Administrador, Atendente")})
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nomeEspecialidade"},
    name = "EspecialidadeMedica")
})
public class EspecialidadeMedica implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer idEspecialidade;
    
    @NotEmpty(message = "Informe o nome da especialidade")
    @Column(length = 60)
    private String nomeEspecialidade;

    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.nomeEspecialidade != null ? this.nomeEspecialidade.hashCode() : 0);
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
        final EspecialidadeMedica other = (EspecialidadeMedica) obj;
        if ((this.nomeEspecialidade == null) ? (other.nomeEspecialidade != null) : !this.nomeEspecialidade.equals(other.nomeEspecialidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeEspecialidade;
    }
    
    
}