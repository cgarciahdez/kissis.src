/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que contiene el DTO 
 */
@XmlRootElement
public class EspecialidadDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id= id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setNombre(String pNombre)
    {
        nombre = pNombre;
    }
    public void setDescripcion(String pDescripcion)
    {
        descripcion = pDescripcion;
    }
    
}
