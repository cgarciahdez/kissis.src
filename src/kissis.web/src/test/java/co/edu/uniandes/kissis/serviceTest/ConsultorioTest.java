/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.serviceTest;

import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import co.edu.uniandes.kissis.providers.EJBExceptionMapper;
import co.edu.uniandes.kissis.service.ConsultorioService;
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
public class ConsultorioTest {

    public static String URLRESOURCES = "src/main/webapp";
    public static String URLBASE = "http://localhost:8181/kissis.web/webresources";
    public static String PATHBOOK = "/consultorios";
    public static int Ok = 200;
    public static int Created = 201;
    public static int OkWithoutContent = 204;
    public static List<ConsultorioDTO> oraculo = new ArrayList<>();

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
                .addPackage(ConsultorioService.class.getPackage())
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
            ConsultorioDTO consultorio = factory.manufacturePojo(ConsultorioDTO.class);
            oraculo.add(consultorio);
        }
    }


    @Test
    @RunAsClient
    public void t1CreateConsultorioService() throws IOException {
        ConsultorioDTO consultorio = oraculo.get(0);
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK)
                .request()
                .post(Entity.entity(consultorio, MediaType.APPLICATION_JSON));

        ConsultorioDTO consultorioTest = (ConsultorioDTO) response.readEntity(ConsultorioDTO.class);
        Assert.assertEquals(consultorio.getEspecialidad(), consultorioTest.getEspecialidad());
        Assert.assertEquals(consultorio.getTipo(), consultorioTest.getTipo());
        Assert.assertEquals(consultorio.getTamanio(), consultorioTest.getTamanio());
        Assert.assertEquals(consultorio.getExtension(), consultorioTest.getExtension());
        Assert.assertEquals(consultorio.getId(), consultorioTest.getId());
        Assert.assertEquals(Created, response.getStatus());
    }

    @Test
    @RunAsClient
    public void t2GetConsultorioById() {
        Client cliente = ClientBuilder.newClient();
        ConsultorioDTO consultorioTest = cliente.target(URLBASE + PATHBOOK).path("/" + oraculo.get(0).getId())
                .request().get(ConsultorioDTO.class);
        
        Assert.assertEquals(consultorioTest.getEspecialidad(), oraculo.get(0).getEspecialidad());
        Assert.assertEquals(consultorioTest.getTipo(), oraculo.get(0).getTipo());
        Assert.assertEquals(consultorioTest.getTamanio(), oraculo.get(0).getTamanio());
        Assert.assertEquals(consultorioTest.getExtension(), oraculo.get(0).getExtension());
    }

    @Test
    @RunAsClient
    public void t3GetCountryService() throws IOException {
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK)
                .request().get();
        String listConsultorio = response.readEntity(String.class);
        List<ConsultorioDTO> listConsultorioTest = new ObjectMapper().readValue(listConsultorio, List.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(1, listConsultorioTest.size());
    }

    @Test
    @RunAsClient
    public void t4UpdateConsultorioService() throws IOException {
        ConsultorioDTO consultorio = oraculo.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ConsultorioDTO consultorioChanged = factory.manufacturePojo(ConsultorioDTO.class);
        consultorio.setEspecialidad(consultorioChanged.getEspecialidad());
        consultorio.setTipo(consultorioChanged.getTipo());
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK).path("/" + consultorio.getId())
                .request().put(Entity.entity(consultorio, MediaType.APPLICATION_JSON));
        ConsultorioDTO consultorioTest = (ConsultorioDTO) response.readEntity(ConsultorioDTO.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(consultorio.getEspecialidad(), consultorioTest.getEspecialidad());
        Assert.assertEquals(consultorio.getTipo(), consultorioTest.getTipo());
        Assert.assertEquals(consultorio.getTamanio(), consultorioTest.getTamanio());
        Assert.assertEquals(consultorio.getExtension(), consultorioTest.getExtension());

    }

    @Test
    @RunAsClient
    public void t5DeleteCountryService() {
        Client cliente = ClientBuilder.newClient();
        ConsultorioDTO consultorio = oraculo.get(0);
        Response response = cliente.target(URLBASE + PATHBOOK).path("/" + consultorio.getId())
                .request().delete();
        Assert.assertEquals(OkWithoutContent, response.getStatus());
    }

}
