package co.edu.uniandes.kissis.service;

import co.edu.uniandes.kissis.api.IAdminLogic;
import co.edu.uniandes.kissis.dtos.AdminDTO;
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
@Path("/admins")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminService {
    
    @Context 
    private HttpServletResponse response;
    
    @Inject
    private IAdminLogic adminLogic;
    
    /**
     * Metodo POST para la creación de un libro
     * @param dto
     * @return 
     */
    @POST
    public AdminDTO createAdmin(AdminDTO dto) {
        return adminLogic.createAdmin(dto);
    }

    /**
     * Metodo GET para obtener los libros
     * @return 
     */
    @GET
    public List<AdminDTO> getAdmins() {
        return adminLogic.getAdmins();
    }
    
    /**
     * Metodo PUT utilizado principalmente para actualizar
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public AdminDTO updateAdmin(@PathParam("id") Long id, AdminDTO dto) {
        return adminLogic.updateAdmin(dto);
    }

    /**
     * Metodo DELETE usado para eliminar un elemento
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAdmin(@PathParam("id") Long id) {
        adminLogic.deleteAdmin(id);
    }
}
