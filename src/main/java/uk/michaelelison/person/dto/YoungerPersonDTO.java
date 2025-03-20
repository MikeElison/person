package uk.michaelelison.person.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class YoungerPersonDTO {

    private Long id;

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    private String lastName;

    @NotNull(message = "Age cannot be blank")
    private Integer age;

    @NotNull(message = "Age group should be shown")
    private Boolean ageGroup;

    private String phoneNumber;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

}
