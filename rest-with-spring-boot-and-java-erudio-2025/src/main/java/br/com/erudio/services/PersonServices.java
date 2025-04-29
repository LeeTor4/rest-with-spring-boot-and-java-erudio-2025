package br.com.erudio.services;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findALl(){
        logger.info("FindAll Person!");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID!"));
    }

    public Person create(Person person){

        logger.info("Create one Person!");
        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");

       Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID!"));

       entity.setFirstName(person.getFirstName());
       entity.setLastName(person.getLastName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID!"));

        repository.delete(entity);
    }


}
