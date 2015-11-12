package co.edu.uniandes.kissis.dtos;

import co.edu.uniandes.kissis.dtos.ConsultorioDTO;
import co.edu.uniandes.kissis.dtos.DoctorDTO;
import co.edu.uniandes.kissis.dtos.PacienteDTO;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class CitaDTO {
    private Long id;
    private String hora;
    private String fecha;
    private DoctorDTO doctor;
    private PacienteDTO paciente;
    private ConsultorioDTO consultorio;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
