package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.IAdminLogic;
import co.edu.uniandes.kissis.converters.AdminConverter;
import co.edu.uniandes.kissis.dtos.AdminDTO;
import co.edu.uniandes.kissis.entities.AdminEntity;
import co.edu.uniandes.kissis.persistence.AdminPersistence;
import co.edu.uniandes.kissis.dtos.AdminDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * Clase EJB para el desarrollo de la lógica del negocio y conexión de los
 * servicios con la capa de datos
 */
@Stateless
public class AdminLogic implements IAdminLogic {

    
     @Inject private AdminPersistence persistence;
    
    /**
     * @generated
     */
    public List<AdminDTO> getAdmins() {
        return AdminConverter.listEntity2DTO(persistence.findAll());
    }

    /**
     * @generated
     */
    public AdminDTO getAdmin(Long id) {
        return AdminConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public AdminDTO createAdmin(AdminDTO dto) {
        AdminEntity entity = AdminConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return AdminConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public AdminDTO updateAdmin(AdminDTO dto) {
        AdminEntity entity = persistence.update(AdminConverter.fullDTO2Entity(dto));
        return AdminConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteAdmin(Long id) {
        persistence.delete(id);
    }
}
