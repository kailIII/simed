/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author user
 */
@Entity
@Views({
            @View(name = "Agendamento", title = "Agendamento",
            members = "["
            + "paciente;"
            + "ubs;"
            + "profissional;"
            + "tipo;"
            + "procedimento;"           
            + "dataAgendamento;"
            
            
            + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador, Atendente")})


public class Agendamento implements Serializable {
    
    public enum Tipo{Ambulatorial, Hospitalar, AuxílioDiagnóstico}
    public enum Profissional{Médico, TécnicoDeEnfermagem, Enfermeiro}
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer id;
    
    @PropertyDescriptor(index=1, displayName="Paciente")
    @OneToOne
    private Paciente paciente = new Paciente();
    
    @PropertyDescriptor(index=4, displayName="Tipo de Atendimento")
    private Tipo tipo;
    
    @PropertyDescriptor(index=5, displayName="Procedimento")
    @OneToOne
    private Procedimentos procedimento = new Procedimentos();
    
    @PropertyDescriptor(index=3, displayName="Profissional")
    private Profissional profissional;
    
    @PropertyDescriptor(index=2, displayName="Unidade Básica de Saúde")
    @OneToOne
    private UnidadeBasicaDeSaude ubs = new UnidadeBasicaDeSaude();
    
    @PropertyDescriptor(index=6, displayName="Data")
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
        final Agendamento other = (Agendamento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }   
    
}
