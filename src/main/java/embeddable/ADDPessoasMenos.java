/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddable;

import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.Past;
import model.CadastroFamilia;

/**
 *
 * @author user
 */

@Entity

public class ADDPessoasMenos implements Serializable{
    
    public enum Sexo{Masculino, Feminino}
    public enum Escola{Sim,Não}
    public enum Doenca{Alcoolismo,Chagas,Deficiência,Diabetes,Epilepsia,Gestação,HipertensãoArterial,Tuberculose,Hanseníase,Malária}
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @PropertyDescriptor(displayName="Nome")
    private String nome;
    
    @Past
    @PropertyDescriptor(displayName="Data Nasc.")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;
    
    @PropertyDescriptor(displayName="Idade")  
    private Integer idade;
    
    @PropertyDescriptor(displayName="Sexo")  
    private Sexo sexo;
    
    @PropertyDescriptor(displayName="Escola")  
    private Escola escola;
    
    @PropertyDescriptor(displayName="Ocupação")
    private String ocupacao;
    
    @PropertyDescriptor(displayName="Doença ou condição referida(sigla)")
    private Doenca doenca;
    
    @ManyToOne
    private CadastroFamilia cadastroFamilia;
        
    public void removerCrianca(){
    cadastroFamilia.getAddPessoasMais2().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public CadastroFamilia getCadastroFamilia() {
        return cadastroFamilia;
    }

    public void setCadastroFamilia(CadastroFamilia cadastroFamilia) {
        this.cadastroFamilia = cadastroFamilia;
    }
    
    
}
