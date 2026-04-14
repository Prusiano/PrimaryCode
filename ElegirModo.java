package mathmaster;

import mathmaster.util.Alumno;
import mathmaster.util.BaseDatos;
import mathmaster.util.NavegadorFrames;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import mathmaster.enumerados.InterfazMakey;
import mathmaster.util.Configurador;

public class ElegirModo extends javax.swing.JPanel {
    private BaseDatos baseDatos = new BaseDatos();
    private JFrame frame;
    private Alumno alumno;
    private Image image;
    private boolean ingles,español,fruta,plasti;
    int xsize,ysize;
    Dimension pantallaTamano; 
    private final ArrayList<String> listaI;
    private Configurador conf;
    
    public ElegirModo(JFrame frame){
        this.frame = frame;
        
        conf = Configurador.getInstance();
        
        this.alumno = conf.getAlumnoActual();
        this.ingles = conf.isIngles();
        this.español = conf.isEspanol();
        this.fruta = conf.isFruta();
        this.plasti = conf.isPlasti();
        this.listaI = new ArrayList<>();
   
        baseDatos.leerFichero();
        
        pintaFondo();        
        initComponents();
        if (conf.isIngles()){
            frame.setTitle("Choose an Interaction");
            raton.setText("Mouse");
            titulo.setIcon(new ImageIcon(getClass().getResource("/mathmaster/tituloInUK.png")));
        }
        Toolkit tk = Toolkit.getDefaultToolkit();
        xsize = ((int) tk.getScreenSize().getWidth());
        ysize = ((int) tk.getScreenSize().getHeight());
        
        this.frame.setIconImage (new ImageIcon(getClass().getResource("/mathmaster/icono2.png")).getImage());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        cierraVentana();
    }
    
    private void cierraVentana(){
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                int choice = 0;
                if (conf.isIngles()){
                    choice = JOptionPane.showOptionDialog(null, "¿Do you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                }else {
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

        botonAtras = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        botonMakey = new javax.swing.JButton();
        botonRaton = new javax.swing.JButton();
        raton = new javax.swing.JLabel();
        makey = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        botonAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atras2.png"))); // NOI18N
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setPreferredSize(new java.awt.Dimension(55, 55));
        botonAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atraspres.png"))); // NOI18N
        botonAtras.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atrasselec.png"))); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        add(botonAtras);
        botonAtras.setBounds(460, 580, 83, 59);

        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/tituloIn.png"))); // NOI18N
        add(titulo);
        titulo.setBounds(190, 160, 620, 80);

        botonMakey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/makey.png"))); // NOI18N
        botonMakey.setBorderPainted(false);
        botonMakey.setContentAreaFilled(false);
        botonMakey.setFocusable(false);
        botonMakey.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/makeyselec.png"))); // NOI18N
        botonMakey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMakeyActionPerformed(evt);
            }
        });
        add(botonMakey);
        botonMakey.setBounds(560, 300, 200, 160);

        botonRaton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/raton.png"))); // NOI18N
        botonRaton.setBorderPainted(false);
        botonRaton.setContentAreaFilled(false);
        botonRaton.setFocusable(false);
        botonRaton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/ratonselec.png"))); // NOI18N
        botonRaton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRatonActionPerformed(evt);
            }
        });
        add(botonRaton);
        botonRaton.setBounds(270, 270, 140, 190);

        raton.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        raton.setText("Ratón");
        add(raton);
        raton.setBounds(320, 470, 70, 30);

        makey.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        makey.setText("Makey Makey");
        add(makey);
        makey.setBounds(600, 470, 130, 30);
    }// </editor-fold>//GEN-END:initComponents
   
    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
       
//        NavegadorFrames.navegarAtras();
//        this.setVisible(false);
//        this.frame.dispose();
        this.frame.dispose();
        new Main().setVisible(true); 

    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonMakeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMakeyActionPerformed
        
        conf.setRaton(false);
        if(conf.isFruta()){
            NavegadorFrames.navegarA(NavegadorFrames.ELEGIR_FRUTAS);
        }else if(conf.isPlasti()){
            NavegadorFrames.navegarA(NavegadorFrames.ELEGIR_PLASTI);
        }
        

        this.frame.dispose();
    }//GEN-LAST:event_botonMakeyActionPerformed

    private void botonRatonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRatonActionPerformed
        conf.setRaton(true);
        NavegadorFrames.navegarA(NavegadorFrames.ELEGIR_OPERACION);

        this.frame.dispose();
    }//GEN-LAST:event_botonRatonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonMakey;
    private javax.swing.JButton botonRaton;
    private javax.swing.JLabel makey;
    private javax.swing.JLabel raton;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
