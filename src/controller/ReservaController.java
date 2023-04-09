package controller;

import com.toedter.calendar.JDateChooser;
import dao.ReservaDao;
import factory.ConexionFactory;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import modelos.Reserva;
import views.RegistroHuesped;

public class ReservaController {

    private final ReservaDao reservaDao;    
    private final double valorReserva = 12500;

    public ReservaController() {
        var factory = new ConexionFactory();
        this.reservaDao = new ReservaDao(factory.getConexion());
    }

    public List<Reserva> listar() {
        return reservaDao.listar();
    }

    public int guardar(Reserva reserva) {
        return this.reservaDao.guardar(reserva);  
    }

    public int modificar(int idReserva, Date fechaEntrada, Date fechaSalida, double valor, String tipoHabitacion, String formaPago) {
        return this.reservaDao.modificar(idReserva, fechaEntrada, fechaSalida, valor, tipoHabitacion, formaPago);
    }

    public int eliminar(Integer idReserva) {
        return reservaDao.eliminar(idReserva);
    }

    public double calcularValorReserva(JDateChooser fechaEntrada, JDateChooser fechaSalida) {

        if (fechaEntrada.getDate() != null && fechaSalida.getDate() != null) {
            
            int dias = -1;
            
            Calendar entrada = fechaEntrada.getCalendar();
            Calendar salida = fechaSalida.getCalendar();
            
            while (entrada.before(salida) || entrada.equals(salida)) {
                dias++;
                entrada.add(Calendar.DATE, 1);
            }
            return valorReserva * dias;
        } else {
            return 0.0;
        }
        
    }
}
