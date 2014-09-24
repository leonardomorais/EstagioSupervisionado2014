package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class MovEstoque {

    private Integer cdMov;
    private Integer cdProduto;
    private Integer cdVendaCompra;
    private Integer qtAnterior;
    private Integer qtAtual;
    private Double vlProduto;
    private Double vlCusto;
    private String dtMov;
    private String entrada;

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(MovEstoque estoque, boolean venda) {
        RetornaSequencia seq = new RetornaSequencia();

        estoque.setCdMov(seq.retornaSequencia("CD_MOV", "MOV_ESTOQUE"));

        String sql;

        if (venda){
            // atualizar estoque depois de uma venda/compra

            if(produtoRepetido(estoque)){
                alterar(estoque);
            }
            else{
                sql = "INSERT INTO MOV_ESTOQUE (CD_MOV, CD_PRODUTO, CD_VENDA_COMPRA, "
                        + "QT_ANTERIOR, QT_ATUAL, VL_PRODUTO, VL_CUSTO, DT_MOVIMENTO, ENTRADA) "
                        + "VALUES ('" + estoque.getCdMov() + "','" + estoque.getCdProduto() + "','"
                        + estoque.getCdVendaCompra() + "','" + estoque.getQtAnterior() + "','"
                        + estoque.getQtAtual() + "','" + estoque.getVlProduto() + "','" + estoque.getVlCusto() + "','"
                        + estoque.getDtMov() + "','" + estoque.getEntrada() + "')";
                conexao.incluirSQL(sql);
            }            
        }
        else{
            // atualizar estoque a partir do cadastro de produtos
                sql = "INSERT INTO MOV_ESTOQUE (CD_MOV, CD_PRODUTO, QT_ANTERIOR, QT_ATUAL, VL_PRODUTO, VL_CUSTO, "
                        + "DT_MOVIMENTO, ENTRADA) VALUES ('"+estoque.getCdMov()+"','"+estoque.getCdProduto()+"','"
                        +estoque.getQtAnterior()+"','"+estoque.getQtAtual()+"','"+estoque.getVlProduto()+"','"
                        +estoque.getVlCusto()+"','"+estoque.getDtMov()+"','"+estoque.getEntrada()+"')";
        conexao.incluirSQL(sql);
        }
    }
    
    public void incluir(MovEstoque estoque){
        RetornaSequencia seq = new RetornaSequencia();

        estoque.setCdMov(seq.retornaSequencia("CD_MOV", "MOV_ESTOQUE"));
        String sql = "INSERT INTO MOV_ESTOQUE (CD_MOV, CD_PRODUTO, CD_VENDA_COMPRA, "
                        + "QT_ANTERIOR, QT_ATUAL, VL_PRODUTO, VL_CUSTO, DT_MOVIMENTO, ENTRADA) "
                        + "VALUES ('" + estoque.getCdMov() + "','" + estoque.getCdProduto() + "','"
                        + estoque.getCdVendaCompra() + "','" + estoque.getQtAnterior() + "','"
                        + estoque.getQtAtual() + "','" + estoque.getVlProduto() + "','" + estoque.getVlCusto() + "','"
                        + estoque.getDtMov() + "','" + estoque.getEntrada() + "')";
                conexao.incluirSQL(sql);
    }
    
    
    public void alterar(MovEstoque estoque){
        String sql = "UPDATE MOV_ESTOQUE SET QT_ATUAL = '"+estoque.getQtAtual()+"' "
                + "WHERE CD_MOV = "+estoque.getCdMov();
        conexao.atualizarSQL(sql);
    }
    
    public ResultSet consultarGeral(MovEstoque estoque, String dataFinal){
        String clausula;
        if (estoque.getDtMov().equals("")){
            clausula = "";
        }
        else{
            clausula = "WHERE MOV.DT_MOVIMENTO BETWEEN '"+estoque.getDtMov()+"' AND '"+dataFinal+"' ";
        }
        String sql = "SELECT MOV.CD_MOV, MOV.CD_VENDA_COMPRA, MOV.CD_PRODUTO, "
                + "P.DS_PRODUTO, MOV.QT_ANTERIOR, MOV.QT_ATUAL, "
                + "MOV.VL_PRODUTO, MOV.VL_CUSTO, "
                + "TO_CHAR(MOV.DT_MOVIMENTO, 'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN ENTRADA = 'E' THEN 'ENTRADA' ELSE "
                + "'SAÍDA' END AS TIPO "
                + "FROM MOV_ESTOQUE MOV "
                + "INNER JOIN PRODUTOS P "
                + "ON MOV.CD_PRODUTO = P.CD_PRODUTO "+clausula
                + "ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    } 
    
    public ResultSet consultarCdMov(MovEstoque estoque, String dataFinal){
        String clausula;
        if (estoque.getDtMov().equals("")){
            clausula = "";
        }
        else{
            clausula = " AND MOV.DT_MOVIMENTO BETWEEN '"+estoque.getDtMov()+"' AND '"+dataFinal+"'";
        }
        String sql = "SELECT MOV.CD_MOV, MOV.CD_VENDA_COMPRA, MOV.CD_PRODUTO, "
                + "P.DS_PRODUTO, MOV.QT_ANTERIOR, MOV.QT_ATUAL, "
                + "MOV.VL_PRODUTO, MOV.VL_CUSTO, "
                + "TO_CHAR(MOV.DT_MOVIMENTO, 'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN ENTRADA = 'E' THEN 'ENTRADA' ELSE "
                + "'SAÍDA' END AS TIPO "
                + "FROM MOV_ESTOQUE MOV "
                + "INNER JOIN PRODUTOS P "
                + "ON MOV.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE MOV.CD_MOV = "+estoque.getCdMov()+clausula;
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarCdVendaCompra(MovEstoque estoque, String dataFinal){
        String clausula;
        if (estoque.getDtMov().equals("")){
            clausula = "";
        }
        else{
            clausula = " AND MOV.DT_MOVIMENTO BETWEEN '"+estoque.getDtMov()+"' AND '"+dataFinal+"'";
        }
        String sql = "SELECT MOV.CD_MOV, MOV.CD_VENDA_COMPRA, MOV.CD_PRODUTO, "
                + "P.DS_PRODUTO, MOV.QT_ANTERIOR, MOV.QT_ATUAL, "
                + "MOV.VL_PRODUTO, MOV.VL_CUSTO, "
                + "TO_CHAR(MOV.DT_MOVIMENTO, 'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN ENTRADA = 'E' THEN 'ENTRADA' ELSE "
                + "'SAÍDA' END AS TIPO "
                + "FROM MOV_ESTOQUE MOV "
                + "INNER JOIN PRODUTOS P "
                + "ON MOV.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE MOV.CD_VENDA_COMPRA = "+estoque.getCdVendaCompra()+clausula 
                + " ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        
        return conexao.resultset;
    }
    
    public ResultSet consultarCdProduto(MovEstoque estoque, String dataFinal){
        String clausula;
        if (estoque.getDtMov().equals("")){
            clausula = "";
        }
        else{
            clausula = " AND MOV.DT_MOVIMENTO BETWEEN '"+estoque.getDtMov()+"' AND '"+dataFinal+"'";
        }
        String sql = "SELECT MOV.CD_MOV, MOV.CD_VENDA_COMPRA, MOV.CD_PRODUTO, "
                + "P.DS_PRODUTO, MOV.QT_ANTERIOR, MOV.QT_ATUAL, "
                + "MOV.VL_PRODUTO, MOV.VL_CUSTO, "
                + "TO_CHAR(MOV.DT_MOVIMENTO, 'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN ENTRADA = 'E' THEN 'ENTRADA' ELSE "
                + "'SAÍDA' END AS TIPO "
                + "FROM MOV_ESTOQUE MOV "
                + "INNER JOIN PRODUTOS P "
                + "ON MOV.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE MOV.CD_PRODUTO = "+estoque.getCdProduto()+clausula
                + " ORDER BY MOV.CD_PRODUTO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarProduto(String nome, MovEstoque estoque ,String dataFinal){
        String clausula;
        if (estoque.getDtMov().equals("")){
            clausula = "";
        }
        else{
            clausula = "AND MOV.DT_MOVIMENTO BETWEEN '"+estoque.getDtMov()+"' AND '"+dataFinal+"' ";
        }
        String sql = "SELECT MOV.CD_MOV, MOV.CD_VENDA_COMPRA, MOV.CD_PRODUTO, "
                + "P.DS_PRODUTO, MOV.QT_ANTERIOR, MOV.QT_ATUAL, "
                + "MOV.VL_PRODUTO, MOV.VL_CUSTO, "
                + "TO_CHAR(MOV.DT_MOVIMENTO, 'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN ENTRADA = 'E' THEN 'ENTRADA' ELSE "
                + "'SAÍDA' END AS TIPO "
                + "FROM MOV_ESTOQUE MOV "
                + "INNER JOIN PRODUTOS P "
                + "ON MOV.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE P.DS_PRODUTO LIKE '%"+nome+"%' "+clausula
                + "ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarTipo(MovEstoque estoque, String dataFinal){
        String clausula;
        if (estoque.getDtMov().equals("")){
            clausula = "";
        }
        else{
            clausula = "AND MOV.DT_MOVIMENTO BETWEEN '"+estoque.getDtMov()+"' AND '"+dataFinal+"' ";
        }
        String sql = "SELECT MOV.CD_MOV, MOV.CD_VENDA_COMPRA, MOV.CD_PRODUTO, "
                + "P.DS_PRODUTO, MOV.QT_ANTERIOR, MOV.QT_ATUAL, "
                + "MOV.VL_PRODUTO, MOV.VL_CUSTO, "
                + "TO_CHAR(MOV.DT_MOVIMENTO, 'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN ENTRADA = 'E' THEN 'ENTRADA' ELSE "
                + "'SAÍDA' END AS TIPO "
                + "FROM MOV_ESTOQUE MOV "
                + "INNER JOIN PRODUTOS P "
                + "ON MOV.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE  MOV.ENTRADA = '"+estoque.getEntrada()+"' "+clausula
                + "ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public boolean produtoRepetido(MovEstoque estoque){
        boolean repetido = false;
        String sql = "SELECT CD_MOV, CD_PRODUTO, CD_VENDA_COMPRA ,QT_ANTERIOR, QT_ATUAL FROM "
                + "MOV_ESTOQUE WHERE CD_VENDA_COMPRA = "+estoque.getCdVendaCompra();
        conexao.executeSQL(sql);
        try{
            while (conexao.resultset.next()){
                int cd_mov = conexao.resultset.getInt("CD_MOV");
                int cd_prod = conexao.resultset.getInt("CD_PRODUTO");
                int cd_vendaCompra = conexao.resultset.getInt("CD_VENDA_COMPRA");
                if (estoque.getCdProduto() == cd_prod && 
                        estoque.getCdVendaCompra() == cd_vendaCompra){
                    repetido = true;
                    estoque.setCdMov(cd_mov);
                    break;
                }
            }
        }catch(SQLException ex){
            repetido = false;
        }
        
        return repetido;
    }

// getter e setter
    public Integer getCdMov() {
        return cdMov;
    }

    public void setCdMov(Integer cdMov) {
        this.cdMov = cdMov;
    }

    public Integer getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(Integer cdProduto) {
        this.cdProduto = cdProduto;
    }

    public Integer getCdVendaCompra() {
        return cdVendaCompra;
    }

    public void setCdVendaCompra(Integer cdVendaCompra) {
        this.cdVendaCompra = cdVendaCompra;
    }

    public Integer getQtAnterior() {
        return qtAnterior;
    }

    public void setQtAnterior(Integer qtAnterior) {
        this.qtAnterior = qtAnterior;
    }

    public Integer getQtAtual() {
        return qtAtual;
    }

    public void setQtAtual(Integer qtAtual) {
        this.qtAtual = qtAtual;
    }

    public Double getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(Double vlProduto) {
        this.vlProduto = vlProduto;
    }

    public Double getVlCusto() {
        return vlCusto;
    }

    public void setVlCusto(Double vlCusto) {
        this.vlCusto = vlCusto;
    }

    public String getDtMov() {
        return dtMov;
    }

    public void setDtMov(String dtMov) {
        this.dtMov = dtMov;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

}
