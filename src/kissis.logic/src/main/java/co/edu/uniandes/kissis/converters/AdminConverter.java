package co.edu.uniandes.kissis.converters;

import co.edu.uniandes.kissis.dtos.AdminDTO;
import co.edu.uniandes.kissis.entities.AdminEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class AdminConverter {

    public static AdminDTO basicEntity2DTO(AdminEntity entity) {
        if (entity != null) {
            AdminDTO dto = new AdminDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setApellido(entity.getApellido());
            dto.setTipoC(entity.getTipoC());
            dto.setNcedula(entity.getNcedula());
            dto.setImagen(entity.getImagen());
            dto.setGenero(entity.getGenero());
            dto.setFechaN(entity.getFechan());
            
            return dto;
        } else {
            return null;
        }
    }
    
     
     public static AdminEntity basicDTO2Entity(AdminDTO dto) {
        if (dto != null) {
            AdminEntity entity = new AdminEntity();
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setApellido(dto.getApellido());
            entity.setTipoC(dto.getTipoC());
            entity.setNcedula(dto.getNcedula());
            entity.setImage(dto.getImagen());
            entity.setGenero(dto.getGenero());
            entity.setFechan(dto.getFechaN());
            
            return entity;
        } else {
            return null;
        }
    }

    public static List<AdminDTO> listEntity2DTO(List<AdminEntity> entities) {
        List<AdminDTO> dtos = new ArrayList<AdminDTO>();
        if (entities != null) {
            for (AdminEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<AdminEntity> listDTO2Entity(List<AdminDTO> dtos) {
        List<AdminEntity> entities = new ArrayList<AdminEntity>();
        if (dtos != null) {
            for (AdminDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
