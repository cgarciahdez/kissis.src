/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.persistence;

import co.edu.uniandes.kissis.entities.ConsultorioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author c.garcia11
 */
@Stateless
public class ConsultorioPersistence {
    
    @PersistenceContext(unitName = "ConsultorioPU")
    protected EntityManager em;

    public ConsultorioEntity create(ConsultorioEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ConsultorioEntity update(ConsultorioEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ConsultorioEntity entity = em.find(ConsultorioEntity.class, id);
        em.remove(entity);
    }

    public ConsultorioEntity find(Long id) {
        return em.find(ConsultorioEntity.class, id);
    }

    public List<ConsultorioEntity> findAll() {
        Query q = em.createQuery("select u from ConsultorioEntity u");
        return q.getResultList();
    }
    
}
