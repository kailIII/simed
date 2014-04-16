/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddable;

import entities.annotations.ActionDescriptor;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import model.Encaminhamento;
import model.Paciente;
import model.Procedimentos;
import model.UnidadeBasicaDeSaude;

/**
 *
 * @author pedro
 */
@Entity
@EntityDescriptor(hidden = true, displayName="Adicionar Agendamento")
public class ADDAgendamento implements Serializable{
    public enum Tipo{Ambulatorial, Hospitalar, AuxílioDiagnóstico}
    public enum Profissional{Médico, TécnicoDeEnfermagem, Enfermeiro}
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer id;
    
    @PropertyDescriptor(displayName="Paciente")
    @OneToOne
    private Paciente paciente = new Paciente();
    
    @PropertyDescriptor(displayName="Tipo de Atendimento")
    private Tipo tipo;
    
    @PropertyDescriptor(displayName="Procedimento")
    @OneToOne
    private Procedimentos procedimento = new Procedimentos();
    
    @PropertyDescriptor(displayName="Profissional")
    private Profissional profissional;
    
    @PropertyDescriptor(displayName="Unidade Básica de Saúde")
    @OneToOne
    private UnidadeBasicaDeSaude ubs = new UnidadeBasicaDeSaude();
    
    @PropertyDescriptor(displayName="Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAgendamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Procedimentos getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimentos procedimento) {
        this.procedimento = procedimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }


    public UnidadeBasicaDeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeBasicaDeSaude ubs) {
        this.ubs = ubs;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    @ManyToOne
    private Encaminhamento pacienteAddAgendamento;
 
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerAgendamento(){
       pacienteAddAgendamento.getPacienteAddAgendamentos().remove(this);
       
    }

    public Encaminhamento getPacienteAddAgendamento() {
        return pacienteAddAgendamento;
    }

    public void setPacienteAddAgendamento(Encaminhamento pacienteAddAgendamento) {
        this.pacienteAddAgendamento = pacienteAddAgendamento;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ADDAgendamento other = (ADDAgendamento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }  
}
