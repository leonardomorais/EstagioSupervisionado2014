package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Cidade {

    private Integer cdCidade;
    private int[] vetCidades = new int[100];
    private String dsCidade;

    private UF estado = new UF();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Cidade cidade) {
        RetornaSequencia seq = new RetornaSequencia();
        setCdCidade(seq.retornaSequencia("CD_CIDADE", "CIDADE"));
        String sql = "INSERT INTO CIDADE (CD_CIDADE, CD_UF, DS_CIDADE) VALUES"
                + "('" + cidade.getCdCidade() + "','" + estado.getVetEstados(estado.getCdUf()) + "','"
                + cidade.getDsCidade() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(Cidade cidade) {
        String sql = "UPDATE CIDADE SET CD_UF = '" + estado.getVetEstados(estado.getCdUf()) + "', "
                + " DS_CIDADE = '" + cidade.getDsCidade() + "' WHERE CD_CIDADE = " + cidade.getCdCidade();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Cidade cidade) {
        String sql = "DELETE FROM CIDADE WHERE CD_CIDADE = " + cidade.getCdCidade();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarGeral() {
        ResultSet retorno = null;
        String sql = "SELECT C.CD_CIDADE, C.DS_CIDADE, C.CD_UF, U.NOME_UF FROM CIDADE C"
                + " INNER JOIN UF U ON C.CD_UF = U.CD_UF ORDER BY C.CD_CIDADE";
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public ResultSet consultarCodigo(Cidade cidade) {
        ResultSet retorno = null;
        String sql = "SELECT C.CD_CIDADE, C.DS_CIDADE, C.CD_UF, U.NOME_UF FROM CIDADE C"
                + " INNER JOIN UF U ON C.CD_UF = U.CD_UF WHERE CD_CIDADE = " + cidade.getCdCidade();
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public ResultSet consultarNome(Cidade cidade) {
        ResultSet retorno = null;
        String sql = "SELECT C.CD_CIDADE, C.DS_CIDADE, C.CD_UF, U.NOME_UF FROM CIDADE C"
                + " INNER JOIN UF U ON C.CD_UF = U.CD_UF WHERE DS_CIDADE LIKE "
                + "'%" + cidade.getDsCidade() + "%' ORDER BY CD_CIDADE";
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public void retornaCidade(Cidade cidade) {
        ResultSet retorno = consultarCodigo(cidade);
        try {
            retorno.first();
            cidade.setDsCidade(retorno.getString("DS_CIDADE"));
            cidade.getEstado().setDsUf(retorno.getString("NOME_UF"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cidade não encontrada !");
            cidade.setDsCidade("");
        }

    }

    public void retornaComboEstado(JComboBox combo) {
        estado.retornaComboEstados(combo);

    }

    public void retornaComboCidades(JComboBox combo) {
        String sql = "SELECT * FROM CIDADE ORDER BY CD_CIDADE";
        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;
        int[] vet = new int[100];

        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getString("DS_CIDADE"));
                vet[conta] = conexao.resultset.getInt("CD_CIDADE");
                conta++;
            }
            setVetCidades(vet);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cidade não encontrada !");
        }
    }

// getter e setter
    public Integer getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(Integer cdCidade) {
        this.cdCidade = cdCidade;
    }

    public UF getEstado() {
        return estado;
    }

    public void setEstado(UF estado) {
        this.estado = estado;
    }

    public int getVetCidades(int pos) {
        return vetCidades[pos];
    }

    public void setVetCidades(int[] vetEstados) {
        this.vetCidades = vetEstados;
    }

    public String getDsCidade() {
        return dsCidade;
    }

    public void setDsCidade(String dsCidade) {
        this.dsCidade = dsCidade;
    }

}
