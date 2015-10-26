/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.service;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;
 

/**
 *
 * @author windows 8
 */
@ApplicationPath("webresources")
public class RestConfig extends ResourceConfig
{
    public RestConfig() 
    {
        packages("co.edu.uniandes.csw.bookbasico.services");
        packages("co.edu.uniandes.csw.bookbasico.providers");
        packages("co.edu.uniandes.csw.auth.service");
        packages("co.edu.uniandes.csw.auth.filter");
    }    
}
