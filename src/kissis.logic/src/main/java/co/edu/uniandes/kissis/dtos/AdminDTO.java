package co.edu.uniandes.kissis.dtos;

import java.util.Date;
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
    private String tipoc;
    private int ncedula;
    private String genero;
    private Date fechan;
  
        
    /** Metodos set y get de los atributos */    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipoC() {
        return tipoc;
    }

    public void setTipoC(String tipoc) {
        this.tipoc = tipoc;
    }
     
    public int getNcedula() {
        return ncedula;
    }

    public void setNcedula( int ncedula) {
        this.ncedula = ncedula;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Date getFechaN() {
        return fechan;
    }

    public void setFechaN(Date fechan) {
        this.fechan = fechan;
    }
    
    
   
}

