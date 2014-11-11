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
public class Usuario {
    
    private Integer cdUsuario;
    private String login;
    private String senha;
    
    private Nivel nivel = new Nivel();
    private Funcionario funcionario = new Funcionario();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(Usuario usuario){
        RetornaSequencia seq = new RetornaSequencia();
        usuario.setCdUsuario(seq.retornaSequencia("CD_USUARIO", "USUARIO"));
        String sql = "INSERT INTO USUARIO (CD_USUARIO, CD_NIVEL, CD_PESSOA, "
                + "LOGIN, SENHA) VALUES ('"+usuario.getCdUsuario()+"','"
                +usuario.getNivel().getCdNivel()+"','"+usuario.getFuncionario().getCdFuncionario()+"','"
                +usuario.getLogin()+"','"+usuario.getSenha()+"')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Usuário gravado com sucesso!");
        }
    }
    
    public void alterar(Usuario usuario){
        String sql = "UPDATE USUARIO SET CD_NIVEL = '"+usuario.getNivel().getCdNivel()+"', "
                + "CD_PESSOA = '"+usuario.getFuncionario().getCdFuncionario()+"', "
                + "LOGIN = '"+usuario.getLogin()+"', SENHA = '"+usuario.getSenha()+"' "
                + "WHERE CD_USUARIO = "+usuario.getCdUsuario();
        conexao.atualizarSQL(sql);
    }
    
    public void excluir(Usuario usuario){
        String sql = "DELETE FROM USUARIO WHERE CD_USUARIO = "+usuario.getCdUsuario();
        conexao.deleteSQL(sql);
    }
    
    public ResultSet consultarGeral(){
        String sql = "SELECT U.CD_USUARIO, U.CD_PESSOA, P.NOME, U.CD_NIVEL, N.DS_NIVEL, U.LOGIN "
                + "FROM USUARIO U INNER JOIN NIVEL N "
                + "ON U.CD_NIVEL = N.CD_NIVEL "
                + "INNER JOIN FUNCIONARIO F "
                + "ON U.CD_PESSOA = F.CD_PESSOA "
                + "INNER JOIN PESSOA P "
                + "ON F.CD_PESSOA = P.CD_PESSOA ORDER BY U.CD_USUARIO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarCdUsuario(Usuario usuario){
        String sql = "SELECT U.CD_USUARIO, U.CD_PESSOA, P.NOME, U.CD_NIVEL, N.DS_NIVEL, U.LOGIN "
                + "FROM USUARIO U INNER JOIN NIVEL N "
                + "ON U.CD_NIVEL = N.CD_NIVEL "
                + "INNER JOIN FUNCIONARIO F "
                + "ON U.CD_PESSOA = F.CD_PESSOA "
                + "INNER JOIN PESSOA P "
                + "ON F.CD_PESSOA = P.CD_PESSOA WHERE U.CD_USUARIO = "+usuario.getCdUsuario();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public void retornaUsuario(Usuario usuario){
        ResultSet retorno = consultarCdUsuario(usuario);
        try{
            retorno.first();
            usuario.getFuncionario().setCdFuncionario(retorno.getInt("CD_PESSOA"));
            usuario.getFuncionario().getPessoa().setNome(retorno.getString("NOME"));
            usuario.getNivel().setCdNivel(retorno.getInt("CD_NIVEL"));
            usuario.getNivel().setDsNivel(retorno.getString("DS_NIVEL"));
            usuario.setLogin(retorno.getString("LOGIN"));
            usuario.retornaSenha(usuario);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            usuario.setLogin("");
        }
    }
    
    private void retornaSenha(Usuario usuario){
        String sql = "SELECT SENHA FROM USUARIO WHERE CD_USUARIO = "+usuario.getCdUsuario();
        conexao.executeSQL(sql);
        try {
            conexao.resultset.first();
            usuario.setSenha(conexao.resultset.getString("SENHA"));
        } catch (SQLException ex) {
            usuario.setSenha("");
        }
        
    }
    
    // getter e setter

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
