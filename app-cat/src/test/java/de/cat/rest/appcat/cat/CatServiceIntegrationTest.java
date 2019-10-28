package de.cat.rest.appcat.cat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CatServiceIntegrationTest {

    @Autowired
    private CatService service;

    @Test
    public void findAll() {
        assertThat(service.findAll("").size(), is(3));
    }

    @Test
    public void findById() {
        Cat cat = service.findById(1L);
        assertThat(cat.getId(), is(1L));
        assertThat(cat.getName(), is("Mauzi"));
        assertThat(cat.getColor(), is("brown"));
    }

    @Test(expected = CatNotFoundException.class)
    public void findByIdWithException() {
        service.findById(22L);
    }
}