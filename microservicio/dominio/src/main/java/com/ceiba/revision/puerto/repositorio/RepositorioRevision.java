package com.ceiba.revision.puerto.repositorio;

import com.ceiba.revision.modelo.entidad.Revision;

import java.util.Date;

public interface RepositorioRevision {
    Long guardarRevision(Revision revision);
    void actualizarRevision(Revision revision);
    int calcularValorRevision(String calificacion);
    Date calcularFechaProximaRevision(Date fechaRevision);
}
