package uk.michaelelison.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.michaelelison.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
