package uk.michaelelison.person.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonAttributesDTO {

    @NotNull(message = "Date of birth is required")
    @PastOrPresent(message = "Date of birth must be in the past or today")
    private LocalDate dateOfBirth;

    @Size(min = 1, max = 255, message = "Occupation must be between 2 and 255 characters")
    private String occupation;

    @Size(min = 1, max = 255, message = "Interests must be between 2 and 255 characters")
    private String interests;

    @Size(min = 1, max = 255, message = "Hobbies must be between 2 and 255 characters")
    private String hobbies;

    @Size(min = 1, max = 255, message = "Comment must be between 2 and 255 characters")
    private String comment;
}
