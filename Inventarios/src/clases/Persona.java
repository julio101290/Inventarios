/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author ANDRES
 */
public class Persona {

    protected String nombres;
    protected String apellidos;
    protected String direccion;
    protected String ciudad;
    protected String telefono;
    protected String RFC;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Persona(String nombres, String apellidos, String direccion, String ciudad, String telefono, String RFC) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
