package mathmaster;

import mathmaster.util.Alumno;
import mathmaster.util.BaseDatos;
import mathmaster.util.NavegadorFrames;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import mathmaster.util.Configurador;

public class ElegirOpcion extends javax.swing.JPanel {
    private BaseDatos baseDatos = new BaseDatos();
    private JFrame frame;
    private Alumno alumno;
    private Image image;
    private boolean ingles,español,fruta,plasti;
    int xsize,ysize;
    Dimension pantallaTamano; 
    
    public ElegirOpcion (JFrame f) {
        this.frame=f;
        Configurador c = Configurador.getInstance();
        
        this.alumno = c.getAlumnoActual();
        this.ingles = c.isIngles();
        this.español = c.isEspanol();
        this.fruta = c.isFruta();
        this.plasti = c.isPlasti();
        this.baseDatos = c.getBaseDatos();
        
        baseDatos.leerFichero();
//        this.baseDatos=bDatos;
        pintaFondo();        
        initComponents();
        if (ingles){
            frame.setTitle("Choose an option");
            titulo.setIcon(new ImageIcon(getClass().getResource("/mathmaster/titulo2UK.png")));
            botonAlumno.setIcon(new ImageIcon(getClass().getResource("/mathmaster/alumnoUK.png")));
            botonAlumno.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/alumnopressUK.png")));
            botonAlumno.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/alumnoselecUK.png")));
            botonProfesor.setIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorUK.png")));
            botonProfesor.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorpressUK.png")));
            botonProfesor.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/profesorselecUK.png")));
        }
        Toolkit tk = Toolkit.getDefaultToolkit();
        xsize = ((int) tk.getScreenSize().getWidth());
        ysize = ((int) tk.getScreenSize().getHeight());
//        int distancia=0;        
//        distancia=xsize/2-titulo.getLocation().x;
//        titulo.setLocation(distancia,titulo.getLocation().y);
//        botonAlumno.setLocation(distancia,botonAlumno.getLocation().y);
//        botonProfesor.setLocation(distancia,botonProfesor.getLocation().y);
//        botonAtras.setLocation(distancia,botonAtras.getLocation().y);
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

        botonProfesor = new javax.swing.JButton();
        botonAlumno = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

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
        add(botonProfesor);
        botonProfesor.setBounds(240, 320, 183, 109);

        botonAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/alumno.png"))); // NOI18N
        botonAlumno.setBorderPainted(false);
        botonAlumno.setContentAreaFilled(false);
        botonAlumno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAlumno.setPreferredSize(new java.awt.Dimension(155, 105));
        botonAlumno.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/alumnopres.png"))); // NOI18N
        botonAlumno.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/alumnoselec.png"))); // NOI18N
        botonAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlumnoActionPerformed(evt);
            }
        });
        add(botonAlumno);
        botonAlumno.setBounds(580, 320, 183, 109);

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
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/titulo2.png"))); // NOI18N
        add(titulo);
        titulo.setBounds(210, 160, 580, 80);
    }// </editor-fold>//GEN-END:initComponents
   
    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        this.frame.dispose();
        new Main().setVisible(true); 
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProfesorActionPerformed
      JPasswordField campoContraseña = new JPasswordField(10);
      JPanel pPanel = new JPanel();
      if(ingles)
        pPanel.add(new JLabel("Please enter the password: "));
      else if (español)
        pPanel.add(new JLabel("Por favor escriba la contraseña: "));
      pPanel.add(campoContraseña);
       
      int result=0;
      if(ingles)
          result = JOptionPane.showConfirmDialog(this,pPanel,"Input the password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
      else if(español)
        result = JOptionPane.showConfirmDialog(this,pPanel,"Escribe la contraseña",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
      if (result == JOptionPane.OK_OPTION){
         String contraseña = String.valueOf(campoContraseña.getPassword());
            if(contraseña.equalsIgnoreCase("1234")){
                NavegadorFrames.navegarA(NavegadorFrames.PROFESOR);
                this.frame.dispose();
            }else {
                if(ingles)
                    JOptionPane.showMessageDialog(pPanel, "Wrong password");
                else if(español)
                    JOptionPane.showMessageDialog(pPanel, "Contraseña Incorrecta");
            }
      }
    }//GEN-LAST:event_botonProfesorActionPerformed

    
    private void botonAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlumnoActionPerformed
      JTextField campoNombre = new JTextField(10);
      JTextField campoApellido = new JTextField(10);
      JPanel pPanel = new JPanel();
      if(ingles)
          pPanel.add(new JLabel("Name: "));
      else if(español)
        pPanel.add(new JLabel("Nombre: "));
      pPanel.add(campoNombre);
      if(ingles)
          pPanel.add(new JLabel("Last Name: "));
      else if(español)
        pPanel.add(new JLabel("Apellido: "));
      pPanel.add(campoApellido);
       
      int result=0;
      if(ingles)
        result = JOptionPane.showConfirmDialog(this,pPanel,"Input your Name and Last Name",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
      else if(español)
        result = JOptionPane.showConfirmDialog(this,pPanel,"Escribe tu Nombre y Apellido",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
      if (result == JOptionPane.OK_OPTION){
          String nombre = campoNombre.getText();
          String apellido = campoApellido.getText();
          if((nombre.equalsIgnoreCase("")) || (apellido.equalsIgnoreCase(""))){
              if(ingles)
                JOptionPane.showMessageDialog(null,"Input a valid name and last name","Error",JOptionPane.INFORMATION_MESSAGE);
              else if(español)
                JOptionPane.showMessageDialog(null,"Escribe un Nombre y Apellido valido","Error",JOptionPane.INFORMATION_MESSAGE);
          }else{
            if (baseDatos.buscarAlumno(nombre, apellido)){
                if(ingles)
                    JOptionPane.showMessageDialog(null,"User found","Correct",JOptionPane.INFORMATION_MESSAGE);
                else if(español)
                    JOptionPane.showMessageDialog(null,"Usuario encontrado","Correcto",JOptionPane.INFORMATION_MESSAGE);
                
                int progreso=baseDatos.devolverProgreso(nombre, apellido);
                int contador=baseDatos.devolverContador(nombre, apellido);
                int puntos = baseDatos.devolverPuntos(nombre, apellido);
                Alumno alumnoElegido = new Alumno(nombre,apellido,progreso,contador,puntos);
                this.alumno = alumnoElegido;
                
                Configurador.getInstance().setConfiguracion(this.alumno, this.baseDatos, this.español, this.ingles, this.fruta, this.plasti);
              //  NavegadorFrames.getInstance().navegarAElegirModo(this.frame);
                //TODO: Llevar lógica a ElegirModo, y hacer sólo si seleccionan MakeyMakey
//                 JFrame ventanaElegirModo = new JFrame();
//                ElegirModo elegirModo = new ElegirModo(ventanaElegirModo, this.baseDatos, this.alumno, this.ingles, this.español, this.fruta, this.plasti, null);
//                ventanaElegirModo.setContentPane(elegirModo);
//                ventanaElegirModo.setTitle("PrimaryCode");
//                ventanaElegirModo.setSize(1024, 720);
//                ventanaElegirModo.setLocationRelativeTo(null);
//                ventanaElegirModo.setResizable(false);
//                ventanaElegirModo.setVisible(true);
//                this.frame.dispose();
//                if(fruta){
//                    JFrame ventanaPF = new JFrame();
//                    PreviaFrutas pf = new PreviaFrutas(ventanaPF,baseDatos,alumnoElegido,ingles,español,fruta,plasti);
//                    ventanaPF.setContentPane(pf);
//                    ventanaPF.setTitle("PrimaryCode");
//                    ventanaPF.setSize(1024, 720);
//                    ventanaPF.setLocationRelativeTo(null);
//                    ventanaPF.setResizable(false);
//                    ventanaPF.setVisible(true);
//                    this.frame.dispose();
//                }else if (plasti){
//                    JFrame ventanaPP = new JFrame();
//                    PreviaPlasti pp = new PreviaPlasti(ventanaPP,baseDatos,alumnoElegido,ingles,español,fruta,plasti);
//                    ventanaPP.setContentPane(pp);
//                    ventanaPP.setTitle("PrimaryCode");
//                    ventanaPP.setSize(1024, 720);
//                    ventanaPP.setLocationRelativeTo(null);
//                    ventanaPP.setResizable(false);
//                    ventanaPP.setVisible(true);
//                    this.frame.dispose();
//                    }
             }else{
                    Alumno alumnoElegido = new Alumno(nombre,apellido,0,baseDatos.getContador(),0);
                    baseDatos.añadirAlumno(alumnoElegido);
                    this.alumno = alumnoElegido;
                //   NavegadorFrames.getInstance().navegarAElegirModo(this.frame);
                    //TODO: llevar a ElegirModo solo si pincha en Makey Makey
//                    if(fruta){
//                        JFrame ventanaPF = new JFrame();
//                        PreviaFrutas pf = new PreviaFrutas(ventanaPF,baseDatos,a,ingles,español,fruta,plasti);
//                        ventanaPF.setContentPane(pf);
//                        ventanaPF.setTitle("PrimaryCode");
//                        ventanaPF.setSize(1024, 720);
//                        ventanaPF.setLocationRelativeTo(null);
//                        ventanaPF.setResizable(false);
//                        ventanaPF.setVisible(true);
//                        this.frame.dispose();
//                    }else if (plasti){
//                        JFrame ventanaPP = new JFrame();
//                        PreviaPlasti pp = new PreviaPlasti(ventanaPP,baseDatos,a,ingles,español,fruta,plasti);
//                        ventanaPP.setContentPane(pp);
//                        ventanaPP.setTitle("PrimaryCode");
//                        ventanaPP.setSize(1024, 720);
//                        ventanaPP.setLocationRelativeTo(null);
//                        ventanaPP.setResizable(false);
//                        ventanaPP.setVisible(true);
//                        this.frame.dispose();
//                    }
              }
          }
      }
      baseDatos.leerFichero();
      baseDatos.escribirFichero();
    }//GEN-LAST:event_botonAlumnoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlumno;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonProfesor;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
