
package Classes;

import ConexaoBanco.ConexaoPostgreSQL;

/**
 *
 * @author Leonardo
 */
public class NivelTelas {

    private Nivel nivel = new Nivel();
    private Telas tela = new Telas();
    private String pInclusao;
    private String pAlteracao;
    private String pExclusao;
    private String pGravacao;
    private String pRelatorio;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(NivelTelas nvTelas){
        String sql = "INSERT INTO NIVEL_TELA (CD_NIVEL, CD_TELA, P_INCLUIR, P_ALTERAR,"
                + " P_EXCLUIR, P_GRAVAR, P_RELATORIO) VALUES ('"+nvTelas.getNivel().getCdNivel()+"','"
                +nvTelas.getTela().getCdTela()+"','"+nvTelas.getpInclusao()+"','"+nvTelas.getpAlteracao()+"','"
                +nvTelas.getpExclusao()+"','"+nvTelas.getpGravacao()+"','"+nvTelas.getpRelatorio()+"')";
        conexao.incluirSQL(sql);
    }
    
    
    // getter e setter

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getpInclusao() {
        return pInclusao;
    }

    public void setpInclusao(String pInclusao) {
        this.pInclusao = pInclusao;
    }

    public String getpAlteracao() {
        return pAlteracao;
    }

    public void setpAlteracao(String pAlteracao) {
        this.pAlteracao = pAlteracao;
    }

    public String getpExclusao() {
        return pExclusao;
    }

    public void setpExclusao(String pExclusao) {
        this.pExclusao = pExclusao;
    }

    public String getpGravacao() {
        return pGravacao;
    }

    public void setpGravacao(String pGravacao) {
        this.pGravacao = pGravacao;
    }

    public String getpRelatorio() {
        return pRelatorio;
    }

    public void setpRelatorio(String pRelatorio) {
        this.pRelatorio = pRelatorio;
    }

    public Telas getTela() {
        return tela;
    }

    public void setTela(Telas tela) {
        this.tela = tela;
    }
    
    
}
