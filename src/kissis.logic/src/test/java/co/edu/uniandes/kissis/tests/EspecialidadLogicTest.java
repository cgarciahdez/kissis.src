package co.edu.uniandes.kissis.tests;


import co.edu.uniandes.kissis.api.IEspecialidadLogic;
import co.edu.uniandes.kissis.converters.EspecialidadConverter;
import co.edu.uniandes.kissis.dtos.EspecialidadDTO;
import co.edu.uniandes.kissis.ejb.EspecialidadLogic;
import co.edu.uniandes.kissis.entities.EspecialidadEntity;
import co.edu.uniandes.kissis.persistence.EspecialidadPersistence;
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

/**
 *
 * @author davidfernando
 */
public class EspecialidadLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(EspecialidadEntity.class.getPackage())
                .addPackage(EspecialidadDTO.class.getPackage())
                .addPackage(EspecialidadConverter.class.getPackage())
                .addPackage(EspecialidadLogic.class.getPackage())
                .addPackage(IEspecialidadLogic.class.getPackage())
                .addPackage(EspecialidadPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IEspecialidadLogic bookLogic;

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
        em.createQuery("delete from EspecialidadEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<EspecialidadEntity> data = new ArrayList<EspecialidadEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {            
            PodamFactory factory = new PodamFactoryImpl();
            EspecialidadEntity entity = EspecialidadConverter.basicDTO2Entity(factory.manufacturePojo(EspecialidadDTO.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createEspecialidadTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EspecialidadDTO dto = factory.manufacturePojo(EspecialidadDTO.class);
        EspecialidadDTO result = bookLogic.createEspecialidad(dto);
        Assert.assertNotNull(result);
        EspecialidadEntity entity = em.find(EspecialidadEntity.class, result.getId());

        Assert.assertEquals(dto.getNombre(), entity.getNombre());
        Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void getEspecialidadesTest() {
        List<EspecialidadDTO> list = bookLogic.getEspecialidades();
        Assert.assertEquals(data.size(), list.size());
        for (EspecialidadDTO dto : list) {
            boolean found = false;
            for (EspecialidadEntity entity : data) {
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
    public void getEspecialidadTest() {
        EspecialidadEntity entity = data.get(0);
        EspecialidadDTO dto = bookLogic.getEspecialidad(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getNombre(), dto.getNombre());
        Assert.assertEquals(entity.getDescripcion(), dto.getDescripcion());
    }

    /**
     * @generated
     */
    @Test
    public void deleteEspecialidadTest() {
        EspecialidadEntity entity = data.get(0);
        bookLogic.deleteEspecialidad(entity.getId());
        EspecialidadEntity deleted = em.find(EspecialidadEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateEspecialidadTest() {
        EspecialidadEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EspecialidadDTO dto = factory.manufacturePojo(EspecialidadDTO.class);
        dto.setId(entity.getId());
        
        bookLogic.updateEspecialidad(dto);

        EspecialidadEntity resp = em.find(EspecialidadEntity.class, entity.getId());

        Assert.assertEquals(dto.getNombre(), resp.getNombre());
        Assert.assertEquals(dto.getDescripcion(), resp.getDescripcion());
    }
}
