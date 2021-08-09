package com.ceiba.revision.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRevision {
    private Long idRevision;
    private String matriculaInmobiliaria;
    private String direccion;
    private Date fechaVisita;
    private String calificacion;
    private Date fechaProximaRevision;
    private int valorRevision;
}
