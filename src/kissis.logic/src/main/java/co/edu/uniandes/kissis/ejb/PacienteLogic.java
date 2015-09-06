package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.IPacienteLogic;
import co.edu.uniandes.kissis.converters.PacienteConverter;
import co.edu.uniandes.kissis.dtos.PacienteDTO;
import co.edu.uniandes.kissis.entities.PacienteEntity;
import co.edu.uniandes.kissis.persistence.PacientePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author am.consuegra10
 */
@Stateless
public class PacienteLogic implements IPacienteLogic
{
    @Inject private PacientePersistence persistence;
    
    public List<PacienteDTO> getPacientes() 
    {
        return PacienteConverter.listEntity2DTO(persistence.findAll());
    }

    public PacienteDTO gePaciente(Long id)
    {
        return PacienteConverter.basicEntity2DTO(persistence.find(id));
    }

    public PacienteDTO createPaciente(PacienteDTO dto)
    {
        PacienteEntity entity = PacienteConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return PacienteConverter.basicEntity2DTO(entity);
    }

    public PacienteDTO updatePaciente(PacienteDTO dto)
    {
        PacienteEntity entity = persistence.update(PacienteConverter.basicDTO2Entity(dto));
        return PacienteConverter.basicEntity2DTO(entity);
    }

    public void deletePaciente(Long id)
    {
        persistence.delete(id);
    }
}
