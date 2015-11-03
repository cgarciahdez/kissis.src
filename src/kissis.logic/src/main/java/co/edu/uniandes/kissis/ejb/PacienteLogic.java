package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.IPacienteLogic;
import co.edu.uniandes.kissis.converters.CitaConverter;
import co.edu.uniandes.kissis.converters.PacienteConverter;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.dtos.PacienteDTO;
import co.edu.uniandes.kissis.entities.CitaEntity;
import co.edu.uniandes.kissis.entities.PacienteEntity;
import co.edu.uniandes.kissis.persistence.CitaPersistence;
import co.edu.uniandes.kissis.persistence.PacientePersistence;
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
    @Inject private PacientePersistence pacientePersistence;
    
    @Inject private CitaPersistence citaPersistence;
    
    @Override
    public List<PacienteDTO> getPacientes() 
    {
        return PacienteConverter.listEntity2DTO(pacientePersistence.findAll());
    }
    
    @Override
    public PacienteDTO getPaciente(Long id)
    {
        return PacienteConverter.basicEntity2DTO(pacientePersistence.find(id));
    }
    
    @Override
    public PacienteDTO createPaciente(PacienteDTO dto)
    {
        PacienteEntity entity = PacienteConverter.basicDTO2Entity(dto);
        pacientePersistence.create(entity);
        return PacienteConverter.basicEntity2DTO(entity);
    }
    
    @Override
    public PacienteDTO updatePaciente(PacienteDTO dto)
    {
        PacienteEntity entity = pacientePersistence.update(PacienteConverter.basicDTO2Entity(dto));
        return PacienteConverter.basicEntity2DTO(entity);
    }
    
    @Override
    public void deletePaciente(Long id)
    {
        pacientePersistence.delete(id);
    }
    
    @Override
    public CitaDTO addCita(Long citaId, Long pacienteId)
    {
        PacienteEntity pacienteEntity = pacientePersistence.find(pacienteId);
        CitaEntity citaEntity = citaPersistence.find(citaId);
        pacienteEntity.getCitas().add(citaEntity);
        return CitaConverter.basicEntity2DTO(citaEntity);
    }
    
    @Override
    public void removeCita(Long citaId, Long pacienteId)
    {
        PacienteEntity pacienteEntity = pacientePersistence.find(pacienteId);
        CitaEntity cita = citaPersistence.find(citaId);
        cita.setPaciente(null);
        pacienteEntity.getCitas().remove(cita);
    }
    
    @Override
    public List<CitaDTO> replaceCitas(List<CitaDTO> citas, Long pacienteId)
    {
        PacienteEntity paciente = pacientePersistence.find(pacienteId);
        List<CitaEntity> citaList = citaPersistence.findAll();
        List<CitaEntity> newCitaList = CitaConverter.listDTO2Entity(citas);
        
        for (CitaEntity cita : citaList) 
        {
            if (newCitaList.contains(cita)) 
            {
                cita.setPaciente(paciente);
            } 
            else 
            {
                if (cita.getPaciente() != null && cita.getPaciente().equals(paciente)) 
                {
                    cita.setPaciente(null);
                }
            }
        }
        return citas;
    }
    
    @Override
    public List<CitaDTO> getCitas(Long pacienteId)
    {
        return CitaConverter.listEntity2DTO(pacientePersistence.find(pacienteId).getCitas());
    }
    
    @Override
    public CitaDTO getCita(Long pacienteId, Long citaId)
    {
        List<CitaEntity> citas = pacientePersistence.find(pacienteId).getCitas();
        CitaEntity cita = new CitaEntity();
        cita.setId(citaId);
        int index = citas.indexOf(cita);
        
        if (index >= 0)
        {
            return CitaConverter.basicEntity2DTO(citas.get(index));
        }
        return null;
    }
}
