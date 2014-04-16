/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UnidadeBasicaDeSaude;

/**
 *
 * @author diogenes
 */
public class GeradorRelatorio {

    public void gerarCartao(Relatorio relatorio) {
        Document doc = null;
        OutputStream os = null;
        try {
            os = new FileOutputStream("C:/Relatorios/CartaoDaMulher.pdf");
            //os = new FileOutputStream("/home/diogenes/Documentos/Relatorios/CartaoDaMulher.pdf"); //Diogenes
            //os = new FileOutputStream("/home/'user'/Documentos/Relatorios/CartaoDaMulher.pdf""); //Linux
            //os = new FileOutputStream("C:/Relatorios/CartaoDaMulher.pdf"); //Windows
            
            doc = new Document();
            PdfWriter.getInstance(doc, os);
            doc.open();

            PdfPTable cabecalho = new PdfPTable(2);
            Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);

            Font fonteDesc = new Font(); /*
             * Será usada na descrição.
             */

            float[] widths = {0.15f, 0.85f};
            cabecalho.setWidthPercentage(90);/*
             * Seta a largura da tabela com relação a página.
             */
            cabecalho.setWidths(widths);
            cabecalho.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            Image img = Image.getInstance("C:/Relatorios/logo.png");
            //Image img = Image.getInstance("/home/diogenes/Documentos/Siso/web/img/LogoTop.png"); //Diogenes
            //Image img = Image.getInstance("/home/'user'/Documentos/Siso/web/img/logo.png"); //Linux
            //Image img = Image.getInstance("C:/Relatorios/logo.png"); //Windows
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);

            Paragraph p = new Paragraph("PREFEITURA MUNICIPAL DE QUIXADÁ\n"
                    + "SISTEMA DE ATENÇÃO BÁSICA À SAÚDE\n"
                    + "CARTÃO DA MULHER/ADOLESCENTE", fonteCabecalho);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(cabecalho);

            try {
                getCabecalhoCartao(relatorio, fonteDesc, doc);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Gerando Relatorio");
            doc.close();
            os.close();

            System.out.println("Relatorio Gerado");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public void getCabecalhoCartao(Relatorio relatorio, Font fonteRodaPe, Document doc) {

        PdfPTable dadosPessoais = new PdfPTable(4); // qtd de colunas a ser geradas
        PdfPTable agendamento = new PdfPTable(4);
        PdfPTable dadosGerais = new PdfPTable(3);

        float[] widths = new float[]{0.20f, 0.20f, 0.60f};

        /* Seta a largura da tabela com relação a página.*/
        dadosPessoais.setSpacingBefore(10f);
        dadosPessoais.setWidthPercentage(90);

        agendamento.setSpacingBefore(10f);
        agendamento.setWidthPercentage(90);

        dadosGerais.setSpacingBefore(10f);
        dadosGerais.setWidthPercentage(90);

        try {
            dadosPessoais.setWidths(widths);
            agendamento.setWidths(widths);
            dadosGerais.setWidths(widths);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font fonteCorpo = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

        dadosPessoais.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        dadosPessoais.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);

        agendamento.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        agendamento.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);

        dadosGerais.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        dadosGerais.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);

        String nascimento;
        Format d = new SimpleDateFormat("dd/MM/yyyy");
        nascimento = d.format(relatorio.getDataNascimento());

