/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.persistence;

/**
 *
 * @author df.cubillos10
 */
import co.edu.uniandes.kissis.entities.EspecialidadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EspecialidadPersistence {
    @PersistenceContext(unitName = "EspecialidadBasicoPU")
    protected EntityManager em;

    public EspecialidadEntity create(EspecialidadEntity entity) {
        em.persist(entity);
        return entity;
    }

    public EspecialidadEntity update(EspecialidadEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        EspecialidadEntity entity = em.find(EspecialidadEntity.class, id);
        em.remove(entity);
    }

    public EspecialidadEntity find(Long id) {
        return em.find(EspecialidadEntity.class, id);
    }

    public List<EspecialidadEntity> findAll() {
        Query q = em.createQuery("select u from EspecialidadEntity u");
        return q.getResultList();
    }
    
}
