/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.ejb;
import co.edu.uniandes.kissis.api.IEspecialidadLogic;
import co.edu.uniandes.kissis.converters.EspecialidadConverter;
import co.edu.uniandes.kissis.dtos.EspecialidadDTO;
import co.edu.uniandes.kissis.entities.EspecialidadEntity;
import co.edu.uniandes.kissis.persistence.EspecialidadPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author df.cubillos10
 */
@Stateless
public class EspecialidadLogic implements IEspecialidadLogic {
 @Inject private EspecialidadPersistence persistence;

    @Override
    public List<EspecialidadDTO> getEspecialidades() {
        return EspecialidadConverter.listEntity2DTO(persistence.findAll());
    }

    public EspecialidadDTO getEspecialidad(Long id) {
        return EspecialidadConverter.basicEntity2DTO(persistence.find(id));
    }
    
    @Override
    public EspecialidadDTO createEspecialidad(EspecialidadDTO dto) {
        EspecialidadEntity entity = EspecialidadConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return EspecialidadConverter.basicEntity2DTO(entity);
    }
    @Override
    public EspecialidadDTO updateEspecialidad(EspecialidadDTO dto) {
        EspecialidadEntity entity = persistence.update(EspecialidadConverter.basicDTO2Entity(dto));
        return EspecialidadConverter.basicEntity2DTO(entity);
    }
    @Override
    public void deleteEspecialidad(Long id) {
        persistence.delete(id);
    }
}
