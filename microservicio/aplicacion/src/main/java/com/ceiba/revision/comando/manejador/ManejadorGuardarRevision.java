package com.ceiba.revision.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.revision.comando.ComandoRevision;
import com.ceiba.revision.comando.fabrica.FabricaRevision;
import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.servicio.ServicioGuardarRevision;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGuardarRevision implements ManejadorComandoRespuesta<ComandoRevision, ComandoRespuesta<Long>> {
    private final FabricaRevision fabricaRevision;
    private final ServicioGuardarRevision servicioGuardarRevision;

    public ManejadorGuardarRevision(FabricaRevision fabricaRevision, ServicioGuardarRevision servicioGuardarRevision){
        this.fabricaRevision = fabricaRevision;
        this.servicioGuardarRevision = servicioGuardarRevision;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRevision comandoRevision){
        Revision revision = this.fabricaRevision.guardar(comandoRevision);
        return new ComandoRespuesta<>(this.servicioGuardarRevision.guardarRevision(revision));
    }
}
