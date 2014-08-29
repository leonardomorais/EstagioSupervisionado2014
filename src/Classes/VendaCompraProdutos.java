package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class VendaCompraProdutos {

    private Integer cdVendaCompra;
    private Integer quantidade;
    private Double valor;

    private Produto produto = new Produto();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(VendaCompraProdutos vcProdutos) {
        String sql;
        if (produtoRepetido(vcProdutos)){
            alterar(vcProdutos);
        }
        else{
            sql = "INSERT INTO VENDA_COMPRA_PRODUTOS "
                + "(CD_VENDA_COMPRA, CD_PRODUTO, QT_PRODUTO, VL_UNITARIO) "
                + "VALUES ('" + vcProdutos.getCdVendaCompra() + "','"
                + vcProdutos.getProduto().getCdProduto() + "','"
                + vcProdutos.getQuantidade() + "','"
                + vcProdutos.getValor() + "')";
            conexao.incluirSQL(sql);
        }
    }
    
    public void alterar(VendaCompraProdutos vcProdutos){
        String sql = "UPDATE VENDA_COMPRA_PRODUTOS "
                + "SET QT_PRODUTO = '"+vcProdutos.getQuantidade()+"' "
                + "WHERE CD_VENDA_COMPRA = "+vcProdutos.getCdVendaCompra()+" AND "
                + "CD_PRODUTO = "+vcProdutos.getProduto().getCdProduto();
        conexao.atualizarSQL(sql);
    }

    public ResultSet consultarProdutos(VendaCompraProdutos vcProdutos) {
        String sql = "SELECT VC.CD_PRODUTO, P.DS_PRODUTO, "
                + "VC.VL_UNITARIO, VC.QT_PRODUTO, VC.QT_PRODUTO * VC.VL_UNITARIO AS TOTAL "
                + "FROM VENDA_COMPRA_PRODUTOS VC INNER JOIN "
                + "PRODUTOS P ON VC.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE VC.CD_VENDA_COMPRA = " + vcProdutos.getCdVendaCompra()
                + " ORDER BY VC.CD_PRODUTO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public boolean produtoRepetido(VendaCompraProdutos vcProd) {
        boolean repetido = false;

        String sql = "SELECT CD_PRODUTO, QT_PRODUTO FROM VENDA_COMPRA_PRODUTOS "
                + "WHERE CD_VENDA_COMPRA = "+vcProd.getCdVendaCompra();
        conexao.executeSQL(sql);
       
        try {
            while (conexao.resultset.next()){
                int cd = conexao.resultset.getInt("CD_PRODUTO");
                int qt = conexao.resultset.getInt("QT_PRODUTO");
                
                
                if(vcProd.getProduto().getCdProduto() == cd){
                    repetido = true;
                    vcProd.setQuantidade(qt + vcProd.getQuantidade());
                    break;
                }
            }
        } catch (SQLException ex) {
            repetido = false;
        }
        return repetido;
    }

    // getter e setter
    public Integer getCdVendaCompra() {
        return cdVendaCompra;
    }

    public void setCdVendaCompra(Integer cdVendaCompra) {
        this.cdVendaCompra = cdVendaCompra;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
