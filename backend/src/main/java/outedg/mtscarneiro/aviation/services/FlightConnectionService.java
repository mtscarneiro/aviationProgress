package outedg.mtscarneiro.aviation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import outedg.mtscarneiro.aviation.domain.FlightConnection;
import outedg.mtscarneiro.aviation.repositories.FlightConnectionRepository;
import outedg.mtscarneiro.aviation.services.exceptions.DatabaseException;
import outedg.mtscarneiro.aviation.services.exceptions.ResourceNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FlightConnectionService {

    @Autowired
    private FlightConnectionRepository repository;

    public List<FlightConnection> findAll() {
        return repository.findAll();
    }

    public FlightConnection findById(Long id) {
        Optional<FlightConnection> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public FlightConnection insert(FlightConnection obj) {
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

    private void updateData(FlightConnection entity, FlightConnection obj) {
        entity.setConnection(obj.getConnection());
    }

    public FlightConnection update(Long id, FlightConnection obj) {
        try {
            FlightConnection entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } 
    }
}
