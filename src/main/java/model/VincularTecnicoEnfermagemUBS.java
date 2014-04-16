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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */

@Entity
@Views({
    
    @View(name = "VincularTecnicoEnfermagemUBS",
    title = "Vincular Tecnico de Enfermagem a Unidade Básica de Saude",
    members = "["
    + "VincularTecnicoEnfermagemUBS[tecnicoDeEnfermagem;"
    + "         unidadeBasicaDeSaude];"

    + "DiasDaSemana[diasDaSemana.segunda;"
    + "                    diasDaSemana.terca;"
    + "                    diasDaSemana.quarta;"
    + "                    diasDaSemana.quinta;"
    + "                    diasDaSemana.sexta;"
    + "                    diasDaSemana.sabado;"
    + "                    diasDaSemana.domingo];"
    + "]",
    filters="Pesquisar por[tecnicoDeEnfermagem, unidadeBasicaDeSaude, Ctrl.DAO.filter()]",
    template = "@CRUD+@PAGER",
    roles="Administrador"
)})
@EntityDescriptor(displayName = "Vincular Técnico de Enfermagem a Unidade Básica de Saude", 
        pluralDisplayName = "Vincular Técnicos de Enfermagem a Unidade Básica de Saude",
        template = "@FORM_CRUD",
        roles="Administrador"
        
        )
        
public class VincularTecnicoEnfermagemUBS implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer id;
    
    //@Column(unique = true)
    @NotNull(message = "Informe o Tecnico de Enfermagem")
    @OneToOne
    @PropertyDescriptor(index = 1, displayName = "Tecnico de Enfermagem", autoFilter= true)
    private TecnicoDeEnfermagem tecnicoDeEnfermagem;
    
    @NotNull(message = "Informe a Unidade Básica de Saúde")
    @ManyToOne
    @PropertyDescriptor(index = 2, displayName = "Unidade Básica de Saúde", autoFilter= true)
    private UnidadeBasicaDeSaude unidadeBasicaDeSaude;
    
    @Embedded
    private DiasDaSemana diasDaSemana = new DiasDaSemana();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TecnicoDeEnfermagem getTecnicoDeEnfermagem() {
        return tecnicoDeEnfermagem;
    }

    public void setTecnicoDeEnfermagem(TecnicoDeEnfermagem tecnicoDeEnfermagem) {
        this.tecnicoDeEnfermagem = tecnicoDeEnfermagem;
    }

    public UnidadeBasicaDeSaude getUnidadeBasicaDeSaude() {
        return unidadeBasicaDeSaude;
    }

    public void setUnidadeBasicaDeSaude(UnidadeBasicaDeSaude unidadeBasicaDeSaude) {
        this.unidadeBasicaDeSaude = unidadeBasicaDeSaude;
    }

    public DiasDaSemana getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(DiasDaSemana diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.tecnicoDeEnfermagem != null ? this.tecnicoDeEnfermagem.hashCode() : 0);
        hash = 37 * hash + (this.unidadeBasicaDeSaude != null ? this.unidadeBasicaDeSaude.hashCode() : 0);
        hash = 37 * hash + (this.diasDaSemana != null ? this.diasDaSemana.hashCode() : 0);
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
        final VincularTecnicoEnfermagemUBS other = (VincularTecnicoEnfermagemUBS) obj;
        if (this.tecnicoDeEnfermagem != other.tecnicoDeEnfermagem && (this.tecnicoDeEnfermagem == null || !this.tecnicoDeEnfermagem.equals(other.tecnicoDeEnfermagem))) {
            return false;
        }
        if (this.unidadeBasicaDeSaude != other.unidadeBasicaDeSaude && (this.unidadeBasicaDeSaude == null || !this.unidadeBasicaDeSaude.equals(other.unidadeBasicaDeSaude))) {
            return false;
        }
        if (this.diasDaSemana != other.diasDaSemana && (this.diasDaSemana == null || !this.diasDaSemana.equals(other.diasDaSemana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VincularTecnicoEnfermagemUBS{" + "tecnicoDeEnfermagem=" + tecnicoDeEnfermagem + ", unidadeBasicaDeSaude=" + unidadeBasicaDeSaude + ", diasDaSemana=" + diasDaSemana + '}';
    }

    

    
}
