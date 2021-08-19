package com.ceiba.revision.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.revision.comando.ComandoRevision;
import com.ceiba.revision.comando.manejador.ManejadorActualizarRevision;
import com.ceiba.revision.comando.manejador.ManejadorGuardarRevision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revisiones")
public class ComandoControladorRevision {
    private final ManejadorGuardarRevision manejadorGuardarRevision;
    private final ManejadorActualizarRevision manejadorActualizarRevision;

    @Autowired
    public ComandoControladorRevision(ManejadorGuardarRevision manejadorGuardarRevision, ManejadorActualizarRevision manejadorActualizarRevision){
        this.manejadorGuardarRevision = manejadorGuardarRevision;
        this.manejadorActualizarRevision = manejadorActualizarRevision;
    }

    @PostMapping("/guardarRevision")
    public ComandoRespuesta<Long> guardar(@RequestBody ComandoRevision comandoRevision){
        return manejadorGuardarRevision.ejecutar(comandoRevision);
    }

    @PutMapping(value="/actualizarRevision/{idRevision}")
    public void actualizar(@RequestBody ComandoRevision comandoRevision, @PathVariable Long idRevision){
        comandoRevision.setIdRevision(idRevision);
        manejadorActualizarRevision.ejecutar(comandoRevision);
    }
}
