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
