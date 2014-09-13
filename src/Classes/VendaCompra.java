package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class VendaCompra {

    private static Integer cdVendaCompra;

    private Operacao operacao = new Operacao();
    private Cliente cliente = new Cliente();
    private Fornecedor fornecedor = new Fornecedor();
    private FormaPagamento forma = new FormaPagamento();
    private VendaAtendimentoMesa vendaAtendimento = new VendaAtendimentoMesa();
    private VendaCompraProdutos vcProdutos = new VendaCompraProdutos();
    private String dtVenda;
    private Double vlTotal;
    private String pago;

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(VendaCompra vendaC) {
        RetornaSequencia seq = new RetornaSequencia();
        vendaC.setCdVendaCompra(seq.retornaSequencia("CD_VENDA_COMPRA", "VENDA_COMPRA"));
        String sql;
        //vendaC.getOperacao().retornaOperacao(vendaC.getOperacao());
        switch (vendaC.getOperacao().getDsOperacao()){
            case "VENDA":
                sql = "INSERT INTO VENDA_COMPRA (CD_VENDA_COMPRA, CD_OPERACAO, CD_CLIENTE, "
                    + "CD_FORMA, DT_VENDA_COMPRA, VL_TOTAL, PAGO) VALUES ('" + vendaC.getCdVendaCompra() + "','"
                    + vendaC .getOperacao().getCdOperacao() + "','" + vendaC.getCliente().getCdCliente() + "','"
                    + vendaC.getForma().getCdForma() + "','" + vendaC.getDtVenda() + "','" + vendaC.getVlTotal() + "','"
                    + vendaC.getPago() + "')";
            break;
                
            case "COMPRA":
                sql = "INSERT INTO VENDA_COMPRA (CD_VENDA_COMPRA, CD_OPERACAO, CD_FORNECEDOR, "
                    + "CD_FORMA, DT_VENDA_COMPRA, VL_TOTAL, PAGO) VALUES ('" + vendaC.getCdVendaCompra() + "','"
                    + vendaC.getOperacao().getCdOperacao() + "','" + vendaC.getFornecedor().getCdFornecedor() + "','"
                    + vendaC.getForma().getCdForma() + "','" + vendaC.getDtVenda() + "','" + vendaC.getVlTotal() + "','"
                    + vendaC.getPago() + "')";
            break;
            
            default:
               sql = "";   
        }
        conexao.incluirSQL(sql);
    }

    public void alterar(VendaCompra vendaC) {
    }

    public void excluir(VendaCompra vc) {
        Contas contas = new Contas();
        contas.setVendaCompra(vc);
        ResultSet retorno = contas.consultarCdVendaCompra(contas);
        try{
            retorno.first();
            contas.setCdConta(retorno.getInt("CD_CONTA"));
            contas.excluir(contas);
            vc.getVcProdutos().setCdVendaCompra(vc.getCdVendaCompra());
            vc.getVcProdutos().excluir(vc.getVcProdutos());
//            String sql = "DELETE FROM VENDA_COMPRA WHERE CD_VENDA_COMPRA = " + vc.getCdVendaCompra();
//            conexao.deleteSQL(sql);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir esta venda/compra!");
        }
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT VC.CD_VENDA_COMPRA, VA.NR_ATENDIMENTO, P.CD_PESSOA, "
                + "CASE WHEN VC.CD_FORNECEDOR IS NULL THEN "
                + "(SELECT P.NOME FROM PESSOA P "
                + "INNER JOIN CLIENTE C ON P.CD_PESSOA = C.CD_PESSOA "
                + "INNER JOIN VENDA_COMPRA V ON V.CD_CLIENTE = C.CD_PESSOA "
                + "WHERE V.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA) "
                + "ELSE "
                + "(SELECT P.NOME FROM PESSOA P "
                + "INNER JOIN FORNECEDOR F ON P.CD_PESSOA = F.CD_PESSOA "
                + "INNER JOIN VENDA_COMPRA SUB ON SUB.CD_FORNECEDOR = F.CD_PESSOA "
                + "WHERE SUB.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA) END AS NOME , "
                + "F.CD_FORMA, "
                + "TO_CHAR(VC.DT_VENDA_COMPRA,'DD/MM/YYYY') AS DATA, "
                + "VC.VL_TOTAL, "
                + "O.DS_OPERACAO "
                + "FROM VENDA_COMPRA VC "
                + "LEFT JOIN VENDA_ATENDIMENTO_MESA VA "
                + "ON VC.CD_VENDA_COMPRA = VA.CD_VENDA "
                + "INNER JOIN OPERACAO O ON VC.CD_OPERACAO = O.CD_OPERACAO "
                + "INNER JOIN FORMA_PGTO F ON F.CD_FORMA = VC.CD_FORMA "
                + "INNER JOIN PESSOA P ON P.CD_PESSOA = VC.CD_FORNECEDOR OR "
                + "P.CD_PESSOA = VC.CD_CLIENTE "
                + "ORDER BY VC.CD_VENDA_COMPRA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdVendaCompra(VendaCompra vc) {
        String sql = "SELECT VC.CD_VENDA_COMPRA, VA.NR_ATENDIMENTO, P.CD_PESSOA, "
                + "CASE WHEN VC.CD_FORNECEDOR IS NULL THEN "
                + "(SELECT P.NOME FROM PESSOA P "
                + "INNER JOIN CLIENTE C ON P.CD_PESSOA = C.CD_PESSOA "
                + "INNER JOIN VENDA_COMPRA V ON V.CD_CLIENTE = C.CD_PESSOA "
                + "WHERE V.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA) "
                + "ELSE "
                + "(SELECT P.NOME FROM PESSOA P "
                + "INNER JOIN FORNECEDOR F ON P.CD_PESSOA = F.CD_PESSOA "
                + "INNER JOIN VENDA_COMPRA SUB ON SUB.CD_FORNECEDOR = F.CD_PESSOA "
                + "WHERE SUB.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA) END AS NOME , "
                + "F.CD_FORMA, "
                + "TO_CHAR(VC.DT_VENDA_COMPRA,'DD/MM/YYYY') AS DATA, "
                + "VC.VL_TOTAL, "
                + "O.DS_OPERACAO "
                + "FROM VENDA_COMPRA VC "
                + "LEFT JOIN VENDA_ATENDIMENTO_MESA VA "
                + "ON VC.CD_VENDA_COMPRA = VA.CD_VENDA "
                + "INNER JOIN OPERACAO O ON VC.CD_OPERACAO = O.CD_OPERACAO "
                + "INNER JOIN FORMA_PGTO F ON F.CD_FORMA = VC.CD_FORMA "
                + "INNER JOIN PESSOA P ON P.CD_PESSOA = VC.CD_FORNECEDOR OR "
                + "P.CD_PESSOA = VC.CD_CLIENTE "
                + "WHERE VC.CD_VENDA_COMPRA = " + vc.getCdVendaCompra();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCliente(VendaCompra vc) {
        String sql = "SELECT VC.CD_VENDA_COMPRA, VA.NR_ATENDIMENTO, VC.CD_CLIENTE, P.NOME, "
                + "F.CD_FORMA, "
                + "TO_CHAR(VC.DT_VENDA_COMPRA,'DD/MM/YYYY'), "
                + "VC.VL_TOTAL, "
                + "O.DS_OPERACAO "
                + "FROM VENDA_COMPRA VC "
                + "LEFT JOIN VENDA_ATENDIMENTO_MESA VA "
                + "ON VC.CD_VENDA_COMPRA = VA.CD_VENDA "
                + "INNER JOIN CLIENTE C ON VC.CD_CLIENTE = C.CD_PESSOA "
                + "INNER JOIN PESSOA P ON C.CD_PESSOA = P.CD_PESSOA "
                + "INNER JOIN OPERACAO O ON VC.CD_OPERACAO = O.CD_OPERACAO "
                + "INNER JOIN FORMA_PGTO F ON VC.CD_FORMA = F.CD_FORMA "
                + "WHERE P.NOME LIKE '%" + vc.getCliente().getPessoa().getNome() + "%' "
                + "ORDER BY VC.CD_VENDA_COMPRA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarFornecedor(VendaCompra vc) {
        String sql = "SELECT VC.CD_VENDA_COMPRA, 'SEM ATENDIMENTO' , VC.CD_FORNECEDOR, P.NOME, "
                + "F.CD_FORMA, "
                + "TO_CHAR(VC.DT_VENDA_COMPRA,'DD/MM/YYYY'),"
                + "VC.VL_TOTAL, "
                + "O.DS_OPERACAO "
                + "FROM VENDA_COMPRA VC "
                + "INNER JOIN FORNECEDOR FN ON VC.CD_FORNECEDOR = FN.CD_PESSOA "
                + "INNER JOIN PESSOA P ON FN.CD_PESSOA = P.CD_PESSOA "
                + "INNER JOIN OPERACAO O ON VC.CD_OPERACAO = O.CD_OPERACAO "
                + "INNER JOIN FORMA_PGTO F ON VC.CD_FORMA = F.CD_FORMA "
                + "WHERE P.NOME LIKE '%" + vc.getFornecedor().getPessoa().getNome() + "%' "
                + "ORDER BY VC.CD_VENDA_COMPRA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarPorTipo(VendaCompra vc) {
        String sql = "SELECT VC.CD_VENDA_COMPRA, VA.NR_ATENDIMENTO, P.CD_PESSOA, "
                + "CASE WHEN VC.CD_FORNECEDOR IS NULL THEN "
                + "(SELECT P.NOME FROM PESSOA P "
                + "INNER JOIN CLIENTE C ON P.CD_PESSOA = C.CD_PESSOA "
                + "INNER JOIN VENDA_COMPRA V ON V.CD_CLIENTE = C.CD_PESSOA "
                + "WHERE V.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA) "
                + "ELSE "
                + "(SELECT P.NOME FROM PESSOA P "
                + "INNER JOIN FORNECEDOR F ON P.CD_PESSOA = F.CD_PESSOA "
                + "INNER JOIN VENDA_COMPRA SUB ON SUB.CD_FORNECEDOR = F.CD_PESSOA "
                + "WHERE SUB.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA) END AS NOME , "
                + "F.CD_FORMA, "
                + "TO_CHAR(VC.DT_VENDA_COMPRA,'DD/MM/YYYY') AS DATA, "
                + "VC.VL_TOTAL, "
                + "O.DS_OPERACAO "
                + "FROM VENDA_COMPRA VC "
                + "LEFT JOIN VENDA_ATENDIMENTO_MESA VA "
                + "ON VC.CD_VENDA_COMPRA = VA.CD_VENDA "
                + "INNER JOIN OPERACAO O ON VC.CD_OPERACAO = O.CD_OPERACAO "
                + "INNER JOIN FORMA_PGTO F ON F.CD_FORMA = VC.CD_FORMA "
                + "INNER JOIN PESSOA P ON P.CD_PESSOA = VC.CD_FORNECEDOR OR "
                + "P.CD_PESSOA = VC.CD_CLIENTE "
                + "WHERE O.DS_OPERACAO = '" + vc.getOperacao().getDsOperacao() + "' "
                + "ORDER BY VC.CD_VENDA_COMPRA";
        conexao.executeSQL(sql);
        return conexao.resultset;
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

    public void retornaVendaCompra(VendaCompra vc) {
        ResultSet retorno = consultarCdVendaCompra(vc);
        try {
            retorno.first();
            vc.setDtVenda(retorno.getString("DATA"));
            vc.setVlTotal(retorno.getDouble("VL_TOTAL"));
            vc.getCliente().getPessoa().setCdPessoa(retorno.getInt("CD_PESSOA"));
            vc.getCliente().getPessoa().setNome(retorno.getString("NOME"));
            vc.getOperacao().setDsOperacao(retorno.getString("DS_OPERACAO"));
            vc.getForma().setCdForma(retorno.getInt("CD_FORMA"));
            try {
                vc.getVendaAtendimento().getAtendimento().setNrAtendimento(retorno.getInt("NR_ATENDIMENTO"));
            } catch (SQLException ex) {
                vc.getVendaAtendimento().getAtendimento().setNrAtendimento(0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Venda/Compra não encontrada!");
            vc.setCdVendaCompra(0);
        }
    }
    
    public boolean permiteExclusao(VendaCompra vc){
        boolean permitido = true;
        Contas contas = new Contas();
        contas.setVendaCompra(vc);
        ResultSet retorno = contas.consultarCdVendaCompra(contas);
        try{
            retorno.first();
            contas.setCdConta(retorno.getInt("CD_CONTA"));
            permitido = contas.permiteExclusao(contas);
        }
        catch(SQLException ex){
            
        }
        return permitido;
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

    public VendaCompraProdutos getVcProdutos() {
        return vcProdutos;
    }

    public void setVcProdutos(VendaCompraProdutos vcProdutos) {
        this.vcProdutos = vcProdutos;
    }
}
