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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author pedro
 */
@Entity
@Views({
    @View(name = "Atendimentos", title = "Atendimentos",
        members = "[ubs:2; paciente,dataAtendimento; primeiroAtendimento:2;peso,altura,pressao;temperatura,glicemia;queixaPricinpal:2;historialAtual:2]:2",
        roles = "Administrador, Atendente, Medico, Enfermeiro, TecnicoDeEnfermagem",
        template = "@CRUD+@PAGER" )
        })

public class Atendimento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Integer idAtendimento;
    
    @ManyToOne
    private UnidadeBasicaDeSaude ubs;
    
    @ManyToOne
    private Paciente paciente;
    
    private boolean primeiroAtendimento;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimento;
    
    private float peso;
    
    private float altura;
    
    @PropertyDescriptor(mask = "99/99")
    private String pressao;
    
    private float temperatura;
    
    private float glicemia;

    @Lob
    private String queixaPricinpal;
    
    @Lob
    private String historialAtual;

    public String getQueixaPricinpal() {
        return queixaPricinpal;
    }

    public void setQueixaPricinpal(String queixaPricinpal) {
        this.queixaPricinpal = queixaPricinpal;
    }

    public String getHistorialAtual() {
        return historialAtual;
    }

    public void setHistorialAtual(String historialAtual) {
        this.historialAtual = historialAtual;
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

    public boolean isPrimeiroAtendimento() {
        return primeiroAtendimento;
    }

    public void setPrimeiroAtendimento(boolean primeiroAtendimento) {
        this.primeiroAtendimento = primeiroAtendimento;
    }

    public Integer getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Integer idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(float glicemia) {
        this.glicemia = glicemia;
    }
    
    
            
}
