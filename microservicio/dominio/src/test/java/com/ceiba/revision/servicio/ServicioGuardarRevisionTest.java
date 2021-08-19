package com.ceiba.revision.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.puerto.repositorio.RepositorioRevision;
import com.ceiba.revision.servicio.testdatabuilder.RevisionTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;

public class ServicioGuardarRevisionTest {

    @Test
    public void validarFechaVisita(){
        //Arrange
        Date fechaTemp = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(fechaTemp);
        c.add(Calendar.DATE, 1);
        fechaTemp = c.getTime();
        RevisionTestDataBuilder revisionTestDataBuilder = new RevisionTestDataBuilder().asignaFechaVisita(fechaTemp);
        //Act - Assert
        BasePrueba.assertThrows(() -> revisionTestDataBuilder.build(), ExcepcionValorInvalido.class, "La fecha de la visita no puede ser mayor a la fecha actual");
    }

    @Test
    public void validarCalificacionPermitida(){
        //Arrange
        RevisionTestDataBuilder revisionTestDataBuilder = new RevisionTestDataBuilder().asignaCalificacion("BUena");
        //Act - Assert
        BasePrueba.assertThrows(() -> revisionTestDataBuilder.build(), ExcepcionValorInvalido.class, "La calificación solo puede ser Buena o Mala");

    }

    @Test
    public void validarGuardado(){
        //Arrange
        RevisionTestDataBuilder revisionTestDataBuilder = new RevisionTestDataBuilder().asignaId(1L);
        Revision revision = revisionTestDataBuilder.build();
        RepositorioRevision repositorioRevision= Mockito.mock(RepositorioRevision.class);
        Mockito.when(repositorioRevision.guardarRevision(revision)).thenReturn(1L);
        ServicioGuardarRevision servicioGuardarRevision = new ServicioGuardarRevision(repositorioRevision);
        //Act - Assert
        Assert.assertEquals(servicioGuardarRevision.guardarRevision(revision), revision.getIdRevision());
    }
}
