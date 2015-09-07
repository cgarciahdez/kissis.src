package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

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
    private String tipoCC;
    private int CC;
    private String genero;
    private Date fechaN;
    
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

    public String getImage() {
        return imagen;
    }

    public void setImage(String imagen) {
        this.imagen = imagen;
    }
    
    public String getTipoCC() {
        return tipoCC;
    }

    public void setTipoCC(String tipoDocumento) {
        this.tipoCC = tipoDocumento;
    }
     
    public int getCC() {
        return CC;
    }

    public void setCC( int CC) {
        this.CC = CC;
    }
    
     public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

}
