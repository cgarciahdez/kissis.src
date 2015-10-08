package co.edu.uniandes.kissis.api;

import co.edu.uniandes.kissis.dtos.CitaDTO;
import co.edu.uniandes.kissis.dtos.PacienteDTO;
import java.util.List;

/**
 *
 * @author am.consuegra10
 */
public interface IPacienteLogic 
{
    public List<PacienteDTO> getPacientes();
    public PacienteDTO getPaciente(Long id);
    public PacienteDTO createPaciente(PacienteDTO dto);
    public PacienteDTO updatePaciente(PacienteDTO dto);
    public void deletePaciente(Long id);
    public CitaDTO addCita(Long citaId, Long pacienteId);
    public void removeCita(Long citaId, Long pacienteId);
    public List<CitaDTO> replaceCitas(List<CitaDTO> citas, Long pacienteId);
    public List<CitaDTO> getCitas(Long pacienteId);
    public CitaDTO getCita(Long pacienteId, Long citaId);
}
