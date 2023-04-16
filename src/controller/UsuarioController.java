package controller;

import dao.UsuarioDao;
import factory.ConexionFactory;

public class UsuarioController {

    private final UsuarioDao usuarioDao;

    public UsuarioController() {
        var factory = new ConexionFactory();
        this.usuarioDao = new UsuarioDao(factory.getConexion());
    }

    public boolean buscarUsuario(String usuario, String contrasena) {
        return usuarioDao.buscarUsuario(usuario, contrasena);
    }

}
