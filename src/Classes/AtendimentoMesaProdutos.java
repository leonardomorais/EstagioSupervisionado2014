package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class AtendimentoMesaProdutos {
    
    private Integer nrAtendimento;
    private Produto produto = new Produto();
    private Integer quantidade;
    private Double valor;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(AtendimentoMesaProdutos atd){
        String sql = "INSERT INTO ATENDIMENTO_MESA_PRODUTOS "
                + "(NR_ATENDIMENTO, CD_PRODUTO, QT_PRODUTO, VL_UNITARIO) "
                + "VALUES ('"+atd.getNrAtendimento()+"','"
                +atd.getProduto().getCdProduto()+"','"+atd.getQuantidade()+"','"
                +atd.getValor()+"')";
        conexao.incluirSQL(sql);
    }
    
    public void excluir(AtendimentoMesaProdutos atd){
        String sql = "DELETE FROM ATENDIMENTO_MESA_PRODUTOS WHERE "
                + "NR_ATENDIMENTO = "+atd.getNrAtendimento()+" AND "
                + "CD_PRODUTO = "+atd.getProduto().getCdProduto();
        conexao.deleteSQL(sql);
    }
    
    public ResultSet retornaProdutos(AtendimentoMesaProdutos atd){
        String sql = "SELECT A.NR_ATENDIMENTO, A.CD_PRODUTO, P.DS_PRODUTO, "
                + "A.QT_PRODUTO, A.VL_UNITARIO, A.QT_PRODUTO * A.VL_UNITARIO AS TOTAL "
                + "FROM ATENDIMENTO_MESA_PRODUTOS A INNER JOIN "
                + "PRODUTOS P ON A.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE A.NR_ATENDIMENTO = " + atd.getNrAtendimento()+" ORDER BY A.CD_PRODUTO";
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

    public Integer getNrAtendimento() {
        return nrAtendimento;
    }

    public void setNrAtendimento(Integer nrAtendimento) {
        this.nrAtendimento = nrAtendimento;
    }

    
    
    
    
    
}
