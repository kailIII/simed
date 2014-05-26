/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddable;

import entities.annotations.ActionDescriptor;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import model.AtendimentoIdoso;

/**
 *
 * @author marsellus
 */
@Entity
@EntityDescriptor(hidden = true, displayName = "Adicionar Sintoma")
public class ADDAcompanhamentoIdoso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Long ID;

    public enum Resposta {

        Sim, Não
    }

    public enum Seios {

        Direito, Esquerdo
    }

    public enum Quadrantes {

        Esquerdo1, Esquerdo2, Esquerdo3, Esquerdo4,
        Direito1, Direito2, Direito3, Direito4
    }

    public enum Sintomas {

        Zona_Displásica, Nódulos, Zona_Dolorosa, Descargas, Cicatriz, Retração
    }
    @PropertyDescriptor(displayName="Mamas Normais")
    private Resposta mamasNormais;
    
    @PropertyDescriptor(displayName="Seio")
    private Seios seios;
    
    @PropertyDescriptor(displayName="Quadrante")
    private Quadrantes quadrantes;
    
    @PropertyDescriptor(displayName="Sintoma")
    private Sintomas sintomas;
    
    @ManyToOne
    private AtendimentoIdoso IdosoAddAcompanhamento;

    @ActionDescriptor(methodDisabled = "#{not autoEntityBackBean.formInEditMode}")
    public void removerSintoma() {
        IdosoAddAcompanhamento.getAddAcompanhamentoIdoso().remove(this);
        
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public AtendimentoIdoso getIdosoAddAcompanhamento() {
        return IdosoAddAcompanhamento;
    }

    public void setIdosoAddAcompanhamento(AtendimentoIdoso IdosoAddAcompanhamento) {
        this.IdosoAddAcompanhamento = IdosoAddAcompanhamento;
    }

    public Resposta getMamasNormais() {
        return mamasNormais;
    }

    public void setMamasNormais(Resposta mamasNormais) {
        this.mamasNormais = mamasNormais;
    }

    public Seios getSeios() {
        return seios;
    }

    public void setSeios(Seios seios) {
        this.seios = seios;
    }

    public Quadrantes getQuadrantes() {
        return quadrantes;
    }

    public void setQuadrantes(Quadrantes quadrantes) {
        this.quadrantes = quadrantes;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }
}
