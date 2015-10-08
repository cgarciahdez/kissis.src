package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.ICitaLogic;
import co.edu.uniandes.kissis.converters.CitaConverter;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.entities.CitaEntity;
import co.edu.uniandes.kissis.persistence.CitaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author am.consuegra10
 */
@Stateless
public class CitaLogic implements ICitaLogic
{
    
    @Inject private CitaPersistence persistence;

    public List<CitaDTO> getCitas() 
    {
        return CitaConverter.listEntity2DTO(persistence.findAll());
    }

    public CitaDTO getCita(Long id) 
    {
        return CitaConverter.basicEntity2DTO(persistence.find(id));
    }

    public CitaDTO createCita(CitaDTO dto) 
    {
        CitaEntity entity = CitaConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return CitaConverter.basicEntity2DTO(entity);
    }

    public CitaDTO updateCita(CitaDTO dto) 
    {
        CitaEntity entity = persistence.update(CitaConverter.basicDTO2Entity(dto));
        return CitaConverter.basicEntity2DTO(entity);
    }

    public void deleteCita(Long id) 
    {
        persistence.delete(id);
    }
}
