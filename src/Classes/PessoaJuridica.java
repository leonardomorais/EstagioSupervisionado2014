package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class PessoaJuridica {

    private Integer cdPessoa;
    private String CNPJ;
    private String razao;
    private String dtCadastro;
    private String inAtivo;

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(PessoaJuridica pjuridica) {
        String sql = "INSERT INTO PESSOA_JURIDICA (CD_PESSOA, CNPJ, RAZAO_SOCIAL, DT_CADASTRO, SITUACAO) "
                + "VALUES ('" + pjuridica.getCdPessoa() + "','" + pjuridica.getCNPJ() + "','" + pjuridica.getRazao() + "',' "
                + pjuridica.getDtCadastro() + "','" + pjuridica.getInAtivo() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(PessoaJuridica pjuridica) {
        String sql = "UPDATE PESSOA_JURIDICA SET CNPJ = '" + pjuridica.getCNPJ() + "', RAZAO_SOCIAL = '"
                + pjuridica.getRazao() + "', DT_CADASTRO = '" + pjuridica.getDtCadastro() + "', SITUACAO = '"
                + pjuridica.getInAtivo() + "' WHERE CD_PESSOA = " + pjuridica.getCdPessoa();
        conexao.atualizarSQL(sql);
    }

    public void excluir(PessoaJuridica pjuridica) {
        String sql = "UPDATE PESSOA_JURIDICA SET SITUACAO = 'I' WHERE CD_PESSOA = " + pjuridica.getCdPessoa();
        conexao.deleteSQL(sql);
    }

    public void retornaPJuridica(PessoaJuridica pjuridica) {
        String sql = "SELECT P.CD_PESSOA, P.NOME, PJ.CNPJ, PJ.RAZAO_SOCIAL FROM PESSOA P "
                + "INNER JOIN PESSOA_JURIDICA PJ ON P.CD_PESSOA = PJ.CD_PESSOA "
                + "WHERE P.CD_PESSOA = " + pjuridica.getCdPessoa();
        conexao.executeSQL(sql);
        ResultSet retorno = conexao.resultset;
        try {
            retorno.first();
            pjuridica.setCNPJ(retorno.getString("CNPJ"));
            pjuridica.setRazao(retorno.getString("RAZAO_SOCIAL"));

        } catch (SQLException ex) {
            pjuridica.setCNPJ("");
        }
    }

    // getter e setter
    public Integer getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Integer cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
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

}
