package co.edu.uniandes.kissis.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que contiene el DTO 
 */
@XmlRootElement
public class AdminDTO {
    
    /** Atributos de la clase */
    private Long id;
    private String nombre;
    private String apellido;
    private String imagen;
    private String tipoDocumento;
    private int numeroCedula;
    private String tipoDeAdmin;
        
    /** Metodos set y get de los atributos */    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return imagen;
    }

    public void setImage(String imagen) {
        this.imagen = imagen;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getTipoDoc() {
        return tipoDocumento;
    }

    public void setTipoDoc(String isbn) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoAdmin() {
        return tipoDeAdmin;
    }

    public void setTipoAdmin(String tipoDeAdmin) {
        this.tipoDeAdmin = tipoDeAdmin;
    }
    
    public int getnumeroCedula() {
        return numeroCedula;
    }

    public void setnumeroCedula( int numeroCedula) {
        this.numeroCedula = numeroCedula;
    }
   
}

