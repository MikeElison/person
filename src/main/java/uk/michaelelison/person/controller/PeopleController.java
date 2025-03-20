package uk.michaelelison.person.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.michaelelison.person.dto.SeniorPersonDTO;
import uk.michaelelison.person.dto.YoungerPersonDTO;
import uk.michaelelison.person.model.Person;
import uk.michaelelison.person.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/people/v1")
public class PeopleController {

    public static final Logger logger = LoggerFactory.getLogger(PeopleController.class);

    private final PersonService personService;

    public PeopleController(final PersonService personService) {
        this.personService = personService;
    }

    // Creating new people

    @PostMapping("/senior")
    public ResponseEntity<SeniorPersonDTO> createSeniorPerson(@Valid @RequestBody SeniorPersonDTO seniorPersonDTO) {

        logger.info("Received SeniorPersonDTO: {}", seniorPersonDTO);
        SeniorPersonDTO createdSeniorPerson = personService.saveSeniorPerson(seniorPersonDTO);

        return new ResponseEntity<>(createdSeniorPerson, HttpStatus.CREATED);
    }

    @PostMapping("/younger")
    public ResponseEntity<YoungerPersonDTO> createYoungerPerson(@Valid @RequestBody YoungerPersonDTO youngerPersonDTO) {

        logger.info("Received YoungerPersonDTO: {}", youngerPersonDTO);
        YoungerPersonDTO  createdYoungerPerson = personService.saveYoungerPerson(youngerPersonDTO);

        return new ResponseEntity<>(createdYoungerPerson, HttpStatus.CREATED);
    }



    // Get people

    @GetMapping("/senior")
    public List<SeniorPersonDTO> getAllSeniorPeople() {
        return personService.getAllSeniorPeople();
    }

    @GetMapping("/younger")
    public List<YoungerPersonDTO> getAllYoungerPeople() {
        return personService.getAllYoungerPeople();
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }


    // Update people

    @PutMapping("/senior/{seniorId}")
    public ResponseEntity<SeniorPersonDTO> updateSeniorPerson(@Valid @RequestBody SeniorPersonDTO seniorPersonDTO, @PathVariable("seniorId") Long id) {

        SeniorPersonDTO updatedSeniorPerson = personService.updateSeniorPerson(seniorPersonDTO, id);
        return new ResponseEntity<>(updatedSeniorPerson, HttpStatus.OK);
    }

    @PutMapping("/younger/{youngerId}")
    public ResponseEntity<YoungerPersonDTO> updateYoungerPerson(@Valid @RequestBody YoungerPersonDTO youngerPersonDTO, @PathVariable("youngerId") Long id) {

        YoungerPersonDTO updatedYoungerPerson = personService.updateYoungerPerson(youngerPersonDTO, id);
        return new ResponseEntity<>(updatedYoungerPerson, HttpStatus.OK);
    }


    // Delete people

    @DeleteMapping("{peopleId}")
    public ResponseEntity<String> deletePersonById(@PathVariable("peopleId") Long id) {
        personService.deletePersonById(id);
        return new ResponseEntity<>("The person deleted successfully", HttpStatus.OK);
    }

}
