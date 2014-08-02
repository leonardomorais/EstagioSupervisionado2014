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
public class Banco {

    private Integer cdBanco;
    private String nmBanco;
    private String inAtivo;
    
    private Map <Integer, Integer> bancos = new HashMap<Integer, Integer>();

//   private int vetBanco [] = new int[100];

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Banco banco) {
        RetornaSequencia seq = new RetornaSequencia();
        banco.setCdBanco(seq.retornaSequencia("CD_BANCO", "BANCO"));
        String sql = "INSERT INTO BANCO (CD_BANCO, NM_BANCO, IN_ATIVO) "
                + "VALUES ('" + banco.getCdBanco() + "','" + banco.getNmBanco() + "',"
                + "'" + banco.getInAtivo() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(Banco banco) {
        String sql = "UPDATE BANCO SET NM_BANCO = '" + banco.getNmBanco() + "', "
                + "IN_ATIVO = '" + banco.getInAtivo() + "' WHERE CD_BANCO = " + banco.getCdBanco();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Banco banco) {
        String sql = "UPDATE BANCO SET IN_ATIVO = 'I' WHERE CD_BANCO = " + banco.getCdBanco();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarGeral() {
        ResultSet retorno = null;
        String sql = "SELECT CD_BANCO, NM_BANCO, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                + "FROM BANCO ORDER BY CD_BANCO";
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public ResultSet consultarCdBanco(Banco banco) {
        ResultSet retorno = null;
        String sql = "SELECT CD_BANCO, NM_BANCO, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                + "FROM BANCO WHERE CD_BANCO = " + banco.getCdBanco();
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public ResultSet consultarDsBanco(Banco banco) {
        ResultSet retorno = null;
        String sql = "SELECT CD_BANCO, NM_BANCO, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                + "FROM BANCO WHERE NM_BANCO LIKE '%" + banco.getNmBanco() + "%' ORDER BY CD_BANCO";
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public void retornaBanco(Banco banco) {
        ResultSet retorno = consultarCdBanco(banco);
        try {
            retorno.first();
            banco.setNmBanco(retorno.getString("NM_BANCO"));
            banco.setInAtivo(retorno.getString("SITUACAO"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Banco não encontrado");
            banco.setNmBanco("");
        }
    }

    public void retornaComboBanco(JComboBox combo, boolean todos) {
        String sql = "";
        if (todos) {
            sql = "SELECT * FROM BANCO ORDER BY CD_BANCO";
        } else {
            sql = "SELECT * FROM BANCO INNER JOIN AGENCIA_CONTA "
                    + "ON BANCO.CD_BANCO = AGENCIA_CONTA.CD_BANCO ORDER BY BANCO.CD_BANCO";
        }

        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;
//        int[] vet = new int[100];

        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getString("NM_BANCO"));
                bancos.put(conta, conexao.resultset.getInt("CD_BANCO"));
//                vet[conta] = conexao.resultset.getInt("CD_BANCO");
                conta++;
            }
//            setVetBanco(vet);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Banco não encontrado !");
        }
    }

    // getter e setter
    public Integer getCdBanco() {
        return cdBanco;
    }

    public void setCdBanco(Integer cdBanco) {
        this.cdBanco = cdBanco;
    }

    public String getNmBanco() {
        return nmBanco;
    }

    public void setNmBanco(String nmBanco) {
        this.nmBanco = nmBanco;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }

//    public int getVetBanco(int pos) {
//        return vetBanco[pos];
//    }
//
//    public void setVetBanco(int[] vetBanco) {
//        this.vetBanco = vetBanco;
//    }
    
    public int getBanco(int pos){
        return bancos.get(pos);
    }
}
