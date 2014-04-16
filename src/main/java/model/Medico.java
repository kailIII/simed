/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import embeddable.ADDEspecialidadesMedicas;
import entities.Repository;
import entities.annotations.ActionDescriptor;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import entities.dao.DAOConstraintException;
import entities.dao.DAOException;
import entities.dao.DAOValidationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author ufc
 */
@Entity
@NamedQueries(
        @NamedQuery(name= "medicoNameQuery",
        query = ""
        + "Select u"
        + " From Medico u"
        +" Order By u.nomeMedico" ))
@EntityDescriptor(displayName = "Medico", pluralDisplayName = "Médicos",
template = "@FORM_CRUD",
roles = "Administrador, Atendente")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"crmMedico"},
    name = "Medico")
})
@Views({
    @View(name = "Medicos", title = "Médicos",
    filters = "Pesquisar Por:[crmMedico, nomeMedico, Ctrl.DAO.filter()]",
    members = "["
    + "crmMedico;"
    + "nomeMedico;"
    + "telefoneMedico;"
   + "adicionarEspecialidade(); "
   + "'Adicionar Especialidades':addEspecialidades<addEspecialidade,rqeAddEspecialidade,removerEspecialidade()>;"
    //+ "registrarDentista();"
    + "]",
    namedQuery = "medicoNameQuery",
    template = "@CRUD+@PAGER",            
    roles = "Administrador, Atendente")
})
public class Medico implements Serializable{
    
    @Column(length=10)
    @NotEmpty(message = "informe o CRM do Médico")
    @PropertyDescriptor(index = 1, displayName = "CRM", autoFilter = true)
    private String crmMedico;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Integer idMedico;
    
    @NotEmpty(message = "Informe o nome do Médico")
    @Column(length = 60)
    @PropertyDescriptor(index = 2, autoFilter = true)
    private String nomeMedico;
    
    @NotEmpty(message = "Informe o telefone do Médico")
    @PropertyDescriptor(index = 3, mask = "(99)9999-9999")
    private String telefoneMedico;
    
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="medicoAddEspecialidade")
    @PropertyDescriptor(displayName="Adicionar Especialidades")
    private List<ADDEspecialidadesMedicas> addEspecialidades = new ArrayList<ADDEspecialidadesMedicas>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarEspecialidade(){
        ADDEspecialidadesMedicas addE = new ADDEspecialidadesMedicas();
        addE.setMedicoAddEspecialidade(this);
        addEspecialidades.add(addE);
    }

    public String registrarMedico() throws DAOException, DAOValidationException, DAOConstraintException {
        List<Medico> medicos = Repository.query("MedicoCro", crmMedico);

        
        if (medicos.size() == 1) {
            return "Médico já cadastrado";
        } else {

            Repository.save(this);

            return "Médico cadastrado com sucesso";

        }


    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    
    
    

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getTelefoneMedico() {
        return telefoneMedico;
    }

    public void setTelefoneMedico(String telefoneMedico) {
        this.telefoneMedico = telefoneMedico;
    }

    public List<ADDEspecialidadesMedicas> getAddEspecialidades() {
        return addEspecialidades;
    }

    public void setAddEspecialidades(List<ADDEspecialidadesMedicas> addEspecialidades) {
        this.addEspecialidades = addEspecialidades;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.crmMedico != null ? this.crmMedico.hashCode() : 0);
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
        final Medico other = (Medico) obj;
        if ((this.crmMedico == null) ? (other.crmMedico != null) : !this.crmMedico.equals(other.crmMedico)) {
            return false;
        }
        return true;
    }

    
    
    

    @Override
    public String toString() {
        return crmMedico + "-" + nomeMedico;
    }
    
    
    
}