package blocdenotas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends javax.swing.JFrame implements ActionListener{
    JMenu contenedor;
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Tarea","tarea");
    JMenuItem nuevo,guardar,guardarcomo,abrir;
    JMenuBar barra;
    JTextArea area;
    JScrollPane scroll;
    JFileChooser yoteelijo;
    String nombre;
    public Ventana(){
        yoteelijo = new JFileChooser();
        inicializarComponentes();
    }
    public void inicializarComponentes(){
        this.setSize(800,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Bloc de Notas"); 
        
        yoteelijo = new JFileChooser();
        area = new JTextArea();
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        contenedor = new JMenu(); 
        nuevo = new JMenuItem();
        guardar = new JMenuItem();
        guardarcomo = new JMenuItem();
        abrir = new JMenuItem();
        barra = new JMenuBar();
        
        area.setBounds(0, 25, 790, 335);
        barra.setBounds(0, 0, 600, 25);
        contenedor.setText("Archivo");
        nuevo.setText("Nuevo");
        abrir.setText("Abrir");
        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardarcomo.setText("Guardar Como");
        
        nuevo.addActionListener(this);
        abrir.addActionListener(this);
        guardar.addActionListener(this);
        guardarcomo.addActionListener(this);
        
        scroll.setBounds(0, 25, 790, 335);
        add(scroll);
        
        contenedor.add(nuevo); 
        contenedor.add(abrir);
        contenedor.add(guardar);
        contenedor.add(guardarcomo);
        barra.add(contenedor);
        add(barra);
        
        
    }
    public void guardarComo(){
        JFileChooser guardarcomo = new JFileChooser();
        EscribirArchivo es = new EscribirArchivo(); 
        es.Escribir(yoteelijo,area); 
    }
    public void obtenerArchivo(){
        area.setText(" ");
        yoteelijo.setFileFilter(filtro);
        int opcion = yoteelijo.showOpenDialog(this);
        
        try{
            nombre = yoteelijo.getSelectedFile().toString();
            if(opcion==JFileChooser.APPROVE_OPTION){
            LeerArchivo leer = new LeerArchivo();
            leer.Read(nombre, area); 
        }
        }catch(Exception e){
            
        } 
        
    }
    public void guardar(){
        EscribirArchivo write = new EscribirArchivo();
        write.guardar(area, nombre); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==nuevo){
            guardar.setEnabled(false); 
            area.setText(null);
        }
        if(e.getSource()==abrir){
            guardar.setEnabled(true);
            obtenerArchivo();
            
        } 
        if(e.getSource()==guardarcomo){
            guardar.setEnabled(true); 
            guardarComo();
        }
        if(e.getSource()==guardar){
            guardar();
        }
    }
}
