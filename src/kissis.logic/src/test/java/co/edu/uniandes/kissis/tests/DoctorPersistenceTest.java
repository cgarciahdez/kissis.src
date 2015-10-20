/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.tests;

import co.edu.uniandes.kissis.api.IDoctorLogic;
import co.edu.uniandes.kissis.converters.DoctorConverter;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
import co.edu.uniandes.kissis.ejb.DoctorLogic;
import co.edu.uniandes.kissis.entities.DoctorEntity;
import co.edu.uniandes.kissis.persistence.DoctorPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class DoctorPersistenceTest 
{
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() 
    {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(DoctorEntity.class.getPackage())
                .addPackage(DoctorPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private DoctorPersistence DoctorPersistence;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from DoctorEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<DoctorEntity> data = new ArrayList<DoctorEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            DoctorEntity entity = DoctorConverter.basicDTO2Entity(factory.manufacturePojo(DoctorDTO.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createDoctorTest() {
        PodamFactory factory = new PodamFactoryImpl();
        DoctorEntity newEntity = DoctorConverter.basicDTO2Entity(factory.manufacturePojo(DoctorDTO.class));

        DoctorEntity result = DoctorPersistence.create(newEntity);

        Assert.assertNotNull(result);

        DoctorEntity entity = em.find(DoctorEntity.class, result.getId());

        Assert.assertEquals(newEntity.getApellido(), entity.getApellido());
        Assert.assertEquals(newEntity.getEspecialidad(), entity.getEspecialidad());
        Assert.assertEquals(newEntity.getGenero(), entity.getGenero());
        Assert.assertEquals(newEntity.getIdDato(), entity.getIdDato());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getTipoId(), entity.getTipoId());
    }

    /**
     * @generated
     */
    @Test
    public void getDoctorsTest() {
        List<DoctorEntity> list = DoctorPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (DoctorEntity ent : list) {
            boolean found = false;
            for (DoctorEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getDoctorTest() {
        DoctorEntity entity = data.get(0);
        DoctorEntity newEntity = DoctorPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getApellido(), newEntity.getApellido());
        Assert.assertEquals(entity.getEspecialidad(), newEntity.getEspecialidad());
        Assert.assertEquals(entity.getGenero(), newEntity.getGenero());
        Assert.assertEquals(entity.getIdDato(), newEntity.getIdDato());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getTipoId(), entity.getTipoId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteDoctorTest() {
        DoctorEntity entity = data.get(0);
        DoctorPersistence.delete(entity.getId());
        DoctorEntity deleted = em.find(DoctorEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateDoctorTest() {
        DoctorEntity entity = data.get(0);

        PodamFactory factory = new PodamFactoryImpl();
        DoctorEntity newEntity = DoctorConverter.basicDTO2Entity(factory.manufacturePojo(DoctorDTO.class));
        newEntity.setId(entity.getId());

        DoctorPersistence.update(newEntity);

        DoctorEntity resp = em.find(DoctorEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getApellido(), resp.getApellido());
        Assert.assertEquals(newEntity.getEspecialidad(), resp.getEspecialidad());
        Assert.assertEquals(newEntity.getGenero(), resp.getGenero());
        Assert.assertEquals(newEntity.getIdDato(), resp.getIdDato());
        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getTipoId(), resp.getTipoId());
    }
    
}
