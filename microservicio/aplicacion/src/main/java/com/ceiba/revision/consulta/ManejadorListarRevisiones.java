package com.ceiba.revision.consulta;

import com.ceiba.revision.modelo.dto.DtoRevision;
import com.ceiba.revision.puerto.dao.DaoRevision;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarRevisiones {
    private final DaoRevision daoRevision;

    public ManejadorListarRevisiones(DaoRevision daoRevision){
        this.daoRevision = daoRevision;
    }

    public List<DtoRevision> listar(){
        return this.daoRevision.listar();
    }
}
