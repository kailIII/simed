/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddable;

import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Yarllysson
 */
@Embeddable
public class DiasDaSemana implements Serializable {
    
    @PropertyDescriptor(displayName = "1. Segunda-Feira")
    private Boolean segunda = false;
    
    @PropertyDescriptor(displayName = "2. Terça-Feira")
    private Boolean terca = false;
    
    @PropertyDescriptor(displayName = "3. Quarta-Feira")
    private Boolean quarta = false;
    
    @PropertyDescriptor(displayName = "4. Quinta-Feira")
    private Boolean quinta = false;
    
    @PropertyDescriptor(displayName = "5. Sexta-Feira")
    private Boolean sexta = false;
    
    @PropertyDescriptor(displayName = "6. Sábado")
    private Boolean sabado = false;
    
    @PropertyDescriptor(displayName = "7. Domingo")
    private Boolean domingo = false;

    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }

    public Boolean getQuarta() {
        return quarta;
    }

    public void setQuarta(Boolean quarta) {
        this.quarta = quarta;
    }

    public Boolean getQuinta() {
        return quinta;
    }

    public void setQuinta(Boolean quinta) {
        this.quinta = quinta;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public Boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(Boolean segunda) {
        this.segunda = segunda;
    }

    public Boolean getSexta() {
        return sexta;
    }

    public void setSexta(Boolean sexta) {
        this.sexta = sexta;
    }

    public Boolean getTerca() {
        return terca;
    }

    public void setTerca(Boolean terca) {
        this.terca = terca;
    }
    
    
}
