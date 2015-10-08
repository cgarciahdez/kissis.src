package co.edu.uniandes.kissis.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author am.consuegra10
 */
@XmlRootElement
public class CitaDTO 
{
    private Long id;
    private PacienteDTO paciente;
    private DoctorDTO doctor;
    private Date dia;
    private Date hora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
}
