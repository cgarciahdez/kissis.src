package co.edu.uniandes.kissis.ejb;

import co.edu.uniandes.kissis.dtos.DoctorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Clase EJB para el desarrollo de la lógica del negocio y conexión de los
 * servicios con la capa de datos
 */
@Stateless
public class DoctorLogic implements IDoctorLogic {

    /**
     * Lista que se usara para el manejo de la información del servicio
     */
    private final static List<DoctorDTO> doctor = new ArrayList<DoctorDTO>();

    /**
     * Metodo para obtener todos los consultorios
     * @return
     */
    public List<DoctorDTO> getDoctores() {
        return doctor;
    }

    /**
     * Metodo para crear un consultorio
     * @param dto
     * @return 
     */
    public DoctorDTO createConsultorio(DoctorDTO dto) {
        doctor.add(dto);
        return dto;
    }

    /**
     * Metodo para actualizar un elemento
     * @param dto
     * @return 
     */
    public DoctorDTO updateDoctor(Long id, DoctorDTO dto) {
        for (int i = 0; i < doctor.size(); i++) {
            if (doctor.get(i).getId().equals(id)) {
                doctor.get(i).setId(id);
                doctor.get(i).setEspecialidad(dto.getEspecialidad());
                doctor.get(i).setNombre(dto.getNombre());
                doctor.get(i).setApellido(dto.getApellido());
                doctor.get(i).setExperiencia(dto.getExperiencia());
                doctor.get(i).setOcupado(dto.getOcupado());
            }
        }
        return dto;
    }

    /**
     * Metodo utilizado para eliminar un elemento
     * @param id
     */
    public void deleteDoctor(Long id) {
        for (int i = 0; i < doctor.size(); i++) {
            if (doctor.get(i).getId().equals(id)){
                doctor.remove(i);
            }
        }
    }
}
