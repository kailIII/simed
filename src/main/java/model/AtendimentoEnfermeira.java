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
    @View(name = "AtendimentoEnfermeira", title = "Atendimento Enfermeira",
         members = "["
            + "dataAtendimentoEnfermeira;"
            + "ubs;"
            + "enfermeiro;"
            + "paciente;"
            + "adicionarProcedimentos();"
            + "addProcedimentos<procedimento,removerProcedimentoEnfermeira()>"
            + "]",template = "@CRUD",
            roles = "Administrador")
})

public class AtendimentoEnfermeira implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    
    @ManyToOne
    private UnidadeBasicaDeSaude ubs;
    
    @ManyToOne
    private Paciente paciente;
    
    @ManyToOne
    private Enfermeiro enfermeiro;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimentoEnfermeira;
    //atendimentoEnfermeira
    @PropertyDescriptor(displayName="Adicionar Procedimentos")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="atendimentoEnfermeira")
    private List<ADDProcedimentos> addProcedimentos = new ArrayList<ADDProcedimentos>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarProcedimentos() {
        ADDProcedimentos addPrc = new ADDProcedimentos();
        addPrc.setAtendimentoEnfermeira(this);
        addPrc.setIdenfermeiro(enfermeiro.getId());
        addProcedimentos.add(addPrc);
    }

    public UnidadeBasicaDeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeBasicaDeSaude ubs) {
        this.ubs = ubs;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public List<ADDProcedimentos> getAddProcedimentos() {
        return addProcedimentos;
    }

    public void setAddProcedimentos(List<ADDProcedimentos> addProcedimentos) {
        this.addProcedimentos = addProcedimentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAtendimentoEnfermeira() {
        return dataAtendimentoEnfermeira;
    }

    public void setDataAtendimentoEnfermeira(Date dataAtendimentoEnfermeira) {
        this.dataAtendimentoEnfermeira = dataAtendimentoEnfermeira;
    }

    
}
