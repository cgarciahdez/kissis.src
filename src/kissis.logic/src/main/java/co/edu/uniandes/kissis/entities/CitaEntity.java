package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CitaEntity implements Serializable{

    /**
     * La anotación @Id indica a JPA que este campo es la llave primaria de la entidad.
     * La anotación @GeneratedValue indica a JPA que el valor del campo debe ser generado 
     * automáticamente. La secuencia del valor del id dependerá de "Author".
     */
    @Id
    @GeneratedValue(generator = "Cita")
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    private DoctorEntity doctor;
    private PacienteEntity paciente;
    private ConsultorioEntity consultorio;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date horaInicio) {
        this.hora = horaInicio;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public ConsultorioEntity getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(ConsultorioEntity consultorio) {
        this.consultorio = consultorio;
    }

   
}
