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
public class AgenciaConta {

    private static Integer cdAgcConta;
    private String nrAgencia;
    private String nrConta;
    private static String dsConta;
    private Double vlConta;
    private String inAtivo;

    private Map<Integer, Integer> contas = new HashMap<Integer, Integer>();
    // private int[] vetAgcConta = new int[100];
    private Banco banco = new Banco();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(AgenciaConta agc) {
        RetornaSequencia seq = new RetornaSequencia();
        agc.setCdAgcConta(seq.retornaSequencia("CD_AGENCIA_CONTA", "AGENCIA_CONTA"));
        String sql = "INSERT INTO AGENCIA_CONTA (CD_AGENCIA_CONTA, CD_BANCO, NR_AGENCIA, NR_CONTA, "
                + "DS_CONTA, VALOR_CONTA, IN_ATIVO) VALUES ('" + agc.getCdAgcConta() + "','"
                + banco.getBanco(banco.getCdBanco()) + "','" + agc.getNrAgencia() + "','" + agc.getNrConta() + "','"
                + agc.getDsConta() + "','" + agc.getVlConta() + "','" + agc.getInAtivo() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Conta gravada com sucesso!");
        }
    }

    public void alterar(AgenciaConta agc) {
        String sql = "UPDATE AGENCIA_CONTA SET CD_BANCO = '" + banco.getBanco(banco.getCdBanco()) + "', "
                + "NR_AGENCIA = '" + agc.getNrAgencia() + "', NR_CONTA = '" + agc.getNrConta() + "', "
                + "DS_CONTA = '" + agc.getDsConta() + "', "
                + "VALOR_CONTA = '" + agc.getVlConta() + "', IN_ATIVO = '" + agc.getInAtivo() + "' "
                + "WHERE CD_AGENCIA_CONTA = " + agc.getCdAgcConta();
        conexao.atualizarSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Conta alterada com sucesso!");
        }
    }

    public void excluir(AgenciaConta agc) {
        String sql = "UPDATE AGENCIA_CONTA SET IN_ATIVO = 'I' WHERE CD_AGENCIA_CONTA = " + agc.getCdAgcConta();
        conexao.deleteSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Conta inativada com sucesso!");
        }
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT A.CD_AGENCIA_CONTA, B.NM_BANCO, A.NR_AGENCIA, A.NR_CONTA, A.DS_CONTA, A.VALOR_CONTA, "
                + "CASE WHEN A.IN_ATIVO = 'A' THEN 'ATIVA' ELSE 'INATIVA' END AS SITUACAO "
                + "FROM AGENCIA_CONTA A INNER JOIN BANCO B ON A.CD_BANCO = B.CD_BANCO ORDER BY A.CD_AGENCIA_CONTA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdAgc(AgenciaConta agc) {
        String sql = "SELECT A.CD_AGENCIA_CONTA, B.NM_BANCO, A.NR_AGENCIA, A.NR_CONTA, A.DS_CONTA, A.VALOR_CONTA, "
                + "CASE WHEN A.IN_ATIVO = 'A' THEN 'ATIVA' ELSE 'INATIVA' END AS SITUACAO "
                + "FROM AGENCIA_CONTA A INNER JOIN BANCO B ON A.CD_BANCO = B.CD_BANCO "
                + "WHERE A.CD_AGENCIA_CONTA = " + agc.getCdAgcConta();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsConta(AgenciaConta agc) {
        String sql = "SELECT A.CD_AGENCIA_CONTA, B.NM_BANCO, A.NR_AGENCIA, A.NR_CONTA, A.DS_CONTA, A.VALOR_CONTA, "
                + "CASE WHEN A.IN_ATIVO = 'A' THEN 'ATIVA' ELSE 'INATIVA' END AS SITUACAO "
                + "FROM AGENCIA_CONTA A INNER JOIN BANCO B ON A.CD_BANCO = B.CD_BANCO "
                + "WHERE A.DS_CONTA LIKE '%" + agc.getDsConta() + "%' ORDER BY A.CD_AGENCIA_CONTA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaAgenciaConta(AgenciaConta agc) {
        ResultSet retorno = consultarCdAgc(agc);
        try {
            retorno.first();
            banco.setNmBanco(retorno.getString("NM_BANCO"));
            agc.setDsConta(retorno.getString("DS_CONTA"));
            agc.setNrAgencia(retorno.getString("NR_AGENCIA"));
            agc.setNrConta(retorno.getString("NR_CONTA"));
            agc.setVlConta(retorno.getDouble("VALOR_CONTA"));
            agc.setInAtivo(retorno.getString("SITUACAO"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Agência Conta não encontrada !");
            agc.setDsConta("");
        }
    }

    public void retornaComboAgcConta(JComboBox combo) {
        String sql = "SELECT * FROM AGENCIA_CONTA ORDER BY CD_AGENCIA_CONTA";
        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;
//      int[] vet = new int[100];

        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getString("DS_CONTA"));
                contas.put(conta, conexao.resultset.getInt("CD_AGENCIA_CONTA"));
//              vet[conta] = conexao.resultset.getInt("CD_AGENCIA_CONTA");
                conta++;
            }
//            setVetAgcConta(vet);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Agência Conta não encontrada !");
        }
    }

    public void retornaComboAgcConta(JComboBox combo, AgenciaConta agc) {
        String sql = "SELECT A.CD_AGENCIA_CONTA, A.DS_CONTA, B.NM_BANCO "
                + "FROM AGENCIA_CONTA A INNER JOIN BANCO B ON "
                + "A.CD_BANCO = B.CD_BANCO AND A.IN_ATIVO = 'A' "
                + "ORDER BY A.CD_AGENCIA_CONTA";
        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;
        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getInt("CD_AGENCIA_CONTA") + " - " 
                        + conexao.resultset.getString("DS_CONTA") + " - "
                        + conexao.resultset.getString("NM_BANCO"));
                conta++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Agência Conta não encontrada !");
        }
    }

    public void atualizarValorConta(AgenciaConta agc) {
        String sql = "UPDATE AGENCIA_CONTA SET VALOR_CONTA = '" + agc.getVlConta() + "' WHERE "
                + "CD_AGENCIA_CONTA = " + agc.getCdAgcConta();
        conexao.atualizarSQL(sql);
    }

    // getter  e setter
    public Integer getCdAgcConta() {
        return cdAgcConta;
    }

    public void setCdAgcConta(Integer cdAgcConta) {
        this.cdAgcConta = cdAgcConta;
    }

    public String getNrAgencia() {
        return nrAgencia;
    }

    public void setNrAgencia(String nrAgencia) {
        this.nrAgencia = nrAgencia;
    }

    public String getDsConta() {
        return dsConta;
    }

    public void setDsConta(String dsConta) {
        this.dsConta = dsConta;
    }

    public Double getVlConta() {
        return vlConta;
    }

    public void setVlConta(Double vlConta) {
        this.vlConta = vlConta;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

//    public int getVetAgcConta(int pos) {
//        return vetAgcConta[pos];
//    }
//
//    public void setVetAgcConta(int[] vetAgcConta) {
//        this.vetAgcConta = vetAgcConta;
//    }
    public int getConta(int pos) {
        return contas.get(pos);
    }

}
