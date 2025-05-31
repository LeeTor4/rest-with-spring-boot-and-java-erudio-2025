package br.com.erudio.controllers;

import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE ,
                            MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_YAML_VALUE}
    )
    public List<PersonDTO> findAll() {
        return services.findALl();
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE ,
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_YAML_VALUE}
    )
    public PersonDTO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE ,
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE ,
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_YAML_VALUE}
    )
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return services.create(personDTO);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE ,
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_YAML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE ,
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_YAML_VALUE}
    )
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return services.update(personDTO);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

}
