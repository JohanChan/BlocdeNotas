package blocdenotas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
 
public class LeerArchivo {
    public LeerArchivo(){
        
    }
    public void Read(String archivo,JTextArea area){
        String texto="";
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            while((texto=br.readLine())!=null){
                area.append(texto); 
                area.append("\n");
                
            }
            br.close();
        } catch (Exception ex) {
            //Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
