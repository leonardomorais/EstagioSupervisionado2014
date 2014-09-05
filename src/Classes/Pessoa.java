package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pessoa {

    private static Integer cdPessoa;
    private static String nome;
    private String dtCadastro;
    private String inAtivo;
    private String tpPessoa;

    private PessoaFisica pfisica = new PessoaFisica();
    private PessoaJuridica pjuridica = new PessoaJuridica();
    private Endereco endereco = new Endereco();
    private Contato contato = new Contato();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Pessoa pessoa) {
        RetornaSequencia seq = new RetornaSequencia();
        pessoa.setCdPessoa(seq.retornaSequencia("CD_PESSOA", "PESSOA"));
        String sql = "INSERT INTO PESSOA (CD_PESSOA, NOME, DT_CADASTRO, TP_PESSOA, SITUACAO)"
                + " VALUES ('" + pessoa.getCdPessoa() + "','" + pessoa.getNome() + "','" + pessoa.getDtCadastro() + "','"
                + pessoa.getTpPessoa() + "','" + pessoa.getInAtivo() + "')";
        conexao.incluirSQL(sql);

        if (pessoa.getTpPessoa().equals("F")) {
            incluirPessoaFisica(pessoa);
        } else {
            incluirPessoaJuridica(pessoa);
        }

        incluirEndereco(pessoa);
        incluirContato(pessoa);
    }

    public void alterar(Pessoa pessoa) {
        String sql = "UPDATE PESSOA SET NOME = '" + pessoa.getNome() + "', "
                + " DT_CADASTRO = '" + pessoa.getDtCadastro() + "', "
                + "SITUACAO = '" + pessoa.getInAtivo() + "' WHERE CD_PESSOA = '" + pessoa.getCdPessoa() + "'";
        conexao.atualizarSQL(sql);

        if (pessoa.getTpPessoa().equals("F")) {
            alterarPessoaFisica(pessoa);
        } else {
            alterarPessoaJuridica(pessoa);
        }

        alterarEndereco(pessoa);
        alterarContato(pessoa);
    }

    public void excluir(Pessoa pessoa) {
        if (pessoa.getTpPessoa().equals("F")) {
            pessoa.getPfisica().setCdPessoa(pessoa.getCdPessoa());
            pessoa.getPfisica().excluir(pessoa.getPfisica());
        } else {
            pessoa.getPjuridica().setCdPessoa(pessoa.getCdPessoa());
            pessoa.getPjuridica().excluir(pessoa.getPjuridica());
        }

        String sql = "UPDATE PESSOA SET SITUACAO = 'I' WHERE CD_PESSOA = " + pessoa.getCdPessoa();
        conexao.deleteSQL(sql);
    }

    public void alterarPessoaFisica(Pessoa pessoa) {
        getPfisica().setCdPessoa(pessoa.getCdPessoa());
        getPfisica().setDtCadastro(pessoa.getDtCadastro());
        getPfisica().alterar(getPfisica());
    }

    public void alterarPessoaJuridica(Pessoa pessoa) {
        getPjuridica().setCdPessoa(pessoa.getCdPessoa());
        getPjuridica().alterar(getPjuridica());
    }

    public void incluirEndereco(Pessoa pessoa) {
        getEndereco().setCdPessoa(pessoa.getCdPessoa());
        getEndereco().incluir(getEndereco());
    }

    public void alterarEndereco(Pessoa pessoa) {
        getEndereco().setCdPessoa(pessoa.getCdPessoa());
        getEndereco().alterar(getEndereco());
    }

    public void incluirContato(Pessoa pessoa) {
        getContato().setCdPessoa(pessoa.getCdPessoa());
        getContato().incluir(getContato());
    }

    public void alterarContato(Pessoa pessoa) {
        getContato().setCdPessoa(pessoa.getCdPessoa());
        getContato().alterar(getContato());
    }

    public void incluirPessoaFisica(Pessoa pessoa) {
        getPfisica().setCdPessoa(pessoa.getCdPessoa());
        getPfisica().setDtCadastro(pessoa.getDtCadastro());
        getPfisica().incluir(getPfisica());
    }

    public void incluirPessoaJuridica(Pessoa pessoa) {
        getPjuridica().setCdPessoa(pessoa.getCdPessoa());
        getPjuridica().incluir(getPjuridica());
    }

    public void retornaEndereco(Pessoa pessoa) {
        pessoa.getEndereco().setCdPessoa(pessoa.getCdPessoa());
        pessoa.getEndereco().retornaEndereco(pessoa.getEndereco());
    }

    public void retornaContato(Pessoa pessoa) {
        pessoa.getContato().setCdPessoa(pessoa.getCdPessoa());
        pessoa.getContato().retornaContato(pessoa.getContato());
    }

    public void retornaPessoaFisica(Pessoa pessoa) {
        pessoa.getPfisica().setCdPessoa(pessoa.getCdPessoa());
        pessoa.getPfisica().retornaPFisica(pessoa.getPfisica());
    }

    public void retornaPessoaJuridica(Pessoa pessoa) {
        pessoa.getPjuridica().setCdPessoa(pessoa.getCdPessoa());
        pessoa.getPjuridica().retornaPJuridica(pessoa.getPjuridica());
    }

    public void retornaPessoa(Pessoa pessoa) {
        ResultSet rs = null;
        String sql = "SELECT NOME, TO_CHAR(DT_CADASTRO,'DD/MM/YYYY') AS DATA, "
                + "TP_PESSOA, SITUACAO FROM PESSOA WHERE CD_PESSOA = " + pessoa.getCdPessoa();
        conexao.executeSQL(sql);
        rs = conexao.resultset;
        try {
            rs.first();
            pessoa.setNome(rs.getString("NOME"));
            pessoa.setTpPessoa("TP_PESSOA");
            pessoa.setDtCadastro("DATA");
            pessoa.setInAtivo("SITUACAO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
            pessoa.setNome("");
        }
    }

    public String retornaTipoPessoa(Pessoa pessoa) {
        String sql = "SELECT CASE WHEN P.CD_PESSOA IN (SELECT CD_PESSOA FROM FORNECEDOR) "
                + "THEN 'FORNECEDOR' WHEN P.CD_PESSOA IN (SELECT CD_PESSOA FROM CLIENTE) "
                + "THEN 'CLIENTE' ELSE 'FUNCIONÁRIO' END AS TIPO FROM PESSOA P "
                + "WHERE P.CD_PESSOA = " + pessoa.getCdPessoa();
        conexao.executeSQL(sql);
        String tipo;
        try{
            conexao.resultset.first();
            tipo = conexao.resultset.getString("TIPO");
        }
        catch(SQLException ex){
            tipo = "";
        }
        return tipo;
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT CD_PESSOA, NOME, TO_CHAR(DT_CADASTRO,'DD/MM/YYYY') AS DT_CADASTRO, "
                + "CASE WHEN TP_PESSOA = 'F' THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                + "CASE WHEN SITUACAO = 'A' THEN 'ATIVA' ELSE 'INATIVA' END AS SITUACAO, "
                + "CASE WHEN CD_PESSOA IN (SELECT CD_PESSOA FROM CLIENTE) THEN "
                + "'CLIENTE' "
                + "WHEN CD_PESSOA IN (SELECT CD_PESSOA FROM FORNECEDOR) THEN "
                + "'FORNECEDOR' "
                + "ELSE 'FUNCIONARIO' END AS ATOR FROM PESSOA ORDER BY CD_PESSOA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdPessoa(Pessoa pessoa) {
        String sql = "SELECT CD_PESSOA, NOME, TO_CHAR(DT_CADASTRO,'DD/MM/YYYY') AS DT_CADASTRO, "
                + "CASE WHEN TP_PESSOA = 'F' THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                + "CASE WHEN SITUACAO = 'A' THEN 'ATIVA' ELSE 'INATIVA' END AS SITUACAO, "
                + "CASE WHEN CD_PESSOA IN (SELECT CD_PESSOA FROM CLIENTE) THEN "
                + "'CLIENTE' "
                + "WHEN CD_PESSOA IN (SELECT CD_PESSOA FROM FORNECEDOR) THEN "
                + "'FORNECEDOR' "
                + "ELSE 'FUNCIONARIO' END AS ATOR FROM PESSOA "
                + "WHERE CD_PESSOA = " + pessoa.getCdPessoa();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNomePessoa(Pessoa pessoa) {
        String sql = "SELECT CD_PESSOA, NOME, TO_CHAR(DT_CADASTRO,'DD/MM/YYYY') AS DT_CADASTRO, "
                + "CASE WHEN TP_PESSOA = 'F' THEN 'FÍSICA' ELSE 'JURÍDICA' END AS TIPO, "
                + "CASE WHEN SITUACAO = 'A' THEN 'ATIVA' ELSE 'INATIVA' END AS SITUACAO, "
                + "CASE WHEN CD_PESSOA IN (SELECT CD_PESSOA FROM CLIENTE) THEN "
                + "'CLIENTE' "
                + "WHEN CD_PESSOA IN (SELECT CD_PESSOA FROM FORNECEDOR) THEN "
                + "'FORNECEDOR' "
                + "ELSE 'FUNCIONARIO' END AS ATOR FROM PESSOA "
                + "WHERE NOME LIKE '%" + pessoa.getNome() + "%' ORDER BY CD_PESSOA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    // getter e setter
    public Integer getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Integer cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTpPessoa() {
        return tpPessoa;
    }

    public void setTpPessoa(String tpPessoa) {
        this.tpPessoa = tpPessoa;
    }

    public PessoaFisica getPfisica() {
        return pfisica;
    }

    public void setPfisica(PessoaFisica pfisica) {
        this.pfisica = pfisica;
    }

    public PessoaJuridica getPjuridica() {
        return pjuridica;
    }

    public void setPjuridica(PessoaJuridica pjuridica) {
        this.pjuridica = pjuridica;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

}
