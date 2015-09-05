/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.ejb;
import co.edu.uniandes.kissis.dtos.EspecialidadDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author df.cubillos10
 */
@Stateless
public class EspecialidadLogic implements IEspecialidadLogic {

    /**
     * Lista que se usara para el manejo de la información del servicio
     */
    private final static List<EspecialidadDTO> especialidad = new ArrayList<EspecialidadDTO>();

    /**
     * Metodo para obtener todos los consultorios
     * @return
     */
    public List<EspecialidadDTO> getEspecialidades() {
        return especialidad;
    }

    /**
     * Metodo para crear un consultorio
     * @param dto
     * @return 
     */
    public EspecialidadDTO createEspecialidad(EspecialidadDTO dto) {
        especialidad.add(dto);
        return dto;
    }

    /**
     * Metodo para actualizar un elemento
     * @param dto
     * @return 
     */
    public EspecialidadDTO updateEspecialidad(String nombre, EspecialidadDTO dto) {
        for (int i = 0; i < especialidad.size(); i++) {
            if (especialidad.get(i).getNombre().equals(nombre)) {
                especialidad.get(i).setNombre(nombre);
                especialidad.get(i).setDescripcion(dto.getDescripcion());
            }
        }
        return dto;
    }

    /**
     * Metodo utilizado para eliminar un elemento
     * @param nombre
     */
    public void deleteEspecialidad(String nombre) {
        for (int i = 0; i < especialidad.size(); i++) {
            if (especialidad.get(i).getNombre().equals(nombre)){
                especialidad.remove(i);
            }
        }
    }
}
