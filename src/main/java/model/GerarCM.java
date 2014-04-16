/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.ActionDescriptor;
import entities.annotations.View;
import entities.annotations.Views;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import config.configuracao;
import relatorio.GeradorRelatorio;
import relatorio.Relatorio;
import relatorio.RelatorioCartaoMulher;

/**
 *
 * @author diogenes
 */
@Entity
@Views({
    @View(name = "GerarCartaoMulher", title = "Imprimir Cartão da Mulher",
            members = "['Paciente:':#atendimento;gerarRelatorioCM()] ",
            roles = "Administrador",
            template = "@PAGE", namedQuery = "select new model.GerarCM()")
})
public class GerarCM implements Serializable {

    @Id
    private Long id;
    @ManyToOne()
    @NotNull(message = "Selecione um Paciente")
    private AtendimentoAMulher atendimento;

    @ActionDescriptor(displayName = "", value = "Imprimir Cartão")
    public File gerarRelatorioCM() {

        System.out.println("PACIENTE NOME: " + atendimento + " ID: " + atendimento.getId());

        RelatorioCartaoMulher dao = new RelatorioCartaoMulher();


        Relatorio relatorio = dao.getRelatorio(atendimento);

        GeradorRelatorio gerador = new GeradorRelatorio();
        gerador.gerarCartao(relatorio);

        File file;
        file = new File(configuracao.CLASSPATH + "relatorios/Cartao_" + atendimento.getPaciente() + ".pdf");
        //file = new File("/home/diogenes/Documentos/Relatorios/Cartao_" + atendimento.getPaciente() + ".pdf"); //Diogenes
        //file = new File("/home/'user'/Documentos/Relatorios/Cartao_" + atendimento.getPaciente() + ".pdf"); //Linux
        //file = new File("C:/Relatorios/Cartao_" + atendimento.getPaciente() + ".pdf"); //Windows
        return file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtendimentoAMulher getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoAMulher atendimento) {
        this.atendimento = atendimento;
    }
}
