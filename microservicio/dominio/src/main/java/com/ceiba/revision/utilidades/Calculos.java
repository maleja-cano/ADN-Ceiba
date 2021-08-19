package com.ceiba.revision.utilidades;

import com.ceiba.revision.modelo.entidad.Calificacion;

import java.util.Calendar;
import java.util.Date;

public class Calculos {
    private static final int NUMERO_ANIOS_PROXIMA_REVISION=5;
    private static final int VALOR_CALIFICACION_BUENA = 50000;
    private static final int VALOR_CALIFICACION_MALA = 30000;

    public int calcularValorRevision(String calificacion){
        if(calificacion.equals(Calificacion.Buena)){
            return VALOR_CALIFICACION_BUENA;
        }
        else{
             return VALOR_CALIFICACION_MALA;
        }
    }

    public Date calcularFechaProximaRevision(Date fechaRevision){
        Calendar f = Calendar.getInstance();
        f.setTime(fechaRevision);
        f.add(Calendar.YEAR, NUMERO_ANIOS_PROXIMA_REVISION);
        int ultimoDia = f.getMaximum(Calendar.DAY_OF_MONTH);
        f.set(Calendar.DAY_OF_MONTH, ultimoDia);
        int dia = f.get(Calendar.DAY_OF_WEEK)-1 == 0 ? 7 : f.get(Calendar.DAY_OF_WEEK)-1;
        if(dia==7){ ultimoDia=ultimoDia-2;}
        else if(dia==6){ultimoDia=ultimoDia-1;}
        f.set(Calendar.DAY_OF_MONTH, ultimoDia);
        return f.getTime();
    }
}
