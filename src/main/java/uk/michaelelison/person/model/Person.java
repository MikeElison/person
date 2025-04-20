package uk.michaelelison.person.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Index;

import java.time.LocalDate;

@Data
@Entity
@Table(name="people")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    @Index(name = "idx_last_name")
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "interests")
    private String interests;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "email", nullable = false)
    @org.hibernate.annotations.Index(name = "idx_email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "comments")
    private String comment;


//

    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "age_group", nullable = false)
    private Boolean ageGroup;


}
