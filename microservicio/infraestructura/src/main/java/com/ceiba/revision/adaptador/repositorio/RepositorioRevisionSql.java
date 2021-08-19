package com.ceiba.revision.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.puerto.repositorio.RepositorioRevision;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRevisionSql implements RepositorioRevision {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="revision", value="guardar")
    private static String sqlCrear;

    @SqlStatement(namespace="revision", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="revision", value="buscarxId")
    private static String sqlBuscarxId;

    public RepositorioRevisionSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long guardarRevision(Revision revision){
        return this.customNamedParameterJdbcTemplate.crear(revision, sqlCrear);
    }

    @Override
    public void actualizarRevision(Revision revision){
        this.customNamedParameterJdbcTemplate.actualizar(revision, sqlActualizar);
    }

    @Override
    public boolean buscarxId(Long idRevision) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idRevision", idRevision);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarxId,paramSource, Boolean.class);
    }

}
