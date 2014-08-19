
package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class VendaCompra {
    
    private Integer cdVendaCompra;
    
    private Operacao operacao = new Operacao();
    private Cliente cliente = new Cliente();
    private Fornecedor fornecedor = new Fornecedor();
    private FormaPagamento forma = new FormaPagamento();
    private VendaAtendimentoMesa vendaAtendimento = new VendaAtendimentoMesa();
    private String dtVenda;
    private Double vlTotal;
    private String pago;
  
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(VendaCompra vendaC){
        RetornaSequencia seq = new RetornaSequencia();
        vendaC.setCdVendaCompra(seq.retornaSequencia("CD_VENDA_COMPRA", "VENDA_COMPRA"));
        String sql;
        vendaC.getOperacao().retornaOperacao(vendaC.getOperacao());
        if (vendaC.getOperacao().getTipo().equals("SIM")){
            // se a operação for saída é uma venda
            sql = "INSERT INTO VENDA_COMPRA (CD_VENDA_COMPRA, CD_OPERACAO, CD_CLIENTE, "
                    + "CD_FORMA, DT_VENDA_COMPRA, VL_TOTAL, PAGO) VALUES ('"+vendaC.getCdVendaCompra()+"','"
            +vendaC.getOperacao().getCdOperacao()+"','"+vendaC.getCliente().getCdCliente()+"','"
            +vendaC.getForma().getCdForma()+"','"+vendaC.getDtVenda()+"','"+vendaC.getVlTotal()+"','"
            +vendaC.getPago()+"')";
        }
        else{
            // se a operação for entrada é uma compra
            sql = "INSERT INTO VENDA_COMPRA (CD_VENDA_COMPRA, CD_OPERACAO, CD_FORNECEDOR, "
                    + "CD_FORMA, DT_VENDA_COMPRA, VL_TOTAL, PAGO) VALUES ('"+vendaC.getCdVendaCompra()+"','"
            +vendaC.getOperacao().getCdOperacao()+"','"+vendaC.getFornecedor().getCdFornecedor()+"','"
            +vendaC.getForma().getCdForma()+"','"+vendaC.getDtVenda()+"','"+vendaC.getVlTotal()+"','"
            +vendaC.getPago()+"')";
        }
        conexao.incluirSQL(sql);
    }
    
    public void alterar(VendaCompra vendaC){
    }
    
    public void excluir(VendaCompra vendaC){
        String sql = "DELETE FROM VENDA_COMPRA WHERE CD_VENDA_COMPRA = "+vendaC.getCdVendaCompra();
        conexao.deleteSQL(sql);
    }
    
    public double retornaTotalVendaCompra(JTable jtable) {
        DefaultTableModel tabela = (DefaultTableModel) jtable.getModel();
        double total = 0;
        double valor = 0;
        int linhas = tabela.getRowCount();
        for (int i = 0; i < linhas; i++) {
            valor = Double.parseDouble(tabela.getValueAt(i, 4).toString());
            total = total + valor;
        }

        return total;
    }
    // getter e setter

    public Integer getCdVendaCompra() {
        return cdVendaCompra;
    }

    public void setCdVendaCompra(Integer cdVendaCompra) {
        this.cdVendaCompra = cdVendaCompra;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }

    public String getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public VendaAtendimentoMesa getVendaAtendimento() {
        return vendaAtendimento;
    }

    public void setVendaAtendimento(VendaAtendimentoMesa vendaAtendimento) {
        this.vendaAtendimento = vendaAtendimento;
    }
    
    
}
