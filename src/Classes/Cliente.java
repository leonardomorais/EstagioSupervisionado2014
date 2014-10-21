package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cliente {

    private static Integer cdCliente;
    private String dtCadastro;
    private String inAtivo;

    private Pessoa pessoa = new Pessoa();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Cliente cliente) {
        cliente.getPessoa().incluir(cliente.getPessoa());
        cliente.setCdCliente(cliente.getPessoa().getCdPessoa());

        String sql = "INSERT INTO CLIENTE (CD_PESSOA, DT_CADASTRO, SITUACAO) "
                + "VALUES ('" + cliente.getCdCliente() + "','" + cliente.getDtCadastro() + "','"
                + cliente.getInAtivo() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Cliente gravado com sucesso!");
        }
    }

    public void alterar(Cliente cliente) {
        cliente.getPessoa().setCdPessoa(cliente.getCdCliente());
        cliente.getPessoa().alterar(cliente.getPessoa());

        String sql = "UPDATE CLIENTE SET DT_CADASTRO = '" + cliente.getDtCadastro() + "', "
                + "SITUACAO = '" + cliente.getInAtivo() + "' "
                + "WHERE CD_PESSOA = " + cliente.getCdCliente();
        conexao.atualizarSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
        }
    }

    public void excluir(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET SITUACAO = 'I' WHERE CD_PESSOA = '" + cliente.getCdCliente() + "'";
        conexao.deleteSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Cliente inativado com sucesso!");
        }
    }

    public void retornaCliente(Cliente cliente) {
        cliente.getPessoa().setCdPessoa(cliente.getCdCliente());
        ResultSet retorno = null;
        String sql = "SELECT C.CD_PESSOA, P.NOME, TO_CHAR(C.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN C.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO, "
                + "P.TP_PESSOA FROM PESSOA P "
                + "INNER JOIN CLIENTE C ON C.CD_PESSOA = P.CD_PESSOA WHERE C.CD_PESSOA = "
                + cliente.getCdCliente();
        conexao.executeSQL(sql);
        retorno = conexao.resultset;

        try {
            retorno.first();
            cliente.getPessoa().setNome(retorno.getString("NOME"));
            cliente.setDtCadastro(retorno.getString("DATA"));
            cliente.setInAtivo(retorno.getString("SITUACAO"));
            cliente.getPessoa().setTpPessoa(retorno.getString("TP_PESSOA"));
            cliente.getPessoa().getEndereco().setNrSequencia(1);
            cliente.getPessoa().getContato().setNrSeq(1);

            if (cliente.getPessoa().getTpPessoa().equals("F")) {

                cliente.getPessoa().retornaPessoaFisica(cliente.getPessoa());
            } else {
                cliente.getPessoa().retornaPessoaJuridica(cliente.getPessoa());
            }
            cliente.getPessoa().retornaContato(cliente.getPessoa());
            cliente.getPessoa().retornaEndereco(cliente.getPessoa());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            cliente.getPessoa().setNome("");
        }
    }

    public ResultSet consultarGeral(boolean todos) {
        String sql;
        if (todos) {
            sql = "SELECT C.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) END AS CPF_CNPJ, "
                    + "CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                    + "TO_CHAR(C.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN C.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' "
                    + "END AS SITUACAO FROM CLIENTE C "
                    + "INNER JOIN PESSOA P ON C.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                    + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                    + "AND E.NR_SEQ = 1 "
                    + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                    + "AND CT.NR_SEQ = 1 ORDER BY C.CD_PESSOA";
        } else {
            // esta consulta retorna os apenas os clientes ativos para a venda
            sql = "SELECT C.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) END AS CPF_CNPJ, "
                    + "TO_CHAR(C.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM CLIENTE C INNER JOIN PESSOA P ON C.CD_PESSOA = "
                    + "P.CD_PESSOA WHERE C.SITUACAO = 'A' ORDER BY C.CD_PESSOA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdCliente(Cliente cliente, boolean todos) {
        String sql;
        
        if (todos){
           sql =  "SELECT C.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                + "CASE WHEN P.TP_PESSOA = 'J' "
                + "THEN "
                + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                + "WHERE P.CD_PESSOA = C.CD_PESSOA) "
                + "ELSE "
                + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                + "WHERE P.CD_PESSOA = C.CD_PESSOA) END AS CPF_CNPJ, "
                + "CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                + "TO_CHAR(C.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN C.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' "
                + "END AS SITUACAO FROM CLIENTE C "
                + "INNER JOIN PESSOA P ON C.CD_PESSOA = P.CD_PESSOA "
                + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                + "AND E.NR_SEQ = 1 "
                + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                + "AND CT.NR_SEQ = 1 WHERE C.CD_PESSOA = " + cliente.getCdCliente() + " "
                + "ORDER BY C.CD_PESSOA";
        }
        else{
            sql = "SELECT C.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) END AS CPF_CNPJ, "
                    + "TO_CHAR(C.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM CLIENTE C INNER JOIN PESSOA P ON C.CD_PESSOA = "
                    + "P.CD_PESSOA WHERE C.SITUACAO = 'A' AND C.CD_PESSOA = "
                    + cliente.getCdCliente();
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNomeCliente(Cliente cliente, boolean todos) {
        String sql;
        if (todos){
           sql = "SELECT C.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                + "CASE WHEN P.TP_PESSOA = 'J' "
                + "THEN "
                + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                + "WHERE P.CD_PESSOA = C.CD_PESSOA) "
                + "ELSE "
                + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                + "WHERE P.CD_PESSOA = C.CD_PESSOA) END AS CPF_CNPJ, "
                + "CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                + "TO_CHAR(C.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN C.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' "
                + "END AS SITUACAO FROM CLIENTE C "
                + "INNER JOIN PESSOA P ON C.CD_PESSOA = P.CD_PESSOA "
                + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                + "AND E.NR_SEQ = 1 "
                + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                + "AND CT.NR_SEQ = 1 WHERE P.NOME LIKE '%" + cliente.getPessoa().getNome() + "%' "
                + "ORDER BY C.CD_PESSOA";
        }
        else{
            sql = "SELECT C.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = C.CD_PESSOA) END AS CPF_CNPJ, "
                    + "TO_CHAR(C.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM CLIENTE C INNER JOIN PESSOA P ON C.CD_PESSOA = "
                    + "P.CD_PESSOA WHERE C.SITUACAO = 'A' ORDER BY C.CD_PESSOA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public boolean parcelasAPagar(Cliente cliente){
        
        String sql = "SELECT P.CD_CONTA, P.NR_PARCELA, P.VL_PARCELA, "
                + "TO_CHAR(P.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "P.VL_PAGO, TO_CHAR(P.DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO "
                + "FROM PARCELAS P INNER JOIN CONTAS_PAGAR_RECEBER C "
                + "ON P.CD_CONTA = C.CD_CONTA AND P.SITUACAO = 'A' AND P.DT_PAGO IS NULL "
                + "INNER JOIN VENDA_COMPRA VC "
                + "ON C.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA "
                + "AND VC.CD_CLIENTE = " + cliente.getCdCliente();
        conexao.executeSQL(sql);
        
        try{
            conexao.resultset.first();
            int cd = conexao.resultset.getInt("CD_CONTA");
            return true;
        }
        catch(SQLException ex){
            return false;    
        }
    }

// getter e setter
    public Integer getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(Integer cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
