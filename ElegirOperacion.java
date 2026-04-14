package mathmaster;

import mathmaster.info.Info;
import mathmaster.info.Info2;
import mathmaster.info.Info2UK;
import mathmaster.info.InfoUK;
import mathmaster.util.Alumno;
import mathmaster.util.Fuente;
import mathmaster.util.BaseDatos;
import mathmaster.condicionales.Condicionales1;
import mathmaster.io.ES1;
import mathmaster.util.NavegadorFrames;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mathmaster.bucles.Bucles1;
import mathmaster.ficheros.DefinicionFicheros;
import mathmaster.ficheros.Ficheros;
import mathmaster.ficheros.Ficheros1;
import mathmaster.funciones.Funciones1;
import mathmaster.recursividad.Recursividad1;
import mathmaster.util.Configurador;

public class ElegirOperacion extends javax.swing.JPanel {
    private BaseDatos baseDatos;
    private JFrame frame;
    private Alumno alumno;
    private Image image;
    private ArrayList<String>listaI;
    private boolean ingles,español,fruta,plasti,raton;
    private Configurador conf;
    
    public ElegirOperacion (JFrame f) {
        Font myFont = Fuente.getFont(Fuente.CUSTOM1, Font.BOLD, 30);
        this.frame=f;
        conf = Configurador.getInstance();
        this.baseDatos = conf.getBaseDatos();
        this.alumno=conf.getAlumnoActual();
        this.ingles=conf.isIngles();
        this.español=conf.isEspanol();
        this.fruta=conf.isFruta();
        this.plasti=conf.isPlasti();
        this.listaI = (ArrayList<String>) conf.getInterfazMakey().getTeclas();
        this.raton=conf.isRaton();
        pintaFondo();
        initComponents();
        
        if(hola != null){
            hola.setFont(myFont);
            hola.setText("Hola "+ alumno.getNombre());
            
        }
        
        postConstruct(f);
    }
    
    @Deprecated
    public ElegirOperacion (JFrame f, BaseDatos bDatos, Alumno a,boolean uk,boolean es, boolean fr, boolean p,ArrayList<String> lI,boolean raton) {
        Font myFont = Fuente.getFont(Fuente.CUSTOM1, Font.BOLD, 30);
        this.frame=f;
        this.baseDatos = bDatos;
        this.alumno=a;
        this.ingles=uk;
        this.español=es;
        this.fruta=fr;
        this.plasti=p;
        this.listaI=lI;
        this.raton=raton;
        pintaFondo();
        initComponents();
        hola.setFont(myFont);
        hola.setText("Hola "+ a.getNombre());
        
        postConstruct(f);

    }
    
