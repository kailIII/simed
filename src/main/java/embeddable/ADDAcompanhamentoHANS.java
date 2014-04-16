/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import model.AcompanhamentoHANS;

/**
 *
 * @author NicolasMoura
 */
@Entity

@EntityDescriptor(hidden = true, displayName="Adicionar Mes")

public class ADDAcompanhamentoHANS implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Long id;
    
    public enum Mes{
        Jan, Fev, Mar, Abr, Mai, Jun, Jul, Ago, Set, Out, Nov, Dez
    }
   
    
    @NotNull(message="Informe o mês do acompanhamento")
    @PropertyDescriptor(displayName="Mês")
    private Mes mesAcompanhamentoHANS;
    
    @Past
    @PropertyDescriptor(displayName="Data Visita ACS")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVisita;
    
    @PropertyDescriptor(displayName="Medicação Diária")
    private boolean tomaMedicacao;
    
    @Past
    @Temporal(javax.persistence.TemporalType.DATE)
    @PropertyDescriptor(displayName="Última Dose")
    private Date dataUltimaDose;
    
    @PropertyDescriptor(displayName="Auto-Cuidados")
    private boolean autoCuidados;
    
    @Past
    @Temporal(javax.persistence.TemporalType.DATE)
    @PropertyDescriptor(displayName="Dia Última Consulta")
    private Date dataUltimaConsulta;
    
    @PropertyDescriptor(displayName="Comunicantes Examinados")
    private boolean comunicantes;
    
    @PropertyDescriptor(displayName="Comunicantes receberam BCG")
    private Integer bcg;
    
    @PropertyDescriptor(displayName="Nº Comunicantes")
    private Integer numComunicantes;
    
    @ManyToOne
    private AcompanhamentoHANS pacienteAddAcompanhamentoHANS;
    
    //
    
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerMes(){
        pacienteAddAcompanhamentoHANS.getAddAcompanhamentoHANS().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcompanhamentoHANS getPacienteAddAcompanhamentoHANS() {
        return pacienteAddAcompanhamentoHANS;
    }

    public void setPacienteAddAcompanhamentoHANS(AcompanhamentoHANS pacienteAddAcompanhamentoHANS) {
        this.pacienteAddAcompanhamentoHANS = pacienteAddAcompanhamentoHANS;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public Date getDataUltimaConsulta() {
        return dataUltimaConsulta;
    }

    public void setDataUltimaConsulta(Date dataUltimaConsulta) {
        this.dataUltimaConsulta = dataUltimaConsulta;
    }

    public Date getDataUltimaDose() {
        return dataUltimaDose;
    }

    public void setDataUltimaDose(Date dataUltimaDose) {
        this.dataUltimaDose = dataUltimaDose;
    }

    public boolean isAutoCuidados() {
        return autoCuidados;
    }

    public void setAutoCuidados(boolean autoCuidados) {
        this.autoCuidados = autoCuidados;
    }
    
    
    
    public boolean isTomaMedicacao() {
        return tomaMedicacao;
    }

    public void setTomaMedicacao(boolean tomaMedicacao) {
        this.tomaMedicacao = tomaMedicacao;
    }

    public boolean isComunicantes() {
        return comunicantes;
    }

    public void setComunicantes(boolean comunicantes) {
        this.comunicantes = comunicantes;
    }

    public Integer getBcg() {
        return bcg;
    }

    public void setBcg(Integer bcg) {
        this.bcg = bcg;
    }

    public Integer getNumComunicantes() {
        return numComunicantes;
    }

    public void setNumComunicantes(Integer numComunicantes) {
        this.numComunicantes = numComunicantes;
    }
    
    public Mes getMesAcompanhamentoHANS() {
        return mesAcompanhamentoHANS;
    }

    public void setMesAcompanhamentoHANS(Mes mesAcompanhamentoHANS) {
        this.mesAcompanhamentoHANS = mesAcompanhamentoHANS;
    }
    
    
}