        dadosPessoais.addCell(criarCellDados("MUNICÍPIO: " + relatorio.getMunicipio(), fonteCorpo, 4));
        dadosPessoais.addCell(criarCellDados("SERVIÇO DE SAÚDE: " + relatorio.getUnidadeDeSaude(), fonteCorpo, 4));
        dadosPessoais.addCell(criarCellDados("NOME: " + relatorio.getNome(), fonteCorpo, 4));
        dadosPessoais.addCell(criarCellDados("ENDEREÇO: " + relatorio.getEndereco(), fonteCorpo, 4));
        dadosPessoais.addCell(criarCellDados("Nº PRONTUÁRIO: " + relatorio.getNumeroProntuario(), fonteCorpo, 2));
        dadosPessoais.addCell(criarCellDados("DATA DE NASCIMENTO: " + nascimento, fonteCorpo, 2));
        dadosPessoais.addCell(criarCellDados("ESTADO CIVIL: " + relatorio.getEstadoCivil(), fonteCorpo, 2));
        dadosPessoais.addCell(criarCellDados("ESCOLARIDADE: " + relatorio.getEscolaridade(), fonteCorpo, 2));
        try {
            doc.add(dadosPessoais);
        } catch (DocumentException ex) {
            Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        Paragraph p = new Paragraph("AGENDAMENTO", fonteCabecalho);
        p.setAlignment(Element.ALIGN_CENTER);

        agendamento.addCell(criarCellAgendamento("DATA", fonteCabecalho, 1));
        agendamento.addCell(criarCellAgendamento("HORA", fonteCabecalho, 1));
        agendamento.addCell(criarCellAgendamento("NOME DO PROFISSIONAL", fonteCabecalho, 1));
        agendamento.addCell(criarCellAgendamento("SALA", fonteCabecalho, 1));

        for (int i = 1; i <= 24; i++) {
            agendamento.addCell(criarCellAgendamento(" ", fonteCorpo, 1));
            agendamento.addCell(criarCellAgendamento(" ", fonteCorpo, 1));
            agendamento.addCell(criarCellAgendamento(" ", fonteCorpo, 1));
            agendamento.addCell(criarCellAgendamento(" ", fonteCorpo, 1));
            i++;
        }

        try {
            doc.add(p);
            doc.add(agendamento);
        } catch (DocumentException ex) {
            Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

//        Format data_dose1 = new SimpleDateFormat("dd/MM/yyyy");
//        String dataDose1 = data_dose1.format(relatorio.getDoseVacina1());
//        
//        Format data_dose2 = new SimpleDateFormat("dd/MM/yyyy");
//        String dataDose2 = data_dose2.format(relatorio.getDoseVacina2());
//        
//        Format data_dose3 = new SimpleDateFormat("dd/MM/yyyy");
//        String dataDose3 = data_dose3.format(relatorio.getDoseVacina3());

        dadosGerais.addCell(criarCellDados("GESTA: " + relatorio.getGesta(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("PARA: " + relatorio.getPara(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("ABORTO: " + relatorio.getAborto(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("N° DE FILHOS VIVOS: " + relatorio.getNumeroFilhosVivos(), fonteCorpo, 2));
        dadosGerais.addCell(criarCellDados("NATIMORTO: " + relatorio.getNumeroFilhosVivos(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("PARTOS: VAGINAIS: " + relatorio.getNumeroPartosVaginais(), fonteCorpo, 2));
        dadosGerais.addCell(criarCellDados("CESÁREAS: " + relatorio.getNumeroPartosCesareas(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("DATA DO ÚLTIMO PARTO OU ABORTO: " + relatorio.getNumeroPartosCesareas(), fonteCorpo, 3));
        dadosGerais.addCell(criarCellDados("VACINA ANTITETÂNICA: Nº DE DOSES PRÉVIAS: " + relatorio.getNumeroDosesVacinaAntitetanica(), fonteCorpo, 3));
        dadosGerais.addCell(criarCellDados("COMPLETAR ESQUEMA", fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("1ª DOSE: " + relatorio.getDoseVacina1(), fonteCorpo, 2));
        dadosGerais.addCell(criarCellDados("2ª DOSE: " + relatorio.getDoseVacina2(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("3ª DOSE: " + relatorio.getDoseVacina3(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("REFORÇO: " + relatorio.getDoseReforcoVacina(), fonteCorpo, 1));
        dadosGerais.addCell(criarCellDados("INTERCORRÊNCIAS EM GESTAÇÕES ANTERIORES:", fonteCorpo, 3));
        dadosGerais.addCell(criarCellDados(" ", fonteCorpo, 3));
        dadosGerais.addCell(criarCellDados(" ", fonteCorpo, 3));
        dadosGerais.addCell(criarCellDados(" ", fonteCorpo, 3));
        try {
            doc.add(dadosGerais);
        } catch (DocumentException ex) {
            Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("empty-statement")
    PdfPCell criarCellDados(String texto, Font fonte, int colspan) {
        PdfPCell cell = new PdfPCell(new Phrase(texto, fonte));;
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        return cell;

    }

    @SuppressWarnings("empty-statement")
    PdfPCell criarCellAgendamento(String texto, Font fonte, int colspan) {
        PdfPCell cell = new PdfPCell(new Phrase(texto, fonte));;
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        return cell;

    }
    
    
    //Pedro
    public void gerarRBPA(ArrayList<Relatorio> relatorio, UnidadeBasicaDeSaude ubs) {
        Document doc = null;
        OutputStream os = null;
        try {
            os = new FileOutputStream("C:/Relatorios/relatorioBPA.pdf");
            //os = new FileOutputStream("/home/diogenes/Documentos/Relatorios/CartaoDaMulher.pdf"); //Diogenes
            //os = new FileOutputStream("/home/'user'/Documentos/Relatorios/CartaoDaMulher.pdf""); //Linux
            //os = new FileOutputStream("C:/Relatorios/CartaoDaMulher.pdf"); //Windows
            //os = new FileOutputStream("/home/pedro/Relatorios/relatorioBPA.pdf"); //Pedro

            doc = new Document();
            PdfWriter.getInstance(doc, os);
            doc.open();

            PdfPTable cabecalho = new PdfPTable(2);
            Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);

            Font fonteDesc = new Font(); /*
             * Será usada na descrição.
             */

            float[] widths = {0.15f, 0.85f};
            cabecalho.setWidthPercentage(90);/*
             * Seta a largura da tabela com relação a página.
             */
            cabecalho.setWidths(widths);
            cabecalho.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            Image img = Image.getInstance("C:/Relatorios/logo.png");
            //Image img = Image.getInstance("/home/diogenes/Documentos/Siso/web/img/LogoTop.png"); //Diogenes
            //Image img = Image.getInstance("/home/'user'/Documentos/Siso/web/img/logo.png"); //Linux
            //Image img = Image.getInstance("C:/Relatorios/logo.png"); //Windows
            //Image img = Image.getInstance("/home/pedro/Relatorios/logo.png"); //Pedro

            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);

            Paragraph p = new Paragraph("Prefeitura Municipal de Quixadá\n" + "SIABS\n"
                    + "Relatório BPA");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);

            doc.add(cabecalho);

            PdfPTable dadosUbs = new PdfPTable(2);
            
            dadosUbs.addCell(criarCellDados("Nome da unidade básica de saúde", fonteDesc, 2));
            dadosUbs.addCell(criarCellDados(ubs.getNome(), fonteDesc, 2));
            dadosUbs.addCell(criarCellDados("UF: CE", fonteDesc, 1));
            dadosUbs.addCell(criarCellDados("SCNES da unidade"+ubs.getScnes(), fonteDesc, 1));
            
            doc.add(dadosUbs);
            try {
                doc.add(getCabecalhoBPA(relatorio, fonteDesc));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Gerando Relatorio");
            doc.close();
            os.close();

            System.out.println("Relatorio Gerado");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }    
    
    public PdfPTable getCabecalhoBPA(ArrayList<Relatorio> a,  Font fonteRodaPe) {
        PdfPTable desc = new PdfPTable(4); // qtd de colunas a ser geradas
    
      /*
         * Seta a largura da tabela com relação a página.
         */

    
        Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        desc.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        desc.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);

        desc.addCell(new Phrase("Sequência", fonteCabecalho));
        desc.addCell(new Phrase("Procedimento", fonteCabecalho));
        desc.addCell(new Phrase("CBO", fonteCabecalho));
        desc.addCell(new Phrase("Idade: ", fonteCabecalho));
        desc.addCell(new Phrase("Quantidade: ", fonteCabecalho));
        
        int i=1;
        Integer total=0;
        for (Relatorio relatorio : a) {
            
            desc.addCell(new Phrase(""+ i++));
            desc.addCell(new Phrase(""+ relatorio.getCodProcedimento()));
            desc.addCell(new Phrase(""+ relatorio.getCrmMedico()));
            desc.addCell(new Phrase(""+ relatorio.getIdadePaciente()));
            desc.addCell(new Phrase(""+ relatorio.getQuantidade()));
            
            total += relatorio.getQuantidade();
        }

        desc.addCell(new Phrase("Total"));
        desc.addCell(new Phrase(""+ total));
        
        return desc;
    }
    
}