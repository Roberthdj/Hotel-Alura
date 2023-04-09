package controller;

import dao.HuespedDao;
import factory.ConexionFactory;
import java.util.List;
import java.sql.Date;
import modelos.Huesped;

public class HuespedController {

    private HuespedDao huespedDao;

    public HuespedController() {
        var factory = new ConexionFactory();
        this.huespedDao = new HuespedDao(factory.getConexion());
    }

    public List<Huesped> listar() {
        return huespedDao.listar();
    }
    
        public List<Huesped> listarBusqueda(String cadena) {
        return huespedDao.listarBusqueda(cadena);
    }

    public void guardar(Huesped huesped) {
        this.huespedDao.guardar(huesped);
    }

    public int modificar(int idHuesped, int idReserva, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
        return this.huespedDao.modificar(idHuesped, idReserva, nombre, apellido, fechaNacimiento, nacionalidad, telefono);
    }

    public int eliminar(Integer idReserva) {
        return huespedDao.eliminar(idReserva);
    }

}
