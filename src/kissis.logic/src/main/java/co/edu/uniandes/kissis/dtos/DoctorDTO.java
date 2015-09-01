package co.edu.uniandes.kissis.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que contiene el DTO 
 */
@XmlRootElement
public class DoctorDTO {
    
    /** Atributos de la clase */
    private Long id;
    private String especialidad;
    private String nombre;
    private String apellido;
    private int experiencia;
    private boolean ocupado;
        
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

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int exp) {
        this.experiencia = exp;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean pOcupado) {
        this.ocupado = pOcupado;
    }
}
