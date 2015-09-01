package co.edu.uniandes.kissis.ejb;


import co.edu.uniandes.kissis.dtos.AdminDTO;
import java.util.List;

public interface IAdminLogic {
    public List<AdminDTO> getAdmins();
    public AdminDTO createAdmin(AdminDTO dto);
    public AdminDTO updateAdmin(Long id, AdminDTO dto);
    public void deleteAdmin(Long id);
}
