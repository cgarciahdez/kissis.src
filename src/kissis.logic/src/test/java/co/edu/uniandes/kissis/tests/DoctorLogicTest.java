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
public class DoctorLogicTest 
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
                .addPackage(DoctorDTO.class.getPackage())
                .addPackage(DoctorConverter.class.getPackage())
                .addPackage(DoctorLogic.class.getPackage())
                .addPackage(IDoctorLogic.class.getPackage())
                .addPackage(DoctorPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IDoctorLogic DoctorLogic;

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
    public void configTest() 
    {
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
    private void clearData() 
    {
        em.createQuery("delete from DoctorEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<DoctorEntity> data = new ArrayList<DoctorEntity>();

    /**
     * @generated
     */
    private void insertData() 
    {
        for (int i = 0; i < 3; i++) 
        {            
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
    public void createDoctorTest() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        DoctorDTO dto = factory.manufacturePojo(DoctorDTO.class);
        DoctorDTO result = DoctorLogic.createDoctor(dto);
        Assert.assertNotNull(result);
        DoctorEntity entity = em.find(DoctorEntity.class, result.getId());

        Assert.assertEquals(dto.getEspecialidad(), entity.getEspecialidad());
        Assert.assertEquals(dto.getApellido(), entity.getApellido());
        //Assert.assertEquals(dto.getFechaNac(), entity.getFechaNac());
        Assert.assertEquals(dto.getGenero(), entity.getGenero());
        Assert.assertEquals(dto.getIdDato(), entity.getIdDato());
        Assert.assertEquals(dto.getNombre(), entity.getNombre());
        Assert.assertEquals(dto.getTipoId(), entity.getTipoId());
    }

    /**
     * @generated
     */
    @Test
    public void getDoctorsTest() 
    {
        List<DoctorDTO> list = DoctorLogic.getDoctores();
        Assert.assertEquals(data.size(), list.size());
        for (DoctorDTO dto : list) 
        {
            boolean found = false;
            for (DoctorEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
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
        DoctorDTO dto = DoctorLogic.getDoctor(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getEspecialidad(), dto.getEspecialidad());
        Assert.assertEquals(entity.getApellido(), dto.getApellido());
        //Assert.assertEquals(entity.getFechaNac(), dto.getFechaNac());
        Assert.assertEquals(entity.getIdDato(), dto.getIdDato());
        Assert.assertEquals(entity.getGenero(), dto.getGenero());
        Assert.assertEquals(entity.getNombre(), dto.getNombre());
        Assert.assertEquals(entity.getTipoId(), dto.getTipoId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteDoctorTest() 
    {
        DoctorEntity entity = data.get(0);
        DoctorLogic.deleteDoctor(entity.getId());
        DoctorEntity deleted = em.find(DoctorEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateDoctorTest() 
    {
        DoctorEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DoctorDTO dto = factory.manufacturePojo(DoctorDTO.class);
        dto.setId(entity.getId());
        
        DoctorLogic.updateDoctor(dto);

        DoctorEntity resp = em.find(DoctorEntity.class, entity.getId());

        Assert.assertEquals(dto.getEspecialidad(), resp.getEspecialidad());
        Assert.assertEquals(dto.getApellido(), resp.getApellido());
       // Assert.assertEquals(dto.getFechaNac(), resp.getFechaNac());
        Assert.assertEquals(dto.getGenero(), resp.getGenero());
        Assert.assertEquals(dto.getIdDato(), resp.getIdDato());
        Assert.assertEquals(dto.getNombre(), resp.getNombre());
        Assert.assertEquals(dto.getTipoId(), resp.getTipoId());
    }
}
