package com.ceiba.revision.servicio;


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
    public void validarCobroCalificacionMala(){
        //Arrange
        RevisionTestDataBuilder revisionTestDataBuilder = new RevisionTestDataBuilder().asignaCalificacion("Mala");
        Revision revision = revisionTestDataBuilder.build();
        RepositorioRevision repositorioRevision= Mockito.mock(RepositorioRevision.class);
        Mockito.when(repositorioRevision.calcularValorRevision(revision.getCalificacion())).thenReturn(30000);
        ServicioGuardarRevision servicioGuardarRevision = new ServicioGuardarRevision(repositorioRevision);
        //Act - Assert
        Assert.assertEquals(servicioGuardarRevision.calcularValorRevision(revision), 30000);
    }

    @Test
    public void validarCobroCalificacionBuena(){
        //Arrange
        RevisionTestDataBuilder revisionTestDataBuilder = new RevisionTestDataBuilder().asignaCalificacion("Buena");
        Revision revision = revisionTestDataBuilder.build();
        RepositorioRevision repositorioRevision= Mockito.mock(RepositorioRevision.class);
        Mockito.when(repositorioRevision.calcularValorRevision(revision.getCalificacion())).thenReturn(50000);
        ServicioGuardarRevision servicioGuardarRevision = new ServicioGuardarRevision(repositorioRevision);
        //Act - Assert
        Assert.assertEquals(servicioGuardarRevision.calcularValorRevision(revision), 50000);
    }

    @Test
    public void validarFechaProximaRevision(){
        //Arrange
        RevisionTestDataBuilder revisionTestDataBuilder = new RevisionTestDataBuilder().asignaFechaVisita(Calendar.getInstance().getTime());
        Revision revision =revisionTestDataBuilder.build();
        Calendar f = Calendar.getInstance();

        f.setTime(revision.getFechaVisita());
        f.add(Calendar.YEAR, 5);
        int ultimoDia = f.getMaximum(Calendar.DAY_OF_MONTH);
        f.set(Calendar.DAY_OF_MONTH, ultimoDia);
        int dia = f.get(Calendar.DAY_OF_WEEK)-1 == 0 ? 7 : f.get(Calendar.DAY_OF_WEEK)-1;
        if(dia==7){ ultimoDia=ultimoDia-2;}
        else if(dia==6){ultimoDia=ultimoDia-1;}
        f.set(Calendar.DAY_OF_MONTH, ultimoDia);

        RepositorioRevision repositorioRevision= Mockito.mock(RepositorioRevision.class);
        Mockito.when(repositorioRevision.calcularFechaProximaRevision(revision.getFechaVisita())).thenReturn(f.getTime());
        ServicioGuardarRevision servicioGuardarRevision = new ServicioGuardarRevision(repositorioRevision);
        //Act - Assert
        Assert.assertEquals(servicioGuardarRevision.calcularFechaProximaRevision(revision), new Date());
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
