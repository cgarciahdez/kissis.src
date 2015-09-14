package co.edu.uniandes.kissis.persistence;

import co.edu.uniandes.kissis.entities.AdminEntity;
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
public class AdminPersistence {
    
    @PersistenceContext(unitName = "kissisPU")
    protected EntityManager em;

    public AdminEntity create(AdminEntity entity)
    {
        em.persist(entity);
        return entity;
    }

    public AdminEntity update(AdminEntity entity)
    {
        return em.merge(entity);
    }

    public void delete(Long id)
    {
        AdminEntity entity = em.find(AdminEntity.class, id);
        em.remove(entity);
    }

    public AdminEntity find(Long id)
    {
        return em.find(AdminEntity.class, id);
    }

    public List<AdminEntity> findAll()
    {
        Query q = em.createQuery("select u from AdminEntity u");
        return q.getResultList();
    }
}
