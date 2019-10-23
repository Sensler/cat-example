package de.cat.rest.appcat.cat;

import de.cat.rest.appcat.cat.Cat;
import de.cat.rest.appcat.cat.CatNotFoundException;
import de.cat.rest.appcat.cat.CatRepository;
import de.cat.rest.appcat.cat.CatService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatServiceUnitTest {

    private CatRepository repository = mock(CatRepository.class);

    private CatService service = new CatService(repository);

    @Test
    public void findAll() {
        List<Cat> cats = createMockCats();
        when(repository.findAll()).thenReturn(cats);

        assertThat(service.findAll("").size(), is(2));
    }

    private List<Cat> createMockCats() {
        Cat cat = new Cat("Kitty", "weiß");
        cat.setId(1L);
        Cat cat1 = new Cat("Mausi", "schwarz");
        cat.setId(2L);

        List<Cat> cats = new ArrayList<>();
        cats.add(cat);
        cats.add(cat1);
        return cats;
    }

    @Test(expected = CatNotFoundException.class)
    public void findById() throws CatNotFoundException {
        long id = 23L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        service.findById(id);
    }
}