package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.dtos.PacienteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author am.consuegra10
 */
@Stateless
public class PacienteLogic implements IPacienteLogic
{
    /**
     * Lista que se usara para el manejo de la información del servicio
     */
    private final static List<PacienteDTO> pacientes = new ArrayList<PacienteDTO>();
    /**
     * Metodo para obtener todos los pacientes
     * @return pacientes
     */
    public List<PacienteDTO> getPacientes() 
    {
        return pacientes;
    }

    /**
     * Metodo para crear un paciente
     * @param dto
     * @return paciente creado
     */
    public PacienteDTO createPaciente(PacienteDTO dto) 
    {
        pacientes.add(dto);
        return dto;
    }

    /**
     * Metodo para actualizar un paciente
     * @param dto
     * @return 
     */
    public PacienteDTO updatePaciente(String pTipoId, String pId, PacienteDTO dto) 
    {
        for (int i = 0; i < pacientes.size(); i++) 
        {
            PacienteDTO actual = pacientes.get(i);
            
            if (actual.getTipoId().equals(pTipoId) && actual.getId().equals(pId)) 
            {
                actual.setNombre(dto.getNombre());
                actual.setApellido(dto.getApellido());
                actual.setTipoId(dto.getTipoId());
                actual.setId(dto.getId());
                actual.setEps(dto.getEps());
                actual.setIdEps(dto.getIdEps());
                actual.setGenero(dto.getGenero());
            }
        }
        return dto;
    }

    /**
     * Metodo utilizado para eliminar un paciente
     * @param 
     */
    public void deletePaciente(String pTipoId, String pId) 
    {
        for (int i = 0; i < pacientes.size(); i++)
        {
            PacienteDTO actual = pacientes.get(i);
            
            if (actual.getTipoId().equals(pTipoId) && actual.getId().equals(pId))
            {
                pacientes.remove(i);
            }
        }
    }
}
