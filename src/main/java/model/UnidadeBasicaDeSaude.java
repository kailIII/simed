/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author user
 */

@Entity
@Views({
            @View(name = "UnidadeBasicaDeSaude", title = "Unidade Básica de Saúde",
            filters = "Pesquisar Por:[scnes, nome, Ctrl.DAO.filter()]",
            members = "["
            + "scnes;"
            + "nome;"
            + "bairro;"
            + "distrito;"
            + "municipio;"
            + "uf;"
            
            
            + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador")})

public class UnidadeBasicaDeSaude implements Serializable {
    
    public enum UF{ CE, AC, AL, AM, BA,  DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO}
    
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(index=1, hidden=true)
    private int id;
    
    @PropertyDescriptor(index=2, displayName="SCNES", autoFilter=true)  
    @NotNull(message="Informe o SCNES da Unidade Básica de Saúde")
    private Integer scnes;        //codigo da unidade basica de saude
    
    @PropertyDescriptor(index=3, displayName="Unidade Básica de Saúde", autoFilter=true )
    @NotEmpty(message="Informe o nome da Unidade Básica de Saúde")
    private String nome;        //nome da unidade de saude
    
    @Column(length=20)
    @PropertyDescriptor(index=4, autoFilter=true, displayName="Bairro")
    @NotEmpty(message="Informe o Bairro da Unidade Básica de Saúde")
    private String bairro;              //bairro da unidade de saude
    
    @Column(length=20)
    @PropertyDescriptor(index=5, autoFilter=true, displayName="Distrito")
    @NotEmpty(message="Informe o Distrito da Unidade Básica de Saúde")
    private String distrito;            //distrito da unidade de saude
    
    @PropertyDescriptor(index=6, displayName="Município")
    @NotEmpty(message="Informe o Município da Unidade Básica de Saúde")
    private String municipio;              //municipio da unidade basica de saude
    
    @PropertyDescriptor(index=7, displayName="UF")
    @NotNull(message="Informe a Unidade Federativa do Estado da cidade da Unidade Básica de Saúde")
    private UnidadeBasicaDeSaude.UF uf;                  //unidade federativa do estado

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getScnes() {
        return scnes;
    }

    public void setScnes(Integer scnes) {
        this.scnes = scnes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return this.scnes + " - " + this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeBasicaDeSaude other = (UnidadeBasicaDeSaude) obj;
        if (this.scnes != other.scnes && (this.scnes == null || !this.scnes.equals(other.scnes))) {
            return false;
        }
        return true;
    }    
}
