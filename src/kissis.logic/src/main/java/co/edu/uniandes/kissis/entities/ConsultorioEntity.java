package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

/**
 * @generated
 */
@Entity
public class ConsultorioEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Consultorio")
    private Long id;

    private String especialidad;

    private String tipo;

    private String image;

    private String tamanio;
    
    private int extension;

    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getEspecialidad(){
        return especialidad;
    }

    /**
     * @generated
     */
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    /**
     * @generated
     */
    public String getTipo(){
        return tipo;
    }

    /**
     * @generated
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * @generated
     */
    public String getImage(){
        return image;
    }

    /**
     * @generated
     */
    public void setImage(String image){
        this.image = image;
    }

    /**
     * @generated
     */
    public String getTamanio(){
        return tamanio;
    }

    /**
     * @generated
     */
    public void setTamanio(String tamanio){
        this.tamanio = tamanio;
    }
    
    public int getExtension(){
        return extension;
    }
    
    public void setExtension(int extension)
    {
        this.extension = extension;
    }

}
