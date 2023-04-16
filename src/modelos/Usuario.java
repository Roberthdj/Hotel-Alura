package modelos;

public class Usuario {

    private int id;
    private String usuario;
    private String contrasena;

    public Usuario() {
    }   

    public Usuario(int idUsuario, String usuario, String contrasena) {
        this.id = idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }   
    
}
