package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author am.consuegra10
 */
public class CitaEntity implements Serializable
{
    @Id
    @GeneratedValue(generator = "Cita")
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date dia;
    
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @ManyToOne
    private PacienteEntity paciente;
    
    @ManyToOne
    private DoctorEntity doctor;
    
    @ManyToOne
    private ConsultorioEntity consultorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    } 

    public ConsultorioEntity getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(ConsultorioEntity consultorio) {
        this.consultorio = consultorio;
    }
}
