/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class RelatorioBPA {
    public enum Mes{JAN,FEV,MAR,ABR,MAI,JUN,JUL,AGO,SET,OUT,NOV,DEZ}    
    
    public List<Relatorio> getRelatorios(String datainicio, String datafim) {
       
        Date date = new Date();
        
        Format d = new SimpleDateFormat("yyyy");
        
        int ano = Integer.parseInt(d.format(date));
        
        String consultaMedico, consultaEnfermeira, consultaTecnico;       

                consultaMedico = "select  M.CRMMEDICO, PRO.CODIGOPROCEDIMENTO, " +
                "("+ ano +" - Extract('Year' from PAC.DATADENASCIMENTOPACIENTE)), count(*) " +
                "from ADDPROCEDIMENTOS as P, MEDICO as M, PROCEDIMENTOS as PRO, " +
                "ATENDIMENTOMEDICO as AM, PACIENTE as PAC " +
                "where M.IDMEDICO = P.IDMEDICO " +
                "and P.PROCEDIMENTO_CODIGOPROCEDIMENTO = PRO.CODIGOPROCEDIMENTO " +
                " and AM.ID = P.ATENDIMENTOMEDICO_ID " +
                "and AM.PACIENTE_CNS = PAC.CNS " +
                "and AM.DATAATENDIMENTOMEDICO >= '"+ datainicio + "' and '"+ datafim +"' <= AM.DATAATENDIMENTOMEDICO " +
               " group by PRO.CODIGOPROCEDIMENTO, M.CRMMEDICO, PAC.DATADENASCIMENTOPACIENTE";
                
                consultaEnfermeira = "select  E.COREN, PRO.CODIGOPROCEDIMENTO, " +
                 "("+ ano +" - Extract('Year' from PAC.DATADENASCIMENTOPACIENTE)), count(*) " +
                "from ADDPROCEDIMENTOS as P, ENFERMEIRO as E, PROCEDIMENTOS as PRO, " +
                "ATENDIMENTOENFERMEIRA as AE, PACIENTE as PAC " +
                "where E.ID = P.IDENFERMEIRO " +
                "and P.PROCEDIMENTO_CODIGOPROCEDIMENTO = PRO.CODIGOPROCEDIMENTO " +
                "and AE.ID = P.ATENDIMENTOENFERMEIRA_ID " +
                "and AE.PACIENTE_CNS = PAC.CNS " +
                "and AE.DATAATENDIMENTOENFERMEIRA >= '"+ datainicio + "' and '"+ datafim +"' <= AE.DATAATENDIMENTOENFERMEIRA " +
                "group by PRO.CODIGOPROCEDIMENTO, E.COREN, PAC.DATADENASCIMENTOPACIENTE ";
                
                consultaTecnico = "select  TE.COREN, PRO.CODIGOPROCEDIMENTO, " +
                  "("+ ano +" - Extract('Year' from PAC.DATADENASCIMENTOPACIENTE)), count(*) " +
                "from ADDPROCEDIMENTOS as P, TECNICODEENFERMAGEM as TE, PROCEDIMENTOS as PRO, " +
                "ATENDIMENTOTECNICODEENFERMAGEM as ATE, PACIENTE as PAC " +
                "where TE.ID = P.IDTECNICODEENFERMAGEM " +
                "and P.PROCEDIMENTO_CODIGOPROCEDIMENTO = PRO.CODIGOPROCEDIMENTO " +
                "and ATE.ID = P.ATENDIMENTOTECNICODEENFERMAGEM_ID " +
                "and ATE.PACIENTE_CNS = PAC.CNS " +
                "and ATE.DATAATENDIMENTOTECDEENFERMAGEM >= '"+ datainicio + "' and '"+ datafim +"' <= ATE.DATAATENDIMENTOTECDEENFERMAGEM " +
                "group by PRO.CODIGOPROCEDIMENTO, TE.COREN, PAC.DATADENASCIMENTOPACIENTE ";
                
        System.out.println(consultaMedico);
        System.out.println(consultaEnfermeira);
        System.out.println(consultaTecnico);
        
        
        List<Relatorio> relatorios = new ArrayList<Relatorio>();
        
        // Classe que vai recuperar os dados do banco de dados
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        PreparedStatement pste = null;
        ResultSet rsetE = null;
        
        PreparedStatement pstmTe = null;
        ResultSet rsetTe = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(consultaMedico);

            rset = pstm.executeQuery();
            
            
            pste = conn.prepareStatement(consultaEnfermeira);
            
            rsetE = pste.executeQuery();
            // Enquanto existir dados no banco de dados, faça
            
            pstmTe = conn.prepareStatement(consultaTecnico);
            
            rsetTe = pstmTe.executeQuery();
            while (rset.next()) {
                                
                Relatorio relatorio = new Relatorio();
                
                relatorio.setCrmMedico(rset.getString(1));
                relatorio.setCodProcedimento(rset.getLong(2));
                relatorio.setIdadePaciente(rset.getLong(3));                
                relatorio.setQuantidade(rset.getInt(4));
                
                System.out.println(" "+relatorio.getCrmMedico()+" "+relatorio.getCodProcedimento()+" "+ relatorio.getIdadePaciente() +" "+relatorio.getQuantidade());
                
                relatorios.add(relatorio);     
            }
            
            while (rsetE.next()){
                Relatorio relatorio = new Relatorio();
                
                relatorio.setCrmMedico(rsetE.getString(1));
                relatorio.setCodProcedimento(rsetE.getLong(2));
                relatorio.setIdadePaciente(rsetE.getLong(3));                
                relatorio.setQuantidade(rsetE.getInt(4));
                
                System.out.println(" "+relatorio.getCrmMedico()+" "+relatorio.getCodProcedimento()+" "+ relatorio.getIdadePaciente() +" "+relatorio.getQuantidade());
                
                relatorios.add(relatorio);     
            }
            
            while (rsetTe.next()){
                Relatorio relatorio = new Relatorio();
                
                relatorio.setCrmMedico(rsetTe.getString(1));
                relatorio.setCodProcedimento(rsetTe.getLong(2));
                relatorio.setIdadePaciente(rsetTe.getLong(3));                
                relatorio.setQuantidade(rsetTe.getInt(4));
                
                System.out.println(" "+relatorio.getCrmMedico()+" "+relatorio.getCodProcedimento()+" "+ relatorio.getIdadePaciente() +" "+relatorio.getQuantidade());
                
                relatorios.add(relatorio);     
            }
        }catch (Exception e) {

            e.printStackTrace();
            
        }finally {

            try {

                if (rset != null) {

                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
                
                if(rsetE != null){
                    rsetE.close();
                }

                if(pste != null){
                    pste.close();
                }
                
                if(pstmTe != null){
                    pstmTe.close();;
                }
                
                if(rsetTe != null){
                    rsetTe.close();
                }
                
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return relatorios;
    }
}