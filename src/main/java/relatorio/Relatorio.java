
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.util.Date;
import model.UnidadeBasicaDeSaude;


/**
 *
 * @author yarllysson
 */

public class Relatorio {

    private String medicamento;
    private String numeroLote;
    private int quantidade;
    private Date dataValidade;
    private String nomeProduto;
    private String nomeFornecedor;
    private Date dataEntrada;
    private Long valorUnitario;
    private Long valorTotal;
    private String cbo;
    
    private Long codigo;
    private Long idade;
    private String nome;
    private String endereco;
    private String municipio;
    private String unidadeDeSaude;
    private Integer numeroProntuario;
    private Date dataNascimento;
    private String estadoCivil;
    private String escolaridade;
    private Date dataConsulta;
    private String horaConsulta;
    private String nomeResponsavel;
    private String sala;
    private String numeroConsulta;
    private String autocuidado;
    private String individual;
    private String grupo;
    private String entregaMaterialEducativo;
    private String escutaComAtencao;
    private String fazPerguntas;
    private String leMaterialEducativo;
    private String segueRecomendacoes;
    private String antedidaPorMedico;
    private String antedidaPorEnfermeiro;
    private String antedidaPorOutro;
    private String peso;
    private String pa;
    private String seguimento;
    private String rubrica;
    private int numeroFilhosVivos;
    private int natimorto;
    private int numeroPartosVaginais;
    private int numeroPartosCesareas;
    private Date ultimoAborto;
    private int numeroDosesVacinaAntitetanica;
    private Date doseVacina1;
    private Date doseVacina2;
    private Date doseVacina3;
    private Date doseReforcoVacina;
    private String ocorrenciasGestacao;

    public enum Resposta{
        Sim,Não
    }
    
    public enum Seios{
        Direito,Esquerdo
    }
    
    public enum Quadrantes{
        Esquerdo1,Esquerdo2,Esquerdo3,Esquerdo4,
        Direito1,Direito2,Direito3,Direito4
    }
    
    public enum Sintomas{    
        Zona_Displásica,Nódulos,Zona_Dolorosa,Descargas,Cicatriz,Retração
    }
    
    private Boolean nova;
    private Boolean controle;
    
    
    private Boolean umATres;
    private Boolean maisDeTres;
    private Boolean maisDeCinco;
    private Boolean ignorado;
    
    private String paciente_radio;
    private String paciente_gestante;
    private String paciente_trh;
    
    private String tipo_remedio;
    private String tempoUso;
    private String causaInterrupcao;
    private String inicioVidaSexual;
    
   
    private String gesta;
    private String para;
    private String aborto;
    private String ultimaGravidez;
    private String ciclos;
    private String ur;
    
    private String sinusiorragia;
    private String eletro;
    private String dst;
    private String dst_descricao;
    
    private String fumante;
    private String cancerFamiliar;
    private String cancer_descricao;
    private String tipo_cancer;
    private String diabetes;
    private String hipertensao;
    
    private String outras_doencas;
    private String antecedentesCirurgicos;
    private String outros_antecedentes;
    
    private String mamasNormais;
    private String vulva_normal;
    
    private Seios seios;
    private Quadrantes quadrantes;
    private Sintomas sintomas;
    
    private String condiloma;
    
    private String cont_vaginal_normal;
    private String amarelo;
    private String grumoso;
    private String bolhoso;
    private String sanguinolento;
    private String colo_normal;
    private String mvpo;
    private String sangramento_facil;
    private String ulceracao;
    
    private String outros_sintomas;
    
    private String shiler_umMais;
    private String shiler_umCL;
    private String shiler_umMenos;
    
    private String exame_toque;
    
    private String enfermeiro;
    private int coren_enfermeiro;
    
    private String medico;
    private int crm_medico;
    
    public enum Mes{JAN,FEV,MAR,ABR,MAI,JUN,JUL,AGO,SET,OUT,NOV,DEZ}
    
    private UnidadeBasicaDeSaude ubs;
    private Mes mes;
    private Integer ano;
    
