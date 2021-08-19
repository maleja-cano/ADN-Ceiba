package com.ceiba.revision.comando.fabrica;

import com.ceiba.revision.comando.ComandoRevision;
import com.ceiba.revision.modelo.entidad.Revision;
import org.springframework.stereotype.Component;

@Component
public class FabricaRevision {
    public Revision guardar(ComandoRevision comandoRevision){
        return new Revision(comandoRevision.getIdRevision(),
                            comandoRevision.getMatriculaInmobiliaria(),
                            comandoRevision.getDireccion(),
                            comandoRevision.getFechaVisita(),
                            comandoRevision.getCalificacion());
    }
}
