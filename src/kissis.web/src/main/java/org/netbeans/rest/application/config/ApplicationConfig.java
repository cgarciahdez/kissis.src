/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author c.garcia11
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.uniandes.kissis.providers.CreatedFilter.class);
        resources.add(co.edu.uniandes.kissis.providers.EJBExceptionMapper.class);
        resources.add(co.edu.uniandes.kissis.service.AdminService.class);
        resources.add(co.edu.uniandes.kissis.service.CitaService.class);
        resources.add(co.edu.uniandes.kissis.service.ConsultorioService.class);
        resources.add(co.edu.uniandes.kissis.service.DoctorServices.class);
        resources.add(co.edu.uniandes.kissis.service.EspecialidadService.class);
        resources.add(co.edu.uniandes.kissis.service.PacienteService.class);
    }
    
}
