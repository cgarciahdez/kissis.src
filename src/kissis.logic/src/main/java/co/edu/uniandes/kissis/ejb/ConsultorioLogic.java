package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Clase EJB para el desarrollo de la lógica del negocio y conexión de los
 * servicios con la capa de datos
 */
@Stateless
public class ConsultorioLogic implements IConsultorioLogic {

    /**
     * Lista que se usara para el manejo de la información del servicio
     */
    private final static List<ConsultorioDTO> consultorio = new ArrayList<ConsultorioDTO>();

    /**
     * Metodo para obtener todos los consultorios
     * @return
     */
    public List<ConsultorioDTO> getConsultorios() {
        return consultorio;
    }

    /**
     * Metodo para crear un consultorio
     * @param dto
     * @return 
     */
    public ConsultorioDTO createConsultorio(ConsultorioDTO dto) {
        consultorio.add(dto);
        return dto;
    }

    /**
     * Metodo para actualizar un elemento
     * @param dto
     * @return 
     */
    public ConsultorioDTO updateConsultorio(Long id, ConsultorioDTO dto) {
        for (int i = 0; i < consultorio.size(); i++) {
            if (consultorio.get(i).getId().equals(id)) {
                consultorio.get(i).setId(id);
                consultorio.get(i).setEspecialidad(dto.getEspecialidad());
                consultorio.get(i).setImage(dto.getImage());
                consultorio.get(i).setTipo(dto.getTipo());
                consultorio.get(i).setTamanio(dto.getTamanio());
                consultorio.get(i).setExtension(dto.getExtension());
            }
        }
        return dto;
    }

    /**
     * Metodo utilizado para eliminar un elemento
     * @param id
     */
    public void deleteConsultorio(Long id) {
        for (int i = 0; i < consultorio.size(); i++) {
            if (consultorio.get(i).getId().equals(id)){
                consultorio.remove(i);
            }
        }
    }
}
