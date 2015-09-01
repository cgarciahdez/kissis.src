package co.edu.uniandes.kissis.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author am.consuegra10
 */
@XmlRootElement
public class PacienteDTO 
{
    //Atributos de la clase
    private String nombre;
    private String apellido;
    private String tipoId;
    private String id;
    private String eps;
    private String idEps;
    private String genero;
    private Date fechaNac;
    
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

    public void setTipoId(String tipoId) 
    {
        this.tipoId = tipoId;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
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
