package uk.michaelelison.person.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonMainDTO {

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 1, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$", message = "Phone number must be in E.164 format (e.g., +447...)" )
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    private String address;

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
