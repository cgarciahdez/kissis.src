package co.edu.uniandes.kissis.converters;

import co.edu.uniandes.kissis.dtos.AdminDTO;
import co.edu.uniandes.kissis.entities.AdminEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class AdminConverter {

    /**
     * @generated
     */
    private AdminConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static AdminDTO refEntity2DTO(AdminEntity entity) {
        if (entity != null) {
            AdminDTO dto = new AdminDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setApellido(entity.getApellido());
            dto.setTipoCC(entity.getTipoCC());
            dto.setCC(entity.getCC());
            dto.setImage(entity.getImage());
            dto.setGenero(entity.getGenero());
            dto.setFechaN(entity.getFechaN());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static AdminEntity refDTO2Entity(AdminDTO dto) {
        if (dto != null) {
            AdminEntity entity = new AdminEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static AdminDTO basicEntity2DTO(AdminEntity entity) {
        if (entity != null) {
            AdminDTO dto = new AdminDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setApellido(entity.getApellido());
            dto.setTipoCC(entity.getTipoCC());
            dto.setCC(entity.getCC());
            dto.setImage(entity.getImage());
            dto.setGenero(entity.getGenero());
            dto.setFechaN(entity.getFechaN());
            
           
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static AdminEntity basicDTO2Entity(AdminDTO dto) {
        if (dto != null) {
            AdminEntity entity = new AdminEntity();
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setApellido(dto.getApellido());
            dto.setTipoCC(entity.getTipoCC());
            dto.setCC(entity.getCC());
            dto.setImage(entity.getImage());
            dto.setGenero(entity.getGenero());
            dto.setFechaN(entity.getFechaN());
            
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static AdminDTO fullEntity2DTO(AdminEntity entity) {
        if (entity != null) {
           AdminDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static AdminEntity fullDTO2Entity(AdminDTO dto) {
        if (dto != null) {
            AdminEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

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
