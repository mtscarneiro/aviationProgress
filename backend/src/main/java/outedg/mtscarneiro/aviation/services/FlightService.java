package outedg.mtscarneiro.aviation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import outedg.mtscarneiro.aviation.domain.Client;
import outedg.mtscarneiro.aviation.domain.Flight;
import outedg.mtscarneiro.aviation.repositories.ClientRepository;
import outedg.mtscarneiro.aviation.repositories.FlightRepository;
import outedg.mtscarneiro.aviation.services.exceptions.DatabaseException;
import outedg.mtscarneiro.aviation.services.exceptions.ResourceNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public List<Flight> findAll() {
        return repository.findAll();
    }

    public Flight findById(Long id) {
        Optional<Flight> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Flight insert(Flight obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Flight entity, Flight obj) {
        entity.setConnection(obj.getConnection());
        entity.setDestination(obj.getDestination());
        entity.setDate(obj.getDate());
    }

    public Flight update(Long id, Flight obj) {
        try {
            Flight entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } 
    }
}
