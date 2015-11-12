package co.edu.uniandes.kissis.api;

import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
import java.util.List;

public interface IDoctorLogic 
{
    public List<DoctorDTO> getDoctores();
    public DoctorDTO getDoctor(Long id);
    public DoctorDTO createDoctor(DoctorDTO dto);
    public DoctorDTO updateDoctor (DoctorDTO dto);
    public void deleteDoctor(Long id);
    
    public void removeCita(Long citaId, Long doctorId);  
    public List<CitaDTO> getCitas(Long doctorId);
    public CitaDTO getCita(Long doctorId, Long citaId);
}
