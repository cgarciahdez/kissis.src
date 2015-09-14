package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 * @generated
 */
@Entity
public class AdminEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Admin")
    private Long id;
    private String nombre;
    private String apellido;
    private String imagen;
    private String tipoc;
    private int ncedula;
    private String genero;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechan;
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
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

    public void setImage(String imagen) {
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

    public void setNcedula(int ncedula) {
        this.ncedula = ncedula;
    }
    
     public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Date getFechan() {
        return fechan;
    }

    public void setFechan(Date fechan) {
        this.fechan = fechan;
    }

}
