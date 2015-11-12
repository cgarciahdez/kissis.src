
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.serviceTest;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
import co.edu.uniandes.kissis.providers.EJBExceptionMapper;
import co.edu.uniandes.kissis.service.DoctorServices;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Google-sama
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class DoctorTest {

    public static String URLRESOURCES = "src/main/webapp";
    public static String URLBASE = "http://localhost:8181/kissis.web/webresources";
    public static String PATHBOOK = "/doctors";
    public static int Ok = 200;
    public static int Created = 201;
    public static int OkWithoutContent = 204;
    public static List<DoctorDTO> oraculo = new ArrayList<>();

    @Deployment
    public static Archive<?> createDeployment() {

        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        WebArchive war = ShrinkWrap
                // Nombre del Proyecto "kissis.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "kissis.web.war")
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(resolver.artifact("co.edu.uniandes.kissis:kissis.logic:1.0")
                        .resolveAsFiles())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(DoctorServices.class.getPackage())
                .addPackage(EJBExceptionMapper.class.getPackage())
                // El archivo que contiene la configuracion a la base de datos. 
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                // El archivo beans.xml es necesario para injeccion de dependencias. 
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));

        return war;
    }

    @BeforeClass
    public static void setUp() {
        for (int i = 0; i < 5; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            DoctorDTO doctor = factory.manufacturePojo(DoctorDTO.class);
            oraculo.add(doctor);
        }
    }


    @Test
    @RunAsClient
    public void t1CreateDoctorService() throws IOException {
        DoctorDTO doctor = oraculo.get(0);
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK)
                .request()
                .post(Entity.entity(doctor, MediaType.APPLICATION_JSON));

        DoctorDTO doctorTest = (DoctorDTO) response.readEntity(DoctorDTO.class);
        Assert.assertEquals(doctor.getEspecialidad(), doctorTest.getEspecialidad());
        Assert.assertEquals(doctor.getApellido(), doctorTest.getApellido());
        Assert.assertEquals(doctor.getNombre(), doctorTest.getNombre());
        Assert.assertEquals(doctor.getGenero(), doctorTest.getGenero());
        Assert.assertEquals(doctor.getId(), doctorTest.getId());
        Assert.assertEquals(doctor.getTipoId(), doctorTest.getTipoId());
        Assert.assertEquals(Created, response.getStatus());
    }

    @Test
    @RunAsClient
    public void t2GetDoctorById() {
        Client cliente = ClientBuilder.newClient();
        DoctorDTO doctorTest = cliente.target(URLBASE + PATHBOOK).path("/" + oraculo.get(0).getId())
                .request().get(DoctorDTO.class);
        
        Assert.assertEquals(doctorTest.getEspecialidad(), oraculo.get(0).getEspecialidad());
        Assert.assertEquals(doctorTest.getApellido(), oraculo.get(0).getApellido());
        Assert.assertEquals(doctorTest.getNombre(), oraculo.get(0).getNombre());
        Assert.assertEquals(doctorTest.getGenero(), oraculo.get(0).getGenero());
        Assert.assertEquals(doctorTest.getTipoId(), oraculo.get(0).getTipoId());
    }

    @Test
    @RunAsClient
    public void t3GetCountryService() throws IOException 
    {
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK)
                .request().get();
        String listDoctor = response.readEntity(String.class);
        List<DoctorDTO> listDoctorTest = new ObjectMapper().readValue(listDoctor, List.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(1, listDoctorTest.size());
    }

    @Test
    @RunAsClient
    public void t4UpdateDoctorService() throws IOException {
        DoctorDTO doctor = oraculo.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DoctorDTO doctorChanged = factory.manufacturePojo(DoctorDTO.class);
        doctor.setEspecialidad(doctorChanged.getEspecialidad());
        doctor.setApellido(doctorChanged.getApellido());
        doctor.setNombre(doctorChanged.getNombre());
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK).path("/" + doctor.getId())
                .request().put(Entity.entity(doctor, MediaType.APPLICATION_JSON));
        DoctorDTO doctorTest = (DoctorDTO) response.readEntity(DoctorDTO.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(doctor.getEspecialidad(), doctorTest.getEspecialidad());
        Assert.assertEquals(doctor.getApellido(), doctorTest.getApellido());
        Assert.assertEquals(doctor.getNombre(), doctorTest.getNombre());
        Assert.assertEquals(doctor.getTipoId(), doctorTest.getTipoId());

    }

    @Test
    @RunAsClient
    public void t5DeleteCountryService() {
        Client cliente = ClientBuilder.newClient();
        DoctorDTO doctor = oraculo.get(0);
        Response response = cliente.target(URLBASE + PATHBOOK).path("/" + doctor.getId())
                .request().delete();
        Assert.assertEquals(OkWithoutContent, response.getStatus());
    }

}