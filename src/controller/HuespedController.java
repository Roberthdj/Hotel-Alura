package controller;

import dao.HuespedDao;
import factory.ConexionFactory;
import modelos.Huesped;

public class HuespedController {

    private HuespedDao huespedDao;

    public HuespedController() {
        var factory = new ConexionFactory();
        this.huespedDao = new HuespedDao(factory.getConexion());
    }

    public void guardar(Huesped huesped) {
        this.huespedDao.guardar(huesped);
    }

}
