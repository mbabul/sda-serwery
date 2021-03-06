package io.mbab.sda.serwery.cities;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
@Slf4j
public class CityController {

    private CityRepository repo;

    @GetMapping
    HttpEntity<List<City>> getAll() {
        return ResponseEntity.ok(repo.getAll());
    }

    @GetMapping("/{id}")
    HttpEntity<City> findById(@PathVariable long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/exception")
    HttpEntity<Void> test() {
        try {
            repo.test();
        } catch (RuntimeException e) {
            log.error("Example error", e);
        }
        return ResponseEntity.noContent().build();
    }
}
