package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Consultas.ProdutosEstoqueInvalido;
import Mensagens.Avisos;
import Validacoes.RetornaData;
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

    private Familia familia = new Familia();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Produto produto) {
        RetornaSequencia seq = new RetornaSequencia();
        produto.setCdProduto(seq.retornaSequencia("CD_PRODUTO", "PRODUTOS"));
        String sql = "INSERT INTO PRODUTOS (CD_PRODUTO, CD_FAMILIA, DS_PRODUTO, "
                + "VL_PRODUTO, QT_ATUAL, QT_MIN, VL_CUSTO, ATIVO) "
                + "VALUES ('" + produto.getCdProduto() + "',"
                + "'" + familia.getFamilia(familia.getCdFamilia()) + "',"
                + "'" + produto.getDsProduto() + "','" + produto.getVlProduto() + "',"
                + "'" + produto.getQtAtual() + "','" + produto.getQtMin() + "',"
                + "'" + produto.getVlCusto() + "','" + produto.getAtivo() + "')";
        conexao.incluirSQL(sql);

        atualizarEstoque(produto, 0, true);
    }

    public void alterar(Produto produto) {
        int qtAntes;
        conexao.executeSQL("SELECT QT_ATUAL FROM PRODUTOS WHERE CD_PRODUTO = " + produto.getCdProduto());
        try {
            conexao.resultset.first();
            qtAntes = conexao.resultset.getInt("QT_ATUAL");

        } catch (SQLException ex) {
            qtAntes = 0;
        }

        String sql = "UPDATE PRODUTOS SET CD_FAMILIA = '" + familia.getFamilia(familia.getCdFamilia()) + "', "
                + "DS_PRODUTO = '" + produto.getDsProduto() + "', VL_PRODUTO = '" + produto.getVlProduto() + "', "
                + "QT_ATUAL = '" + produto.getQtAtual() + "', QT_MIN = '" + produto.getQtMin() + "', "
                + "VL_CUSTO = '" + produto.getVlCusto() + "', ATIVO = '" + produto.getAtivo() + "'"
                + " WHERE CD_PRODUTO = " + produto.getCdProduto();
        conexao.atualizarSQL(sql);

        if (qtAntes != produto.qtAtual) {
            if (qtAntes < produto.qtAtual) {
                atualizarEstoque(produto, qtAntes, true);
            } else {
                atualizarEstoque(produto, qtAntes, false);
            }
        }

    }

    public void excluir(Produto produto) {
        String sql = "UPDATE PRODUTOS SET ATIVO = 'I' WHERE CD_PRODUTO = " + produto.getCdProduto();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarGeral(boolean todos) {
        String sql = "";
        if (todos) {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN, CASE WHEN ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS ATIVO, "
                    + "CASE WHEN P.QT_ATUAL > P.QT_MIN THEN 'VÁLIDO' ELSE 'INVÁLIDO' END AS SIT_ESTOQUE "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F "
                    + "ON P.CD_FAMILIA = F.CD_FAMILIA ORDER BY P.CD_PRODUTO";
        } else {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F "
                    + "ON P.CD_FAMILIA = F.CD_FAMILIA WHERE P.QT_ATUAL > P.QT_MIN AND P.ATIVO = 'A' "
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
                    + "CASE WHEN P.QT_ATUAL > P.QT_MIN THEN 'VÁLIDO' ELSE 'INVÁLIDO' END AS SIT_ESTOQUE "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F "
                    + "ON P.CD_FAMILIA = F.CD_FAMILIA WHERE P.CD_PRODUTO = " + produto.getCdProduto();
        } else {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F "
                    + "ON P.CD_FAMILIA = F.CD_FAMILIA WHERE P.CD_PRODUTO = " + produto.getCdProduto()
                    + " AND P.QT_ATUAL > P.QT_MIN AND P.ATIVO = 'A' ";

        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsProduto(Produto produto, boolean todos) {
        String sql = "";
        if (todos) {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN, CASE WHEN ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS ATIVO, "
                    + "CASE WHEN P.QT_ATUAL > P.QT_MIN THEN 'VÁLIDO' ELSE 'INVÁLIDO' END AS SIT_ESTOQUE "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F ON P.CD_FAMILIA = F.CD_FAMILIA "
                    + "WHERE P.DS_PRODUTO LIKE  '%" + produto.getDsProduto() + "%' ORDER BY P.CD_PRODUTO";
        } else {
            sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                    + "P.QT_ATUAL, P.QT_MIN "
                    + "FROM PRODUTOS P INNER JOIN FAMILIA F ON P.CD_FAMILIA = F.CD_FAMILIA "
                    + "WHERE P.DS_PRODUTO LIKE '%" + produto.getDsProduto() + "%' "
                    + "AND P.QT_ATUAL > P.QT_MIN AND P.ATIVO = 'A' ORDER BY P.CD_PRODUTO";
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

            if (todos) {
                produto.setAtivo("ATIVO");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado !");
            produto.setDsProduto("");
        }

    }

    public void retornaComboFamilia(JComboBox combo) {
        familia.retornaComboFamilia(combo);
    }

    public void atualizarEstoque(Produto produto, int qtAnterior, boolean entrada) {
        MovEstoque estoque = new MovEstoque();
        RetornaData data = new RetornaData();
        estoque.setCdProduto(produto.getCdProduto());
        estoque.setDtMov(data.retornaDataAtual());
        estoque.setQtAnterior(qtAnterior);
        estoque.setQtAtual(produto.getQtAtual());
        estoque.setVlCusto(produto.getVlCusto());
        estoque.setVlProduto(produto.getVlProduto());

        if (entrada) {
            estoque.setEntrada("E");
        } else {
            estoque.setEntrada("S");
        }
        estoque.incluir(estoque, false);
        //
        Avisos aviso = new Avisos();
        if (aviso.existemAvisos()){
            aviso.adicionarAvisos();
        }
        else{
            aviso.removerAviso();
        }
    }

    public void alteraQtAtual(Produto produto) {
        conexao.executeSQL("UPDATE PRODUTOS SET QT_ATUAL = '" + produto.getQtAtual() + "' "
                + "WHERE CD_PRODUTO = " + produto.getCdProduto());
    }

    public boolean possuiEstoqueInvalido() {
        boolean possui = false;
        ResultSet retorno = produtosEstoqueInvalido();
        try{
           retorno.first();
           int cd = retorno.getInt("CD_PRODUTO");
           possui = true;
        }
        catch(SQLException ex){
            
        }
        return possui;
    }
    
    public ResultSet produtosEstoqueInvalido(){
        String sql = "SELECT P.CD_PRODUTO, P.DS_PRODUTO, F.DS_FAMILIA, P.VL_PRODUTO, P.VL_CUSTO, "
                + "P.QT_ATUAL, P.QT_MIN FROM PRODUTOS P INNER JOIN FAMILIA F "
                + "ON P.CD_FAMILIA = F.CD_FAMILIA "
                + "WHERE P.ATIVO = 'A' AND P.QT_ATUAL <= P.QT_MIN "
                + "ORDER BY P.CD_PRODUTO";
        conexao.executeSQL(sql);
        return conexao.resultset;
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

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

}
