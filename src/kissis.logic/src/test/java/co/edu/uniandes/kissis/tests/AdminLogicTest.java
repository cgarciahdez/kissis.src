package co.edu.uniandes.kissis.tests;

import co.edu.uniandes.kissis.ejb.AdminLogic;
import co.edu.uniandes.kissis.api.IAdminLogic;
import co.edu.uniandes.kissis.converters.AdminConverter;
import co.edu.uniandes.kissis.dtos.AdminDTO;
import co.edu.uniandes.kissis.entities.AdminEntity;
import co.edu.uniandes.kissis.persistence.AdminPersistence;
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
public class AdminLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(AdminEntity.class.getPackage())
                .addPackage(AdminDTO.class.getPackage())
                .addPackage(AdminConverter.class.getPackage())
                .addPackage(AdminLogic.class.getPackage())
                .addPackage(IAdminLogic.class.getPackage())
                .addPackage(AdminPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IAdminLogic AdminLogic;

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
        em.createQuery("delete from AdminEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<AdminEntity> data = new ArrayList<AdminEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {            
            PodamFactory factory = new PodamFactoryImpl();
            AdminEntity entity = AdminConverter.basicDTO2Entity(factory.manufacturePojo(AdminDTO.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createAdminTest() {
        PodamFactory factory = new PodamFactoryImpl();
        AdminDTO dto = factory.manufacturePojo(AdminDTO.class);
        
        AdminDTO result = AdminLogic.createAdmin(dto);
        Assert.assertNotNull(result);
        
        AdminEntity entity = em.find(AdminEntity.class, result.getId());

        
        Assert.assertEquals(dto.getNombre(), entity.getNombre());
        Assert.assertEquals(dto.getApellido(), entity.getApellido());
        Assert.assertEquals(dto.getTipoC(), entity.getTipoC());
        Assert.assertEquals(dto.getNcedula(), entity.getNcedula());
        Assert.assertEquals(dto.getGenero(), entity.getGenero());
        Assert.assertEquals(dto.getFechaN(), entity.getFechan());
        Assert.assertEquals(dto.getImagen(), entity.getImagen());
    }

    /**
     * @generated
     */
    @Test
    public void getAdminsTest() {
        List<AdminDTO> list = AdminLogic.getAdmins();
        Assert.assertEquals(data.size(), list.size());
        for (AdminDTO dto : list) {
            boolean found = false;
            for (AdminEntity entity : data) {
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
    public void getAdminTest() {
        AdminEntity entity = data.get(0);
        AdminDTO dto = AdminLogic.getAdmin(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getNombre(), dto.getNombre());
        Assert.assertEquals(entity.getApellido(), dto.getApellido());
        Assert.assertEquals(entity.getTipoC(), dto.getTipoC());
        Assert.assertEquals(entity.getNcedula(), dto.getNcedula());
        Assert.assertEquals(entity.getGenero(), dto.getGenero());
        Assert.assertEquals(entity.getFechan(), dto.getFechaN());
        Assert.assertEquals(entity.getImagen(), dto.getImagen());
    }

    /**
     * @generated
     */
    @Test
    public void deleteAdminTest() {
        AdminEntity entity = data.get(0);
        AdminLogic.deleteAdmin(entity.getId());
        AdminEntity deleted = em.find(AdminEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateAdminTest() {
        AdminEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AdminDTO dto = factory.manufacturePojo(AdminDTO.class);
        dto.setId(entity.getId());
        
        AdminLogic.updateAdmin(dto);

        AdminEntity resp = em.find(AdminEntity.class, entity.getId());

        Assert.assertEquals(dto.getNombre(), resp.getNombre());
        Assert.assertEquals(dto.getApellido(), resp.getApellido());
        Assert.assertEquals(dto.getTipoC(), resp.getTipoC());
        Assert.assertEquals(dto.getNcedula(), resp.getNcedula());
        Assert.assertEquals(dto.getGenero(), resp.getGenero());
        Assert.assertEquals(dto.getFechaN(), resp.getFechan());
        Assert.assertEquals(dto.getImagen(), resp.getImagen());
    }
}
