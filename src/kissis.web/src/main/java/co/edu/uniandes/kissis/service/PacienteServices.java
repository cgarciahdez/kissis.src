package co.edu.uniandes.kissis.service;

import co.edu.uniandes.kissis.dtos.PacienteDTO;
import co.edu.uniandes.kissis.ejb.IPacienteLogic;
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
 *
 * @author am.consuegra10
 */
@Path("/consult")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteServices
{
    @Context 
    private HttpServletResponse response;
    
    @Inject
    private IPacienteLogic pacienteLogic;
    
    /**
     * Metodo POST para la creación de un paciente
     * @param dto
     * @return 
     */
    @POST
    public PacienteDTO createPaciente(PacienteDTO dto) 
    {
        return pacienteLogic.createPaciente(dto);
    }
    
    /**
     * Metodo GET para obtener los libros
     * @return 
     */
    @GET
    public List<PacienteDTO> getPacientes() 
    {
        return pacienteLogic.getPacientes();
    }
    
     /**
     * Metodo PUT utilizado principalmente para actualizar
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public PacienteDTO updatePaciente(@PathParam("tipoId") String pTipoId, @PathParam("id") String pId, PacienteDTO dto) 
    {
        return pacienteLogic.updatePaciente(pTipoId,pId,dto);
    }
    
    /**
     * Metodo DELETE usado para eliminar un paciente
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePaciente(@PathParam("tipoId") String pTipoId, @PathParam("id") String pId)
    {
        pacienteLogic.deletePaciente(pTipoId,pId);
    }
}
