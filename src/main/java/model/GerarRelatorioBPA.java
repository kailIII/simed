/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.View;
import entities.annotations.Views;
import java.io.File;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import relatorio.GeradorRelatorio;
import relatorio.Relatorio;
import relatorio.RelatorioBPA;

/**
 *
 * @author pedro
 */

@Entity
@Views({
    @View(name = "GerarRelatorioBPA", title = "Gerar Relatório de BPA",
     members = "["
        + "#dataInicio, #dataFinal; #ubs;"
        + "gerarRelatorioBPA()]",
     roles = "Administrador",
     template = "@PAGER", namedQuery="select new model.GerarRelatorioBPA()")
})

public class GerarRelatorioBPA implements Serializable {
    
    @Id
    private Long id;

    @ManyToOne
    private UnidadeBasicaDeSaude ubs;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFinal;
    
    public File gerarRelatorioBPA(){      
        RelatorioBPA dao = new RelatorioBPA();
        
        Format d = new SimpleDateFormat("yyyy-MM-dd");
        
        
        
        List<Relatorio> results = dao.getRelatorios(d.format(dataInicio), d.format(dataFinal));
        GeradorRelatorio gerador = new GeradorRelatorio();
        gerador.gerarRBPA((ArrayList<Relatorio>) results,  ubs);
        
        File file = new File("C:/Relatorios/relatorioBPA.pdf");
        //file = new File("/home/diogenes/Documentos/Relatorios/Cartao_" + atendimento.getPaciente() + ".pdf"); //Diogenes
        //file = new File("/home/pedro/Relatorios/relatorioBPA.pdf"); // Pedro
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public UnidadeBasicaDeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeBasicaDeSaude ubs) {
        this.ubs = ubs;
    }
    
}
