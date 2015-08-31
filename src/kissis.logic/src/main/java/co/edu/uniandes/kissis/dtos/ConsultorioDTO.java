package co.edu.uniandes.kissis.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que contiene el DTO 
 */
@XmlRootElement
public class ConsultorioDTO {
    
    /** Atributos de la clase */
    private Long id;
    private String especialidad;
    private String tipo;
    private String image;
    private String tamanio;
    private int extension;
        
    /** Metodos set y get de los atributos */    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String esp) {
        this.especialidad = esp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tam) {
        this.tamanio = tam;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }
}
