package co.edu.uniandes.kissis.converters;

import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.entities.CitaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author am.consuegra10
 */
public abstract class CitaConverter 
{
    /**
     * @generated
     */
    public static CitaDTO basicEntity2DTO(CitaEntity entity) 
    {
        if (entity != null) 
        {
            CitaDTO dto = new CitaDTO();
            
            dto.setId(entity.getId());
            dto.setPaciente(PacienteConverter.basicEntity2DTO(entity.getPaciente()));
            dto.setDoctor(DoctorConverter.basicEntity2DTO(entity.getDoctor()));
            dto.setDia(entity.getDia());
            dto.setHora(entity.getHora());

            return dto;
        } 
        else
        {
            return null;
        }
    }

    /**
     * @generated
     */
    public static CitaEntity basicDTO2Entity(CitaDTO dto)
    {
        if (dto != null)
        {
            CitaEntity entity = new CitaEntity();
            
            entity.setId(dto.getId());
            entity.setPaciente(PacienteConverter.basicDTO2Entity(dto.getPaciente()));
            entity.setDoctor(DoctorConverter.basicDTO2Entity(dto.getDoctor()));
            entity.setDia(dto.getDia());
            entity.setHora(dto.getHora());
            
            return entity;
        }
        else
        {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<CitaDTO> listEntity2DTO(List<CitaEntity> entities)
    {
        List<CitaDTO> dtos = new ArrayList<CitaDTO>();
        
        if (entities != null)
        {
            for (CitaEntity entity : entities) 
            {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<CitaEntity> listDTO2Entity(List<CitaDTO> dtos)
    {
        List<CitaEntity> entities = new ArrayList<CitaEntity>();
        
        if (dtos != null) 
        {
            for (CitaDTO dto : dtos) 
            {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
