package com.ceiba.revision.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.revision.comando.ComandoRevision;
import com.ceiba.revision.servicio.testdatabuilder.ComandoRevisionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorRevision.class)
public class ComandoControladorRevisionTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void guardar() throws Exception{
        ComandoRevision revision = new ComandoRevisionTestDataBuilder().build();
        mocMvc.perform(post("/revisiones/guardarRevision")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(revision)))
                        .andExpect(status().isOk())
                        .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        Long idRevision=1L;
        ComandoRevision revision = new ComandoRevisionTestDataBuilder().build();
        mocMvc.perform(delete("/revision/{id}",idRevision)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
}
