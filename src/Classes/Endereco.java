package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Endereco {

    private Integer cdPessoa;
    private Integer nrSequencia;
    private String ruaAv;
    private String nrEndereco;
    private String bairro;
    private String CEP;
    private String complemento;

    private Cidade cidade = new Cidade();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Endereco endereco) {
        RetornaSequencia seq = new RetornaSequencia();
        endereco.setNrSequencia(seq.retornaSequencia("NR_SEQ", "ENDERECO", "CD_PESSOA", endereco.getCdPessoa()));
        String sql = "INSERT INTO ENDERECO(CD_PESSOA, NR_SEQ, CD_CIDADE, RUA_AV, NR_ENDERECO, BAIRRO, "
                + "CEP, COMPLEMENTO) VALUES ('" + endereco.getCdPessoa() + "','" + endereco.getNrSequencia() + "','"
                + endereco.getCidade().getVetCidades(endereco.getCidade().getCdCidade()) + "','"
                + endereco.getRuaAv() + "','" + endereco.getNrEndereco() + "','" + endereco.getBairro() + "','"
                + endereco.getCEP() + "','" + endereco.getComplemento() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(Endereco endereco) {
        String sql = "UPDATE ENDERECO SET CD_CIDADE = '"
                + endereco.getCidade().getVetCidades(endereco.getCidade().getCdCidade()) + "', "
                + "RUA_AV = '" + endereco.getRuaAv() + "', NR_ENDERECO = '" + endereco.getNrEndereco() + "', "
                + "BAIRRO = '" + endereco.getBairro() + "', CEP = '" + endereco.getCEP() + "', COMPLEMENTO = '"
                + endereco.getComplemento() + "' "
                + "WHERE CD_PESSOA = " + endereco.getCdPessoa() + " AND NR_SEQ = " + endereco.getNrSequencia();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Endereco endereco) {
        String sql = "DELETE FROM ENDERECO WHERE CD_PESSOA = " + endereco.getCdPessoa() + " "
                + "AND NR_SEQ = " + endereco.getNrSequencia();
        conexao.deleteSQL(sql);
    }

    public void excluirTodos(Endereco endereco) {
        String sql = "DELETE FROM ENDERECO WHERE CD_PESSOA = " + endereco.getCdPessoa();
        conexao.deleteSQL(sql);
    }

    public void retornaEndereco(Endereco endereco) {
        String sql = "SELECT P.CD_PESSOA, P.NOME, E.NR_SEQ, E.CD_CIDADE, E.RUA_AV, E.NR_ENDERECO, "
                + "E.BAIRRO, E.CEP, E.COMPLEMENTO FROM ENDERECO E INNER JOIN PESSOA P ON "
                + "P.CD_PESSOA = E.CD_PESSOA WHERE P.CD_PESSOA = " + endereco.getCdPessoa() + " AND E.NR_SEQ = "
                + endereco.getNrSequencia();
        conexao.executeSQL(sql);
        ResultSet retorno = conexao.resultset;
        try {
            retorno.first();
            endereco.setRuaAv(retorno.getString("RUA_AV"));
            endereco.setNrEndereco(retorno.getString("NR_ENDERECO"));
            endereco.setBairro(retorno.getString("BAIRRO"));
            endereco.setCEP(retorno.getString("CEP"));
            endereco.setComplemento(retorno.getString("COMPLEMENTO"));

            endereco.getCidade().setCdCidade(retorno.getInt("CD_CIDADE"));
            endereco.getCidade().retornaCidade(endereco.getCidade());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Endereço não encontrado!");
            endereco.setRuaAv("00");
        }

    }

    public ResultSet consultarGeral() {
        String sql = "SELECT E.CD_PESSOA, E.NR_SEQ, P.NOME, C.DS_CIDADE, E.RUA_AV, "
                + "E.NR_ENDERECO, E.BAIRRO, "
                + "CASE WHEN E.CEP = '     -   ' THEN '' "
                + "ELSE E.CEP END AS CEP, "
                + "E. COMPLEMENTO FROM PESSOA P "
                + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA INNER JOIN "
                + "CIDADE C ON E.CD_CIDADE = C.CD_CIDADE ORDER BY E.CD_PESSOA, E.NR_SEQ";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCodigo(Endereco endereco) {
        String sql = "SELECT E.CD_PESSOA, E.NR_SEQ, P.NOME, C.DS_CIDADE, E.RUA_AV, "
                + "E.NR_ENDERECO, E.BAIRRO, "
                + "CASE WHEN E.CEP = '     -   ' THEN '' "
                + "ELSE E.CEP END AS CEP, "
                + "E. COMPLEMENTO FROM PESSOA P "
                + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA INNER JOIN "
                + "CIDADE C ON E.CD_CIDADE = C.CD_CIDADE "
                + "WHERE E.CD_PESSOA = " + endereco.getCdPessoa();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNome(Pessoa pessoa) {
        String sql = "SELECT E.CD_PESSOA, E.NR_SEQ, P.NOME, C.DS_CIDADE, E.RUA_AV, "
                + "E.NR_ENDERECO, E.BAIRRO, "
                + "CASE WHEN E.CEP = '     -   ' THEN '' "
                + "ELSE E.CEP END AS CEP, "
                + "E. COMPLEMENTO FROM PESSOA P "
                + "INNER JOIN ENDERECO E ON P.CD_PESSOA = E.CD_PESSOA INNER JOIN "
                + "CIDADE C ON E.CD_CIDADE = C.CD_CIDADE "
                + "WHERE P.NOME LIKE '%" + pessoa.getNome() + "%' "
                + "ORDER BY E.CD_PESSOA, E.NR_SEQ";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaComboCidade(JComboBox combo) {
        cidade.retornaComboCidades(combo);
    }

    // getter e setter
    public Integer getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Integer cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public Integer getNrSequencia() {
        return nrSequencia;
    }

    public void setNrSequencia(Integer nrSequencia) {
        this.nrSequencia = nrSequencia;
    }

    public String getRuaAv() {
        return ruaAv;
    }

    public void setRuaAv(String ruaAv) {
        this.ruaAv = ruaAv;
    }

    public String getNrEndereco() {
        return nrEndereco;
    }

    public void setNrEndereco(String nrEndereco) {
        this.nrEndereco = nrEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
