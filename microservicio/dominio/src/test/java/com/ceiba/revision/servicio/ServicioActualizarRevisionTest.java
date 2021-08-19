package com.ceiba.revision.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.revision.modelo.entidad.Revision;
import com.ceiba.revision.puerto.repositorio.RepositorioRevision;
import com.ceiba.revision.servicio.testdatabuilder.RevisionTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarRevisionTest {

    @Test
    public void validarBuscarxId() {
        // arrange
        Revision revision = new RevisionTestDataBuilder().asignaId(1L).build();
        RepositorioRevision repositorioRevision = Mockito.mock(RepositorioRevision.class);
        Mockito.when(repositorioRevision.buscarxId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarRevision servicioActualizarRevision = new ServicioActualizarRevision(repositorioRevision);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarRevision.actualizarRevision(revision), ExcepcionDuplicidad.class,"La revision si existe");
    }
}
