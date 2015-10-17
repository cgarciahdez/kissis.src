package co.edu.uniandes.kissis.ejb;


import co.edu.uniandes.kissis.api.ICitaLogic;
import co.edu.uniandes.kissis.converters.CitaConverter;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.entities.CitaEntity;
import co.edu.uniandes.kissis.persistence.CitaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CitaLogic implements ICitaLogic  {
    
    @Inject private CitaPersistence persistence;
    
    public CitaDTO createCita(CitaDTO dto) {
        CitaEntity entity = CitaConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return CitaConverter.basicEntity2DTO(entity);
    }

}
