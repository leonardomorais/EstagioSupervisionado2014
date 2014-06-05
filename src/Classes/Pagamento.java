package Classes;

/**
 *
 * @author Leonardo
 */
public class Pagamento {
    
    private Integer cdPagamento;

    private AgenciaConta agc;
    private Parcelas parcelas;
    private TipoPagamento tipo = new TipoPagamento();

    // getter e setter
    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public Integer getCdPagamento() {
        return cdPagamento;
    }

    public void setCdPagamento(Integer cdPagamento) {
        this.cdPagamento = cdPagamento;
    }

    public AgenciaConta getAgc() {
        return agc;
    }

    public void setAgc(AgenciaConta agc) {
        this.agc = agc;
    }

    public Parcelas getParcelas() {
        return parcelas;
    }

    public void setParcelas(Parcelas parcelas) {
        this.parcelas = parcelas;
    }
    
    
    
    
    
}
