package de.cat.rest.appcat.cat;

import de.cat.rest.appcat.cat.Cat;
import de.cat.rest.appcat.cat.CatService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false, defaultValue = "") String name){
        return ResponseEntity.ok(service.findAll(name));
    }

    @GetMapping("/{id}") // /api/cats/123
    public ResponseEntity<Cat> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cat> create(@RequestBody Cat cat) {
        Cat save = service.save(cat);
        return ResponseEntity.created(ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(save.getId())
            .toUri())
            .body(save);

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
