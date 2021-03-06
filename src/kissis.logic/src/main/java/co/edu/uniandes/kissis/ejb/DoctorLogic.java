package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.ICitaLogic;
import co.edu.uniandes.kissis.api.IDoctorLogic;
import co.edu.uniandes.kissis.converters.DoctorConverter;
import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
import co.edu.uniandes.kissis.entities.DoctorEntity;
import co.edu.uniandes.kissis.persistence.DoctorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DoctorLogic implements IDoctorLogic 
{
    @Inject private DoctorPersistence persistence;
    
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
    
    public void crearCitas (List<CitaDTO> citas)
    {
        for (CitaDTO c: citas)
        {
            citaLogic.createCita(c);           
        }
    }
    
    
}
