package co.edu.uniandes.kissis.persistence;

import co.edu.uniandes.kissis.entities.PacienteEntity;
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
public class PacientePersistence
{
    @PersistenceContext(unitName = "kissisPU")
    protected EntityManager em;

    public PacienteEntity create(PacienteEntity entity)
    {
        em.persist(entity);
        return entity;
    }

    public PacienteEntity update(PacienteEntity entity)
    {
        return em.merge(entity);
    }

    public void delete(Long id)
    {
        PacienteEntity entity = em.find(PacienteEntity.class, id);
        em.remove(entity);
    }

    public PacienteEntity find(Long id)
    {
        return em.find(PacienteEntity.class, id);
    }

    public List<PacienteEntity> findAll()
    {
        Query q = em.createQuery("select u from PacienteEntity u");
        return q.getResultList();
    }
}
