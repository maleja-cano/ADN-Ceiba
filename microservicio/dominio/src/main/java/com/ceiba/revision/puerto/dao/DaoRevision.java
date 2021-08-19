package com.ceiba.revision.puerto.dao;

import com.ceiba.revision.modelo.dto.DtoRevision;
import com.ceiba.revision.modelo.entidad.Revision;

import java.util.List;

public interface DaoRevision {
    List<DtoRevision> listar();
    DtoRevision buscarxIdRevision(Long idRevision);
}
