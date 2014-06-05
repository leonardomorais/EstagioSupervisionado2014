
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
public class Produto {

    private static Integer cdProduto;
    private static String dsProduto;
    private Double vlProduto;
    private Integer qtAtual;
    private Integer qtMin;
    private Double vlCusto;
    private String ativo;
    private String sitEstoque;

    private Familia familia = new Familia();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Produto produto) {
        RetornaSequencia seq = new RetornaSequencia();
        produto.setCdProduto(seq.retornaSequencia("CD_PRODUTO", "PRODUTOS"));
        String sql = "INSERT INTO PRODUTOS (CD_PRODUTO, CD_FAMILIA, DS_PRODUTO, "
                + "VL_PRODUTO, QT_ATUAL, QT_MIN, VL_CUSTO, ATIVO, SIT_ESTOQUE) "
                + "VALUES ('" + produto.getCdProduto() + "',"
                + "'" + familia.getVetFamilia(familia.getCdFamilia()) + "',"
                + "'" + produto.getDsProduto() + "','" + produto.getVlProduto() + "',"
                + "'" + produto.getQtAtual() + "','" + produto.getQtMin() + "',"
                + "'" + produto.getVlCusto() + "','" + produto.getAtivo() + "','" + produto.getSitEstoque() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(Produto produto) {
        String sql = "UPDATE PRODUTOS SET CD_FAMILIA = '" + familia.getVetFamilia(familia.getCdFamilia()) + "', "
                + "DS_PRODUTO = '" + produto.getDsProduto() + "', VL_PRODUTO = '" + produto.getVlProduto() + "', "
                + "QT_ATUAL = '" + produto.getQtAtual() + "', QT_MIN = '" + produto.getQtMin() + "', "
                + "VL_CUSTO = '" + produto.getVlCusto() + "', ATIVO = '" + produto.getAtivo() + "', "
                + "SIT_ESTOQUE = '" + produto.getSitEstoque() + "' WHERE CD_PRODUTO = " + produto.getCdProduto();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Produto produto) {
        String sql = "DELETE FROM PRODUTOS WHERE CD_PRODUTO = " + produto.getCdProduto();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarGeral(boolean todos) {
        String sql = "";
        if (todos) {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN, CASE WHEN ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS ATIVO, "
                    + "CASE WHEN SIT_ESTOQUE = 'V' THEN 'VÁLIDO' ELSE 'INVÁLIDO' END AS SIT_ESTOQUE "
                    + " FROM PRODUTOS P INNER JOIN FAMILIA F "
                    + "ON P.CD_FAMILIA = F.CD_FAMILIA ORDER BY P.CD_PRODUTO";
        } else {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN FROM PRODUTOS P INNER JOIN FAMILIA F "
                    + "ON P.CD_FAMILIA = F.CD_FAMILIA WHERE SIT_ESTOQUE = 'V' AND P.ATIVO = 'A' "
                    + "ORDER BY P.CD_PRODUTO";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdProduto(Produto produto, boolean todos) {
        String sql = "";
        if (todos) {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN, CASE WHEN ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS ATIVO, "
                    + "CASE WHEN SIT_ESTOQUE = 'V' THEN 'VÁLIDO' ELSE 'INVÁLIDO' END AS SIT_ESTOQUE "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F ON P.CD_FAMILIA = F.CD_FAMILIA "
                    + "WHERE P.CD_PRODUTO = " + produto.getCdProduto();
        } else {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN FROM PRODUTOS P INNER JOIN FAMILIA F "
                    + "ON P.CD_FAMILIA = F.CD_FAMILIA WHERE P.CD_PRODUTO = " + produto.getCdProduto() + " "
                    + "AND SIT_ESTOQUE = 'V' AND P.ATIVO = 'A' ORDER BY P.CD_PRODUTO";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsProduto(Produto produto, boolean todos) {
        String sql = "";
        if (todos) {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN, CASE WHEN ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS ATIVO, "
                    + "CASE WHEN SIT_ESTOQUE = 'V' THEN 'VÁLIDO' ELSE 'INVÁLIDO' END AS SIT_ESTOQUE "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F ON P.CD_FAMILIA = F.CD_FAMILIA "
                    + "WHERE P.DS_PRODUTO LIKE  '%" + produto.getDsProduto() + "%' ORDER BY P.CD_PRODUTO";
        } else {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F ON P.CD_FAMILIA = F.CD_FAMILIA "
                    + "WHERE P.DS_PRODUTO LIKE '%" + produto.getDsProduto() + "%' "
                    + "AND P.SIT_ESTOQUE = 'V' AND P.ATIVO = 'A' ORDER BY P.CD_PRODUTO";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;

    }

    public void retornaProduto(Produto produto, boolean todos) {
        ResultSet retorno = consultarCdProduto(produto, todos);
        try {
            retorno.first();
            produto.setDsProduto(retorno.getString("DS_PRODUTO"));
            familia.setDsFamilia(retorno.getString("DS_FAMILIA"));
            produto.setQtAtual(retorno.getInt("QT_ATUAL"));
            produto.setQtMin(retorno.getInt("QT_MIN"));
            produto.setVlCusto(retorno.getDouble("VL_CUSTO"));
            produto.setVlProduto(retorno.getDouble("VL_PRODUTO"));
            
            if (todos){
                produto.setAtivo(retorno.getString("ATIVO"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado !");
            produto.setDsProduto("");
        }

    }

    public void retornaComboFamilia(JComboBox combo) {
        familia.retornaComboFamilia(combo);
    }

// getter e setter
    public Integer getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(Integer cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    public Double getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(Double vlProduto) {
        this.vlProduto = vlProduto;
    }

    public Integer getQtAtual() {
        return qtAtual;
    }

    public void setQtAtual(Integer qtAtual) {
        this.qtAtual = qtAtual;
    }

    public Integer getQtMin() {
        return qtMin;
    }

    public void setQtMin(Integer qtMin) {
        this.qtMin = qtMin;
    }

    public Double getVlCusto() {
        return vlCusto;
    }

    public void setVlCusto(Double vlCusto) {
        this.vlCusto = vlCusto;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getSitEstoque() {
        return sitEstoque;
    }

    public void setSitEstoque(String sitEstoque) {
        this.sitEstoque = sitEstoque;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

}
