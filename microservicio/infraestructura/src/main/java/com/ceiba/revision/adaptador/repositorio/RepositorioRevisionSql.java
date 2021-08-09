package com.ceiba.revision.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.puerto.repositorio.RepositorioRevision;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;

@Repository
public class RepositorioRevisionSql implements RepositorioRevision {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="revision", value="guardar")
    private static String sqlCrear;

    @SqlStatement(namespace="revision", value="actualizar")
    private static String sqlActualizar;

    public RepositorioRevisionSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long guardarRevision(Revision revision){
        return this.customNamedParameterJdbcTemplate.crear(revision, sqlCrear);
    }

    @Override
    public void actualizarRevision(Revision revision){
        this.customNamedParameterJdbcTemplate.crear(revision, sqlActualizar);
    }

    @Override
    public int calcularValorRevision(String calificacion){
        int valor=0;
        if(calificacion.equals("Buena")){
            valor=50000;
        }
        else{
            valor=30000;
        }
        return valor;
    }

    @Override
    public Date calcularFechaProximaRevision(Date fechaRevision){
        Calendar f = Calendar.getInstance();
        f.setTime(fechaRevision);
        f.add(Calendar.YEAR, 5);
        int ultimoDia = f.getMaximum(Calendar.DAY_OF_MONTH);
        f.set(Calendar.DAY_OF_MONTH, ultimoDia);
        int dia = f.get(Calendar.DAY_OF_WEEK)-1 == 0 ? 7 : f.get(Calendar.DAY_OF_WEEK)-1;
        if(dia==7){ ultimoDia=ultimoDia-2;}
        else if(dia==6){ultimoDia=ultimoDia-1;}
        f.set(Calendar.DAY_OF_MONTH, ultimoDia);
        return f.getTime();
    }
}
