package co.edu.uniandes.kissis.service;

import co.edu.uniandes.kissis.api.IAdminLogic;
import co.edu.uniandes.kissis.dtos.AdminDTO;
import co.edu.uniandes.kissis.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/admins")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminService {

    @Inject
    private IAdminLogic adminLogic;

    @POST
    @StatusCreated
    public AdminDTO createAdmin(AdminDTO dto) {
        return adminLogic.createAdmin(dto);
    }

    @GET
    public List<AdminDTO> getAdmins() {
        return adminLogic.getAdmins();
    }

    @GET
    @Path("{id: \\d+}")
    public AdminDTO getAdmin(@PathParam("id") Long id) {
        return adminLogic.getAdmin(id);
    }

    @PUT
    @Path("{id: \\d+}")
    public AdminDTO updateBook(@PathParam("id") Long id, AdminDTO dto) {
        dto.setId(id);
        return adminLogic.updateAdmin(dto);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteAdmin(@PathParam("id") Long id) {
       adminLogic.deleteAdmin(id);
    }
}
