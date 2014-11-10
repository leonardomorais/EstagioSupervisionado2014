package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Funcionario {

    private static Integer cdFuncionario;

    private Pessoa pessoa = new Pessoa();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Funcionario funcionario) {
        funcionario.getPessoa().setTpPessoa("F");
        funcionario.getPessoa().incluir(funcionario.getPessoa());
        funcionario.setCdFuncionario(funcionario.getPessoa().getCdPessoa());

        String sql = "INSERT INTO FUNCIONARIO VALUES ('" + funcionario.getCdFuncionario() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Funcionário gravado com sucesso!");
        }
    }

    public void alterar(Funcionario funcionario) {
        funcionario.getPessoa().setCdPessoa(funcionario.getCdFuncionario());
        funcionario.getPessoa().setTpPessoa("F");
        funcionario.getPessoa().alterar(funcionario.getPessoa());
    }

    public void excluir(Funcionario funcionario) {
        funcionario.getPessoa().setCdPessoa(funcionario.getCdFuncionario());
        funcionario.getPessoa().setTpPessoa("F");
        funcionario.getPessoa().excluir(funcionario.getPessoa());

    }

    public ResultSet consultarGeral(boolean todos) {
        String sql = "";
        if (todos) {

            sql = " SELECT F.CD_PESSOA, P.NOME, PF.CPF, CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                    + "TO_CHAR (P.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN P.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                    + "FROM FUNCIONARIO F "
                    + "INNER JOIN PESSOA P ON F.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN PESSOA_FISICA PF ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                    + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                    + "AND E.NR_SEQ = 1 "
                    + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                    + "AND CT.NR_SEQ = 1 ORDER BY F.CD_PESSOA";
        } else {
            sql = "SELECT F.CD_PESSOA, P.NOME, PF.CPF, "
                    + "TO_CHAR (P.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM FUNCIONARIO F "
                    + "INNER JOIN PESSOA P ON F.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN PESSOA_FISICA PF ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.SITUACAO = 'A' ORDER BY F.CD_PESSOA";
        }

        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdFuncionario(Funcionario funcionario, boolean todos) {
        String sql;

        if (todos) {
            sql = "SELECT F.CD_PESSOA, P.NOME, PF.CPF, CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                    + "TO_CHAR (P.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN P.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                    + "FROM FUNCIONARIO F "
                    + "INNER JOIN PESSOA P ON F.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN PESSOA_FISICA PF ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                    + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                    + "AND E.NR_SEQ = 1 "
                    + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                    + "AND CT.NR_SEQ = 1  WHERE F.CD_PESSOA =  " + funcionario.getCdFuncionario();
        } else {
            sql = "SELECT F.CD_PESSOA, P.NOME, PF.CPF, "
                    + "TO_CHAR (P.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM FUNCIONARIO F "
                    + "INNER JOIN PESSOA P ON F.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN PESSOA_FISICA PF ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.SITUACAO = 'A' AND F.CD_PESSOA = " + funcionario.getCdFuncionario();
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNomeFuncionario(Funcionario funcionario, boolean todos) {
        String sql = "";

        if (todos) {
            sql = "SELECT F.CD_PESSOA, P.NOME, PF.CPF, CD.DS_CIDADE, CT.EMAIL_CONTATO, "
                    + "TO_CHAR (P.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN P.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO "
                    + "FROM FUNCIONARIO F "
                    + "INNER JOIN PESSOA P ON F.CD_PESSOA = P.CD_PESSOA "
                    + "INNER JOIN PESSOA_FISICA PF ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA "
                    + "INNER JOIN CIDADE CD ON E.CD_CIDADE = CD.CD_CIDADE "
                    + "AND E.NR_SEQ = 1 "
                    + "INNER JOIN CONTATO CT ON P.CD_PESSOA = CT.CD_PESSOA "
                    + "AND CT.NR_SEQ = 1  WHERE P.NOME LIKE '%" + funcionario.getPessoa().getNome() + "%' "
                    + "ORDER BY F.CD_PESSOA";
        } else {
            sql = "SELECT F.CD_PESSOA, P.NOME, PF.CPF, "
                    + "TO_CHAR (P.DT_CADASTRO,'DD/MM/YYYY') AS DATA "
                    + "FROM FUNCIONARIO F "
                    + "INNER JOIN PESSOA P ON F.CD_PESSOA = P.CD_PESSOA"
                    + "INNER JOIN PESSOA_FISICA PF ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.SITUACAO = 'A' AND P.NOME LIKE '%" + funcionario.getPessoa().getNome() + "%' "
                    + "ORDER BY F.CD_PESSOA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaFuncionario(Funcionario funcionario, boolean todos) {
        funcionario.getPessoa().setCdPessoa(funcionario.getCdFuncionario());
        ResultSet retorno = null;

        String sql = "";
        if (todos) {
            sql = "SELECT F.CD_PESSOA, P.NOME, TO_CHAR(P.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN P.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO FROM "
                    + "PESSOA P INNER JOIN FUNCIONARIO F ON P.CD_PESSOA = F.CD_PESSOA "
                    + "WHERE F.CD_PESSOA = " + funcionario.getCdFuncionario();

        } else {
            sql = "SELECT F.CD_PESSOA, P.NOME, TO_CHAR(P.DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN P.SITUACAO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SITUACAO FROM "
                    + "PESSOA P INNER JOIN FUNCIONARIO F ON P.CD_PESSOA = F.CD_PESSOA "
                    + "WHERE F.CD_PESSOA = " + funcionario.getCdFuncionario() + " AND P.SITUACAO = 'A'";

        }

        conexao.executeSQL(sql);
        retorno = conexao.resultset;

        try {
            retorno.first();
            funcionario.getPessoa().setNome(retorno.getString("NOME"));
            funcionario.getPessoa().setDtCadastro(retorno.getString("DATA"));
            funcionario.getPessoa().setInAtivo(retorno.getString("SITUACAO"));

            funcionario.getPessoa().getContato().setNrSeq(1);
            funcionario.getPessoa().getEndereco().setNrSequencia(1);

            funcionario.getPessoa().retornaPessoaFisica(funcionario.getPessoa());

            funcionario.getPessoa().retornaContato(funcionario.getPessoa());
            funcionario.getPessoa().retornaEndereco(funcionario.getPessoa());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
            funcionario.getPessoa().setNome("");
        }

    }

    // getter e setter
    public Integer getCdFuncionario() {
        return cdFuncionario;
    }

    public void setCdFuncionario(Integer cd_funcionario) {
        this.cdFuncionario = cd_funcionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
