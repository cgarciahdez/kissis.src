package co.edu.uniandes.kissis.converters;

import co.edu.uniandes.kissis.dtos.DoctorDTO;
import co.edu.uniandes.kissis.entities.DoctorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amcon_000
 * generated
 */
public abstract class DoctorConverter 
{
    public static DoctorDTO refEntity2DTO(DoctorEntity entity) {
        if (entity != null) {
            DoctorDTO dto = new DoctorDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setApellido(entity.getApellido());
            dto.setTipoId(entity.getTipoId());
            dto.setIdDato(entity.getIdDato());
            dto.setEspecialidad(entity.getEspecialidad());
            dto.setGenero(entity.getGenero());
            dto.setFechaNac(entity.getFechaNac());

            return dto;
        } else {
            return null;
        }
    }

    
    public static DoctorEntity refDTO2Entity(DoctorDTO dto) {
        if (dto != null) {
            DoctorEntity entity = new DoctorEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }
    /**
     * @generated
     */
    public static DoctorDTO basicEntity2DTO(DoctorEntity entity) 
    {
        if (entity != null) 
        {
            DoctorDTO dto = new DoctorDTO();
            
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setApellido(entity.getApellido());
            dto.setTipoId(entity.getTipoId());
            dto.setIdDato(entity.getIdDato());
            dto.setEspecialidad(entity.getEspecialidad());
            dto.setGenero(entity.getGenero());
            dto.setFechaNac(entity.getFechaNac());

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
    public static DoctorEntity basicDTO2Entity(DoctorDTO dto)
    {
        if (dto != null)
        {
            DoctorEntity entity = new DoctorEntity();
            
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setApellido(dto.getApellido());
            entity.setTipoId(dto.getTipoId());
            entity.setIdDato(dto.getIdDato());
            entity.setEspecialidad(dto.getEspecialidad());
            entity.setGenero(dto.getGenero());
            entity.setFechaNac(dto.getFechaNac());

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
    public static List<DoctorDTO> listEntity2DTO(List<DoctorEntity> entities)
    {
        List<DoctorDTO> dtos = new ArrayList<DoctorDTO>();
        
        if (entities != null)
        {
            for (DoctorEntity entity : entities) 
            {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<DoctorEntity> listDTO2Entity(List<DoctorDTO> dtos)
    {
        List<DoctorEntity> entities = new ArrayList<DoctorEntity>();
        
        if (dtos != null) 
        {
            for (DoctorDTO dto : dtos) 
            {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
