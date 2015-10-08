package co.edu.uniandes.kissis.dtos;

import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
import co.edu.uniandes.kissis.dtos.PacienteDTO;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class CitaDTO {
    private Long id;
    private Date hora;
    private Date fecha;
    private DoctorDTO doctor;
    private PacienteDTO paciente;
    private ConsultorioDTO consultorio;

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ConsultorioDTO getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(ConsultorioDTO consultorio) {
        this.consultorio = consultorio;
    }


    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
