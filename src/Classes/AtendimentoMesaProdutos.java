package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class AtendimentoMesaProdutos {

    //private Integer nrAtendimento;
    private AtendimentoMesa atendimento = new AtendimentoMesa();
    private Produto produto = new Produto();
    private Integer quantidade;
    private Double valor;

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(AtendimentoMesaProdutos atd) {
        String sql = "INSERT INTO ATENDIMENTO_MESA_PRODUTOS "
                + "(NR_ATENDIMENTO, CD_PRODUTO, QT_PRODUTO, VL_UNITARIO) "
                + "VALUES ('" + atd.getAtendimento().getNrAtendimento() + "','"
                + atd.getProduto().getCdProduto() + "','" + atd.getQuantidade() + "','"
                + atd.getValor() + "')";
        conexao.incluirSQL(sql);
    }

    public void excluir(AtendimentoMesaProdutos atd) {
        String sql = "DELETE FROM ATENDIMENTO_MESA_PRODUTOS WHERE "
                + "NR_ATENDIMENTO = " + atd.getAtendimento().getNrAtendimento() + " AND "
                + "CD_PRODUTO = " + atd.getProduto().getCdProduto();
        conexao.deleteSQL(sql);
    }

    public void excluirTodos(AtendimentoMesaProdutos atd) {
        ResultSet retorno = atd.consultarProdutos(atd);
        try {
            while (retorno.next()) {
                atd.getProduto().setCdProduto(retorno.getInt("CD_PRODUTO"));
                atd.setQuantidade(retorno.getInt("QT_PRODUTO"));
                atd.getProduto().retornaProduto(atd.getProduto(), true);
                atd.getProduto().setQtAtual(atd.getProduto().getQtAtual() + atd.getQuantidade());
                atd.getProduto().alteraQtAtual(atd.getProduto());
                // atualiza a quantidade atual dos produtos
            }
        } catch (SQLException ex) {

        }
        String sql = "DELETE FROM ATENDIMENTO_MESA_PRODUTOS WHERE "
                + "NR_ATENDIMENTO = " + atd.getAtendimento().getNrAtendimento();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarProdutos(AtendimentoMesaProdutos atd) {
        String sql = "SELECT A.CD_PRODUTO, P.DS_PRODUTO, "
                + " A.VL_UNITARIO, A.QT_PRODUTO, A.QT_PRODUTO * A.VL_UNITARIO AS TOTAL "
                + "FROM ATENDIMENTO_MESA_PRODUTOS A INNER JOIN "
                + "PRODUTOS P ON A.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE A.NR_ATENDIMENTO = " + atd.getAtendimento().getNrAtendimento();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    // getter e setter
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    

//    public Integer getNrAtendimento() {
//        return nrAtendimento;
//    }
//
//    public void setNrAtendimento(Integer nrAtendimento) {
//        this.nrAtendimento = nrAtendimento;
//    }

    public AtendimentoMesa getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoMesa atendimento) {
        this.atendimento = atendimento;
    }

}
