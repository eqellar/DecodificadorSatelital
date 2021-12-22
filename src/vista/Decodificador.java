package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.PrintStream;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Altitud;
import modelo.Altitud;
import modelo.ConcatenaTiempo;
import modelo.ConcatenaTiempo;
import modelo.Fecha;
import modelo.Fecha;
import modelo.Heading;
import modelo.Heading;
import modelo.Hora;
import modelo.Hora;
import modelo.Latitud;
import modelo.Latitud;
import modelo.Longitud;
import modelo.Longitud;
import modelo.Mensaje;
import modelo.Mensaje;
import modelo.QuitarSalto;
import modelo.QuitarSalto;
import modelo.String2UnixTime4000;
import modelo.String2UnixTime4000;
import modelo.UnixTime;
import modelo.UnixTime;
import modelo.Velocidad;
import modelo.Velocidad;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Decodificador
        extends JFrame {
	
	

    public Decodificador() {
        initComponents();
    }

    String zona = "";
    private JButton btnBorrar;
    private JButton jButMapear;
    private JButton jButton1;
    private JButton jButton2;
    public static JComboBox<String> jCGMT;
    private JLabel jLAltitud;
    private JLabel jLFecha;
    private JLabel jLHeading;
    private JLabel jLImagen;
    private JLabel jLLatitud;
    private JLabel jLLongitud;
    private JLabel jLMensaje;
    private JLabel jLStatusGPS;
    private JLabel jLTitulo;
    private JLabel jLVelocidad;
    private JLabel jLZonaH;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField jTexLat;
    public static JTextField jTexValido;
    private JTextField jTextAltitud;
    private JTextField jTextFecha;
    private JTextField jTextHeading;
    private JTextField jTextLon;
    private JTextField jTextMsj;
    private JTextField jTextVel;
    private JTextArea txtA1;

    public String getZone(String zone) {
        this.zona = zone;
        System.out.println(this.zona);
        return this.zona;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.txtA1 = new JTextArea();
        jCGMT = new JComboBox();
        this.jButton1 = new JButton();
        this.jLTitulo = new JLabel();
        this.jLLatitud = new JLabel();
        this.jTexLat = new JTextField();
        this.jLLongitud = new JLabel();
        this.jTextLon = new JTextField();
        this.jLFecha = new JLabel();
        this.jTextVel = new JTextField();
        this.jLVelocidad = new JLabel();
        this.jTextFecha = new JTextField();
        this.jLMensaje = new JLabel();
        this.jTextMsj = new JTextField();
        this.btnBorrar = new JButton();
        this.jButton2 = new JButton();
        jTexValido = new JTextField();
        this.jLStatusGPS = new JLabel();
        this.jLZonaH = new JLabel();
        this.jLHeading = new JLabel();
        this.jLAltitud = new JLabel();
        this.jTextHeading = new JTextField();
        this.jTextAltitud = new JTextField();
        this.jButMapear = new JButton();
        this.jLImagen = new JLabel();

        setDefaultCloseOperation(3);
        setTitle("Decodificacion de Mensajes Satelitales GDM v1.2");
        setAutoRequestFocus(false);
        setBounds(new Rectangle(200, 200, 900, 600));
        setMinimumSize(new Dimension(800, 400));
        setPreferredSize(new Dimension(800, 400));
        setResizable(false);
        setSize(new Dimension(900, 400));
        getContentPane().setLayout(new AbsoluteLayout());

        this.jPanel1.setPreferredSize(new Dimension(100, 290));
        this.jPanel1.setLayout(new AbsoluteLayout());

        this.txtA1.setColumns(20);
        this.txtA1.setRows(5);
        this.txtA1.setToolTipText("");
        this.txtA1.setPreferredSize(new Dimension(800, 94));
        this.jScrollPane1.setViewportView(this.txtA1);

        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(30, 60, 410, 110));

        jCGMT.setModel(new DefaultComboBoxModel(new String[]{"GMT", "GMT-5", "GMT-6"}));
        jCGMT.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                Decodificador.this.jCGMTItemStateChanged(evt);
            }
        });
        this.jPanel1.add(jCGMT, new AbsoluteConstraints(640, 130, -1, -1));

        this.jButton1.setBackground(new Color(153, 204, 255));
        this.jButton1.setText("Decodificar...");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Decodificador.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(30, 170, 130, -1));

        this.jLTitulo.setForeground(new Color(255, 102, 51));
        this.jLTitulo.setHorizontalAlignment(0);
        this.jLTitulo.setText("Ingresa la trama satelital tal como la copiaste del Back Offcice");
        this.jLTitulo.setHorizontalTextPosition(0);
        this.jPanel1.add(this.jLTitulo, new AbsoluteConstraints(30, 40, 410, 20));

        this.jLLatitud.setText("Latitud");
        this.jPanel1.add(this.jLLatitud, new AbsoluteConstraints(60, 220, -1, -1));

        this.jTexLat.setEditable(false);
        this.jTexLat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Decodificador.this.jTexLatActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jTexLat, new AbsoluteConstraints(20, 240, 110, -1));

        this.jLLongitud.setText("Longitud");
        this.jPanel1.add(this.jLLongitud, new AbsoluteConstraints(180, 220, -1, -1));

        this.jTextLon.setEditable(false);
        this.jPanel1.add(this.jTextLon, new AbsoluteConstraints(140, 240, 120, -1));

        this.jLFecha.setHorizontalAlignment(0);
        this.jLFecha.setText("Fecha (año-mes-día) y hora (24 hr)");
        this.jPanel1.add(this.jLFecha, new AbsoluteConstraints(570, 170, 210, -1));

        this.jTextVel.setEditable(false);
        this.jPanel1.add(this.jTextVel, new AbsoluteConstraints(270, 240, 100, -1));

        this.jLVelocidad.setText("Velocidad Km/h");
        this.jPanel1.add(this.jLVelocidad, new AbsoluteConstraints(280, 220, -1, -1));

        this.jTextFecha.setEditable(false);
        this.jPanel1.add(this.jTextFecha, new AbsoluteConstraints(570, 190, 210, -1));

        this.jLMensaje.setText("Mensaje");
        this.jPanel1.add(this.jLMensaje, new AbsoluteConstraints(640, 220, 70, -1));
        this.jLMensaje.getAccessibleContext().setAccessibleName("jLabel3");

        this.jTextMsj.setEditable(false);
        this.jPanel1.add(this.jTextMsj, new AbsoluteConstraints(570, 240, 210, -1));

        this.btnBorrar.setBackground(new Color(204, 153, 255));
        this.btnBorrar.setText("Limpiar...");
        this.btnBorrar.setEnabled(false);
        this.btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Decodificador.this.btnBorrarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnBorrar, new AbsoluteConstraints(340, 170, 100, -1));

        this.jButton2.setText("Salir");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Decodificador.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton2, new AbsoluteConstraints(720, 320, -1, -1));

        jTexValido.setEditable(false);
        jTexValido.setHorizontalAlignment(0);
        this.jPanel1.add(jTexValido, new AbsoluteConstraints(270, 300, 100, -1));

        this.jLStatusGPS.setHorizontalAlignment(0);
        this.jLStatusGPS.setText("Status GPS");
        this.jPanel1.add(this.jLStatusGPS, new AbsoluteConstraints(270, 280, 90, -1));

        this.jLZonaH.setText("Selecciona zona horaria");
        this.jPanel1.add(this.jLZonaH, new AbsoluteConstraints(610, 110, -1, -1));

        this.jLHeading.setHorizontalAlignment(0);
        this.jLHeading.setText("Heading");
        this.jLHeading.setHorizontalTextPosition(0);
        this.jPanel1.add(this.jLHeading, new AbsoluteConstraints(30, 280, 100, -1));

        this.jLAltitud.setText("Altitud");
        this.jPanel1.add(this.jLAltitud, new AbsoluteConstraints(190, 280, -1, -1));

        this.jTextHeading.setEditable(false);
        this.jPanel1.add(this.jTextHeading, new AbsoluteConstraints(20, 300, 110, -1));

        this.jTextAltitud.setEditable(false);
        this.jPanel1.add(this.jTextAltitud, new AbsoluteConstraints(140, 300, 120, -1));

        this.jButMapear.setText("Mapear posición");
        this.jButMapear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Decodificador.this.jButMapearActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButMapear, new AbsoluteConstraints(420, 270, -1, -1));

        this.jLImagen.setIcon(new ImageIcon(getClass().getResource("/imagen/gsat2.jpg")));
        this.jLImagen.setText("jLabel2");
        this.jLImagen.setMaximumSize(new Dimension(1010, 548));
        this.jLImagen.setMinimumSize(new Dimension(910, 548));
        this.jLImagen.setPreferredSize(new Dimension(910, 548));
        this.jPanel1.add(this.jLImagen, new AbsoluteConstraints(-60, 0, 900, 520));

        getContentPane().add(this.jPanel1, new AbsoluteConstraints(-10, -10, 1010, 440));

        getAccessibleContext().setAccessibleName("Ventana1");

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        String trama = this.txtA1.getText();
        QuitarSalto quitar = new QuitarSalto();
        String complete = quitar.quitarSaltos(trama);
        String buscar = "0xFA";
        String buscar2 = "2324";
        int largotrama = trama.length();
        Fecha fecha = new Fecha();
        Latitud lat = new Latitud();
        Mensaje msj = new Mensaje();
        Hora hr = new Hora();
        Velocidad speed = new Velocidad();
        Longitud lon = new Longitud();
        ConcatenaTiempo con = new ConcatenaTiempo();
        String2UnixTime4000 un4 = new String2UnixTime4000();
        UnixTime unix = new UnixTime();
        Heading head = new Heading();
        Altitud alt = new Altitud();
        if ((complete.length() > 60) && (complete.contains(buscar)) && (complete.contains(buscar2))) {
            un4.unix4000(con.fechaCompleta(trama));

            this.jTextFecha.setText(unix.timepo4000(un4.unix4000(con.fechaCompleta(trama))));
            this.jTextMsj.setForeground(Color.blue);
            this.jTextMsj.setText(msj.decoMensaje(trama));
            this.jTexLat.setText(lat.decodLatitud4000(trama));
            this.jTextLon.setText(lon.decodLongitud4000(trama));
            this.jTextVel.setText(speed.decodSpedd4000(trama));
            this.txtA1.setEditable(false);
            jTexValido.setEditable(false);
            this.jButton1.setEnabled(false);
            this.btnBorrar.setEnabled(true);
            this.jTextHeading.setText(head.decodHeading4000(complete));
            this.jTextAltitud.setText(alt.decodAltitud4000(complete));
        } else if ((largotrama < 60) && (complete.contains(buscar))) {
            this.jTextFecha.setText(fecha.decodFecha2000(trama));
            this.jTextMsj.setForeground(Color.red);
            this.jTextMsj.setText("El protocolo 2000 no lleva mensaje");
            this.jTexLat.setText(lat.decodLatitud2000(trama));
            this.jTextLon.setText(lon.decodLongitud2000(trama));
            this.jTextVel.setText(speed.decodSpedd2000(trama));
            this.txtA1.setEditable(false);
            this.jButton1.setEnabled(false);
            this.btnBorrar.setEnabled(true);
            jTexValido.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "No es una trama valida");
            this.btnBorrar.setEnabled(true);
        }
    }

    private void jTexLatActionPerformed(ActionEvent evt) {
    }

    private void btnBorrarActionPerformed(ActionEvent evt) {
        this.txtA1.setText("");
        this.jTexLat.setText("");
        this.jTextFecha.setText("");
        this.jTextLon.setText("");
        this.jTextMsj.setText("");
        this.jTextVel.setText("");
        jTexValido.setText("");
        this.jTextHeading.setText("");
        this.jTextAltitud.setText("");
        this.txtA1.setEditable(true);
        this.jButton1.setEnabled(true);
        this.btnBorrar.setEnabled(false);
        jTexValido.setEditable(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jCGMTItemStateChanged(ItemEvent evt) {
        String trama = this.txtA1.getText();
        int largotrama = trama.length();
        UnixTime unix = new UnixTime();
        String2UnixTime4000 un4 = new String2UnixTime4000();
        ConcatenaTiempo con = new ConcatenaTiempo();
        Fecha fecha = new Fecha();
        if (largotrama > 60) {
            this.jTextFecha.setText(unix.timepo4000(un4.unix4000(con.fechaCompleta(trama))));
        } else {
            this.jTextFecha.setText(fecha.decodFecha2000(trama));
        }
    }

    private void jButMapearActionPerformed(ActionEvent evt) {
        String posicion = "";

        String mapsgoogle = "http://maps.google.com/maps?f=q&hl=en&q=";

        Latitud lat = new Latitud();
        String trama = this.txtA1.getText();
        QuitarSalto quitar = new QuitarSalto();
        String complete = quitar.quitarSaltos(trama);
        Longitud lon = new Longitud();
        if (complete.length() > 60) {
            String latitud = lat.decodLatitud4000(complete);
            String longitud = lon.decodLongitud4000(complete);
            posicion = mapsgoogle + latitud + "+" + longitud;

            System.out.println(posicion);
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop dk = Desktop.getDesktop();
                    dk.browse(new URI(posicion));
                } catch (Exception e) {
                    System.out.println("Error al abrir URL: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Su PC no soporta esta aplicación");
            }
        } else if (complete.length() < 60) {
            String latitud = lat.decodLatitud2000(complete);
            String longitud = lon.decodLongitud2000(complete);
            posicion = mapsgoogle + latitud + "+" + longitud;
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop dk = Desktop.getDesktop();
                    dk.browse(new URI(posicion));
                } catch (Exception e) {
                    System.out.println("Error al abrir URL: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Su PC no soporta esta aplicación");
            }
        }
    }

}
