package co.edu.uniandes.kissis.ejb;


import co.edu.uniandes.kissis.dtos.DoctorDTO;
import java.util.List;

public interface IDoctorLogic 
{
    public List<DoctorDTO> getDoctores();
    public DoctorDTO createConsultorio(DoctorDTO dto);
    public DoctorDTO updateDoctor (Long id, DoctorDTO dto);
    public void deleteDoctor(Long id);
}
