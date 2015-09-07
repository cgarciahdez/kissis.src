package co.edu.uniandes.kissis.api;

import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import java.util.List;

public interface IConsultorioLogic {
    public List<ConsultorioDTO> getConsultorios();
    public ConsultorioDTO getConsultorio(Long id);
    public ConsultorioDTO createConsultorio(ConsultorioDTO dto);
    public ConsultorioDTO updateConsultorio(ConsultorioDTO dto);
    public void deleteConsultorio(Long id);
}
