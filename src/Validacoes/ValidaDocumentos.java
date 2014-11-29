package Validacoes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class ValidaDocumentos {
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public boolean validaCPFCNPJ(String documento) {
        boolean valido;

        if (verificaExistencia(documento)) {
            valido = false;
        }
        
        else if (combinacaoInvalida(removeMascara(documento))){
            valido = false;
        }
        
        else {
            documento = removeMascara(documento);    
            switch (documento.length()) {
                case 11:
                    // Caso CPF
                    valido = validaCPF(documento);
                    break;
                case 14:
                    // Caso CNPJ
                    valido = validaCNPJ(documento);
                    break;
                default :
                    valido = false;
            }
        }
        return valido;
    }

    public boolean validaCPF(String documento) {
        boolean valido;
        try {
            int digito1 = Integer.parseInt("" + documento.charAt(9));
            int digito2 = Integer.parseInt("" + documento.charAt(10));

            valido = ((digito1 == retornaDvCPF(documento, 1))
                    && (digito2 == retornaDvCPF(documento, 2))); 
                
            return valido;
            
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public int retornaDvCPF(String valores, int dv) {
        int soma = 0;
        int digito;
        int fator;
        int cont;

        switch (dv) {
            case 1:
                // retorna o digito verificador 1
                fator = 10;
                cont = 8;
                break;
            default:
                // retorna o digito verificador 2
                fator = 11;
                cont = 9;
        }

        for (int i = 0; i <= cont; i++) {
            soma = soma + (Integer.parseInt("" + valores.charAt(i)) * fator);
            fator--;
        }
        //int resultado = (int) soma / 11;
        int resto = soma % 11;
//        System.err.println("Soma: "+soma);
//        System.err.println("Resultado: "+resultado);
//        System.err.println("Resto: "+resto);

        if (resto < 2) {
            digito = 0;
        } else {
            digito = 11 - resto;
        }
//        System.err.println("Digito " + dv + " :" + digito);
        return digito;
    }

    public boolean validaCNPJ(String documento) {
        boolean valido;
        try {
            int digito1 = Integer.parseInt("" + documento.charAt(12));
            int digito2 = Integer.parseInt("" + documento.charAt(13));

            if ((digito1 == retornaDvCNPJ(documento, 1))
                    && (digito2 == retornaDvCNPJ(documento, 2))) {
                valido = true;
            } else {
                valido = false;
            }
            return valido;
            
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public int retornaDvCNPJ(String valores, int dv) {
        int soma = 0;
        int digito;
        int[] fatores;
        int count;

        switch (dv) {
            case 1:
                fatores = new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
                count = 11;
                break;
            default:
                fatores = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
                count = 12;
        }

        for (int i = 0; i <= count; i++) {
            soma = soma + (Integer.parseInt("" + valores.charAt(i)) * fatores[i]);
        }

//        int resultado = (int) soma / 11;
        int resto = soma % 11;
//        System.err.println("Soma: "+soma);
//        System.err.println("Resultado: "+resultado);
//        System.err.println("Resto: "+resto);

        if (resto < 2) {
            digito = 0;
        } else {
            digito = 11 - resto;
        }
//        System.err.println("Digito " + dv + " :" + digito);
        return digito;
    }

    public String removeMascara(String documento) {
        String valores = "";

        valores = documento.replace(".", "").replace("-", "").replace("/", "");
        //System.err.println("Valores "+valores);
        return valores;
    }

    public boolean verificaExistencia(String documento) {
        boolean existe;
        String consulta;

        switch (documento.length()) {
            case 14:
                // caso CPF
                consulta = "SELECT * FROM PESSOA_FISICA WHERE CPF = '" + documento + "'";
                break;
            default:
                consulta = "SELECT * FROM PESSOA_JURIDICA WHERE CNPJ = '" + documento + "'";
        }

        conexao.executeSQL(consulta);
        try {
            conexao.resultset.first();
            consulta = Integer.toString(conexao.resultset.getInt("CD_PESSOA"));
            existe = true;
        } catch (SQLException ex) {
            existe = false;
        }
        return existe;
    }
    
    public boolean combinacaoInvalida(String documento){
        boolean invalido = false;
        
        if (documento.equals("00000000000")
                ||documento.equals("11111111111")
                ||documento.equals("22222222222")
                ||documento.equals("33333333333")
                ||documento.equals("44444444444")
                ||documento.equals("55555555555")
                ||documento.equals("66666666666")
                ||documento.equals("77777777777")
                ||documento.equals("88888888888")
                ||documento.equals("99999999999")
                ||documento.equals("01234567890")){
            invalido = true;
        }
        return invalido;
    }
}
