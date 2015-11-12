/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.converters;
import co.edu.uniandes.kissis.dtos.EspecialidadDTO;
import co.edu.uniandes.kissis.entities.EspecialidadEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author df.cubillos10
 */
public abstract class EspecialidadConverter {
    private EspecialidadConverter(){};
    public static EspecialidadDTO basicEntity2DTO(EspecialidadEntity entity) {
        if (entity != null) {
            EspecialidadDTO dto = new EspecialidadDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setDescripcion(entity.getDescripcion());
           
            return dto;
        } else {
            return null;
        }
    }

    public static  EspecialidadEntity basicDTO2Entity( EspecialidadDTO dto) {
        if (dto != null) {
             EspecialidadEntity entity = new  EspecialidadEntity();
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setDescripcion(dto.getDescripcion());
           

            return entity;
        } else {
            return null;
        }
    }

    public static List< EspecialidadDTO> listEntity2DTO(List< EspecialidadEntity> entities) {
        List< EspecialidadDTO> dtos = new ArrayList< EspecialidadDTO>();
        if (entities != null) {
            for ( EspecialidadEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    public static List< EspecialidadEntity> listDTO2Entity(List< EspecialidadDTO> dtos) {
        List< EspecialidadEntity> entities = new ArrayList< EspecialidadEntity>();
        if (dtos != null) {
            for ( EspecialidadDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
