package co.edu.uniandes.kissis.api;


import co.edu.uniandes.kissis.converters.CitaConverter;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.entities.CitaEntity;
import co.edu.uniandes.kissis.persistence.CitaPersistence;
import java.util.List;
/**
 *
 * @author am.consuegra10
 */
public interface ICitaLogic 
{
    public List<CitaDTO> getCitas();
    public CitaDTO getCita(Long id);
    public CitaDTO createCita(CitaDTO dto);
    public CitaDTO updateCita(CitaDTO dto);
    public void deleteCita(Long id);
}
