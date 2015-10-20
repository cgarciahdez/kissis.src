package co.edu.uniandes.kissis.converters;


import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.entities.CitaEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class CitaConverter {
 
    
    /**
     * Convierte una instancia de CitaEntity a CitaDTO
     * Convierte Únicamente los atributos propios de la entidad y no tiene en 
     * cuenta las relaciones con otras entidades.
     * @param entity instancia de CitaEntity a convertir
     * @return Instancia de CitaDTO con los datos básicos de entity
     */
    public static CitaDTO basicEntity2DTO(CitaEntity entity) {
        if (entity != null) {

            CitaDTO dto = new CitaDTO();
            dto.setId(entity.getId());
            dto.setHora(entity.getHora());
            dto.setFecha(entity.getFecha());
            dto.setDoctor(DoctorConverter.refEntity2DTO(entity.getDoctor()));
            dto.setPaciente(PacienteConverter.refEntity2DTO(entity.getPaciente()));
            dto.setConsultorio(ConsultorioConverter.refEntity2DTO(entity.getConsultorio()));
            
            return dto;
        }
        return null;
    }

    /**
     * Convierte una instancia de CitaDTO a CitaEntity
     * Convierte todos los atributos propios de CitaDTO a la entidad y no 
     * tiene en cuenta las relaciones con otras entidades.
     * @param dto Instancia de CitaDTO a convertir
     * @return Instancia de CitaEntity con los datos básicos de dto
     */
    public static CitaEntity basicDTO2Entity(CitaDTO dto) {
        if (dto != null) {
            CitaEntity entity = new CitaEntity();

            entity.setId(dto.getId());
            entity.setHora(dto.getHora());
            entity.setFecha(dto.getFecha());
            entity.setDoctor(DoctorConverter.refDTO2Entity(dto.getDoctor()));
            entity.setPaciente(PacienteConverter.refDTO2Entity(dto.getPaciente()));
            entity.setConsultorio(ConsultorioConverter.refDTO2Entity(dto.getConsultorio()));

            return entity;
        }
        return null;
    }

    /**
     * Convierte una colección de instancias de CitaEntity a CitaDTO
     * Por cada instancia en la colección invoca basicEntity2DTO (por cada 
     * instancia solo convierte sus atributos básicos) y guarda el
     * resultado en una nueva colección
     * @param entities Colección de instancias de CitaEntity 
     * @return Colección de instancias de CitaDTO
     */
    public static List<CitaDTO> listEntity2DTO(List<CitaEntity> entities) {
        List<CitaDTO> dtos = new ArrayList<CitaDTO>();
        if (entities != null) {
            for (CitaEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de CitaDTO a CitaEntity
     * Por cada instancia en la colección invoca basicDTO2Entity (solo los 
     * atributos básicos) y guarda el
     * resultado en una nueva colección.
     * @param dtos Colección de instancias de CitaDTO
     * @return Colección de instancias de CitaEntity
     */
    public static List<CitaEntity> listDTO2Entity(List<CitaDTO> dtos) {
        List<CitaEntity> entities = new ArrayList<CitaEntity>();
        if (dtos != null) {
            for (CitaDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
