package com.ceiba.revision.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.revision.comando.ComandoRevision;
import com.ceiba.revision.comando.fabrica.FabricaRevision;
import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.servicio.ServicioActualizarRevision;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRevision implements ManejadorComando<ComandoRevision> {
    private final FabricaRevision fabricaRevision;
    private final ServicioActualizarRevision servicioActualizarRevision;

    public ManejadorActualizarRevision(FabricaRevision fabricaRevision, ServicioActualizarRevision servicioActualizarRevision){
        this.fabricaRevision = fabricaRevision;
        this.servicioActualizarRevision = servicioActualizarRevision;
    }

    public void ejecutar(ComandoRevision comandoRevision){
        Revision revision = this.fabricaRevision.guardar(comandoRevision);
        this.servicioActualizarRevision.actualizarRevision(revision);
    }
}
