package com.ceiba.revision.servicio;

import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.puerto.repositorio.RepositorioRevision;
import com.ceiba.revision.utilidades.Calculos;

import java.util.Date;

public class ServicioActualizarRevision {
    private final RepositorioRevision repositorioRevision;

    public ServicioActualizarRevision(RepositorioRevision repositorioRevision){
        this.repositorioRevision = repositorioRevision;
    }

    public void actualizarRevision(Revision revision){
        //boolean existe=this.validarExistenciaPrevia(revision);
        //if(existe) {
            revision.setValorRevision(this.calcularValorRevision(revision));
            revision.setFechaProximaRevision(this.calcularFechaProximaRevision(revision));
            this.repositorioRevision.actualizarRevision(revision);
        //}
    }

    private int calcularValorRevision(Revision revision){
        return new Calculos().calcularValorRevision(revision.getCalificacion());
    }

    private Date calcularFechaProximaRevision(Revision revision){
        return new Calculos().calcularFechaProximaRevision(revision.getFechaVisita());
    }

    private boolean validarExistenciaPrevia(Revision revision) {
        boolean existe = this.repositorioRevision.buscarxId(revision.getIdRevision());
        return existe;
    }
}
