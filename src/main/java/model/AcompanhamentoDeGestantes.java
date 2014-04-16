/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.Editor;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kbesa
 */

@Entity
@NamedQueries({
@NamedQuery(name = "VerificacaoDasGestantes",
            query = "Select p From Paciente p Where p.sexoPaciente = 1 Order By p.cns")
})
@Views({
      @View(name = "listaDeVerificacaoDaUsuaria", title = "Lista de Verificação da Usuária",
            filters = "Pesquisar Por:[paciente, Ctrl.DAO.filter()]",
            members = "["
                    + "[Unidade[ubs;nomeACS;municipioCodigo;segmento;area;microarea;dataCadastro];"
                    + "Dados do Paciente[paciente;endereco;numero;bairro];"
                    + "Data da Última Regra[dataUltimaRegra]],"
                    + "[Estado Nutricional[mes1;mes2;mes3;mes4;mes5;mes6;mes7;mes8;mes9];"
                    + "Data da Consulta de Puerpério[consulta1;consulta2];"
                    + "Data Provável do Parto[dataProvavelDoParto]],"
                    + "[Data da Consulta de Pré-Natal[mesGestacao1;mesGestacao2;mesGestacao3;mesGestacao4;mesGestacao5;mesGestacao6;mesGestacao7;mesGestacao8;mesGestacao9];"
                    + "Data da Vacina[dataDaVacina1;dataDaVacina2;dataDaVacina3;dataDaVacinaR]],"
                    + "[Fatores de Risco[gestacoes;nanimortoAborto;maisDe36;menosDe20;sangramento;edema;diabetes;pressaoAlta];"
                    + "Resultado da Gestação Atual[dataNascimento;resultado];"
                    + "Observação[observacao]]"
                    + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador")})


public class AcompanhamentoDeGestantes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne()
    @Editor(namedQuery = "VerificacaoDasGestantes")
    private Paciente paciente;
    
    
    
    //Unidade
    @NotNull
    @ManyToOne()
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
    private String nomeACS;
    
    //Data do Cadastro da Gestante
    @PropertyDescriptor(displayName = "Data de Cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    
    //Identificação da Gestante
    @PropertyDescriptor(displayName = "Endereço")
    private String endereco;
    
    @PropertyDescriptor(displayName = "Numero")
    private String numero;
    
    @PropertyDescriptor(displayName = "Bairro")
    private String bairro;
    
    
    //Data da Última Regra e Data Provável do Parto
    @PropertyDescriptor(displayName = " ")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataUltimaRegra;
    
    @PropertyDescriptor(displayName = " ")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataProvavelDoParto;
    
    
    //Data da Vacina
    @PropertyDescriptor(displayName = "Vacina 1")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDaVacina1;
    @PropertyDescriptor(displayName = "Vacina 2")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDaVacina2;
    @PropertyDescriptor(displayName = "Vacina 3")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDaVacina3;
    @PropertyDescriptor(displayName = "Vacina R")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDaVacinaR;
    
    
    public enum EstadoNutricional{
        Nutrida,Desnutrida;
    }
   
    //Estado Nutricional
    @PropertyDescriptor(displayName = "1º Mês de gestação")
    private EstadoNutricional mes1;
    @PropertyDescriptor(displayName = "2º Mês de gestação")
    private EstadoNutricional mes2;
    @PropertyDescriptor(displayName = "3º Mês de gestação")
    private EstadoNutricional mes3;
    @PropertyDescriptor(displayName = "4º Mês de gestação")
    private EstadoNutricional mes4;
    @PropertyDescriptor(displayName = "5º Mês de gestação")
    private EstadoNutricional mes5;
    @PropertyDescriptor(displayName = "6º Mês de gestação")
    private EstadoNutricional mes6;
    @PropertyDescriptor(displayName = "7º Mês de gestação")
    private EstadoNutricional mes7;
    @PropertyDescriptor(displayName = "8º Mês de gestação")
    private EstadoNutricional mes8;
    @PropertyDescriptor(displayName = "9º Mês de gestação")
    private EstadoNutricional mes9;
    
    
    //Data da Consulta PréNatal
    @PropertyDescriptor(displayName = "1º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao1;
    @PropertyDescriptor(displayName = "2º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao2;
    @PropertyDescriptor(displayName = "3º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao3;
    @PropertyDescriptor(displayName = "4º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao4;
    @PropertyDescriptor(displayName = "5º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao5;
    @PropertyDescriptor(displayName = "6º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao6;
    @PropertyDescriptor(displayName = "7º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao7;
    @PropertyDescriptor(displayName = "8º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao8;
    @PropertyDescriptor(displayName = "9º Mês de gestação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mesGestacao9;
    
    
    //Fatores de Risco
    @PropertyDescriptor(displayName = "6 ou Mais Gestações")
    private boolean gestacoes = false;
    @PropertyDescriptor(displayName = "Nanimorto/Aborto")
    private boolean nanimortoAborto = false;
    @PropertyDescriptor(displayName = "36 Anos ou Mais")
    private boolean maisDe36 = false;
    @PropertyDescriptor(displayName = "Menos de 20 Anos")
    private boolean menosDe20 = false;
    @PropertyDescriptor(displayName = "Sangramento")
    private boolean sangramento = false;
    @PropertyDescriptor(displayName = "Edema")
    private boolean edema = false;
    @PropertyDescriptor(displayName = "Diabetes")
    private boolean diabetes = false;
    @PropertyDescriptor(displayName = "Pressão Alta")
    private boolean pressaoAlta = false;

    
    //Resultado da Gestação Atual
    public enum ResultadoDaGestacao{
        Nascido_Vivo,Nascido_Morto,Abortado;
    }
    
    @PropertyDescriptor(displayName = "Data de Nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @PropertyDescriptor(displayName = "Resultado da Gestação")
    private ResultadoDaGestacao resultado;
    
    
    //Data da Consulta de Puerpério
    @PropertyDescriptor(displayName = "1ª Consulta")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date consulta1;
    
    @PropertyDescriptor(displayName = "2ª Consulta")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date consulta2;
    
    
    //Observação
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public UnidadeBasicaDeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeBasicaDeSaude ubs) {
        this.ubs = ubs;
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

    public String getNomeACS() {
        return nomeACS;
    }

    public void setNomeACS(String nomeACS) {
        this.nomeACS = nomeACS;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Date getDataUltimaRegra() {
        return dataUltimaRegra;
    }

    public void setDataUltimaRegra(Date dataUltimaRegra) {
        this.dataUltimaRegra = dataUltimaRegra;
    }

    public Date getDataProvavelDoParto() {
        return dataProvavelDoParto;
    }

    public void setDataProvavelDoParto(Date dataProvavelDoParto) {
        this.dataProvavelDoParto = dataProvavelDoParto;
    }

    public Date getDataDaVacina1() {
        return dataDaVacina1;
    }

    public void setDataDaVacina1(Date dataDaVacina1) {
        this.dataDaVacina1 = dataDaVacina1;
    }

    public Date getDataDaVacina2() {
        return dataDaVacina2;
    }

    public void setDataDaVacina2(Date dataDaVacina2) {
        this.dataDaVacina2 = dataDaVacina2;
    }

    public Date getDataDaVacina3() {
        return dataDaVacina3;
    }

    public void setDataDaVacina3(Date dataDaVacina3) {
        this.dataDaVacina3 = dataDaVacina3;
    }

    public Date getDataDaVacinaR() {
        return dataDaVacinaR;
    }

    public void setDataDaVacinaR(Date dataDaVacinaR) {
        this.dataDaVacinaR = dataDaVacinaR;
    }

    public EstadoNutricional getMes1() {
        return mes1;
    }

    public void setMes1(EstadoNutricional mes1) {
        this.mes1 = mes1;
    }

    public EstadoNutricional getMes2() {
        return mes2;
    }

    public void setMes2(EstadoNutricional mes2) {
        this.mes2 = mes2;
    }

    public EstadoNutricional getMes3() {
        return mes3;
    }

    public void setMes3(EstadoNutricional mes3) {
        this.mes3 = mes3;
    }

    public EstadoNutricional getMes4() {
        return mes4;
    }

    public void setMes4(EstadoNutricional mes4) {
        this.mes4 = mes4;
    }

    public EstadoNutricional getMes5() {
        return mes5;
    }

    public void setMes5(EstadoNutricional mes5) {
        this.mes5 = mes5;
    }

    public EstadoNutricional getMes6() {
        return mes6;
    }

    public void setMes6(EstadoNutricional mes6) {
        this.mes6 = mes6;
    }

    public EstadoNutricional getMes7() {
        return mes7;
    }

    public void setMes7(EstadoNutricional mes7) {
        this.mes7 = mes7;
    }

    public EstadoNutricional getMes8() {
        return mes8;
    }

    public void setMes8(EstadoNutricional mes8) {
        this.mes8 = mes8;
    }

    public EstadoNutricional getMes9() {
        return mes9;
    }

    public void setMes9(EstadoNutricional mes9) {
        this.mes9 = mes9;
    }

    public Date getMesGestacao1() {
        return mesGestacao1;
    }

    public void setMesGestacao1(Date mesGestacao1) {
        this.mesGestacao1 = mesGestacao1;
    }

    public Date getMesGestacao2() {
        return mesGestacao2;
    }

    public void setMesGestacao2(Date mesGestacao2) {
        this.mesGestacao2 = mesGestacao2;
    }

    public Date getMesGestacao3() {
        return mesGestacao3;
    }

    public void setMesGestacao3(Date mesGestacao3) {
        this.mesGestacao3 = mesGestacao3;
    }

    public Date getMesGestacao4() {
        return mesGestacao4;
    }

    public void setMesGestacao4(Date mesGestacao4) {
        this.mesGestacao4 = mesGestacao4;
    }

    public Date getMesGestacao5() {
        return mesGestacao5;
    }

    public void setMesGestacao5(Date mesGestacao5) {
        this.mesGestacao5 = mesGestacao5;
    }

    public Date getMesGestacao6() {
        return mesGestacao6;
    }

    public void setMesGestacao6(Date mesGestacao6) {
        this.mesGestacao6 = mesGestacao6;
    }

    public Date getMesGestacao7() {
        return mesGestacao7;
    }

    public void setMesGestacao7(Date mesGestacao7) {
        this.mesGestacao7 = mesGestacao7;
    }

    public Date getMesGestacao8() {
        return mesGestacao8;
    }

    public void setMesGestacao8(Date mesGestacao8) {
        this.mesGestacao8 = mesGestacao8;
    }

    public Date getMesGestacao9() {
        return mesGestacao9;
    }

    public void setMesGestacao9(Date mesGestacao9) {
        this.mesGestacao9 = mesGestacao9;
    }

    public boolean isGestacoes() {
        return gestacoes;
    }

    public void setGestacoes(boolean gestacoes) {
        this.gestacoes = gestacoes;
    }

    public boolean isNanimortoAborto() {
        return nanimortoAborto;
    }

    public void setNanimortoAborto(boolean nanimortoAborto) {
        this.nanimortoAborto = nanimortoAborto;
    }

    public boolean isMaisDe36() {
        return maisDe36;
    }

    public void setMaisDe36(boolean maisDe36) {
        this.maisDe36 = maisDe36;
    }

    public boolean isMenosDe20() {
        return menosDe20;
    }

    public void setMenosDe20(boolean menosDe20) {
        this.menosDe20 = menosDe20;
    }

    public boolean isSangramento() {
        return sangramento;
    }

    public void setSangramento(boolean sangramento) {
        this.sangramento = sangramento;
    }

    public boolean isEdema() {
        return edema;
    }

    public void setEdema(boolean edema) {
        this.edema = edema;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isPressaoAlta() {
        return pressaoAlta;
    }

    public void setPressaoAlta(boolean pressaoAlta) {
        this.pressaoAlta = pressaoAlta;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ResultadoDaGestacao getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoDaGestacao resultado) {
        this.resultado = resultado;
    }

    public Date getConsulta1() {
        return consulta1;
    }

    public void setConsulta1(Date consulta1) {
        this.consulta1 = consulta1;
    }

    public Date getConsulta2() {
        return consulta2;
    }

    public void setConsulta2(Date consulta2) {
        this.consulta2 = consulta2;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    
}
