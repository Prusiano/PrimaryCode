package mathmaster;

import mathmaster.util.Alumno;
import mathmaster.util.Fuente;
import mathmaster.util.BaseDatos;
import mathmaster.util.NavegadorFrames;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mathmaster.util.Configurador;
import mathmaster.util.Constantes;

public class PreviaPlasti extends javax.swing.JPanel {

    private JFrame frame;
    private BaseDatos baseDatos;
    private Alumno alumno;
    private boolean textook;
    private Image image;
    private int contador=0;
    private ArrayList<String>listaI= new ArrayList<>();
    private boolean ingles,español,fruta,plasti;
    private Configurador conf;
      
     public PreviaPlasti(JFrame f) {
        Font myFont = Fuente.getFont(Fuente.CUSTOM1, Font.BOLD, 40);
        conf = Configurador.getInstance();
        this.frame=f;
        this.baseDatos=conf.getBaseDatos();
        this.alumno=conf.getAlumnoActual();
        this.ingles=conf.isIngles();
        this.español=conf.isEspanol();
        this.fruta=conf.isFruta();
        this.plasti=conf.isPlasti();
        pintaFondo();
        initComponents();
        if(ingles){
            info.setIcon(new ImageIcon(getClass().getResource("/mathmaster/infoUK.png")));
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/mathmaster/conectarUK.png")));
            botonreset.setToolTipText("Reset");
        }
        f.setIconImage (new ImageIcon(getClass().getResource("/mathmaster/icono2.png")).getImage());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cierraVentana();
    }
    public PreviaPlasti(JFrame f, BaseDatos bDatos,Alumno a,boolean uk,boolean es,boolean fr,boolean p) {
        Font myFont = Fuente.getFont(Fuente.CUSTOM1, Font.BOLD, 40);
        this.frame=f;
        this.baseDatos=bDatos;
        this.alumno=a;
        this.ingles=uk;
        this.español=es;
        this.fruta=fr;
        this.plasti=p;
        pintaFondo();
        initComponents();
        if(ingles){
            info.setIcon(new ImageIcon(getClass().getResource("/mathmaster/info2UK.png")));
            botonreset.setToolTipText("Reset");
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/mathmaster/conectarUK.png")));
        }
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        left = new javax.swing.JLabel();
        up = new javax.swing.JLabel();
        click = new javax.swing.JLabel();
        down = new javax.swing.JLabel();
        right = new javax.swing.JLabel();
        space = new javax.swing.JLabel();
        botonmanzana = new javax.swing.JButton();
        botonplatano = new javax.swing.JButton();
        botonnaranja = new javax.swing.JButton();
        botonkiwi = new javax.swing.JButton();
        botonpera = new javax.swing.JButton();
        botonlimon = new javax.swing.JButton();
        botontomate = new javax.swing.JButton();
        botonberenjena = new javax.swing.JButton();
        botonzanahoria = new javax.swing.JButton();
        botonreset = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(2147483647, 2147483647));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atras2.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atraspres.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atrasselec.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(340, 600, 60, 70);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/siguiente.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/siguientepress.png"))); // NOI18N
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/siguienteselec.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(620, 600, 70, 70);

        jTextField1.setEditable(false);
        jTextField1.setBorder(null);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(480, 110, 0, 14);

        left.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        left.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        left.setText("1");
        add(left);
        left.setBounds(200, 170, 70, 70);

        up.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        up.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        up.setText("2");
        add(up);
        up.setBounds(430, 140, 70, 70);

        click.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        click.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        click.setText("3");
        add(click);
        click.setBounds(730, 200, 70, 70);

        down.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        down.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        down.setText("4");
        add(down);
        down.setBounds(200, 410, 70, 70);

        right.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        right.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        right.setText("5");
        add(right);
        right.setBounds(490, 440, 70, 70);

        space.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        space.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        space.setText("6");
        add(space);
        space.setBounds(750, 450, 70, 70);

