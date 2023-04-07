package modelos;

import java.util.Date;

public class Huesped {

    private int id;
    private int id_reserva;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String telefono;

    public Huesped() {
    }

    public Huesped(int id, int id_reserva, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
        this.id = id;
        this.id_reserva = id_reserva;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
