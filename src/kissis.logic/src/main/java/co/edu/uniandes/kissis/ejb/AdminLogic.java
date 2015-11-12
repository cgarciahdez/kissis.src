package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.api.IAdminLogic;
import co.edu.uniandes.kissis.converters.AdminConverter;
import co.edu.uniandes.kissis.dtos.AdminDTO;
import co.edu.uniandes.kissis.entities.AdminEntity;
import co.edu.uniandes.kissis.persistence.AdminPersistence;
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
     @Override
    public List<AdminDTO> getAdmins() {
        return AdminConverter.listEntity2DTO(persistence.findAll());
    }

    /**
     * @generated
     */
     @Override
    public AdminDTO getAdmin(Long id) {
        return AdminConverter.basicEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
     @Override
    public AdminDTO createAdmin(AdminDTO dto) {
        AdminEntity entity = AdminConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return AdminConverter.basicEntity2DTO(entity);
    }

    /**
     * @generated
     */
     @Override
    public AdminDTO updateAdmin(AdminDTO dto) {
        AdminEntity entity = persistence.update(AdminConverter.basicDTO2Entity(dto));
        return AdminConverter.basicEntity2DTO(entity);
    }

    /**
     * @generated
     */
     @Override
    public void deleteAdmin(Long id) {
        persistence.delete(id);
    }
}
