/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.serviceTest;
import co.edu.uniandes.kissis.dtos.AdminDTO;
import co.edu.uniandes.kissis.providers.EJBExceptionMapper;
import co.edu.uniandes.kissis.service.AdminService;
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
 * @author Jhonatan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class AdminTest {

    public static String URLRESOURCES = "src/main/webapp";
    public static String URLBASE = "http://localhost:8181/kissis.web/webresources";
    public static String PATHBOOK = "/admins";
    public static int Ok = 200;
    public static int Created = 201;
    public static int OkWithoutContent = 204;
    public static List<AdminDTO> oraculo = new ArrayList<>();

    @Deployment
    public static Archive<?> createDeployment() {

        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        WebArchive war = ShrinkWrap
                // Nombre del Proyecto "Adminbasico.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "kissis.web.war")
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.kissis:kissis.logic:1.0")
                        .resolveAsFiles())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(AdminService.class.getPackage())
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
            AdminDTO Admin = factory.manufacturePojo(AdminDTO.class);
            oraculo.add(Admin);
        }
    }


    @Test
    @RunAsClient
    public void t1CreateAdminService() throws IOException {
        AdminDTO Admin = oraculo.get(0);
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK)
                .request()
                .post(Entity.entity(Admin, MediaType.APPLICATION_JSON));
        AdminDTO AdminTest = (AdminDTO) response.readEntity(AdminDTO.class);
        Assert.assertEquals(Admin.getNombre(), AdminTest.getNombre());
        Assert.assertEquals(Admin.getApellido(), AdminTest.getApellido());
        Assert.assertEquals(Admin.getGenero(), AdminTest.getGenero());
        Assert.assertEquals(Admin.getTipoC(), AdminTest.getTipoC());
        Assert.assertEquals(Admin.getNcedula(), AdminTest.getNcedula());
        Assert.assertEquals(Admin.getImagen(), AdminTest.getImagen());  
        Assert.assertEquals(Created, response.getStatus());
    }

    @Test
    @RunAsClient
    public void t2GetAdminById() {
        Client cliente = ClientBuilder.newClient();
        AdminDTO AdminTest = cliente.target(URLBASE + PATHBOOK).path("/" + oraculo.get(0).getId())
                .request().get(AdminDTO.class);
        Assert.assertEquals(AdminTest.getNombre(), oraculo.get(0).getNombre());
        Assert.assertEquals(AdminTest.getApellido(), oraculo.get(0).getApellido());
        Assert.assertEquals(AdminTest.getGenero(), oraculo.get(0).getGenero());
        Assert.assertEquals(AdminTest.getTipoC(), oraculo.get(0).getTipoC());
        Assert.assertEquals(AdminTest.getNcedula(), oraculo.get(0).getNcedula());
        Assert.assertEquals(AdminTest.getImagen(), oraculo.get(0).getImagen());
    }

    @Test
    @RunAsClient
    public void t3GetCountryService() throws IOException {
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK)
                .request().get();
        String listAdmin = response.readEntity(String.class);
        List<AdminDTO> listAdminTest = new ObjectMapper().readValue(listAdmin, List.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(1, listAdminTest.size());
    }

    @Test
    @RunAsClient
    public void t4UpdateAdminService() throws IOException {
        AdminDTO Admin = oraculo.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AdminDTO AdminChanged = factory.manufacturePojo(AdminDTO.class);
        Admin.setNombre(AdminChanged.getNombre());
        Admin.setApellido(AdminChanged.getApellido());
        Admin.setGenero(AdminChanged.getGenero());
        Admin.setTipoC(AdminChanged.getTipoC());
        Admin.setNcedula(AdminChanged.getNcedula());
        Admin.setImagen(AdminChanged.getImagen());
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK).path("/" + Admin.getId())
                .request().put(Entity.entity(Admin, MediaType.APPLICATION_JSON));
        AdminDTO AdminTest = (AdminDTO) response.readEntity(AdminDTO.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(Admin.getNombre(), AdminTest.getNombre());
        Assert.assertEquals(Admin.getApellido(), AdminTest.getApellido());
        Assert.assertEquals(Admin.getGenero(), AdminTest.getGenero());
        Assert.assertEquals(Admin.getTipoC(), AdminTest.getTipoC());
        Assert.assertEquals(Admin.getNcedula(), AdminTest.getNcedula());
        Assert.assertEquals(Admin.getImagen(), AdminTest.getImagen());
    }

    @Test
    @RunAsClient
    public void t5DeleteCountryService() {
        Client cliente = ClientBuilder.newClient();
        AdminDTO Admin = oraculo.get(0);
        Response response = cliente.target(URLBASE + PATHBOOK).path("/" + Admin.getId())
                .request().delete();
        Assert.assertEquals(OkWithoutContent, response.getStatus());
    }
    
    }
