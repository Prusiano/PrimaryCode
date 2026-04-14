package mathmaster;

import mathmaster.util.Alumno;
import mathmaster.util.NavegadorFrames;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import mathmaster.enumerados.InterfazMakey;
import mathmaster.enumerados.Lenguaje;
import mathmaster.util.Configurador;
import mathmaster.util.Constantes;
import java.util.Properties;
import java.util.List;


/**
 *
 * @author Ruben
 */
public class Main extends javax.swing.JFrame {
    private Configurador configuracion;
   
    int xsize,ysize;
    Dimension pantallaTamano; 
    
    public Main() {
        configuracion = Configurador.getInstance();
        this.setContentPane(new BackgroundPanel());
        this.setIconImage (new ImageIcon(getClass().getResource("/mathmaster/icono2.png")).getImage());
        initComponents();
        this.botonES.setToolTipText("Español");
        this.botonUK.setToolTipText("Inglés");
        this.botonfruta.setToolTipText("Jugamos con alimentos");
        this.botonplasti.setToolTipText("Jugamos con plastilina");
        this.setTitle("PrimaryCode");
        if (configuracion.isIngles()){
            this.interaccion.setText("Select Interaction");
            this.idioma.setText("Select Language");            
            botonEmpezar.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarUK.png")));
            botonEmpezar.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarpressUK.png")));
            botonEmpezar.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarselecUK.png")));
            botonSalir.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirUK.png")));
            botonSalir.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirpressUK.png")));
            botonSalir.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirselecUK.png")));
            titulo.setIcon(new ImageIcon(getClass().getResource("/mathmaster/tituloUK.png")));
            
            botonInvitado.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarUK.png")));
            botonInvitado.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarpressUK.png")));
            botonInvitado.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarselecUK.png")));
           
        }
        Toolkit tk = Toolkit.getDefaultToolkit();
        pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 
        xsize = ((int) tk.getScreenSize().getWidth());
        ysize = ((int) tk.getScreenSize().getHeight());
        this.setSize(1024, 720);
        this.setLocationRelativeTo(null);

        seleccionarIconosInterfazMakey(this.configuracion.getInterfazMakey());
        seleccionarIconosLenguaje(this.configuracion.getLang());
        
        
//        NewHibernateUtil hibernate = new NewHibernateUtil();
//        
//        List<mathmaster.util.Profesor> profesoresBd;
//        profesoresBd = hibernate.obtenerProfesores();
//        String listaProfesores = profesoresBd.toString();
//        
//        contenidoProfesores.setText(listaProfesores);
}       
  

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonEmpezar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonUK = new javax.swing.JButton();
        botonES = new javax.swing.JButton();
        botonfruta = new javax.swing.JButton();
        botonplasti = new javax.swing.JButton();
        interaccion = new javax.swing.JLabel();
        idioma = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonProfesor = new javax.swing.JButton();
        textoPortalProfesor = new javax.swing.JLabel();
        botonInvitado = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        botonEmpezar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonEmpezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonempezar.png"))); // NOI18N
        botonEmpezar.setBorder(null);
        botonEmpezar.setBorderPainted(false);
        botonEmpezar.setContentAreaFilled(false);
        botonEmpezar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEmpezar.setMaximumSize(new java.awt.Dimension(150, 100));
        botonEmpezar.setMinimumSize(new java.awt.Dimension(150, 100));
        botonEmpezar.setPreferredSize(new java.awt.Dimension(150, 100));
        botonEmpezar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonempezarpress.png"))); // NOI18N
        botonEmpezar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonempezarselec.png"))); // NOI18N
        botonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpezarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEmpezar);
        botonEmpezar.setBounds(360, 450, 160, 90);

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonsalir.png"))); // NOI18N
        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSalir.setPreferredSize(new java.awt.Dimension(150, 100));
        botonSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonsalirpress.png"))); // NOI18N
        botonSalir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonsalirselec.png"))); // NOI18N
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir);
        botonSalir.setBounds(560, 450, 160, 90);

        botonUK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/ukflag.png"))); // NOI18N
        botonUK.setToolTipText("");
        botonUK.setBorder(null);
        botonUK.setContentAreaFilled(false);
        botonUK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonUK.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/ukflagpress.png"))); // NOI18N
        botonUK.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/ukflagselec.png"))); // NOI18N
        botonUK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUKActionPerformed(evt);
            }
        });
        getContentPane().add(botonUK);
        botonUK.setBounds(890, 70, 46, 30);

        botonES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/esflag.png"))); // NOI18N
        botonES.setToolTipText("");
        botonES.setBorder(null);
        botonES.setContentAreaFilled(false);
        botonES.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonES.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/esflagpress.png"))); // NOI18N
        botonES.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/esflagselec.png"))); // NOI18N
        botonES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonESActionPerformed(evt);
            }
        });
        getContentPane().add(botonES);
        botonES.setBounds(810, 70, 46, 30);

        botonfruta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fruta.png"))); // NOI18N
        botonfruta.setToolTipText("");
        botonfruta.setContentAreaFilled(false);
        botonfruta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/frutapress.png"))); // NOI18N
        botonfruta.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/frutaselec.png"))); // NOI18N
        botonfruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonfrutaActionPerformed(evt);
            }
        });
        getContentPane().add(botonfruta);
        botonfruta.setBounds(800, 160, 67, 50);

        botonplasti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plasti.png"))); // NOI18N
        botonplasti.setToolTipText("");
        botonplasti.setContentAreaFilled(false);
        botonplasti.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plastipress.png"))); // NOI18N
        botonplasti.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plastiselec.png"))); // NOI18N
        botonplasti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonplastiActionPerformed(evt);
            }
        });
        getContentPane().add(botonplasti);
        botonplasti.setBounds(880, 160, 60, 60);

        interaccion.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        interaccion.setText("Selecciona Interacción");
        getContentPane().add(interaccion);
        interaccion.setBounds(810, 140, 170, 20);

        idioma.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        idioma.setText("Selecciona Idioma");
        getContentPane().add(idioma);
        idioma.setBounds(820, 40, 170, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/titulo_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 60, 620, 120);

        botonProfesor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/profesor.png"))); // NOI18N
        botonProfesor.setBorderPainted(false);
        botonProfesor.setContentAreaFilled(false);
        botonProfesor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonProfesor.setPreferredSize(new java.awt.Dimension(155, 105));
        botonProfesor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/profesorpres.png"))); // NOI18N
        botonProfesor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/profesorselec.png"))); // NOI18N
        botonProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProfesorActionPerformed(evt);
            }
        });
        getContentPane().add(botonProfesor);
        botonProfesor.setBounds(820, 560, 160, 100);

        textoPortalProfesor.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        textoPortalProfesor.setText("Acceder a portal profesor");
        textoPortalProfesor.setToolTipText("");
        getContentPane().add(textoPortalProfesor);
        textoPortalProfesor.setBounds(820, 670, 160, 14);

        botonInvitado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonProbar.png"))); // NOI18N
        botonInvitado.setBorder(null);
        botonInvitado.setBorderPainted(false);
        botonInvitado.setContentAreaFilled(false);
        botonInvitado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonProbarpress.png"))); // NOI18N
        botonInvitado.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonProbarselec.png"))); // NOI18N
        botonInvitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInvitadoActionPerformed(evt);
            }
        });
        getContentPane().add(botonInvitado);
        botonInvitado.setBounds(460, 560, 160, 90);

        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/titulo.png"))); // NOI18N
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        getContentPane().add(titulo);
        titulo.setBounds(260, 130, 540, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        int choice = 0;
                if (configuracion.isIngles()){
                    choice = JOptionPane.showOptionDialog(null, "¿Do you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                }else if (configuracion.isEspanol()){
                    choice = JOptionPane.showOptionDialog(null, "¿Quieres salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                }
        if (choice == JOptionPane.YES_OPTION){
            //baseDatos.escribirFichero();
            System.exit(0);
        }else
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void elegirAlumno(){
        JTextField campoNombre = new JTextField(10);
      JTextField campoApellido = new JTextField(10);
      JPanel pPanel = new JPanel();
      if(configuracion.isIngles())
          pPanel.add(new JLabel("Name: "));
      else
        pPanel.add(new JLabel("Nombre: "));
      pPanel.add(campoNombre);
      
      if(configuracion.isIngles())
          pPanel.add(new JLabel("Last Name: "));
      else 
        pPanel.add(new JLabel("Apellido: "));
        
      pPanel.add(campoApellido);
       
      int result=0;
       if(configuracion.isIngles())
        result = JOptionPane.showConfirmDialog(this,pPanel,"Input your Name and Last Name",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
      else
        result = JOptionPane.showConfirmDialog(this,pPanel,"Escribe tu Nombre y Apellido",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
       
      if (result == JOptionPane.OK_OPTION){
          String nombre = campoNombre.getText();
          String apellido = campoApellido.getText();
          if((nombre.equalsIgnoreCase("")) || (apellido.equalsIgnoreCase(""))){
               if(configuracion.isIngles())
                JOptionPane.showMessageDialog(null,"Input a valid name and last name","Error",JOptionPane.INFORMATION_MESSAGE);
              else
                JOptionPane.showMessageDialog(null,"Escribe un Nombre y Apellido valido","Error",JOptionPane.INFORMATION_MESSAGE);
          }else{
            if (configuracion.getBaseDatos().buscarAlumno(nombre, apellido)){
                 if(configuracion.isIngles())
                    JOptionPane.showMessageDialog(null,"User found","Correct",JOptionPane.INFORMATION_MESSAGE);
                else 
                    JOptionPane.showMessageDialog(null,"Usuario encontrado","Correcto",JOptionPane.INFORMATION_MESSAGE);
                
                int progreso=configuracion.getBaseDatos().devolverProgreso(nombre, apellido);
                int contador=configuracion.getBaseDatos().devolverContador(nombre, apellido);
                int puntos = configuracion.getBaseDatos().devolverPuntos(nombre, apellido);
                Alumno alumnoElegido = new Alumno(nombre,apellido,progreso,contador,puntos);
                configuracion.setAlumnoActual(alumnoElegido);
                
                NavegadorFrames.navegarA(NavegadorFrames.ELEGIR_MODO);
                this.setVisible(false);
             }else{
                    Alumno alumnoElegido = new Alumno(nombre,apellido,0,configuracion.getBaseDatos().getContador(),0);
                    configuracion.getBaseDatos().añadirAlumno(alumnoElegido);
                    configuracion.setAlumnoActual(alumnoElegido);
                    NavegadorFrames.navegarA(NavegadorFrames.ELEGIR_MODO);
                    this.setVisible(false);
              }
          }
      }
      configuracion.getBaseDatos().leerFichero();
      configuracion.getBaseDatos().escribirFichero();
    }
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        int choice = JOptionPane.showOptionDialog(null, "¿Quieres salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (choice == JOptionPane.YES_OPTION){
            //baseDatos.escribirFichero();
            System.exit(0);
        }else
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void seleccionarIconosLenguaje(Lenguaje elegido){
        this.configuracion.setLang(elegido);
        
        if(elegido.equals(Lenguaje.INGLES)){
            botonES.setIcon(new ImageIcon(getClass().getResource("/mathmaster/esflagbn.png")));
            botonUK.setIcon(new ImageIcon(getClass().getResource("/mathmaster/ukflag.png")));
        }else{
            botonES.setIcon(new ImageIcon(getClass().getResource("/mathmaster/esflag.png")));
            botonUK.setIcon(new ImageIcon(getClass().getResource("/mathmaster/ukflagbn.png")));
        }
        
    }
    private void botonUKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUKActionPerformed
        
        seleccionarIconosLenguaje(Lenguaje.INGLES);
        
        this.interaccion.setText("Select Interaction");
        this.idioma.setText("Select Language");
        botonES.setToolTipText("Spanish");
        botonUK.setToolTipText("English");
        botonfruta.setToolTipText("We play with food");
        botonplasti.setToolTipText("We play with clay");
        
        botonEmpezar.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarUK.png")));
        botonEmpezar.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarpressUK.png")));
        botonEmpezar.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarselecUK.png")));
        botonSalir.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirUK.png")));
        botonSalir.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirpressUK.png")));
        botonSalir.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirselecUK.png")));
        titulo.setIcon(new ImageIcon(getClass().getResource("/mathmaster/tituloUK.png")));
        
        botonProfesor.setIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorUK.png")));
        botonProfesor.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorpressUK.png")));
        botonProfesor.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorselecUK.png")));
        
         botonInvitado.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarUK.png")));
            botonInvitado.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarpressUK.png")));
            botonInvitado.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarselecUK.png")));
          
        this.textoPortalProfesor.setText("Access to teachers portal");
        
        this.configuracion.setLang(Lenguaje.INGLES);
    }//GEN-LAST:event_botonUKActionPerformed

    private void botonESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonESActionPerformed
        
        seleccionarIconosLenguaje(Lenguaje.ESPANOL);
        
        this.interaccion.setText("Selecciona Interacción");
        this.idioma.setText("Selecciona Idioma");
        botonES.setToolTipText("Español");
        botonUK.setToolTipText("Inglés");
        botonfruta.setToolTipText("Jugamos con alimentos");
        botonplasti.setToolTipText("Jugamos con plastilina");
       
        botonEmpezar.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezar.png")));
        botonEmpezar.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarpress.png")));
        botonEmpezar.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonempezarselec.png")));
        botonSalir.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalir.png")));
        botonSalir.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirpress.png")));
        botonSalir.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonsalirselec.png")));
        titulo.setIcon(new ImageIcon(getClass().getResource("/mathmaster/titulo.png")));
         
        botonProfesor.setIcon(new ImageIcon(getClass().getResource("/mathmaster/profesor.png")));
        botonProfesor.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorpres.png")));
        botonProfesor.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorselec.png")));
        
         botonInvitado.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbar.png")));
            botonInvitado.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarpress.png")));
            botonInvitado.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonProbarselec.png")));
          
            
        this.textoPortalProfesor.setText("Acceso a portal profesor");
        
        this.configuracion.setLang(Lenguaje.ESPANOL);
    }//GEN-LAST:event_botonESActionPerformed

    private void seleccionarIconosInterfazMakey(InterfazMakey seleccionado){
        
        this.configuracion.setInterfazMakey(seleccionado);
         
        if(seleccionado.equals(InterfazMakey.FRUTAS)){   
            botonfruta.setIcon(new ImageIcon(getClass().getResource("/imagenes/fruta.png")));
            botonplasti.setIcon(new ImageIcon(getClass().getResource("/imagenes/plastibn.png")));
        }else{
            botonfruta.setIcon(new ImageIcon(getClass().getResource("/imagenes/frutabn.png")));
            botonplasti.setIcon(new ImageIcon(getClass().getResource("/imagenes/plasti.png")));
        }
        
    }
    private void botonfrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonfrutaActionPerformed
       seleccionarIconosInterfazMakey(InterfazMakey.FRUTAS);
        
    }//GEN-LAST:event_botonfrutaActionPerformed

    private void botonplastiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonplastiActionPerformed
        seleccionarIconosInterfazMakey(InterfazMakey.PLASTILINA);
    }//GEN-LAST:event_botonplastiActionPerformed

    private void botonProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProfesorActionPerformed
        JPasswordField campoContrasena = new JPasswordField(10);
        JPanel pPanel = new JPanel();
        if(this.configuracion.isIngles())
            pPanel.add(new JLabel("Please enter the password: "));
        else if (this.configuracion.isEspanol())
            pPanel.add(new JLabel("Por favor escriba la contraseña: "));
        pPanel.add(campoContrasena);

        int result=0;
        if(this.configuracion.isIngles())
            result = JOptionPane.showConfirmDialog(this,pPanel,"Input the password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        else if(this.configuracion.isEspanol())
            result = JOptionPane.showConfirmDialog(this,pPanel,"Escribe la contraseña",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        
        if (result == JOptionPane.OK_OPTION){
            String contrasena = String.valueOf(campoContrasena.getPassword());
            if(contrasena.equalsIgnoreCase(Constantes.PASSWORD)){
                NavegadorFrames.navegarA(NavegadorFrames.PROFESOR);
                this.setVisible(false);
            }else {
                if(this.configuracion.isIngles())
                JOptionPane.showMessageDialog(pPanel, "Wrong password");
                else if(this.configuracion.isEspanol())
                JOptionPane.showMessageDialog(pPanel, "Contraseña Incorrecta");
            }
        }
    }//GEN-LAST:event_botonProfesorActionPerformed

    private void botonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpezarActionPerformed
        if ((!configuracion.isFruta())&&(!configuracion.isPlasti())){
            if (configuracion.isIngles())
            JOptionPane.showMessageDialog(null, "Select an object before start");
            else
            JOptionPane.showMessageDialog(null, "Elige un objeto de arriba antes de empezar");

        }else{
            elegirAlumno();

        }
    }//GEN-LAST:event_botonEmpezarActionPerformed

    private void botonInvitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInvitadoActionPerformed

        Alumno invitado = new Alumno("Invitado", "", 0, 0, 0);
        Configurador.getInstance().setAlumnoActual(invitado);
        NavegadorFrames.navegarA(NavegadorFrames.ELEGIR_MODO);
        this.setVisible(false);
    }//GEN-LAST:event_botonInvitadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

//        NewHibernateUtil hibernate = new NewHibernateUtil();
//        
//        mathmaster.util.Profesor profeDiego = new mathmaster.util.Profesor();
//        profeDiego.setNombre("Diegoch"+LocalDateTime.now().toString());
//        profeDiego.setEmail("diego.digionantonio@gmail.com");
//        profeDiego.setPin("6875u");
//        profeDiego.setFechaAlta(LocalDateTime.now());
//        
////        hibernate.insertarProfesor(profeDiego);
//        
//        List<mathmaster.util.Profesor> profesoresBd;
//        profesoresBd = hibernate.obtenerProfesores();
//        System.out.println("Los profes son: " + profesoresBd);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonES;
    private javax.swing.JButton botonEmpezar;
    private javax.swing.JButton botonInvitado;
    private javax.swing.JButton botonProfesor;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonUK;
    private javax.swing.JButton botonfruta;
    private javax.swing.JButton botonplasti;
    private javax.swing.JLabel idioma;
    private javax.swing.JLabel interaccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel textoPortalProfesor;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
 class BackgroundPanel extends JPanel {
     
    private Image image;
     
    public BackgroundPanel() {
        MediaTracker tracker=new MediaTracker(this);
        image=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/mathmaster/fondo3.png"));
        tracker.addImage(this.image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (image != null)
          g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }
 }
