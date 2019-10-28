package de.cat.rest.appcat.cat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CatService service;

    @Test
    public void findAll() throws Exception {

        when(service.findAll("")).thenReturn(createCatsMock());

        mockMvc.perform(get("/api/cats")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    public void findOne() throws Exception {

        Cat mock = new Cat("xyz", "red");
        when(service.findById(1L)).thenReturn(mock);

        mockMvc.perform(get("/api/cats/1"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("xyz")));


    }

    private List<Cat> createCatsMock() {
        Cat cat = new Cat("Mieze", "blau");
        cat.setId(1L);
        Cat cat1 = new Cat("Catboy", "grün");
        cat1.setId(2L);

        List<Cat> cats = new ArrayList<>();
        cats.add(cat);
        cats.add(cat1);
        return cats;
    }


    @Test
    public void update() throws Exception {
        Cat cat = new Cat("Tom", "grau");
        cat.setId(1L);

        when(service.save(same(cat))).thenReturn(cat);

        mockMvc.perform(put("/api/cats/{id}", cat.getId()).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(cat))).andExpect(status().isNoContent());
    }

    @Test
    public void updateWithBadRequest() throws Exception {
        Cat cat = new Cat("Tom", "grau");
        cat.setId(1L);

        when(service.save(same(cat))).thenReturn(cat);

        mockMvc.perform(put("/api/cats/2", cat.getId()).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(cat))).andExpect(status().isBadRequest());
    }


}