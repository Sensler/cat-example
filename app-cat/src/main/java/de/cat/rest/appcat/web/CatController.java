package de.cat.rest.appcat.web;

import de.cat.rest.appcat.domain.Cat;
import de.cat.rest.appcat.service.CatService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cats")
public class CatController {

    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false, defaultValue = "") String name){
        return ResponseEntity.ok(service.findAll(name));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cat cat){
        if(id == null || !id.equals(cat.getId())){
            return ResponseEntity.badRequest().body("Resource path and id mismatch");
        }
        service.save(cat);
        return ResponseEntity.noContent().build();
    }
}
