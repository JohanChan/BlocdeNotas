package blocdenotas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
 
public class EscribirArchivo {
    public EscribirArchivo(){
          
    }
    public void Escribir(JFileChooser save,JTextArea area){
        
        save.setApproveButtonText("Guardar");
        save.showSaveDialog(null);
        File archivo = new File(save.getSelectedFile()+".tarea");
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(archivo));
            bf.write(area.getText()); 
            bf.write("\n"); 
            bf.close();
        }catch(Exception e){ 
            
        }
    }
    public void guardar(JTextArea area,String arch){
        File archivo = new File(arch);
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(archivo));
            bf.write(area.getText()); 
            bf.write("\n");
            bf.close();
        }catch(Exception e){ 
            
        }
    }

}
