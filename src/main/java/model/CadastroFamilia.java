/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.ADDPessoasMais;
import embeddable.ADDPessoasMenos;
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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Dhiego Sampaio
 */

@Entity
@Views({
    @View(name = "CadastroFamilia", title = "Familias Assistidas",
    filters = "Pesquisar Por:[endereco, Ctrl.DAO.filter()]",
    members = "["
    + "SECRETARIA MUNICIPAL DE SAÚDE SISTEMA DE INFORMAÇÃO DE ATENÇÃO BÁSICA [uf,endereco,numero,bairro;cep;municipio;segmento;area;microarea;familia;datas];"
    + "CADASTRO DA FAMÍLIA["
        + "addPessoasMais<nome,dataNasc,idade,sexo,alfabetizado,ocupacao,doenca,removerPessoa()>; adicionarPessoa();"
        + "addPessoasMais2<nome,dataNasc,idade,sexo,escola,ocupacao,doenca,removerCrianca()>; adicionarCrianca()"
    + "];"
    + "SITUAÇÃO DA MORADIA E SANEAMENTO[ "
        + "TIPO DE CASA[tipoCasa,outroTipoCasa;comodos;energia]:4;"
        + "DESTINO DO LIXO[destinoLixo],"
        + "TRATAMENTO DA ÁGUA NO DOMICÍLIO[tratamentoAgua],"
        + "ABASTECIMENTO DE ÁGUA[abastecimento],"
        + "DESTINO DE FEZES E URINA[destinoShit];"        
    +"];"
    + "OUTRAS INFORMAÇÕES[ "
        + "planoSaude,pessoasPlanoSaude;nomePlanoSaude:2;"
        + "CASO DE DOENÇA[casoDoenca;outroCasoDoenca],"
        + "GRUPOS COMUNITÁRIOS[participaGrupo;outroParticipaGrupo];"
        + "MEIOS DE COMUNICAÇÃO[meioComunicacao;outroMeioComunicacao];"
        + "MEIOS DE TRANSPORTE[meioTransporte;outroMeioTransporte]"
    + "];"
        + "observacoes;"
    + "]",
    template = "@CRUD+@PAGER",            
    roles = "Administrador, Atendente, AgenteDeSaude")
})

public class CadastroFamilia implements Serializable {
    
    public enum UF{ CE, AC, AL, AM, BA,  DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO}
    public enum TipoCasa{Tijolo,TaipaRevestida,TaipaNãoRevestida,Madeira,MaterialAproveitado,Outro}
    public enum SimNao{Sim,Nao}
    public enum DestinoLixo {Coletado,QueimadoEnterrado,CéuAberto}
    public enum Tratamento{Filtração,Fervura,Cloração,SemTratamento}
    public enum Agua{RedePública,PoçoOuNascente,Outros}
    public enum Shit{SistemaDeEsgoto,Fossa,CéuAberto}
    public enum Doenca{Hospital,UnidadeDeSaúde,Benzedeira,Farmácia,Outro}
    public enum Comunicacao{Rádio,Televisão,Outro}
    public enum Grupos{Cooperativa,GrupoReligioso,Associações,Outro}
    public enum Transporte{Ônibus,Caminhão,Carro,Carroça,Outro}
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Integer id;
        
    @NotNull(message="Informe a UF")
    @PropertyDescriptor(displayName="UF")
    private UF uf;
    
    @NotEmpty(message="Informe o endereço")
    @PropertyDescriptor(displayName="Endereço")
    private String endereco;
    
    @NotEmpty(message="Informe o número da residência")
    @PropertyDescriptor(displayName="Numero")  
    private Integer numero;
    
    @NotEmpty(message="Informe o bairro")
    @PropertyDescriptor(displayName="Bairro")
    private String bairro;
    
    @NotEmpty(message="Informe o CEP")
    @Column(length=9)
    @PropertyDescriptor(displayName="CEP", mask="99999-999")
    private String cep;
    
