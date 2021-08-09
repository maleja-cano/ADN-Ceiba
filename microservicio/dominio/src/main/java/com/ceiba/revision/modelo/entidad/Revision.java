package com.ceiba.revision.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Revision {
    private Long idRevision;
    private String matriculaInmobiliaria;
    private String direccion;
    private Date fechaVisita;
    private String calificacion;
    private Date fechaProximaRevision;
    private int valorRevision;

    public Revision(Long idRevision, String matriculaInmobiliaria, String direccion, Date fechaVisita,
                    String calificacion, Date fechaProximaRevision, int valorRevision){
        this.idRevision = idRevision;
        this.matriculaInmobiliaria = matriculaInmobiliaria;
        this.direccion = direccion;
        this.fechaVisita = fechaVisita;
        this.calificacion = calificacion;
        this.fechaProximaRevision = fechaProximaRevision;
        this.valorRevision = valorRevision;
    }
}
