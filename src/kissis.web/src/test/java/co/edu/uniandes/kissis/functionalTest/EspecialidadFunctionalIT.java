/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.functionalTest;

/**
 *
 * @author davidfernando
 */
import co.edu.uniandes.kissis.dtos.EspecialidadDTO;
import co.edu.uniandes.kissis.service.EspecialidadService;
import java.io.File;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(Arquillian.class)
public class EspecialidadFunctionalIT {
    public static final String DEPLOY = "Prueba";
    
    @Deployment
      public static Archive<?> createDeployment() {
         MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
 
          WebArchive war = ShrinkWrap
                  // Nombre del Proyecto "BookBasico.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                  .create(WebArchive.class, "Kissis.web.war")
                  // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                  .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.kissis:Kissis.logic:1.0")
                         .resolveAsFiles())
                 // Se agregan los compilados de los paquetes que se van a probar
                .addPackage(EspecialidadService.class.getPackage())
                 // Se agrega contenido estatico: html y modulos de javascript.
                 .addAsWebResource(new File(URLRESOURCES, "index.html"))
                 .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/").as(GenericArchive.class), "/src/", Filters.includeAll())
                 // El archivo que contiene la configuracion a la base de datos.
                 .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                 // El archivo beans.xml es necesario para injeccion de dependencias.
                 .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                 // El archivo web.xml es necesario para el despliegue de los servlets
                 .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));

         return war;
     }
    
     private static final String URLRESOURCES = "src/main/webapp";
      private static final String URLBASE = "http://localhost:8181/BookBasico.web/webresources";
      private static final String PATHBOOK = "/especialidades";
      private static WebDriver driver;
      private static final int Ok = 200;
      private static final int Created = 201;
      private static final int OkWithoutContent = 204;
      private static final String URLIMAGE = "http://www.seleniumhq.org/images/big-logo.png";
 
     // Mediante la anotacion @ArquillianResource se obtiene la URL de despliegue de la aplicacion
     @ArquillianResource
      private static URL deploymentURL;
    
     public List<EspecialidadDTO> data = new ArrayList();
     
     @BeforeClass
     public static void setUp() {
         // Crea una instancia del driver de firefox sobre el que se ejecutara la aplicacion.
         driver = new FirefoxDriver();
     }

 @Before
     public void setUpTest() {
         insertData();
         // El browser  va a la url de despliegue. Se ejecuta al inicar cada uno de los metodos de prueba indicados con @Test
         driver.get(deploymentURL.toString());
     }
     
     @AfterClass
     public static void tearDown() throws Exception {
         //Se ejecuta al terminar todos los métodos de prueba indicados con @Test Cierra el browser
         driver.quit();
     }
     @After
      public void clearData() {
          for (int i = 0; i < data.size(); i++) {
              PodamFactory factory = new PodamFactoryImpl();
              EspecialidadDTO especialidad = factory.manufacturePojo(EspecialidadDTO.class);
              Client cliente = ClientBuilder.newClient();
              Response response = cliente.target(URLBASE + PATHBOOK + '/' + data.get(i).getId())
                  .request()
                  .delete();
             if (response.getStatus()== OkWithoutContent)
                 data.remove(especialidad);
         }
     }
      
      private void insertData() {
        for (int i = 0; i < 3; i++) {            
            PodamFactory factory = new PodamFactoryImpl();
            EspecialidadDTO especialidad = factory.manufacturePojo(EspecialidadDTO.class);
           // especialidad.set(URLIMAGE);
            Client cliente = ClientBuilder.newClient();
            Response response = cliente.target(URLBASE + PATHBOOK)
                .request()
                .post(Entity.entity(especialidad, MediaType.APPLICATION_JSON));
            if (response.getStatus()== Ok)
                data.add(especialidad);
        }
      }
      
      //------------------------------
      //-------TESTS-------
      //-----------------------------
      
      /**
     * El test crea una especialidad y luego verifica que la especialidad creada haya sido
     * publicada correctamente en la lista.
     *
     * @throws java.lang.InterruptedException
     */
    @Test
    @RunAsClient
    public void t1createEspecialidad() throws InterruptedException {
        boolean success = false;
        Thread.sleep(2500);
        driver.findElement(By.id("create-especialidad")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("nueva especialidad");
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("nueva descripcion");
        driver.findElement(By.id("save-doctor")).click();
        Thread.sleep(2000);
        List<WebElement> especialidades = driver.findElements(By.xpath("//div[contains(@ng-repeat,'record in records')]"));
        for (WebElement especialidad : especialidades) {
            List<WebElement> captions = especialidad.findElements(By.xpath("div[contains(@class, 'col-md-4')]/div[contains(@class, 'caption')]/p"));
            if (captions.get(0).getText().contains("nueva especialidad") && captions.get(1).getText().contains("nueva descripcion"))
                    {
                success = true;
            }
        }
        assertTrue(success);
        Thread.sleep(1000);
    }

      
      
      
     /**
       * El test edita una especialidad ya creaao y luego verifica que la especialidad editada
       * haya sido publicada correctamente en la lista de especialidades.
       *
       * @throws java.lang.InterruptedException
       */
      @Test
      @RunAsClient
      public void t2EditEspecialidad() throws InterruptedException {
         Thread.sleep(1500);
         boolean success = false;
         String newDescription = "Nueva descripcion";
         driver.findElement(By.id("-edit-btn")).click(); //Hace click en el primer elemento edit-btn encontrado
         Thread.sleep(1000);
         driver.findElement(By.id("descripcion")).clear();
         driver.findElement(By.id("descripcion")).sendKeys("nueva descripcion");
         driver.findElement(By.id("name")).clear();
         driver.findElement(By.id("name")).sendKeys("nuevo nombre");
         driver.findElement(By.id("save-book")).click();
         Thread.sleep(1000);
         List<WebElement> especialidades = driver.findElements(By.xpath("//div[contains(@ng-repeat,'record in records')]"));
         for (WebElement especialidad : especialidades) {
             List<WebElement> captions = especialidad.findElements(By.xpath("div[contains(@class, 'col-md-4')]/div[contains(@class, 'caption')]/p"));
             if (captions.get(1).getText().contains(newDescription)
                     && captions.get(2).getText().contains("nuevo nombre")) {
                 success = true;
                 break;
             }
         }
         assertTrue(success);
    }
      
    /**
     * El test elimina una especialidad de la lista de especialidades. Luego, verifica que la especialidad
     * eliminado haya sido removido correctamente de la misma.
     *
     * @throws java.lang.InterruptedException
     */
    @Test
    @RunAsClient
    public void t3DeleteEspecialidad() throws InterruptedException, IOException {
        Thread.sleep(1500);
        boolean success = false;
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHBOOK)
                .request().get();
        String listEspecialidad = response.readEntity(String.class);
        List<EspecialidadDTO> listEspecialidadTest = new ObjectMapper().readValue(listEspecialidad, List.class);
        driver.findElement(By.id("-delete-btn")).click();// Elimina el primer elemento con encontrado id -delete-btn 
        Thread.sleep(1000);
        List<WebElement> especialidades = driver.findElements(By.xpath("//div[contains(@ng-repeat,'record in records')]"));
        if (especialidades.size() == (listEspecialidadTest.size()-1)) {
            success = true;
        }
        assertTrue(success);
    }  
      
      
      
      
      
      
}
