package controller;

import dao.ReservaDao;
import factory.ConexionFactory;
import java.sql.Date;
import java.util.List;
import modelos.Reserva;
import views.RegistroHuesped;

public class ReservaController {

    private ReservaDao reservaDao;
    private int idReserva;

    public ReservaController() {
        var factory = new ConexionFactory();
        this.reservaDao = new ReservaDao(factory.getConexion());
    }

    public List<Reserva> listar() {
        return reservaDao.listar();
    }

    public void guardar(Reserva reserva) {
        idReserva = this.reservaDao.guardar(reserva);
        RegistroHuesped registro = new RegistroHuesped();
        registro.setIdReserva(idReserva);
        registro.setVisible(true);
    }

    public int modificar(int idReserva, Date fechaEntrada, Date fechaSalida, double valor, String tipoHabitacion, String formaPago) {
        return this.reservaDao.modificar(idReserva, fechaEntrada, fechaSalida, valor, tipoHabitacion, formaPago);
    }

    public int eliminar(Integer idReserva) {
        return reservaDao.eliminar(idReserva);
    }
}