    private Long codProcedimento;
    private String crmMedico;
    private Long idadePaciente;
    
    
    
    
    public UnidadeBasicaDeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeBasicaDeSaude ubs) {
        this.ubs = ubs;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Long getCodProcedimento() {
        return codProcedimento;
    }

    public void setCodProcedimento(Long codProcedimento) {
        this.codProcedimento = codProcedimento;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public Long getIdadePaciente() {
        return idadePaciente;
    }

    public void setIdadePaciente(Long idadePaciente) {
        this.idadePaciente = idadePaciente;
    }
    
    public int getNumeroFilhosVivos() {
        return numeroFilhosVivos;
    }

    public void setNumeroFilhosVivos(int numeroFilhosVivos) {
        this.numeroFilhosVivos = numeroFilhosVivos;
    }

    public int getNatimorto() {
        return natimorto;
    }

    public void setNatimorto(int natimorto) {
        this.natimorto = natimorto;
    }

    public int getNumeroPartosVaginais() {
        return numeroPartosVaginais;
    }

    public void setNumeroPartosVaginais(int numeroPartosVaginais) {
        this.numeroPartosVaginais = numeroPartosVaginais;
    }

    public int getNumeroPartosCesareas() {
        return numeroPartosCesareas;
    }

    public void setNumeroPartosCesareas(int numeroPartosCesareas) {
        this.numeroPartosCesareas = numeroPartosCesareas;
    }

    public Date getUltimoAborto() {
        return ultimoAborto;
    }

    public void setUltimoAborto(Date ultimoAborto) {
        this.ultimoAborto = ultimoAborto;
    }

    public int getNumeroDosesVacinaAntitetanica() {
        return numeroDosesVacinaAntitetanica;
    }

    public void setNumeroDosesVacinaAntitetanica(int numeroDosesVacinaAntitetanica) {
        this.numeroDosesVacinaAntitetanica = numeroDosesVacinaAntitetanica;
    }

    public Date getDoseVacina1() {
        return doseVacina1;
    }

    public void setDoseVacina1(Date doseVacina1) {
        this.doseVacina1 = doseVacina1;
    }

    public Date getDoseVacina2() {
        return doseVacina2;
    }

    public void setDoseVacina2(Date doseVacina2) {
        this.doseVacina2 = doseVacina2;
    }

    public Date getDoseVacina3() {
        return doseVacina3;
    }

    public void setDoseVacina3(Date doseVacina3) {
        this.doseVacina3 = doseVacina3;
    }

    public Date getDoseReforcoVacina() {
        return doseReforcoVacina;
    }

    public void setDoseReforcoVacina(Date doseReforcoVacina) {
        this.doseReforcoVacina = doseReforcoVacina;
    }

    public String getOcorrenciasGestacao() {
        return ocorrenciasGestacao;
    }

    public void setOcorrenciasGestacao(String ocorrenciasGestacao) {
        this.ocorrenciasGestacao = ocorrenciasGestacao;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUnidadeDeSaude() {
        return unidadeDeSaude;
    }

    public void setUnidadeDeSaude(String unidadeDeSaude) {
        this.unidadeDeSaude = unidadeDeSaude;
    }

    public Integer getNumeroProntuario() {
        return numeroProntuario;
    }

    public void setNumeroProntuario(Integer numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(String numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public String getAutocuidado() {
        return autocuidado;
    }

    public void setAutocuidado(String autocuidado) {
        this.autocuidado = autocuidado;
    }

    public String getIndividual() {
        return individual;
    }

    public void setIndividual(String individual) {
        this.individual = individual;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEntregaMaterialEducativo() {
        return entregaMaterialEducativo;
    }

    public void setEntregaMaterialEducativo(String entregaMaterialEducativo) {
        this.entregaMaterialEducativo = entregaMaterialEducativo;
    }

    public String getEscutaComAtencao() {
        return escutaComAtencao;
    }

    public void setEscutaComAtencao(String escutaComAtencao) {
        this.escutaComAtencao = escutaComAtencao;
    }

    public String getFazPerguntas() {
        return fazPerguntas;
    }

    public void setFazPerguntas(String fazPerguntas) {
        this.fazPerguntas = fazPerguntas;
    }

    public String getLeMaterialEducativo() {
        return leMaterialEducativo;
    }

    public void setLeMaterialEducativo(String leMaterialEducativo) {
        this.leMaterialEducativo = leMaterialEducativo;
    }

    public String getSegueRecomendacoes() {
        return segueRecomendacoes;
    }

    public void setSegueRecomendacoes(String segueRecomendacoes) {
        this.segueRecomendacoes = segueRecomendacoes;
    }

    public String getAntedidaPorMedico() {
        return antedidaPorMedico;
    }

    public void setAntedidaPorMedico(String antedidaPorMedico) {
        this.antedidaPorMedico = antedidaPorMedico;
    }

    public String getAntedidaPorEnfermeiro() {
        return antedidaPorEnfermeiro;
    }

    public void setAntedidaPorEnfermeiro(String antedidaPorEnfermeiro) {
        this.antedidaPorEnfermeiro = antedidaPorEnfermeiro;
    }

    public String getAntedidaPorOutro() {
        return antedidaPorOutro;
    }

    public void setAntedidaPorOutro(String antedidaPorOutro) {
        this.antedidaPorOutro = antedidaPorOutro;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(String seguimento) {
        this.seguimento = seguimento;
    }

    public String getRubrica() {
        return rubrica;
    }

    public void setRubrica(String rubrica) {
        this.rubrica = rubrica;
    }

    public Boolean getNova() {
        return nova;
    }

    public void setNova(Boolean nova) {
        this.nova = nova;
    }

    public Boolean getControle() {
        return controle;
    }

    public void setControle(Boolean controle) {
        this.controle = controle;
    }

    public Boolean getUmATres() {
        return umATres;
    }

    public void setUmATres(Boolean umATres) {
        this.umATres = umATres;
    }

    public Boolean getMaisDeTres() {
        return maisDeTres;
    }

    public void setMaisDeTres(Boolean maisDeTres) {
        this.maisDeTres = maisDeTres;
    }

    public Boolean getMaisDeCinco() {
        return maisDeCinco;
    }

    public void setMaisDeCinco(Boolean maisDeCinco) {
        this.maisDeCinco = maisDeCinco;
    }

    public Boolean getIgnorado() {
        return ignorado;
    }

    public void setIgnorado(Boolean ignorado) {
        this.ignorado = ignorado;
    }

    public String getPaciente_radio() {
        return paciente_radio;
    }

    public void setPaciente_radio(String paciente_radio) {
        this.paciente_radio = paciente_radio;
    }

    public String getPaciente_gestante() {
        return paciente_gestante;
    }

    public void setPaciente_gestante(String paciente_gestante) {
        this.paciente_gestante = paciente_gestante;
    }

    public String getPaciente_trh() {
        return paciente_trh;
    }

    public void setPaciente_trh(String paciente_trh) {
        this.paciente_trh = paciente_trh;
    }

    public String getTipo_remedio() {
        return tipo_remedio;
    }

    public void setTipo_remedio(String tipo_remedio) {
        this.tipo_remedio = tipo_remedio;
    }

    public String getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(String tempoUso) {
        this.tempoUso = tempoUso;
    }

    public String getCausaInterrupcao() {
        return causaInterrupcao;
    }

    public void setCausaInterrupcao(String causaInterrupcao) {
        this.causaInterrupcao = causaInterrupcao;
    }

    public String getInicioVidaSexual() {
        return inicioVidaSexual;
    }

    public void setInicioVidaSexual(String inicioVidaSexual) {
        this.inicioVidaSexual = inicioVidaSexual;
    }

    public String getGesta() {
        return gesta;
    }

    public void setGesta(String gesta) {
        this.gesta = gesta;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getAborto() {
        return aborto;
    }

    public void setAborto(String aborto) {
        this.aborto = aborto;
    }

    public String getUltimaGravidez() {
        return ultimaGravidez;
    }

    public void setUltimaGravidez(String ultimaGravidez) {
        this.ultimaGravidez = ultimaGravidez;
    }

    public String getCiclos() {
        return ciclos;
    }

    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

    public String getSinusiorragia() {
        return sinusiorragia;
    }

    public void setSinusiorragia(String sinusiorragia) {
        this.sinusiorragia = sinusiorragia;
    }

    public String getEletro() {
        return eletro;
    }

    public void setEletro(String eletro) {
        this.eletro = eletro;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getDst_descricao() {
        return dst_descricao;
    }

    public void setDst_descricao(String dst_descricao) {
        this.dst_descricao = dst_descricao;
    }

    public String getFumante() {
        return fumante;
    }

    public void setFumante(String fumante) {
        this.fumante = fumante;
    }

    public String getCancerFamiliar() {
        return cancerFamiliar;
    }

    public void setCancerFamiliar(String cancerFamiliar) {
        this.cancerFamiliar = cancerFamiliar;
    }

    public String getCancer_descricao() {
        return cancer_descricao;
    }

    public void setCancer_descricao(String cancer_descricao) {
        this.cancer_descricao = cancer_descricao;
    }

    public String getTipo_cancer() {
        return tipo_cancer;
    }

    public void setTipo_cancer(String tipo_cancer) {
        this.tipo_cancer = tipo_cancer;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(String hipertensao) {
        this.hipertensao = hipertensao;
    }

    public String getOutras_doencas() {
        return outras_doencas;
    }

    public void setOutras_doencas(String outras_doencas) {
        this.outras_doencas = outras_doencas;
    }

    public String getAntecedentesCirurgicos() {
        return antecedentesCirurgicos;
    }

    public void setAntecedentesCirurgicos(String antecedentesCirurgicos) {
        this.antecedentesCirurgicos = antecedentesCirurgicos;
    }

    public String getOutros_antecedentes() {
        return outros_antecedentes;
    }

    public void setOutros_antecedentes(String outros_antecedentes) {
        this.outros_antecedentes = outros_antecedentes;
    }

    public String getMamasNormais() {
        return mamasNormais;
    }

    public void setMamasNormais(String mamasNormais) {
        this.mamasNormais = mamasNormais;
    }

    public String getVulva_normal() {
        return vulva_normal;
    }

    public void setVulva_normal(String vulva_normal) {
        this.vulva_normal = vulva_normal;
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

    public String getCondiloma() {
        return condiloma;
    }

    public void setCondiloma(String condiloma) {
        this.condiloma = condiloma;
    }

    public String getCont_vaginal_normal() {
        return cont_vaginal_normal;
    }

    public void setCont_vaginal_normal(String cont_vaginal_normal) {
        this.cont_vaginal_normal = cont_vaginal_normal;
    }

    public String getAmarelo() {
        return amarelo;
    }

    public void setAmarelo(String amarelo) {
        this.amarelo = amarelo;
    }

    public String getGrumoso() {
        return grumoso;
    }

    public void setGrumoso(String grumoso) {
        this.grumoso = grumoso;
    }

    public String getBolhoso() {
        return bolhoso;
    }

    public void setBolhoso(String bolhoso) {
        this.bolhoso = bolhoso;
    }

    public String getSanguinolento() {
        return sanguinolento;
    }

    public void setSanguinolento(String sanguinolento) {
        this.sanguinolento = sanguinolento;
    }

    public String getColo_normal() {
        return colo_normal;
    }

    public void setColo_normal(String colo_normal) {
        this.colo_normal = colo_normal;
    }

    public String getMvpo() {
        return mvpo;
    }

    public void setMvpo(String mvpo) {
        this.mvpo = mvpo;
    }

    public String getSangramento_facil() {
        return sangramento_facil;
    }

    public void setSangramento_facil(String sangramento_facil) {
        this.sangramento_facil = sangramento_facil;
    }

    public String getUlceracao() {
        return ulceracao;
    }

    public void setUlceracao(String ulceracao) {
        this.ulceracao = ulceracao;
    }

    public String getOutros_sintomas() {
        return outros_sintomas;
    }

    public void setOutros_sintomas(String outros_sintomas) {
        this.outros_sintomas = outros_sintomas;
    }

    public String getShiler_umMais() {
        return shiler_umMais;
    }

    public void setShiler_umMais(String shiler_umMais) {
        this.shiler_umMais = shiler_umMais;
    }

    public String getShiler_umCL() {
        return shiler_umCL;
    }

    public void setShiler_umCL(String shiler_umCL) {
        this.shiler_umCL = shiler_umCL;
    }

    public String getShiler_umMenos() {
        return shiler_umMenos;
    }

    public void setShiler_umMenos(String shiler_umMenos) {
        this.shiler_umMenos = shiler_umMenos;
    }

    public String getExame_toque() {
        return exame_toque;
    }

    public void setExame_toque(String exame_toque) {
        this.exame_toque = exame_toque;
    }

    public String getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(String enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public int getCoren_enfermeiro() {
        return coren_enfermeiro;
    }

    public void setCoren_enfermeiro(int coren_enfermeiro) {
        this.coren_enfermeiro = coren_enfermeiro;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public int getCrm_medico() {
        return crm_medico;
    }

    public void setCrm_medico(int crm_medico) {
        this.crm_medico = crm_medico;
    }

    
    
    
}