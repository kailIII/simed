/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddable;
import entities.annotations.ActionDescriptor;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import model.EspecialidadeMedica;
import model.Medico;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ufc
 */
@Entity
@EntityDescriptor(hidden = true, displayName="Adicionar Especialidade")
public class ADDEspecialidadesMedicas implements Serializable{
    
    @Id
    @PropertyDescriptor(hidden=true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idAddEspecialidades;
    
    @NotNull(message="Informe a Especialidade do Médico")
    @ManyToOne//perguntar ao Luis
    @PropertyDescriptor(displayName="Especialidade")
    private EspecialidadeMedica addEspecialidade;
    
    @NotEmpty(message="Informe o RQE do Médico")
    @PropertyDescriptor(displayName="RQE")
    private String rqeAddEspecialidade;
    
    @ManyToOne
    private Medico medicoAddEspecialidade;
    
     @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
     public void removerEspecialidade(){
         medicoAddEspecialidade.getAddEspecialidades().remove(this);
     }

    public Long getIdAddEspecialidades() {
        return idAddEspecialidades;
    }

    public void setIdAddEspecialidades(Long idAddEspecialidades) {
        this.idAddEspecialidades = idAddEspecialidades;
    }

    public EspecialidadeMedica getAddEspecialidade() {
        return addEspecialidade;
    }

    public void setAddEspecialidade(EspecialidadeMedica addEspecialidade) {
        this.addEspecialidade = addEspecialidade;
    }

    public String getRqeAddEspecialidade() {
        return rqeAddEspecialidade;
    }

    public void setRqeAddEspecialidade(String rqeAddEspecialidade) {
        this.rqeAddEspecialidade = rqeAddEspecialidade;
    }

    public Medico getMedicoAddEspecialidade() {
        return medicoAddEspecialidade;
    }

    public void setMedicoAddEspecialidade(Medico medicoAddEspecialidade) {
        this.medicoAddEspecialidade = medicoAddEspecialidade;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.idAddEspecialidades != null ? this.idAddEspecialidades.hashCode() : 0);
        hash = 83 * hash + (this.addEspecialidade != null ? this.addEspecialidade.hashCode() : 0);
        hash = 83 * hash + (this.rqeAddEspecialidade != null ? this.rqeAddEspecialidade.hashCode() : 0);
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
        final ADDEspecialidadesMedicas other = (ADDEspecialidadesMedicas) obj;
        if (this.idAddEspecialidades != other.idAddEspecialidades && (this.idAddEspecialidades == null || !this.idAddEspecialidades.equals(other.idAddEspecialidades))) {
            return false;
        }
        if (this.addEspecialidade != other.addEspecialidade && (this.addEspecialidade == null || !this.addEspecialidade.equals(other.addEspecialidade))) {
            return false;
        }
        if ((this.rqeAddEspecialidade == null) ? (other.rqeAddEspecialidade != null) : !this.rqeAddEspecialidade.equals(other.rqeAddEspecialidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rqeAddEspecialidade;
    }
    
    
    
}
