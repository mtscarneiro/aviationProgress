package outedg.mtscarneiro.aviation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import outedg.mtscarneiro.aviation.domain.Client;
import outedg.mtscarneiro.aviation.repositories.ClientRepository;
import outedg.mtscarneiro.aviation.services.exceptions.DatabaseException;
import outedg.mtscarneiro.aviation.services.exceptions.ResourceNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Client insert(Client obj) {
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

    private void updateData(Client entity, Client obj) {
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
        entity.setEmail(obj.getEmail());
        entity.setFlight(obj.getFlight());
    }

    public Client update(Long id, Client obj) {
        try {
            Client entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
