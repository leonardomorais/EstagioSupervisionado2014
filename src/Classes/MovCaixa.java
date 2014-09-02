package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;

/**
 *
 * @author Leonardo
 */
public class MovCaixa {
    
    private Integer cdMov;
    private Double saldoAnterior;
    private Double saldoFinal;
    private Double valorMov;
    private String dataMov;
    private String observacao;
    
    private AgenciaConta agc = new AgenciaConta();
    private Parcelas parcelas = new Parcelas();
    private Operacao operacao = new Operacao();
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(MovCaixa mov, boolean conta){
        RetornaSequencia seq = new RetornaSequencia();
        mov.setCdMov(seq.retornaSequencia("CD_MOV", "MOV_CAIXA"));
        String sql;
        if (conta){
            // se for movimentação de caixa referente a parcela de uma conta 
            sql = "INSERT INTO MOV_CAIXA (CD_MOV, CD_AGENCIA_CONTA, CD_OPERACAO, CD_CONTA, "
                    + "NR_PARCELA, SALDO_ANTERIOR, SALDO_FINAL, DATA_MOV, VALOR_MOV, OBERVACAO) "
                    + "VALUES ('"+mov.getCdMov()+"','"+mov.getAgc().getCdAgcConta()+"','"
                    +mov.getOperacao().getCdOperacao()+"','"+mov.getParcelas().getContas().getCdConta()+"','"
                    +mov.getParcelas().getNrParcela()+"','"+mov.getSaldoAnterior()+"','"+mov.getSaldoFinal()+"','"
                    +mov.getValorMov()+"','"+mov.getObservacao()+")";
        }
        else{
            sql = "INSERT INTO MOV_CAIXA (CD_MOV, CD_AGENCIA_CONTA, CD_OPERACAO, SALDO_ANTERIOR, SALDO_FINAL, "
                    + "DATA_MOV, VALOR_MOV, OBSERVACAO) VALUES ('"+mov.getCdMov()+"','"+mov.getAgc().getCdAgcConta()+"','"
                    +mov.getOperacao().getCdOperacao()+"','"+mov.getSaldoAnterior()+"','"+mov.getSaldoFinal()+"','"
                    +mov.getDataMov()+"','"+mov.getValorMov()+"','"+mov.getObservacao()+"')";
        }
        conexao.incluirSQL(sql);
    }
    
    
    
// getter e setter
    
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

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Integer getCdMov() {
        return cdMov;
    }

    public void setCdMov(Integer cdMov) {
        this.cdMov = cdMov;
    }

    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Double getValorMov() {
        return valorMov;
    }

    public void setValorMov(Double valorMov) {
        this.valorMov = valorMov;
    }

    public String getDataMov() {
        return dataMov;
    }

    public void setDataMov(String dataMov) {
        this.dataMov = dataMov;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }  
    
    
}
