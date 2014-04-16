/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.ADDAcompanhamentoTB;
import entities.annotations.ActionDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author NicolasMoura
 */

@Entity
@Views({
    @View(name = "AcompanhamentoTB", title = "Acompanhamento à Tuberculose",
            members = "[Paciente[pacienteTB,municipio,segmento,unidade,area,microArea;nomeAcs,dataVigencia];"
            + "Acompanhamento de Pessoas com Tuberculose["
            + "adicionarMes();"
            + "addAcompanhamentoTB<mesAcompanhamentoTB,"
            + "dataVisita,tomaMedicacao,reacoes,dataUltimaConsulta,exameEscarro,"
            + "comunicantes,bcg,numComunicantes,comunicMaiorCinco,removerMes()>;]"
            + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador, Medico, Enfermeiro, TecnicoDeEnfermagem")
})

public class AcompanhamentoTB implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private int id;
    
    
    @ManyToOne
    @PropertyDescriptor(displayName="Paciente Tuberculoso")
    Tuberculose pacienteTB;
    
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
    @PropertyDescriptor(displayName = "Data de Vigência")
    @NotNull(message = "Informe a data de Vigencia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVigencia;
    
    @PropertyDescriptor(displayName="Adicionar Procedimentos")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="pacienteAddAcompanhamentoTB")
    private List<ADDAcompanhamentoTB> addAcompanhamentoTB = new ArrayList<ADDAcompanhamentoTB>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarMes() {
        ADDAcompanhamentoTB addPTB = new ADDAcompanhamentoTB();
        addPTB.setPacienteAddAcompanhamentoTB(this);
        addAcompanhamentoTB.add(addPTB);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tuberculose getPacienteTB() {
        return pacienteTB;
    }

    public void setPacienteTB(Tuberculose pacienteTB) {
        this.pacienteTB = pacienteTB;
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

    

    public List<ADDAcompanhamentoTB> getAddAcompanhamentoTB() {
        return addAcompanhamentoTB;
    }

    public void setAddAcompanhamentoTB(List<ADDAcompanhamentoTB> addAcompanhamentoTB) {
        this.addAcompanhamentoTB = addAcompanhamentoTB;
    }
    
}