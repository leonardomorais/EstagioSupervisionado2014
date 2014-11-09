package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Nivel {
    
    private Integer cdNivel;
    private String dsNivel;
    private String inAtivo;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(Nivel nivel){
        RetornaSequencia seq = new RetornaSequencia();
        nivel.setCdNivel(seq.retornaSequencia("CD_NIVEL", "NIVEL"));
        String sql = "INSERT INTO NIVEL (CD_NIVEL, DS_NIVEL, IN_ATIVO) VALUES "
                + "('"+nivel.getCdNivel()+"','"+nivel.getDsNivel()+"','"+nivel.getInAtivo()+"')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Nível de usuário cadastrado com sucesso!");
        }
    }
    
    public void alterar(Nivel nivel){
        String sql = "UPDATE NIVEL SET DS_NIVEL = '"+nivel.getDsNivel()+"', IN_ATIVO = '"+nivel.getInAtivo()+"'"
                + "WHERE CD_NIVEL = "+nivel.getCdNivel();
        conexao.atualizarSQL(sql);
    }
    
    public void excluir(Nivel nivel){
        String sql = "UPDATE NIVEL SET IN_ATIVO = 'I' WHERE CD_NIVEL = "+nivel.getCdNivel();
        conexao.atualizarSQL(sql);
    }
    
    
    // getter e setter

    public Integer getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(Integer cdNivel) {
        this.cdNivel = cdNivel;
    }

    public String getDsNivel() {
        return dsNivel;
    }

    public void setDsNivel(String dsNivel) {
        this.dsNivel = dsNivel;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }
    
    
    
}
