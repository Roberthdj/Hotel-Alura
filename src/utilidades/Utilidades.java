package utilidades;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;

public class Utilidades {

    private final double valorDiaReserva = 50000;

    public double calcularValorReserva(JDateChooser fechaEntrada, JDateChooser fechaSalida) {
        if (fechaEntrada.getDate() != null && fechaSalida.getDate() != null) {
            Calendar entrada = fechaEntrada.getCalendar();
            Calendar salida = fechaSalida.getCalendar();
            int dias = -1;
            while (entrada.before(salida) || entrada.equals(salida)) {
                dias++;
                entrada.add(Calendar.DATE, 1);
            }
            return valorDiaReserva * dias;
        } else {
            return 0.0;
        }
    }
}
