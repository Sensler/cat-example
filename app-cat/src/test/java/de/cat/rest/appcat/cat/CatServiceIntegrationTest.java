package de.cat.rest.appcat.cat;

import de.cat.rest.appcat.cat.Cat;
import de.cat.rest.appcat.cat.CatNotFoundException;
import de.cat.rest.appcat.cat.CatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatServiceIntegrationTest {

    @Autowired
    private CatService service;

    @Test
    public void findAll(){
        assertThat(service.findAll("").size(), is(3));
    }

    @Test
    public void findById() throws CatNotFoundException {
        Cat cat = service.findById(1L);
        assertThat(cat.getId() , is(1L) );
        assertThat(cat.getName() , is("Mauzi") );
        assertThat(cat.getColor() , is("braun") );
    }

    @Test(expected = CatNotFoundException.class)
    public void findByIdWithException() throws CatNotFoundException {
        service.findById(22L);
    }
}