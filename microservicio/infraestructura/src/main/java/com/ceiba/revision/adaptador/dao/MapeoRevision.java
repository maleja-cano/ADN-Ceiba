package com.ceiba.revision.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.revision.modelo.dto.DtoRevision;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoRevision implements RowMapper<DtoRevision>, MapperResult {
    @Override
    public DtoRevision mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idRevision = resultSet.getLong("idRevision");
        String matriculaInmobiliaria = resultSet.getString("matricualInmobiliaria");
        String direccion = resultSet.getString("direccion");
        Date fechaVisita = resultSet.getDate("fechaVisita");
        String calificacion = resultSet.getString("calificacion");
        Date fechaProximaRevision = resultSet.getDate("fechaProximaRevision");
        int valorRevision = resultSet.getInt("valorRevision");
        return new DtoRevision(idRevision, matriculaInmobiliaria, direccion, fechaVisita, calificacion, fechaProximaRevision, valorRevision);
    }
}
