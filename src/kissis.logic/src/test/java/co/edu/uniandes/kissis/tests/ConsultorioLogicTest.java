package co.edu.uniandes.kissis.tests;


import co.edu.uniandes.kissis.api.IConsultorioLogic;
import co.edu.uniandes.kissis.converters.ConsultorioConverter;
import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import co.edu.uniandes.kissis.ejb.ConsultorioLogic;
import co.edu.uniandes.kissis.entities.ConsultorioEntity;
import co.edu.uniandes.kissis.persistence.ConsultorioPersistence;
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
public class ConsultorioLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ConsultorioEntity.class.getPackage())
                .addPackage(ConsultorioDTO.class.getPackage())
                .addPackage(ConsultorioConverter.class.getPackage())
                .addPackage(ConsultorioLogic.class.getPackage())
                .addPackage(IConsultorioLogic.class.getPackage())
                .addPackage(ConsultorioPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IConsultorioLogic bookLogic;

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
        em.createQuery("delete from ConsultorioEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ConsultorioEntity> data = new ArrayList<ConsultorioEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {            
            PodamFactory factory = new PodamFactoryImpl();
            ConsultorioEntity entity = ConsultorioConverter.basicDTO2Entity(factory.manufacturePojo(ConsultorioDTO.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createConsultorioTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ConsultorioDTO dto = factory.manufacturePojo(ConsultorioDTO.class);
        ConsultorioDTO result = bookLogic.createConsultorio(dto);
        Assert.assertNotNull(result);
        ConsultorioEntity entity = em.find(ConsultorioEntity.class, result.getId());

        Assert.assertEquals(dto.getEspecialidad(), entity.getEspecialidad());
        Assert.assertEquals(dto.getTipo(), entity.getTipo());
        Assert.assertEquals(dto.getImage(), entity.getImage());
        Assert.assertEquals(dto.getTamanio(), entity.getTamanio());
        Assert.assertEquals(dto.getExtension(), entity.getExtension());
    }

    /**
     * @generated
     */
    @Test
    public void getConsultoriosTest() {
        List<ConsultorioDTO> list = bookLogic.getConsultorios();
        Assert.assertEquals(data.size(), list.size());
        for (ConsultorioDTO dto : list) {
            boolean found = false;
            for (ConsultorioEntity entity : data) {
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
    public void getConsultorioTest() {
        ConsultorioEntity entity = data.get(0);
        ConsultorioDTO dto = bookLogic.getConsultorio(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getEspecialidad(), dto.getEspecialidad());
        Assert.assertEquals(entity.getTipo(), dto.getTipo());
        Assert.assertEquals(entity.getImage(), dto.getImage());
        Assert.assertEquals(entity.getTamanio(), dto.getTamanio());
        Assert.assertEquals(entity.getExtension(), dto.getExtension());
    }

    /**
     * @generated
     */
    @Test
    public void deleteConsultorioTest() {
        ConsultorioEntity entity = data.get(0);
        bookLogic.deleteConsultorio(entity.getId());
        ConsultorioEntity deleted = em.find(ConsultorioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateConsultorioTest() {
        ConsultorioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ConsultorioDTO dto = factory.manufacturePojo(ConsultorioDTO.class);
        dto.setId(entity.getId());
        
        bookLogic.updateConsultorio(dto);

        ConsultorioEntity resp = em.find(ConsultorioEntity.class, entity.getId());

        Assert.assertEquals(dto.getEspecialidad(), resp.getEspecialidad());
        Assert.assertEquals(dto.getTipo(), resp.getTipo());
        Assert.assertEquals(dto.getImage(), resp.getImage());
        Assert.assertEquals(dto.getTamanio(), resp.getTamanio());
        Assert.assertEquals(dto.getExtension(), resp.getExtension());
    }
}
