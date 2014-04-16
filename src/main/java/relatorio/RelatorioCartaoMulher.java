/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.AtendimentoAMulher;

/**
 *
 * @author diogenes
 */
public class RelatorioCartaoMulher {

    public Relatorio getRelatorio(AtendimentoAMulher atendimento) {

        String consulta;

        consulta = "SELECT a.id, a.aborto, a.amarelo, a.antecedentescirurgicos, a.bolhoso, a.cancerfamiliar, "
                + "a.cancer_descricao, a.causainterrupcao, a.ciclos, a.colo_normal, a.condiloma, "
                + "a.cont_vaginal_normal, a.controle, a.coren_enfermeiro, a.crm_medico, "
                + "a.diabetes, a.dn, a.dst, a.dst_descricao, a.eletro, a.endereco, a.enfermeiro, "
                + "a.exame_toque, a.fumante, a.gesta, a.grumoso, a.hipertensao, a.ignorado, "
                + "a.iniciovidasexual, a.maisdecinco, a.maisdetres, a.mamasnormais, a.medico, "
                + "a.mvpo, a.nome, a.nome_remedio, a.nova, a.numero_prontuario, a.outras_doencas, "
                + "a.outros_antecedentes, a.outros_sintomas, a.pa, a.paciente_gestante, "
                + "a.paciente_radio, a.paciente_trh, a.para, a.peso, a.sangramento_facil, "
                + "a.sanguinolento, a.seguimento, a.shiler_umcl, a.shiler_ummais, a.shiler_ummenos, "
                + "a.sinusiorragia, a.tempouso, a.tipo_cancer, a.ulceracao, a.ultimagravidez, "
                + "a.umatres, a.ur, a.vulva_normal, a.paciente_cns,"
                + "p.cns, p.bairropaciente, p.datadenascimentopaciente, p.enderecopaciente, "
                + "p.nomecompletopaciente, p.nomedamaepaciente, p.numeropaciente, p.sexopaciente, p.telefonepaciente "
                + "FROM atendimentoamulher as a, paciente as p WHERE a.cns = " + atendimento.getId() + " and a.paciente_cns = p.cns;";


        System.out.println(consulta);

        // Classe que vai recuperar os dados do banco de dados

        Relatorio relatorio = new Relatorio();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Boolean resposta;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(consulta);
            rset = pstm.executeQuery();

            // Enquanto existir dados no banco de dados, faça

            while (rset.next()) {

                relatorio.setNumeroProntuario(rset.getInt("numero_prontuario"));
                relatorio.setNome(rset.getString("nomecompletopaciente"));
                relatorio.setDataNascimento(rset.getDate("datadenascimentopaciente"));
                relatorio.setEndereco(rset.getString("bairropaciente"));
                relatorio.setMunicipio(rset.getString("enderecopaciente"));
                relatorio.setAborto(rset.getString("aborto"));

                resposta = rset.getBoolean("amarelo");
                if (resposta == true) {
                    relatorio.setAmarelo("Sim");
                } else if (resposta == false) {
                    relatorio.setAmarelo("Não");
                }

                relatorio.setAntecedentesCirurgicos(rset.getString("antecedentescirurgicos"));
                relatorio.setAntedidaPorEnfermeiro(rset.getString("enfermeiro"));
                relatorio.setAntedidaPorMedico(rset.getString("medico"));

                resposta = rset.getBoolean("bolhoso");
                if (resposta == true) {
                    relatorio.setBolhoso("Sim");
                } else if (resposta == false) {
                    relatorio.setBolhoso("Não");
                }

                relatorio.setCancerFamiliar(rset.getString("cancerfamiliar"));
                relatorio.setCancer_descricao(rset.getString("cancer_descricao"));
                relatorio.setCausaInterrupcao(rset.getString("causainterrupcao"));
                relatorio.setCiclos(rset.getString("ciclos"));

                resposta = rset.getBoolean("colo_normal");
                if (resposta == true) {
                    relatorio.setColo_normal("Sim");
                } else if (resposta == false) {
                    relatorio.setColo_normal("Não");
                }

                relatorio.setCondiloma(rset.getString("condiloma"));

                resposta = rset.getBoolean("cont_vaginal_normal");
                if (resposta == true) {
                    relatorio.setCont_vaginal_normal("Sim");
                } else if (resposta == false) {
                    relatorio.setCont_vaginal_normal("Não");
                }

                relatorio.setControle(rset.getBoolean("controle"));
                relatorio.setCoren_enfermeiro(rset.getInt("coren_enfermeiro"));
                relatorio.setCrm_medico(rset.getInt("crm_medico"));
                relatorio.setDiabetes(rset.getString("diabetes"));
                relatorio.setDst(rset.getString("dst"));
                relatorio.setDst_descricao(rset.getString("dst_descricao"));
                relatorio.setEletro(rset.getString("eletro"));
                relatorio.setExame_toque(rset.getString("exame_toque"));
                relatorio.setFumante(rset.getString("fumante"));
                relatorio.setEndereco(rset.getString("endereco"));
                relatorio.setGesta(rset.getString("gesta"));

                resposta = rset.getBoolean("grumoso");
                if (resposta == true) {
                    relatorio.setGrumoso("Sim");
                } else if (resposta == false) {
                    relatorio.setGrumoso("Não");
                }

                relatorio.setIgnorado(rset.getBoolean("ignorado"));
                relatorio.setInicioVidaSexual(rset.getString("iniciovidasexual"));
                relatorio.setMaisDeCinco(rset.getBoolean("maisdecinco"));
                relatorio.setMaisDeTres(rset.getBoolean("maisdetres"));
                relatorio.setMamasNormais(rset.getString("mamasnormais"));

                resposta = rset.getBoolean("mvpo");
                if (resposta == true) {
                    relatorio.setMvpo("Sim");
                } else if (resposta == false) {
                    relatorio.setMvpo("Não");
                }

                relatorio.setTipo_remedio(rset.getString("nome_remedio"));
                relatorio.setOutras_doencas(rset.getString("outras_doencas"));
                relatorio.setOutros_antecedentes(rset.getString("outras_doencas"));
                relatorio.setOutras_doencas(rset.getString("outros_antecedentes"));
                relatorio.setOutros_sintomas(rset.getString("outros_sintomas"));
                relatorio.setPa(rset.getString("pa"));
                relatorio.setPaciente_gestante(rset.getString("paciente_gestante"));
                relatorio.setPaciente_radio(rset.getString("paciente_radio"));
                relatorio.setPaciente_trh(rset.getString("paciente_trh"));
                relatorio.setPara(rset.getString("para"));
                relatorio.setPeso(rset.getString("peso"));

                resposta = rset.getBoolean("sangramento_facil");
                if (resposta == true) {
                    relatorio.setSangramento_facil("Sim");
                } else if (resposta == false) {
                    relatorio.setSangramento_facil("Não");
                }

                resposta = rset.getBoolean("sanguinolento");
                if (resposta == true) {
                    relatorio.setSanguinolento("Sim");
                } else if (resposta == false) {
                    relatorio.setSanguinolento("Não");
                }

                relatorio.setSeguimento(rset.getString("seguimento"));

                resposta = rset.getBoolean("shiler_ummais");
                if (resposta == true) {
                    relatorio.setShiler_umMais("Sim");
                } else if (resposta == false) {
                    relatorio.setShiler_umMais("Não");
                }

                resposta = rset.getBoolean("shiler_umcl");
                if (resposta == true) {
                    relatorio.setShiler_umCL("Sim");
                } else if (resposta == false) {
                    relatorio.setShiler_umCL("Não");
                }

                resposta = rset.getBoolean("shiler_ummenos");
                if (resposta == true) {
                    relatorio.setShiler_umMenos("Sim");
                } else if (resposta == false) {
                    relatorio.setShiler_umMenos("Não");
                }

                relatorio.setSinusiorragia(rset.getString("sinusiorragia"));
                relatorio.setTempoUso(rset.getString("tempouso"));
                relatorio.setTipo_cancer(rset.getString("tipo_cancer"));

                resposta = rset.getBoolean("ulceracao");
                if (resposta == true) {
                    relatorio.setUlceracao("Sim");
                } else if (resposta == false) {
                    relatorio.setUlceracao("Não");
                }

                relatorio.setUltimaGravidez(rset.getString("ultimagravidez"));
                relatorio.setUmATres(rset.getBoolean("umatres"));
                relatorio.setUr(rset.getString("ur"));

                String v = rset.getString("vulva_normal");
                if (v.equals("0")) {
                    relatorio.setVulva_normal("Sim");
                } else if (v.equals("1")) {
                    relatorio.setVulva_normal("Não");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

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

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return relatorio;

    }
}
