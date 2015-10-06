package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@NamedQueries({
//    @NamedQuery(
//            name = "AuthorEntity.findByEditorial", 
//            query = "SELECT DISTINCT a FROM AuthorEntity a join a.books b where b.editorial.id = :editorial_id")
//})
public class CitaEntity implements Serializable{

    /**
     * La anotación @Id indica a JPA que este campo es la llave primaria de la entidad.
     * La anotación @GeneratedValue indica a JPA que el valor del campo debe ser generado 
     * automáticamente. La secuencia del valor del id dependerá de "Author".
     */
    @Id
    @GeneratedValue(generator = "Cita")
    private Long id;
    private Date horaInicio;
    private DoctorEntity doctor;
    private PacienteEntity paciente;
    private ConsultorioEntity consultorio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
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
