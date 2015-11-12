package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.ICitaLogic;
import co.edu.uniandes.kissis.api.IDoctorLogic;
import co.edu.uniandes.kissis.converters.CitaConverter;
import co.edu.uniandes.kissis.converters.DoctorConverter;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
import co.edu.uniandes.kissis.entities.CitaEntity;
import co.edu.uniandes.kissis.entities.DoctorEntity;
import co.edu.uniandes.kissis.entities.PacienteEntity;
import co.edu.uniandes.kissis.persistence.CitaPersistence;
import co.edu.uniandes.kissis.persistence.DoctorPersistence;
import co.edu.uniandes.kissis.persistence.PacientePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DoctorLogic implements IDoctorLogic 
{
     
    @Inject private DoctorPersistence persistence;
    
    @Inject private CitaPersistence citaPersistence;
     
    @Inject 
    ICitaLogic citaLogic;
    
    @Override
    public List<DoctorDTO> getDoctores() 
    {
        return DoctorConverter.listEntity2DTO(persistence.findAll());
    }

    @Override
    public DoctorDTO getDoctor(Long id) 
    {
        return DoctorConverter.basicEntity2DTO(persistence.find(id));
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO dto) 
    {
        DoctorEntity entity = DoctorConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return DoctorConverter.basicEntity2DTO(entity);
    }

    @Override
    public DoctorDTO updateDoctor(DoctorDTO dto) 
    {
        DoctorEntity entity = persistence.update(DoctorConverter.basicDTO2Entity(dto));
        return DoctorConverter.basicEntity2DTO(entity);
    }

    @Override
    public void deleteDoctor(Long id) 
    {
        persistence.delete(id);
    }
    
    
    @Override
    public void removeCita(Long citaId, Long doctorId)
    {
        DoctorEntity doctorEntity = persistence.find(doctorId);
        CitaEntity cita = citaPersistence.find(citaId);
        cita.setPaciente(null);
        doctorEntity.getCitas().remove(cita);
    }
     
    @Override
    public List<CitaDTO> getCitas(Long doctorId)
    {
        return CitaConverter.listEntity2DTO(persistence.find(doctorId).getCitas());
    }
    
    @Override
    public CitaDTO getCita(Long doctorId, Long citaId)
    {
        List<CitaEntity> citas = persistence.find(doctorId).getCitas();
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
