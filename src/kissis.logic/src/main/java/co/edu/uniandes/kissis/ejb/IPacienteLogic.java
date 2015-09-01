package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.dtos.PacienteDTO;
import java.util.List;

/**
 *
 * @author am.consuegra10
 */
public interface IPacienteLogic 
{
    public List<PacienteDTO> getPacientes();
    public PacienteDTO createPaciente(PacienteDTO dto);
    public PacienteDTO updatePaciente(String pTipoId, String pId, PacienteDTO dto);
    public void deletePaciente(String pTipoId, String pId);
}
