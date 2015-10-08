package co.edu.uniandes.kissis.persistence;

import co.edu.uniandes.kissis.entities.CitaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author am.consuegra10
 */
@Stateless
public class CitaPersistence 
{
    @PersistenceContext(unitName = "ConsultorioPU")
    protected EntityManager em;

    public CitaEntity create(CitaEntity entity)
    {
        em.persist(entity);
        return entity;
    }

    public CitaEntity update(CitaEntity entity)
    {
        return em.merge(entity);
    }

    public void delete(Long id)
    {
        CitaEntity entity = em.find(CitaEntity.class, id);
        em.remove(entity);
    }

    public CitaEntity find(Long id)
    {
        return em.find(CitaEntity.class, id);
    }

    public List<CitaEntity> findAll()
    {
        Query q = em.createQuery("select u from CitaEntity u");
        return q.getResultList();
    }
}
