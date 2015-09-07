package co.edu.uniandes.kissis.api;

import co.edu.uniandes.kissis.dtos.AdminDTO;
import java.util.List;

public interface IAdminLogic {
    public List<AdminDTO> getAdmins();
    public AdminDTO getAdmin(Long id);
    public AdminDTO createAdmin(AdminDTO dto);
    public AdminDTO updateAdmin(AdminDTO dto);
    public void deleteAdmin(Long id);
}

