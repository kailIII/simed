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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import model.Medico;
import model.Paciente;
import model.SaudeDaMulher;

/**
 *
 * @author NicolasMoura
 */

@Entity

@EntityDescriptor(hidden = true, displayName="Adicionar Consulta")

public class ADDConsulta implements Serializable{
    
    public enum NumeroConsulta{
        Um, Dois,Tres,Quatro,Cinco,Seis,Sete,Oito,Nove,Dez
    }
    
    @NotNull(message="Informe o numero da consulta")
    @PropertyDescriptor(displayName="Nº Consulta")
    private NumeroConsulta numeroConsulta;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    @ManyToOne
    private Paciente paciente;
 
    @ManyToOne
    private Medico nomeDoMedico;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataConsulta;

    @Column(length = 30)
    private String semanaAmenorreia;
    
    private double pressaoArterial;
    
    private String apresentacao;
    
    private double alteracaoUterina;
    
    private double peso;
    
    private String bfc;
    
    private String movFetais;

    @ManyToOne
    private SaudeDaMulher mulherAddConsulta;
    
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerConsulta(){
        mulherAddConsulta.getAddConsulta().remove(this);
    }

    public SaudeDaMulher getMulherAddConsulta() {
        return mulherAddConsulta;
    }

    public void setMulherAddConsulta(SaudeDaMulher mulherAddConsulta) {
        this.mulherAddConsulta = mulherAddConsulta;
    }

    public NumeroConsulta getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(NumeroConsulta numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getNomeDoMedico() {
        return nomeDoMedico;
    }

    public void setNomeDoMedico(Medico nomeDoMedico) {
        this.nomeDoMedico = nomeDoMedico;
    }
   
    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getSemanaAmenorreia() {
        return semanaAmenorreia;
    }

    public void setSemanaAmenorreia(String semanaAmenorreia) {
        this.semanaAmenorreia = semanaAmenorreia;
    }

    public double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public double getAlteracaoUterina() {
        return alteracaoUterina;
    }

    public void setAlteracaoUterina(double alteracaoUterina) {
        this.alteracaoUterina = alteracaoUterina;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getBfc() {
        return bfc;
    }

    public void setBfc(String bfc) {
        this.bfc = bfc;
    }

    public String getMovFetais() {
        return movFetais;
    }

    public void setMovFetais(String movFetais) {
        this.movFetais = movFetais;
    }

}
