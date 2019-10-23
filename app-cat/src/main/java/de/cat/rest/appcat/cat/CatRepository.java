package de.cat.rest.appcat.cat;

import de.cat.rest.appcat.cat.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    List<Cat> findByName(String name);

    List<Cat> findByNameContains(String name);

    List<Cat> findByColor(String color);

    List<Cat> findByNameAndColor(String name, String color);
}
