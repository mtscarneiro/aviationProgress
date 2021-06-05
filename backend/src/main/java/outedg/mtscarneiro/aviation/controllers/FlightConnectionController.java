package outedg.mtscarneiro.aviation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import outedg.mtscarneiro.aviation.domain.FlightConnection;
import outedg.mtscarneiro.aviation.services.FlightConnectionService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/connections")
public class FlightConnectionController {

    @Autowired
    private FlightConnectionService flightConnectionService;

    @GetMapping
    public ResponseEntity<List<FlightConnection>> findAll() {
        List<FlightConnection> list = flightConnectionService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FlightConnection> findById(@PathVariable Long id) {
        FlightConnection obj = flightConnectionService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<FlightConnection> insert(@RequestBody FlightConnection obj) {
        obj = flightConnectionService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FlightConnection> delete(@PathVariable Long id) {
        flightConnectionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FlightConnection> update(@PathVariable Long id, @RequestBody FlightConnection obj) {
        obj = flightConnectionService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
