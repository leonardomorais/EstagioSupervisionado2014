package Validacoes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class RetornaSequencia {

    public int retornaSequencia(String atributo, String tabela) {

        ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
        String sql = "SELECT COALESCE (MAX(" + atributo + "),0) + 1 AS ULTIMO FROM " + tabela;
        conexao.executeSQL(sql);
        int resultado = 0;
        try {
            conexao.resultset.first();
            resultado = conexao.resultset.getInt("ULTIMO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados nao encontrados \n" + ex);
        }
        return resultado;

    }

    public int retornaSequencia(String atributo, String tabela, String chave, int valor) {

        ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
        String sql = "SELECT COALESCE (MAX(" + atributo + "),0) + 1 AS ULTIMO FROM " + tabela + " WHERE " + chave + " = " + valor;
        conexao.executeSQL(sql);
        int resultado = 0;
        try {
            conexao.resultset.first();
            resultado = conexao.resultset.getInt("ULTIMO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados nao encontrados \n" + ex);
        }
        return resultado;

    }
}
