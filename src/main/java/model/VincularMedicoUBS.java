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
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ufc
 */
@Entity
@Views({
    
    @View(name = "VincularMedicoUBS",
    title = "Vincular Medico a Unidade Basica de Saude",
    members = "["
    + "Vincular Medico Unidade Basica de Saude[medico;"
    + "         unidadeBasicaSaude];"
      
    + "Dias Da Semana[diasDaSemana.segunda;"
    + "               diasDaSemana.terca;"
    + "               diasDaSemana.quarta;"
    + "               diasDaSemana.quinta;"
    + "               diasDaSemana.sexta;"
    + "               diasDaSemana.sabado;"
    + "               diasDaSemana.domingo];"
    + "]",
    filters="Pesquisar por[medico, unidadeBasicaSaude, Ctrl.DAO.filter()]",
    template = "@CRUD+@PAGER",
    roles="Administrador"
)})
@EntityDescriptor(displayName = "Vincular Medico a Unidade Basica de Saúde", 
        pluralDisplayName = "Vincular Médicos a Unidade Basica de Saúde",
        template = "@FORM_CRUD",
        roles="Administrador"
        
        )
//@Table(uniqueConstraints = {
//    @UniqueConstraint(columnNames = {"medico"
//            },
//    name = "VincularMedicoUnidadeBasicaSaude")
//})
public class VincularMedicoUBS implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer id;
    
    @NotNull(message = "Informe o Medico")
    @ManyToOne
    @PropertyDescriptor(index = 1, displayName = "Medico", autoFilter= true)
    private Medico medico;
    
    @NotNull(message = "Informe a unidade Basica de saúde")
    @ManyToOne
    @PropertyDescriptor(index = 2, displayName = "Unidade Basica de Saúde", autoFilter= true)
    private UnidadeBasicaDeSaude unidadeBasicaSaude;
    
  
    @Embedded
    private DiasDaSemana diasDaSemana = new DiasDaSemana();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public UnidadeBasicaDeSaude getUnidadeBasicaSaude() {
        return unidadeBasicaSaude;
    }

    public void setUnidadeBasicaSaude(UnidadeBasicaDeSaude unidadeBasicaSaude) {
        this.unidadeBasicaSaude = unidadeBasicaSaude;
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
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final VincularMedicoUBS other = (VincularMedicoUBS) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.medico != other.medico && (this.medico == null || !this.medico.equals(other.medico))) {
            return false;
        }
        if (this.unidadeBasicaSaude != other.unidadeBasicaSaude && (this.unidadeBasicaSaude == null || !this.unidadeBasicaSaude.equals(other.unidadeBasicaSaude))) {
            return false;
        }
        if (this.diasDaSemana != other.diasDaSemana && (this.diasDaSemana == null || !this.diasDaSemana.equals(other.diasDaSemana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " " + medico + "" + unidadeBasicaSaude
                + "" + diasDaSemana;
    }
    
    
}
