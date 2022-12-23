package com.cs491.languageapp.entity.request;

import com.cs491.languageapp.core.validator.ValidPassword;
import com.cs491.languageapp.core.validator.create.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@PasswordMatches
public class CreateOccupantRequest {

    @NotBlank
    private String name;
    @NotBlank
    @Email(regexp = ".+@.+\\..+")
    private String email;

    @ValidPassword
    @NotBlank
    private String password;

    @NotBlank
    private String matchingPassword;
}
