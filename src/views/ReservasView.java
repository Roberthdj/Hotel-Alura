package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.util.Date;
import utilidades.Utilidades;

@SuppressWarnings("serial")
public class ReservasView extends JFrame {

    private JPanel contentPane;
    public static JTextField txtValor;
    public static JDateChooser txtFechaEntrada;
    public static JDateChooser txtFechaSalida;
    public static JComboBox<String> txtFormaPago, txtTipoHabitacion;
    int xMouse, yMouse;
    private JLabel labelExit;
    private JLabel labelAtras;
    private double valorReserva;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReservasView frame = new ReservasView();
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
    public ReservasView() {
        super("Reserva");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 560);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 910, 560);
        contentPane.add(panel);
        panel.setLayout(null);

        // Código que crea los elementos de la interfáz gráfica
        JSeparator separator_1_2 = new JSeparator(); //Sep. Check IN
        separator_1_2.setForeground(SystemColor.textHighlight);
        separator_1_2.setBounds(68, 166, 289, 2);
        separator_1_2.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_2);

        JSeparator separator_1_3 = new JSeparator(); // Sep. forma de pago
        separator_1_3.setForeground(SystemColor.textHighlight);
        separator_1_3.setBackground(SystemColor.textHighlight);
        separator_1_3.setBounds(68, 478, 289, 2);
        panel.add(separator_1_3);

        JSeparator separator_1_1 = new JSeparator(); // Sep. Check OUT
        separator_1_1.setForeground(SystemColor.textHighlight);
        separator_1_1.setBounds(68, 248, 289, 11);
        separator_1_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_1);

        JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
        lblCheckIn.setForeground(SystemColor.textInactiveText);
        lblCheckIn.setBounds(68, 106, 300, 14);
        lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckIn);

        JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
        lblCheckOut.setForeground(SystemColor.textInactiveText);
        lblCheckOut.setBounds(68, 185, 300, 14);
        lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckOut);

        JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
        lblFormaPago.setForeground(SystemColor.textInactiveText);
        lblFormaPago.setBounds(68, 410, 250, 24);
        lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblFormaPago);

        // Integrando etiqueta y separador para tipo de habitación
        JLabel lblTipoHabitacion = new JLabel("TIPO DE HABITACION");
        lblTipoHabitacion.setForeground(SystemColor.textInactiveText);
        lblTipoHabitacion.setBounds(68, 265, 250, 24);
        lblTipoHabitacion.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblTipoHabitacion);

        JSeparator separator_1_4 = new JSeparator();
        separator_1_4.setForeground(SystemColor.textHighlight);
        separator_1_4.setBounds(68, 333, 289, 11);
        separator_1_4.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_4);
        // Fin de integración

        JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
        lblTitulo.setBounds(109, 40, 300, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(lblTitulo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(428, 0, 482, 560);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(197, 68, 104, 107);
        panel_1.add(logo);
        logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 140, 500, 409);
        panel_1.add(imagenFondo);
        imagenFondo.setBackground(Color.WHITE);
        imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));

        JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
        lblValor.setForeground(SystemColor.textInactiveText);
        lblValor.setBounds(72, 350, 300, 14);
        lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblValor);

        JSeparator separator_1 = new JSeparator(); //Sep valor de la reserva
        separator_1.setForeground(SystemColor.textHighlight);
        separator_1.setBounds(68, 400, 289, 2);
        separator_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1);

        // Componentes para dejar la interfaz con estilo Material Design
        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuPrincipal principal = new MenuPrincipal();
                principal.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setBounds(429, 0, 53, 36);
        panel_1.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setForeground(Color.WHITE);
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

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
        header.setBackground(Color.WHITE);
        panel.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 75, 35);
        header.add(btnAtras);

        labelAtras = new JLabel("Atrás");
        labelAtras.setBounds(0, 0, 75, 35);
        btnAtras.add(labelAtras);
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 20));

        JLabel lblSiguiente = new JLabel("SIGUIENTE");
        lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
        lblSiguiente.setForeground(Color.WHITE);
        lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblSiguiente.setBounds(0, 0, 122, 35);

        //Campos que guardaremos en la base de datos
        txtFechaEntrada = new JDateChooser();
        txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
        txtFechaEntrada.setBounds(68, 131, 289, 35);
        txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
        txtFechaEntrada.setBackground(Color.WHITE);
        txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
        txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
        txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtFechaEntrada.setDate(new Date());
        panel.add(txtFechaEntrada);

        txtFechaSalida = new JDateChooser();
        txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
        txtFechaSalida.setBounds(68, 211, 289, 35);
        txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
        txtFechaSalida.setBackground(Color.WHITE);
        txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtFechaSalida.setDateFormatString("yyyy-MM-dd");
        txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);//
        txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        txtFechaSalida.setDate(new Date()); //
        panel.add(txtFechaSalida);

        txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                Utilidades utilidad = new Utilidades(); // Calculando el valor de la reserva para guardar en la DB
                valorReserva = utilidad.calcularValorReserva(txtFechaEntrada, txtFechaSalida);

                DecimalFormat formato = new DecimalFormat("#,###,##0.00"); // Mostrando el valor de la reserva con formato
                String valorFormateado = formato.format(valorReserva);
                txtValor.setText("$ " + valorFormateado);
            }
        });

        txtValor = new JTextField();
        txtValor.setBackground(SystemColor.text);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setForeground(Color.BLACK);
        txtValor.setBounds(78, 373, 250, 27);
        txtValor.setEditable(false);
        txtValor.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(txtValor);
        txtValor.setColumns(10);

        txtTipoHabitacion = new JComboBox();
        txtTipoHabitacion.setBounds(68, 294, 289, 38);
        txtTipoHabitacion.setBackground(SystemColor.text);
        txtTipoHabitacion.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtTipoHabitacion.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtTipoHabitacion.setModel(new DefaultComboBoxModel(
                new String[]{
                    "Habitación individual",
                    "Habitación matrimonial",
                    "Habitación familiar",
                    "Suite principal"
                }));
        panel.add(txtTipoHabitacion);

        txtFormaPago = new JComboBox();
        txtFormaPago.setBounds(68, 440, 289, 38);
        txtFormaPago.setBackground(SystemColor.text);
        txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtFormaPago.setModel(new DefaultComboBoxModel(
                new String[]{
                    "Tarjeta de Crédito",
                    "Tarjeta de Débito",
                    "Dinero en efectivo"
                }));
        panel.add(txtFormaPago);

        JPanel btnsiguiente = new JPanel();
        btnsiguiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null) {
                    RegistroHuesped registro = new RegistroHuesped();
                    registro.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                }
            }
        });

        JLabel labelSiguiente = new JLabel("SIGUIENTE");
        labelSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
        labelSiguiente.setForeground(Color.WHITE);
        labelSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelSiguiente.setBounds(0, 0, 150, 35);

        btnsiguiente.setLayout(null);
        btnsiguiente.setBackground(SystemColor.textHighlight);
        btnsiguiente.setBounds(250, 493, 150, 35);
        btnsiguiente.add(labelSiguiente);

        btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(btnsiguiente);

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
}