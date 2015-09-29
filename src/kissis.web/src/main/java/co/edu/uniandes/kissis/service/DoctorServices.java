package co.edu.uniandes.kissis.service;

import co.edu.uniandes.kissis.api.IDoctorLogic;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
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
 * Clase que contiene lo relacionado con el servicio REST
 */
@Path("/doctores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorServices 
{
    
    @Inject
    private IDoctorLogic doctorLogic;

    @POST
    @StatusCreated
    public DoctorDTO createPaciente(DoctorDTO dto)
    {
        return doctorLogic.createDoctor(dto);
    }

    @GET
    public List<DoctorDTO> getDoctores()
    {
        return doctorLogic.getDoctores();
    }

    @GET
    @Path("{id: \\d+}")
    public DoctorDTO getDoctor(@PathParam("id") Long id)
    {
        return doctorLogic.getDoctor(id);
    }

    @PUT
    @Path("{id: \\d+}")
    public DoctorDTO updateDoctor(@PathParam("id") Long id, DoctorDTO dto)
    {
        dto.setId(id);
        return doctorLogic.updateDoctor(dto);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteBook(@PathParam("id") Long id)
    {
        doctorLogic.deleteDoctor(id);
    }
}
