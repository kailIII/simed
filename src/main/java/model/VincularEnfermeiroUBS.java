/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.DiasDaSemana;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marsellus
 */

@Entity
@Views({
    
    @View(name = "VincularEnfermeiroUBS",
    title = "Vincular Enfermeiro a UBS",
    members = "["
    + "VincularEnfermeiroUBS[enfermeiroVincularEnfermeiroUBS;"
    + "         UBSVincularEnfermeiroUBS];"

    + "DiasDaSemana[diasDaSemanaVincularEnfermeiroUBS.segunda;"
    + "                    diasDaSemanaVincularEnfermeiroUBS.terca;"
    + "                    diasDaSemanaVincularEnfermeiroUBS.quarta;"
    + "                    diasDaSemanaVincularEnfermeiroUBS.quinta;"
    + "                    diasDaSemanaVincularEnfermeiroUBS.sexta;"
    + "                    diasDaSemanaVincularEnfermeiroUBS.sabado;"
    + "                    diasDaSemanaVincularEnfermeiroUBS.domingo];"
    + "]",
    filters="Pesquisar por[enfermeiroVincularEnfermeiroUBS, UBSVincularEnfermeiroUBS, Ctrl.DAO.filter()]",
    template = "@CRUD+@PAGER",
    roles="Administrador"
)})
@EntityDescriptor(displayName = "Vincular Enfermeiro a UBS", 
        pluralDisplayName = "Vincular Enfermeiro a UBS",
        template = "@FORM_CRUD",
        roles="Administrador"
        
        )

public class VincularEnfermeiroUBS implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer idVincularEnfermeiroUBS;
    
    @NotNull(message = "Informe o Enfermeiro")
    @ManyToOne
    @PropertyDescriptor(index = 1, displayName = "Enfermeiro", autoFilter= true)
    private Enfermeiro enfermeiroVincularEnfermeiroUBS;
         
    
    @NotNull(message = "Informe a unidade de saúde")
    @ManyToOne
    @PropertyDescriptor(index = 2, displayName = "Unidade de Saúde", autoFilter= true)
    private UnidadeBasicaDeSaude UBSVincularEnfermeiroUBS;

    @Embedded
    private DiasDaSemana diasDaSemanaVincularEnfermeiroUBS = new DiasDaSemana();

    public Integer getIdVincularEnfermeiroUBS() {
        return idVincularEnfermeiroUBS;
    }

    public void setIdVincularEnfermeiroUBS(Integer idVincularEnfermeiroUBS) {
        this.idVincularEnfermeiroUBS = idVincularEnfermeiroUBS;
    }

    public Enfermeiro getEnfermeiroVincularEnfermeiroUBS() {
        return enfermeiroVincularEnfermeiroUBS;
    }

    public void setEnfermeiroVincularEnfermeiroUBS(Enfermeiro enfermeiroVincularEnfermeiroUBS) {
        this.enfermeiroVincularEnfermeiroUBS = enfermeiroVincularEnfermeiroUBS;
    }

    public UnidadeBasicaDeSaude getUBSVincularEnfermeiroUBS() {
        return UBSVincularEnfermeiroUBS;
    }

    public void setUBSVincularEnfermeiroUBS(UnidadeBasicaDeSaude UBSVincularEnfermeiroUBS) {
        this.UBSVincularEnfermeiroUBS = UBSVincularEnfermeiroUBS;
    }

    public DiasDaSemana getDiasDaSemanaVincularEnfermeiroUBS() {
        return diasDaSemanaVincularEnfermeiroUBS;
    }

    public void setDiasDaSemanaVincularEnfermeiroUBS(DiasDaSemana diasDaSemanaVincularEnfermeiroUBS) {
        this.diasDaSemanaVincularEnfermeiroUBS = diasDaSemanaVincularEnfermeiroUBS;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.idVincularEnfermeiroUBS != null ? this.idVincularEnfermeiroUBS.hashCode() : 0);
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
        final VincularEnfermeiroUBS other = (VincularEnfermeiroUBS) obj;
        if (this.idVincularEnfermeiroUBS != other.idVincularEnfermeiroUBS && (this.idVincularEnfermeiroUBS == null || !this.idVincularEnfermeiroUBS.equals(other.idVincularEnfermeiroUBS))) {
            return false;
        }
        return true;
    }

   


}
