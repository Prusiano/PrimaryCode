package mathmaster;

import mathmaster.util.NavegadorFrames;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mathmaster.util.Alumno;
import mathmaster.util.BaseDatos;
import mathmaster.util.Configurador;
import mathmaster.util.Configurador;
import mathmaster.util.NavegadorFrames;

public class Profesor extends javax.swing.JPanel {

   private BaseDatos baseDatos;
   private JFrame frame;
   private Alumno alumno;
   private Image image;
   private boolean ingles,español,fruta,plasti;
   
    public Profesor (JFrame f) {
        this.frame=f;
        
        Configurador c = Configurador.getInstance();
        
        this.alumno = c.getAlumnoActual();
        this.ingles = c.isIngles();
        this.español = c.isEspanol();
        this.fruta = c.isFruta();
        this.plasti = c.isPlasti();
        this.baseDatos = c.getBaseDatos();
        
        pintaFondo();
        initComponents();
        if(ingles)
            botonMostrar.setText("Show students");
        f.setIconImage (new ImageIcon(getClass().getResource("/mathmaster/icono2.png")).getImage());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cierraVentana();
    }
    
    private void cierraVentana(){
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                int choice = 0;
                if (ingles){
                    choice = JOptionPane.showOptionDialog(null, "¿Do you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                }else if (español){
                    choice = JOptionPane.showOptionDialog(null, "¿Quieres salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                }
                if (choice == JOptionPane.YES_OPTION){
                    //baseDatos.escribirFichero();
                    System.exit(0);
                }else
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
        });
    }
    
    private void pintaFondo(){
        MediaTracker tracker=new MediaTracker(this);
        image=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/mathmaster/fondo2.png"));
        tracker.addImage(this.image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (image != null)
          g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonreset2 = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        consultar = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();

        setLayout(null);

        botonreset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/reset.png"))); // NOI18N
        botonreset2.setToolTipText("Reestablecer");
        botonreset2.setContentAreaFilled(false);
        botonreset2.setFocusable(false);
        botonreset2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/resetpress.png"))); // NOI18N
        botonreset2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/resetselec.png"))); // NOI18N
        botonreset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonreset2ActionPerformed(evt);
            }
        });
        add(botonreset2);
        botonreset2.setBounds(200, 10, 60, 60);

        botonMostrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonMostrar.setText("Mostrar lista de alumnos");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });
        add(botonMostrar);
        botonMostrar.setBounds(410, 20, 200, 40);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(206, 80));

        consultar.setEditable(false);
        consultar.setColumns(1);
        consultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        consultar.setRows(5);
        jScrollPane1.setViewportView(consultar);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 1000, 500);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atras2.png"))); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setPreferredSize(new java.awt.Dimension(55, 55));
        jButton11.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atraspres.png"))); // NOI18N
        jButton11.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atrasselec.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        add(jButton11);
        jButton11.setBounds(480, 600, 55, 55);
    }// </editor-fold>//GEN-END:initComponents

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
          baseDatos.leerFichero();
        
        if(baseDatos.getAlumnos().size()==0){
            if(español){
                consultar.setText("                                                                                             Ningún alumno registrado todavía");
            }else if (ingles){
                consultar.setText("                                                                                             Any student registered already");
            }
        }
        else{
            String cadena="";
            if(ingles){
                for (int i=0;i<baseDatos.getAlumnos().size();i++){
                        cadena+= baseDatos.getAlumnos().get(i).toStringUK();
                        cadena+="\n";
                }
            }else if(español){
                for (int i=0;i<baseDatos.getAlumnos().size();i++){
                        cadena+= baseDatos.getAlumnos().get(i).toString();  
                        cadena+="\n";
                }
            }   
            consultar.setText(cadena);
        }
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
//        NavegadorFrames.navegarAtras();
//
//        this.frame.dispose();
 this.frame.dispose();
        new Main().setVisible(true); 
    }//GEN-LAST:event_jButton11ActionPerformed

    private void botonreset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonreset2ActionPerformed
        try {
           baseDatos.borrarFichero();
           baseDatos.leerFichero();
        String cadena="";
        if(ingles){
            for (int i=0;i<baseDatos.getAlumnos().size();i++){
                    cadena+= baseDatos.getAlumnos().get(i).toStringUK();
                    cadena+="\n";
            }
        }else if(español){
            for (int i=0;i<baseDatos.getAlumnos().size();i++){
                    cadena+= baseDatos.getAlumnos().get(i).toString();  
                    cadena+="\n";
            }
        }   
        consultar.setText(cadena);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_botonreset2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton botonreset2;
    private javax.swing.JTextArea consultar;
    private javax.swing.JButton jButton11;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
