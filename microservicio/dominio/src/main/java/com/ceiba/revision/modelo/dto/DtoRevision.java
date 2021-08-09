package com.ceiba.revision.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoRevision {
    private Long idRevision;
    private String matriculaInmobiliaria;
    private String direccion;
    private Date fechaVisita;
    private String calificacion;
    private Date fechaProximaRevision;
    private int valorRevision;
}
