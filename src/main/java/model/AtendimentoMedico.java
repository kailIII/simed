/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.ADDProcedimentos;
import entities.annotations.ActionDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author pedro
 */

@Entity
@Views({
    @View(name = "AtendimentoMedico", title = "Atendimento Médico",
         members = "["
            + "dataAtendimentoMedico;"
            + "ubs;"
            + "medico;"
            + "paciente;"
            + "adicionarProcedimentos();"
            + "addProcedimentos<procedimento,removerProcedimentoMedico()>"
            + "]",template = "@CRUD",
            roles = "Administrador")
})

public class AtendimentoMedico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    
    @ManyToOne
    UnidadeBasicaDeSaude ubs;
    
    @ManyToOne
    Paciente paciente;
    
    @ManyToOne
    Medico medico;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimentoMedico;
    
    @PropertyDescriptor(displayName="Adicionar Procedimentos")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="atendimentoMedico")
    private List<ADDProcedimentos> addProcedimentos = new ArrayList<ADDProcedimentos>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarProcedimentos() {
        ADDProcedimentos addPrc = new ADDProcedimentos();
        addPrc.setAtendimentoMedico(this);
        addPrc.setIdmedico(medico.getIdMedico());
        addProcedimentos.add(addPrc);
    }

    public UnidadeBasicaDeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeBasicaDeSaude ubs) {
        this.ubs = ubs;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<ADDProcedimentos> getAddProcedimentos() {
        return addProcedimentos;
    }

    public void setAddProcedimentos(List<ADDProcedimentos> addProcedimentos) {
        this.addProcedimentos = addProcedimentos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAtendimentoMedico() {
        return dataAtendimentoMedico;
    }

    public void setDataAtendimentoMedico(Date dataAtendimentoMedico) {
        this.dataAtendimentoMedico = dataAtendimentoMedico;
    }


}
