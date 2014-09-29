
package Mensagens;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;

/**
 *
 * @author Leonardo
 */
public class MensagensSistema implements Accessible{

    
    public static void exibirMsg(String msg){
        
        System.err.println("MSG "+msg);
    }
    
    @Override
    public AccessibleContext getAccessibleContext() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
