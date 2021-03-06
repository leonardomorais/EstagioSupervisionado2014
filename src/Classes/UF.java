package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class UF {

    private Integer cdUf;
    private String dsUf;
    private String sigla;
   // private int vetEstados[] = new int[100];

    private Map <Integer, Integer> estados = new HashMap<Integer, Integer>();
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(UF uf) {
        RetornaSequencia seq = new RetornaSequencia();
        uf.setCdUf(seq.retornaSequencia("CD_UF", "UF"));
        String sql = "INSERT INTO UF (CD_UF, NOME_UF, SIGLA) VALUES ('" + uf.getCdUf() + "','"
                + uf.getDsUf() + "','" + uf.getSigla() + "')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Estado gravado com sucesso!");
        }
    }

    public void alterar(UF uf) {
        String sql = "UPDATE UF SET NOME_UF = '" + uf.getDsUf() + "', SIGLA ='" + uf.getSigla() + "' WHERE "
                + "CD_UF = " + uf.getCdUf();
        conexao.atualizarSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Estado alterado com sucesso!");
        }
    }

    public void excluir(UF uf) {
        String sql = "DELETE FROM UF WHERE CD_UF = " + uf.getCdUf();
        conexao.deleteSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Estado excluído com sucesso!");
        }
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT * FROM UF ORDER BY CD_UF";
        conexao.executeSQL(sql);
        return conexao.resultset;        
    }

    public ResultSet consultarCodigo(UF uf) {
        String sql = "SELECT * FROM UF WHERE CD_UF = " + uf.getCdUf();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNome(UF uf) {
        String sql = "SELECT * FROM UF WHERE NOME_UF LIKE '%" + uf.getDsUf() + "%' ORDER BY CD_UF";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaEstado(UF uf) {
        ResultSet retorno = consultarCodigo(uf);
        try {
            retorno.first();
            uf.setDsUf(retorno.getString("NOME_UF"));
            uf.setSigla(retorno.getString("SIGLA"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Estado não encontrado !");
            uf.setDsUf("");

        }
    }

    public void retornaComboEstados(JComboBox combo) {
        String sql = "SELECT * FROM UF ORDER BY CD_UF";
        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;
//        int[] vet = new int[100];

        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getString("NOME_UF"));
                estados.put(conta, conexao.resultset.getInt("CD_UF"));
//                vet[conta] = conexao.resultset.getInt("CD_UF");
                conta++;
            }
//            setVetEstados(vet);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "UF não encontrada !");
        }
    }

    //getter e setter
    public Integer getCdUf() {
        return cdUf;
    }

    public void setCdUf(Integer cdUf) {
        this.cdUf = cdUf;
    }

    public String getDsUf() {
        return dsUf;
    }

    public void setDsUf(String dsUf) {
        this.dsUf = dsUf;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

//    public int getVetEstados(int posicao) {
//        return vetEstados[posicao];
//    }
//
//    public void setVetEstados(int[] vetEstados) {
//        this.vetEstados = vetEstados;
//    }
    
    public int getEstado(int pos){
        return estados.get(pos);
    }
}
