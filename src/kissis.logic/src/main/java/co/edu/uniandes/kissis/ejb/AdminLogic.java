package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.dtos.AdminDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Clase EJB para el desarrollo de la lógica del negocio y conexión de los
 * servicios con la capa de datos
 */
@Stateless
public class AdminLogic implements IAdminLogic {

    /**
     * Lista que se usara para el manejo de la información del servicio
     */
    private final static List<AdminDTO> admin = new ArrayList<AdminDTO>();

    /**
     * Metodo para obtener todos los libros
     * @return
     */
    public List<AdminDTO> getAdmins() {
        return admin;
    }

    /**
     * Metodo para crear un libro
     * @param dto
     * @return 
     */
    public AdminDTO createAdmin(AdminDTO dto) {
        admin.add(dto);
        return dto;
    }
    /**
     * Metodo para actualizar un elemento
     * @param dto
     * @return 
     */
    public AdminDTO updateAdmin(Long id, AdminDTO dto) {
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).getId().equals(id)) {
                admin.get(i).setId(id);
                admin.get(i).setNombre(dto.getName());
                admin.get(i).setApellido(dto.getApellido());
                admin.get(i).setImage(dto.getImage());
                admin.get(i).setTipoDoc(dto.getTipoDoc());
                admin.get(i).setnumeroCedula(dto.getnumeroCedula());
                admin.get(i).setTipoAdmin(dto.getTipoAdmin());
            }
        }
        return dto;
    }

    /**
     * Metodo utilizado para eliminar un elemento
     * @param id
     */
    public void deleteAdmin(Long id) {
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).getId().equals(id)){
                admin.remove(i);
            }
        }
    }
}
