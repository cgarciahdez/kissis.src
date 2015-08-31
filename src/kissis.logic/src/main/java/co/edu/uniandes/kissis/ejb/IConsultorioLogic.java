package co.edu.uniandes.kissis.ejb;


import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import java.util.List;

public interface IConsultorioLogic {
    public List<ConsultorioDTO> getConsultorios();
    public ConsultorioDTO createConsultorio(ConsultorioDTO dto);
    public ConsultorioDTO updateConsultorio(Long id, ConsultorioDTO dto);
    public void deleteConsultorio(Long id);
}
