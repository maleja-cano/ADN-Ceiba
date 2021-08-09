package com.ceiba.revision.servicio;

import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.puerto.repositorio.RepositorioRevision;

import java.util.Date;

public class ServicioGuardarRevision {
    private final RepositorioRevision repositorioRevision;

    public ServicioGuardarRevision(RepositorioRevision repositorioRevision){
        this.repositorioRevision = repositorioRevision;
    }

    public Long guardarRevision(Revision revision){
        revision.setValorRevision(this.calcularValorRevision(revision));
        revision.setFechaProximaRevision(this.calcularFechaProximaRevision(revision));
        return this.repositorioRevision.guardarRevision(revision);
    }

    public int calcularValorRevision(Revision revision){
        return this.repositorioRevision.calcularValorRevision(revision.getCalificacion());
    }

    public Date calcularFechaProximaRevision(Revision revision){
        return this.repositorioRevision.calcularFechaProximaRevision(revision.getFechaVisita());
    }
}
