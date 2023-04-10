package views;

import controller.HuespedController;
import controller.ReservaController;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes;
    private JTable tbReservas;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHuesped;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;
    private ReservaController reservaController;
    private HuespedController huespedController;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Busqueda() {

        this.reservaController = new ReservaController();
        this.huespedController = new HuespedController();

        crearFormulario();
        cargarTablaReserva();
        cargarTablaHuesped();
    }

// Código que permite crear la ventana
    private void crearFormulario() { // Código que permite crear el frame

        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 300, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 14));
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor a pagar");
        modelo.addColumn("Habitación");
        modelo.addColumn("Forma de Pago");
        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
        scroll_table.setVisible(true);

        tbHuespedes = new JTable();
        tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 14));
        modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
        modeloHuesped.addColumn("Huesped");
        modeloHuesped.addColumn("Nombres");
        modeloHuesped.addColumn("Apellidos");
        modeloHuesped.addColumn("Fecha de Nacimiento");
        modeloHuesped.addColumn("Nacionalidad");
        modeloHuesped.addColumn("Telefono");
        modeloHuesped.addColumn("Reserva");
        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
        panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.getSelectedIndex() == 0) {
                    limpiarTxtBuscar();
                    limpiarTabla(modelo);
                    cargarTablaReserva();
                } else if (panel.getSelectedIndex() == 1) {
                    limpiarTxtBuscar();
                    limpiarTabla(modeloHuesped);
                    cargarTablaHuesped();
                }
            }
        });

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
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
        header.setBounds(0, 0, 910, 40);
        contentPane.add(header);

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
        btnAtras.setBounds(5, 5, 50, 36);
        header.add(btnAtras);

        labelAtras = new JLabel();
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelAtras.setBounds(0, 0, 50, 36);
        labelAtras.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/atras.png")));
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                llamarMenuUsuario();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 5, 50, 40);
        header.add(btnexit);

        labelExit = new JLabel();
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 50, 40);
        btnexit.add(labelExit);
        labelExit.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/salir.png")));

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();

        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.getSelectedIndex() == 0) {
                    limpiarTabla(modelo);
                    buscarReserva(txtBuscar.getText());
                } else if (panel.getSelectedIndex() == 1) {
                    limpiarTabla(modeloHuesped);
                    buscarHuesped(txtBuscar.getText());
                }
            }
        });

        JPanel btnEditar = new JPanel();
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.getSelectedIndex() == 0) {
                    editarReserva();
                    limpiarTabla(modelo);
                    cargarTablaReserva();
                } else if (panel.getSelectedIndex() == 1) {
                    editarHuesped();
                    limpiarTabla(modeloHuesped);
                    cargarTablaHuesped();
                }
                limpiarTxtBuscar();
            }
        });

        JPanel btnEliminar = new JPanel();
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);

        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.getSelectedIndex() == 0) {
                    eliminarReserva();
                } else if (panel.getSelectedIndex() == 1) {
                    eliminarHuesped();
                }
            }
        });
    }

// Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

