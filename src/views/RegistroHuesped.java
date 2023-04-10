package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import controller.HuespedController;
import controller.ReservaController;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.util.Date;
import javax.swing.JOptionPane;
import modelos.Huesped;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtNreserva;
    private JDateChooser txtFechaN;
    private JComboBox<Format> txtNacionalidad;
    private JLabel labelExit;
    private JLabel labelAtras;
    int xMouse, yMouse;
    private int idReserva;
    private HuespedController huespedController;
    private ReservaController reservaController;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistroHuesped frame = new RegistroHuesped();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Create the frame.
     */
    public RegistroHuesped() {
        this.huespedController = new HuespedController();
        crearFormulario();
    }

    public void crearFormulario() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/lOGO-50PX.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 634);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.text);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane.setLayout(null);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(SystemColor.text);
        header.setOpaque(false);
        header.setBounds(0, 0, 910, 40);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eliminarReserva();
                ReservasView reserva = new ReservasView();
                reserva.setVisible(true);
                dispose();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }
        });

        btnAtras.setLayout(null);
        btnAtras.setBackground(new Color(12, 138, 199));
        btnAtras.setBounds(5, 5, 50, 35);
        header.add(btnAtras);

        labelAtras = new JLabel();
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setForeground(Color.WHITE);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelAtras.setBounds(0, 0, 50, 35);
        labelAtras.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/atras.png")));
        btnAtras.add(labelAtras);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNombre.setBounds(560, 135, 285, 33);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setColumns(10);
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtApellido.setBounds(560, 204, 285, 33);
        txtApellido.setColumns(10);
        txtApellido.setBackground(Color.WHITE);
        txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtApellido);

        txtFechaN = new JDateChooser();
        txtFechaN.setBounds(560, 278, 285, 36);
        txtFechaN.getCalendarButton().setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/icon-reservas.png")));
        txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaN.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtFechaN.setDateFormatString("yyyy-MM-dd");
        txtFechaN.setDate(new Date());
        contentPane.add(txtFechaN);

        txtNacionalidad = new JComboBox();
        txtNacionalidad.setBounds(560, 350, 289, 36);
        txtNacionalidad.setBackground(SystemColor.text);
        txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNacionalidad.setModel(new DefaultComboBoxModel(
                new String[]{
                    "afgano-afgana", "alemán-alemana", "árabe-árabe", "argentino-argentina",
                    "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña",
                    "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china",
                    "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana",
                    "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña",
                    "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia",
                    "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa",
                    "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa",
                    "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní",
                    "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa",
                    "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya",
                    "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega",
                    "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana",
                    "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana",
                    "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa",
                    "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya",
                    "venezolano-venezolana", "vietnamita-vietnamita"
                }));
        contentPane.add(txtNacionalidad);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(562, 119, 253, 14);
        lblNombre.setForeground(SystemColor.textInactiveText);
        lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNombre);

        JLabel lblApellido = new JLabel("APELLIDO");
        lblApellido.setBounds(560, 189, 255, 14);
        lblApellido.setForeground(SystemColor.textInactiveText);
        lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblApellido);

        JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
        lblFechaN.setBounds(560, 256, 255, 14);
        lblFechaN.setForeground(SystemColor.textInactiveText);
        lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblFechaN);

        JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
        lblNacionalidad.setBounds(560, 326, 255, 14);
        lblNacionalidad.setForeground(SystemColor.textInactiveText);
        lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNacionalidad);

        JLabel lblTelefono = new JLabel("TELÉFONO");
        lblTelefono.setBounds(562, 406, 253, 14);
        lblTelefono.setForeground(SystemColor.textInactiveText);
        lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtTelefono.setBounds(560, 424, 285, 33);
        txtTelefono.setColumns(10);
        txtTelefono.setBackground(Color.WHITE);
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtTelefono);

        JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
        lblTitulo.setBounds(606, 55, 240, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
        contentPane.add(lblTitulo);

        JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
        lblNumeroReserva.setBounds(560, 474, 253, 14);
        lblNumeroReserva.setForeground(SystemColor.textInactiveText);
        lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNumeroReserva);

        txtNreserva = new JTextField();
        txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 20));
        txtNreserva.setBounds(560, 495, 285, 33);
        txtNreserva.setColumns(10);
        txtNreserva.setBackground(Color.WHITE);
        txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtNreserva.setEditable(false);
        txtNreserva.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(txtNreserva);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(560, 170, 289, 2);
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2);

        JSeparator separator_1_2_1 = new JSeparator();
        separator_1_2_1.setBounds(560, 240, 289, 2);
        separator_1_2_1.setForeground(new Color(12, 138, 199));
        separator_1_2_1.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_1);

        JSeparator separator_1_2_2 = new JSeparator();
        separator_1_2_2.setBounds(560, 314, 289, 2);
        separator_1_2_2.setForeground(new Color(12, 138, 199));
        separator_1_2_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_2);

        JSeparator separator_1_2_3 = new JSeparator();
        separator_1_2_3.setBounds(560, 386, 289, 2);
        separator_1_2_3.setForeground(new Color(12, 138, 199));
        separator_1_2_3.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_3);

        JSeparator separator_1_2_4 = new JSeparator();
        separator_1_2_4.setBounds(560, 457, 289, 2);
        separator_1_2_4.setForeground(new Color(12, 138, 199));
        separator_1_2_4.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_4);

        JSeparator separator_1_2_5 = new JSeparator();
        separator_1_2_5.setBounds(560, 529, 289, 2);
        separator_1_2_5.setForeground(new Color(12, 138, 199));
        separator_1_2_5.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_5);

        JPanel btnguardar = new JPanel();
        btnguardar.setBounds(660, 560, 220, 35);
        btnguardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                guardar();
            }
        });

        btnguardar.setLayout(null);
        btnguardar.setBackground(new Color(12, 138, 199));
        contentPane.add(btnguardar);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel labelGuardar = new JLabel("CONFIRMAR RESERVA");
        labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
        labelGuardar.setForeground(Color.WHITE);
        labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelGuardar.setBounds(0, 0, 220, 35);
        btnguardar.add(labelGuardar);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 489, 634);
        panel.setBackground(new Color(12, 138, 199));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 121, 479, 502);
        panel.add(imagenFondo);
        imagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/registro.png")));

        JLabel logo = new JLabel("");
        logo.setBounds(194, 39, 104, 107);
        panel.add(logo);
        logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));

        JPanel btnexit = new JPanel();
        btnexit.setBounds(855, 5, 50, 40);
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eliminarReserva();
                llamarMenuPrincipal();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });

        btnexit.setLayout(null);
        btnexit.setBackground(Color.white);
        contentPane.add(btnexit);
        header.add(btnexit);

        labelExit = new JLabel();
        labelExit.setBounds(0, 0, 50, 36);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(SystemColor.black);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setIcon(new ImageIcon(Login.class.getResource("/imagenes/salir.png")));
        btnexit.add(labelExit);
    }

    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    //Código que permite realizar acciones CRUD
    public void guardar() {

        if (!txtNombre.getText().equals("") && !txtApellido.getText().equals("") && txtFechaN.getDate() != null && !txtTelefono.getText().equals("")) {

            if (JOptionPane.showConfirmDialog(this, "¿Deseas crear el registro?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                var huesped = new Huesped();

                huesped.setId_reserva(this.idReserva);
                huesped.setNombre(txtNombre.getText());
                huesped.setApellido(txtApellido.getText());
                huesped.setFechaNacimiento(txtFechaN.getDate());
                huesped.setNacionalidad(txtNacionalidad.getSelectedItem().toString());
                huesped.setTelefono(txtTelefono.getText());
                this.huespedController.guardar(huesped);
                JOptionPane.showMessageDialog(this, "Se ha creado un huésped!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                llamarReservasView();
            } else {
                eliminarReserva();
                llamarReservasView();
            }
            dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Error en los datos, corrija la información ingresada!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void eliminarReserva() {
        this.reservaController = new ReservaController();
        try {
            this.reservaController.eliminar(idReserva);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error en el proceso!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Código que permite realizar obtener un dato de otro formulario    
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
        txtNreserva.setText(String.valueOf(idReserva));
    }

    //---------------------------------------------------------------
    public void llamarReservasView() {
        ReservasView reserva = new ReservasView();
        reserva.setVisible(true);
    }

    public void llamarMenuPrincipal() {
        MenuPrincipal principal = new MenuPrincipal();
        principal.setVisible(true);
        dispose();
    }

}