        botonmanzana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/amarilla.png"))); // NOI18N
        botonmanzana.setContentAreaFilled(false);
        botonmanzana.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/amarillapress.png"))); // NOI18N
        botonmanzana.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/amarillaselec.png"))); // NOI18N
        botonmanzana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmanzanaActionPerformed(evt);
            }
        });
        add(botonmanzana);
        botonmanzana.setBounds(150, 510, 80, 80);

        botonplatano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/azul.png"))); // NOI18N
        botonplatano.setContentAreaFilled(false);
        botonplatano.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/azulpress.png"))); // NOI18N
        botonplatano.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/azulselec.png"))); // NOI18N
        botonplatano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonplatanoActionPerformed(evt);
            }
        });
        add(botonplatano);
        botonplatano.setBounds(230, 510, 83, 80);

        botonnaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/naranjaP.png"))); // NOI18N
        botonnaranja.setContentAreaFilled(false);
        botonnaranja.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/naranjaPpress.png"))); // NOI18N
        botonnaranja.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/naranjaPselec.png"))); // NOI18N
        botonnaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonnaranjaActionPerformed(evt);
            }
        });
        add(botonnaranja);
        botonnaranja.setBounds(310, 510, 80, 80);

        botonkiwi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/morada.png"))); // NOI18N
        botonkiwi.setContentAreaFilled(false);
        botonkiwi.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/moradapress.png"))); // NOI18N
        botonkiwi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/moradaselec.png"))); // NOI18N
        botonkiwi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonkiwiActionPerformed(evt);
            }
        });
        add(botonkiwi);
        botonkiwi.setBounds(390, 510, 80, 80);

        botonpera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/verde.png"))); // NOI18N
        botonpera.setContentAreaFilled(false);
        botonpera.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/verdepress.png"))); // NOI18N
        botonpera.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/verdeselec.png"))); // NOI18N
        botonpera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonperaActionPerformed(evt);
            }
        });
        add(botonpera);
        botonpera.setBounds(470, 510, 80, 80);

        botonlimon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/negra.png"))); // NOI18N
        botonlimon.setContentAreaFilled(false);
        botonlimon.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/negrapress.png"))); // NOI18N
        botonlimon.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/negraselec.png"))); // NOI18N
        botonlimon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonlimonActionPerformed(evt);
            }
        });
        add(botonlimon);
        botonlimon.setBounds(810, 510, 80, 80);

        botontomate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/roja.png"))); // NOI18N
        botontomate.setContentAreaFilled(false);
        botontomate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/rojapress.png"))); // NOI18N
        botontomate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/rojaselec.png"))); // NOI18N
        botontomate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botontomateActionPerformed(evt);
            }
        });
        add(botontomate);
        botontomate.setBounds(550, 510, 80, 80);

        botonberenjena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/rosa.png"))); // NOI18N
        botonberenjena.setContentAreaFilled(false);
        botonberenjena.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/rosapress.png"))); // NOI18N
        botonberenjena.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/rosaselec.png"))); // NOI18N
        botonberenjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonberenjenaActionPerformed(evt);
            }
        });
        add(botonberenjena);
        botonberenjena.setBounds(640, 510, 80, 80);

        botonzanahoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/azulclaro.png"))); // NOI18N
        botonzanahoria.setContentAreaFilled(false);
        botonzanahoria.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/azulclaropress.png"))); // NOI18N
        botonzanahoria.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/azulclaroselec.png"))); // NOI18N
        botonzanahoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonzanahoriaActionPerformed(evt);
            }
        });
        add(botonzanahoria);
        botonzanahoria.setBounds(720, 510, 80, 80);

        botonreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/reset.png"))); // NOI18N
        botonreset.setToolTipText("Reestablecer");
        botonreset.setContentAreaFilled(false);
        botonreset.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/resetpress.png"))); // NOI18N
        botonreset.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/resetselec.png"))); // NOI18N
        botonreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonresetActionPerformed(evt);
            }
        });
        add(botonreset);
        botonreset.setBounds(490, 600, 60, 70);

        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/info2.png"))); // NOI18N
        add(info);
        info.setBounds(30, 220, 200, 210);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/conectarES.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(-10, 0, 1030, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
       NavegadorFrames.navegarAtras();
       this.setVisible(false);
       this.frame.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
    }//GEN-LAST:event_jTextField1KeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (contador<6){
            if (español)
                JOptionPane.showMessageDialog(null,"Rellena todo antes de continuar","Pulsa en las plastilinas",JOptionPane.INFORMATION_MESSAGE);
            else if (ingles)
                JOptionPane.showMessageDialog(null,"Fill all before continue","Click on clays",JOptionPane.INFORMATION_MESSAGE);
        }else{
                NavegadorFrames.getInstance().navegarA(NavegadorFrames.ELEGIR_OPERACION);
                this.frame.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonmanzanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmanzanaActionPerformed
        String nombrePlasti = "amarilla";
       botonmanzana.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
            
    }//GEN-LAST:event_botonmanzanaActionPerformed

    private void botonplatanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonplatanoActionPerformed
       String nombrePlasti = "azul";
       botonplatano.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
    }//GEN-LAST:event_botonplatanoActionPerformed

    private void botonnaranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonnaranjaActionPerformed
        String nombrePlasti = "naranjaP";
       botonnaranja.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
    }//GEN-LAST:event_botonnaranjaActionPerformed

    private void botonkiwiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonkiwiActionPerformed
        String nombrePlasti = "morada";
       botonkiwi.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
    }//GEN-LAST:event_botonkiwiActionPerformed

    private void botonperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonperaActionPerformed
        String nombrePlasti = "verde";
       botonpera.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
    }//GEN-LAST:event_botonperaActionPerformed

    private void botonlimonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonlimonActionPerformed
         String nombrePlasti = "negra";
       botonlimon.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
        
    }//GEN-LAST:event_botonlimonActionPerformed

    private void botontomateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botontomateActionPerformed
        String nombrePlasti = "roja";
       botontomate.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
    }//GEN-LAST:event_botontomateActionPerformed

    private void botonberenjenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonberenjenaActionPerformed
        
          String nombrePlasti = "rosa";
       botonberenjena.setEnabled(false);
       plastiSeleccionada(nombrePlasti);
        
    }//GEN-LAST:event_botonberenjenaActionPerformed

    private void botonzanahoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonzanahoriaActionPerformed
      
        String nombrePlasti = "azulclaro";
       botonzanahoria.setEnabled(false);
       plastiSeleccionada(nombrePlasti);

    }//GEN-LAST:event_botonzanahoriaActionPerformed

    private void plastiSeleccionada(String nombrePlasti){
        
        listaI.add(contador, nombrePlasti);
        conf.getInterfazMakey().addTecla(contador, nombrePlasti);
        desactivaPlasti(nombrePlasti);
        contador++;
              
        //Si llega al maximo
        if(contador == Constantes.MAXIMO_TECLAS){
            botonmanzana.setEnabled(false);
            botonpera.setEnabled(false);
            botonkiwi.setEnabled(false);
            botonlimon.setEnabled(false);
            botonnaranja.setEnabled(false);
            botonplatano.setEnabled(false); 
            botontomate.setEnabled(false); 
            botonberenjena.setEnabled(false); 
            botonzanahoria.setEnabled(false);          
        }
        
    }
    
    private void desactivaPlasti(String nombrePlasti){
        JLabel etiquetaBoton = null;
        switch(contador){
            case 0:
                etiquetaBoton = left;
                break;
            case 1:
                etiquetaBoton = up;
                break;
            case 2:
                etiquetaBoton = click;
                break;
            case 3:
                etiquetaBoton = down;
                break;
            case 4:
                etiquetaBoton = right;
                break;
            case 5:
                etiquetaBoton = space;
                break;
            default:
                etiquetaBoton = left;
        }
        
        etiquetaBoton.setText("");
        etiquetaBoton.setIcon(new ImageIcon(getClass().getResource("/mathmaster/"+ nombrePlasti +".png")));
            
    }
            
            
    
    private void botonresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonresetActionPerformed
        contador=0;
        botonmanzana.setEnabled(true);
        botonpera.setEnabled(true);
        botonkiwi.setEnabled(true);
        botonlimon.setEnabled(true);
        botonnaranja.setEnabled(true);
        botonplatano.setEnabled(true);
        botontomate.setEnabled(true);
        botonberenjena.setEnabled(true);
        botonzanahoria.setEnabled(true);
        up.setIcon(null);
        left.setIcon(null);
        right.setIcon(null);
        down.setIcon(null);
        click.setIcon(null);
        space.setIcon(null);
        space.setIcon(null);
        up.setText("2");
        left.setText("1");
        right.setText("5");
        down.setText("4");
        click.setText("3");
        space.setText("6");
        listaI.clear();
    }//GEN-LAST:event_botonresetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonberenjena;
    private javax.swing.JButton botonkiwi;
    private javax.swing.JButton botonlimon;
    private javax.swing.JButton botonmanzana;
    private javax.swing.JButton botonnaranja;
    private javax.swing.JButton botonpera;
    private javax.swing.JButton botonplatano;
    private javax.swing.JButton botonreset;
    private javax.swing.JButton botontomate;
    private javax.swing.JButton botonzanahoria;
    private javax.swing.JLabel click;
    private javax.swing.JLabel down;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel left;
    private javax.swing.JLabel right;
    private javax.swing.JLabel space;
    private javax.swing.JLabel up;
    // End of variables declaration//GEN-END:variables
}
