package co.edu.uniandes.kissis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author amcon_000
 */
@Entity
public class PacienteEntity implements Serializable
{
    @Id
    @GeneratedValue(generator = "Paciente")
    private Long id;
    
    private String nombre;
    
    private String apellido;
    
    private String tipoId;
    
    private String idDato;
    
    private String eps;
    
    private String idEps;
    
    private String genero;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    
    public String getNombre() 
    {
        return nombre;
    }
    
    /**
     * @generated
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id)
    {
        this.id = id;
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

    public void setTipoId(String tipoId) 
    {
        this.tipoId = tipoId;
    }

    public String getIdDato() 
    {
        return idDato;
    }

    public void setIdDato(String idDato) 
    {
        this.idDato = idDato;
    }

    public String getEps() 
    {
        return eps;
    }

    public void setEps(String eps) 
    {
        this.eps = eps;
    }

    public String getIdEps() 
    {
        return idEps;
    }

    public void setIdEps(String idEps) 
    {
        this.idEps = idEps;
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
