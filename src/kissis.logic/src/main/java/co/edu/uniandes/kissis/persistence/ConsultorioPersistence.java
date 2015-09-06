/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.persistence;

import co.edu.uniandes.kissis.entities.ConsultorioEntity;
import javax.ejb.Stateless;

/**
 *
 * @author c.garcia11
 */
@Stateless
public class ConsultorioPersistence extends CrudPersistence {
    
    
    public ConsultorioPersistence(){
        this.entityClass = ConsultorioEntity.class;
    }
    
}
