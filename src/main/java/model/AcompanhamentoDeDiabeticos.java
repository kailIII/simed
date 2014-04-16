/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Felipe
 */

@Entity
@Views({
      @View(name = "acompanhamentoDeDiabeticos", title = "Acompanhamento de Diabéticos",
            filters = "Pesquisar Por:[paciente, Ctrl.DAO.filter()]",
            members = "["
                    + "[Dados do Paciente[paciente;sexo;idade;"
                    + "fazDieta;"
                    + "fazExerciciosFisicos;"
                    + "usaInsulina;"
                    + "tomaHipoglicemianteOral];"
                    + "Endereço[rua;numero;bairro];"
                    + "Data da Visita do ACS[visitaACS]],"
                    + "[Unidade[ubs;nomeDoACS;municipioCodigo;segmento;area;microarea];"
                    + "Observação[observacao]]"
                    + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador")
        })

public class AcompanhamentoDeDiabeticos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne()
    private Paciente paciente;
    
    
    
    // Unidade
    @NotNull
    @ManyToOne()
    @PropertyDescriptor(displayName = "UBS")
    private UnidadeBasicaDeSaude ubs;
    
    @NotNull
    @PropertyDescriptor(displayName = "Município (Código)")
    private int municipioCodigo;
    
    @PropertyDescriptor(displayName = "Segmento")
    private int segmento;
    
    @PropertyDescriptor(displayName = "Área")
    private int area;
    
    @PropertyDescriptor(displayName = "Microárea")
    private int microarea;
    
    @PropertyDescriptor(displayName = "Nome do ACS")
    private String nomeDoACS;
    
    
    
    //Endereço do Paciente
    @PropertyDescriptor(displayName = "Rua")
    private String rua;
    @PropertyDescriptor(displayName = "Número")
    private String numero;
    @PropertyDescriptor(displayName = "Bairro")
    private String bairro;
    
    
    
    //Sexo do Paciente
    public enum Sexo{
        Masculino,Feminino;
    }
    @PropertyDescriptor(displayName = "Sexo")
    private Sexo sexo;
    
    @PropertyDescriptor(displayName = "Idade")
    private int idade;
    
    
    
    //Data da visita do ACS
    @PropertyDescriptor(displayName = " ")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date visitaACS;
    
    
    // Booleanos
    @PropertyDescriptor(displayName = "Faz Dieta")
    private boolean fazDieta = false;
    
    @PropertyDescriptor(displayName = "Faz Exercícios Físicos")
    private boolean fazExerciciosFisicos = false;
    
    @PropertyDescriptor(displayName = "Usa Insulina")
    private boolean usaInsulina = false;
    
    @PropertyDescriptor(displayName = "Toma Hipoglicemiante Oral")
    private boolean tomaHipoglicemianteOral;
    
    
    
    
    // Observação
    @Lob
    @PropertyDescriptor(displayName = " ")
    private String observacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getMunicipioCodigo() {
        return municipioCodigo;
    }

    public void setMunicipioCodigo(int municipioCodigo) {
        this.municipioCodigo = municipioCodigo;
    }

    public int getSegmento() {
        return segmento;
    }

    public void setSegmento(int segmento) {
        this.segmento = segmento;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getMicroarea() {
        return microarea;
    }

    public void setMicroarea(int microarea) {
        this.microarea = microarea;
    }

    public String getNomeDoACS() {
        return nomeDoACS;
    }

    public void setNomeDoACS(String nomeDoACS) {
        this.nomeDoACS = nomeDoACS;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getVisitaACS() {
        return visitaACS;
    }

    public void setVisitaACS(Date visitaACS) {
        this.visitaACS = visitaACS;
    }

    public boolean isFazDieta() {
        return fazDieta;
    }

    public void setFazDieta(boolean fazDieta) {
        this.fazDieta = fazDieta;
    }

    public boolean isFazExerciciosFisicos() {
        return fazExerciciosFisicos;
    }

    public void setFazExerciciosFisicos(boolean fazExerciciosFisicos) {
        this.fazExerciciosFisicos = fazExerciciosFisicos;
    }

    public boolean isUsaInsulina() {
        return usaInsulina;
    }

    public void setUsaInsulina(boolean usaInsulina) {
        this.usaInsulina = usaInsulina;
    }

    public boolean isTomaHipoglicemianteOral() {
        return tomaHipoglicemianteOral;
    }

    public void setTomaHipoglicemianteOral(boolean tomaHipoglicemianteOral) {
        this.tomaHipoglicemianteOral = tomaHipoglicemianteOral;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
