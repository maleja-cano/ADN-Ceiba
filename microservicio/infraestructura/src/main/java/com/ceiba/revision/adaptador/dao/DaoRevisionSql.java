package com.ceiba.revision.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.revision.modelo.dto.DtoRevision;
import com.ceiba.revision.puerto.dao.DaoRevision;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoRevisionSql implements DaoRevision {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="revision", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="revision", value="buscarxMatricula")
    private static String sqlBuscarxMatricula;

    public DaoRevisionSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRevision> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRevision());
    }
}
