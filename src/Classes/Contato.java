package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Contato {

    private Integer cdPessoa;
    private Integer nrSeq;
    private String nomeContato;
    private String email;
    private String foneRes;
    private String foneCom;
    private String foneCel;

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Contato contato) {
        RetornaSequencia seq = new RetornaSequencia();    
        contato.setNrSeq(seq.retornaSequencia("NR_SEQ", "CONTATO", "CD_PESSOA", contato.getCdPessoa()));
        String sql = "INSERT INTO CONTATO(CD_PESSOA, NR_SEQ, NOME_CONTATO, EMAIL_CONTATO, "
                + "FONE_RES, FONE_COM, FONE_CEL) VALUES ('" + contato.getCdPessoa() + "','"
                + contato.getNrSeq() + "','" + contato.getNomeContato() + "','" + contato.getEmail() + "','"
                + contato.getFoneRes() + "','" + contato.getFoneCom() + "','" + contato.getFoneCel() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Contato gravado com sucesso!");
        }
    }

    public void alterar(Contato contato) {
        String sql = "UPDATE CONTATO SET NOME_CONTATO = '" + contato.getNomeContato() + "', "
                + "EMAIL_CONTATO = '" + contato.getEmail() + "', FONE_RES = '" + contato.getFoneRes() + "', "
                + "FONE_COM = '" + contato.getFoneCom() + "', FONE_CEL = '" + contato.getFoneCel() + "' "
                + "WHERE CD_PESSOA = " + contato.getCdPessoa() + " AND NR_SEQ = " + contato.getNrSeq();
        conexao.atualizarSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Contato alterado com sucesso!");
        }
    }

    public void excluir(Contato contato) {
        String sql = "DELETE FROM CONTATO WHERE CD_PESSOA = " + contato.getCdPessoa()
                + " AND NR_SEQ = " + contato.getNrSeq();
        conexao.deleteSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Contato excluído com sucesso!");
        }
    }

    public void excluirTodos(Contato contato) {
        String sql = "DELETE FROM CONTATO WHERE CD_PESSOA = " + contato.getCdPessoa();
        conexao.deleteSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Contatos excluídos com sucesso!");
        }
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT C.CD_PESSOA, P.NOME, C.NR_SEQ, C.NOME_CONTATO, C.EMAIL_CONTATO, "
                + " C.FONE_RES , C.FONE_COM , C.FONE_CEL "
                + " FROM PESSOA P INNER JOIN CONTATO C ON P.CD_PESSOA = C.CD_PESSOA "
                + " ORDER BY C.CD_PESSOA, C.NR_SEQ";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdContato(Contato contato) {
        String sql = "SELECT C.CD_PESSOA, P.NOME, C.NR_SEQ, C.NOME_CONTATO, C.EMAIL_CONTATO, "
                + " C.FONE_RES , C.FONE_COM , C.FONE_CEL "
                + " FROM PESSOA P INNER JOIN CONTATO C ON P.CD_PESSOA = C.CD_PESSOA "
                + " WHERE C.CD_PESSOA = " + contato.getCdPessoa();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNome(Pessoa pessoa) {
        String sql = "SELECT C.CD_PESSOA, P.NOME, C.NR_SEQ, C.NOME_CONTATO, C.EMAIL_CONTATO, "
                + " C.FONE_RES , C.FONE_COM , C.FONE_CEL "
                + " FROM PESSOA P INNER JOIN CONTATO C ON P.CD_PESSOA = C.CD_PESSOA "
                + " WHERE P.NOME LIKE '%" + pessoa.getNome() + "%' "
                + " ORDER BY C.CD_PESSOA, C.NR_SEQ";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaContato(Contato contato) {
        String sql = "SELECT P.CD_PESSOA, P.NOME, C.NR_SEQ, C.NOME_CONTATO, C.EMAIL_CONTATO, "
                + "C.FONE_RES, C.FONE_COM, C.FONE_CEL FROM CONTATO C INNER JOIN PESSOA P "
                + "ON P.CD_PESSOA = C.CD_PESSOA WHERE P.CD_PESSOA = " + contato.getCdPessoa()
                + "AND C.NR_SEQ =  " + contato.getNrSeq();
        conexao.executeSQL(sql);
        ResultSet retorno = conexao.resultset;
        try {
            retorno.first();
            contato.setNomeContato(retorno.getString("NOME_CONTATO"));
            contato.setEmail(retorno.getString("EMAIL_CONTATO"));
            contato.setFoneRes(retorno.getString("FONE_RES"));
            contato.setFoneCom(retorno.getString("FONE_COM"));
            contato.setFoneCel(retorno.getString("FONE_CEL"));
        } catch (SQLException ex) {
            contato.setNomeContato("");
        }

    }

    //getter e setter
    public Integer getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Integer cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public Integer getNrSeq() {
        return nrSeq;
    }

    public void setNrSeq(Integer nrSeq) {
        this.nrSeq = nrSeq;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneRes() {
        return foneRes;
    }

    public void setFoneRes(String foneRes) {
        this.foneRes = foneRes;
    }

    public String getFoneCom() {
        return foneCom;
    }

    public void setFoneCom(String foneCom) {
        this.foneCom = foneCom;
    }

    public String getFoneCel() {
        return foneCel;
    }

    public void setFoneCel(String foneCel) {
        this.foneCel = foneCel;
    }

}
