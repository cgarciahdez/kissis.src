package co.edu.uniandes.kissis.service;

import co.edu.uniandes.kissis.api.ICitaLogic;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Clase que contiene lo relacionado con el servicio REST
 */
@Path("/citas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CitaService {
    
    @Context 
    private HttpServletResponse response;
    
    @Inject
    private ICitaLogic citaLogic;
    

    @POST
    @StatusCreated
    public CitaDTO createCita(CitaDTO dto) {
        return citaLogic.createCita(dto);     
    }

    /**
     * Metodo GET para obtener los libros
     * @return 
     */
    @GET
    public List<CitaDTO> getCitas() {
        return citaLogic.getCitas();
    }
    
    @GET
    @Path("{libres}")
    public List<CitaDTO> getCitasLibres() {
        return citaLogic.getCitasLibres();
    }
    
    @GET
    @Path("{id: \\d+}")
    public CitaDTO getCita(@PathParam("id") Long id) {
        return citaLogic.getCita(id);
    }
    
    /**
     * Metodo PUT utilizado principalmente para actualizar
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public CitaDTO updateCita(CitaDTO dto) {
        return citaLogic.updateCita(dto);
    }

    /**
     * Metodo DELETE usado para eliminar un elemento
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCita(@PathParam("id") Long id) {
        citaLogic.deleteCita(id);
    }
}
