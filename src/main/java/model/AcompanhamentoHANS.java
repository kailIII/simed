/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import embeddable.ADDAcompanhamentoHANS;
import entities.annotations.ActionDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author NicolasMoura
 */

@Entity
@Views({
    @View(name = "AcompanhamentoHANS", title = "Acompanhamento à Hanseníase",
            members = "[Paciente[pacienteHANS,municipio,segmento,unidade,area,microArea;nomeAcs,dataVigencia];"
            + "Acompanhamento de Pessoas com Hanseníase["
            + "adicionarMes();"
            + "addAcompanhamentoHANS<mesAcompanhamentoHANS,"
            + "dataVisita,tomaMedicacao,dataUltimaDose,autoCuidados,dataUltimaConsulta,"
            + "comunicantes,bcg,numComunicantes,removerMes()>;]"
            + "]",
            template = "@CRUD",
            roles = "Administrador, Medico, Enfermeiro, TecnicoDeEnfermagem")
})

public class AcompanhamentoHANS implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    
    
    @ManyToOne
    @PropertyDescriptor(displayName="Paciente Hanseníase")
    Hanseniase pacienteHANS;
    
    @Column(length = 10)
    @PropertyDescriptor(displayName = "Município")
    private String municipio;
    
    @Column(length = 5)
    @PropertyDescriptor(displayName = "Segmento")
    private String segmento;
    
    @Column(length = 5)
    @PropertyDescriptor(displayName = "Unidade")
    private String unidade;
    
    @Column(length = 5)
    @PropertyDescriptor(displayName = "Área")
    private String area;
    
    @Column(length = 5)
    @PropertyDescriptor(displayName = "Micro-Área")
    private String microArea;
    
    @Column(length = 40)
    @PropertyDescriptor(displayName = "Nome do ACS")
    private String nomeAcs;
    
    @Past
    @PropertyDescriptor(displayName = "Vigência")
    @NotNull(message = "Informe a data de Vigencia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVigencia;
    
    @PropertyDescriptor(displayName="Adicionar Procedimentos")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="pacienteAddAcompanhamentoHANS")
    private List<ADDAcompanhamentoHANS> addAcompanhamentoHANS = new ArrayList<ADDAcompanhamentoHANS>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarMes() {
        ADDAcompanhamentoHANS addPHans = new ADDAcompanhamentoHANS();
        addPHans.setPacienteAddAcompanhamentoHANS(this);
        addAcompanhamentoHANS.add(addPHans);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hanseniase getPacienteHANS() {
        return pacienteHANS;
    }

    public void setPacienteHANS(Hanseniase pacienteHANS) {
        this.pacienteHANS = pacienteHANS;
    }

    

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMicroArea() {
        return microArea;
    }

    public void setMicroArea(String microArea) {
        this.microArea = microArea;
    }

    public String getNomeAcs() {
        return nomeAcs;
    }

    public void setNomeAcs(String nomeAcs) {
        this.nomeAcs = nomeAcs;
    }

    public Date getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(Date dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public List<ADDAcompanhamentoHANS> getAddAcompanhamentoHANS() {
        return addAcompanhamentoHANS;
    }

    public void setAddAcompanhamentoHANS(List<ADDAcompanhamentoHANS> addAcompanhamentoHANS) {
        this.addAcompanhamentoHANS = addAcompanhamentoHANS;
    }
    
    

    

    
    
}