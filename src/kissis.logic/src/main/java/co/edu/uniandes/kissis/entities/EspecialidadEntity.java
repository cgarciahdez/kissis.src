/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.entities;

/**
 *
 * @author df.cubillos10
 */
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

/**
 * @generated
 */
@Entity
public class EspecialidadEntity {
   @Id
    @GeneratedValue(generator = "Especialidad")
    private Long id;

    private String nombre;

    private String descripcion;


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
    public String getNombre(){
        return nombre;
    }

    /**
     * @generated
     */
    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    /**
     * @generated
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * @generated
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    
}
