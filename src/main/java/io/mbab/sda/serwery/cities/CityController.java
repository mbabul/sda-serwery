package io.mbab.sda.serwery.cities;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private CityRepository repo;

    @GetMapping
    List<City> getAll() {
        return repo.getAll();
    }

    @GetMapping("/{id}")
    City getOne(@PathVariable long id) {
        return repo.getOne(id);
    }
}
