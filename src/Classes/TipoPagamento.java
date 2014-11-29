package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class TipoPagamento {

    private static Integer cdTipo;
    private static String dsTipo;
    private String inAtivo;
    

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(TipoPagamento tp) {
        RetornaSequencia seq = new RetornaSequencia();
        tp.setCdTipo(seq.retornaSequencia("CD_TIPO", "TIPO_PGTO"));
        String sql = "INSERT INTO TIPO_PGTO (CD_TIPO, DS_TIPO, IN_ATIVO) "
                + "VALUES ('" + tp.getCdTipo() + "','" + tp.getDsTipo() + "','" + tp.getInAtivo() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Tipo de pagamento gravado com sucesso!");
        }
    }

    public void alterar(TipoPagamento tp) {
        String sql = "UPDATE TIPO_PGTO SET DS_TIPO = '" + tp.getDsTipo() + "', IN_ATIVO = '" + tp.getInAtivo() + "' "
                + "WHERE CD_TIPO = " + tp.getCdTipo();
        conexao.atualizarSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Tipo de pagamento alterado com sucesso!");
        }
    }

    public void exclur(TipoPagamento tp) {
        String sql = "UPDATE TIPO_PGTO SET IN_ATIVO = 'I' WHERE CD_TIPO = " + tp.getCdTipo();
        conexao.deleteSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Tipo de pagamento inativado com sucesso!");
        }
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT CD_TIPO, DS_TIPO, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                + "FROM TIPO_PGTO ORDER BY CD_TIPO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdTipo(TipoPagamento tp) {
        String sql = "SELECT CD_TIPO, DS_TIPO, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                + "FROM TIPO_PGTO WHERE CD_TIPO = " + tp.getCdTipo();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsTipo(TipoPagamento tp) {
        String sql = "SELECT CD_TIPO, DS_TIPO, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                + "FROM TIPO_PGTO WHERE DS_TIPO LIKE '%" + tp.getDsTipo() + "%' ORDER BY CD_TIPO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaTipo(TipoPagamento tp) {
        ResultSet retorno = consultarCdTipo(tp);
        try {
            retorno.first();
            tp.setDsTipo(retorno.getString("DS_TIPO"));
            tp.setInAtivo(retorno.getString("SITUACAO"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Tipo de Pagamento não encontrado !");
            tp.setDsTipo("");
        }
    }
    
//    public void retornaComboTipo(JComboBox combo){
//        String sql = "SELECT * FROM TIPO_PGTO ORDER BY CD_TIPO";
//        conexao.executeSQL(sql);
//
//        combo.removeAllItems();
//        int conta = 0;
//        int[] vet = new int[100];
//
//        try {
//            while (conexao.resultset.next()) {
//                combo.addItem(conexao.resultset.getString("DS_TIPO"));
//                vet[conta] = conexao.resultset.getInt("CD_TIPO");
//                conta++;
//            }
//            setVetTipos(vet);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Origem não encontrada !");
//        }
//    }

// getter e setter
    public Integer getCdTipo() {
        return cdTipo;
    }

    public void setCdTipo(Integer cdTipo) {
        this.cdTipo = cdTipo;
    }

    public String getDsTipo() {
        return dsTipo;
    }

    public void setDsTipo(String dsTipo) {
        this.dsTipo = dsTipo;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }

//    public int getVetTipos(int pos) {
//        return vetTipos[pos];
//    }
//
//    public void setVetTipos(int[] vetTipos) {
//        this.vetTipos = vetTipos;
//    }

}
