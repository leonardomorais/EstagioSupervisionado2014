package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Fornecedor {

    private static Integer cdFornecedor;
    private String dtCadastro;
    private String inAtivo;

    private Pessoa pessoa = new Pessoa();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Fornecedor fornecedor) {
        fornecedor.getPessoa().incluir(fornecedor.getPessoa());
        fornecedor.setCdFornecedor(fornecedor.getPessoa().getCdPessoa());

        String sql = "INSERT INTO FORNECEDOR (CD_PESSOA, DT_CADASTRO, SITUACAO) "
                + "VALUES ('" + fornecedor.getCdFornecedor() + "','" + fornecedor.getDtCadastro() + "','"
                + fornecedor.getInAtivo() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(Fornecedor fornecedor) {
        fornecedor.getPessoa().setCdPessoa(fornecedor.getCdFornecedor());
        fornecedor.getPessoa().getEndereco().setNrSequencia(1);
        fornecedor.getPessoa().getContato().setNrSeq(1);

        fornecedor.getPessoa().alterar(fornecedor.getPessoa());

        String sql = "UPDATE FORNECEDOR SET DT_CADASTRO = '" + fornecedor.getDtCadastro() + "', "
                + "SITUACAO = '" + fornecedor.getInAtivo() + "' WHERE CD_PESSOA = " + fornecedor.getCdFornecedor();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Fornecedor fornecedor) {
        String sql = "UPDATE FORNECEDOR SET SITUACAO = 'I' WHERE CD_PESSOA = " + fornecedor.getCdFornecedor();
        conexao.deleteSQL(sql);
    }

    public void retornaFornecedor(Fornecedor fornecedor) {
        fornecedor.getPessoa().setCdPessoa(fornecedor.getCdFornecedor());
        ResultSet retorno = null;
        String sql = "SELECT F.CD_PESSOA, P.NOME, TO_CHAR(F.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                + "CASE WHEN F.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO, "
                + "P.TP_PESSOA FROM PESSOA P "
                + "INNER JOIN FORNECEDOR F ON F.CD_PESSOA = P.CD_PESSOA WHERE F.CD_PESSOA = "
                + fornecedor.getCdFornecedor();
        conexao.executeSQL(sql);
        retorno = conexao.resultset;

        try {
            retorno.first();
            fornecedor.getPessoa().setNome(retorno.getString("NOME"));
            fornecedor.setDtCadastro(retorno.getString("DATA"));
            fornecedor.setInAtivo(retorno.getString("SITUACAO"));
            fornecedor.getPessoa().setTpPessoa(retorno.getString("TP_PESSOA"));

            fornecedor.getPessoa().getEndereco().setNrSequencia(1);
            fornecedor.getPessoa().getContato().setNrSeq(1);

            if (fornecedor.getPessoa().getTpPessoa().equals("F")) {

                fornecedor.getPessoa().retornaPessoaFisica(fornecedor.getPessoa());
            } else {
                fornecedor.getPessoa().retornaPessoaJuridica(fornecedor.getPessoa());
            }
            fornecedor.getPessoa().retornaContato(fornecedor.getPessoa());
            fornecedor.getPessoa().retornaEndereco(fornecedor.getPessoa());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            fornecedor.getPessoa().setNome("");
        }
    }

    public ResultSet consultarGeral(boolean todos) {
        String sql;
        if (todos) {
            sql = "SELECT FN.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = FN.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = FN.CD_PESSOA) END AS CPF_CNPJ, "
                    + "CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                    + "TO_CHAR(FN.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN FN.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' "
                    + "END AS SITUACAO FROM FORNECEDOR FN "
                    + "INNER JOIN PESSOA P ON FN.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                    + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                    + "AND E.NR_SEQ = 1 "
                    + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                    + "AND CT.NR_SEQ = 1 ORDER BY FN.CD_PESSOA";
        } else {
            // consulta apenas dos fornecedores ativos para a tela de compra
            sql = "SELECT F.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = F.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = F.CD_PESSOA) END AS CPF_CNPJ, "
                    + "TO_CHAR(F.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM FORNECEDOR F INNER JOIN PESSOA P ON F.CD_PESSOA = "
                    + "P.CD_PESSOA WHERE F.SITUACAO = 'A' ORDER BY F.CD_PESSOA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdFornecedor(Fornecedor fornecedor, boolean todos) {
        String sql;
        if (todos) {
            sql = "SELECT FN.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = FN.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = FN.CD_PESSOA) END AS CPF_CNPJ, "
                    + "CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                    + "TO_CHAR(FN.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN FN.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' "
                    + "END AS SITUACAO FROM FORNECEDOR FN "
                    + "INNER JOIN PESSOA P ON FN.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                    + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                    + "AND E.NR_SEQ = 1 "
                    + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                    + "AND CT.NR_SEQ = 1 WHERE FN.CD_PESSOA = " + fornecedor.getCdFornecedor();
        } else {
            sql = "SELECT F.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = F.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = F.CD_PESSOA) END AS CPF_CNPJ, "
                    + "TO_CHAR(F.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM FORNECEDOR F INNER JOIN PESSOA P ON F.CD_PESSOA = "
                    + "P.CD_PESSOA WHERE F.SITUACAO = 'A' AND F.CD_PESSOA = "
                    + fornecedor.getCdFornecedor();
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNomeFornecedor(Fornecedor fornecedor, boolean todos) {
        String sql;
        if (todos) {
            sql = "SELECT FN.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = FN.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = FN.CD_PESSOA) END AS CPF_CNPJ, "
                    + "CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                    + "TO_CHAR(FN.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN FN.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' "
                    + "END AS SITUACAO FROM FORNECEDOR FN "
                    + "INNER JOIN PESSOA P ON FN.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                    + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                    + "AND E.NR_SEQ = 1 "
                    + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                    + "AND CT.NR_SEQ = 1 WHERE P.NOME LIKE '%" + fornecedor.getPessoa().getNome() + "%' "
                    + "ORDER BY FN.CD_PESSOA";
        } 
        else {
            sql = "SELECT F.CD_PESSOA, P.NOME, CASE WHEN P.TP_PESSOA = 'F' "
                    + "THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                    + "CASE WHEN P.TP_PESSOA = 'J' "
                    + "THEN "
                    + "(SELECT PJ.CNPJ FROM PESSOA_JURIDICA PJ "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PJ.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = F.CD_PESSOA) "
                    + "ELSE "
                    + "(SELECT PF.CPF FROM PESSOA_FISICA PF "
                    + "INNER JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.CD_PESSOA = F.CD_PESSOA) END AS CPF_CNPJ, "
                    + "TO_CHAR(F.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM FORNECEDOR F INNER JOIN PESSOA P ON F.CD_PESSOA = "
                    + "P.CD_PESSOA WHERE F.SITUACAO = 'A' AND P.NOME LIKE '%"
                    + fornecedor.getPessoa().getNome() + "%' ORDER BY F.CD_PESSOA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    // getter e setter
    public Integer getCdFornecedor() {
        return cdFornecedor;
    }

    public void setCdFornecedor(Integer cdFornecedor) {
        this.cdFornecedor = cdFornecedor;
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
