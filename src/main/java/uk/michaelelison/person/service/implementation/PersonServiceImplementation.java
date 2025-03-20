package uk.michaelelison.person.service.implementation;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.michaelelison.person.dto.SeniorPersonDTO;
import uk.michaelelison.person.dto.YoungerPersonDTO;
import uk.michaelelison.person.exception.ResourceNotFoundException;
import uk.michaelelison.person.model.Person;
import uk.michaelelison.person.repository.PersonRepository;
import uk.michaelelison.person.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImplementation implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImplementation.class);

    @Autowired
    public PersonServiceImplementation(final PersonRepository personRepository, final ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    // Creating new people

    @Override
    public SeniorPersonDTO saveSeniorPerson(SeniorPersonDTO seniorPersonDTO) {

        logger.info("Creating a new senior person: {}", seniorPersonDTO);

        Person person = modelMapper.map(seniorPersonDTO, Person.class);
        Person savedPerson = personRepository.save(person);

        logger.info("Saved person {}", savedPerson);

        SeniorPersonDTO savedSeniorPersonDTO = modelMapper.map(savedPerson, SeniorPersonDTO.class);

        logger.info("Created senior person: {}", savedSeniorPersonDTO);

        return savedSeniorPersonDTO;
    }

    @Override
    public YoungerPersonDTO saveYoungerPerson(YoungerPersonDTO youngerPersonDTO) {

        logger.info("Creating a new younger person: {}", youngerPersonDTO);

        Person person = modelMapper.map(youngerPersonDTO, Person.class);
        Person savedPerson = personRepository.save(person);

        logger.info("Saved person: {}", savedPerson);

        YoungerPersonDTO savedYoungPersonDTO = modelMapper.map(savedPerson, YoungerPersonDTO.class);

        logger.info("Created younger person: {}", savedYoungPersonDTO);


        return savedYoungPersonDTO;
    }


    // Get people

    @Override
    public List<SeniorPersonDTO> getAllSeniorPeople() {
        return personRepository.findAll().stream().filter(a -> a.getAgeGroup()).map(a -> modelMapper.map(a, SeniorPersonDTO.class)).toList();
    }

    @Override
    public List<YoungerPersonDTO> getAllYoungerPeople() {
        return personRepository.findAll().stream().filter(a -> !a.getAgeGroup()).map(a -> modelMapper.map(a, YoungerPersonDTO.class)).toList();
    }

    @Override
    public List<Person> getAllPeople() {

        return personRepository.findAll().stream().map(a -> modelMapper.map(a, Person.class)).toList();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).stream().map(a -> modelMapper.map(a, Person.class)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id));
    }


    // Update people

    @Override
    public SeniorPersonDTO updateSeniorPerson(SeniorPersonDTO seniorPersonDTO, Long id) {

        Person existingPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id));

        if (!existingPerson.getAgeGroup()) {
            throw new ResourceNotFoundException("Senior person", "Id", id);
        }
        Person existingSeniorPerson = existingPerson;


        modelMapper.map(seniorPersonDTO, existingSeniorPerson);

        personRepository.save(existingSeniorPerson);
        SeniorPersonDTO savedSeniorPersonDTO = modelMapper.map(existingSeniorPerson, SeniorPersonDTO.class);

        return savedSeniorPersonDTO;
    }

    @Override
    public YoungerPersonDTO updateYoungerPerson(YoungerPersonDTO youngerPersonDTO, Long id) {

        Person existingPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id));

        if (existingPerson.getAgeGroup()) {
            throw new ResourceNotFoundException("Senior person", "Id", id);
        }
        Person existingYoungerPerson = existingPerson;


        modelMapper.map(youngerPersonDTO, existingYoungerPerson);

        personRepository.save(existingYoungerPerson);
        YoungerPersonDTO savedYoungerPerson = modelMapper.map(existingYoungerPerson, YoungerPersonDTO.class);

        return savedYoungerPerson;
    }


    // Delete people

    @Override
    public void deletePersonById(Long id) {

        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id));
        personRepository.deleteById(id);
    }
}
