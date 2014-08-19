/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Validacoes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Leonardo
 */
public class FormataMoeda extends PlainDocument{
    
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException
    {
        String texto = getText(0, getLength());
        if(texto.length() < 10) {
            remove(0, getLength());
            StringBuffer strBuf = new StringBuffer(texto.replace(",", "").replace(".", "")+ str);
            if(strBuf.length() < 3) strBuf.insert(0, ",");
            else strBuf.insert(strBuf.length() - 2, ",");
            if (strBuf.length() > 6) strBuf.insert(strBuf.length()-6, ".");
            super.insertString(0, strBuf.toString(), a);
            
       }
    }
}

    

