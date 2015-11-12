package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
/**
 *
 * @author amcon_000
 */
@Entity
public class DoctorEntity implements Serializable
{
    @Id
    @GeneratedValue(generator = "Doctor")
    private Long id;
    
    private String nombre;
    
    private String apellido;
    
    private String tipoId;

    private String idDato;

    private String especialidad;
    
    private String genero;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.PERSIST)
    private List<CitaEntity> citas;

    public List<CitaEntity> getCitas() {
        return citas;
    }
    
    public void setCitas(List<CitaEntity> citas) {
        this.citas = citas;
    }
        
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    
    public String getTipoId() 
    {
        return tipoId;
    }

    public void setTipoId(String tipoID)
    {
        this.tipoId = tipoID;
    }
    
    public String getIdDato() 
    {
        return idDato;
    }

    public void setIdDato(String idDato)
    {
        this.idDato = idDato;
    }
    
    public String getEspecialidad()
    {
        return especialidad;
    }

    public void setEspecialidad(String esp)
    {
        this.especialidad = esp;
    }

    public String getGenero() 
    {
        return genero;
    }

    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    public Date getFechaNac() 
    {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) 
    {
        this.fechaNac = fechaNac;
    }
}
