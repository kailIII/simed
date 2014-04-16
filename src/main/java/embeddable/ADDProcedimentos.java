/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddable;

import entities.annotations.ActionDescriptor;
import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import model.AtendimentoEnfermeira;
import model.AtendimentoMedico;
import model.AtendimentoTecnicoDeEnfermagem;
import model.Procedimentos;

/**
 *
 * @author pedro
 */
@Entity
public class ADDProcedimentos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    
    @ManyToOne
    private Procedimentos procedimento;

    @ManyToOne
    private AtendimentoMedico atendimentoMedico;
    
    @ManyToOne 
    private AtendimentoEnfermeira atendimentoEnfermeira;
    
    @ManyToOne
    private AtendimentoTecnicoDeEnfermagem atendimentoTecnicoDeEnfermagem;
   
    
    private Integer idmedico;

    private Integer idenfermeiro;
    
    private Integer idtecnicoDeEnfermagem;
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerProcedimentoMedico(){
        atendimentoMedico.getAddProcedimentos().remove(this);
       
    }

    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerProcedimentoEnfermeira(){
        atendimentoEnfermeira.getAddProcedimentos().remove(this);
       
    }
     
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerProcedimentoTecnicoDeEnfermagem(){
        atendimentoTecnicoDeEnfermagem.getAddProcedimentos().remove(this);
       
    }
     
    public Procedimentos getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimentos procedimento) {
        this.procedimento = procedimento;
    }
    
    public AtendimentoMedico getAtendimentoMedico() {
        return atendimentoMedico;
    }

    public void setAtendimentoMedico(AtendimentoMedico atendimentoMedico) {
        this.atendimentoMedico = atendimentoMedico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AtendimentoEnfermeira getAtendimentoEnfermeira() {
        return atendimentoEnfermeira;
    }

    public void setAtendimentoEnfermeira(AtendimentoEnfermeira atendimentoEnfermeira) {
        this.atendimentoEnfermeira = atendimentoEnfermeira;
    }

    public AtendimentoTecnicoDeEnfermagem getAtendimentoTecnicoDeEnfermagem() {
        return atendimentoTecnicoDeEnfermagem;
    }

    public void setAtendimentoTecnicoDeEnfermagem(AtendimentoTecnicoDeEnfermagem atendimentoTecnicoDeEnfermagem) {
        this.atendimentoTecnicoDeEnfermagem = atendimentoTecnicoDeEnfermagem;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getIdenfermeiro() {
        return idenfermeiro;
    }

    public void setIdenfermeiro(Integer idenfermeiro) {
        this.idenfermeiro = idenfermeiro;
    }

    public Integer getIdtecnicoDeEnfermagem() {
        return idtecnicoDeEnfermagem;
    }

    public void setIdtecnicoDeEnfermagem(Integer idtecnicoDeEnfermagem) {
        this.idtecnicoDeEnfermagem = idtecnicoDeEnfermagem;
    }

    
}
