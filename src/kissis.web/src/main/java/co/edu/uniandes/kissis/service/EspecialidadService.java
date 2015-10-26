/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.service;

import co.edu.uniandes.kissis.api.IEspecialidadLogic;
import co.edu.uniandes.kissis.dtos.EspecialidadDTO;
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
 * @author df.cubillos10
 */
@Path("/especialidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EspecialidadService {
   @Context 
    private HttpServletResponse response;
    
    @Inject
    private IEspecialidadLogic especialidadLogic;
    
    /**
     * Metodo POST para la creación de un libro
     * @param dto
     * @return 
     */
    @POST
    public EspecialidadDTO createEspecialidad(EspecialidadDTO dto) {
        return especialidadLogic.createEspecialidad(dto);
    }

    /**
     * Metodo GET para obtener los libros
     * @return 
     */
    @GET
    public List<EspecialidadDTO> getEspecialidades() {
        return especialidadLogic.getEspecialidades();
    }
    
    /**
     * Metodo PUT utilizado principalmente para actualizar
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public EspecialidadDTO updateEspecialidad(@PathParam("id") Long id, EspecialidadDTO dto) {
        return especialidadLogic.updateEspecialidad(dto);
    }

    /**
     * Metodo DELETE usado para eliminar un elemento
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEspecialidad(@PathParam("id") Long id) {
        especialidadLogic.deleteEspecialidad(id);
    }
}
