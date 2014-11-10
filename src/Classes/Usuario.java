package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
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
