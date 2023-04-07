package controller;

import dao.ReservaDao;
import factory.ConexionFactory;
import modelos.Reserva;
import views.RegistroHuesped;

public class ReservaController {

    private ReservaDao reservaDao;
    private int idReserva;

    public ReservaController() {
        var factory = new ConexionFactory();
        this.reservaDao = new ReservaDao(factory.getConexion());
    }

    public void guardar(Reserva reserva) {
        idReserva = this.reservaDao.guardar(reserva);
        RegistroHuesped registro = new RegistroHuesped();
        registro.setIdReserva(idReserva);
        registro.setVisible(true);
    }
}