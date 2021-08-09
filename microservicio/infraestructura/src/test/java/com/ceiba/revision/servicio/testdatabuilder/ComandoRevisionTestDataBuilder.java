package com.ceiba.revision.servicio.testdatabuilder;


import com.ceiba.revision.comando.ComandoRevision;

import java.util.Calendar;
import java.util.Date;

public class ComandoRevisionTestDataBuilder {
    private Long idRevision;
    private String matriculaInmobiliaria;
    private String direccion;
    private Date fechaVisita;
    private String calificacion;
    private Date fechaProximaRevision;
    private int valorRevision;

    public ComandoRevisionTestDataBuilder(){
        matriculaInmobiliaria = "230-111111";
        direccion = "Calle 1 Carrera 1";
        fechaVisita = Calendar.getInstance().getTime();
        calificacion = "Buena";
    }

    public ComandoRevisionTestDataBuilder asignaCalificacion(String calificacion){
        this.calificacion = calificacion;
        return this;
    }

    public ComandoRevisionTestDataBuilder asignaFechaVisita(Date fechaVisita){
        this.fechaVisita = fechaVisita;
        return this;
    }

    public ComandoRevision build(){
        return new ComandoRevision(idRevision, matriculaInmobiliaria, direccion, fechaVisita, calificacion, fechaProximaRevision, valorRevision);
    }
}
