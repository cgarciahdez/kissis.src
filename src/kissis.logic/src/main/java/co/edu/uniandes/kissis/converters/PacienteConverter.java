package co.edu.uniandes.kissis.converters;

import co.edu.uniandes.kissis.dtos.PacienteDTO;
import co.edu.uniandes.kissis.entities.PacienteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amcon_000
 * @generated
 */
public abstract class PacienteConverter
{
    private PacienteConverter(){};
    public static PacienteDTO refEntity2DTO(PacienteEntity entity) {
        if (entity != null) {
            PacienteDTO dto = new PacienteDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setApellido(entity.getApellido());
            dto.setTipoId(entity.getTipoId());
            dto.setIdDato(entity.getIdDato());
            dto.setEps(entity.getEps());
            dto.setIdEps(entity.getIdEps());
            dto.setGenero(entity.getGenero());
            dto.setFechaNac(entity.getFechaNac());

            return dto;
        } else {
            return null;
        }
    }

    
    public static PacienteEntity refDTO2Entity(PacienteDTO dto) {
        if (dto != null) {
            PacienteEntity entity = new PacienteEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }
    
    /**
     * @generated
     */
    public static PacienteDTO basicEntity2DTO(PacienteEntity entity) 
    {
        if (entity != null) 
        {
            PacienteDTO dto = new PacienteDTO();
            
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setApellido(entity.getApellido());
            dto.setTipoId(entity.getTipoId());
            dto.setIdDato(entity.getIdDato());
            dto.setEps(entity.getEps());
            dto.setIdEps(entity.getIdEps());
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
    public static PacienteEntity basicDTO2Entity(PacienteDTO dto)
    {
        if (dto != null)
        {
            PacienteEntity entity = new PacienteEntity();
            
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setApellido(dto.getApellido());
            entity.setTipoId(dto.getTipoId());
            entity.setIdDato(dto.getIdDato());
            entity.setEps(dto.getEps());
            entity.setIdEps(dto.getIdEps());
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

    public static List<PacienteDTO> listEntity2DTO(List<PacienteEntity> entities)
    {
        List<PacienteDTO> dtos = new ArrayList<PacienteDTO>();
        
        if (entities != null)
        {
            for (PacienteEntity entity : entities) 
            {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<PacienteEntity> listDTO2Entity(List<PacienteDTO> dtos)
    {
        List<PacienteEntity> entities = new ArrayList<PacienteEntity>();
        
        if (dtos != null) 
        {
            for (PacienteDTO dto : dtos) 
            {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
