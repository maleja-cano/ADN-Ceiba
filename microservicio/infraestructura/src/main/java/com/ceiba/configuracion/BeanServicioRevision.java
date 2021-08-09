package com.ceiba.configuracion;

import com.ceiba.revision.puerto.repositorio.RepositorioRevision;
import com.ceiba.revision.servicio.ServicioActualizarRevision;
import com.ceiba.revision.servicio.ServicioGuardarRevision;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioRevision {

    @Bean
    public ServicioGuardarRevision servicioGuardarRevision(RepositorioRevision repositorioRevision){
        return new ServicioGuardarRevision(repositorioRevision);
    }

    @Bean
    public ServicioActualizarRevision servicioActualizarRevision(RepositorioRevision repositorioRevision){
        return new ServicioActualizarRevision(repositorioRevision);
    }
}
