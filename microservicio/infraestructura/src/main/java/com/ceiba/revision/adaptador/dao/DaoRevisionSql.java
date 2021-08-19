package com.ceiba.revision.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.revision.modelo.dto.DtoRevision;
import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.puerto.dao.DaoRevision;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoRevisionSql implements DaoRevision {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="revision", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="revision", value="buscarxId")
    private static String sqlBuscarxId;

    public DaoRevisionSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRevision> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRevision());
    }

    @Override
    public DtoRevision buscarxIdRevision(Long idRevision) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idRevision", idRevision);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarxId,paramSource, DtoRevision.class);
    }
}
