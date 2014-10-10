package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.EditarComponentes;
import Validacoes.RetornaSequencia;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import sun.swing.SwingAccessor;

/**
 *
 * @author Leonardo
 */
public class AtendimentoMesa {

    private static Integer nrAtendimento;
    private String horaAbertura;
    private String horaFechamento;
    private String abertoFechado;
    private static Double vlTotal;
    private String dtAtendimento;

    private Mesa mesa = new Mesa();
    private Funcionario funcionario = new Funcionario();
    private AtendimentoMesaProdutos atdProdutos = new AtendimentoMesaProdutos();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(AtendimentoMesa atd) {
        RetornaSequencia seq = new RetornaSequencia();
        atd.setNrAtendimento(seq.retornaSequencia("NR_ATENDIMENTO", "ATENDIMENTO_MESA"));
        String sql = "INSERT INTO ATENDIMENTO_MESA (NR_ATENDIMENTO, HORA_ABERTURA, "
                + "ABERTO_FECHADO, DT_ATENDIMENTO) VALUES ('" + atd.getNrAtendimento() + "','"
                + atd.getHoraAbertura() + "','" + atd.getAbertoFechado() + "','" + atd.getDtAtendimento() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(AtendimentoMesa atd) {
        String sql = "UPDATE ATENDIMENTO_MESA SET NR_MESA = '" + atd.getMesa().getNrMesa() + "', "
                + "HORA_ABERTURA = '" + atd.getHoraAbertura() + "', "
                + "HORA_FECHAMENTO = '" + atd.getHoraFechamento() + "', "
                + "ABERTO_FECHADO = '" + atd.getAbertoFechado() + "', "
                + "VL_TOTAL = '" + atd.getVlTotal() + "', "
                + "DT_ATENDIMENTO = '" + atd.getDtAtendimento() + "', "
                + "CD_FUNCIONARIO = '" + atd.getFuncionario().getCdFuncionario() + "' "
                + "WHERE NR_ATENDIMENTO = " + atd.getNrAtendimento();
        conexao.atualizarSQL(sql);
    }
    public void alterar (AtendimentoMesa atd, String campo){
        String valor;
        String sql;
        switch (campo){
            case "NR_MESA":
                valor = atd.getMesa().getNrMesa().toString();
            break;
                
            case "HORA_ABERTURA":
                valor = atd.getHoraAbertura();
            break; 
                
            case "HORA_FECHAMENTO":
                valor = atd.getHoraFechamento();
            break;
                
            case "ABERTO_FECHADO":
                valor = atd.getAbertoFechado();
            break;
                
            case "VL_TOTAL":
                valor = atd.getVlTotal().toString();
            break;    
                
            case "DT_ATENDIMENTO":
                valor = atd.getDtAtendimento();
            break;    
                
            default:
                valor = atd.getFuncionario().getCdFuncionario().toString();
            break;    
            
        }
        sql = "UPDATE ATENDIMENTO_MESA SET "+campo+" = '"+valor+"' WHERE NR_ATENDIMENTO = "
                +atd.getNrAtendimento();
         
        conexao.atualizarSQL(sql);
    }

    public void excluir(AtendimentoMesa atd) {
        String sql = "DELETE FROM ATENDIMENTO_MESA WHERE NR_ATENDIMENTO = " + atd.getNrAtendimento();
        conexao.deleteSQL(sql);
    }

    public double retornaTotalAtendimento(JTable jtable) {
        DefaultTableModel tabela = (DefaultTableModel) jtable.getModel();
        double total = 0;
        double valor = 0;
        int linhas = tabela.getRowCount();
        for (int i = 0; i < linhas; i++) {
            valor = Double.parseDouble(tabela.getValueAt(i, 4).toString());
            total = total + valor;
        }

        return total;
    }

    public ResultSet consultarGeral(AtendimentoMesa atd) {
        String condicao;
        if (atd.getAbertoFechado().equals("AMBOS")){
            condicao = "";
        }
        else{
            condicao = "WHERE A.ABERTO_FECHADO = '"+atd.getAbertoFechado()+"' ";
        }
        String sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "+condicao
                    + "ORDER BY A.NR_ATENDIMENTO";
        
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNrAtendimento(AtendimentoMesa atd) {
        String condicao;
        if (atd.getAbertoFechado().equals("AMBOS")){
            condicao = "WHERE ";
        }
        else{
            condicao = "WHERE A.ABERTO_FECHADO = '"+atd.getAbertoFechado()+"' AND ";
        }
        String sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "+condicao
                    + "A.NR_ATENDIMENTO = "+ atd.getNrAtendimento();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarNrMesa(AtendimentoMesa atd){
        String condicao;
        if (atd.getAbertoFechado().equals("AMBOS")){
            condicao = "WHERE ";
        }
        else{
            condicao = "WHERE A.ABERTO_FECHADO = '"+atd.getAbertoFechado()+"' AND ";
        }
       String sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "+condicao
                    + "A.NR_MESA = "+ atd.getMesa().getNrMesa()+" ORDER BY A.NR_ATENDIMENTO";
        
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarNomeFuncionario(AtendimentoMesa atd){
        String condicao;
        if (atd.getAbertoFechado().equals("AMBOS")){
            condicao = "WHERE ";
        }
        else{
            condicao = "WHERE A.ABERTO_FECHADO = '"+atd.getAbertoFechado()+"' AND ";
        }
        String sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "+condicao
                    + "P.NOME LIKE '%"
                    + atd.getFuncionario().getPessoa().getNome()+"%' "
                    + "ORDER BY A.NR_ATENDIMENTO";
        
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarPorData(AtendimentoMesa atd){
        String condicao;
        if (atd.getAbertoFechado().equals("AMBOS")){
            condicao = "WHERE ";
        }
        else{
            condicao = "WHERE A.ABERTO_FECHADO = '"+atd.getAbertoFechado()+"' AND ";
        }
        String sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "+condicao
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') "
                    + "= '"+atd.getDtAtendimento()+"' ORDER BY A.NR_ATENDIMENTO";
        
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public void retornaAtendimento(AtendimentoMesa atd){
        String sql = "SELECT NR_MESA, HORA_ABERTURA, HORA_FECHAMENTO, "
                + "ABERTO_FECHADO, VL_TOTAL, TO_CHAR(DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                + "CD_FUNCIONARIO FROM ATENDIMENTO_MESA WHERE NR_ATENDIMENTO = "+atd.getNrAtendimento();
        conexao.executeSQL(sql);
        try{
            conexao.resultset.first();
            atd.getFuncionario().setCdFuncionario(conexao.resultset.getInt("CD_FUNCIONARIO"));
            atd.getMesa().setNrMesa(conexao.resultset.getInt("NR_MESA"));
            atd.setHoraAbertura(conexao.resultset.getString("HORA_ABERTURA"));
            atd.setHoraFechamento(conexao.resultset.getString("HORA_FECHAMENTO"));
            atd.setAbertoFechado(conexao.resultset.getString("ABERTO_FECHADO"));
            atd.setVlTotal(conexao.resultset.getDouble("VL_TOTAL"));
            atd.setDtAtendimento(conexao.resultset.getString("DATA"));   
        }
        catch(SQLException ex){
            atd.setNrAtendimento(0);
        }
    }
    
    public ResultSet exibirAtendimentosAtuais() {
        String sql = "SELECT A.NR_MESA, A.NR_ATENDIMENTO, A.CD_FUNCIONARIO, "
                + "P.NOME, A.HORA_ABERTURA, COALESCE(A.VL_TOTAL,0.00) "
                + "FROM ATENDIMENTO_MESA A "
                + "LEFT JOIN FUNCIONARIO F ON A.CD_FUNCIONARIO = F.CD_PESSOA "
                + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                + "WHERE A.ABERTO_FECHADO = 'A' ORDER BY A.NR_MESA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public void carregarMesas(JPanel panel, JTextField campoMesa) {
        String sql = "SELECT M.NR_MESA, A.NR_ATENDIMENTO, A.HORA_ABERTURA, A.VL_TOTAL, "
                + "A.CD_FUNCIONARIO, CASE WHEN A.NR_ATENDIMENTO IS NULL THEN "
                + "'Mesa Disponível' ELSE 'Mesa Ocupada' END AS DISPONIVEL "
                + "FROM MESA M LEFT JOIN ATENDIMENTO_MESA A ON M.NR_MESA = A.NR_MESA "
                + "AND A.ABERTO_FECHADO = 'A' WHERE M.ATIVA = 'A' ORDER BY M.NR_MESA ";
        conexao.executeSQL(sql);
        
        try {
            EditarComponentes edit = new EditarComponentes();
            int x = 5;
            int y = 5;
            Font fonte = new Font("Tahoma", 1, 12);
            while (conexao.resultset.next()){
                
                int nr = conexao.resultset.getInt("NR_MESA");
                String disponivel = conexao.resultset.getString("DISPONIVEL");
                String total = conexao.resultset.getString("VL_TOTAL");
                
                JPanel mesa = new JPanel();
                JLabel labelNr = new JLabel("Mesa:           "+nr);
                
                JLabel labelSit = new JLabel(disponivel);
                //
                ImageIcon img;
                if (disponivel.equals("Mesa Disponível")){
                    img = new ImageIcon("src\\Extras\\Imagens\\mesaDisponivel.png");
                    labelSit.setForeground(new Color(0, 102, 51));
                }
                else{
                    img = new ImageIcon("src\\Extras\\Imagens\\mesaOcupada.png");
                    labelSit.setForeground(Color.BLUE);
                }
                
                JLabel labelImg = new JLabel(img);
                
                try{
                    total = total.replace(".", ",");
                }
                catch(NullPointerException ex){
                    total = "0,00";
                }
                JLabel labelTotal = new JLabel("Total:      "+total);
                
                // editando os labels
      
                labelTotal.setFont(fonte);
                labelNr.setFont(fonte);
                labelSit.setFont(fonte);
                
                //
                
                mesa.add(labelNr);
                mesa.add(labelImg);
                mesa.add(labelTotal);
                mesa.add(labelSit);
                
                mesa.setBackground(new Color(197, 222, 243));
                
                mesa.setBounds(x, y, 120, 120);
                
                x = x + 125; // tamanho do jpanel mais o espaçamento de 5
                
                // se não há mais espaço horizontal para os componentes, adiciona o próximo abaixo
                if (x >= panel.getWidth() - 125){
                    y = y + 125;
                    x = 5;
                }
             
                edit.editaJpanel(mesa, campoMesa);
                panel.add(mesa);
            
                panel.repaint();
                panel.validate();
            }
        } 
        catch (SQLException ex) {
            
        }
        
    }
    
    public void retornaMesa(AtendimentoMesa atd){
        String sql = "SELECT M.NR_MESA, A.NR_ATENDIMENTO, A.HORA_ABERTURA, A.VL_TOTAL, A.CD_FUNCIONARIO, P.NOME, "
                + "CASE WHEN A.NR_ATENDIMENTO IS NULL THEN 'Mesa Disponível' ELSE 'Mesa Ocupada' END AS DISPONIVEL "
                + "FROM MESA M LEFT JOIN ATENDIMENTO_MESA A "
                + "ON M.NR_MESA = A.NR_MESA AND A.ABERTO_FECHADO = 'A' "
                + "LEFT JOIN PESSOA P ON A.CD_FUNCIONARIO = P.CD_PESSOA "
                + "WHERE M.ATIVA = 'A' "
                + "AND M.NR_MESA = "+atd.getMesa().getNrMesa();
        conexao.executeSQL(sql);
        try{
            conexao.resultset.first();
            atd.setNrAtendimento(conexao.resultset.getInt("NR_ATENDIMENTO"));
            atd.setHoraAbertura(conexao.resultset.getString("HORA_ABERTURA"));
            atd.setVlTotal(conexao.resultset.getDouble("VL_TOTAL"));
            atd.getFuncionario().setCdFuncionario(conexao.resultset.getInt("CD_FUNCIONARIO"));
            atd.getFuncionario().getPessoa().setNome(conexao.resultset.getString("NOME"));
            atd.setHoraFechamento(conexao.resultset.getString("DISPONIVEL").toUpperCase());
        }
        catch(SQLException ex){
            atd.getMesa().setNrMesa(0);
        }
    }
    
    public boolean VerificaMesaDisponivel(AtendimentoMesa atd){
        boolean disponivel = true;
        String sql = "SELECT * FROM ATENDIMENTO_MESA WHERE "
                + "ABERTO_FECHADO = 'A' AND NR_MESA = "+atd.getMesa().getNrMesa();
        conexao.executeSQL(sql);
        try{
            while(conexao.resultset.next()){
                disponivel = false;
                JOptionPane.showMessageDialog(null, "Já existe um atendimento aberto na mesa "+atd.getMesa().getNrMesa());
            }
        }
        catch(SQLException ex){
            disponivel = true;
        }
        return disponivel;
    }

    // getter e setter
    public Integer getNrAtendimento() {
        return nrAtendimento;
    }

    public void setNrAtendimento(Integer nrAtendimento) {
        this.nrAtendimento = nrAtendimento;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public String getAbertoFechado() {
        return abertoFechado;
    }

    public void setAbertoFechado(String abertoFechado) {
        this.abertoFechado = abertoFechado;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public String getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(String dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public AtendimentoMesaProdutos getAtdProdutos() {
        return atdProdutos;
    }

    public void setAtdProdutos(AtendimentoMesaProdutos atdProdutos) {
        this.atdProdutos = atdProdutos;
    }

}
