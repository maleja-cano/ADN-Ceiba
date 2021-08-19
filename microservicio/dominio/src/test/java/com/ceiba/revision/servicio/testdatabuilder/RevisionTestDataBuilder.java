package com.ceiba.revision.servicio.testdatabuilder;

import com.ceiba.revision.modelo.entidad.Revision;

import java.util.Calendar;
import java.util.Date;

public class RevisionTestDataBuilder {
    private Long idRevision;
    private String matriculaInmobiliaria;
    private String direccion;
    private Date fechaVisita;
    private String calificacion;
    private Date fechaProximaRevision;
    private int valorRevision;

    public RevisionTestDataBuilder(){
        matriculaInmobiliaria = "230-111111";
        direccion = "Calle 1 Carrera 1";
        fechaVisita = Calendar.getInstance().getTime();
        calificacion = "Buena";
        fechaProximaRevision=Calendar.getInstance().getTime();
        valorRevision=50000;
    }

    public RevisionTestDataBuilder asignaCalificacion(String calificacion){
        this.calificacion = calificacion;
        return this;
    }

    public RevisionTestDataBuilder asignaFechaVisita(Date fechaVisita){
        this.fechaVisita = fechaVisita;
        return this;
    }

    public RevisionTestDataBuilder asignaId(Long idRevision){
        this.idRevision = idRevision;
        return this;
    }

    public Revision build(){
        return new Revision(idRevision, matriculaInmobiliaria, direccion, fechaVisita, calificacion);
    }
}
