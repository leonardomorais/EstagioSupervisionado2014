package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class ConexaoPostgreSQL {

    public static Connection ConexaoPostgre;
    public static Statement statement;
    public static ResultSet resultset;
    public ResultSetMetaData metaData;
    public int retorno = 0;

    public ConexaoPostgreSQL() {
        conecta();
    }

    public static Connection conecta() {
        if (ConexaoPostgre != null) {
            return ConexaoPostgre;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                ConexaoPostgre = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"
                        + "Estagio", "postgres", "leonardo");
//                System.out.println("Conectado");                
              //  JOptionPane.showMessageDialog(null, "Conectado com sucesso");
                return ConexaoPostgre;
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver não localizado :");
                ex.printStackTrace();
                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados");
                ex.printStackTrace();
                return null;
            }
        }
    }

    public void desconecta() {
        boolean result = true;
        try {
            ConexaoPostgre.close();
            JOptionPane.showMessageDialog(null, "banco fechado");
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o banco de dados :" + fecha);
            result = false;
        }
    }

    public void incluirSQL(String sql) {

        try {
            statement = ConexaoPostgre.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(sql);
//                statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY'");
//                resultset = statement.executeQuery(sql);
            retorno = 1;
            //JOptionPane.showMessageDialog(null, "O registro foi gravado com sucesso!");
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 00001) {
                JOptionPane.showMessageDialog(null, "O registro não pôde ser incluído pois já está cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível executar o comando sql, " + sqlex
                        + ",o sql passado foi " + sql);

            }
            retorno = 0;
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YYYY'");
            resultset = statement.executeQuery(sql);
            retorno = 1;
        } catch (SQLException sqlex) {
            //JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro \n" + sqlex);
        }
        try {
            metaData = resultset.getMetaData();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }

    }

    public void deleteSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);
            if (retorno == 1) {
              //  JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso");
            }
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "O Registro não pôde ser excluído porque ele"
                        + " está sendo utilizado em outro cadastro/movimento");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível executar o comando sql de exclusão, " + sqlex + ""
                        + " ,o sql passado foi " + sql);
            }
            retorno = 0;
        }

    }

    public void atualizarSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);
            if (retorno == 1) {
                //JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            }
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "O registro não pôde ser atualizado em outro cadastro/movimento");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível executar o comando sql de exclusão " + sqlex + ", o sql passado foi "
                        + sql);
            }
            retorno = 0;
        }

    }

}
