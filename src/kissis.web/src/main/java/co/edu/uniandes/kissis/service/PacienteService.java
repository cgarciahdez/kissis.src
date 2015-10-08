package co.edu.uniandes.kissis.service;

import co.edu.uniandes.kissis.api.IPacienteLogic;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.dtos.PacienteDTO;
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

/**
 *
 * @author am.consuegra10
 */
@Path("/pacientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteService
{
    @Inject
    private IPacienteLogic pacienteLogic;

    @POST
    @StatusCreated
    public PacienteDTO createPaciente(PacienteDTO dto)
    {
        return pacienteLogic.createPaciente(dto);
    }

    @GET
    public List<PacienteDTO> getPacientes()
    {
        return pacienteLogic.getPacientes();
    }

    @GET
    @Path("{id: \\d+}")
    public PacienteDTO getPaciente(@PathParam("id") Long id)
    {
        return pacienteLogic.getPaciente(id);
    }

    @PUT
    @Path("{id: \\d+}")
    public PacienteDTO updatePaciente(@PathParam("id") Long id, PacienteDTO dto)
    {
        dto.setId(id);
        return pacienteLogic.updatePaciente(dto);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteBook(@PathParam("id") Long id)
    {
        pacienteLogic.deletePaciente(id);
    }
    
    @GET
    @Path("{pacienteId: \\d+}/citas")
    public List<CitaDTO> getCitas(@PathParam("pacienteId") Long pacienteId)
    {
        return pacienteLogic.getCitas(pacienteId);
    }
    
    @DELETE
    @Path("{pacienteId: \\d+}/citas/{citaId: \\d+}")
    public void deleteCita(@PathParam("pacienteId") Long pacienteId,@PathParam("citaId") Long cidaId)
    {
        pacienteLogic.removeCita(cidaId, pacienteId);
    }
}