    @NotEmpty(message="Informe o município")
    @PropertyDescriptor(displayName="Município")
    private String municipio;
    
    @PropertyDescriptor(displayName="Segmento")
    private String segmento;
    
    @PropertyDescriptor(displayName="Área")
    private String area;
    
    @PropertyDescriptor(displayName="Microárea")
    private String microarea;
    
    @PropertyDescriptor(displayName="Família")  
    private Integer familia;
    
    @Past
    @PropertyDescriptor(displayName="Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datas;
    
    @PropertyDescriptor(displayName="Construção")
    private TipoCasa tipoCasa;
    
    @PropertyDescriptor(displayName="Especificação - Outro")
    private String outroTipoCasa;
    
    @PropertyDescriptor(displayName="Número de cômodos/peças")  
    private Integer comodos;
    
    @PropertyDescriptor(displayName = "Energia elétrica")
    private SimNao energia;
    
    @PropertyDescriptor(displayName = " ")
    private DestinoLixo destinoLixo;
    
    @PropertyDescriptor(displayName = " ")
    private Tratamento tratamentoAgua;
    
    @PropertyDescriptor(displayName = " ")
    private Agua abastecimento;
    
    @PropertyDescriptor(displayName = " ")
    private Shit destinoShit;
    
    @PropertyDescriptor(displayName = "Alguém da família possui Plano de Saúde?")
    private SimNao planoSaude;
    
    @PropertyDescriptor(displayName="Número de pessoas cobertas por Plano de Saúde")  
    private Integer pessoasPlanoSaude;
    
    @PropertyDescriptor(displayName="Nome do Plano de Saúde")
    private String nomePlanoSaude;
    
    @PropertyDescriptor(displayName = "Em caso de doença procura ")
    private Doenca casoDoenca;
    
    @PropertyDescriptor(displayName="Especificação - Outro")
    private String outroCasoDoenca;
    
    @PropertyDescriptor(displayName = "Meios de comunicação que mais utiliza")
    private Comunicacao meioComunicacao;
    
    @PropertyDescriptor(displayName="Especificação - Outro")
    private String outroMeioComunicacao;
    
    @PropertyDescriptor(displayName = "Participa de grupos comunitários")
    private Grupos participaGrupo;
    
    @PropertyDescriptor(displayName="Especificação - Outro")
    private String outroParticipaGrupo;
    
    @PropertyDescriptor(displayName = "Meios de transporte que mais utiliza")
    private Transporte meioTransporte;
    
    @PropertyDescriptor(displayName="Especificação - Outro")
    private String outroMeioTransporte;
    
    @Lob
    @PropertyDescriptor(displayName="OBSERVAÇÕES")
    private String observacoes;
    
    
    
    
    @PropertyDescriptor(displayName="Pessoas com 15 anos ou mais")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="cadastroFamilia")
    private List<ADDPessoasMais> addPessoasMais = new ArrayList<ADDPessoasMais>();
    
