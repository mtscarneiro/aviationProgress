package outedg.mtscarneiro.aviation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import outedg.mtscarneiro.aviation.domain.Flight;
import outedg.mtscarneiro.aviation.services.FlightService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> findAll() {
        List<Flight> list = flightService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> findById(@PathVariable Long id) {
        Flight obj = flightService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Flight> insert(@RequestBody Flight obj) {
        obj = flightService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Flight> delete(@PathVariable Long id) {
        flightService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Flight> update(@PathVariable Long id, @RequestBody Flight obj) {
        obj = flightService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
