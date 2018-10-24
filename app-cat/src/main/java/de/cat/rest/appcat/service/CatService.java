package de.cat.rest.appcat.service;

import de.cat.rest.appcat.domain.Cat;
import de.cat.rest.appcat.domain.CatNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CatService {

    private Logger logger = LoggerFactory.getLogger(CatService.class);

    private CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        repository.save(new Cat("Mauzi", "braun"));
        repository.save(new Cat("Snobilikat", "bunt"));
        repository.save(new Cat("Flamiau", "weiß"));

        logger.info("********** findAll **********");
        repository.findAll().forEach(cat -> logger.info(cat.toString()));

        logger.info("********** findById(1l) **********");
        logger.info(repository.findById(1L).get().toString());

        logger.info("********** findByName(\"Mauzi\") **********");
        repository.findByName("Mauzi").forEach(cat -> logger.info(cat.toString()));

        logger.info("********** findByNameAndColor(\"Flamiau\", \"weiß\") **********");
        repository.findByNameAndColor("Flamiau", "weiß").forEach(cat -> logger.info(cat.toString()));

        logger.info("********** findByNameContains(\"l\") **********");
        repository.findByNameContains("l").forEach(cat -> logger.info(cat.toString()));

    }

    public List<Cat> findAll() {
        return repository.findAll();
    }

    public Cat save(Cat entity) {
        return repository.save(entity);
    }

    public Cat findById(Long id) throws CatNotFoundException {
        return repository.findById(id).orElseThrow(() -> new CatNotFoundException("Cat with id= " + id + " not found."));
    }

}
