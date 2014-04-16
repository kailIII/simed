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
    @View(name = "AtendimentoTecnicoDeEnfermagem", title = "Atendimento Tecnico de Enfermagem",
         members = "["
            + "dataAtendimentoTecDeEnfermagem;"
            + "ubs;"
            + "tecnicoDeEnfermagem;"
            + "paciente;"
            + "adicionarProcedimentos();"
            + "addProcedimentos<procedimento,removerProcedimentoTecnicoDeEnfermagem()>"
            + "]",template = "@CRUD",
            roles = "Administrador")
})

public class AtendimentoTecnicoDeEnfermagem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    
    @ManyToOne
    private UnidadeBasicaDeSaude ubs;
    
    @ManyToOne
    private Paciente paciente;
    
    @ManyToOne
    private TecnicoDeEnfermagem tecnicoDeEnfermagem;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimentoTecDeEnfermagem;
    
    //atendimentoTecnicoDeEnfermagem
    @PropertyDescriptor(displayName="Adicionar Procedimentos")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="atendimentoTecnicoDeEnfermagem")
    private List<ADDProcedimentos> addProcedimentos = new ArrayList<ADDProcedimentos>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarProcedimentos() {
        ADDProcedimentos addPrc = new ADDProcedimentos();
        addPrc.setAtendimentoTecnicoDeEnfermagem(this);
        addPrc.setIdtecnicoDeEnfermagem(tecnicoDeEnfermagem.getId());
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

    public List<ADDProcedimentos> getAddProcedimentos() {
        return addProcedimentos;
    }

    public void setAddProcedimentos(List<ADDProcedimentos> addProcedimentos) {
        this.addProcedimentos = addProcedimentos;
    }

    public TecnicoDeEnfermagem getTecnicoDeEnfermagem() {
        return tecnicoDeEnfermagem;
    }

    public void setTecnicoDeEnfermagem(TecnicoDeEnfermagem tecnicoDeEnfermagem) {
        this.tecnicoDeEnfermagem = tecnicoDeEnfermagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAtendimentoTecDeEnfermagem() {
        return dataAtendimentoTecDeEnfermagem;
    }

    public void setDataAtendimentoTecDeEnfermagem(Date dataAtendimentoTecDeEnfermagem) {
        this.dataAtendimentoTecDeEnfermagem = dataAtendimentoTecDeEnfermagem;
    }

}
