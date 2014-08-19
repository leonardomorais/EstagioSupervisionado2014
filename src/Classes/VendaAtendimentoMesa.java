

package Classes;

import ConexaoBanco.ConexaoPostgreSQL;

/**
 *
 * @author Leonardo
 */
public class VendaAtendimentoMesa {
    
    private Integer cdVenda;
    private AtendimentoMesa atendimento = new AtendimentoMesa();
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(VendaAtendimentoMesa vendaAtd){
        String sql = "INSERT INTO VENDA_ATENDIMENTO_MESA (CD_VENDA, NR_ATENDIMENTO) "
                + "VALUES ('"+vendaAtd.getCdVenda()+"','"+vendaAtd.getAtendimento().getNrAtendimento()+"')";
        conexao.incluirSQL(sql);
    }
    
    
    // getter e setter
    
    public AtendimentoMesa getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoMesa atendimento) {
        this.atendimento = atendimento;
    }

    public Integer getCdVenda() {
        return cdVenda;
    }

    public void setCdVenda(Integer cdVenda) {
        this.cdVenda = cdVenda;
    }
    
    
    
    
}
