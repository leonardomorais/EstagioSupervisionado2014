package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Origem {

    private Integer cdOrigem;
    private String dsOrigem;
    
    private Map <Integer, Integer> origens = new HashMap<Integer, Integer>();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Origem origem) {
        RetornaSequencia seq = new RetornaSequencia();
        origem.setCdOrigem(seq.retornaSequencia("CD_ORIGEM", "ORIGEM"));
        String sql = "INSERT INTO ORIGEM (CD_ORIGEM, DS_ORIGEM) VALUES "
                + "('" + origem.getCdOrigem() + "','" + origem.getDsOrigem() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Origem gravada com sucesso!");
        }
    }

    public void alterar(Origem origem) {
        String sql = "UPDATE ORIGEM SET DS_ORIGEM = '" + origem.getDsOrigem() + "' "
                + "WHERE CD_ORIGEM = " + origem.getCdOrigem();
        conexao.atualizarSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Origem alterada com sucesso!");
        }
    }

    public void excluir(Origem origem) {
        String sql = "DELETE FROM ORIGEM WHERE CD_ORIGEM = " + origem.getCdOrigem();
        conexao.deleteSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Origem excluída com sucesso!");
        }
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT * FROM ORIGEM ORDER BY CD_ORIGEM";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdOrigem(Origem origem) {
        String sql = "SELECT * FROM ORIGEM WHERE CD_ORIGEM = " + origem.getCdOrigem();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsOrigem(Origem origem) {
        String sql = "SELECT * FROM ORIGEM WHERE DS_ORIGEM LIKE '%" + origem.getDsOrigem() + "%' "
                + "ORDER BY CD_ORIGEM";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaOrigem(Origem origem) {
        ResultSet retorno = consultarCdOrigem(origem);
        try {
            retorno.first();
            origem.setDsOrigem(retorno.getString("DS_ORIGEM"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Origem não encontrada !");
            origem.setDsOrigem("");
        }
    }

    public void retornaComboOrigens(JComboBox combo) {
        String sql = "SELECT * FROM ORIGEM ORDER BY CD_ORIGEM";
        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;
//        int[] vet = new int[100];

        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getString("DS_ORIGEM"));
                origens.put(conta, conexao.resultset.getInt("CD_ORIGEM"));
//                vet[conta] = conexao.resultset.getInt("CD_ORIGEM");
                conta++;
            }
//            setVetOrigem(vet);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Origem não encontrada !");
        }
    }
// getter e setter    

    public Integer getCdOrigem() {
        return cdOrigem;
    }

    public void setCdOrigem(Integer cdOrigem) {
        this.cdOrigem = cdOrigem;
    }

    public String getDsOrigem() {
        return dsOrigem;
    }

    public void setDsOrigem(String dsOrigem) {
        this.dsOrigem = dsOrigem;
    }

//    public int getVetOrigem(int posicao) {
//        return vetOrigem[posicao];
//    }
//
//    public void setVetOrigem(int[] vetOrigem) {
//        this.vetOrigem = vetOrigem;
//    }
    public int getOrigem(int pos){
        return origens.get(pos);
    }

}