//Código para listar, editar y eliminar 
    private void cargarTablaReserva() {
        var reservas = this.reservaController.listar();

        reservas.forEach(reserva -> modelo.addRow(
                new Object[]{
                    reserva.getId(),
                    reserva.getFechaEntrada(),
                    reserva.getFechaSalida(),
                    reserva.getValor(),
                    reserva.getTipoHabitacion(),
                    reserva.getFormaPago()
                }
        ));
    }

    private void cargarTablaHuesped() {

        var huespedes = this.huespedController.listar();

        huespedes.forEach(huesped -> modeloHuesped.addRow(
                new Object[]{
                    huesped.getId(),
                    huesped.getNombre(),
                    huesped.getApellido(),
                    huesped.getFechaNacimiento(),
                    huesped.getNacionalidad(),
                    huesped.getTelefono(),
                    huesped.getId_reserva()
                }
        ));
    }

    private void buscarReserva(String cadena) {

        if (isNumeric(cadena)) {

            int idBusqueda = Integer.valueOf(cadena);

            var reservas = this.reservaController.listarBusqueda(idBusqueda);

            if (reservas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El número de reserva no existe!", "WARNING", JOptionPane.WARNING_MESSAGE);
                limpiarTabla(modelo);
                cargarTablaReserva();
                limpiarTxtBuscar();

            } else {
                reservas.forEach(reserva -> modelo.addRow(
                        new Object[]{
                            reserva.getId(),
                            reserva.getFechaEntrada(),
                            reserva.getFechaSalida(),
                            reserva.getValor(),
                            reserva.getTipoHabitacion(),
                            reserva.getFormaPago()
                        }
                ));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un criterio de busqueda valido!", "WARNING", JOptionPane.WARNING_MESSAGE);
            limpiarTabla(modelo);
            cargarTablaReserva();
            limpiarTxtBuscar();
        }

    }

    private void buscarHuesped(String cadena) {

        if (!cadena.equals("")) {

            var huespedes = this.huespedController.listarBusqueda(cadena);

            if (huespedes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No existen huespedes con este apellido!", "WARNING", JOptionPane.WARNING_MESSAGE);
                limpiarTabla(modeloHuesped);
                cargarTablaHuesped();
                limpiarTxtBuscar();
            } else {

                huespedes.forEach(huesped -> modeloHuesped.addRow(
                        new Object[]{
                            huesped.getId(),
                            huesped.getNombre(),
                            huesped.getApellido(),
                            huesped.getFechaNacimiento(),
                            huesped.getNacionalidad(),
                            huesped.getTelefono(),
                            huesped.getId_reserva()
                        }
                ));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un criterio de busqueda valido!", "WARNING", JOptionPane.WARNING_MESSAGE);
            limpiarTabla(modeloHuesped);
            cargarTablaHuesped();
            limpiarTxtBuscar();
        }
    }

    private void editarReserva() {
        if (tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una reserva!", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {

            if (JOptionPane.showConfirmDialog(this, "¿Deseas modificar la información del huesped?", "QUESTION", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                int idReserva = (int) modelo.getValueAt(tbReservas.getSelectedRow(), 0);

                String entrada = modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString().trim();
                Date fechaEntrada = Date.valueOf(entrada);
                String salida = modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString().trim();
                Date fechaSalida = Date.valueOf(salida);

                Double valor = Double.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString().trim());
                String tipoHabitacion = modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString().trim();
                String formaPago = modelo.getValueAt(tbReservas.getSelectedRow(), 5).toString().trim();

                this.reservaController.modificar(idReserva, fechaEntrada, fechaSalida, valor, tipoHabitacion, formaPago);
                JOptionPane.showMessageDialog(this, "La reserva número " + idReserva + " se ha modificado.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

            } else {
                limpiarTxtBuscar();
            }
        }
    }

    private void editarHuesped() {
        if (tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un huésped!", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {

            if (JOptionPane.showConfirmDialog(this, "¿Deseas modificar la información del huésped?", "QUESTION", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                int idHuesped = (int) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0);
                String nombre = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1).toString().trim();
                String apellido = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2).toString().trim();

                String nacimiento = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString().trim();
                Date fechaNacimiento = Date.valueOf(nacimiento);

                String nacionalidad = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4).toString().trim();
                String telefono = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString().trim();
                int idReserva = (int) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 6);

                this.huespedController.modificar(idHuesped, idReserva, nombre, apellido, fechaNacimiento, nacionalidad, telefono);
                JOptionPane.showMessageDialog(this, "El huésped número " + idHuesped + " se ha modificado.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

            } else {
                limpiarTxtBuscar();
            }
        }
    }

    private void eliminarReserva() {
        if (tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una reserva!", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {

            if (JOptionPane.showConfirmDialog(this, "¿Deseas eliminar la reserva?", "QUESTION", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                int idReserva = (int) modelo.getValueAt(tbReservas.getSelectedRow(), 0);

                try {
                    int resultado = this.reservaController.eliminar(idReserva);
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(this, "La reserva número " + idReserva + " ha sido eliminada.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        modelo.removeRow(tbReservas.getSelectedRow());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Primero debes eliminar el huésped asociado a la reserva número " + idReserva + "!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }

    private void eliminarHuesped() {
        if (tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro!", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(this, "¿Deseas eliminar la reserva?", "QUESTION", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                int idHuesped = (int) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0);
                try {
                    int resultado = this.huespedController.eliminar(idHuesped);
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(this, "El huésped número " + idHuesped + " ha sido eliminado, por favor elimine la reserva asociada", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        modeloHuesped.removeRow(tbHuespedes.getSelectedRow());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error en el proceso!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Código para procesos de validación y limpieza
    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void limpiarTabla(DefaultTableModel modelo) {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void limpiarTxtBuscar() {
        txtBuscar.setText("");
        txtBuscar.requestFocus();
    }

    //  Código para llamar formularios
    public void llamarMenuUsuario() {
        MenuUsuario usuario = new MenuUsuario();
        usuario.setVisible(true);
        dispose();
    }

}
