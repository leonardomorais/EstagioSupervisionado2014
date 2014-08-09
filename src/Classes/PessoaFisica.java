package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class PessoaFisica {

    private Integer cdPessoa;
    private String CPF;
    private String RG;
    private String sexo;
    private String dtCadastro;
   

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(PessoaFisica pfisica) {
        String sql = "INSERT INTO PESSOA_FISICA (CD_PESSOA, CPF, RG, SEXO, DT_CADASTRO) "
                + "VALUES ('" + pfisica.getCdPessoa() + "','" + pfisica.getCPF() + "','" + pfisica.getRG() + "','"
                + pfisica.getSexo() + "','" + pfisica.getDtCadastro() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(PessoaFisica pfisica) {
        String sql = "UPDATE PESSOA_FISICA SET CPF = '" + pfisica.getCPF() + "', RG = '"
                + pfisica.getRG() + "', SEXO = '" + pfisica.getSexo() + "', DT_CADASTRO = '"
                + pfisica.getDtCadastro() +"' "
                + "WHERE CD_PESSOA = " + pfisica.getCdPessoa();
        conexao.atualizarSQL(sql);
    }

    public void excluir(PessoaFisica pfisica) {
        String sql = "UPDATE PESSOA SET SITUACAO = 'I' WHERE CD_PESSOA = " + pfisica.getCdPessoa();
        conexao.deleteSQL(sql);
    }

    public void retornaPFisica(PessoaFisica pfisica) {
        String sql = "SELECT P.CD_PESSOA, P.NOME, PF.CPF, PF.RG, CASE WHEN PF.SEXO = 'M' "
                + "THEN 'MASCULINO' ELSE 'FEMININO' END AS SEXO, PF.DT_CADASTRO FROM "
                + "PESSOA P INNER JOIN PESSOA_FISICA PF ON P.CD_PESSOA = PF.CD_PESSOA "
                + "WHERE P.CD_PESSOA = " + pfisica.getCdPessoa();
        conexao.executeSQL(sql);
        ResultSet retorno = conexao.resultset;
        try {
            retorno.first();
            pfisica.setCPF(retorno.getString("CPF"));
            pfisica.setRG(retorno.getString("RG"));
            pfisica.setSexo(retorno.getString("SEXO"));
        } catch (SQLException ex) {
            pfisica.setCPF("");
        }
    }

    //getter e setter
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Integer cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public String getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