    @PropertyDescriptor(displayName="Pessoas de 0 a 14 anos")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="cadastroFamilia")
    private List<ADDPessoasMenos> addPessoasMais2 = new ArrayList<ADDPessoasMenos>(); 

    public void adicionarPessoa() {
        ADDPessoasMais addPPc = new ADDPessoasMais();
        addPPc.setCadastroFamilia(this);
        addPessoasMais.add(addPPc);
    }
    
    public void adicionarCrianca() {
        ADDPessoasMenos addPPc = new ADDPessoasMenos();
        addPPc.setCadastroFamilia(this);
        addPessoasMais2.add(addPPc);
    }
    
    
    

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMicroarea() {
        return microarea;
    }

    public void setMicroarea(String microarea) {
        this.microarea = microarea;
    }

    public Integer getFamilia() {
        return familia;
    }

    public void setFamilia(Integer familia) {
        this.familia = familia;
    }

    public Date getDatas() {
        return datas;
    }

    public void setDatas(Date datas) {
        this.datas = datas;
    }    

    public List<ADDPessoasMais> getAddPessoasMais() {
        return addPessoasMais;
    }

    public void setAddPessoasMais(List<ADDPessoasMais> addPessoasMais) {
        this.addPessoasMais = addPessoasMais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ADDPessoasMenos> getAddPessoasMais2() {
        return addPessoasMais2;
    }

    public void setAddPessoasMais2(List<ADDPessoasMenos> addPessoasMais2) {
        this.addPessoasMais2 = addPessoasMais2;
    }

    public TipoCasa getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(TipoCasa tipoCasa) {
        this.tipoCasa = tipoCasa;
    }

    public String getOutroTipoCasa() {
        return outroTipoCasa;
    }

    public void setOutroTipoCasa(String outroTipoCasa) {
        this.outroTipoCasa = outroTipoCasa;
    }

    public Integer getComodos() {
        return comodos;
    }

    public void setComodos(Integer comodos) {
        this.comodos = comodos;
    }

    public SimNao getEnergia() {
        return energia;
    }

    public void setEnergia(SimNao energia) {
        this.energia = energia;
    }

    public DestinoLixo getDestinoLixo() {
        return destinoLixo;
    }

    public void setDestinoLixo(DestinoLixo destinoLixo) {
        this.destinoLixo = destinoLixo;
    }

    public Tratamento getTratamentoAgua() {
        return tratamentoAgua;
    }

    public void setTratamentoAgua(Tratamento tratamentoAgua) {
        this.tratamentoAgua = tratamentoAgua;
    }

    public Agua getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(Agua abastecimento) {
        this.abastecimento = abastecimento;
    }

    public Shit getDestinoShit() {
        return destinoShit;
    }

    public void setDestinoShit(Shit destinoShit) {
        this.destinoShit = destinoShit;
    }

    public SimNao getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(SimNao planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Integer getPessoasPlanoSaude() {
        return pessoasPlanoSaude;
    }

    public void setPessoasPlanoSaude(Integer pessoasPlanoSaude) {
        this.pessoasPlanoSaude = pessoasPlanoSaude;
    }

    public String getNomePlanoSaude() {
        return nomePlanoSaude;
    }

    public void setNomePlanoSaude(String nomePlanoSaude) {
        this.nomePlanoSaude = nomePlanoSaude;
    }

    public Doenca getCasoDoenca() {
        return casoDoenca;
    }

    public void setCasoDoenca(Doenca casoDoenca) {
        this.casoDoenca = casoDoenca;
    }

    public String getOutroCasoDoenca() {
        return outroCasoDoenca;
    }

    public void setOutroCasoDoenca(String outroCasoDoenca) {
        this.outroCasoDoenca = outroCasoDoenca;
    }

    public Comunicacao getMeioComunicacao() {
        return meioComunicacao;
    }

    public void setMeioComunicacao(Comunicacao meioComunicacao) {
        this.meioComunicacao = meioComunicacao;
    }

    public String getOutroMeioComunicacao() {
        return outroMeioComunicacao;
    }

    public void setOutroMeioComunicacao(String outroMeioComunicacao) {
        this.outroMeioComunicacao = outroMeioComunicacao;
    }

    public Grupos getParticipaGrupo() {
        return participaGrupo;
    }

    public void setParticipaGrupo(Grupos participaGrupo) {
        this.participaGrupo = participaGrupo;
    }

    public String getOutroParticipaGrupo() {
        return outroParticipaGrupo;
    }

    public void setOutroParticipaGrupo(String outroParticipaGrupo) {
        this.outroParticipaGrupo = outroParticipaGrupo;
    }

    public Transporte getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(Transporte meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public String getOutroMeioTransporte() {
        return outroMeioTransporte;
    }

    public void setOutroMeioTransporte(String outroMeioTransporte) {
        this.outroMeioTransporte = outroMeioTransporte;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }    
      
}
