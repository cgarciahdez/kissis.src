package co.edu.uniandes.kissis.tests;

import co.edu.uniandes.kissis.api.IPacienteLogic;
import co.edu.uniandes.kissis.converters.PacienteConverter;
import co.edu.uniandes.kissis.dtos.PacienteDTO;
import co.edu.uniandes.kissis.ejb.PacienteLogic;
import co.edu.uniandes.kissis.entities.PacienteEntity;
import co.edu.uniandes.kissis.persistence.PacientePersistence;
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
 *
 * @author am.consuegra10
 */
@RunWith(Arquillian.class)
public class PacienteLogicTest
{
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PacienteEntity.class.getPackage())
                .addPackage(PacienteDTO.class.getPackage())
                .addPackage(PacienteConverter.class.getPackage())
                .addPackage(PacienteLogic.class.getPackage())
                .addPackage(IPacienteLogic.class.getPackage())
                .addPackage(PacientePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IPacienteLogic pacienteLogic;

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
        em.createQuery("delete from PacienteEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<PacienteEntity> data = new ArrayList<PacienteEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {            
            PodamFactory factory = new PodamFactoryImpl();
            PacienteEntity entity = PacienteConverter.basicDTO2Entity(factory.manufacturePojo(PacienteDTO.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createPacienteTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PacienteDTO dto = factory.manufacturePojo(PacienteDTO.class);
        PacienteDTO result = pacienteLogic.createPaciente(dto);
        Assert.assertNotNull(result);
        PacienteEntity entity = em.find(PacienteEntity.class, result.getId());

        Assert.assertEquals(dto.getNombre(), entity.getNombre());
        Assert.assertEquals(dto.getApellido(), entity.getApellido());
        Assert.assertEquals(dto.getTipoId(), entity.getTipoId());
        Assert.assertEquals(dto.getIdDato(), entity.getIdDato());
        Assert.assertEquals(dto.getEps(), entity.getEps());
        Assert.assertEquals(dto.getIdEps(), entity.getIdEps());
        Assert.assertEquals(dto.getGenero(), entity.getGenero());
        Assert.assertEquals(dto.getFechaNac(), entity.getFechaNac());
    }

    /**
     * @generated
     */
    @Test
    public void getPacientesTest() {
        List<PacienteDTO> list = pacienteLogic.getPacientes();
        Assert.assertEquals(data.size(), list.size());
        for (PacienteDTO dto : list) {
            boolean found = false;
            for (PacienteEntity entity : data) {
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
    public void getPacienteTest() {
        PacienteEntity entity = data.get(0);
        PacienteDTO dto = pacienteLogic.getPaciente(entity.getId());
        Assert.assertNotNull(dto);
        
        Assert.assertEquals(entity.getNombre(), dto.getNombre());
        Assert.assertEquals(entity.getApellido(), dto.getApellido());
        Assert.assertEquals(entity.getTipoId(), dto.getTipoId());
        Assert.assertEquals(entity.getIdDato(), dto.getIdDato());
        Assert.assertEquals(entity.getEps(), dto.getEps());
        Assert.assertEquals(entity.getIdEps(), dto.getIdEps());
        Assert.assertEquals(entity.getGenero(), dto.getGenero());
        Assert.assertEquals(entity.getFechaNac(), dto.getFechaNac());
    }

    /**
     * @generated
     */
    @Test
    public void deletePacienteTest() {
        PacienteEntity entity = data.get(0);
        pacienteLogic.deletePaciente(entity.getId());
        PacienteEntity deleted = em.find(PacienteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePacienteTest() {
        PacienteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PacienteDTO dto = factory.manufacturePojo(PacienteDTO.class);
        dto.setId(entity.getId());
        
        pacienteLogic.updatePaciente(dto);

        PacienteEntity resp = em.find(PacienteEntity.class, entity.getId());

        Assert.assertEquals(dto.getNombre(), resp.getNombre());
        Assert.assertEquals(dto.getApellido(), resp.getApellido());
        Assert.assertEquals(dto.getTipoId(), resp.getTipoId());
        Assert.assertEquals(dto.getIdDato(), resp.getIdDato());
        Assert.assertEquals(dto.getEps(), resp.getEps());
        Assert.assertEquals(dto.getIdEps(), resp.getIdEps());
        Assert.assertEquals(dto.getGenero(), resp.getGenero());
        Assert.assertEquals(dto.getFechaNac(), resp.getFechaNac());
    }
}