     //TODO: mover al constructor cuando las llamadas al constructor viejo estén refactorizadas
    private void postConstruct(JFrame f){
         if(raton){
            interaccion.setIcon(new ImageIcon(getClass().getResource("/mathmaster/interaccionR.png")));
        }else{
            interaccion.setIcon(new ImageIcon(getClass().getResource("/mathmaster/interaccionM.png")));
        }
         if (ingles){
            textoRecursividad.setText("Function");
            linea1.setText("add (a, b) {");
            frame.setTitle("Choose an option ");
            textoInteraccion.setText("Interacting with");
            botonArrays.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonArrays.png")));
            botonArrays.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonArrayspressES.png")));
            botonArrays.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonArraysselecES.png")));
            botonES.setIcon(new ImageIcon(getClass().getResource("/imagenes/botonESUK.png")));
            botonES.setPressedIcon(new ImageIcon(getClass().getResource("/imagenes/botonESpressUK.png")));
            botonES.setSelectedIcon(new ImageIcon(getClass().getResource("/imagenes/botonESselecUK.png")));
            botonCond.setIcon(new ImageIcon(getClass().getResource("/imagenes/botonCondicionalUK.png")));
            botonCond.setPressedIcon(new ImageIcon(getClass().getResource("/imagenes/botonCondicionalpressUK.png")));
            botonCond.setSelectedIcon(new ImageIcon(getClass().getResource("/imagenes/botonCondicionalselecUK.png")));         
            botonBucles1.setIcon(new ImageIcon(getClass().getResource("/mathmaster/botonbuclesUK.png")));
            botonBucles1.setPressedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonbuclespressUK.png")));
            botonBucles1.setSelectedIcon(new ImageIcon(getClass().getResource("/mathmaster/botonbuclesselecUK.png")));
            botonRecursividad.setIcon(new ImageIcon(getClass().getResource("/imagenes/botonRecursividadUK.png")));
            botonRecursividad.setPressedIcon(new ImageIcon(getClass().getResource("/imagenes/botonRecursividadPressUK.png")));
            botonRecursividad.setSelectedIcon(new ImageIcon(getClass().getResource("/imagenes/botonRecursividadSeleccUK.png")));
            botonFicheros.setIcon(new ImageIcon(getClass().getResource("/imagenes/botonFicherosUK.png")));
            botonFicheros.setPressedIcon(new ImageIcon(getClass().getResource("/imagenes/botonFicherosPressUK.png")));
            botonFicheros.setSelectedIcon(new ImageIcon(getClass().getResource("/imagenes/botonFicherosSeleccUK.png")));
            botonFunciones.setIcon(new ImageIcon(getClass().getResource("/imagenes/funcionesEN.png")));
            botonFunciones.setPressedIcon(new ImageIcon(getClass().getResource("/imagenes/funcionesPressEN.png")));
            botonFunciones.setSelectedIcon(new ImageIcon(getClass().getResource("/imagenes/funcionesSelEN.png")));
            
            if(hola != null){
                hola.setText("Hi "+ alumno.getNombre());
            }
            
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

        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        botonES = new javax.swing.JButton();
        botonArrays = new javax.swing.JButton();
        botonCond = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        info = new javax.swing.JButton();
        hola = new javax.swing.JLabel();
        textoInteraccion = new javax.swing.JLabel();
        interaccion = new javax.swing.JLabel();
        botonBucles1 = new javax.swing.JButton();
        numero4 = new javax.swing.JLabel();
        numero1 = new javax.swing.JLabel();
        numero2 = new javax.swing.JLabel();
        numero3 = new javax.swing.JLabel();
        botonFunciones = new javax.swing.JButton();
        numero5 = new javax.swing.JLabel();
        botonFicheros = new javax.swing.JButton();
        numero6 = new javax.swing.JLabel();
        botonRecursividad = new javax.swing.JButton();
        numero7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textoRecursividad = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        linea2 = new javax.swing.JLabel();
        linea3 = new javax.swing.JLabel();
        linea1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conjuntoPequeño.png"))); // NOI18N
        add(jLabel11);
        jLabel11.setBounds(440, 410, 190, 120);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cajaFrutasPequeña.PNG"))); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(200, 420, 140, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/bucle2.png"))); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(820, 190, 100, 100);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonIn.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonInpress.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonInselec.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(320, 80, 40, 40);

        botonES.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonESES.png"))); // NOI18N
        botonES.setBorderPainted(false);
        botonES.setContentAreaFilled(false);
        botonES.setPreferredSize(new java.awt.Dimension(155, 105));
        botonES.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonESpressES.png"))); // NOI18N
        botonES.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonESselecES.png"))); // NOI18N
        botonES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonESActionPerformed(evt);
            }
        });
        add(botonES);
        botonES.setBounds(120, 140, 189, 140);

        botonArrays.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonArrays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonArrays.png"))); // NOI18N
        botonArrays.setBorderPainted(false);
        botonArrays.setContentAreaFilled(false);
        botonArrays.setPreferredSize(new java.awt.Dimension(155, 105));
        botonArrays.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonArrayspressES.png"))); // NOI18N
        botonArrays.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonArraysselecES.png"))); // NOI18N
        botonArrays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArraysActionPerformed(evt);
            }
        });
        add(botonArrays);
        botonArrays.setBounds(120, 330, 190, 140);

        botonCond.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonCond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonCondicionalES.png"))); // NOI18N
        botonCond.setBorderPainted(false);
        botonCond.setContentAreaFilled(false);
        botonCond.setPreferredSize(new java.awt.Dimension(155, 105));
        botonCond.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonCondicionalpressES.png"))); // NOI18N
        botonCond.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonCondicionalselecES.png"))); // NOI18N
        botonCond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCondActionPerformed(evt);
            }
        });
        add(botonCond);
        botonCond.setBounds(420, 140, 160, 140);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atras2.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setPreferredSize(new java.awt.Dimension(55, 55));
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atraspres.png"))); // NOI18N
        jButton5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/atrasselec.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(480, 550, 83, 59);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/titulo3.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(270, 50, 480, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/bucle.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(690, 100, 100, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/teclado.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(190, 240, 130, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/monitor.png"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(100, 140, 90, 80);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/interrogante.png"))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(380, 140, 90, 70);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/mayorigual.png"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(530, 200, 100, 90);

        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/info2_1.png"))); // NOI18N
        info.setContentAreaFilled(false);
        info.setFocusable(false);
        info.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/info3pres.png"))); // NOI18N
        info.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/info3sel.png"))); // NOI18N
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        add(info);
        info.setBounds(770, 60, 80, 70);
        add(hola);
        hola.setBounds(90, 30, 240, 40);

        textoInteraccion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        textoInteraccion.setText("Interaccionando con");
        add(textoInteraccion);
        textoInteraccion.setBounds(90, 80, 160, 40);
        add(interaccion);
        interaccion.setBounds(230, 70, 90, 60);

        botonBucles1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBucles1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonbuclesES.png"))); // NOI18N
        botonBucles1.setBorderPainted(false);
        botonBucles1.setContentAreaFilled(false);
        botonBucles1.setPreferredSize(new java.awt.Dimension(155, 105));
        botonBucles1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonbuclespressES.png"))); // NOI18N
        botonBucles1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonbuclesselecES.png"))); // NOI18N
        botonBucles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBucles1ActionPerformed(evt);
            }
        });
        add(botonBucles1);
        botonBucles1.setBounds(700, 140, 190, 140);

        numero4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/numero4.png"))); // NOI18N
        add(numero4);
        numero4.setBounds(110, 430, 60, 60);

        numero1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/numero1.png"))); // NOI18N
        add(numero1);
        numero1.setBounds(110, 240, 60, 60);

        numero2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/numero2.png"))); // NOI18N
        add(numero2);
        numero2.setBounds(410, 250, 60, 60);

        numero3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/numero3.png"))); // NOI18N
        add(numero3);
        numero3.setBounds(700, 250, 60, 60);

        botonFunciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonFunciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonfuncionesES.png"))); // NOI18N
        botonFunciones.setBorderPainted(false);
        botonFunciones.setContentAreaFilled(false);
        botonFunciones.setPreferredSize(new java.awt.Dimension(155, 105));
        botonFunciones.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonfuncionesPressES.png"))); // NOI18N
        botonFunciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/botonfuncionesSelES.png"))); // NOI18N
        botonFunciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFuncionesActionPerformed(evt);
            }
        });
        add(botonFunciones);
        botonFunciones.setBounds(710, 340, 190, 140);

        numero5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/numero5.png"))); // NOI18N
        add(numero5);
        numero5.setBounds(410, 440, 60, 60);

        botonFicheros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonFicheros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonFicherosES.png"))); // NOI18N
        botonFicheros.setBorderPainted(false);
        botonFicheros.setContentAreaFilled(false);
        botonFicheros.setPreferredSize(new java.awt.Dimension(155, 105));
        botonFicheros.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonFicherosPressES.png"))); // NOI18N
        botonFicheros.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonFicherosSeleccES.png"))); // NOI18N
        botonFicheros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFicherosActionPerformed(evt);
            }
        });
        add(botonFicheros);
        botonFicheros.setBounds(410, 340, 190, 140);

        numero6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/numero6.png"))); // NOI18N
        add(numero6);
        numero6.setBounds(700, 440, 60, 60);

        botonRecursividad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonRecursividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRecursividadES.png"))); // NOI18N
        botonRecursividad.setBorderPainted(false);
        botonRecursividad.setContentAreaFilled(false);
        botonRecursividad.setPreferredSize(new java.awt.Dimension(155, 105));
        botonRecursividad.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRecursividadPressES.png"))); // NOI18N
        botonRecursividad.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRecursividadSeleccES.png"))); // NOI18N
        botonRecursividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRecursividadActionPerformed(evt);
            }
        });
        add(botonRecursividad);
        botonRecursividad.setBounds(130, 510, 190, 140);

        numero7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathmaster/numero7.png"))); // NOI18N
        add(numero7);
        numero7.setBounds(110, 610, 60, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechaRecursividad.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(-60, 490, 400, 330);

        textoRecursividad.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        textoRecursividad.setText("Funcion");
        add(textoRecursividad);
        textoRecursividad.setBounds(340, 620, 70, 50);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        linea2.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        linea2.setText("return a + b;");
        jPanel1.add(linea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        linea3.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        linea3.setText("}");
        jPanel1.add(linea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 46, -1));

        linea1.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        linea1.setText("sumar (a. b) {");
        jPanel1.add(linea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 20));

        add(jPanel1);
        jPanel1.setBounds(850, 430, 120, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
//        NavegadorFrames.navegarAtras();
//        this.setVisible(false);
//        this.frame.dispose();
NavegadorFrames.navegarA(NavegadorFrames.ELEGIR_MODO);
this.frame.dispose();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void botonESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonESActionPerformed
        JFrame ventanaES1 = new JFrame();
        ES1 es1 = new ES1(ventanaES1,baseDatos,alumno,ingles,español,fruta,plasti,listaI,raton);
        ventanaES1.setContentPane(es1);
        ventanaES1.setTitle("PrimaryCode");
        ventanaES1.setSize(1024, 720);
        ventanaES1.setLocationRelativeTo(null);
        ventanaES1.setResizable(false);
        ventanaES1.setVisible(true);
        this.frame.dispose();
    }//GEN-LAST:event_botonESActionPerformed

    private void botonArraysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArraysActionPerformed
       
        NavegadorFrames.navegarA(NavegadorFrames.ARRAYS_CREAR_UNIDIM_3);
        this.frame.dispose();
    }//GEN-LAST:event_botonArraysActionPerformed

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        if((fruta) && (español)){
            JFrame ventanaInfo = new JFrame();
            Info Info = new Info(ventanaInfo,true);
            Info.setTitle("PrimaryCode");
            Info.setSize(512, 360);
            Info.setLocationRelativeTo(null);
            Info.setResizable(false);
            Info.setVisible(true);
        }else if ((fruta) && (ingles)){
            JFrame ventanaInfoUK = new JFrame();
            InfoUK InfoUK = new InfoUK(ventanaInfoUK,true);
            InfoUK.setTitle("PrimaryCode");
            InfoUK.setSize(512, 360);
            InfoUK.setLocationRelativeTo(null);
            InfoUK.setResizable(false);
            InfoUK.setVisible(true);
        }else if ((plasti) && (español)){
            JFrame ventanaInfo2 = new JFrame();
            Info2 Info2 = new Info2(ventanaInfo2,true);
            Info2.setTitle("PrimaryCode");
            Info2.setSize(512, 360);
            Info2.setLocationRelativeTo(null);
            Info2.setResizable(false);
            Info2.setVisible(true);
        }else if ((plasti) && (ingles)){
            JFrame ventanaInfo2UK = new JFrame();
            Info2UK Info2UK = new Info2UK(ventanaInfo2UK,true);
            Info2UK.setTitle("PrimaryCode");
            Info2UK.setSize(512, 360);
            Info2UK.setLocationRelativeTo(null);
            Info2UK.setResizable(false);
            Info2UK.setVisible(true);
        }
    }//GEN-LAST:event_infoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!this.raton){
            this.raton=true;
            interaccion.setIcon(new ImageIcon(getClass().getResource("/mathmaster/interaccionR.png")));
        }else{
            raton=false;
            interaccion.setIcon(new ImageIcon(getClass().getResource("/mathmaster/interaccionM.png")));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonBucles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBucles1ActionPerformed
        // TODO add your handling code here:
         JFrame ventanaBucles = new JFrame();
        Bucles1 bucles1 = new Bucles1(ventanaBucles,baseDatos,alumno,ingles,español,fruta,plasti,listaI,raton);
        ventanaBucles.setContentPane(bucles1);
        ventanaBucles.setTitle("PrimaryCode");
        ventanaBucles.setSize(1024, 720);
        ventanaBucles.setLocationRelativeTo(null);
        ventanaBucles.setResizable(false);
        ventanaBucles.setVisible(true);
        this.frame.dispose();
    }//GEN-LAST:event_botonBucles1ActionPerformed

    private void botonCondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCondActionPerformed
        JFrame ventanaCondicionales = new JFrame();
        Condicionales1 condicionales1 = new Condicionales1(ventanaCondicionales,baseDatos,alumno,ingles,español,fruta,plasti,listaI,raton);
        ventanaCondicionales.setContentPane(condicionales1);
        ventanaCondicionales.setTitle("PrimaryCode");
        ventanaCondicionales.setSize(1024, 720);
        ventanaCondicionales.setLocationRelativeTo(null);
        ventanaCondicionales.setResizable(false);
        ventanaCondicionales.setVisible(true);
        this.frame.dispose();
        //            }
        //        }
    }//GEN-LAST:event_botonCondActionPerformed

    private void botonFuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFuncionesActionPerformed
        JFrame ventanaFunciones = new JFrame();
        Funciones1 funciones1 = new Funciones1(ventanaFunciones,baseDatos,alumno,ingles,español,fruta,plasti,listaI,raton);
        ventanaFunciones.setContentPane(funciones1);
        ventanaFunciones.setTitle("PrimaryCode");
        ventanaFunciones.setSize(1024, 720);
        ventanaFunciones.setLocationRelativeTo(null);
        ventanaFunciones.setResizable(false);
        ventanaFunciones.setVisible(true);
        this.frame.dispose();
    }//GEN-LAST:event_botonFuncionesActionPerformed

    private void botonFicherosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFicherosActionPerformed
        JFrame ventanaFicheros = new JFrame();
        DefinicionFicheros ficheros1 = new DefinicionFicheros(ventanaFicheros);
        ventanaFicheros.setContentPane(ficheros1);
        ventanaFicheros.setTitle("PrimaryCode");
        ventanaFicheros.setSize(1024, 720);
        ventanaFicheros.setLocationRelativeTo(null);
        ventanaFicheros.setResizable(false);
        ventanaFicheros.setVisible(true);
        this.frame.dispose();
    }//GEN-LAST:event_botonFicherosActionPerformed

    private void botonRecursividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRecursividadActionPerformed
        JFrame recursividad = new JFrame();
        Recursividad1 recursividad1 = new Recursividad1(recursividad);
        recursividad.setContentPane(recursividad1);
        recursividad.setTitle("PrimaryCode");
        recursividad.setSize(1024, 720);
        recursividad.setLocationRelativeTo(null);
        recursividad.setResizable(false);
        recursividad.setVisible(true);
        this.frame.dispose();
    }//GEN-LAST:event_botonRecursividadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonArrays;
    private javax.swing.JButton botonBucles1;
    private javax.swing.JButton botonCond;
    private javax.swing.JButton botonES;
    private javax.swing.JButton botonFicheros;
    private javax.swing.JButton botonFunciones;
    private javax.swing.JButton botonRecursividad;
    private javax.swing.JLabel hola;
    private javax.swing.JButton info;
    private javax.swing.JLabel interaccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel linea1;
    private javax.swing.JLabel linea2;
    private javax.swing.JLabel linea3;
    private javax.swing.JLabel numero1;
    private javax.swing.JLabel numero2;
    private javax.swing.JLabel numero3;
    private javax.swing.JLabel numero4;
    private javax.swing.JLabel numero5;
    private javax.swing.JLabel numero6;
    private javax.swing.JLabel numero7;
    private javax.swing.JLabel textoInteraccion;
    private javax.swing.JLabel textoRecursividad;
    // End of variables declaration//GEN-END:variables
}
