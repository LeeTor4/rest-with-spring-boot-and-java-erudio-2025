package br.com.erudio.services;

import br.com.erudio.data.dto.v1.PersonDTO;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.exception.ResourceNotFoundException;
import static  br.com.erudio.mapper.ObjectMapper.parseListObjects;
import static  br.com.erudio.mapper.ObjectMapper.parseObject;

import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper converter;

    public List<PersonDTO> findALl(){
        logger.info("FindAll Person!");
        return parseListObjects(repository.findAll(),PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID!"));

        return  parseObject(entity,PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO){

        logger.info("Create one Person!");

        var entity = parseObject(personDTO,Person.class);

        return parseObject(repository.save(entity),PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 personDTOV2){

        logger.info("Create one Person V2!");

        var entity = converter.convertDTOtoEntity(personDTOV2);

        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO personDTO) {

        logger.info("Updating one Person!");

       Person entity = repository.findById(personDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID!"));

       entity.setFirstName(personDTO.getFirstName());
       entity.setLastName(personDTO.getLastName());
       entity.setAddress(personDTO.getAddress());
       entity.setGender(personDTO.getGender());

       return parseObject(repository.save(entity),PersonDTO.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ID!"));

        repository.delete(entity);
    }


}
