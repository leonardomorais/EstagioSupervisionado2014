package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Familia {

    private Integer cdFamilia;
    private String dsFamilia;
//    private int[] vetFamilia = new int[100];

    private Map <Integer, Integer> familias = new HashMap<Integer, Integer>();
    
    private Origem origem = new Origem();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Familia familia) {
        RetornaSequencia seq = new RetornaSequencia();
        familia.setCdFamilia(seq.retornaSequencia("CD_FAMILIA", "FAMILIA"));
        String sql = "INSERT INTO FAMILIA (CD_FAMILIA, CD_ORIGEM, DS_FAMILIA) "
                + "VALUES ('" + familia.getCdFamilia() + "','" + origem.getOrigem(origem.getCdOrigem()) + "','"
                + familia.getDsFamilia() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Família gravada com sucesso!");
        }
    }

    public void alterar(Familia familia) {
        String sql = "UPDATE FAMILIA SET CD_ORIGEM = '" + origem.getOrigem(origem.getCdOrigem()) + "', "
                + "DS_FAMILIA = '" + familia.getDsFamilia() + "' WHERE CD_FAMILIA = " + familia.getCdFamilia();
        conexao.atualizarSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Família alterada com sucesso!");
        }
    }

    public void excluir(Familia familia){
        String sql = "DELETE FROM FAMILIA WHERE CD_FAMILIA = " + familia.getCdFamilia();
           conexao.deleteSQL(sql); 
           if (conexao.retorno == 1){
               JOptionPane.showMessageDialog(null, "Família de produtos excluída com sucesso!");
           }
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT F.CD_FAMILIA, F.DS_FAMILIA, F.CD_ORIGEM, O.DS_ORIGEM "
                + "FROM FAMILIA F INNER JOIN ORIGEM O ON F.CD_ORIGEM = O.CD_ORIGEM "
                + "ORDER BY F.CD_FAMILIA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdFamilia(Familia familia) {
        String sql = "SELECT F.CD_FAMILIA, F.DS_FAMILIA, F.CD_ORIGEM, O.DS_ORIGEM "
                + "FROM FAMILIA F INNER JOIN ORIGEM O ON F.CD_ORIGEM = O.CD_ORIGEM "
                + "WHERE F.CD_FAMILIA = " + familia.getCdFamilia();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsFamilia(Familia familia) {
        String sql = "SELECT F.CD_FAMILIA, F.DS_FAMILIA, F.CD_ORIGEM, O.DS_ORIGEM "
                + "FROM FAMILIA F INNER JOIN ORIGEM O ON F.CD_ORIGEM = O.CD_ORIGEM "
                + "WHERE F.DS_FAMILIA  LIKE '%" + familia.getDsFamilia() + "%' "
                + "ORDER BY F.CD_FAMILIA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaFamilia(Familia familia) {
        ResultSet retorno = consultarCdFamilia(familia);
        try {
            retorno.first();
            familia.setDsFamilia(retorno.getString("DS_FAMILIA"));
            origem.setDsOrigem(retorno.getString("DS_ORIGEM"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Família não encontrada !");
            familia.setDsFamilia("");
        }
    }

    public void retornaComboFamilia(JComboBox combo) {
        String sql = "SELECT * FROM FAMILIA ORDER BY CD_FAMILIA";
        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;
//        int[] vet = new int[100];

        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getString("DS_FAMILIA"));
                familias.put(conta, conexao.resultset.getInt("CD_FAMILIA"));
//                vet[conta] = conexao.resultset.getInt("CD_FAMILIA");
                conta++;
            }
//            setVetFamilia(vet);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Família não encontrada !");
        }
    }

    // getter e setter
    public Integer getCdFamilia() {
        return cdFamilia;
    }

    public void setCdFamilia(Integer cdFamilia) {
        this.cdFamilia = cdFamilia;
    }

    public String getDsFamilia() {
        return dsFamilia;
    }

    public void setDsFamilia(String dsFamilia) {
        this.dsFamilia = dsFamilia;
    }

//    public int getVetFamilia(int pos) {
//        return vetFamilia[pos];
//    }
//
//    public void setVetFamilia(int[] vetFamilia) {
//        this.vetFamilia = vetFamilia;
//    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public int getFamilia(int pos){
        return familias.get(pos);
    }
}
