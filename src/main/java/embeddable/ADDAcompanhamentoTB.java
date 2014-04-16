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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import model.AcompanhamentoTB;

/**
 *
 * @author NicolasMoura
 */

@Entity

@EntityDescriptor(hidden = true, displayName="Adicionar Mes")

public class ADDAcompanhamentoTB implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Long id;
    
    public enum Mes{
        Jan, Fev, Mar, Abr, Mai, Jun, Jul, Ago, Set, Out, Nov, Dez
    }
    
    @NotNull(message="Informe o mês do acompanhamento")
    @PropertyDescriptor(displayName="Mês")
    private Mes mesAcompanhamentoTB;
    
    @Past
    @PropertyDescriptor(displayName="Data Visita ACS")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVisita;
    
    @PropertyDescriptor(displayName="Medicação Diária")
    private boolean tomaMedicacao;
    
    @PropertyDescriptor(displayName="Reações")
    private boolean reacoes;
    
    @Past
    @PropertyDescriptor(displayName="Dia Última Consulta")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataUltimaConsulta;
    
    @PropertyDescriptor(displayName="Exame Escarro")
    private boolean exameEscarro;
    
    @PropertyDescriptor(displayName="Comunicantes Examinados")
    private boolean comunicantes;
    
    @PropertyDescriptor(displayName="< 5 anos com BCG")
    private Integer bcg;
    
    @PropertyDescriptor(displayName="Nº Comunicantes")
    private Integer numComunicantes;
    
    @PropertyDescriptor(displayName="Comunicantes >5 anos")
    private Integer comunicMaiorCinco;
    
    @ManyToOne
    private AcompanhamentoTB pacienteAddAcompanhamentoTB;
    
    //
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerMes(){
        pacienteAddAcompanhamentoTB.getAddAcompanhamentoTB().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public AcompanhamentoTB getPacienteAddAcompanhamentoTB() {
        return pacienteAddAcompanhamentoTB;
    }

    public void setPacienteAddAcompanhamentoTB(AcompanhamentoTB pacienteAddAcompanhamentoTB) {
        this.pacienteAddAcompanhamentoTB = pacienteAddAcompanhamentoTB;
    }

    
    public boolean isTomaMedicacao() {
        return tomaMedicacao;
    }

    public void setTomaMedicacao(boolean tomaMedicacao) {
        this.tomaMedicacao = tomaMedicacao;
    }

    public boolean isReacoes() {
        return reacoes;
    }

    public void setReacoes(boolean reacoes) {
        this.reacoes = reacoes;
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

    
    public boolean isExameEscarro() {
        return exameEscarro;
    }

    public void setExameEscarro(boolean exameEscarro) {
        this.exameEscarro = exameEscarro;
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

    public Integer getComunicMaiorCinco() {
        return comunicMaiorCinco;
    }

    public void setComunicMaiorCinco(Integer comunicMaiorCinco) {
        this.comunicMaiorCinco = comunicMaiorCinco;
    }
    
    public Mes getMesAcompanhamentoTB() {
        return mesAcompanhamentoTB;
    }

    public void setMesAcompanhamentoTB(Mes mesAcompanhamentoTB) {
        this.mesAcompanhamentoTB = mesAcompanhamentoTB;
    }
    
    
}
