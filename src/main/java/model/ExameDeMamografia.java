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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Felipe Rodrigues
 */

@Entity
@Views({
      @View(name = "exameDeMamografia", title = "Exame de Mamografia",
            filters = "Pesquisar Por:[paciente, Ctrl.DAO.filter()]",
            members = "["
                    + "[paciente;"
                    + "Ministério da Saúde[[uf;ubs],[codigoDeUnidadeDeSaude;municipio;municipioCodigo]];"
                    + "Tem nódulo ou Caroço na Mama?[noduloNaMama];"
                    + "Apresenta Risco Elevado para Câncer de Mama?[riscoElevado];"
                    + "Teve Suas Mamas Examinadas por Um Profissional"
                    + "de Saúde Antes Desta Consulta?[teveMamasExaminadas];"
                    + "Fez Mamografia Alguma Vez?[fezMamografia,dataUltimaMamografia];"
                    + "Controle Radiológico Categoria 3[[noduloMD;calcificacaoMD;assimetriaFocalMD;assimetriaDifusaMD;areaDensaMD;distorcaoFocalMD],"
                    + "                                 [noduloME;calcificacaoME;assimetriaFocalME;assimetriaDifusaME;areaDensaME;distorcaoFocalME]]],"
                    + "[Mamografira Diagnóstica["
                    + "Mama Direita["
                    + "[Descarga Papilar[cristalinaMD;hamorragicaMD];"
                    + "Localização do Nódulo[qslMD;qilMD;qsmMD;qimMD;uqistMD;uqsupMD;uqmedMD;uqintMD;rraMD;paMD];"
                    + "lesaoPapilarMD],"
                    + "[Linfonodo Palpável[axilarMD;supraclavicularMD];"
                    + "Localização do Espaçamento[qslMDE;qilMDE;qsmMDE;qimMDE;uqistMDE;uqsupMDE;uqmedMDE;uqintMDE;rraMDE;paMDE]]],"
                    + "Mama Esquerda["
                    + "[Descarga Papilar[cristalinaME;hamorragicaME];"
                    + "Localização do Nódulo[qslME;qilME;qsmME;qimME;uqistME;uqsupME;uqmedME;uqintME;rraME;paME];"
                    + "lesaoPapilarME],"
                    + "[Linfonodo Palpável[axilarME;supraclavicularME];"
                    + "Localização do Espaçamento[qslMEE;qilMEE;qsmMEE;qimMEE;uqistMEE;uqsupMEE;uqmedMEE;uqintMEE;rraMEE;paMEE]]]];"
                    + "[Lesão com Diagnóstico de Câncer[[noduloMDLesao;calcificacaoMDLesao;assimetriaFocalMDLesao;assimetriaDifusaMDLesao;areaDensaMDLesao;distorcaoFocalMDLesao],"
                    + "                                 [noduloMELesao;calcificacaoMELesao;assimetriaFocalMELesao;assimetriaDifusaMELesao;areaDensaMELesao;distorcaoFocalMELesao]],"
                    + "Mamografia de Rastreamento[dataDeSolicitacao;examinador;nomeDoExame]]]"
                    + "]",
            namedQuery = "pacienteNamedQuery",
            template = "@CRUD+@PAGER",
            roles = "Administrador")
        })

