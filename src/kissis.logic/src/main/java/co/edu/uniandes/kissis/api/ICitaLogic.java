package co.edu.uniandes.kissis.api;

import co.edu.uniandes.kissis.dtos.CitaDTO;
import java.util.List;

public interface ICitaLogic {
    
    public List<CitaDTO> getCitas();
    public List<CitaDTO> getCitasLibres();
    public CitaDTO getCita(Long id);
    public CitaDTO createCita(CitaDTO dto);
    public CitaDTO updateCita(CitaDTO dto);
    public void deleteCita(Long id);

}
