package uk.michaelelison.person.service;

import uk.michaelelison.person.dto.PersonMainDTO;
import uk.michaelelison.person.dto.SeniorPersonDTO;
import uk.michaelelison.person.dto.YoungerPersonDTO;
import uk.michaelelison.person.model.Person;

import java.util.List;

public interface PersonService {

    // create
    PersonMainDTO createPerson(PersonMainDTO personMainDTO);

    SeniorPersonDTO saveSeniorPerson (SeniorPersonDTO seniorPersonDTO);
    YoungerPersonDTO saveYoungerPerson (YoungerPersonDTO youngerPersonDTO);



    List<SeniorPersonDTO> getAllSeniorPeople();
    List<YoungerPersonDTO> getAllYoungerPeople();
    List<Person> getAllPeople();



    Person getPersonById (Long id);



    SeniorPersonDTO updateSeniorPerson(SeniorPersonDTO seniorPersonDTO, Long id);
    YoungerPersonDTO updateYoungerPerson(YoungerPersonDTO youngerPersonDTO, Long id);



    void deletePersonById(Long id);
}
