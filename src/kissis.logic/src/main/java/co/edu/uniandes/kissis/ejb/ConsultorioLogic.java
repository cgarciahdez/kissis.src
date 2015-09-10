package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.IConsultorioLogic;
import co.edu.uniandes.kissis.converters.ConsultorioConverter;
import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import co.edu.uniandes.kissis.entities.ConsultorioEntity;
import co.edu.uniandes.kissis.persistence.ConsultorioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase EJB para el desarrollo de la lógica del negocio y conexión de los
 * servicios con la capa de datos
 */
@Stateless
public class ConsultorioLogic implements IConsultorioLogic {
 @Inject private ConsultorioPersistence persistence;

    public List<ConsultorioDTO> getConsultorios() {
        return ConsultorioConverter.listEntity2DTO(persistence.findAll());
    }

    public ConsultorioDTO getConsultorio(Long id) {
        return ConsultorioConverter.basicEntity2DTO(persistence.find(id));
    }

    public ConsultorioDTO createConsultorio(ConsultorioDTO dto) {
        ConsultorioEntity entity = ConsultorioConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return ConsultorioConverter.basicEntity2DTO(entity);
    }

    public ConsultorioDTO updateConsultorio(ConsultorioDTO dto) {
        ConsultorioEntity entity = persistence.update(ConsultorioConverter.basicDTO2Entity(dto));
        return ConsultorioConverter.basicEntity2DTO(entity);
    }

    public void deleteConsultorio(Long id) {
        persistence.delete(id);
    }
}
