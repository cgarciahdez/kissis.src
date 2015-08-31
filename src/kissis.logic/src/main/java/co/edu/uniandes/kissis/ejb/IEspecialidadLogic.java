/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.ejb;
import co.edu.uniandes.kissis.dtos.EspecialidadDTO;
import java.util.List;

/**
 *
 * @author df.cubillos10
 */
public interface IEspecialidadLogic {
    public List<EspecialidadDTO> getEspecialidades();
    public EspecialidadDTO createEspecialidad(EspecialidadDTO dto);
    public EspecialidadDTO updateEspecialidad(String nombre, EspecialidadDTO dto);
    public void deleteEspecialidad(String nombre);
}
