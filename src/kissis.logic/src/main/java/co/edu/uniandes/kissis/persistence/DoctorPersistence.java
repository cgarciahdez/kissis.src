package co.edu.uniandes.kissis.persistence;

import co.edu.uniandes.kissis.entities.DoctorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author amcon_000
 */
@Stateless
public class DoctorPersistence 
{
    @PersistenceContext(unitName = "DoctorPU")
    protected EntityManager em;

    public DoctorEntity create(DoctorEntity entity)
    {
        em.persist(entity);
        return entity;
    }

    public DoctorEntity update(DoctorEntity entity)
    {
        return em.merge(entity);
    }

    public void delete(Long id)
    {
        DoctorEntity entity = em.find(DoctorEntity.class, id);
        em.remove(entity);
    }

    public DoctorEntity find(Long id)
    {
        return em.find(DoctorEntity.class, id);
    }

    public List<DoctorEntity> findAll()
    {
        Query q = em.createQuery("select u from DoctorEntity u");
        return q.getResultList();
    }
}
