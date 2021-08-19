package com.ceiba.revision.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Revision {

    private static final String MENSAJE_ERROR_MATRICULA_INMOBILIARIA_OBLIGATORIA = "Debe ingresar la matrícula inmobiliaria del predio";
    private static final String MENSAJE_ERROR_DIRECCION_OBLIGATORIA = "Debe ingresar la dirección del predio";
    private static final String MENSAJE_ERROR_FECHA_VISITA_OBLIGATORIA = "Debe ingresar la fecha de la visita";
    private static final String MENSAJE_ERROR_CALIFICACICON_OBLIGATORIA = "Debe ingresar la calificación de la revisión";

    private static final String MENSAJE_ERROR_FECHA_VISITA_NO_PERMITIDA = "La fecha de la visita no puede ser mayor a la fecha actual";
    private static final String MENSAJE_ERROR_CALIFICACION_NO_PERMITIDA = "La calificación solo puede ser Buena o Mala";


    private Long idRevision;
    private String matriculaInmobiliaria;
    private String direccion;
    private Date fechaVisita;
    private String calificacion;
    @Setter private Date fechaProximaRevision;
    @Setter private int valorRevision;

    public Revision(Long idRevision, String matriculaInmobiliaria, String direccion, Date fechaVisita,
                    String calificacion){
        validarObligatorio(matriculaInmobiliaria, MENSAJE_ERROR_MATRICULA_INMOBILIARIA_OBLIGATORIA);
        validarObligatorio(direccion, MENSAJE_ERROR_DIRECCION_OBLIGATORIA);
        validarObligatorio(fechaVisita, MENSAJE_ERROR_FECHA_VISITA_OBLIGATORIA);
        validarObligatorio(calificacion, MENSAJE_ERROR_CALIFICACICON_OBLIGATORIA);
        validarMayorQueActual(fechaVisita, MENSAJE_ERROR_FECHA_VISITA_NO_PERMITIDA);
        validarValido(calificacion, Calificacion.class, MENSAJE_ERROR_CALIFICACION_NO_PERMITIDA);

        this.idRevision = idRevision;
        this.matriculaInmobiliaria = matriculaInmobiliaria;
        this.direccion = direccion;
        this.fechaVisita = fechaVisita;
        this.calificacion = calificacion;
    }

}