public class ExameDeMamografia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne()
    private Paciente paciente;
    
    
    // Ministério da Saúde
    @ManyToOne()
    @PropertyDescriptor(displayName = "UBS")
    private UnidadeBasicaDeSaude ubs;
    
    @PropertyDescriptor(displayName = "Código de Unidade de Saúde (CNES)")
    private int codigoDeUnidadeDeSaude;
    
    @PropertyDescriptor(displayName = "Município")
    private int municipio;
    
    @PropertyDescriptor(displayName = "Município (Código)")
    private int municipioCodigo;
    
    public enum UF{
        CE, AC, AL, AM, BA,  DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO
    }
    @PropertyDescriptor(displayName = "UF")
    private UF uf;
    
    
    // Dados da Anamnese (Unidade Solicitante)
    
    // 1 - Tem nódulo ou Caroço na Mama?
    public enum NoduloNaMama{
        Sim_Mama_Esquerda,Sim_Mama_Direita,Sim_Ambas,Não;
    }
    @PropertyDescriptor(displayName = " ")
    private NoduloNaMama noduloNaMama;
    
    
    // 2 - Apresenta Risco Elevado para Câncer de Mama?
    public enum RiscoElevadoParaCancer{
        Sim,Não,Não_Sabe;
    }
    @PropertyDescriptor(displayName = " ")
    private RiscoElevadoParaCancer riscoElevado;
    
    
    // 3 - Antes Desta Consulta, Teve Suas Mamas Examinadas por Um Profissional de Saúde?
    public  enum TeveMamasExaminadas{
        Sim,Nunca_Foram_Examinadas_Anteriormente;
    }
    @PropertyDescriptor(displayName = " ")
    private TeveMamasExaminadas teveMamasExaminadas;
    
    
    // 4 - Fez Mamografia Alguma Vez?
    public enum FezMamografia{
        Sim,Não,Não_Sabe;
    }
    @PropertyDescriptor(displayName = " ")
    private FezMamografia fezMamografia;
    
    @PropertyDescriptor(displayName = "Data da Última Mamografia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataUltimaMamografia;
    
    
    
    
    // ############################## Mama Direita ########################
    
    @PropertyDescriptor(displayName = "Lesão Papilar")
    private boolean lesaoPapilarMD = false;
    
    // Descarga Papilar
    @PropertyDescriptor(displayName = "Cristalina")
    private boolean cristalinaMD = false;
    @PropertyDescriptor(displayName = "Hamorrágica")
    private boolean hamorragicaMD = false;
    
    // Localização do Nódulo
    @PropertyDescriptor(displayName = "Quadrante Superior Lateral")
    private boolean qslMD = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Lateral")
    private boolean qilMD = false;
    @PropertyDescriptor(displayName = "Quadrante Superior Medial")
    private boolean qsmMD = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Medial")
    private boolean qimMD = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Laterais")
    private boolean uqistMD = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Superiores")
    private boolean uqsupMD = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Mediais")
    private boolean uqmedMD = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Internos")
    private boolean uqintMD = false;
    @PropertyDescriptor(displayName = "Região Retroareolar")
    private boolean rraMD = false;
    @PropertyDescriptor(displayName = "Prolongamento Axilar")
    private boolean paMD = false;
    
    //Localização do Espaçamento
    @PropertyDescriptor(displayName = "Quadrante Superior Lateral")
    private boolean qslMDE = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Lateral")
    private boolean qilMDE = false;
    @PropertyDescriptor(displayName = "Quadrante Superior Medial")
    private boolean qsmMDE = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Medial")
    private boolean qimMDE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Laterais")
    private boolean uqistMDE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Superiores")
    private boolean uqsupMDE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Mediais")
    private boolean uqmedMDE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Internos")
    private boolean uqintMDE = false;
    @PropertyDescriptor(displayName = "Região Retroareolar")
    private boolean rraMDE = false;
    @PropertyDescriptor(displayName = "Prolongamento Axilar")
    private boolean paMDE = false;
    
    // Linfonodo Palpável
    @PropertyDescriptor(displayName = "Axilar")
    private boolean axilarMD = false;
    @PropertyDescriptor(displayName = "Supraclavicular")
    private boolean supraclavicularMD = false;
    
    
    
    

    // ####################### Mama Esquerda ############################
    
    @PropertyDescriptor(displayName = "Lesão Papilar")
    private boolean lesaoPapilarME = false;
    
    // Descarga Papilar
    @PropertyDescriptor(displayName = "Cristalina")
    private boolean cristalinaME = false;
    @PropertyDescriptor(displayName = "Hamorrágica")
    private boolean hamorragicaME = false;
    
    // Localização do Nódulo
    @PropertyDescriptor(displayName = "Quadrante Superior Lateral")
    private boolean qslME = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Lateral")
    private boolean qilME = false;
    @PropertyDescriptor(displayName = "Quadrante Superior Medial")
    private boolean qsmME = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Medial")
    private boolean qimME = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Laterais")
    private boolean uqistME = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Superiores")
    private boolean uqsupME = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Mediais")
    private boolean uqmedME = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Internos")
    private boolean uqintME = false;
    @PropertyDescriptor(displayName = "Região Retroareolar")
    private boolean rraME = false;
    @PropertyDescriptor(displayName = "Prolongamento Axilar")
    private boolean paME = false;
    
    //Localização do Espaçamento
    @PropertyDescriptor(displayName = "Quadrante Superior Lateral")
    private boolean qslMEE = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Lateral")
    private boolean qilMEE = false;
    @PropertyDescriptor(displayName = "Quadrante Superior Medial")
    private boolean qsmMEE = false;
    @PropertyDescriptor(displayName = "Quadrante Inferior Medial")
    private boolean qimMEE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Laterais")
    private boolean uqistMEE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Superiores")
    private boolean uqsupMEE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Mediais")
    private boolean uqmedMEE = false;
    @PropertyDescriptor(displayName = "União dos Quadrantes Internos")
    private boolean uqintMEE = false;
    @PropertyDescriptor(displayName = "Região Retroareolar")
    private boolean rraMEE = false;
    @PropertyDescriptor(displayName = "Prolongamento Axilar")
    private boolean paMEE = false;
    
    // Linfonodo Palpável
    @PropertyDescriptor(displayName = "Axilar")
    private boolean axilarME = false;
    @PropertyDescriptor(displayName = "Supraclavicular")
    private boolean supraclavicularME = false;
 
    
    // Controle Radiológico Categoria 3
    @PropertyDescriptor(displayName = "Nódulo na Mama Direita")
    private boolean noduloMD;
    @PropertyDescriptor(displayName = "Nódulo na Mama Esquerda")
    private boolean noduloME;
    
    @PropertyDescriptor(displayName = "Microcalcificação na Mama Direita")
    private boolean calcificacaoMD;
    @PropertyDescriptor(displayName = "Microcalcificação na Mama Esquerda")
    private boolean calcificacaoME;
    
    @PropertyDescriptor(displayName = "Assimetria Focal na Mama Direita")
    private boolean assimetriaFocalMD;
    @PropertyDescriptor(displayName = "Assimetria Focal na Mama Esquerda")
    private boolean assimetriaFocalME;
    
    @PropertyDescriptor(displayName = "Assimetria Difusa na Mama Direita")
    private boolean assimetriaDifusaMD;
    @PropertyDescriptor(displayName = "Assimetria Difusa na Mama Esquerda")
    private boolean assimetriaDifusaME;
    
    @PropertyDescriptor(displayName = "Área Densa na Mama Direita")
    private boolean areaDensaMD;
    @PropertyDescriptor(displayName = "Área Densa na Mama Esquerda")
    private boolean areaDensaME;
    
    @PropertyDescriptor(displayName = "Distorção Focal na Mama Direita")
    private boolean distorcaoFocalMD;
    @PropertyDescriptor(displayName = "Distorção Focal na Mama Esquerda")
    private boolean distorcaoFocalME;
    
    
    
    // Lesão com Diagnóstico de Câncer
    @PropertyDescriptor(displayName = "Nódulo na Mama Direita")
    private boolean noduloMDLesao;
    @PropertyDescriptor(displayName = "Nódulo na Mama Esquerda")
    private boolean noduloMELesao;
    
    @PropertyDescriptor(displayName = "Microcalcificação na Mama Direita")
    private boolean calcificacaoMDLesao;
    @PropertyDescriptor(displayName = "Microcalcificação na Mama Esquerda")
    private boolean calcificacaoMELesao;
    
    @PropertyDescriptor(displayName = "Assimetria Focal na Mama Direita")
    private boolean assimetriaFocalMDLesao;
    @PropertyDescriptor(displayName = "Assimetria Focal na Mama Esquerda")
    private boolean assimetriaFocalMELesao;
    
    @PropertyDescriptor(displayName = "Assimetria Difusa na Mama Direita")
    private boolean assimetriaDifusaMDLesao;
    @PropertyDescriptor(displayName = "Assimetria Difusa na Mama Esquerda")
    private boolean assimetriaDifusaMELesao;
    
    @PropertyDescriptor(displayName = "Área Densa na Mama Direita")
    private boolean areaDensaMDLesao;
    @PropertyDescriptor(displayName = "Área Densa na Mama Esquerda")
    private boolean areaDensaMELesao;
    
    @PropertyDescriptor(displayName = "Distorção Focal na Mama Direita")
    private boolean distorcaoFocalMDLesao;
    @PropertyDescriptor(displayName = "Distorção Focal na Mama Esquerda")
    private boolean distorcaoFocalMELesao;
    
    
    
    // Mamografia de Rastreamento
    @PropertyDescriptor(displayName = "Data de Solicitação")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeSolicitacao;
    
    @PropertyDescriptor(displayName = "Examinador")
    private String examinador;
    
    @PropertyDescriptor(displayName = "Nome do Exame")
    private String nomeDoExame;
    

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

    public int getCodigoDeUnidadeDeSaude() {
        return codigoDeUnidadeDeSaude;
    }

    public void setCodigoDeUnidadeDeSaude(int codigoDeUnidadeDeSaude) {
        this.codigoDeUnidadeDeSaude = codigoDeUnidadeDeSaude;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public int getMunicipioCodigo() {
        return municipioCodigo;
    }

    public void setMunicipioCodigo(int municipioCodigo) {
        this.municipioCodigo = municipioCodigo;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public NoduloNaMama getNoduloNaMama() {
        return noduloNaMama;
    }

    public void setNoduloNaMama(NoduloNaMama noduloNaMama) {
        this.noduloNaMama = noduloNaMama;
    }

    public RiscoElevadoParaCancer getRiscoElevado() {
        return riscoElevado;
    }

    public void setRiscoElevado(RiscoElevadoParaCancer riscoElevado) {
        this.riscoElevado = riscoElevado;
    }

    public TeveMamasExaminadas getTeveMamasExaminadas() {
        return teveMamasExaminadas;
    }

    public void setTeveMamasExaminadas(TeveMamasExaminadas teveMamasExaminadas) {
        this.teveMamasExaminadas = teveMamasExaminadas;
    }

    public FezMamografia getFezMamografia() {
        return fezMamografia;
    }

    public void setFezMamografia(FezMamografia fezMamografia) {
        this.fezMamografia = fezMamografia;
    }

    public Date getDataUltimaMamografia() {
        return dataUltimaMamografia;
    }

    public void setDataUltimaMamografia(Date dataUltimaMamografia) {
        this.dataUltimaMamografia = dataUltimaMamografia;
    }

    public boolean isLesaoPapilarMD() {
        return lesaoPapilarMD;
    }

    public void setLesaoPapilarMD(boolean lesaoPapilarMD) {
        this.lesaoPapilarMD = lesaoPapilarMD;
    }

    public boolean isCristalinaMD() {
        return cristalinaMD;
    }

    public void setCristalinaMD(boolean cristalinaMD) {
        this.cristalinaMD = cristalinaMD;
    }

    public boolean isHamorragicaMD() {
        return hamorragicaMD;
    }

    public void setHamorragicaMD(boolean hamorragicaMD) {
        this.hamorragicaMD = hamorragicaMD;
    }

    public boolean isQslMD() {
        return qslMD;
    }

    public void setQslMD(boolean qslMD) {
        this.qslMD = qslMD;
    }

    public boolean isQilMD() {
        return qilMD;
    }

    public void setQilMD(boolean qilMD) {
        this.qilMD = qilMD;
    }

    public boolean isQsmMD() {
        return qsmMD;
    }

    public void setQsmMD(boolean qsmMD) {
        this.qsmMD = qsmMD;
    }

    public boolean isQimMD() {
        return qimMD;
    }

    public void setQimMD(boolean qimMD) {
        this.qimMD = qimMD;
    }

    public boolean isUqistMD() {
        return uqistMD;
    }

    public void setUqistMD(boolean uqistMD) {
        this.uqistMD = uqistMD;
    }

    public boolean isUqsupMD() {
        return uqsupMD;
    }

    public void setUqsupMD(boolean uqsupMD) {
        this.uqsupMD = uqsupMD;
    }

    public boolean isUqmedMD() {
        return uqmedMD;
    }

    public void setUqmedMD(boolean uqmedMD) {
        this.uqmedMD = uqmedMD;
    }

    public boolean isUqintMD() {
        return uqintMD;
    }

    public void setUqintMD(boolean uqintMD) {
        this.uqintMD = uqintMD;
    }

    public boolean isRraMD() {
        return rraMD;
    }

    public void setRraMD(boolean rraMD) {
        this.rraMD = rraMD;
    }

    public boolean isPaMD() {
        return paMD;
    }

    public void setPaMD(boolean paMD) {
        this.paMD = paMD;
    }

    public boolean isQslMDE() {
        return qslMDE;
    }

    public void setQslMDE(boolean qslMDE) {
        this.qslMDE = qslMDE;
    }

    public boolean isQilMDE() {
        return qilMDE;
    }

    public void setQilMDE(boolean qilMDE) {
        this.qilMDE = qilMDE;
    }

    public boolean isQsmMDE() {
        return qsmMDE;
    }

    public void setQsmMDE(boolean qsmMDE) {
        this.qsmMDE = qsmMDE;
    }

    public boolean isQimMDE() {
        return qimMDE;
    }

    public void setQimMDE(boolean qimMDE) {
        this.qimMDE = qimMDE;
    }

    public boolean isUqistMDE() {
        return uqistMDE;
    }

    public void setUqistMDE(boolean uqistMDE) {
        this.uqistMDE = uqistMDE;
    }

    public boolean isUqsupMDE() {
        return uqsupMDE;
    }

    public void setUqsupMDE(boolean uqsupMDE) {
        this.uqsupMDE = uqsupMDE;
    }

    public boolean isUqmedMDE() {
        return uqmedMDE;
    }

    public void setUqmedMDE(boolean uqmedMDE) {
        this.uqmedMDE = uqmedMDE;
    }

    public boolean isUqintMDE() {
        return uqintMDE;
    }

    public void setUqintMDE(boolean uqintMDE) {
        this.uqintMDE = uqintMDE;
    }

    public boolean isRraMDE() {
        return rraMDE;
    }

    public void setRraMDE(boolean rraMDE) {
        this.rraMDE = rraMDE;
    }

    public boolean isPaMDE() {
        return paMDE;
    }

    public void setPaMDE(boolean paMDE) {
        this.paMDE = paMDE;
    }

    public boolean isAxilarMD() {
        return axilarMD;
    }

    public void setAxilarMD(boolean axilarMD) {
        this.axilarMD = axilarMD;
    }

    public boolean isSupraclavicularMD() {
        return supraclavicularMD;
    }

    public void setSupraclavicularMD(boolean supraclavicularMD) {
        this.supraclavicularMD = supraclavicularMD;
    }

    public boolean isLesaoPapilarME() {
        return lesaoPapilarME;
    }

    public void setLesaoPapilarME(boolean lesaoPapilarME) {
        this.lesaoPapilarME = lesaoPapilarME;
    }

    public boolean isCristalinaME() {
        return cristalinaME;
    }

    public void setCristalinaME(boolean cristalinaME) {
        this.cristalinaME = cristalinaME;
    }

    public boolean isHamorragicaME() {
        return hamorragicaME;
    }

    public void setHamorragicaME(boolean hamorragicaME) {
        this.hamorragicaME = hamorragicaME;
    }

    public boolean isQslME() {
        return qslME;
    }

    public void setQslME(boolean qslME) {
        this.qslME = qslME;
    }

    public boolean isQilME() {
        return qilME;
    }

    public void setQilME(boolean qilME) {
        this.qilME = qilME;
    }

    public boolean isQsmME() {
        return qsmME;
    }

    public void setQsmME(boolean qsmME) {
        this.qsmME = qsmME;
    }

    public boolean isQimME() {
        return qimME;
    }

    public void setQimME(boolean qimME) {
        this.qimME = qimME;
    }

    public boolean isUqistME() {
        return uqistME;
    }

    public void setUqistME(boolean uqistME) {
        this.uqistME = uqistME;
    }

    public boolean isUqsupME() {
        return uqsupME;
    }

    public void setUqsupME(boolean uqsupME) {
        this.uqsupME = uqsupME;
    }

    public boolean isUqmedME() {
        return uqmedME;
    }

    public void setUqmedME(boolean uqmedME) {
        this.uqmedME = uqmedME;
    }

    public boolean isUqintME() {
        return uqintME;
    }

    public void setUqintME(boolean uqintME) {
        this.uqintME = uqintME;
    }

    public boolean isRraME() {
        return rraME;
    }

    public void setRraME(boolean rraME) {
        this.rraME = rraME;
    }

    public boolean isPaME() {
        return paME;
    }

    public void setPaME(boolean paME) {
        this.paME = paME;
    }

    public boolean isQslMEE() {
        return qslMEE;
    }

    public void setQslMEE(boolean qslMEE) {
        this.qslMEE = qslMEE;
    }

    public boolean isQilMEE() {
        return qilMEE;
    }

    public void setQilMEE(boolean qilMEE) {
        this.qilMEE = qilMEE;
    }

    public boolean isQsmMEE() {
        return qsmMEE;
    }

    public void setQsmMEE(boolean qsmMEE) {
        this.qsmMEE = qsmMEE;
    }

    public boolean isQimMEE() {
        return qimMEE;
    }

    public void setQimMEE(boolean qimMEE) {
        this.qimMEE = qimMEE;
    }

    public boolean isUqistMEE() {
        return uqistMEE;
    }

    public void setUqistMEE(boolean uqistMEE) {
        this.uqistMEE = uqistMEE;
    }

    public boolean isUqsupMEE() {
        return uqsupMEE;
    }

    public void setUqsupMEE(boolean uqsupMEE) {
        this.uqsupMEE = uqsupMEE;
    }

    public boolean isUqmedMEE() {
        return uqmedMEE;
    }

    public void setUqmedMEE(boolean uqmedMEE) {
        this.uqmedMEE = uqmedMEE;
    }

    public boolean isUqintMEE() {
        return uqintMEE;
    }

    public void setUqintMEE(boolean uqintMEE) {
        this.uqintMEE = uqintMEE;
    }

    public boolean isRraMEE() {
        return rraMEE;
    }

    public void setRraMEE(boolean rraMEE) {
        this.rraMEE = rraMEE;
    }

    public boolean isPaMEE() {
        return paMEE;
    }

    public void setPaMEE(boolean paMEE) {
        this.paMEE = paMEE;
    }

    public boolean isAxilarME() {
        return axilarME;
    }

    public void setAxilarME(boolean axilarME) {
        this.axilarME = axilarME;
    }

    public boolean isSupraclavicularME() {
        return supraclavicularME;
    }

    public void setSupraclavicularME(boolean supraclavicularME) {
        this.supraclavicularME = supraclavicularME;
    }

    public boolean isNoduloMD() {
        return noduloMD;
    }

    public void setNoduloMD(boolean noduloMD) {
        this.noduloMD = noduloMD;
    }

    public boolean isNoduloME() {
        return noduloME;
    }

    public void setNoduloME(boolean noduloME) {
        this.noduloME = noduloME;
    }

    public boolean isCalcificacaoMD() {
        return calcificacaoMD;
    }

    public void setCalcificacaoMD(boolean calcificacaoMD) {
        this.calcificacaoMD = calcificacaoMD;
    }

    public boolean isCalcificacaoME() {
        return calcificacaoME;
    }

    public void setCalcificacaoME(boolean calcificacaoME) {
        this.calcificacaoME = calcificacaoME;
    }

    public boolean isAssimetriaFocalMD() {
        return assimetriaFocalMD;
    }

    public void setAssimetriaFocalMD(boolean assimetriaFocalMD) {
        this.assimetriaFocalMD = assimetriaFocalMD;
    }

    public boolean isAssimetriaFocalME() {
        return assimetriaFocalME;
    }

    public void setAssimetriaFocalME(boolean assimetriaFocalME) {
        this.assimetriaFocalME = assimetriaFocalME;
    }

    public boolean isAssimetriaDifusaMD() {
        return assimetriaDifusaMD;
    }

    public void setAssimetriaDifusaMD(boolean assimetriaDifusaMD) {
        this.assimetriaDifusaMD = assimetriaDifusaMD;
    }

    public boolean isAssimetriaDifusaME() {
        return assimetriaDifusaME;
    }

    public void setAssimetriaDifusaME(boolean assimetriaDifusaME) {
        this.assimetriaDifusaME = assimetriaDifusaME;
    }

    public boolean isAreaDensaMD() {
        return areaDensaMD;
    }

    public void setAreaDensaMD(boolean areaDensaMD) {
        this.areaDensaMD = areaDensaMD;
    }

    public boolean isAreaDensaME() {
        return areaDensaME;
    }

    public void setAreaDensaME(boolean areaDensaME) {
        this.areaDensaME = areaDensaME;
    }

    public boolean isDistorcaoFocalMD() {
        return distorcaoFocalMD;
    }

    public void setDistorcaoFocalMD(boolean distorcaoFocalMD) {
        this.distorcaoFocalMD = distorcaoFocalMD;
    }

    public boolean isDistorcaoFocalME() {
        return distorcaoFocalME;
    }

    public void setDistorcaoFocalME(boolean distorcaoFocalME) {
        this.distorcaoFocalME = distorcaoFocalME;
    }

    public boolean isNoduloMDLesao() {
        return noduloMDLesao;
    }

    public void setNoduloMDLesao(boolean noduloMDLesao) {
        this.noduloMDLesao = noduloMDLesao;
    }

    public boolean isNoduloMELesao() {
        return noduloMELesao;
    }

    public void setNoduloMELesao(boolean noduloMELesao) {
        this.noduloMELesao = noduloMELesao;
    }

    public boolean isCalcificacaoMDLesao() {
        return calcificacaoMDLesao;
    }

    public void setCalcificacaoMDLesao(boolean calcificacaoMDLesao) {
        this.calcificacaoMDLesao = calcificacaoMDLesao;
    }

    public boolean isCalcificacaoMELesao() {
        return calcificacaoMELesao;
    }

    public void setCalcificacaoMELesao(boolean calcificacaoMELesao) {
        this.calcificacaoMELesao = calcificacaoMELesao;
    }

    public boolean isAssimetriaFocalMDLesao() {
        return assimetriaFocalMDLesao;
    }

    public void setAssimetriaFocalMDLesao(boolean assimetriaFocalMDLesao) {
        this.assimetriaFocalMDLesao = assimetriaFocalMDLesao;
    }

    public boolean isAssimetriaFocalMELesao() {
        return assimetriaFocalMELesao;
    }

    public void setAssimetriaFocalMELesao(boolean assimetriaFocalMELesao) {
        this.assimetriaFocalMELesao = assimetriaFocalMELesao;
    }

    public boolean isAssimetriaDifusaMDLesao() {
        return assimetriaDifusaMDLesao;
    }

    public void setAssimetriaDifusaMDLesao(boolean assimetriaDifusaMDLesao) {
        this.assimetriaDifusaMDLesao = assimetriaDifusaMDLesao;
    }

    public boolean isAssimetriaDifusaMELesao() {
        return assimetriaDifusaMELesao;
    }

    public void setAssimetriaDifusaMELesao(boolean assimetriaDifusaMELesao) {
        this.assimetriaDifusaMELesao = assimetriaDifusaMELesao;
    }

    public boolean isAreaDensaMDLesao() {
        return areaDensaMDLesao;
    }

    public void setAreaDensaMDLesao(boolean areaDensaMDLesao) {
        this.areaDensaMDLesao = areaDensaMDLesao;
    }

    public boolean isAreaDensaMELesao() {
        return areaDensaMELesao;
    }

    public void setAreaDensaMELesao(boolean areaDensaMELesao) {
        this.areaDensaMELesao = areaDensaMELesao;
    }

    public boolean isDistorcaoFocalMDLesao() {
        return distorcaoFocalMDLesao;
    }

    public void setDistorcaoFocalMDLesao(boolean distorcaoFocalMDLesao) {
        this.distorcaoFocalMDLesao = distorcaoFocalMDLesao;
    }

    public boolean isDistorcaoFocalMELesao() {
        return distorcaoFocalMELesao;
    }

    public void setDistorcaoFocalMELesao(boolean distorcaoFocalMELesao) {
        this.distorcaoFocalMELesao = distorcaoFocalMELesao;
    }

    public Date getDataDeSolicitacao() {
        return dataDeSolicitacao;
    }

    public void setDataDeSolicitacao(Date dataDeSolicitacao) {
        this.dataDeSolicitacao = dataDeSolicitacao;
    }

    public String getExaminador() {
        return examinador;
    }

    public void setExaminador(String examinador) {
        this.examinador = examinador;
    }

    public String getNomeDoExame() {
        return nomeDoExame;
    }

    public void setNomeDoExame(String nomeDoExame) {
        this.nomeDoExame = nomeDoExame;
    }
    
    
}
